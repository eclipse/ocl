/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotTables;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * A TemplateParameterSubstitutionVisitor traverses a CallExp to identify the formal/actual TemplateParameterSubstitutions
 * associated with that CallExp. This creates a mapping from each formal template parameter to a list of actual types that
 * correspond. This mapping can then be used to crteate new specializations.
 * <p>
 * The visitor should be constructed with a MetaModelManager in case any synthetic types need contructing, and the identity
 * of the self type incase one of the substitutions uses OclSelf.
 */
public class TemplateParameterSubstitutionVisitor extends AbstractExtendingVisitor<Object, Map<TemplateParameter, List<DomainType>>>
{
	private final MetaModelManager metaModelManager;
	private final Type selfType;
//	private Map<TemplateParameter, List<DomainType>> reverseMapping = null;
	private Map<Integer, List<TemplateParameter>> indexedTemplateParameters = null;
	private DomainType actual;
	
	public TemplateParameterSubstitutionVisitor(MetaModelManager metaModelManager, Type selfType) {
		super(new HashMap<TemplateParameter, List<DomainType>>());
		this.metaModelManager = metaModelManager;
		this.selfType = selfType;
	}

	public @Nullable DomainType specialize(@Nullable TemplateParameter templateParameter) {
		if (templateParameter == null) {
			return null;
		}
		List<DomainType> list = context.get(templateParameter);
		if (list == null) {
			return null;
		}
		int iMax = list.size();
		if (iMax < 1) {
			return null;
		}
		if (iMax == 1) {
			return list.get(0);
		}
		DomainType bestType = list.get(0);
		if (iMax > 1) {
			IdResolver idResolver = null;
			if (metaModelManager != null) {
				idResolver = metaModelManager.getIdResolver();
			}
			if (idResolver == null) {
				DomainEvaluator evaluator = new EcoreExecutorManager(templateParameter, PivotTables.LIBRARY);		// FIXME me get from caller
				idResolver = evaluator.getIdResolver();
			}
			for (int i = 1; i < iMax; i++) {
				@SuppressWarnings("null")@NonNull DomainType anotherType = list.get(i);
				DomainType commonType = bestType.getCommonType(idResolver, anotherType);
				bestType = commonType;
				if (metaModelManager != null) {
					bestType = metaModelManager.getType(bestType);
				}
			}
		}
		return bestType;
	}

	public @NonNull DomainType specialize(@NonNull TemplateableElement templateableElement) {
		Map<TemplateParameter, ParameterableElement> usageBindings = new HashMap<TemplateParameter, ParameterableElement>();
		for (TemplateParameter templateParameter : context.keySet()) {
			DomainType specialize = specialize(templateParameter);
			if (specialize != null) {
				Type specialized = metaModelManager.getType(specialize);
				usageBindings.put(templateParameter, specialized);
			}
		}
		return metaModelManager.getSpecializedType((Type) templateableElement, usageBindings);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;
		for (TemplateParameter templateParameter : context.keySet()) {
			if (!isFirst) {
				s.append("\n");
			}
			s.append(templateParameter + " => " + context.get(templateParameter));
			isFirst = false;
		}
		if (indexedTemplateParameters != null) {
			for (Integer index : indexedTemplateParameters.keySet()) {
				s.append("\n");
				s.append(index + " => " + indexedTemplateParameters.get(index));
			}
		}
		return s.toString();
	}
	
	protected void visit(@Nullable TypedElement formalElement, @Nullable DomainTypedElement actualElement) {
		if ((formalElement != null) && (actualElement != null)) {
			Type formalType = formalElement.getType();
			DomainType actualType = actualElement.getType();
			visit(formalType, actualType);
		}
	}
	
	protected void visit(@Nullable Type formalType, @Nullable DomainTypedElement actualElement) {
		if (actualElement != null) {
			DomainType actualType = actualElement.getType();
			visit(formalType, actualType);
		}
	}

	protected void visit(@Nullable Type newFormal, @Nullable DomainType newActual) {
		if ((newFormal != null) && (newActual != null)) {
/*			if (newActual instanceof EObject) {
				EObject newContainer = ((EObject)newActual).eContainer();
				if (newContainer instanceof TemplateParameter) {
					TemplateParameter newTemplateParameter = (TemplateParameter)newContainer;
					if (reverseMapping == null) {
						reverseMapping = new HashMap<TemplateParameter, List<DomainType>>();
					}
					List<DomainType> actualList = reverseMapping.get(newTemplateParameter);
					if (actualList == null) {
						actualList = new ArrayList<DomainType>();
						reverseMapping.put(newTemplateParameter, actualList);
					}
					if (!actualList.contains(newFormal)) {
						actualList.add(newFormal);
					}
				}
			} */
			DomainType oldActual = actual;
			try {
				actual = newActual;
				newFormal.accept(this);
			} finally {
				actual = oldActual;
			}
		}
	}

	protected void visitAllTypes(@NonNull List<? extends Type> formalElements, @NonNull List<? extends DomainType> actualElements) {
		int iMax = Math.min(formalElements.size(), actualElements.size());
		for (int i = 0; i < iMax; i++) {
			visit(formalElements.get(i), actualElements.get(i));
		}
	}

	protected void visitAllTypedElements(@NonNull List<? extends TypedElement> formalElements, @Nullable List<? extends DomainTypedElement> actualElements) {
		if (actualElements != null) {
			int iMax = Math.min(formalElements.size(), actualElements.size());
			for (int i = 0; i < iMax; i++) {
				TypedElement formalElement = formalElements.get(i);
				DomainTypedElement actualElement = actualElements.get(i);
				visit(formalElement, actualElement);
			}
		}
	}
	
	public String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		TemplateParameter owningTemplateParameter = object.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			owningTemplateParameter.accept(this);
			return null;
		}
		else {
			return super.visitClass(object);
		}
	}

	@Override
	public @Nullable Object visitCollectionType(@NonNull CollectionType object) {
		if (actual instanceof CollectionType) {
			Type formalElementType = object.getElementType();
			Type actualElementType = ((CollectionType)actual).getElementType();
			visit(formalElementType, actualElementType);
		}
		return null;
	}

	@Override
	public @Nullable Object visitIterateExp(@NonNull IterateExp object) {
		Iteration referredIteration = object.getReferredIteration();
		visit(referredIteration, object);
		visit(referredIteration.getOwningType(), object.getSource());
		visitAllTypedElements(referredIteration.getOwnedIterator(), object.getIterator());
		visitAllTypedElements(referredIteration.getOwnedAccumulator(), Collections.singletonList(object.getResult()));
		visitAllTypedElements(referredIteration.getOwnedParameter(), Collections.singletonList(object.getBody()));
		return null;
	}

	@Override
	public @Nullable Object visitIteratorExp(@NonNull IteratorExp object) {
		Iteration referredIteration = object.getReferredIteration();
		visit(referredIteration, object);
		visit(referredIteration.getOwningType(), object.getSource());
		visitAllTypedElements(referredIteration.getOwnedIterator(), object.getIterator());
		visitAllTypedElements(referredIteration.getOwnedParameter(), Collections.singletonList(object.getBody()));
		return null;
	}

	@Override
	public @Nullable Object visitLambdaType(@NonNull LambdaType object) {
		if (actual instanceof LambdaType) {
			LambdaType actualLambdaType = (LambdaType)actual;
			visit(object.getContextType(), actualLambdaType.getContextType());
			visit(object.getResultType(), actualLambdaType.getResultType());
			visitAllTypes(object.getParameterType(), actualLambdaType.getParameterType());
		}
		return null;
	}

	@Override
	public @Nullable Object visitMetaclass(@NonNull Metaclass<?> object) {
		if (actual instanceof Metaclass<?>) {
			Type formalElementType = object.getInstanceType();
			Type actualElementType = ((Metaclass<?>)actual).getInstanceType();
			visit(formalElementType, actualElementType);
		}
		return null;
	}

	@Override
	public @Nullable Object visitOperationCallExp(@NonNull OperationCallExp object) {
		Operation referredOperation = object.getReferredOperation();
		visit(referredOperation, object);
		visit(referredOperation.getOwningType(), object.getSource());
		visitAllTypedElements(referredOperation.getOwnedParameter(), object.getArgument());
		return null;
	}

	@Override
	public @Nullable Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		Property referredOppositeProperty = object.getReferredProperty();
		if (referredOppositeProperty != null) {
			Property referredProperty = referredOppositeProperty.getOpposite();
			if (referredProperty != null) {
				visit(referredProperty, object);
				visit(referredProperty.getOwningType(), object.getSource());
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitPrimitiveType(@NonNull PrimitiveType object) {
		return null;
	}

	@Override
	public @Nullable Object visitPropertyCallExp(@NonNull PropertyCallExp object) {
		Property referredProperty = object.getReferredProperty();
		if (referredProperty != null) {
			visit(referredProperty, object);
			visit(referredProperty.getOwningType(), object.getSource());
		}
		return null;
	}

	@Override
	public @Nullable Object visitSelfType(@NonNull SelfType object) {
		visit(selfType, actual);
		return null;
	}

	@Override
	public @Nullable Object visitTemplateParameter(@NonNull TemplateParameter object) {
		TemplateParameterId elementId = object.getElementId();
		List<DomainType> actualList = context.get(object);
		if (actualList == null) {
			actualList = new ArrayList<DomainType>();
			context.put(object, actualList);
		}
		if (!actualList.contains(actual)) {
			actualList.add(actual);
		}
		if (indexedTemplateParameters == null) {
			indexedTemplateParameters = new HashMap<Integer, List<TemplateParameter>>();
		}
		int index = elementId.getIndex();
		List<TemplateParameter> indexList = indexedTemplateParameters.get(index);
		if (indexList == null) {
			indexList = new ArrayList<TemplateParameter>();
			indexedTemplateParameters.put(index, indexList);
		}
		if (!indexList.contains(object)) {
			indexList.add(object);
		}
		return null;
	}

	@Override
	public @Nullable Object visitTupleType(@NonNull TupleType object) {
		if (actual instanceof TupleType) {
			visitAllTypedElements(object.getOwnedAttribute(), ((TupleType)actual).getOwnedAttribute());
		}
		return null;
	}

	@Override
	public @Nullable Object visitType(@NonNull Type object) {
		for (TemplateBinding templateBinding : object.getTemplateBinding()) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitution()) {
				safeVisit(templateParameterSubstitution.getActual());
			}
		}
		return null;
	}
}

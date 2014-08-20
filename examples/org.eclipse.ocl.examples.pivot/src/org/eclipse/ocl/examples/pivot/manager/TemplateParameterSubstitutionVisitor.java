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
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * A TemplateParameterSubstitutionVisitor traverses a CallExp to identify the formal/actual TemplateParameterSubstitutions
 * associated with that CallExp. This creates a mapping from each formal template parameter to a list of actual types that
 * correspond. This mapping can then be used to create new specializations.
 * <p>
 * The visitor should be constructed with a MetaModelManager in case any synthetic types need contructing, and the identity
 * of the self type incase one of the substitutions uses OclSelf.
 */
public class TemplateParameterSubstitutionVisitor extends AbstractExtendingVisitor<Object, Map<TemplateParameter, List<DomainType>>>
{
	private final @NonNull MetaModelManager metaModelManager;
	private final @NonNull Type selfType;
//	private Map<TemplateParameter, List<DomainType>> reverseMapping = null;
	private Map<Integer, List<TemplateParameter>> indexedTemplateParameters = null;
	private DomainType actual;

	protected final @NonNull Map<TemplateParameter, org.eclipse.ocl.examples.pivot.Type> templateParameter2type =
			new HashMap<TemplateParameter, org.eclipse.ocl.examples.pivot.Type>();
	protected final @NonNull Map<TemplateParameterSubstitution, org.eclipse.ocl.examples.pivot.Type> templateParameterSubstitution2type =
			new HashMap<TemplateParameterSubstitution, org.eclipse.ocl.examples.pivot.Type>();
	
	public TemplateParameterSubstitutionVisitor(@NonNull MetaModelManager metaModelManager, @NonNull Type selfType) {
		super(new HashMap<TemplateParameter, List<DomainType>>());
		this.metaModelManager = metaModelManager;
		this.selfType = selfType;
	}
	
	protected void analyzeFeature(@Nullable Feature formalFeature, @Nullable DomainTypedElement actualElement) {
		if ((formalFeature != null) && (actualElement != null)) {
			Type formalType = formalFeature.getOwningClass();
			DomainType actualType = actualElement.getType();
			analyzeType(formalType, actualType);
		}
	}

	protected void analyzeType(@Nullable Type newFormal, @Nullable DomainType newActual) {
		if ((newFormal != null) && (newActual != null)) {
			DomainType oldActual = actual;
			try {
				actual = newActual;
				newFormal.accept(this);
			} finally {
				actual = oldActual;
			}
		}
	}
	
	protected void analyzeTypedElement(@Nullable TypedElement formalElement, @Nullable DomainTypedElement actualElement) {
		if ((formalElement != null) && (actualElement != null)) {
			Type formalType = formalElement.getType();
			DomainType actualType = actualElement.getType();
			analyzeType(formalType, actualType);
		}
	}

	protected void analyzeTypedElements(@NonNull List<? extends TypedElement> formalElements, @Nullable List<? extends DomainTypedElement> actualElements) {
		if (actualElements != null) {
			int iMax = Math.min(formalElements.size(), actualElements.size());
			for (int i = 0; i < iMax; i++) {
				TypedElement formalElement = formalElements.get(i);
				DomainTypedElement actualElement = actualElements.get(i);
				analyzeTypedElement(formalElement, actualElement);
			}
		}
	}

	protected void analyzeTypes(@NonNull List<? extends Type> formalElements, @NonNull List<? extends DomainType> actualElements) {
		int iMax = Math.min(formalElements.size(), actualElements.size());
		for (int i = 0; i < iMax; i++) {
			analyzeType(formalElements.get(i), actualElements.get(i));
		}
	}

	public @Nullable Type get(@NonNull TemplateParameterSubstitution templateParameterSubstitution) {
		Type type = templateParameterSubstitution2type.get(templateParameterSubstitution);
		if (type instanceof TemplateParameter) {
			Type type2 = templateParameter2type.get(type);
			if (type2 != null) {
				return type2;
			}
		}
		return type;
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
			IdResolver idResolver = metaModelManager.getIdResolver();
			for (int i = 1; i < iMax; i++) {
				@SuppressWarnings("null")@NonNull DomainType anotherType = list.get(i);
				DomainType commonType = bestType.getCommonType(idResolver, anotherType);
				bestType = metaModelManager.getType(commonType);
			}
		}
		return bestType;
	}

	public @NonNull Type specialize(@NonNull Type templateableElement) {
		Map<TemplateParameter, Type> usageBindings = new HashMap<TemplateParameter, Type>();
		Set<TemplateParameter> keySet = context.keySet();
		Type[] templateBindings = new Type[keySet.size()];
		for (TemplateParameter templateParameter : keySet) {
			DomainType specialize = specialize(templateParameter);
			if (specialize != null) {
				Type specialized = metaModelManager.getType(specialize);
				if (templateParameter != null) {
					usageBindings.put(templateParameter, specialized);
					int index = templateParameter.getTemplateParameterId().getIndex();
					if ((0 <= index) && (index < templateBindings.length)) {
						templateBindings[index] = specialized;
					}
				}
			}
		}
		return metaModelManager.getSpecializedType(templateableElement, selfType, templateBindings);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;
		for (TemplateParameter templateParameter : context.keySet()) {
			if (!isFirst) {
				s.append("\n");
			}
			s.append(templateParameter.getTemplateParameterId() + " : " + templateParameter + " => " + context.get(templateParameter));
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
	
	public String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unsupported " + getClass().getSimpleName() + " " + visitable.getClass().getSimpleName());
	}

	@Override
	public @Nullable Object visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class object) {
		for (TemplateBinding templateBinding : object.getOwnedTemplateBindings()) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getOwnedTemplateParameterSubstitutions()) {
				safeVisit(templateParameterSubstitution.getActual());
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitCollectionType(@NonNull CollectionType object) {
		if (actual instanceof CollectionType) {
			Type formalElementType = object.getElementType();
			Type actualElementType = ((CollectionType)actual).getElementType();
			analyzeType(formalElementType, actualElementType);
		}
		return null;
	}

	@Override
	public @Nullable Object visitIterateExp(@NonNull IterateExp object) {
		Iteration referredIteration = object.getReferredIteration();
		analyzeTypedElement(referredIteration, object);
		analyzeFeature(referredIteration, object.getSource());
		analyzeTypedElements(referredIteration.getOwnedIterator(), object.getIterator());
		analyzeTypedElements(referredIteration.getOwnedAccumulator(), Collections.singletonList(object.getResult()));
		analyzeTypedElements(referredIteration.getOwnedParameter(), Collections.singletonList(object.getBody()));
		return null;
	}

	@Override
	public @Nullable Object visitIteratorExp(@NonNull IteratorExp object) {
		Iteration referredIteration = object.getReferredIteration();
		analyzeTypedElement(referredIteration, object);
		analyzeFeature(referredIteration, object.getSource());
		analyzeTypedElements(referredIteration.getOwnedIterator(), object.getIterator());
		analyzeTypedElements(referredIteration.getOwnedParameter(), Collections.singletonList(object.getBody()));
		return null;
	}

	@Override
	public @Nullable Object visitLambdaType(@NonNull LambdaType object) {
		if (actual instanceof LambdaType) {
			LambdaType actualLambdaType = (LambdaType)actual;
			analyzeType(object.getContextType(), actualLambdaType.getContextType());
			analyzeType(object.getResultType(), actualLambdaType.getResultType());
			analyzeTypes(object.getParameterType(), actualLambdaType.getParameterType());
		}
		else {
			analyzeType(object.getResultType(), actual);
		}
		return null;
	}

	@Override
	public @Nullable Object visitMetaclass(@NonNull Metaclass<?> object) {
		if (actual instanceof Metaclass<?>) {
			Type formalElementType = object.getInstanceType();
			Type actualElementType = ((Metaclass<?>)actual).getInstanceType();
			analyzeType(formalElementType, actualElementType);
		}
		return null;
	}

	@Override
	public @Nullable Object visitOperationCallExp(@NonNull OperationCallExp object) {
		Operation referredOperation = object.getReferredOperation();
//		visit(referredOperation, object);
		analyzeType(referredOperation.getType(), object.getType());
		analyzeType(referredOperation.getOwningClass(), object.getSource().getType());
		analyzeTypedElements(referredOperation.getOwnedParameter(), object.getArgument());
		return null;
	}

	@Override
	public @Nullable Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		Property referredOppositeProperty = object.getReferredProperty();
		if (referredOppositeProperty != null) {
			Property referredProperty = referredOppositeProperty.getOpposite();
			if (referredProperty != null) {
				analyzeFeature(referredProperty, object.getSource());
				analyzeTypedElement(referredProperty, object);
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
			OCLExpression source = object.getSource();
			if (source != null) {
				Type sourceType = source.getType();
				if (referredProperty.isStatic() && (sourceType instanceof Metaclass<?>)) {
					sourceType = ((Metaclass<?>)sourceType).getInstanceType();
				}
				analyzeType(referredProperty.getOwningClass(), sourceType);
			}
			analyzeTypedElement(referredProperty, object);
		}
		return null;
	}

	@Override
	public @Nullable Object visitSelfType(@NonNull SelfType object) {
		analyzeType(selfType, actual);
		return null;
	}

	@Override
	public @Nullable Object visitTemplateParameter(@NonNull TemplateParameter object) {
		TemplateParameterId elementId = object.getTemplateParameterId();
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
			analyzeTypedElements(object.getOwnedProperties(), ((TupleType)actual).getOwnedProperties());
		}
		return null;
	}
}

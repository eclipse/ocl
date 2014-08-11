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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
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
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * A TemplateParameterSubstitutionVisitor traverses a CallExp to identify the formal/actual TemplateParameterSubstitutions
 * associated with that CallExp. This creates a mapping from each formal template parameter to a list of actual types that
 * correspond. This mapping can then be used to create new specializations.
 * <p>
 * The visitor should be constructed with a MetaModelManager in case any synthetic types need contructing, and the identity
 * of the self type incase one of the substitutions uses OclSelf.
 */
public class TemplateParameterSubstitutionVisitor extends AbstractExtendingVisitor<Object, Map<Integer, Type>> implements TemplateParameterSubstitutions
{	
	public static @NonNull TemplateParameterSubstitutions createBindings(@NonNull MetaModelManager metaModelManager, @NonNull Type formalType, @NonNull Type actualType) {
		TemplateParameterSubstitutionVisitor visitor = createVisitor(actualType, metaModelManager, null, false);
		visitor.analyzeType(formalType, actualType);
		return visitor;
	}
	
	public static @NonNull TemplateParameterSubstitutions createBindings(@NonNull MetaModelManager metaModelManager, @Nullable Type sourceType, boolean sourceIsTypeof, @NonNull Operation candidateOperation) {
		TemplateParameterSubstitutionVisitor visitor = createVisitor(candidateOperation, metaModelManager, sourceType, sourceIsTypeof);
		visitor.analyzeType(candidateOperation.getOwningClass(), sourceType);
		for (EObject eObject = candidateOperation; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				TemplateSignature templateSignature = ((TemplateableElement)eObject).getOwnedTemplateSignature();
				if (templateSignature != null) {
					List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
					int iSize = templateParameters.size();
					if (iSize > 0) {
						return visitor;
					}
				}
			}
		}
		
		return TemplateParameterSubstitutions.EMPTY;
	}

	protected static @NonNull TemplateParameterSubstitutionVisitor createVisitor(@NonNull EObject eObject, @NonNull MetaModelManager metaModelManager, @Nullable Type selfType, boolean selfIsTypeof) {
		Resource resource = eObject.eResource();
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory().createTemplateParameterSubstitutionVisitor(metaModelManager, selfType, selfIsTypeof);
		}
		else {
			return new TemplateParameterSubstitutionVisitor(metaModelManager, selfType, selfIsTypeof);
		}
	}

	/**
	 * Return the specialized form of type analyzing expr to determine the formal to actual parameter mappings under the
	 * supervision of a metaModelManager and using selfType as the value of OclSelf.
	 */
	public static @NonNull Type specializeType(@NonNull Type type, boolean isTypeof, @NonNull CallExp callExp, @NonNull MetaModelManager metaModelManager, @Nullable Type selfType, boolean selfIsTypeof) {
		TemplateParameterSubstitutionVisitor visitor = createVisitor(callExp, metaModelManager, selfType, selfIsTypeof);
		visitor.visit(callExp);
		return visitor.specializeType(type, isTypeof, false);
	}

	private final @NonNull MetaModelManager metaModelManager;
	private final @Nullable Type selfType;
	private final boolean selfIsTypeof;
	
	/**
	 * Internal variable used to pass the actual corresponding to the visited formal.
	 */
	private DomainType actual;
	
	public TemplateParameterSubstitutionVisitor(@NonNull MetaModelManager metaModelManager, @Nullable Type selfType, boolean selfIsTypeof) {
		super(new HashMap<Integer, Type>());
		this.metaModelManager = metaModelManager;
		this.selfType = selfType;
		this.selfIsTypeof = selfIsTypeof;
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
		if ((formalElement != null) && (actualElement instanceof Element)) {
			Type formalType = formalElement.getType();
			DomainType actualType = ApparentTypeVisitor.getApparentType(metaModelManager, (Element) actualElement);
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

	public @Nullable Type get(@Nullable TemplateParameter templateParameter) {
		if (templateParameter == null) {
			return null;
		}
		return context.get(templateParameter.getTemplateParameterId().getIndex());
	}

	protected @NonNull TupleType getSpecializedTupleType(@NonNull TupleType type, boolean isTypeof) {
		TupleType specializedTupleType = type;
		Map<String, Type> resolutions =  null;
		List<Property> parts = specializedTupleType.getOwnedProperties();
		for (Property part : parts) {
			if (part != null) {
				Type propertyType = PivotUtil.getType(part);
				if (propertyType != null) {
					Type resolvedPropertyType = specializeType(propertyType, isTypeof, true);
					if (resolvedPropertyType != propertyType) {
						if (resolutions == null) {
							resolutions = new HashMap<String, Type>();
						}
						resolutions.put(DomainUtil.getSafeName(part), resolvedPropertyType);
					}
				}
			}
		}
		if (resolutions != null) {
			List<TuplePartId> partIds = new ArrayList<TuplePartId>(parts.size());
			for (int i = 0; i < parts.size(); i++) {
				@SuppressWarnings("null") @NonNull Property part = parts.get(i);
				String partName = DomainUtil.getSafeName(part);
				Type resolvedPropertyType = resolutions.get(partName);
				TypeId partTypeId = resolvedPropertyType != null ? resolvedPropertyType.getTypeId() : part.getTypeId();
				TuplePartId tuplePartId = IdManager.getTuplePartId(i, partName, partTypeId);
				partIds.add(tuplePartId);
			}
			TupleTypeId tupleTypeId = IdManager.getTupleTypeId(DomainUtil.nonNullModel(type.getName()), partIds);
			specializedTupleType = metaModelManager.getTupleManager().getTupleType(metaModelManager.getIdResolver(), tupleTypeId);
			return specializedTupleType;
		}
		else {
			Map<String, Type> partMap = new HashMap<String, Type>();
			for (DomainTypedElement part : type.getOwnedProperties()) {
				DomainType type1 = part.getType();
				if (type1 != null) {
					Type type2 = metaModelManager.getType(type1);
					Type type3 = specializeType(type2, isTypeof, true);
					partMap.put(part.getName(), type3);
				}
			}
			return metaModelManager.getTupleManager().getTupleType(DomainUtil.getSafeName(type), partMap);
		}
	}

	public boolean isEmpty() {
		return context.isEmpty();
	}

	public void put(int templateParameterIndex, @Nullable Type actualType) {
		context.put(templateParameterIndex, actualType);
	}

	public @NonNull Type put(@NonNull TemplateParameter formalTemplateParameter, @NonNull Type actualType) {
		TemplateParameterId elementId = formalTemplateParameter.getTemplateParameterId();
		int index = elementId.getIndex();
		Type oldType = context.get(index);
		if (oldType != null) {
			IdResolver idResolver = metaModelManager.getIdResolver();
			DomainType commonType = oldType.getCommonType(idResolver, actualType);
			Type bestType = metaModelManager.getType(commonType);
			if (bestType != oldType) {
				context.put(index, bestType);
			}
			return bestType;
		}
		else {
			context.put(index, actualType);
			return actualType;
		}
	}

	public @NonNull Type specializeType(@NonNull Type type, boolean isTypeof, boolean isNested) {
		TemplateParameter asTemplateParameter = type.isTemplateParameter();
		if (asTemplateParameter != null) {
			int index = asTemplateParameter.getTemplateParameterId().getIndex();
			Type actualType = context.get(index);
			return actualType != null ? actualType : type;
		}
		if (type instanceof SelfType) {
			return DomainUtil.nonNullState(selfType != null ? !isNested && selfIsTypeof ? metaModelManager.getClassType() : selfType : type);	// FIXME this is a fudge for allInstances()/oclType()
		}
		else if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			Type elementType = DomainUtil.nonNullModel(collectionType.getElementType());
			Type specializedElementType = specializeType(elementType, isTypeof, true);
			CollectionType unspecializedCollectionType = PivotUtil.getUnspecializedTemplateableElement(collectionType);
			return metaModelManager.getCollectionType(unspecializedCollectionType, specializedElementType, null, null);
		}
		else if (type instanceof TupleType) {
			return getSpecializedTupleType((TupleType) type, isTypeof);
		}
		else if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			String typeName = DomainUtil.nonNullModel(lambdaType.getName());
			Type specializedContextType = specializeType(DomainUtil.nonNullModel(lambdaType.getContextType()), isTypeof, true);
			List<Type> specializedParameterTypes = new ArrayList<Type>();
			for (Type parameterType : lambdaType.getParameterType()) {
				if (parameterType != null) {
					specializedParameterTypes.add(specializeType(parameterType, isTypeof, true));
				}
			}
			Type specializedResultType = specializeType(DomainUtil.nonNullModel(lambdaType.getResultType()), isTypeof, true);
			return metaModelManager.getLambdaManager().getLambdaType(typeName, specializedContextType, specializedParameterTypes, specializedResultType);
		}
		else {
			//
			//	Get the bindings of the type.
			//
			org.eclipse.ocl.examples.pivot.Class partiallySpecializedType = (org.eclipse.ocl.examples.pivot.Class)type;
			org.eclipse.ocl.examples.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement(partiallySpecializedType);
			List<TemplateBinding> ownedTemplateBindings = partiallySpecializedType.getOwnedTemplateBindings();
			if (ownedTemplateBindings.size() > 0) {
				List<Type> templateArguments = new ArrayList<Type>();
				for (TemplateBinding ownedTemplateBinding : ownedTemplateBindings) {
					for (TemplateParameterSubstitution ownedTemplateParameterSubstitution : ownedTemplateBinding.getOwnedTemplateParameterSubstitutions()) {
						Type actualType = ownedTemplateParameterSubstitution.getActual();
						if (actualType != null) {
							actualType = specializeType(actualType, isTypeof, true);
							templateArguments.add(actualType);
						}
					}
				}
				return metaModelManager.getLibraryType(unspecializedType, templateArguments);
			}
			TemplateSignature ownedTemplateSignature = partiallySpecializedType.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				List<Type> templateArguments = new ArrayList<Type>();
				for (@SuppressWarnings("null")@NonNull TemplateParameter ownedTemplateParameter : ownedTemplateSignature.getOwnedTemplateParameters()) {
					Type actualType = specializeType(ownedTemplateParameter, isTypeof, true);
					templateArguments.add(actualType);
				}
				return metaModelManager.getLibraryType(unspecializedType, templateArguments);
			}
		}
		return type;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("{");
		boolean isFirst = true;
		List<Integer> keys = new ArrayList<Integer>(context.keySet());
		Collections.sort(keys);
		for (Integer index : keys) {
			if (!isFirst) {
				s.append("\n");
			}
			s.append(index + " => " + context.get(index));
			isFirst = false;
		}
		s.append("}");
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
	public @Nullable Object visitOperationCallExp(@NonNull OperationCallExp object) {
		Operation referredOperation = object.getReferredOperation();
//		visit(referredOperation, object);
		analyzeType(referredOperation.getType(), object.getType());
		analyzeType(referredOperation.getOwningClass(), object.getSource().getType());
		analyzeTypedElements(referredOperation.getOwnedParameter(), object.getArgument());
		//
		//	FIXME More general processing for T2 < T1
		//
		LibraryFeature implementationClass = referredOperation.getImplementation();
		if (implementationClass != null) {
			@SuppressWarnings("null")@NonNull Class<? extends LibraryFeature> className = implementationClass.getClass();
			TemplateParameterSubstitutionHelper helper = TemplateParameterSubstitutionHelper.getHelper(className);
			if (helper != null) {
				helper.resolveUnmodeledTemplateParameterSubstitutions(this, object);
			}
		}
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
				analyzeType(referredProperty.getOwningClass(), sourceType);
			}
			analyzeTypedElement(referredProperty, object);
		}
		return null;
	}

	@Override
	public @Nullable Object visitSelfType(@NonNull SelfType object) {
		analyzeType(/*selfIsTypeof ? metaModelManager.getClassType() :*/ selfType, actual);
		return null;
	}

	@Override
	public @Nullable Object visitTemplateParameter(@NonNull TemplateParameter object) {
		if (actual instanceof Type) {
			put(object, (Type)actual);
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

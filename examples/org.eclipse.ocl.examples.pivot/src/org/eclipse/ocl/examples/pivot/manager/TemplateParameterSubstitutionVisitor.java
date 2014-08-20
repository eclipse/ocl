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
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.CallExp;
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
import org.eclipse.ocl.examples.pivot.TemplateSignature;
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
public class TemplateParameterSubstitutionVisitor extends AbstractExtendingVisitor<Object, Map<TemplateParameter, List<DomainType>>>
{
	/**
	 * Return the specialized form of type analyzing expr to determine the formal to actual parameter mappings under the
	 * supervision of a metaModelManager and using selfType as the value of OclSelf.
	 */
	public static @NonNull Type specializeType(@NonNull Type type, @NonNull CallExp expr, @NonNull MetaModelManager metaModelManager, @NonNull Type selfType) {
		Resource resource = expr.eResource();
		TemplateParameterSubstitutionVisitor visitor;
		if (resource instanceof ASResource) {
			visitor = ((ASResource)resource).getASResourceFactory().createTemplateParameterSubstitutionVisitor(metaModelManager, selfType);
		}
		else {
			visitor = new TemplateParameterSubstitutionVisitor(metaModelManager, selfType);
		}
		visitor.visit(expr);
		return visitor.specializeType(type);
	}

	private final @NonNull MetaModelManager metaModelManager;
	private final @NonNull Type selfType;
	private Map<Integer, List<TemplateParameter>> indexedTemplateParameters = null;
	
	/**
	 * Internal variable used to pass the actual corresponding to the visited formal.
	 */
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

	protected @NonNull TupleType getSpecializedTupleType(@NonNull TupleType type) {
		TupleType specializedTupleType = type;
		Map<String, Type> resolutions =  null;
		List<Property> parts = specializedTupleType.getOwnedProperties();
		for (Property part : parts) {
			if (part != null) {
				Type propertyType = PivotUtil.getType(part);
				if (propertyType != null) {
					Type resolvedPropertyType = specializeType(propertyType);
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
					Type type3 = specializeType(type2);
					partMap.put(part.getName(), type3);
				}
			}
			return metaModelManager.getTupleManager().getTupleType(DomainUtil.getSafeName(type), partMap);
		}
	}

	public @Nullable DomainType specializeTemplateParameter(@Nullable TemplateParameter templateParameter) {
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

	public @NonNull Type specializeType(@NonNull Type type) {
		Map<TemplateParameter, Type> usageBindings = new HashMap<TemplateParameter, Type>();
		Set<TemplateParameter> keySet = context.keySet();
		Type[] templateBindings = new Type[keySet.size()];
		for (TemplateParameter templateParameter : keySet) {
			DomainType specialize = specializeTemplateParameter(templateParameter);
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
		TemplateParameter asTemplateParameter = type.isTemplateParameter();
		if (asTemplateParameter != null) {
			int index = asTemplateParameter.getTemplateParameterId().getIndex();
			if ((0 <= index) && (index < templateBindings.length)) {
				Type boundType = templateBindings[index];
				if (boundType != null) {
					return boundType;
				}
			}
			return type;
		}
		if (type instanceof SelfType) {
			return selfType;
		}
		else if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			Type elementType = DomainUtil.nonNullModel(collectionType.getElementType());
			Type specializedElementType = specializeType(elementType);
			CollectionType unspecializedCollectionType = PivotUtil.getUnspecializedTemplateableElement(collectionType);
			return metaModelManager.getCollectionType(unspecializedCollectionType, specializedElementType, null, null);
		}
		else if (type instanceof Metaclass<?>) {
			Metaclass<?> metaclass = (Metaclass<?>)type;
			Type instanceType = DomainUtil.nonNullModel(metaclass.getInstanceType());
			Type specializedInstanceType = specializeType(instanceType);
			return metaModelManager.getMetaclass(specializedInstanceType);
		}
		else if (type instanceof TupleType) {
			return getSpecializedTupleType((TupleType) type);
		}
		else if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			String typeName = DomainUtil.nonNullModel(lambdaType.getName());
			Type specializedContextType = specializeType(DomainUtil.nonNullModel(lambdaType.getContextType()));
			List<Type> specializedParameterTypes = new ArrayList<Type>();
			for (Type parameterType : lambdaType.getParameterType()) {
				if (parameterType != null) {
					specializedParameterTypes.add(specializeType(parameterType));
				}
			}
			Type specializedResultType = specializeType(DomainUtil.nonNullModel(lambdaType.getResultType()));
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
							actualType = specializeType(actualType);
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
					Type actualType = specializeType(ownedTemplateParameter);
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

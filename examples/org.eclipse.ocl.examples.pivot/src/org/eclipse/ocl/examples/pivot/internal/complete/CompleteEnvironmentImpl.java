/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.complete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.library.executor.CollectionTypeParameters;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.CompleteClass;
import org.eclipse.ocl.examples.pivot.CompleteModel;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.OrphanCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveCompletePackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteModelImpl;
import org.eclipse.ocl.examples.pivot.manager.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.manager.LambdaTypeManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PivotStandardLibrary2;
import org.eclipse.ocl.examples.pivot.manager.TemplateParameterSubstitutions;
import org.eclipse.ocl.examples.pivot.manager.TupleTypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class CompleteEnvironmentImpl implements CompleteEnvironment.Internal
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull CompleteModel.Internal completeModel;
	protected final @NonNull PivotStandardLibrary2 standardLibrary;
	protected final @NonNull Map<DomainClass, CompleteClass.Internal> class2completeClass = new WeakHashMap<DomainClass, CompleteClass.Internal>();
	
	/**
	 * The known lambda types.
	 */
	private LambdaTypeManager lambdaManager = null;			// Lazily created
	
	/**
	 * The known tuple types.
	 */
	private @Nullable TupleTypeManager tupleManager = null;			// Lazily created

	protected CompleteEnvironmentImpl() {
		this(new MetaModelManager());
	}

	public CompleteEnvironmentImpl(@NonNull MetaModelManager metaModelManager) {
		this.metaModelManager = metaModelManager;
		this.completeModel = new CompleteModelImpl(this);
		this.standardLibrary = new PivotStandardLibrary2(completeModel);
	}
	
	public void addOrphanClass(@NonNull org.eclipse.ocl.examples.pivot.Class pivotElement) {
		if (pivotElement.getUnspecializedElement() != null) {
			assert pivotElement.getUnspecializedElement().getUnspecializedElement() == null;
		}
		else {
			assert (pivotElement instanceof LambdaType)
				|| (pivotElement instanceof TupleType);
		}
		pivotElement.setOwningPackage(completeModel.getOrphanage());
	}

	@Override
	public boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		//
		//	Resolve first template parameters to its substitution
		//
		TemplateParameter firstTemplateParameter = firstType.isTemplateParameter();
		if (firstTemplateParameter != null) {
			Type firstSubstitution = firstSubstitutions.get(firstTemplateParameter);
			if (firstSubstitution != null) {
				firstType = firstSubstitution;
			}
		}
		//
		//	Accrue solution to the econd template parameter
		//
		TemplateParameter secondTemplateParameter = secondType.isTemplateParameter();
		if (secondTemplateParameter != null) {
//			Type secondSubstitution = secondSubstitutions.get(secondTemplateParameter);
//			if (secondSubstitution != null) {
//				secondType = secondSubstitution;
//			}
			secondType = secondSubstitutions.put(secondTemplateParameter, firstType);
			return true;
		}
		if (firstType == secondType) {
			return true;
		}
		//
		//	Normalize types to their behavioral class
		//
		CompleteClass firstCompleteClass = getCompleteClass(firstType);
		CompleteClass secondCompleteClass = getCompleteClass(secondType);
		if (firstCompleteClass == secondCompleteClass) {
			return true;
		}
		firstType = firstCompleteClass.getBehavioralClass();
		secondType = secondCompleteClass.getBehavioralClass();
		//
		//	Use specialized conformance for constructed types, inheritance tree intersection for simple types
		//
		if (firstType == secondType) {
			return true;
		}
		else if ((firstType instanceof DataType) && (secondType instanceof DataType)) {
			if ((firstType instanceof CollectionType) && (secondType instanceof CollectionType)) {
				return conformsToCollectionType((CollectionType)firstType, firstSubstitutions, (CollectionType)secondType, secondSubstitutions);
			}
			else if ((firstType instanceof LambdaType) && (secondType instanceof LambdaType)) {
				return conformsToLambdaType((LambdaType)firstType, firstSubstitutions, (LambdaType)secondType, secondSubstitutions);
			}
			else if ((firstType instanceof TupleType) && (secondType instanceof TupleType)) {
				return conformsToTupleType((TupleType)firstType, firstSubstitutions, (TupleType)secondType, secondSubstitutions);
			}
		}
		DomainInheritance firstInheritance = firstCompleteClass.getCompleteInheritance();
		DomainInheritance secondInheritance = secondCompleteClass.getCompleteInheritance();
		return firstInheritance.isSubInheritanceOf(secondInheritance);
	}

/*	@Override
	public boolean conformsToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType) {
		CollectionType firstCollectionType2 = (CollectionType)firstCollectionType;
		CollectionType secondCollectionType2 = (CollectionType)secondCollectionType;
		TemplateParameterSubstitutions firstSubstitutions = TemplateParameterSubstitutionVisitor.createBindings(this, firstCollectionType2, secondCollectionType2);
		TemplateParameterSubstitutions secondSubstitutions = TemplateParameterSubstitutionVisitor.createBindings(this, secondCollectionType2, firstCollectionType2);
		return conformsToCollectionType(firstCollectionType2, firstSubstitutions, secondCollectionType2, secondSubstitutions);	// FIXME cast
	} */

	protected boolean conformsToCollectionType(@NonNull CollectionType firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull CollectionType secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions) {
		CollectionType firstContainerType = firstType.getContainerType();
		CollectionType secondContainerType = secondType.getContainerType();
		if (firstContainerType != secondContainerType) {
			CompleteClass firstContainerCompleteClass = getCompleteClass(firstContainerType);
			CompleteClass secondContainerCompleteClass = getCompleteClass(secondContainerType);
			DomainInheritance firstContainerInheritance = firstContainerCompleteClass.getCompleteInheritance();
			DomainInheritance secondContainerInheritance = secondContainerCompleteClass.getCompleteInheritance();
			if (!firstContainerInheritance.isSubInheritanceOf(secondContainerInheritance)) {
				return false;
			}
		}
		Type firstElementType = firstType.getElementType();
		Type secondElementType = secondType.getElementType();
		if ((firstElementType == null) || (secondElementType == null)) {
			return false;
		}
		IntegerValue firstLower = firstType.getLowerValue();
		IntegerValue secondLower = secondType.getLowerValue();
		if (firstLower.compareTo(secondLower) < 0) {
			return false;
		}
		IntegerValue firstUpper = firstType.getUpperValue();
		IntegerValue secondUpper = secondType.getUpperValue();
		if (firstUpper.compareTo(secondUpper) > 0) {
			return false;
		}
		return conformsTo(firstElementType, firstSubstitutions, secondElementType, secondSubstitutions);
	}

	protected boolean conformsToLambdaType(@NonNull LambdaType actualType, @NonNull TemplateParameterSubstitutions actualSubstitutions,
			@NonNull LambdaType requiredType, @NonNull TemplateParameterSubstitutions requiredSubstitutions) {
		Type actualContextType = actualType.getContextType();
		Type requiredContextType = requiredType.getContextType();
		if ((actualContextType == null) || (requiredContextType == null)) {
			return false;
		}
		if (!conformsTo(actualContextType, actualSubstitutions, requiredContextType, requiredSubstitutions)) {
			return false;
		}
		Type actualResultType = actualType.getResultType();
		Type requiredResultType = requiredType.getResultType();
		if ((actualResultType == null) || (requiredResultType == null)) {
			return false;
		}
		if (!conformsTo(requiredResultType, requiredSubstitutions, actualResultType, actualSubstitutions)) {	// contravariant
			return false;
		}
		List<Type> actualParameterTypes = actualType.getParameterType();
		List<Type> requiredParameterTypes = requiredType.getParameterType();
		int iMax = actualParameterTypes.size();
		if (iMax != requiredParameterTypes.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			Type actualParameterType = actualParameterTypes.get(i);
			Type requiredParameterType = requiredParameterTypes.get(i);
			if ((actualParameterType == null) || (requiredParameterType == null)) {
				return false;
			}
			if (!conformsTo(actualParameterType, actualSubstitutions, requiredParameterType, requiredSubstitutions)) {
				return false;
			}
		}
		return true;
	}

	protected boolean conformsToTupleType(@NonNull TupleType actualType, @NonNull TemplateParameterSubstitutions actualSubstitutions,
			@NonNull TupleType requiredType, @NonNull TemplateParameterSubstitutions requiredSubstitutions) {
		List<Property> actualProperties = actualType.getOwnedProperties();
		List<Property> requiredProperties = requiredType.getOwnedProperties();
		if (actualProperties.size() != requiredProperties.size()) {
			return false;
		}
		for (Property actualProperty : actualProperties) {
			Property requiredProperty = DomainUtil.getNamedElement(requiredProperties, actualProperty.getName());
			if (requiredProperty == null) {
				return false;
			}
			Type actualPropertyType = actualProperty.getType();
			Type requiredPropertyType = requiredProperty.getType();
			if ((actualPropertyType == null) || (requiredPropertyType == null)) {
				return false;
			}
			if (!conformsTo(actualPropertyType, actualSubstitutions, requiredPropertyType, requiredSubstitutions)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void didAddClass(@NonNull DomainClass partialClass, @NonNull CompleteClass.Internal completeClass) {
//		assert partialClass.getUnspecializedElement() == null;
		CompleteClass oldCompleteClass = class2completeClass.put(partialClass, completeClass);
		assert (oldCompleteClass == null) ||(oldCompleteClass == completeClass);
	}
	
	@Override
	public void didRemoveClass(@NonNull DomainClass pivotType) {
		class2completeClass.remove(pivotType);
	}

	@Override
	public void dispose() {
		class2completeClass.clear();
		if (lambdaManager != null) {
			lambdaManager.dispose();
			lambdaManager = null;
		}
		if (tupleManager != null) {
			tupleManager.dispose();
			tupleManager = null;
		}
	}

	@Override
	public @Nullable CollectionType findCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return completeClass.findCollectionType(typeParameters);
	}

	@Override
	public @NonNull CollectionType getBagType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getBagType(metaModelManager.getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getBagType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(standardLibrary.getBagType(), elementType, lower, upper);
	}

	@Override
	public @NonNull CollectionType getCollectionType(@NonNull CompleteClass.Internal completeClass, @NonNull CollectionTypeParameters<Type> typeParameters) {
		return completeClass.getCollectionType(typeParameters);
	}
	
	@Override
	public @NonNull CollectionType getCollectionType(@NonNull DomainClass containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType((CollectionType)metaModelManager.getType(containerType), metaModelManager.getType(elementType), lower, upper);
	}

	@Override
	public @NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		assert containerType == PivotUtil.getUnspecializedTemplateableElement(containerType);
		TemplateSignature templateSignature = containerType.getOwnedTemplateSignature();
		if (templateSignature == null) {
			throw new IllegalArgumentException("Collection type must have a template signature");
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
		if (templateParameters.size() != 1) {
			throw new IllegalArgumentException("Collection type must have exactly one template parameter");
		}
		boolean isUnspecialized = elementType == templateParameters.get(0);
		if (isUnspecialized) {
			return containerType;	
		}
		@SuppressWarnings("unchecked")
		T specializedType = (T) completeModel.getCollectionType(completeModel.getCompleteClass(containerType), new CollectionTypeParameters<Type>(elementType, lower, upper));
		return specializedType;
	}
	
	@Override
	public @NonNull CompleteClass.Internal getCompleteClass(@NonNull DomainType pivotType) {
		for (int recursions = 0; pivotType instanceof DomainTemplateParameter; recursions++) {
			DomainType lowerBound = ((DomainTemplateParameter)pivotType).getLowerBound();
			pivotType = lowerBound != null ? lowerBound : getStandardLibrary().getOclAnyType();
			if (recursions > 100) {
				pivotType = getStandardLibrary().getOclAnyType();
			}
		}
		if (pivotType instanceof ElementExtension) {
			Stereotype stereotype = ((ElementExtension)pivotType).getStereotype();
			if (stereotype != null) {
				pivotType = stereotype;
			}
		}
		CompleteClass.Internal completeClass = class2completeClass.get(pivotType);
		if (completeClass != null) {
			return completeClass;
		}
		else if (pivotType instanceof PrimitiveType) {
			PrimitiveCompletePackage.Internal primitiveCompletePackage = completeModel.getPrimitiveCompletePackage();
			return primitiveCompletePackage.getCompleteClass((PrimitiveType)pivotType);
		}
		else if ((pivotType instanceof CollectionType) && (((CollectionType)pivotType).getUnspecializedElement() != null)) {
			OrphanCompletePackage.Internal orphanCompletePackage = completeModel.getOrphanCompletePackage();
			return orphanCompletePackage.getCompleteClass((CollectionType)pivotType);
		}
		else if (pivotType instanceof DomainClass) {
			DomainPackage pivotPackage = ((DomainClass)pivotType).getOwningPackage();
			if (pivotPackage == null) {
				throw new IllegalStateException("type has no package");
			}
			CompletePackage.Internal completePackage = completeModel.getCompletePackage(pivotPackage);
			return completePackage.getCompleteClass((DomainClass) pivotType);
		}
		else {
			throw new UnsupportedOperationException("TemplateType");
		}
	}

	@Override
	public @NonNull CompleteModel.Internal getCompleteModel() {
		return completeModel;
	}

	public @NonNull LambdaTypeManager getLambdaManager() {
		LambdaTypeManager lambdaManager2 = lambdaManager;
		if (lambdaManager2 == null) {
			lambdaManager2 = lambdaManager = new LambdaTypeManager(this);
		}
		return lambdaManager2;
	}

	@Override
	public @NonNull LambdaType getLambdaType(@NonNull String typeName, @NonNull Type contextType, @NonNull List<? extends Type> parameterTypes, @NonNull Type resultType,
			@Nullable TemplateParameterSubstitutions bindings) {
		LambdaTypeManager lambdaManager = getLambdaManager();
		return lambdaManager.getLambdaType(typeName, contextType, parameterTypes, resultType, bindings);
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	@Override
	public DomainPackage getNestedPackage(@NonNull DomainPackage domainPackage, @NonNull String name) {
		CompletePackage completePackage = metaModelManager.getCompletePackage(domainPackage);
		CompletePackage memberPackage = completePackage.getOwnedCompletePackage(name);
		return memberPackage != null ? memberPackage.getPivotPackage() : null;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class getNestedType(@NonNull DomainPackage domainPackage, @NonNull String name) {
		CompletePackage completePackage = metaModelManager.getCompletePackage(domainPackage);
		return completePackage.getMemberType(name);
	}

	@Override
	public @NonNull CollectionType getOrderedSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getOrderedSetType(metaModelManager.getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getOrderedSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(standardLibrary.getOrderedSetType(), elementType, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSequenceType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getSequenceType(metaModelManager.getType(elementType), lower, upper);
	}

	public @NonNull CollectionType getSequenceType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(standardLibrary.getSequenceType(), elementType, lower, upper);
	}

	@Override
	public @NonNull CollectionType getSetType(@NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getSetType(metaModelManager.getType(elementType), lower, upper);
	}

	@Override
	public @NonNull CollectionType getSetType(@NonNull Type elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		return getCollectionType(standardLibrary.getSetType(), elementType, lower, upper);
	}

	@Override
	public @NonNull Type getSpecializedType(@NonNull Type type, @Nullable TemplateParameterSubstitutions substitutions) {
		if ((substitutions == null) || substitutions.isEmpty()) {
			return type;
		}
		TemplateParameter asTemplateParameter = type.isTemplateParameter();
		if (asTemplateParameter != null) {
			Type boundType = substitutions.get(asTemplateParameter);
			org.eclipse.ocl.examples.pivot.Class asClass = boundType != null ? boundType.isClass() : null;
			return asClass != null ? asClass : type;
		}
		else if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)type;
			CollectionType unspecializedType = PivotUtil.getUnspecializedTemplateableElement(collectionType);
			if (!substitutions.isEmpty()) {
				TemplateParameter templateParameter = unspecializedType.getOwnedTemplateSignature().getOwnedTemplateParameters().get(0);
				Type templateArgument = substitutions.get(templateParameter);
				if (templateArgument == null) {
					templateArgument = templateParameter;
				}
				if (templateArgument != null) {
					return getCollectionType(unspecializedType, templateArgument, null, null);
				}
			}
			return collectionType;
		}
		else if (type instanceof TupleType) {
			return getTupleManager().getTupleType((TupleType) type, substitutions);
		}
		else if (type instanceof LambdaType) {
			LambdaType lambdaType = (LambdaType)type;
			String typeName = DomainUtil.nonNullModel(lambdaType.getName());
			Type contextType = DomainUtil.nonNullModel(lambdaType.getContextType());
			@NonNull List<Type> parameterType = lambdaType.getParameterType();
			Type resultType = DomainUtil.nonNullModel(lambdaType.getResultType());
			return getLambdaManager().getLambdaType(typeName, contextType, parameterType, resultType, substitutions);
		}
		else if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
			//
			//	Get the bindings of the type.
			//
			org.eclipse.ocl.examples.pivot.Class unspecializedType = PivotUtil.getUnspecializedTemplateableElement((org.eclipse.ocl.examples.pivot.Class)type);
			//
			//	Prepare the template argument list, one template argument per template parameter.
			//
			TemplateSignature templateSignature = unspecializedType.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getOwnedTemplateParameters();
				List<Type> templateArguments = new ArrayList<Type>(templateParameters.size());
				for (TemplateParameter templateParameter : templateParameters) {
					Type templateArgument = substitutions.get(templateParameter);
					templateArguments.add(templateArgument != null ? templateArgument : templateParameter);
				}
				return metaModelManager.getLibraryType(unspecializedType, templateArguments);
			}
		}
		return type;
	}

	@Override
	public @NonNull PivotStandardLibrary2 getStandardLibrary() {
		return standardLibrary;
	}

	@Override
	public @NonNull TupleTypeManager getTupleManager() {
		TupleTypeManager tupleManager2 = tupleManager;
		if (tupleManager2 == null) {
			tupleManager = tupleManager2 = new TupleTypeManager(this);
		}
		return tupleManager2;
	}

	@Override
	public @NonNull TupleType getTupleType(@NonNull String typeName, @NonNull Collection<? extends DomainTypedElement> parts,
			@Nullable TemplateParameterSubstitutions bindings) {
		return getTupleManager().getTupleType(typeName, parts, bindings);
	}
}
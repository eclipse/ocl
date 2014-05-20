/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.AbstractStandardLibrary;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.oclany.OclAnyUnsupportedOperation;
import org.eclipse.ocl.examples.library.LibraryConstants;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.IllegalLibraryException;
import org.eclipse.osgi.util.NLS;

public abstract class PivotStandardLibrary extends AbstractStandardLibrary	// FIXME AbstractStandardLibrary is unhelpful
{
	private static final Logger logger = Logger.getLogger(PivotStandardLibrary.class);

	/**
	 * The URI used by default for the OCL Standard Library. NB. This
	 * constant is repeated in GenerateOCLstdlibModel.mwe2 an in
	 * org.eclipse.ocl.examples.library/plugin.xml.
	 */
	public static final @NonNull String DEFAULT_OCL_STDLIB_URI = LibraryConstants.STDLIB_URI;

	/**
	 * The URI to provide the default Standard Library. This value may be
	 * reassigned pior to any OCL analysis or evaluation to select a different
	 * default. Alternatively the need for default may be bypassed by explicitly
	 * invoking loadLibrary().
	 */
	protected @NonNull String defaultStandardLibraryURI = DEFAULT_OCL_STDLIB_URI;

	private @Nullable BagType bagType = null;
	private @Nullable PrimitiveType booleanType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class classType = null;
	private @Nullable CollectionType collectionType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class enumerationType = null;
	private @Nullable PrimitiveType integerType = null;
	private @Nullable Metaclass<?> metaclassType = null;
	private @Nullable AnyType oclAnyType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class oclComparableType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class oclElementType = null;
	private @Nullable Operation oclInvalidOperation = null;
	private @Nullable Property oclInvalidProperty = null;
	private @Nullable InvalidType oclInvalidType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class oclLambdaType = null;
	private @Nullable SelfType oclSelfType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class oclSummableType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class oclTupleType = null;
	private @Nullable org.eclipse.ocl.examples.pivot.Class oclTypeType = null;
	private @Nullable VoidType oclVoidType = null;
	private @Nullable CollectionType orderedCollectionType = null;
	private @Nullable OrderedSetType orderedSetType = null;
	private @Nullable PrimitiveType realType = null;
	private @Nullable SequenceType sequenceType = null;
	private @Nullable SetType setType = null;
	private @Nullable PrimitiveType stringType = null;
	private @Nullable CollectionType uniqueCollectionType = null;
	private @Nullable PrimitiveType unlimitedNaturalType = null;
	
	private @Nullable Map<String, Type> nameToLibraryTypeMap = null;

	/**
	 * Names of all iterations in the libraries.
	 */
//	private Set<String> iterationNames = new HashSet<String>();

	protected void defineLibraryType(@NonNull Type pivotType) {
		Map<String, Type> nameToLibraryTypeMap2 = nameToLibraryTypeMap;
		if (nameToLibraryTypeMap2 == null) {
			nameToLibraryTypeMap = nameToLibraryTypeMap2 = new HashMap<String, Type>();
		}
		String name = pivotType.getName();
		Type oldType = nameToLibraryTypeMap2.put(name, pivotType);
		if ((oldType != null) && (oldType != pivotType)) {
			logger.warn("Conflicting pivot type '" + name + "'");
		}
//		for (Operation operation : pivotType.getOwnedOperation()) {
//			if (operation instanceof Iteration) {
//				iterationNames.add(operation.getName());
//			}
//		}
	}

	public @Nullable Operation basicGetOclInvalidOperation() {
		return oclInvalidOperation;
	}

	public @Nullable Property basicGetOclInvalidProperty() {
		return oclInvalidProperty;
	}

	public @Nullable InvalidType basicGetOclInvalidType() {
		return oclInvalidType;
	}

	@Override
	public void dispose() {
		resetLibrary();	
		super.dispose();
	}

	public @NonNull BagType getBagType() {
		BagType bagType2 = bagType;
		if (bagType2 == null) {
			bagType2 = bagType = resolveRequiredTemplateableType(BagType.class, TypeId.BAG_NAME, 1);
		}
		return bagType2;
	}

	public @NonNull PrimitiveType getBooleanType() {
		PrimitiveType booleanType2 = booleanType;
		if (booleanType2 == null) {
			booleanType2 = booleanType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.BOOLEAN_NAME);		
		}
		return booleanType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getClassType() {
		org.eclipse.ocl.examples.pivot.Class classType2 = classType;
		if (classType2 == null) {
			classType2 = classType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, TypeId.CLASS_NAME);		
		}
		return classType2;
	}

	public @NonNull CollectionType getCollectionType() {
		CollectionType collectionType2 = collectionType;
		if (collectionType2 == null) {
			collectionType2 = collectionType = resolveRequiredTemplateableType(CollectionType.class, TypeId.COLLECTION_NAME, 1);
		}
		return collectionType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getEnumerationType() {
		org.eclipse.ocl.examples.pivot.Class enumerationType2 = enumerationType;
		if (enumerationType2 == null) {
			enumerationType2 = enumerationType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, TypeId.ENUMERATION_NAME);		
		}
		return enumerationType2;
	}

	public @NonNull PrimitiveType getIntegerType() {
		PrimitiveType integerType2 = integerType;
		if (integerType2 == null) {
			integerType2 = integerType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.INTEGER_NAME);		
		}
		return integerType2;
	}

	public Type getLibraryType(@NonNull String typeName) {
		Map<String, Type> nameToLibraryTypeMap2 = nameToLibraryTypeMap;
		if (nameToLibraryTypeMap2 == null) {
			nameToLibraryTypeMap = nameToLibraryTypeMap2 = new HashMap<String, Type>();
			loadDefaultLibrary(defaultStandardLibraryURI);
		}
		return nameToLibraryTypeMap2.get(typeName);
	}

	public @NonNull Metaclass<?> getMetaclassType() {
		Metaclass<?> metaclassType2 = metaclassType;
		if (metaclassType2 == null) {
			metaclassType2 = metaclassType = resolveRequiredTemplateableType(Metaclass.class, TypeId.METACLASS_NAME, 1);		
		}
		return metaclassType2;
	}

	public @NonNull AnyType getOclAnyType() {
		AnyType oclAnyType2 = oclAnyType;
		if (oclAnyType2 == null) {
			oclAnyType2 = oclAnyType = resolveRequiredSimpleType(AnyType.class, TypeId.OCL_ANY_NAME);		
		}
		return oclAnyType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getOclComparableType() {
		org.eclipse.ocl.examples.pivot.Class oclComparableType2 = oclComparableType;
		if (oclComparableType2 == null) {
			oclComparableType2 = oclComparableType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, TypeId.OCL_COMPARABLE_NAME);		
		}
		return oclComparableType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getOclElementType() {
		org.eclipse.ocl.examples.pivot.Class oclElementType2 = oclElementType;
		if (oclElementType2 == null) {
			oclElementType2 = oclElementType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, "OclElement");		
		}
		return oclElementType2;
	}

	public @NonNull Operation getOclInvalidOperation() {
		Operation oclInvalidOperation2 = oclInvalidOperation;
		if (oclInvalidOperation2 == null) {
			InvalidType invalidType = getOclInvalidType();
			List<Operation> invalidOperations = invalidType.getOwnedOperation();
			String invalidName = "oclBadOperation";
			oclInvalidOperation2 = DomainUtil.getNamedElement(invalidOperations, invalidName);
			if (oclInvalidOperation2 == null) {
				oclInvalidOperation2 = PivotFactory.eINSTANCE.createOperation();
				oclInvalidOperation2.setName(invalidName);
				oclInvalidOperation2.setType(invalidType);
				oclInvalidOperation2.setImplementation(OclAnyUnsupportedOperation.INSTANCE);
				invalidOperations.add(oclInvalidOperation2);
			}
			oclInvalidOperation = oclInvalidOperation2;
		}
		return oclInvalidOperation2;
	}

	public @NonNull Property getOclInvalidProperty() {
		Property oclInvalidProperty2 = oclInvalidProperty;
		if (oclInvalidProperty2 == null) {
			InvalidType invalidType = getOclInvalidType();
			List<Property> invalidProperties = invalidType.getOwnedAttribute();
			String invalidName = "oclBadProperty";
			oclInvalidProperty2 = DomainUtil.getNamedElement(invalidProperties, invalidName);
			if (oclInvalidProperty2 == null) {
				oclInvalidProperty2 = PivotFactory.eINSTANCE.createProperty();
				oclInvalidProperty2.setName(invalidName);
				oclInvalidProperty2.setType(invalidType);
				oclInvalidProperty2.setImplementation(OclAnyUnsupportedOperation.INSTANCE);
				invalidProperties.add(oclInvalidProperty2);
			}
			oclInvalidProperty = oclInvalidProperty2;
		}
		return oclInvalidProperty2;
	}

	public @NonNull InvalidType getOclInvalidType() {
		InvalidType oclInvalidType2 = oclInvalidType;
		if (oclInvalidType2 == null) {
			oclInvalidType2 = oclInvalidType = resolveRequiredSimpleType(InvalidType.class, TypeId.OCL_INVALID_NAME);		
		}
		return oclInvalidType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getOclLambdaType() {
		org.eclipse.ocl.examples.pivot.Class oclLambdaType2 = oclLambdaType;
		if (oclLambdaType2 == null) {
			oclLambdaType2 = oclLambdaType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, "OclLambda");		
		}
		return oclLambdaType2;
	}

	public Type getOclMessageType() {
		return getRequiredLibraryType("OclMessage");
	}

	public @NonNull SelfType getOclSelfType() {
		SelfType oclSelfType2 = oclSelfType;
		if (oclSelfType2 == null) {
			oclSelfType2 = oclSelfType = resolveRequiredSimpleType(SelfType.class, TypeId.OCL_SELF_NAME);		
		}
		return oclSelfType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getOclSummableType() {
		org.eclipse.ocl.examples.pivot.Class oclSummableType2 = oclSummableType;
		if (oclSummableType2 == null) {
			oclSummableType2 = oclSummableType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, TypeId.OCL_SUMMABLE_NAME);		
		}
		return oclSummableType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getOclTupleType() {
		org.eclipse.ocl.examples.pivot.Class oclTupleType2 = oclTupleType;
		if (oclTupleType2 == null) {
			oclTupleType2 = oclTupleType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, "OclTuple");		
		}
		return oclTupleType2;
	}

	public @NonNull org.eclipse.ocl.examples.pivot.Class getOclTypeType() {
		org.eclipse.ocl.examples.pivot.Class oclTypeType2 = oclTypeType;
		if (oclTypeType2 == null) {
			oclTypeType2 = oclTypeType = resolveRequiredSimpleType(org.eclipse.ocl.examples.pivot.Class.class, "OclType");		
		}
		return oclTypeType2;
	}

	public @NonNull VoidType getOclVoidType() {
		VoidType oclVoidType2 = oclVoidType;
		if (oclVoidType2 == null) {
			oclVoidType2 = oclVoidType = resolveRequiredSimpleType(VoidType.class, TypeId.OCL_VOID_NAME);		
		}
		return oclVoidType2;
	}

	public @NonNull CollectionType getOrderedCollectionType() {
		CollectionType orderedCollectionType2 = orderedCollectionType;
		if (orderedCollectionType2 == null) {
			orderedCollectionType2 = orderedCollectionType = resolveRequiredTemplateableType(CollectionType.class, TypeId.ORDERED_COLLECTION_NAME, 1);
		}
		return orderedCollectionType2;
	}

	public @NonNull OrderedSetType getOrderedSetType() {
		OrderedSetType orderedSetType2 = orderedSetType;
		if (orderedSetType2 == null) {
			orderedSetType2 = orderedSetType = resolveRequiredTemplateableType(OrderedSetType.class, TypeId.ORDERED_SET_NAME, 1);
		}
		return orderedSetType2;
	}

	public @NonNull PrimitiveType getRealType() {
		PrimitiveType realType2 = realType;
		if (realType2 == null) {
			realType2 = realType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.REAL_NAME);		
		}
		return realType2;
	}

	public @NonNull Type getRequiredLibraryType(@NonNull String typeName) {
		Type type = getLibraryType(typeName);
		if (type == null) {
//			nameToLibraryTypeMap = null;
			type = getLibraryType(typeName);	// FIXME just a debug retry
			Map<String, Type> nameToLibraryTypeMap2 = nameToLibraryTypeMap;
			if ((nameToLibraryTypeMap2 == null) || nameToLibraryTypeMap2.isEmpty()) {
				throw new IllegalLibraryException(OCLMessages.EmptyLibrary_ERROR_);
			}
			else {
				throw new IllegalLibraryException(NLS.bind(OCLMessages.MissingLibraryType_ERROR_, typeName));
			}
		}
		return type;
	}

	public @NonNull SequenceType getSequenceType() {
		SequenceType sequenceType2 = sequenceType;
		if (sequenceType2 == null) {
			sequenceType2 = sequenceType = resolveRequiredTemplateableType(SequenceType.class, TypeId.SEQUENCE_NAME, 1);
		}
		return sequenceType2;
	}

	public @NonNull SetType getSetType() {
		SetType setType2 = setType;
		if (setType2 == null) {
			setType2 = setType = resolveRequiredTemplateableType(SetType.class, TypeId.SET_NAME, 1);
		}
		return setType2;
	}

	public @NonNull PrimitiveType getStringType() {
		PrimitiveType stringType2 = stringType;
		if (stringType2 == null) {
			stringType2 = stringType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.STRING_NAME);		
		}
		return stringType2;
	}

	public @NonNull CollectionType getUniqueCollectionType() {
		CollectionType uniqueCollectionType2 = uniqueCollectionType;
		if (uniqueCollectionType2 == null) {
			uniqueCollectionType2 = uniqueCollectionType = resolveRequiredTemplateableType(CollectionType.class, TypeId.UNIQUE_COLLECTION_NAME, 1);
		}
		return uniqueCollectionType2;
	}

	public @NonNull PrimitiveType getUnlimitedNaturalType() {
		PrimitiveType unlimitedNaturalType2 = unlimitedNaturalType;
		if (unlimitedNaturalType2 == null) {
			unlimitedNaturalType2 = unlimitedNaturalType = resolveRequiredSimpleType(PrimitiveType.class, TypeId.UNLIMITED_NATURAL_NAME);		
		}
		return unlimitedNaturalType2;
	}

	public boolean isOrdered(Type sourceType) {
		if (sourceType instanceof OrderedSetType) {
			return true;
		}
		if (sourceType instanceof SequenceType) {
			return true;
		}
		return false;
	}

	public boolean isUnique(Type sourceType) {
		if (sourceType instanceof OrderedSetType) {
			return true;
		}
		if (sourceType instanceof SetType) {
			return true;
		}
		return false;
	}
	
	protected abstract Resource loadDefaultLibrary(String uri);

	public void resetLibrary() {
		bagType = null;
		booleanType = null;
		classType = null;
		collectionType = null;
		enumerationType = null;
		integerType = null;
		metaclassType = null;
		oclAnyType = null;
		oclElementType = null;
		oclInvalidType = null;
		oclLambdaType = null;
		oclTupleType = null;
		oclTypeType = null;
		oclVoidType = null;
		orderedSetType = null;
		realType = null;
		sequenceType = null;
		setType = null;
		stringType = null;
		unlimitedNaturalType = null;
		nameToLibraryTypeMap = null;
	}

	protected @NonNull <T extends TemplateableElement> T resolveRequiredSimpleType(@NonNull Class<T> requiredClassType, @NonNull String name) {
		Type type = getRequiredLibraryType(name);
		if (requiredClassType.isAssignableFrom(type.getClass())) {
			@SuppressWarnings("unchecked")
			T type2 = (T) type;
			return type2;
		}
		else {
			throw new IllegalLibraryException(name + " is not a " + requiredClassType.getSimpleName());
		}		
	}

	protected @NonNull <T extends TemplateableElement> T resolveRequiredTemplateableType(@NonNull Class<T> requiredClassType, @NonNull String name, int parameterCount) {
		Type type = getRequiredLibraryType(name);
		if (requiredClassType.isAssignableFrom(type.getClass())) {
			if (type.getOwnedTemplateSignature() == null) {
				throw new IllegalLibraryException(name + " is not a templated type");
			}
			else if (type.getOwnedTemplateSignature().getOwnedParameter().size() != parameterCount) {
				throw new IllegalLibraryException(name + " is not a templated type with " + parameterCount + " argument" + (parameterCount != 1 ? "s" : ""));
			}
			@SuppressWarnings("unchecked")
			T type2 = (T) type;
			return type2;
		}
		else {
			throw new IllegalLibraryException(name + " is not a " + requiredClassType.getSimpleName());
		}		
	}
}

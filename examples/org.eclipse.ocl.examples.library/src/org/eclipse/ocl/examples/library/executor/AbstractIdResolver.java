/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.executor;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumeration;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.NestedPackageId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;
import org.eclipse.ocl.examples.domain.ids.TemplateBinding;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.domain.types.AbstractTuplePart;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OCLValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.impl.OrderedSetImpl;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public abstract class AbstractIdResolver implements IdResolver
{
	public static final class Id2InstanceVisitor implements IdVisitor<Object>
	{
		protected final @NonNull String stringValue;

		private Id2InstanceVisitor(@NonNull String stringValue) {
			this.stringValue = stringValue;
		}

		public @Nullable Object visitClassId(@NonNull ClassId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitCollectionTypeId(@NonNull CollectionTypeId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitDataTypeId(@NonNull DataTypeId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitEnumerationId(@NonNull EnumerationId id) {
			return id.getEnumerationLiteralId(stringValue);
		}

		public @Nullable Object visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitInvalidId(@NonNull OclInvalidTypeId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitLambdaTypeId(@NonNull LambdaTypeId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitMetaclassId(@NonNull MetaclassId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitNestedPackageId(@NonNull NestedPackageId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitNsURIPackageId(@NonNull NsURIPackageId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitNullId(@NonNull OclVoidTypeId id) {
			return null;
		}

		public @Nullable Object visitOperationId(@NonNull OperationId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
			if (id == TypeId.BOOLEAN) {
				return Boolean.valueOf(stringValue);
			}
			else if (id == TypeId.STRING) {
				return stringValue;
			}
			else if (id == TypeId.INTEGER) {
				return ValuesUtil.integerValueOf(stringValue);
			}
			else if (id == TypeId.REAL) {
				return ValuesUtil.realValueOf(stringValue);
			}
			else if (id == TypeId.UNLIMITED_NATURAL) {
				return ValuesUtil.integerValueOf(stringValue);
			}
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitPropertyId(@NonNull PropertyId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitRootPackageId(@NonNull RootPackageId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitTemplateBinding(@NonNull TemplateBinding id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitTemplateParameterId(@NonNull TemplateParameterId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitTuplePartId(@NonNull TuplePartId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitTupleTypeId(@NonNull TupleTypeId id) {
			throw new UnsupportedOperationException();
		}

		public @Nullable Object visitUnspecifiedId(@NonNull UnspecifiedId id) {
			throw new UnsupportedOperationException();
		}
	}

	protected final @NonNull DomainStandardLibrary standardLibrary;
	private final @NonNull Map<Object, DomainType> key2type = new HashMap<Object, DomainType>();	// Concurrent puts are duplicates
	private /*@LazyNonNull*/ Map<EnumerationLiteralId, Enumerator> enumerationLiteral2enumerator = null;	// Concurrent puts are duplicates
	private /*@LazyNonNull*/ Map<Enumerator, EnumerationLiteralId> enumerator2enumerationLiteralId = null;	// Concurrent puts are duplicates

	/**
	 * Mapping from name to list of correspondingly named types for definition of tuple parts. This cache is used to provide the
	 * required part definitions to construct a tuple type in the lightweight execution environment. This cache may remain
	 * unused when using the full pivot environment.
	 */
	private Map<String, Map<DomainType, WeakReference<DomainTypedElement>>> tupleParts = null;		// Lazily created
	
	public AbstractIdResolver(@NonNull DomainStandardLibrary standardLibrary) {
		this.standardLibrary = standardLibrary;
	}

	public @Nullable Object boxedValueOf(@Nullable Object unboxedValue) {
		if (unboxedValue == null) {
			return unboxedValue;
		}
		else if (unboxedValue instanceof Value) {
			return unboxedValue;
		}
		else if (unboxedValue instanceof Boolean) {
			return unboxedValue;
		}
		else if (unboxedValue instanceof String) {
			return unboxedValue;
		}
		else if (unboxedValue instanceof Number) {
			if ((unboxedValue instanceof Integer) || (unboxedValue instanceof Long) || (unboxedValue instanceof Short) || (unboxedValue instanceof Byte)) {
				return ValuesUtil.integerValueOf(((Number) unboxedValue).longValue());
			}
			if ((unboxedValue instanceof Float) || (unboxedValue instanceof Double)) {
				return ValuesUtil.realValueOf(((Number) unboxedValue).doubleValue());
			}
			if (unboxedValue instanceof BigDecimal) {
				return ValuesUtil.realValueOf((BigDecimal) unboxedValue);
			}
			if (unboxedValue instanceof BigInteger) {
				return ValuesUtil.integerValueOf((BigInteger) unboxedValue);
			}			
		}
		else if (unboxedValue instanceof Character) {
			return ValuesUtil.integerValueOf(((Character) unboxedValue).charValue());
		}			
		else if (unboxedValue.getClass().isArray()) {
			try {
				Object[] unboxedValues = (Object[])unboxedValue;
				DomainType dynamicType = getDynamicTypeOf(unboxedValues);
				if (dynamicType == null) {
					dynamicType = standardLibrary.getOclInvalidType();
				}
				TypeId elementTypeId = dynamicType.getTypeId();
				CollectionTypeId collectedTypeId = TypeId.SEQUENCE.getSpecializedId(elementTypeId);
				return createSequenceOfEach(collectedTypeId, (Object[])unboxedValue);
			} 
			catch (IllegalArgumentException e) {}
		}
		else if (unboxedValue instanceof Iterable<?>) {
			Iterable<?> unboxedValues = (Iterable<?>)unboxedValue;
			DomainType dynamicType = getDynamicTypeOf(unboxedValues);
			if (dynamicType == null) {
				dynamicType = standardLibrary.getOclInvalidType();
			}
			TypeId elementTypeId = dynamicType.getTypeId();
			CollectionTypeId collectedTypeId = TypeId.SEQUENCE.getSpecializedId(elementTypeId);
			if ((unboxedValue instanceof LinkedHashSet) || (unboxedValue instanceof OrderedSet)) {
				return createOrderedSetOfAll(collectedTypeId, unboxedValues);
			}
			else if (unboxedValue instanceof Bag) {
				return createBagOfAll(collectedTypeId, unboxedValues);
			}
			else if (unboxedValue instanceof Set) {
				return createSetOfAll(collectedTypeId, unboxedValues);
			}
			else {
				return createSequenceOfAll(collectedTypeId, unboxedValues);
			}
		}
/*		else if (unboxedValue instanceof EEnumLiteral) {
			return ValuesUtil.createEnumerationLiteralValue((EEnumLiteral)unboxedValue);
		} */
		else if (unboxedValue instanceof DomainType) {
			return unboxedValue;
		}
		else if (unboxedValue instanceof DomainEnumerationLiteral) {
			return ((DomainEnumerationLiteral) unboxedValue).getEnumerationLiteralId();
		}
		else if (unboxedValue instanceof EEnumLiteral) {
			return IdManager.getEnumerationLiteralId((EEnumLiteral) unboxedValue);
		}
		else if (unboxedValue instanceof EObject) {
			return unboxedValue;
		}
		else if (unboxedValue instanceof DomainElement) {
			return unboxedValue;
		}
		else if (unboxedValue instanceof EnumerationLiteralId) {		// ?? shouldn't happen
			return unboxedValue;
		}	 
		else if (unboxedValue instanceof Enumerator) {
			return boxedValueOfEnumerator((Enumerator) unboxedValue);
		}
		throw new UnsupportedOperationException();				// Must invoke createObjectValue with the appropriate TypeId
	}

	public @Nullable Object boxedValueOf(@NonNull Object unboxedValue, @Nullable EClassifier eClassifier) {
		if (unboxedValue instanceof Value) {
			return unboxedValue;		
		}
		else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum)eClassifier;
			String name = DomainUtil.nonNullModel(((Enumerator)unboxedValue).getName());
			EnumerationId enumId = IdManager.getEnumerationId(eEnum);
			EnumerationLiteralId enumerationLiteralId = enumId.getEnumerationLiteralId(name);
			return enumerationLiteralId;		
		}
		else {
			return boxedValueOf(unboxedValue);
		}
	}

	public @Nullable Object boxedValueOf(@NonNull Object unboxedValue, @NonNull ETypedElement eFeature, @Nullable TypeId typeId) {
		EClassifier eClassifier = eFeature.getEType();
		if (typeId instanceof CollectionTypeId) {
			Collection<?> unboxedValues = (Collection<?>) unboxedValue;
			if (eClassifier instanceof EDataType) {
				ArrayList<Object> values = new ArrayList<Object>(unboxedValues.size());
				for (Object eVal : unboxedValues) {
					if (eVal != null) {
						values.add(boxedValueOf(eVal, eClassifier));
					}
				}
				unboxedValues = values;
			}
			return createCollectionOfAll((CollectionTypeId)typeId, unboxedValues);
		}
		else {
			return boxedValueOf(unboxedValue, eClassifier);
		}
	}

	public @Nullable Object boxedValueOfEnumerator(@NonNull Enumerator unboxedValue) {
		Map<Enumerator, EnumerationLiteralId> enumerator2enumerationLiteralId2 = enumerator2enumerationLiteralId;
		if (enumerator2enumerationLiteralId2 == null) {
			synchronized (this) {
				enumerator2enumerationLiteralId2 = enumerator2enumerationLiteralId;
				if (enumerator2enumerationLiteralId2 == null) {
					enumerator2enumerationLiteralId = enumerator2enumerationLiteralId2 = new HashMap<Enumerator, EnumerationLiteralId>();
					for (DomainPackage dPackage : standardLibrary.getAllPackages()) {
						for (DomainType dType : dPackage.getOwnedType()) {
							if (dType instanceof DomainEnumeration) {
								for (DomainEnumerationLiteral dEnumerationLiteral : ((DomainEnumeration) dType).getEnumerationLiterals()) {
									Enumerator enumerator = dEnumerationLiteral.getEnumerator();
									EnumerationLiteralId enumerationLiteralId = dEnumerationLiteral.getEnumerationLiteralId();
									enumerator2enumerationLiteralId.put(enumerator, enumerationLiteralId);
								}
							}
						}
					}
				}
			}		
		}
		EnumerationLiteralId enumerationLiteralId = enumerator2enumerationLiteralId2.get(unboxedValue);
		if (enumerationLiteralId == null) {
			throw new InvalidValueException("Unknown enumeration " + unboxedValue.getName()); //$NON-NLS-1$
		}
		return enumerationLiteralId;
	}

	public @NonNull BagValue createBagOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues) {
		Bag<Object> boxedValues = new BagImpl<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createBagValue(typeId, boxedValues);
	}
	
	public @NonNull BagValue createBagOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues) {
		Bag<Object> boxedValues = new BagImpl<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createBagValue(typeId, boxedValues);
	}
	   
	/**
	 * Creates a new OCL <tt>Collection</tt> of the specified ordering and uniqueness.
     * 
	 * @param isOrdered the required collection ordering
	 * @param isUnique the required collection uniqueness
	 * @param unboxedValues the required collection contents
	 * @return the new collection
	 */
	public @NonNull CollectionValue createCollectionOfAll(boolean isOrdered, boolean isUnique, @NonNull TypeId elementTypeId, @NonNull Iterable<? extends Object> unboxedValues) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetOfAll(TypeId.ORDERED_SET.getSpecializedId(elementTypeId), unboxedValues);
			}
			else {
				return createSequenceOfAll(TypeId.SEQUENCE.getSpecializedId(elementTypeId), unboxedValues);
			}
		}
		else {
			if (isUnique) {
				return createSetOfAll(TypeId.SET.getSpecializedId(elementTypeId), unboxedValues);
			}
			else {
				return createBagOfAll(TypeId.BAG.getSpecializedId(elementTypeId), unboxedValues);
			}
		}
	}

	public @NonNull CollectionValue createCollectionOfAll(@NonNull CollectionTypeId collectedId, @NonNull Iterable<?> unboxedValues) {
		CollectionTypeId collectionId = collectedId.getGeneralizedId();
		if (collectionId == TypeId.BAG) {
			return createBagOfAll(collectedId, unboxedValues);
		}
		else if (collectionId == TypeId.ORDERED_SET) {
			return createOrderedSetOfAll(collectedId, unboxedValues);
		}
		else if (collectionId == TypeId.SEQUENCE) {
			return createSequenceOfAll(collectedId, unboxedValues);
		}
		else /*if (collectionId == TypeId.SET)*/ {
			return createSetOfAll(collectedId, unboxedValues);
		}
	} 

	public @Nullable Object createInstance(@NonNull TypeId typeId, @NonNull String stringValue) {
		Id2InstanceVisitor visitor = new Id2InstanceVisitor(stringValue);
		return typeId.accept(visitor);
	}

	public @NonNull OrderedSetValue createOrderedSetOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues) {
		OrderedSet<Object> boxedValues = new OrderedSetImpl<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createOrderedSetValue(typeId, boxedValues);
	}

	public @NonNull OrderedSetValue createOrderedSetOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues) {
		OrderedSet<Object> boxedValues = new OrderedSetImpl<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createOrderedSetValue(typeId, boxedValues);
	}

	public @NonNull SequenceValue createSequenceOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues) {
		List<Object> boxedValues = new ArrayList<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createSequenceValue(typeId, boxedValues);
	}

	public @NonNull SequenceValue createSequenceOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues) {
		List<Object> boxedValues = new ArrayList<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createSequenceValue(typeId, boxedValues);
	}

	public @NonNull SetValue createSetOfAll(@NonNull CollectionTypeId typeId, @NonNull Iterable<? extends Object> unboxedValues) {
		Set<Object> boxedValues = new HashSet<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createSetValue(typeId, boxedValues);
	}

	public @NonNull SetValue createSetOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... unboxedValues) {
		Set<Object> boxedValues = new HashSet<Object>();
		for (Object unboxedValue : unboxedValues) {
			boxedValues.add(boxedValueOf(unboxedValue));
		}
		return ValuesUtil.createSetValue(typeId, boxedValues);
	}

	public void dispose() {
		tupleParts = null;
		key2type.clear();
		enumerationLiteral2enumerator = null;
		enumerator2enumerationLiteralId = null;
	}

	public @NonNull DomainType getCollectionType(@NonNull CollectionTypeId typeId) {
		return getCollectionType(typeId, null, null);
	}

	public @NonNull DomainType getCollectionType(@NonNull CollectionTypeId typeId, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		CollectionTypeId generalizedId = typeId.getGeneralizedId();
		if ((typeId == generalizedId) && (lower == null) && (upper == null)) {
			if (generalizedId == TypeId.BAG) {
				return standardLibrary.getBagType();
			}
			else if (generalizedId == TypeId.COLLECTION) {
				return standardLibrary.getCollectionType();
			}
			else if (generalizedId == TypeId.ORDERED_SET) {
				return standardLibrary.getOrderedSetType();
			}
			else if (generalizedId == TypeId.SEQUENCE) {
				return standardLibrary.getSequenceType();
			}
			else if (generalizedId == TypeId.SET) {
				return standardLibrary.getSetType();
			}
			else if (generalizedId == TypeId.UNIQUE_COLLECTION) {
				return standardLibrary.getUniqueCollectionType();
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		else {
			TypeId elementTypeId = typeId.getElementTypeId();
			DomainType elementType = getType(elementTypeId, null);
			if (generalizedId == TypeId.BAG) {
				return standardLibrary.getBagType(elementType, lower, upper);
			}
			else if (generalizedId == TypeId.COLLECTION) {
				return standardLibrary.getCollectionType(standardLibrary.getCollectionType(), elementType, lower, upper);
			}
			else if (generalizedId == TypeId.ORDERED_SET) {
				return standardLibrary.getOrderedSetType(elementType, lower, upper);
			}
			else if (generalizedId == TypeId.SEQUENCE) {
				return standardLibrary.getSequenceType(elementType, lower, upper);
			}
			else if (generalizedId == TypeId.SET) {
				return standardLibrary.getSetType(elementType, lower, upper);
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}
	
	public @NonNull DomainType getDynamicTypeOf(@Nullable Object value) {
		if (value instanceof CollectionValue) {
			CollectionValue collectionValue = (CollectionValue) value;
			DomainType elementType = getDynamicTypeOf(collectionValue.iterable());
			if (elementType == null) {
				elementType = getType(collectionValue.getTypeId().getElementTypeId(), null);
			}
			CollectionTypeId collectedId = collectionValue.getTypeId();
			CollectionTypeId collectionId = collectedId.getGeneralizedId();
			TypeId elementTypeId = elementType.getTypeId();
			collectedId = collectionId.getSpecializedId(elementTypeId);
			final IntegerValue size = collectionValue.size();
			return getCollectionType(collectedId, size, size);
		}
		else {
			return getStaticTypeOf(value);
		}
	}
	
	public @Nullable DomainType getDynamicTypeOf(@NonNull Object... values) {
		DomainType elementType = null;
		for (Object value : values) {
			DomainType valueType = getDynamicTypeOf(value);
			if (elementType == null) {
				elementType = valueType;
			}
			else {
				elementType = elementType.getCommonType(this, valueType);
			}
		}
		if (elementType == null) {
			elementType = standardLibrary.getOclInvalidType();
		}
		return elementType;
	}
	
	public @Nullable DomainType getDynamicTypeOf(@NonNull Iterable<?> values) {
		DomainType elementType = null;
		for (Object value : values) {
			DomainType valueType = getDynamicTypeOf(value);
			if (elementType == null) {
				elementType = valueType;
			}
			else {
				elementType = elementType.getCommonType(this, valueType);
			}
		}
		return elementType;
	}

	public synchronized @NonNull DomainType getJavaType(@NonNull Class<?> javaClass) {
		DomainType type = key2type.get(javaClass);
		if (type != null) {
			return type;
		}
/*		if (javaClass == Boolean.class) {
			type = standardLibrary.getBooleanType();
		}
		else if (javaClass == String.class) {
			type = standardLibrary.getStringType();
		}
		else { */
			type = new JavaType(standardLibrary, javaClass);
//		}
		key2type.put(javaClass, type);
		return type;
	}

	public @NonNull DomainType getMetaclass(@NonNull MetaclassId metaclassId) {
		if (metaclassId == TypeId.METACLASS) {
			return standardLibrary.getMetaclassType();
		}
		else {
			ElementId elementId = metaclassId.getElementId();
			DomainType elementType = getType((TypeId)elementId, null);
			return standardLibrary.getMetaclass(elementType);
		}
	}

	public @NonNull DomainOperation getOperation(@NonNull OperationId operationId) {
		DomainElement element = operationId.accept(this);
		if (element instanceof DomainOperation) {
			return (DomainOperation) element;
		}
		throw new IllegalStateException("No " + operationId); //$NON-NLS-1$
	}

	public @NonNull DomainPackage getPackage(@NonNull PackageId packageId) {
		DomainElement element = packageId.accept(this);
		if (element instanceof DomainPackage) {
			return (DomainPackage) element;
		}
		throw new IllegalStateException("No " + packageId); //$NON-NLS-1$
	}

	public @NonNull DomainProperty getProperty(@NonNull PropertyId propertyId) {
		DomainElement element = propertyId.accept(this);
		if (element instanceof DomainProperty) {
			return (DomainProperty) element;
		}
		throw new IllegalStateException("No " + propertyId); //$NON-NLS-1$
	}

	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		if (value instanceof DomainType) {
			DomainType type = key2type.get(value);
			if (type == null) {
				type = standardLibrary.getMetaclass((DomainType) value);
				assert type != null;
				key2type.put(value, type);
			}
			return type;
		}
		else if (value instanceof EObject) {
			EClass eClass = ((EObject)value).eClass();
			assert eClass != null;
			DomainType type = key2type.get(eClass);
			if (type == null) {
				type = getType(eClass);
				assert type != null;
				key2type.put(eClass, type);
			}
			return type;
		}
		else if (value instanceof Value) {
			TypeId typeId = ((Value)value).getTypeId();			
			DomainType type = key2type.get(typeId);
			if (type == null) {
				type = (DomainType) typeId.accept(this);
				assert type != null;
				key2type.put(typeId, type);
			}
			return type;
		}
		else if (value == null) {
			return standardLibrary.getOclVoidType();
		}
		if (value instanceof Boolean) {
			return standardLibrary.getBooleanType();
		}
		else if (value instanceof String) {
			return standardLibrary.getStringType();
		}
		else if (value instanceof Number) {
			if ((value instanceof BigDecimal) || (value instanceof Double) || (value instanceof Float)) {
				return standardLibrary.getRealType();
			}
			if ((value instanceof BigInteger) || (value instanceof Byte) || (value instanceof Integer) || (value instanceof Long) || (value instanceof Short)) {
				return standardLibrary.getIntegerType();
			}
		}
		else if (value instanceof EnumerationLiteralId) {
			DomainEnumerationLiteral enumLiteral = (DomainEnumerationLiteral) ((EnumerationLiteralId)value).accept(this);
			assert enumLiteral != null;
			DomainEnumeration enumeration = enumLiteral.getEnumeration();
			assert enumeration != null;
			return enumeration;
		}
		Class<?> jClass = value.getClass();
		assert jClass != null;
		return getJavaType(jClass);
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, Object... values) {
		Object bestTypeId = getTypeKeyOf(value);
		DomainType bestType = key2type.get(bestTypeId);
		assert bestType != null;
		Collection<Object> assessedTypeKeys = null;
		int count = 0;
		for (Object anotherValue : values) {
			Object anotherTypeId = getTypeKeyOf(anotherValue);
			if ((assessedTypeKeys == null) ? (anotherTypeId != bestTypeId) : !assessedTypeKeys.contains(anotherTypeId)) {
				DomainType anotherType = key2type.get(anotherTypeId);
				assert anotherType != null;
				DomainType commonType = bestType.getCommonType(this, anotherType);
				if (commonType != bestType) {
					if (assessedTypeKeys == null) {
						assessedTypeKeys = new ArrayList<Object>();
						assessedTypeKeys.add(bestTypeId);
					}
					else if (count++ == 4) {
						assessedTypeKeys = new HashSet<Object>(assessedTypeKeys);
					}
					assessedTypeKeys.add(anotherTypeId);
					bestType = commonType;
					bestTypeId = anotherTypeId;
				}
			}
		}		
		return bestType;
	}

	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		Object bestTypeKey = getTypeKeyOf(value);
		DomainType bestType = key2type.get(bestTypeKey);
		assert bestType != null;
		Collection<Object> assessedTypeKeys = null;
		int count = 0;
		for (Object anotherValue : values) {
			assert anotherValue != null;
			Object anotherTypeKey = getTypeKeyOf(anotherValue);
			if ((assessedTypeKeys == null) ? (anotherTypeKey != bestTypeKey) : !assessedTypeKeys.contains(anotherTypeKey)) {
				DomainType anotherType = key2type.get(anotherTypeKey);
				assert anotherType != null;
				DomainType commonType = bestType.getCommonType(this, anotherType);
				if (commonType != bestType) {
					if (assessedTypeKeys == null) {
						assessedTypeKeys = new ArrayList<Object>();
						assessedTypeKeys.add(bestTypeKey);
					}
					else if (count++ == 4) {
						assessedTypeKeys = new HashSet<Object>(assessedTypeKeys);
					}
					assessedTypeKeys.add(anotherTypeKey);
				}
			}
		}		
		return bestType;
	}
	
	public @NonNull DomainTypedElement getTuplePart(@NonNull String name, @NonNull TypeId typeId) {
		return getTuplePart(name, getType(typeId, null));
	}

	public synchronized @NonNull DomainTypedElement getTuplePart(@NonNull String name, @NonNull DomainType type) {
		if (tupleParts == null) {
			tupleParts = new WeakHashMap<String, Map<DomainType, WeakReference<DomainTypedElement>>>();
		}
		Map<DomainType, WeakReference<DomainTypedElement>> typeMap = tupleParts.get(name);
		if (typeMap == null) {
			typeMap = new WeakHashMap<DomainType, WeakReference<DomainTypedElement>>();
			tupleParts.put(name, typeMap);
		}
		DomainTypedElement tupleProperty = weakGet(typeMap, type);
		if (tupleProperty == null) {
			tupleProperty = new AbstractTuplePart(type, name);
			typeMap.put(type, new WeakReference<DomainTypedElement>(tupleProperty));
		}
		return tupleProperty;
	}

	public abstract @NonNull DomainTupleType getTupleType(@NonNull TupleTypeId typeId);

	public abstract @NonNull DomainType getType(@NonNull EClassifier eClassifier);

	public @NonNull DomainType getType(@NonNull TypeId typeId, @Nullable Object context) {
		DomainElement type = typeId.accept(this);
		assert type != null;
		return (DomainType)type;
	}

	private @NonNull Object getTypeKeyOf(@Nullable Object value) {
		/*if (value instanceof DomainType) {
			DomainType type = (DomainType) id2element.get(value);
			if (type == null) {
				type = standardLibrary.getMetaclass((DomainType) value);
				assert type != null;
				id2element.put(value, type);
			}
			return value;
		}
		else*/ if (value instanceof EObject) {
			EClass typeKey = ((EObject)value).eClass();
			assert typeKey != null;
			DomainType type = key2type.get(typeKey);
			if (type == null) {
				type = getType(typeKey);
				assert type != null;
				key2type.put(typeKey, type);
			}
			return typeKey;
		}
		else if (value instanceof Value) {
			TypeId typeKey = ((Value)value).getTypeId();			
			DomainType type = key2type.get(typeKey);
			if (type == null) {
				type = (DomainType) typeKey.accept(this);
				assert type != null;
				key2type.put(typeKey, type);
			}
			return typeKey;
		}
		else if (value == null) {
			TypeId typeKey = TypeId.OCL_VOID;			
			key2type.put(typeKey, standardLibrary.getOclVoidType());
			return typeKey;
		}
		else {
			Class<?> typeKey = value.getClass();
			assert typeKey != null;
			DomainType type = key2type.get(typeKey);
			if (type != null) {
				return typeKey;
			}
			if (value instanceof Boolean) {
				type = standardLibrary.getBooleanType();
			}
			else if (value instanceof String) {
				type = standardLibrary.getStringType();
			}
			if (type != null) {
				key2type.put(typeKey, type);
				return typeKey;
			}
		}
		throw new UnsupportedOperationException();
	}

	public boolean oclEquals(@Nullable Object thisValue, @Nullable Object thatValue) {
		if (thisValue == thatValue) {
			return true;
		}
		else if (thisValue instanceof OCLValue) {
			if (thatValue instanceof OCLValue) {
				return ((OCLValue)thisValue).oclEquals((OCLValue)thatValue);
			}
			else {
				thatValue = boxedValueOf(thatValue);
				if (thatValue instanceof OCLValue) {
					return ((OCLValue)thisValue).oclEquals((OCLValue)thatValue);
				}
				else {
					return false;
				}
			}
		}
		else if (thatValue instanceof OCLValue) {
			thisValue = boxedValueOf(thisValue);
			if (thisValue instanceof OCLValue) {
				return ((OCLValue)thisValue).oclEquals((OCLValue)thatValue);
			}
			else {
				return false;
			}
		}
		else if (thisValue != null) {
			if (thatValue != null) {
				return thisValue.equals(thatValue);
			}
			else {
				return false;
			}
		}
		else {
			return thatValue == null;
		}
	}

	public @Nullable Object unboxedValueOf(@Nullable Object boxedValue) {
		if (boxedValue instanceof Value) {
			return ((Value)boxedValue).asEcoreObject(this);
		}
		else if (boxedValue instanceof EnumerationLiteralId) {
			return unboxedValueOf((EnumerationLiteralId)boxedValue);
		}
		else {
			return boxedValue;
		}
	}

	public @NonNull Enumerator unboxedValueOf(@NonNull EnumerationLiteralId enumerationLiteralId) {
		if (enumerationLiteral2enumerator == null) {
			synchronized (this) {
				if (enumerationLiteral2enumerator == null) {
					enumerationLiteral2enumerator = new HashMap<EnumerationLiteralId, Enumerator>();
				}
			}
		}
		Enumerator enumerator = enumerationLiteral2enumerator.get(enumerationLiteralId);
		if (enumerator == null) {
			synchronized (enumerationLiteral2enumerator) {
				enumerator = enumerationLiteral2enumerator.get(enumerationLiteralId);
				if (enumerator == null) {
					DomainEnumerationLiteral enumerationLiteral = (DomainEnumerationLiteral) enumerationLiteralId.accept(this);
					if (enumerationLiteral != null) {
						enumerator = enumerationLiteral.getEnumerator();
						enumerationLiteral2enumerator.put(enumerationLiteralId, enumerator);
					}
					if (enumerator == null) {
						throw new UnsupportedOperationException();		// FIXME
					}
				}
			}
		}
		return enumerator;
	}

	public @NonNull EList<Object> unboxedValuesOfAll(@NonNull Collection<? extends Object> boxedValues) {
		Object[] unboxedValues = new Object[boxedValues.size()];
		int i= 0;
		for (Object boxedValue : boxedValues) {
			unboxedValues[i++] = unboxedValueOf(boxedValue);
		}
		return new EcoreEList.UnmodifiableEList<Object>(null, null, i, unboxedValues);
	}

	public @NonNull EList<Object> unboxedValuesOfEach(@NonNull Object... boxedValues) {
		Object[] unboxedValues = new Object[boxedValues.length];
		int i= 0;
		for (Object boxedValue : boxedValues) {
			unboxedValues[i++] = unboxedValueOf(boxedValue);
		}
		return new EcoreEList.UnmodifiableEList<Object>(null, null, boxedValues.length, unboxedValues);
	}

	public @NonNull DomainType visitClassId(@NonNull ClassId id) {
		DomainPackage parentPackage = (DomainPackage) id.getParent().accept(this);
		assert parentPackage != null;
		DomainType nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
		if (nestedType == null) {
			nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
			throw new UnsupportedOperationException();
		}
		return nestedType;
	}
	
	public @NonNull DomainType visitCollectedId(@NonNull CollectionTypeId id) {
		DomainType elementType = (DomainType) id.getElementTypeId().accept(this);
		if (elementType == null) {
			throw new UnsupportedOperationException();
		}
		CollectionTypeId collectionTypeId = id.getGeneralizedId();
		if (collectionTypeId == TypeId.METACLASS) {
			return standardLibrary.getMetaclass(elementType);
		}
		else {
			DomainType collectionType = getCollectionType(collectionTypeId);
			return standardLibrary.getCollectionType(collectionType, elementType, null, null);
		}
	}

	public @NonNull DomainType visitCollectionTypeId(@NonNull CollectionTypeId id) {
		return getCollectionType(id);
	}

	public @NonNull DomainType visitDataTypeId(@NonNull DataTypeId id) {
		DomainPackage parentPackage = (DomainPackage) id.getParent().accept(this);
		assert parentPackage != null;
		DomainType nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
		if (nestedType == null) {
			nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
			if (nestedType == null) {
				throw new UnsupportedOperationException();
			}
		}
		return nestedType;
	}
	
	public @NonNull DomainEnumeration visitEnumerationId(@NonNull EnumerationId id) {
		DomainPackage parentPackage = (DomainPackage) id.getParent().accept(this);
		assert parentPackage != null;
		DomainType nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
		if (nestedType == null) {
			nestedType = standardLibrary.getNestedType(parentPackage, id.getName());
			throw new UnsupportedOperationException();
		}
		if (!(nestedType instanceof DomainEnumeration)) {
			throw new UnsupportedOperationException();
		}
		return (DomainEnumeration) nestedType;
	}

	public @NonNull DomainEnumerationLiteral visitEnumerationLiteralId(@NonNull EnumerationLiteralId id) {
		DomainElement parent = id.getParentId().accept(this);
		if (!(parent instanceof DomainEnumeration)) {
			throw new UnsupportedOperationException();
		}
		DomainEnumerationLiteral enumerationLiteral = ((DomainEnumeration)parent).getEnumerationLiteral(id.getName());
		if (enumerationLiteral == null) {
			throw new UnsupportedOperationException();
		}
		return enumerationLiteral;
	}

	public @NonNull DomainType visitInvalidId(@NonNull OclInvalidTypeId id) {
		return standardLibrary.getOclInvalidType();
	}

	public @NonNull DomainType visitLambdaTypeId(@NonNull LambdaTypeId id) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType visitMetaclassId(@NonNull MetaclassId id) {
		return getMetaclass(id);
	}

	public @NonNull DomainPackage visitNestedPackageId(@NonNull NestedPackageId packageId) {
		DomainPackage parentPackage = (DomainPackage) packageId.getParent().accept(this);
		assert parentPackage != null;
		DomainPackage nestedPackage = standardLibrary.getNestedPackage(parentPackage, packageId.getName());
		if (nestedPackage == null) {
			throw new UnsupportedOperationException();
		}
		return nestedPackage;
	}

	public @NonNull DomainPackage visitNsURIPackageId(@NonNull NsURIPackageId id) {
		DomainPackage nsURIPackage = standardLibrary.getNsURIPackage(id.getNsURI());
		if (nsURIPackage == null) {
			throw new UnsupportedOperationException();
		}
		return nsURIPackage;
	}

	public @NonNull DomainType visitNullId(@NonNull OclVoidTypeId id) {
		return standardLibrary.getOclVoidType();
	}

	public @NonNull DomainOperation visitOperationId(@NonNull OperationId id) {
		DomainType domainType = (DomainType) id.getParent().accept(this);
		if (domainType == null) {
			throw new UnsupportedOperationException();
		}
		DomainInheritance inheritance = standardLibrary.getInheritance(domainType);
		DomainOperation memberOperation = inheritance.getMemberOperation(id);
		if (memberOperation == null) {
			throw new UnsupportedOperationException();
		}
		return memberOperation;
	}

	public @NonNull DomainType visitPrimitiveTypeId(@NonNull PrimitiveTypeId id) {
		DomainType primitiveType = standardLibrary.getPrimitiveType(id);
		if (primitiveType == null) {
			throw new UnsupportedOperationException();
		}
		return primitiveType;
	}

	public @NonNull DomainProperty visitPropertyId(@NonNull PropertyId id) {
		DomainType domainType = (DomainType) id.getParent().accept(this);
		if (domainType == null) {
			throw new UnsupportedOperationException();
		}
		DomainInheritance inheritance = standardLibrary.getInheritance(domainType);
		DomainProperty memberProperty = inheritance.getMemberProperty(id.getName());
		if (memberProperty == null) {
			throw new UnsupportedOperationException();
		}
		return memberProperty;
	}

	public @NonNull DomainPackage visitRootPackageId(@NonNull RootPackageId id) {
		DomainPackage rootPackage = standardLibrary.getRootPackage(id.getName());
		if (rootPackage == null) {
			throw new UnsupportedOperationException();
		}
		return rootPackage;
	}

	public @NonNull DomainElement visitTemplateBinding(@NonNull TemplateBinding id) {
		return id.getTemplateParameter();
	}

	public @NonNull DomainElement visitTemplateParameterId(@NonNull TemplateParameterId id) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType visitTemplateableTypeId(@NonNull TemplateableTypeId id) {
		return getType(id, null);
	}

	public @NonNull DomainTypedElement visitTuplePartId(@NonNull TuplePartId id) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainType visitTupleTypeId(@NonNull TupleTypeId id) {
		return getTupleType(id);
	}

	public @NonNull DomainType visitUnspecifiedId(@NonNull UnspecifiedId id) {
		return (DomainType) id.getSpecifier();
	}

	/**
	 * Return the map.get(key).get() entry if there is one or null if not, removing any stale
	 * entry that may be encountered.
	 */
	protected <K, V> V weakGet(@NonNull Map<K, WeakReference<V>> map, @NonNull K key) {
		WeakReference<V> ref = map.get(key);
		if (ref == null) {
			return null;
		}
		V value = ref.get();
		if (value == null) {
			map.remove(key);
		}
		return value;
	}
}

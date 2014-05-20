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
package org.eclipse.ocl.examples.domain.values.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.elements.DomainMetaclass;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.UnsupportedOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.messages.StatusCodes;
import org.eclipse.ocl.examples.domain.types.AbstractInheritance;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.domain.values.Bag;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSet;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Unlimited;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.impl.BagImpl;
import org.eclipse.ocl.examples.domain.values.impl.BagValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.BigIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.CollectionValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.IntIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.IntegerRangeImpl;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.impl.JavaObjectValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.LongIntegerValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.NullValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.OrderedSetImpl;
import org.eclipse.ocl.examples.domain.values.impl.RangeSequenceValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.RealValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.SetValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.SparseOrderedSetValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.SparseSequenceValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.TupleValueImpl;
import org.eclipse.ocl.examples.domain.values.impl.UnlimitedValueImpl;

/**
 */
public abstract class ValuesUtil
{	
	public static final @NonNull String NULL_STRING = "null";

	private static final int NEGATIVE_INTEGERS = 256;
	private static final int POSITIVE_INTEGERS = 1025;
	private static final @NonNull IntegerValue[] INTEGER_VALUES = new IntegerValue[NEGATIVE_INTEGERS + POSITIVE_INTEGERS];

	public static @NonNull Bag<?> EMPTY_BAG = new BagImpl<Object>();	
	@SuppressWarnings("null")
	public static final @NonNull Set<Object> EMPTY_SET = Collections.emptySet();

	@SuppressWarnings("null")
	public static final @NonNull BigInteger INTEGER_MAX_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger INTEGER_MIN_VALUE = BigInteger.valueOf(Integer.MIN_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();	

	@SuppressWarnings("null")
	public static final @NonNull Boolean FALSE_VALUE = Boolean.FALSE;
	public static final @NonNull InvalidValueException INVALID_VALUE = new InvalidValueException("invalid"); 
	public static final @NonNull NullValue NULL_VALUE = new NullValueImpl(); 
	public static final @NonNull IntegerValue ONE_VALUE = integerValueOf(1);
	@SuppressWarnings("null")
	public static final @NonNull Boolean TRUE_VALUE = Boolean.TRUE;
	public static final @NonNull UnlimitedValue UNLIMITED_VALUE = new UnlimitedValueImpl(); 
	public static final @NonNull IntegerValue ZERO_VALUE = integerValueOf(0);
	
	private static boolean allStaticsInitialized = false;

	public static @NonNull BagValue asBagValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asBagValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName(value));
		}
	}

	public static @NonNull Boolean asBoolean(@Nullable Object value) {
		if (value == Boolean.TRUE) {
			return TRUE_VALUE;
		}
		else if (value == Boolean.FALSE) {
			return FALSE_VALUE;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(value));
		}
	}

	public static @NonNull DomainCollectionType asCollectionType(@Nullable Object value) {
		if (value instanceof DomainCollectionType) {
			return (DomainCollectionType)value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_TYPE_NAME, getTypeName(value));
		}
	}

	public static @NonNull CollectionValue asCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asCollectionValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, getTypeName(value));
		}
	}

	public static @NonNull Integer asInteger(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asInteger();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value));
		}
	}

	public static @NonNull IntegerValue asIntegerValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asIntegerValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value));
		}
	}

	public static @NonNull DomainMetaclass asMetaclass(@Nullable Object value) {
		if (value instanceof DomainMetaclass) {
			return (DomainMetaclass)value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Metaclass", getTypeName(value));
		}
	}

	public static @NonNull EObject asNavigableObject(@Nullable Object value, @NonNull Object navigation) {
		if (value instanceof Value) {
			return ((Value)value).asNavigableObject();
		}
		else if (value instanceof EObject) {
			return (EObject)value;
		}
		else if (value == null) {
			throw new InvalidValueException(("Attempt to navigate from null to '" + EcoreUtils.qualifiedNameFor(navigation) + "'").replace("'", "''"));
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "NavigableObject", getTypeName(value));
		}
	}

	public static @Nullable Object asObject(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asObject();
		}
		else {
			return value;
		}
	}

	public static @NonNull OrderedCollectionValue asOrderedCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asOrderedCollectionValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.ORDERED_COLLECTION_NAME, getTypeName(value));
		}
	}

	public static @NonNull OrderedSetValue asOrderedSetValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asOrderedSetValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.ORDERED_SET_NAME, getTypeName(value));
		}
	}

	public static @NonNull RealValue asRealValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asRealValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.REAL_NAME, getTypeName(value));
		}
	}

	public static @NonNull SequenceValue asSequenceValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSequenceValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SEQUENCE_NAME, getTypeName(value));
		}
	}

	public static @NonNull SetValue asSetValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSetValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SET_NAME, getTypeName(value));
		}
	}

	public static @NonNull String asString(@Nullable Object value) {
		if (value instanceof String) {
			return (String)value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.STRING_NAME, getTypeName(value));
		}
	}

	public static @NonNull TupleValue asTupleValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asTupleValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.TUPLE_NAME, getTypeName(value));
		}
	}

	public static @NonNull DomainType asType(@Nullable Object value) {
		if (value instanceof DomainType) {
			return (DomainType)value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Type", getTypeName(value));
		}
	}

	public static @NonNull UniqueCollectionValue asUniqueCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUniqueCollectionValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.UNIQUE_COLLECTION_NAME, getTypeName(value));
		}
	}

	public static @NonNull Value asUnlimitedNaturalValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUnlimitedNaturalValue();
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.UNLIMITED_NATURAL_NAME, getTypeName(value));
		}
	}

	public static Object asValue(Object value) {
		if (value != null) {
			return value;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.OCL_ANY_NAME, getTypeName(value));
		}
	}

	@SuppressWarnings("null")
	public static @NonNull BigDecimal bigDecimalValueOf(@NonNull Object anObject) {
		if (anObject instanceof BigDecimal) {
			return (BigDecimal)anObject;
		}
		else if (anObject instanceof Unlimited) {
			return BigDecimal.valueOf(Double.POSITIVE_INFINITY);
		}
		else if (anObject instanceof Number) {
			return BigDecimal.valueOf(((Number)anObject).doubleValue());
		}
		else if (anObject instanceof Character) {
			return BigDecimal.valueOf(((Character)anObject).charValue());
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, anObject);
		}
	}

	@SuppressWarnings("null")
	public static @NonNull BigInteger bigIntegerValueOf(@NonNull Object anObject) {
		if (anObject instanceof BigInteger) {
			return (BigInteger)anObject;
		}
//		else if (anObject instanceof Unlimited) {
//			return UNLIMITED_VALUE;
//		}
		else if (anObject instanceof Number) {
			return BigInteger.valueOf(((Number)anObject).longValue());
		}
		else if (anObject instanceof Character) {
			return BigInteger.valueOf(((Character)anObject).charValue());
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.InvalidInteger, anObject);
		}
	}

	@SuppressWarnings("null")
	public static @NonNull Character characterValueOf(@NonNull Object anObject) {
		if (anObject instanceof Character) {
			return (Character)anObject;
		}
//		else if (anObject instanceof Unlimited) {
//			return UNLIMITED_VALUE;
//		}
		else if (anObject instanceof Number) {
			return Character.valueOf((char)((Number)anObject).longValue());
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.InvalidCharacter, anObject);
		}
	}

	public static @NonNull BagValue.Accumulator createBagAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new BagValueImpl.Accumulator(collectedId);
	}	

	public static @NonNull BagValue createBagOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... boxedValues) {
		return new BagValueImpl(typeId, BagValueImpl.createBagOfEach(boxedValues));
	}

	public static @NonNull BagValue createBagRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		Bag<Object> allValues = new BagImpl<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new BagValueImpl(typeId, allValues);
	}

	public static @NonNull BagValue createBagValue(@NonNull CollectionTypeId typeId, @NonNull Bag<? extends Object> boxedValues) {
		return new BagValueImpl(typeId, boxedValues);
	}

	public static @NonNull CollectionValue.Accumulator createCollectionAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		CollectionTypeId collectionId = collectedId.getGeneralizedId();
		if (collectionId == TypeId.BAG) {
			return new BagValueImpl.Accumulator(collectedId);
		}
		else if (collectionId == TypeId.ORDERED_SET) {
			return new SparseOrderedSetValueImpl.Accumulator(collectedId);
		}
		else if (collectionId == TypeId.SEQUENCE) {
			return new SparseSequenceValueImpl.Accumulator(collectedId);
		}
		else /*if (collectionId == TypeId.SET)*/ {
			return new SetValueImpl.Accumulator(collectedId);
		}
	}	

	public static @NonNull InvalidValueException createInvalidValue(@NonNull Exception e) {
		if (e instanceof InvalidValueException) {
			return (InvalidValueException)e;
		}
		else {
			return new InvalidValueException(e);
		}
	}

	public static @NonNull ObjectValue createObjectValue(@NonNull TypeId typeId, @NonNull Object object) {
		return new JavaObjectValueImpl(typeId, object);
	}

	public static @NonNull OrderedSetValue.Accumulator createOrderedSetAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new SparseOrderedSetValueImpl.Accumulator(collectedId);
	}	

//	public static @NonNull OrderedSetValue createOrderedSetRange(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
//		return new RangeOrderedSetValueImpl(typeId, range);
//	}

	public static @NonNull OrderedSetValue createOrderedSetOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... boxedValues) {
		return new SparseOrderedSetValueImpl(typeId, SparseOrderedSetValueImpl.createOrderedSetOfEach(boxedValues));
	}

	public static @NonNull OrderedSetValue createOrderedSetRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		OrderedSet<Object> allValues = new OrderedSetImpl<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SparseOrderedSetValueImpl(typeId, allValues);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> boxedValues) {
		return new SparseOrderedSetValueImpl(typeId, boxedValues);
	}

	public static @NonNull IntegerRange createRange(@NonNull IntegerValue firstInteger, @NonNull IntegerValue lastInteger) {
		return new IntegerRangeImpl(firstInteger, lastInteger);
	}

	public static @NonNull SequenceValue.Accumulator createSequenceAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new SparseSequenceValueImpl.Accumulator(collectedId);
	}	

	public static @NonNull SequenceValue createSequenceOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... boxedValues) {
		return new SparseSequenceValueImpl(typeId, SparseSequenceValueImpl.createSequenceOfEach(boxedValues));
	}

	public static @NonNull SequenceValue createSequenceRange(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
		return new RangeSequenceValueImpl(typeId, range);
	}

	public static @NonNull SequenceValue createSequenceRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		List<Object> allValues = new ArrayList<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SparseSequenceValueImpl(typeId, allValues);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> boxedValues) {
		return new SparseSequenceValueImpl(typeId, boxedValues);
	}

	public static @NonNull SetValue.Accumulator createSetAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new SetValueImpl.Accumulator(collectedId);
	}	

	public static @NonNull SetValue createSetOfEach(@NonNull CollectionTypeId typeId, @NonNull Object... boxedValues) {
		return new SetValueImpl(typeId, SetValueImpl.createSetOfEach(boxedValues));
	}

	public static @NonNull SetValue createSetRange(@NonNull CollectionTypeId typeId, @NonNull Object... values) {
		Set<Object> allValues = new HashSet<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SetValueImpl(typeId, allValues);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> boxedValues) {
		return new SetValueImpl(typeId, boxedValues);
	}

	public static @NonNull TupleValue createTupleValue(@NonNull TupleTypeId typeId, @NonNull Map<? extends TuplePartId, Object> values) {
		return new TupleValueImpl(typeId, values);
	}

	public static @NonNull TupleValue createTupleOfEach(@NonNull TupleTypeId typeId, @NonNull Object... values) {
		return new TupleValueImpl(typeId, values);
	}

	@Deprecated
	public static @NonNull TupleValue createTupleValue(@NonNull TupleTypeId typeId, @NonNull Object... values) {
		return createTupleOfEach(typeId, values);
	}
	
	@Deprecated // obsolete
	public static @NonNull DomainType createTypeValue(@Nullable DomainType type) {
		if (type == null) {
			throw new InvalidValueException("null type");
		}
		return type;
	}

	public static Object getEcoreNumber(@NonNull Number number, Class<?> instanceClass) {
		if ((instanceClass == Double.class) || (instanceClass == double.class)) {
			return number.doubleValue();
		}
		else if ((instanceClass == Float.class) || (instanceClass == float.class)) {
			return number.floatValue();
		}
		else if ((instanceClass == Short.class) || (instanceClass == short.class)) {
			return number.shortValue();
		}
		else if ((instanceClass == Integer.class) || (instanceClass == int.class)) {
			return number.intValue();
		}
		else if ((instanceClass == Long.class) || (instanceClass == long.class)) {
			return number.longValue();
		}
		else if (number instanceof BigDecimal) {
			return number.doubleValue();
		}
		else if (number instanceof BigInteger) {
			return number.longValue();
		}
		else {
			return number;
		}
	}
	
	public static String getTypeName(@Nullable Object value) {
		if (value instanceof Boolean) {
			return TypeId.BOOLEAN_NAME;
		}
		else if (value instanceof String) {
			return TypeId.STRING_NAME;
		}
		else if (value instanceof Value) {
			return ((Value) value).getTypeId().getDisplayName();
		}
		else if (value == null) {
			return TypeId.OCL_VOID_NAME;
		}
		return "Object";
	}
	
	/**
	 * Initialize all static variables in this package to avoid thread contention between conflicting initializations.
	 * <p>
	 * Returns true if this invocation performed the initialization.
	 */
	public static boolean initAllStatics() {
		if (!allStaticsInitialized) {
			synchronized (ValuesUtil.class) {
				if (!allStaticsInitialized) {
					allStaticsInitialized = true;
					// org.eclipse.ocl.examples.domain.elements
					DomainParameterTypes.EMPTY_LIST.getClass();
					DomainTypeParameters.EMPTY_LIST.getClass();
					// org.eclipse.ocl.examples.domain.evaluation
					DomainModelManager.NULL.getClass();
					// org.eclipse.ocl.examples.domain.ids
//					IdManager.getClass();
					TemplateableId.NULL_TEMPLATEABLE_ID_ARRAY.getClass();
//					BindingsId.EMPTY_LIST.getClass();
//					TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY.getClass();
					TypeId.INTEGER.getClass();
					// org.eclipse.ocl.examples.domain.types
					AbstractInheritance.initStatics();
					// org.eclipse.ocl.examples.domain.library
					UnsupportedOperation.INSTANCE.getClass();
					// org.eclipse.ocl.examples.domain.messages
					EvaluatorMessages.InvalidOperation.getClass();
					new StatusCodes();
					// org.eclipse.ocl.examples.domain.types
					AbstractInheritance.initStatics();
					// org.eclipse.ocl.examples.domain.utilities
					DomainUtil.createNumberFromString("0");
					StandaloneProjectMap.initStatics();
					// org.eclipse.ocl.examples.domain.validation
					DomainSubstitutionLabelProvider.INSTANCE.getClass();
					// org.eclipse.ocl.examples.domain.values
					ValuesPackage.eINSTANCE.getClass();
					// org.eclipse.ocl.examples.domain.values.impl
					CollectionValueImpl.initStatics();
					RealValueImpl.initStatics();
					// org.eclipse.ocl.examples.domain.values.util
//					new ValuesAdapterFactory();
//					new ValuesSwitch<Object>();
					return true;
				}
			}
		}
		return false;
	}

	public static @NonNull IntegerValue integerValueOf(int value) {
		if (value > -NEGATIVE_INTEGERS) {
			if (value < POSITIVE_INTEGERS) {
				int index = value + NEGATIVE_INTEGERS;
				IntegerValue integerValue = INTEGER_VALUES[index];
				if (integerValue != null) {
					return integerValue;
				}
				synchronized (INTEGER_VALUES) {
					integerValue = INTEGER_VALUES[index];
					if (integerValue != null) {
						return integerValue;
					}
					return INTEGER_VALUES[index] = new IntIntegerValueImpl(value);
				}
			}			
		}
		return new IntIntegerValueImpl(value);
	}

	public static @NonNull IntegerValue integerValueOf(long value) {
		if ((Integer.MIN_VALUE <= value) && (value <= Integer.MAX_VALUE)) {
			return new IntIntegerValueImpl((int) value);
		}
		else {
			return new LongIntegerValueImpl(value);
		}
	}
	
	public static @NonNull IntegerValue integerValueOf(@Nullable BigInteger value) {
		if (value == null) {
			throw new InvalidValueException(EvaluatorMessages.InvalidInteger, value);
		}
		else if (value.signum() >= 0) {
			if (value.compareTo(INTEGER_MAX_VALUE) <= 0) {
				return new IntIntegerValueImpl(value.intValue());
			}
			if (value.compareTo(LONG_MAX_VALUE) <= 0) {
				return new LongIntegerValueImpl(value.longValue());
			}
		}
		else {
			if (value.compareTo(INTEGER_MIN_VALUE) >= 0) {
				return new IntIntegerValueImpl(value.intValue());
			}
			if (value.compareTo(LONG_MIN_VALUE) >= 0) {
				return new LongIntegerValueImpl(value.longValue());
			}
		}
		return new BigIntegerValueImpl(value);
	}
    
	public static @NonNull IntegerValue integerValueOf(@Nullable Object aValue) {
		if (aValue instanceof BigInteger) {
			return new BigIntegerValueImpl((BigInteger)aValue);
		}
		else if (aValue instanceof Unlimited) {
			return UNLIMITED_VALUE;
		}
		else if (aValue instanceof Number) {
			return integerValueOf(((Number)aValue).longValue());
		}
		else if (aValue instanceof Character) {
			return integerValueOf(((Character)aValue).charValue());
		}
		else if (aValue instanceof IntegerValue) {
			return (IntegerValue)aValue;					// Never happens
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.InvalidInteger, aValue);
		}
	}
	
	/**
	 * Creates a BigInteger representation for aValue.
	 * @param aValue the string representation of a (non-negative) integer number
	 * @return the numeric representation
	 */
	public static @NonNull IntegerValue integerValueOf(@NonNull String aValue) {
		try {
			int len = aValue.length();
			if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
				@SuppressWarnings("null") @NonNull BigInteger result = BigInteger.valueOf(Long.parseLong(aValue));
				return integerValueOf(result);
			}
			else {
				return integerValueOf(new BigInteger(aValue));
			}
		}
		catch (NumberFormatException e) {
			throw new InvalidValueException(e, EvaluatorMessages.InvalidInteger, aValue);
		}
	}

	public static boolean isBoxed(@Nullable Object object) {
		if (object instanceof NullValue) {
			return false;
		}
		if (object instanceof DomainEnumerationLiteral) {
			return false;
		}
		if (object instanceof EEnumLiteral) {
			return false;
		}
		if (object instanceof Enumerator) {
			return false;
		}
		if ((object instanceof Number) && !(object instanceof RealValue)) {
			return false;
		}
		if ((object instanceof Iterable<?>) && !(object instanceof CollectionValue)) {
			return false;
		}
		return true;
	}
	
	public static @Nullable CollectionValue isCollectionValue(@Nullable Object value) {
		if ((value instanceof CollectionValue) && !(value instanceof NullValue)) {
			return (CollectionValue)value;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Return true if aNumber is a known integer representation that can be converted to an IntegerValue.
	 * Returns false for other types including IntegerValue. 
	 */
	public static boolean isIntegerNumber(@NonNull Number aNumber) {
		return (aNumber instanceof BigInteger) || (aNumber instanceof Long) || (aNumber instanceof Integer) || (aNumber instanceof Short) || (aNumber instanceof Byte);
	}
	
	public static IntegerValue isIntegerValue(@Nullable Object value) {
		if ((value instanceof IntegerValue) && !(value instanceof NullValue)) {
			return (IntegerValue)value;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Return true if aNumber is a known floating point representation that can be converted to a RealValue.
	 * Returns false for other types including RealValue. 
	 */
	public static boolean isRealNumber(@NonNull Number aNumber) {
		return (aNumber instanceof BigDecimal) || (aNumber instanceof Double) || (aNumber instanceof Float);
	}

	public static boolean isUnboxed(Object object) {
		if (object instanceof NullValue) {
			return false;
		}
		if (object instanceof ElementId) {
			return false;
		}
		if (object instanceof RealValue) {
			return false;
		}
		if (object instanceof CollectionValue) {
			return false;
		}
		return true;
	}

	public static boolean isUnlimited(@Nullable Object value) {
		return (value instanceof UnlimitedValue) && !(value instanceof NullValue);
	}

	public static @NonNull String oclToString(@NonNull Object value) {
		@SuppressWarnings("null") @NonNull String result = value.toString();
		return result;
	}

	public static @NonNull RealValue realValueOf(double value) {
		return new RealValueImpl(value);
	}

	public static @NonNull RealValue realValueOf(@Nullable BigDecimal value) {
		if (value != null) {
			return new RealValueImpl(value);
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, value);
		}
	}

	public static @NonNull RealValue realValueOf(@Nullable IntegerValue integerValue) {
		if (integerValue == null) {
			throw new InvalidValueException(EvaluatorMessages.InvalidInteger, integerValue);
		}
		try {
			return realValueOf(integerValue.bigDecimalValue());
		} catch (InvalidValueException e) {
			throw new InvalidValueException(e, EvaluatorMessages.InvalidInteger, integerValue);
		}
	}
    
	public static @NonNull RealValue realValueOf(@Nullable Number aNumber) {
		if (aNumber instanceof RealValue) {
			return (RealValue)aNumber;
		}
		else if (aNumber instanceof BigDecimal) {
			return new RealValueImpl((BigDecimal)aNumber);
		}
		else if (aNumber instanceof BigInteger) {
			return new RealValueImpl(new BigDecimal((BigInteger)aNumber));
		}
		else if (aNumber instanceof Unlimited) {
			return new RealValueImpl(Double.POSITIVE_INFINITY);
		}
		else if (aNumber != null) {
			return new RealValueImpl(aNumber.doubleValue());
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, aNumber);
		}
	}
	
	public static @NonNull RealValue realValueOf(@NonNull String aValue) {
		try {
			return new RealValueImpl(new BigDecimal(aValue.trim()));
		}
		catch (NumberFormatException e) {
			throw new InvalidValueException(e, EvaluatorMessages.InvalidReal, aValue);
		}
	}

	public static @NonNull String stringValueOf(@Nullable Object aValue) {
		String stringValue = null;
		if (aValue == null) {
			stringValue = NULL_STRING;
		}
//		else if (aValue instanceof Value) {
//			return ((Value)aValue).toString();
//		}
		else if (aValue instanceof String) {
			stringValue = "'" + DomainUtil.convertToOCLString((String)aValue) + "'";
		}
//		else if (aValue instanceof DomainType) {
//			return String.valueOf(aValue);
//		}
//		else if (aValue instanceof DomainEnumerationLiteral) {
//			return String.valueOf(aValue);
//		}
//		else if (aValue instanceof EEnumLiteral) {
//			return String.valueOf(aValue);
//		}
		else if ((aValue instanceof EObject) &&
			!((aValue instanceof DomainElement) || (aValue instanceof EEnumLiteral))) {
			stringValue = DomainUtil.getLabel((EObject) aValue);
		}
		else if (aValue.getClass().isArray()) {
			throw new UnsupportedOperationException();			// Must invoke DomainStandardLibrary.valueOf() for aggregates
		}
		else if (aValue instanceof Iterable<?>) {
			throw new UnsupportedOperationException();			// Must invoke DomainStandardLibrary.valueOf() for aggregates
		}
		else {
			stringValue = String.valueOf(aValue);
		}
		return stringValue != null ? stringValue : "<<null>>"; 
	}

	public static boolean throwBooleanInvalidValueException(@NonNull String string) {
		throw new InvalidValueException(string);
	}

	/**
	 * Throw an InvalidValueException without subsequent code appearing to be unreachable.
	 */
	public static Object throwInvalidValueException() {
		throw new InvalidValueException("invalid");
	}
	
	public static void toString(@Nullable Object value, @NonNull StringBuilder s, int sizeLimit) {
		if (value instanceof Value) {
			((Value)value).toString(s, sizeLimit);
		}
		else if (value instanceof String) {
			s.append("'");
			toStringWithLimit(s, (String)value, sizeLimit);
			s.append("'");
		}
		else if (value != null) {
			toStringWithLimit(s, value.toString(), sizeLimit);
		}
		else {
			toStringWithLimit(s, NULL_STRING, sizeLimit);
		}
	}

	private static void toStringWithLimit(@NonNull StringBuilder s, String string, int sizeLimit) {
		int length = string.length();
		int available = sizeLimit - (length + 1);
		if (length <= available) {
			s.append(string);
		}
		else {
			if (available > 0) {
				s.append(string.substring(0, available));
			}
			s.append("...");
		}
	}
}

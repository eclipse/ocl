/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.UnlimitedValue;
import org.eclipse.ocl.examples.domain.values.Value;

/**
 * @generated NOT
 */
public abstract class UndefinedValueImpl extends DomainException implements NullValue
{	
	private static final long serialVersionUID = 1L;

	private static class Iterator implements java.util.Iterator<Object>
	{
		public boolean hasNext() {
			return false;
		}

		public Object next() {
			return null;
		}

		public void remove() {
		}
	}

	protected UndefinedValueImpl(@Nullable String message, @Nullable Throwable cause) {
		super(message, cause);
	}

	public @NonNull NullValue abs() {
		return toInvalidValue();
	}

	public @NonNull NullValue addInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue addReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull OrderedCollectionValue append(@Nullable Object object) {
		return toInvalidValue();
	}

	public @NonNull OrderedCollectionValue appendAll(@NonNull OrderedCollectionValue objects) {
		return toInvalidValue();
	}

	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName());
	}

	public @NonNull Collection<Object> asCollection() {
		throw new InvalidValueException("Collection value required");
	}

	public @NonNull CollectionValue asCollectionValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, getTypeName());
	}

	public @NonNull Double asDouble() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Double", getTypeName());
	}
	
	public @NonNull <T> List<T> asEcoreObjects(@NonNull IdResolver idResolver, @NonNull Class<T> elementClass) {
		throw new InvalidValueException(this, "asEcoreObjects");
	}

	public @NonNull Integer asInteger() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	public @NonNull IntegerValue asIntegerValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	public @NonNull List<Object> asList() {
		throw new InvalidValueException("List value required");
	}

	public @NonNull EObject asNavigableObject() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getTypeName());
	}

	public @NonNull Number asNumber() {
		throw new InvalidValueException("undefined value has no Number value");
	}

	public @NonNull Object asObject() {
		return toInvalidValue();
	}

	public @NonNull ObjectValue asObjectValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getTypeName());
	}

	public @NonNull OrderedCollectionValue asOrderedCollectionValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.ORDERED_COLLECTION_NAME, getTypeName());
	}

	public @NonNull OrderedSetValue asOrderedSetValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.ORDERED_SET_NAME, getTypeName());
	}

	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.REAL_NAME, getTypeName());
	}

	public @NonNull SequenceValue asSequenceValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SEQUENCE_NAME, getTypeName());
	}

	public @NonNull SetValue asSetValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SET_NAME, getTypeName());
	}

	public @NonNull TupleValue asTupleValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.TUPLE_NAME, getTypeName());
	}

	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Unique Collection", getTypeName());
	}

	public @NonNull Value asUnlimitedNaturalValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.UNLIMITED_NATURAL_NAME, getTypeName());
	}

	public @Nullable Value at(int index) {
		return toInvalidValue();
	}

	public @NonNull BigDecimal bigDecimalValue() {
		throw new InvalidValueException("undefined value has no BigDecimal value");
	}

	public @NonNull BigInteger bigIntegerValue() {
		throw new InvalidValueException("undefined value has no BigInteger value");
	}
	
	public @NonNull RealValue commutatedAdd(@NonNull RealValue left) {
		return toInvalidValue();
	}
	
	public @NonNull IntegerValue commutatedDiv(@NonNull IntegerValue left) {
		return toInvalidValue();
	}
	
	public @NonNull RealValue commutatedDivide(@NonNull RealValue left) {
		return toInvalidValue();
	}
	
	public @NonNull IntegerValue commutatedMod(@NonNull IntegerValue left) {
		return toInvalidValue();
	}
	
	public @NonNull RealValue commutatedMultiply(@NonNull RealValue left) {
		return toInvalidValue();
	}
	
	public @NonNull RealValue commutatedSubtract(@NonNull RealValue left) {
		return toInvalidValue();
	}

	public int compareTo(/*@NonNull*/ RealValue o) {
		throw new UnsupportedOperationException("UndefinedValueImpl.compareTo");
	}

	public int compareToInteger(@NonNull IntegerValue right) {
		throw new UnsupportedOperationException("UndefinedValueImpl.compareTo");
	}

	public int compareToReal(@NonNull RealValue right) {
		throw new UnsupportedOperationException("UndefinedValueImpl.compareTo");
	}

	public int compareToUnlimited(@NonNull UnlimitedValue right) {
		throw new UnsupportedOperationException("UndefinedValueImpl.compareTo");
	}

    public @NonNull IntegerValue count(@Nullable Object value) {
        return toInvalidValue();
    }

	public @NonNull CollectionValue createNew() {
		return toInvalidValue();
	}

	public @NonNull NullValue div(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue divInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue divUnlimited(@NonNull UnlimitedValue right) {
		return toInvalidValue();
	}

	public @NonNull RealValue divideInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue divideReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public double doubleValue() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

    public @NonNull Boolean excludes(@Nullable Object value) {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
    }


    public @NonNull Boolean excludesAll(@NonNull CollectionValue c) {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
    }

	public @NonNull CollectionValue excluding(@Nullable Object value) {
		return toInvalidValue();
	}

	public @NonNull CollectionValue excludingAll(@NonNull CollectionValue c) {
		return toInvalidValue();
	}

    public @Nullable Value first() {
		return toInvalidValue();
	}

	public @NonNull CollectionValue flatten() {
    	return toInvalidValue();
    }

	public boolean flatten(@NonNull Collection<Object> flattenedElements) {
		return false;
	}

	public @NonNull NullValue floor() {
		return toInvalidValue();
	}

	public DomainType getElement() {
		return null;
	}
    
	public @NonNull List<? extends Object> getElements() {
		throw new InvalidValueException("bad getElements()");
	}

	public @NonNull DomainType getInstanceType() {
		throw new InvalidValueException("undefined value has no instance type");
	}
	
	public String getKind() {
	    return TypeId.COLLECTION_NAME;		// FIXME UOE ??
	}

	public Object getObject() {
		return null;
	}

	public abstract @NonNull OclVoidTypeId getTypeId();

	public @NonNull String getTypeName() {
		return getTypeId().getDisplayName();
	}

	public @NonNull Value getValue(@NonNull TuplePartId partId) {
    	return toInvalidValue();
	}

	public @NonNull Object getValue(int index) {
    	return toInvalidValue();
	}

    public @NonNull Boolean includes(@Nullable Object value) {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
    }

    public @NonNull Boolean includesAll(@NonNull CollectionValue c) {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
   }

	public @NonNull CollectionValue including(@Nullable Object value) {
		return toInvalidValue();
	}

	public @NonNull CollectionValue includingAll(@NonNull CollectionValue c) {
		return toInvalidValue();
	}

	public @NonNull IntegerValue indexOf(@Nullable Object object) {
		return toInvalidValue();
	}

	public @NonNull SequenceValue insertAt(int index, @Nullable Object object) {
		return toInvalidValue();
	}

	public int intSize() {
		return 0;
	}

	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) {
		return toInvalidValue();
	}

	public @NonNull Boolean isEmpty() {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
	}

	public boolean isFalse() {
		return false;
	}
	
	public @Nullable IntegerValue isIntegerValue() {
		return null;
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isTrue() {
		return false;
	}

	public boolean isUndefined() {
		return true;
	}

	public boolean isUnique() {
		return false;
	}

	public boolean isUnlimited() {
		return false;
	}
	
	public boolean isUnlimitedNatural() {
		return false;
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<? extends Object> iterable() {
		return Collections.<Object>emptyList();
	}

	public @NonNull Iterator iterator() {
		return new Iterator();
	}
	
	public @Nullable Value last() {
		return toInvalidValue();
	}

	public @NonNull NullValue max(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue maxInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue maxReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue maxUnlimited(@NonNull UnlimitedValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue min(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue minInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue minReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue minUnlimited(@NonNull UnlimitedValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue minus(@NonNull UniqueCollectionValue set) {
		return toInvalidValue();
	}

	public @NonNull NullValue modInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue modUnlimited(@NonNull UnlimitedValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue multiplyInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue multiplyReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue negate() {
		return toInvalidValue();
	}

	public @NonNull Boolean notEmpty() {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
	}

	public @NonNull OrderedCollectionValue prepend(@Nullable Object object) {
		return toInvalidValue();
	}

	public @NonNull OrderedCollectionValue prependAll(@NonNull OrderedCollectionValue objects) {
		return toInvalidValue();
	}

	public @Nullable Set<TupleValue> product(@NonNull CollectionValue c, @NonNull TupleTypeId tupleTypeId) {
		return null;
	}

	public @NonNull OrderedCollectionValue reverse() {
		return toInvalidValue();
	}

	public @NonNull NullValue round() {
		return toInvalidValue();
	}

	public int signum() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	public @NonNull IntegerValue size() {
    	return toInvalidValue();
	}

    public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
		return toInvalidValue();
	}

	public @NonNull String stringValue() {
		throw new InvalidValueException("undefined value has no String value");
	}

	public @NonNull NullValue subOrderedSet(int lower, int upper) {
		return toInvalidValue();
	}

	public @NonNull NullValue subSequence(int lower, int upper) {
		return toInvalidValue();
	}

	public @NonNull NullValue subtractInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue subtractReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	public @NonNull NullValue symmetricDifference(@NonNull UniqueCollectionValue set) {
		return toInvalidValue();
	}

	protected @NonNull NullValue toInvalidValue() {
		throw new InvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Invalid");
	}
    
	public @NonNull SequenceValue toSequenceValue() {
		return this;
	}

	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append(toString());
	}

	public @NonNull CollectionValue union(@NonNull CollectionValue c) {
        return this;
    }
}

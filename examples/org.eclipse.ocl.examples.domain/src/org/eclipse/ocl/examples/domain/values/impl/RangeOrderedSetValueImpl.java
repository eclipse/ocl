/*******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - split off from EvaluationVisitor
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.values.IntegerRange;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * @generated NOT
 */
public class RangeOrderedSetValueImpl extends OrderedSetValueImpl
{
	public RangeOrderedSetValueImpl(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
		super(typeId, range);
	}

	public @NonNull OrderedSetValue append(@Nullable Object value) {
		IntegerRange theElements = getElements();
		IntegerValue nextValue = theElements.getLast().addInteger(ONE_VALUE);
		if (nextValue.equals(value)) {
			IntegerRange range = createRange(theElements.getFirst(), nextValue);
			return new RangeOrderedSetValueImpl(getTypeId(), range);
		}
		else {
			List<Object> elements = createElements();
			elements.remove(value);
			elements.add(value);
			return new SparseOrderedSetValueImpl(getTypeId(), elements);
		}
	}

	@Override
	public @NonNull IntegerValue count(@Nullable Object value) {
		IntegerValue integerValue = ValuesUtil.isIntegerValue(value);
		if (integerValue != null) {
			if (elements.contains(integerValue)) {
				return ONE_VALUE;
			}
		}
		return ZERO_VALUE;
	}

	protected List<Object> createElements() {
		List<Object> elements = new ArrayList<Object>(intSize());
		for (Object value : iterable()) {
			elements.add(value);
		}
		return elements;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RangeOrderedSetValueImpl) {
			RangeOrderedSetValueImpl that = (RangeOrderedSetValueImpl)obj;
			return this.elements.equals(that.elements);
		}
		else {
			return super.equals(obj);
		}
	}

	public @Nullable Value first() {
		return getElements().getFirst();
	}

	public @NonNull OrderedSetValue flatten() {
		return this;
	}

	@Override
	public @NonNull IntegerRange getElements() {
		return (IntegerRange) elements;
	}

//    public Type getType(TypeManager typeManager, Type staticType) {
//    	if (type == null) {
//    		if ((elements.getFirst() >= 0) && (elements.getLast() >= 0)) {
//    			type = typeManager.getCollectionType(true, false, typeManager.getUnlimitedNaturalType());
//    		}
//    		else{
//    			type = typeManager.getCollectionType(true, false, typeManager.getIntegerType());
//    		}
//    	}
//		return type;
//	}

	public @NonNull OrderedSetValue including(@Nullable Object value) {
		return append(value);
	}

	public @Nullable Value last() {
		return getElements().getLast();
	}

	public @NonNull OrderedSetValue prepend(@Nullable Object value) {
		IntegerRange theElements = getElements();
		IntegerValue previousValue = theElements.getFirst().subtractInteger(ONE_VALUE);
		if (previousValue.equals(value)) {
			IntegerRange range = createRange(previousValue, theElements.getLast());
			return new RangeOrderedSetValueImpl(getTypeId(), range);
		}
		else {
			List<Object> elements = createElements();
			elements.remove(value);
			elements.add(0, value);
			return new SparseOrderedSetValueImpl(getTypeId(), elements);
		}
	}

	public SequenceValue toSequenceValue() {
		return new RangeSequenceValueImpl(getSequenceTypeId(), getElements());
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("OrderedSet{");
		IntegerRange theElements = getElements();
		s.append(theElements.getFirst());
		s.append("..");
		s.append(theElements.getLast());
		s.append("}");
		s.toString();
	}
}
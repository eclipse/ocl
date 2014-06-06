/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * @generated NOT
 */
public abstract class SequenceValueImpl extends CollectionValueImpl implements SequenceValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.SEQUENCE_VALUE;
	}

	public SequenceValueImpl(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> values) {
		super(typeId, values);
	}

    public @NonNull OrderedCollectionValue append(@Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(EvaluatorMessages.InvalidSource, "append");
		}
    	List<Object> result = new ArrayList<Object>(elements);
        result.add(object);
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

    public @NonNull OrderedCollectionValue appendAll(@NonNull OrderedCollectionValue objects) {
    	List<Object> result = new ArrayList<Object>(elements);
        result.addAll(objects.getElements());
        return new SparseSequenceValueImpl(getTypeId(), result);
    }
	
	@Override
	public @NonNull List<? extends Object> asList() {
		return getElements();
	}

    @Override
	public @NonNull OrderedCollectionValue asOrderedCollectionValue() {
		return this;
	}

    @Override
	public @NonNull SequenceValue asSequenceValue() {
        return this;
    }

    public @Nullable Object at(int index) {
        index = index - 1;        
        if (index < 0 || elements.size() <= index) {
        	throw new InvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
		}        
        return getElements().get(index);
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SequenceValue) || (obj instanceof OrderedSetValue)) {
			return false;
		}
		Iterator<? extends Object> theseElements = iterator();
		Iterator<? extends Object> thoseElements = ((SequenceValue)obj).iterator();
		while (theseElements.hasNext() && thoseElements.hasNext()) {
			Object thisValue = theseElements.next();
			Object thatValue = thoseElements.next();
			if (!thisValue.equals(thatValue)) {
				return false;
			}
		}
		return !theseElements.hasNext() && !thoseElements.hasNext();
	}

	public @NonNull SequenceValue excluding(@Nullable Object value) {
		List<Object> result = new ArrayList<Object>();
		if (value == null) {
			for (Object element : elements) {
				if (element != null) {
					result.add(element);
				}
			}
		}
		else {
			for (Object element : elements) {
				if (!value.equals(element)) {
					result.add(element);
				}
			}
		}
		if (result.size() < elements.size()) {
			return new SparseSequenceValueImpl(getTypeId(), result);
		}
		else {
			return this;
		}
	}

	public @NonNull SequenceValue excludingAll(@NonNull CollectionValue values) {
		List<Object> result = new ArrayList<Object>();
		for (Object element : elements) {
			boolean reject = false;
			if (element == null) {
				for (Object value : values) {
					if (value == null) {
						reject = true;
						break;
					}
				}
			}
			else {
				for (Object value : values) {
					if ((value != null) && value.equals(element)) {
						reject = true;
						break;
					}
				}
			}
			if (!reject) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new SparseSequenceValueImpl(getTypeId(), result);
		}
		else {
			return this;
		}
	}

    public @Nullable Object first() {
        if (elements.size() <= 0) {
        	throw new InvalidValueException(EvaluatorMessages.EmptyCollection, TypeId.SEQUENCE_NAME, "first");
        }
        return getElements().get(0);
    }

    public @NonNull SequenceValue flatten() {
    	List<Object> flattened = new ArrayList<Object>();
    	if (flatten(flattened)) {
    		return new SparseSequenceValueImpl(getTypeId(), flattened);
    	}
    	else {
    		return this;
    	}
    }

//    @Override
//	public @NonNull CollectionTypeId getCollectionTypeId() {
//		return TypeId.SEQUENCE;
//	}
    
	@Override
	public @NonNull List<? extends Object> getElements() {
		return (List<? extends Object>) elements;
	}
	
	public @NonNull String getKind() {
	    return TypeId.SEQUENCE_NAME;
	}
	   
	public @NonNull SequenceValue including(@Nullable Object value) {
		if (value instanceof InvalidValueException) {
			throw new InvalidValueException(EvaluatorMessages.InvalidSource, "including");
		}
		List<Object> result = new ArrayList<Object>(elements);
		result.add(value);
		return new SparseSequenceValueImpl(getTypeId(), result);
	}

	public @NonNull SequenceValue includingAll(@NonNull CollectionValue values) {
		List<Object> result = new ArrayList<Object>(elements);
		for (Object value : values) {
			result.add(value);
		}
		return new SparseSequenceValueImpl(getTypeId(), result);
	}

    public @NonNull IntegerValue indexOf(@Nullable Object object) {
        int index = getElements().indexOf(object);
        if (index < 0) {
        	throw new InvalidValueException(EvaluatorMessages.MissingValue, "indexOf");
        }
    	return ValuesUtil.integerValueOf(index+1);
    }

    public @NonNull SequenceValue insertAt(int index, @Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(EvaluatorMessages.InvalidSource, "insertAt");
		}
        index = index - 1;        
        if (index < 0 || index > elements.size()) {
        	throw new InvalidValueException(EvaluatorMessages.IndexOutOfRange, index + 1, size());
        }        
		List<Object> result = new ArrayList<Object>(elements);
		result.add(index, object);
		return new SparseSequenceValueImpl(getTypeId(), result);
    }

	public boolean isOrdered() {
		return true;
	}

	public boolean isUnique() {
		return false;
	}
   
    public @Nullable Object last() {
        int size = elements.size();
		if (size <= 0) {
			throw new InvalidValueException(EvaluatorMessages.EmptyCollection, TypeId.SEQUENCE_NAME, "last");
        }
        return getElements().get(size-1);
    }

    public @NonNull SequenceValue prepend(@Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(EvaluatorMessages.InvalidSource, "prepend");
		}
    	List<Object> result = new ArrayList<Object>();
        result.add(object);
        result.addAll(elements);
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

    public @NonNull SequenceValue prependAll(@NonNull OrderedCollectionValue objects) {
    	List<Object> result = new ArrayList<Object>(objects.getElements());
        result.addAll(elements);
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

	public @NonNull SequenceValue reverse() {
		List<Object> elements = new ArrayList<Object>(this.elements);
		Collections.reverse(elements);
        return new SparseSequenceValueImpl(getTypeId(), elements);
    }
	   
    public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return new SparseSequenceValueImpl(getTypeId(), values);
    }
	
    /**
     * Implementation of the OCL
     * <tt>Sequence::subSequence(lower : Integer, upper : Integer) : Sequence(T)</tt></li>
     * operation.
     * 
     * @param lower the 1-based (in OCL fashion) inclusive lower bound
     * @param upper the 1-based (in OCL fashion) inclusive upper bound
     * @return the source collection with the object inserted at the index
     * 
     * @throws IndexOutOfBoundsException if an index is out of bounds
     * @throws IllegalArgumentException if the lower bound is greater than the upper
     */
    public @NonNull SequenceValue subSequence(int lower, int upper) {
        lower = lower - 1;
        upper = upper - 1;
        
        if (lower < 0) {
			throw new InvalidValueException(new IndexOutOfBoundsException("lower: " + (lower + 1))); //$NON-NLS-1$
        } else if (upper >= elements.size()) {
			throw new InvalidValueException(new IndexOutOfBoundsException(
				"upper: " + (upper + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size()));
        } else if (upper < lower) {
			throw new InvalidValueException(new IllegalArgumentException(
				"lower: " + (lower + 1) + ", upper: " //$NON-NLS-1$ //$NON-NLS-2$
					+ (upper + 1)));
        }
        
		List<Object> result = new ArrayList<Object>();
        int curr = 0;
        for (Object object : iterable()) {
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

	public @NonNull SequenceValue toSequenceValue() {
		return this;
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append(TypeId.SEQUENCE_NAME);
		super.toString(s, lengthLimit);
	}
}

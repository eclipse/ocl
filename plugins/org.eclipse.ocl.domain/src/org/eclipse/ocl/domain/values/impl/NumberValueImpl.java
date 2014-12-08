/*******************************************************************************
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.values.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainElement;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.BagValue;
import org.eclipse.ocl.domain.values.CollectionValue;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.NumberValue;
import org.eclipse.ocl.domain.values.OCLValue;
import org.eclipse.ocl.domain.values.ObjectValue;
import org.eclipse.ocl.domain.values.OrderedCollectionValue;
import org.eclipse.ocl.domain.values.OrderedSetValue;
import org.eclipse.ocl.domain.values.RealValue;
import org.eclipse.ocl.domain.values.SequenceValue;
import org.eclipse.ocl.domain.values.SetValue;
import org.eclipse.ocl.domain.values.TupleValue;
import org.eclipse.ocl.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.Value;
import org.eclipse.ocl.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class NumberValueImpl extends Number implements NumberValue
{
	private static final long serialVersionUID = 1L;

	static class EmptyIterator implements Iterator<Value>
    {
        @Override
		public boolean hasNext() {
            return false;
        }
        @Override
		public Value next() {
            throw new NoSuchElementException();
        }
        @Override
		public void remove() {
            throw new IllegalStateException();
        }
    }

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.VALUE;
	}

	protected NumberValueImpl() {}

	@Override
	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName());
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, getTypeName());
	}

	@Override
	public @NonNull Double asDouble() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Double", getTypeName());
	}

	@Override
	public DomainElement asElement() {
		return null;
	}

	@Override
	public @NonNull Integer asInteger() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	@Override
	public @NonNull IntegerValue asIntegerValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		Object object = asObject();
		if (object instanceof EObject) {
			return (EObject) object;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getTypeName());
		}
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getTypeName());
	}

	@Override
	public @NonNull OrderedCollectionValue asOrderedCollectionValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.ORDERED_COLLECTION_NAME, getTypeName());
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.ORDERED_SET_NAME, getTypeName());
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.REAL_NAME, getTypeName());
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SEQUENCE_NAME, getTypeName());
	}

	@Override
	public @NonNull SetValue asSetValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.SET_NAME, getTypeName());
	}

	@Override
	public @NonNull TupleValue asTupleValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.TUPLE_NAME, getTypeName());
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Unique Collection", getTypeName());
	}

	@Override
	public @NonNull UnlimitedNaturalValue asUnlimitedNaturalValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.UNLIMITED_NATURAL_NAME, getTypeName());
	}

//	public @NonNull DomainType getActualType(@NonNull DomainStandardLibrary standardLibrary) {
//		return getType(standardLibrary);
//	}

	public @NonNull String getTypeName() {
		return getTypeId().getDisplayName();
	}

	@Override
	public boolean isInvalid() {
		return false;
	}

	@Override
	public boolean isUndefined() {
		return false;
	}
	
	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		return equals(thatValue);
	}

	@Override
	public int oclHashCode() {
		return hashCode();
	}

	@Override
	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append(toString());
	}
}

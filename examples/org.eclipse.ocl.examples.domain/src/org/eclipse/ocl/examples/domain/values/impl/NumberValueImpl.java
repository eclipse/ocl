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
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.OCLValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.Value;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class NumberValueImpl extends Number implements Value
{
	private static final long serialVersionUID = 1L;

	static class EmptyIterator implements Iterator<Value>
    {
        public boolean hasNext() {
            return false;
        }
        public Value next() {
            throw new NoSuchElementException();
        }
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

	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName());
	}

	public @NonNull CollectionValue asCollectionValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.COLLECTION_NAME, getTypeName());
	}

	public @NonNull Double asDouble() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Double", getTypeName());
	}
	
	@Deprecated // Use asEcoreObject(@NonNull IdResolver idResolver)
	public @Nullable Object asEcoreObject() {
		return asObject();
	}

	public DomainElement asElement() {
		return null;
	}

	public @NonNull Integer asInteger() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	public @NonNull IntegerValue asIntegerValue() {
		throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	public @NonNull EObject asNavigableObject() {
		Object object = asObject();
		if (object instanceof EObject) {
			return (EObject) object;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, "Object", getTypeName());
		}
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

//	public @NonNull DomainType getActualType(@NonNull DomainStandardLibrary standardLibrary) {
//		return getType(standardLibrary);
//	}

	public @NonNull String getTypeName() {
		return getTypeId().getDisplayName();
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isUndefined() {
		return false;
	}
	
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		return equals(thatValue);
	}

	public int oclHashCode() {
		return hashCode();
	}

	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append(toString());
	}
}

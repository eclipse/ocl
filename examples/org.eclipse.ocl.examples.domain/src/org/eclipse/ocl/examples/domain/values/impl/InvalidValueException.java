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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.OclInvalidTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.BagValue;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.InvalidValue;
import org.eclipse.ocl.examples.domain.values.OCLValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.OrderedSetValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.SequenceValue;
import org.eclipse.ocl.examples.domain.values.SetValue;
import org.eclipse.ocl.examples.domain.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * An InvalidValueException wraps an InvalidValue and is used to return the InvalidValue
 * to the caller. Exceptions are a
 * is thrown when an Invalid Value arises during
 * an evaluation, and when no EvaluationEnvironment is available to support
 * throwing an InvalidEvaluationException. When such an environment is
 * available the InvalidValueException is rethrown as an 
 * InvalidEvaluationException.
 *
 * * @generated NOT
 */
public class InvalidValueException extends UndefinedValueImpl implements InvalidValue
{	
	private static final long serialVersionUID = 1L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.INVALID_VALUE;
	}
	
	public InvalidValueException(@Nullable Exception exception, /*@NonNull*/ String message) {
		super(message, exception);
		assert !(exception instanceof InvalidValueException);
	}

	public InvalidValueException(/*@NonNull*/ String messageTemplate, Object... bindings) {
		this(null, DomainUtil.bind(messageTemplate, bindings));
	}

	public InvalidValueException(@NonNull Exception exception) {
		super(null, exception);
		assert !(exception instanceof InvalidValueException);
	}

	public InvalidValueException(@Nullable Exception exception, /*@NonNull*/ String messageTemplate, Object... bindings) {
		this(exception, DomainUtil.bind(messageTemplate, bindings));
	}

	@Override
	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(this, "asBagValue");
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		throw new InvalidValueException(this, "asCollectionValue");
	}

	@Override
	public @NonNull Double asDouble() {
		throw new InvalidValueException(this, "asDouble");
	}
	
	@Deprecated // Use asEcoreObject(@NonNull IdResolver idResolver)
	public @NonNull List<Object> asEcoreObject() {
		throw new InvalidValueException(this, "asEcoreObject");
	}
	
	public @NonNull List<Object> asEcoreObject(@NonNull IdResolver idResolver) {
		throw new InvalidValueException(this, "asEcoreObject");
	}

	public DomainElement asElement() {
		throw new InvalidValueException(this, "asElement");
	}

	@Override
	public @NonNull Integer asInteger() {
		throw new InvalidValueException(this, "asInteger");
	}

	@Override
	public @NonNull IntegerValue asIntegerValue() {
		throw new InvalidValueException(this, "asIntegerValue");
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		throw new InvalidValueException(this, "asNavigableObject");
	}

	@Override
	public @NonNull Number asNumber() {
		throw new InvalidValueException(this, "asNumberValue");
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		throw new InvalidValueException(this, "asObjectValue");
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
		throw new InvalidValueException(this, "asOrderedSetValue");
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(this, "asRealValue");
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		throw new InvalidValueException(this, "asSequenceValue");
	}

	@Override
	public @NonNull SetValue asSetValue() {
		throw new InvalidValueException(this, "asSetValue");
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
		throw new InvalidValueException(this, "asUniqueCollectionValue");
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof InvalidValueException;
	}

	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getOclInvalidType();
	}

	@Override
	public @NonNull OclInvalidTypeId getTypeId() {
		return TypeId.OCL_INVALID;
	}

	public int intValue() {
    	toInvalidValue();		// throws rather than returns
    	return 0;
	}

	@Override
	public int hashCode() {
		return 0x22222222;
	}

	public boolean isInvalid() {
		return true;
	}

	public boolean oclEquals(@NonNull OCLValue thatValue) {
		return equals(thatValue);
	}

	public int oclHashCode() {
		return hashCode();
	}

//	@Override
//	public String toString() {
//		if (exception != null) {
//			return Value.INVALID_NAME + "<" + exception.getMessage() + ">";
//		}
//		else {
//			return exception.getMessage(); //Value.INVALID_NAME;
//		}
//	}
}

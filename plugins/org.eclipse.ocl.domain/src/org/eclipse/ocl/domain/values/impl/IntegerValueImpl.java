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
package org.eclipse.ocl.domain.values.impl;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.ComparableValue;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.NumberValue;
import org.eclipse.ocl.domain.values.RealValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.UnlimitedValue;
import org.eclipse.ocl.domain.values.ValuesPackage;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.pivot.Type;

/**
 * @generated NOT
 */
public abstract class IntegerValueImpl extends NumberValueImpl implements IntegerValue, UnlimitedNaturalValue
{
	private static final long serialVersionUID = 1L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.INTEGER_VALUE;
	}

	@Override
	public @NonNull RealValue addReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = bigDecimalValue().add(rightValue.bigDecimalValue());
			return ValuesUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}
	
	@Override
	public @NonNull IntegerValue asIntegerValue() {
		return this;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		return this;
	}

	@Override
	public @NonNull UnlimitedNaturalValue asUnlimitedNaturalValue() {
		if (isUnlimitedNatural()) {
			return this;
		}
		else {
			return super.asUnlimitedNaturalValue();
		}
	}

	@Override
	public @NonNull RealValue commutatedAdd(@NonNull RealValue left) {
		return left.addInteger(this);
	}

	@Override
	public int commutatedCompareTo(@NonNull ComparableValue<?> left) {
		if (left instanceof NumberValue) {
			return ((NumberValue)left).commutatedCompareToReal(this);
		}
		else {
			return ValuesUtil.throwUnsupportedCompareTo(left, this);
		}
	}

	@Override
	public int commutatedCompareToReal(@NonNull RealValue left) {
		return bigDecimalValue().compareTo(left.bigDecimalValue());
	}

	@Override
	public @NonNull IntegerValue commutatedDiv(@NonNull IntegerValue left) {
		return left.divInteger(this);
	}

	@Override
	public @NonNull RealValue commutatedDivide(@NonNull RealValue left) {
		return left.divideInteger(this);
	}

	@Override
	public @NonNull IntegerValue commutatedMod(@NonNull IntegerValue left) {
		return left.modInteger(this);
	}

	@Override
	public @NonNull RealValue commutatedMultiply(@NonNull RealValue left) {
		return left.multiplyInteger(this);
	}

	@Override
	public @NonNull RealValue commutatedSubtract(@NonNull RealValue left) {
		return left.subtractInteger(this);
	}

	@Override
	public int compareTo(@Nullable NumberValue right) {
		if (right != null) {
			return -right.commutatedCompareToInteger(this);
		}
		else {
			return ValuesUtil.throwUnsupportedCompareTo(this, right);
		}
	}

	@Override
	public @NonNull IntegerValue divUnlimited(@NonNull UnlimitedValue right) {
		throw new InvalidValueException(EvaluatorMessages.InvalidOperation, "div", "UnlimitedValue");
	}

	@Override
	public @NonNull RealValue divideReal(@NonNull RealValue right) {
		return RealValueImpl.divideBigDecimal(bigDecimalValue(), right.bigDecimalValue());
	}

	@Override
	public @NonNull IntegerValue floor() {
		return this;
	}

	public @NonNull Type getType(@NonNull DomainStandardLibrary standardLibrary) {
		return isUnlimitedNatural() ? standardLibrary.getUnlimitedNaturalType() : standardLibrary.getIntegerType();
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return TypeId.INTEGER;
	}
	
	@Override
	public @Nullable IntegerValue isIntegerValue() {
		return this;
	}

	@Override
	public boolean isUnlimited() {
		return false;
	}
	
	@Override
	public boolean isUnlimitedNatural() {
		return signum() >= 0;
	}

	@Override
	public @Nullable UnlimitedNaturalValue isUnlimitedNaturalValue() {
		return signum() >= 0 ?this : null;
	}

	@Override
	public @NonNull RealValue max(@NonNull RealValue rightValue) {
		return rightValue.maxInteger(this);
	}

	@Override
	public @NonNull UnlimitedNaturalValue max(@NonNull UnlimitedNaturalValue rightValue) {
		return rightValue.maxUnlimited(this);
	}

	@Override
	public @NonNull RealValue maxReal(@NonNull RealValue right) {
		BigDecimal bigDecimalValue = bigDecimalValue();
		return bigDecimalValue.compareTo(right.bigDecimalValue()) > 0 ? ValuesUtil.realValueOf(bigDecimalValue) : right;
	}

	@Override
	public @NonNull UnlimitedNaturalValue maxUnlimited(@NonNull UnlimitedNaturalValue rightValue) {
		return rightValue;
	}

	@Override
	public @NonNull RealValue min(@NonNull RealValue rightValue) {
		return rightValue.minInteger(this);
	}

	@Override
	public @NonNull UnlimitedNaturalValue min(@NonNull UnlimitedNaturalValue rightValue) {
		return rightValue.minUnlimited(this);
	}

	@Override
	public @NonNull RealValue minReal(@NonNull RealValue right) {
		BigDecimal bigDecimalValue = bigDecimalValue();
		return bigDecimalValue.compareTo(right.bigDecimalValue()) < 0 ? ValuesUtil.realValueOf(bigDecimalValue) : right;
	}

	@Override
	public @NonNull UnlimitedNaturalValue minUnlimited(@NonNull UnlimitedNaturalValue rightValue) {
		return this;
	}

	@Override
	public @NonNull IntegerValue modUnlimited(@NonNull UnlimitedValue right) {
		throw new InvalidValueException(EvaluatorMessages.InvalidOperation, "mod", "UnlimitedValue");
	}

	@Override
	public @NonNull RealValue multiplyReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = bigDecimalValue().multiply(rightValue.bigDecimalValue());
			return ValuesUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull IntegerValue round() {
		return this;
	}

	@Override
	public @NonNull RealValue subtractReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = bigDecimalValue().subtract(rightValue.bigDecimalValue());
			return ValuesUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(EvaluatorMessages.InvalidReal, e, null, rightValue);
		}
	}
}

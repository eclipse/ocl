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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.RealValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * @generated NOT
 */
public class BigIntegerValueImpl extends IntegerValueImpl
{
	private static final long serialVersionUID = 6202182719851208124L;

	private final @NonNull BigInteger value;
	
	@SuppressWarnings("null")
	public BigIntegerValueImpl(long value) {
		this(BigInteger.valueOf(value));
	}

	public BigIntegerValueImpl(@NonNull BigInteger value) {
		this.value = value;
		assert value != null;
	}

	@Override
	public @NonNull IntegerValue abs() {
		@SuppressWarnings("null") @NonNull BigInteger result = value.abs();
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public @NonNull IntegerValue addInteger(@NonNull IntegerValue right) {
		@SuppressWarnings("null") @NonNull BigInteger result = value.add(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public @NonNull Double asDouble() {
		@SuppressWarnings("null") @NonNull Double result = value.doubleValue();
		return result;
	}

	@Override
	public @NonNull Object asEcoreObject(@NonNull IdResolver idResolver) {
		return value;
	}
	
	@Override
	public @NonNull Integer asInteger() {
		@SuppressWarnings("null") @NonNull Integer result = Integer.valueOf(intValue());
		return result;
	}
	
	@Override
	public @NonNull Number asNumber() {
		return value;
	}

	@Override
	public @NonNull Object asObject() {
		return value;
	}

	@Override
	public @NonNull BigDecimal bigDecimalValue() {
		return new BigDecimal(value);
	}

	@Override
	public @NonNull BigInteger bigIntegerValue() {
		return value;
	}

	@Override
	public int compareToInteger(@NonNull IntegerValue o) {
		try {
			return value.compareTo(o.bigIntegerValue());
		} catch (InvalidValueException e) {
			return this.hashCode() - o.hashCode();
		}
	}

	@Override
	public @NonNull IntegerValue divInteger(@NonNull IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			throw new InvalidValueException("div zero");
		}
		@SuppressWarnings("null") @NonNull BigInteger result = value.divide(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public @NonNull RealValue divideInteger(@NonNull IntegerValue right) {
		BigDecimal bigLeft = bigDecimalValue();
		BigDecimal bigRight = right.bigDecimalValue();
		return RealValueImpl.divideBigDecimal(bigLeft, bigRight);
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof IntegerValue) {
				BigInteger bigIntegerValue = ((IntegerValue)obj).bigIntegerValue();
				return value.compareTo(bigIntegerValue) == 0;
			}
			if (obj instanceof RealValue) {
				BigDecimal bigDecimalValue = ((RealValue)obj).bigDecimalValue();
				return bigDecimalValue().compareTo(bigDecimalValue) == 0;
			}
		} catch (InvalidValueException e) {
		}
		return this == obj;
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public int intValue() {
		int intValue = value.intValue();
//		if (!BigInteger.valueOf(intValue).equals(value)) {
//			throw new InvalidValueException("intValue() overflow");
//		}
		return intValue;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return signum() >= 0;
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public @NonNull IntegerValue maxInteger(@NonNull IntegerValue right) {
		return value.compareTo(right.bigIntegerValue()) >= 0 ? this : right;
	}

	@Override
	public @NonNull IntegerValue minInteger(@NonNull IntegerValue right) {
		return value.compareTo(right.bigIntegerValue()) <= 0 ? this : right;
	}

	@Override
	public @NonNull IntegerValue modInteger(@NonNull IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			throw new InvalidValueException("mod zero");
		}
		@SuppressWarnings("null") @NonNull BigInteger result = value.remainder(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public @NonNull IntegerValue multiplyInteger(@NonNull IntegerValue right) {
		@SuppressWarnings("null") @NonNull BigInteger result = value.multiply(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public @NonNull IntegerValue negate() {
		@SuppressWarnings("null") @NonNull BigInteger result = value.negate();
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public int signum() {
		return value.signum();
	}

	@Override
	public @NonNull IntegerValue subtractInteger(@NonNull IntegerValue right) {
		@SuppressWarnings("null") @NonNull BigInteger result = value.subtract(right.bigIntegerValue());
		return ValuesUtil.integerValueOf(result);
	}

	@Override
	public String toString() {
		return value.toString();
	}
}

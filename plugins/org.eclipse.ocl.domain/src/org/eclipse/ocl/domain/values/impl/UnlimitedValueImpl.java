/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.values.ComparableValue;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.NumberValue;
import org.eclipse.ocl.domain.values.RealValue;
import org.eclipse.ocl.domain.values.Unlimited;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.UnlimitedValue;
import org.eclipse.ocl.domain.values.ValuesPackage;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;

/**
 * @generated NOT
 */
public class UnlimitedValueImpl extends NumberValueImpl implements UnlimitedValue
{
	private static final long serialVersionUID = 8556985089778234910L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.UNLIMITED_VALUE;
	}

	public UnlimitedValueImpl() {}

	@Override
	public @NonNull Object asEcoreObject(@NonNull IdResolver idResolver) {
		return Unlimited.INSTANCE;
	}

	@Override
	public @NonNull Object asObject() {
		return Unlimited.INSTANCE;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(EvaluatorMessages.InvalidOperation, "asRealValue", "UnlimitedValue");
	}

	@Override
	public @NonNull UnlimitedNaturalValue asUnlimitedNaturalValue() {
		return this;
	}

	@Override
	public int commutatedCompareTo(@NonNull ComparableValue<?> left) {
		if (left instanceof UnlimitedNaturalValue) {
			if (((UnlimitedNaturalValue)left).isUnlimited()) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return ValuesUtil.throwUnsupportedCompareTo(left, this);
		}
	}

	@Override
	public int commutatedCompareToInteger(@NonNull IntegerValue left) {
		return 1;
	}

	@Override
	public int commutatedCompareToReal(@NonNull RealValue left) {
		return 1;
	}

	@Override
	public int compareTo(@Nullable NumberValue right) {
		if (right instanceof UnlimitedNaturalValue) {
			if (((UnlimitedNaturalValue)right).isUnlimited()) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else if (right != null) {
			return -right.commutatedCompareTo(this);
		}
		else {
			return ValuesUtil.throwUnsupportedCompareTo(this, right);
		}
	}

	@Override
	public double doubleValue() {
		throw new InvalidValueException(EvaluatorMessages.InvalidReal, null, null, this);
	}

	@Override
	public float floatValue() {
		throw new InvalidValueException(EvaluatorMessages.InvalidReal, null, null, this);
	}

	public @NonNull Type getType(@NonNull StandardLibrary standardLibrary) {
		return standardLibrary.getUnlimitedNaturalType();
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return TypeId.UNLIMITED_NATURAL;
	}

	@Override
	public int intValue() {
		throw new InvalidValueException(EvaluatorMessages.InvalidInteger, null, null, this);
	}

	@Override
	public boolean isUnlimited() {
		return true;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return true;
	}

	@Override
	public @Nullable UnlimitedNaturalValue isUnlimitedNaturalValue() {
		return this;
	}

	@Override
	public long longValue() {
		throw new InvalidValueException(EvaluatorMessages.InvalidInteger, null, null, this);
	}

	@Override
	public @NonNull UnlimitedNaturalValue max(@NonNull UnlimitedNaturalValue rightValue) {
		return this;
	}

	@Override
	public @NonNull UnlimitedNaturalValue maxUnlimited(@NonNull UnlimitedNaturalValue rightValue) {
		return this;
	}

	@Override
	public @NonNull UnlimitedNaturalValue min(@NonNull UnlimitedNaturalValue rightValue) {
		return rightValue;
	}

	@Override
	public @NonNull UnlimitedNaturalValue minUnlimited(@NonNull UnlimitedNaturalValue rightValue) {
		return rightValue;
	}

	@Override
	public String toString() {
		return "*";
	}
}

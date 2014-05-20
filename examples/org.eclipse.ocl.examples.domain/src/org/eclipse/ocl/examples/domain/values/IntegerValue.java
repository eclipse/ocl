/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values;

import org.eclipse.jdt.annotation.NonNull;

public interface IntegerValue extends RealValue
{	
	/**
	 * @generated NOT
	 */
	interface Accumulator extends IntegerValue {
		void setValue(@NonNull Integer value);	
	}

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue addInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue commutatedDiv(@NonNull IntegerValue left);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue commutatedMod(@NonNull IntegerValue left);

	/**
	 * @generated NOT
	 */
	int compareToInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue divInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue divUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue divideInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	int intValue();

	/**
	 * @generated NOT
	 */
	boolean isUnlimitedNatural();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue maxInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue minInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue modInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue modUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue multiplyInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue negate();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue subtractInteger(@NonNull IntegerValue right);
}

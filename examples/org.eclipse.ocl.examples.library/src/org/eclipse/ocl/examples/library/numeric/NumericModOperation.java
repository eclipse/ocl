/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;

/**
 * NumericModOperation realises the mod() library operation.
 */
public class NumericModOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull NumericModOperation INSTANCE = new NumericModOperation();

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object left, @Nullable Object right) {
		IntegerValue leftInteger = asIntegerValue(left);
		IntegerValue rightInteger = asIntegerValue(right);
		return rightInteger.commutatedMod(leftInteger);
	}
}

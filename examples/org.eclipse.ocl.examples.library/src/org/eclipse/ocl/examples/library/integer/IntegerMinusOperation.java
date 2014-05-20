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
package org.eclipse.ocl.examples.library.integer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;

/**
 * IntegerMinusOperation realizes the Integer::-() library operation.
 */
@Deprecated
public class IntegerMinusOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull IntegerMinusOperation INSTANCE = new IntegerMinusOperation();

	@Override
	@Deprecated
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		return evaluate(left, right);
	}

	@Override
	public @Nullable Object evaluate(@Nullable Object left, @Nullable Object right) {
		IntegerValue leftValue = asIntegerValue(left);
		IntegerValue rightValue = asIntegerValue(right);
		return leftValue.subtractInteger(rightValue);
	}
}

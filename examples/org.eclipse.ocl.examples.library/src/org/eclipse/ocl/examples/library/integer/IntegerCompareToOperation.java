/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * IntegerCompareToOperation realises the Integer::compareTo() library operation.
 */
@Deprecated
public class IntegerCompareToOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull IntegerCompareToOperation INSTANCE = new IntegerCompareToOperation();

	@Override
	@Deprecated
	public @NonNull IntegerValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		return evaluate(left, right);
	}

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object left, @Nullable Object right) {
		IntegerValue leftInteger = asIntegerValue(left);
		IntegerValue rightInteger = asIntegerValue(right);
		return ValuesUtil.integerValueOf(leftInteger.compareToInteger(rightInteger));
	}
}

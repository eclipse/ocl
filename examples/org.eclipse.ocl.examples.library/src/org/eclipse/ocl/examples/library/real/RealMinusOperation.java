/*******************************************************************************
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.real;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.values.RealValue;

/**
 * RealMinusOperation realizes the Real::-() library operation.
 */
@Deprecated
public class RealMinusOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull RealMinusOperation INSTANCE = new RealMinusOperation();

	@Override
	@Deprecated
	public @NonNull RealValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		return evaluate(left, right);
	}

	@Override
	public @NonNull RealValue evaluate(@Nullable Object left, @Nullable Object right) {
		RealValue leftValue = asRealValue(left);
		RealValue rightValue = asRealValue(right);
		return leftValue.subtractReal(rightValue);
	}
}

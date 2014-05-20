/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.library;

import java.lang.reflect.Method;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public class JavaCompareToOperation extends AbstractSimpleBinaryOperation
{
	protected final @NonNull Method method;

	public JavaCompareToOperation(@NonNull Method method) {
		this.method = method;
	}

	@Override
	@Deprecated
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		return evaluate(left, right);
	}

	@Override
	public @Nullable Object evaluate(@Nullable Object leftValue, @Nullable Object rightValue) {
		Object leftObject = asObject(leftValue);
		Object rightObject = asObject(rightValue);
		try {
			Object result = method.invoke(leftObject, rightObject);
			if (!(result instanceof Integer)) {
				throw new InvalidValueException(EvaluatorMessages.TypedResultRequired, TypeId.INTEGER_NAME);
			}
			return ValuesUtil.integerValueOf(((Integer)result).intValue());
		} catch (Exception e) {
			throw new InvalidValueException(e, EvaluatorMessages.TypedResultRequired, TypeId.INTEGER_NAME);
		}
	}
}
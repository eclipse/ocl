/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractOperation;
import org.eclipse.ocl.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.domain.library.LibraryTernaryOperation;
import org.eclipse.ocl.domain.library.LibraryUnaryOperation;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.InvalidValueException;
import org.eclipse.ocl.domain.values.SequenceValue;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;

/**
 * StringTokenizeOperation realises the String::tokenize() library operations.
 */
public class StringTokenizeOperation extends AbstractOperation implements LibraryUnaryOperation, LibraryBinaryOperation, LibraryTernaryOperation 
{
	public static final @NonNull StringTokenizeOperation INSTANCE = new StringTokenizeOperation();
	private static final @NonNull String DELIMS = " \t\n\r\f"; //$NON-NLS-1$

	@Override
	public @Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		String delims = DELIMS;
		boolean returnDelims = false;
		TypeId typeId = callExp.getTypeId();
		List<? extends OCLExpression> arguments = callExp.getArgument();
		if (arguments.size() > 0) {
			if (arguments.size() > 1) {
				if (arguments.size() > 2) {
					throw new InvalidValueException(EvaluatorMessages.InvalidArgument, arguments.get(2));
				}
				OCLExpression argument1 = arguments.get(1);
				assert argument1 != null;
				Object secondArgument = evaluator.evaluate(argument1);
				returnDelims = asBoolean(secondArgument);
			}
			OCLExpression argument0 = arguments.get(0);
			assert argument0 != null;
			Object firstArgument = evaluator.evaluate(argument0);
			delims = asString(firstArgument);
		}
		return evaluate(evaluator, (CollectionTypeId)typeId, sourceValue, delims, returnDelims);
	}

	@Override
	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(evaluator, (CollectionTypeId)returnTypeId, sourceValue, DELIMS, false);
	}

	@Override
	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		String delims = asString(argumentValue);
		return evaluate(evaluator, (CollectionTypeId)returnTypeId, sourceValue, delims, false);
	}

	@Override
	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String delims = asString(firstArgumentValue);
		boolean returnDelims = asBoolean(secondArgumentValue);
		return evaluate(evaluator, (CollectionTypeId)returnTypeId, sourceValue, delims, returnDelims);
	}

/*	public @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, @NonNull Object... argumentValues) {
		String delims = DELIMS;
		boolean returnDelims = false;
		if (argumentValues.length > 0) {
			if (argumentValues.length > 1) {
				if (argumentValues.length > 2) {
					throw new InvalidValueException(EvaluatorMessages.InvalidArgument, argumentValues[2]);
				}
				Object argumentValue1 = argumentValues[1];
				assert argumentValue1 != null;
				returnDelims = asBoolean(argumentValue1);
			}
			Object argumentValue0 = argumentValues[0];
			assert argumentValue0 != null;
			delims = asString(argumentValue0);
		}
		return evaluate(evaluator, (CollectionTypeId)DomainUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue, delims, returnDelims);
	} */

	private @NonNull SequenceValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull CollectionTypeId returnTypeId, @Nullable Object sourceValue, @NonNull String delims, boolean returnDelims) {
		String sourceString = asString(sourceValue);
		StringTokenizer tokenizer = new StringTokenizer(sourceString, delims, returnDelims);
		List<Object> results = new ArrayList<Object>();
		while (tokenizer.hasMoreTokens()) {
			@SuppressWarnings("null") @NonNull String nextToken = tokenizer.nextToken();
			results.add(nextToken);
		}
		return createSequenceValue(returnTypeId, results);
	}
}

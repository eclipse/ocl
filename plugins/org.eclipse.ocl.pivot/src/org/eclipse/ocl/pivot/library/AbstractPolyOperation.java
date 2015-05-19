/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * AbstractPolyOperation supports arguments with a variety of argument lengths operations.
 */
public abstract class AbstractPolyOperation extends AbstractOperation implements LibraryUnaryOperation, LibraryBinaryOperation, LibraryTernaryOperation 
{
	@Override
	public @Nullable Object dispatch(@NonNull Evaluator evaluator, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		TypeId typeId = callExp.getTypeId();
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		if (arguments.size() == 0) {
			return evaluate(evaluator, typeId, sourceValue);
		}
		OCLExpression argument0 = arguments.get(0);
		assert argument0 != null;
		Object firstArgument = evaluator.evaluate(argument0);
		if (arguments.size() == 1) {
			return evaluate(evaluator, typeId, sourceValue, firstArgument);
		}
		OCLExpression argument1 = arguments.get(1);
		assert argument1 != null;
		Object secondArgument = evaluator.evaluate(argument1);
		if (arguments.size() == 2) {
			return evaluate(evaluator, typeId, sourceValue, firstArgument, secondArgument);
		}
		Object[] argumentValues = new Object[arguments.size()];
		argumentValues[0] = firstArgument;
		argumentValues[1] = secondArgument;
		for (int i = 2; i < arguments.size(); i++) {
			OCLExpression argument = arguments.get(i);
			assert argument != null;
			argumentValues[i] = evaluator.evaluate(argument);
		}
		return evaluate(evaluator, typeId, sourceValue, argumentValues);
	}
}

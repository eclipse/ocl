/**
 * <copyright>
 * 
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.debug.stepper;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IRootVMEvaluationVisitor;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;

public class OperationCallExpStepper extends CallExpStepper
{
	public static @NonNull OperationCallExpStepper INSTANCE = new OperationCallExpStepper();

	@Override
	public @Nullable Element isPostStoppable(@NonNull IRootVMEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element element, @Nullable Element parentElement) {
		OperationCallExp callExp = (OperationCallExp)parentElement;
		if (callExp != null) {
			List<OCLExpression> arguments = callExp.getArgument();
			if (arguments.size() <= 0) {
				return callExp;
			}
			if (arguments.get(arguments.size()-1) == element) {
				return callExp;
			}
		}
		return null;
	}
}

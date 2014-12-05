/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.launching;

import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.OCLEvaluationContext;
import org.eclipse.ocl.examples.debug.evaluator.OCLVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.evaluator.OCLVMEvaluator;
import org.eclipse.ocl.examples.debug.vm.launching.InternalDebuggableExecutor;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.ParserException;

/**
 * Internal transformation executor
 */
public class OCLInternalDebuggableExecutor extends InternalDebuggableExecutor
{
	protected final @NonNull OCLEvaluationContext evaluationContext;
	
	public OCLInternalDebuggableExecutor(@NonNull OCLEvaluationContext evaluationContext, @NonNull OCLVMEnvironmentFactory envFactory) {
		super(envFactory, evaluationContext.getConstraintURI());
		this.evaluationContext = evaluationContext;
	}

	protected @NonNull OCLVMEvaluator createEvaluator() throws IOException, ParserException {
		ExpressionInOCL expressionObject = evaluationContext.getExpressionObject();
		if (expressionObject != null) {
			return new OCLVMEvaluator((OCLVMEnvironmentFactory) envFactory, expressionObject, evaluationContext.getContextObject());
		}
		else {
			return new OCLVMEvaluator((OCLVMEnvironmentFactory) envFactory, evaluationContext.getConstraintURI(), evaluationContext.getContextURI());
		}
	}
}

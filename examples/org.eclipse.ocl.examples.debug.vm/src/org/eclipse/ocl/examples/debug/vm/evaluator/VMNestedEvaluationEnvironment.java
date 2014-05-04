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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.pivot.NamedElement;

public abstract class VMNestedEvaluationEnvironment<T extends NamedElement> extends VMEvaluationEnvironment<T>
{
	protected final @NonNull IRootVMEvaluationEnvironment<T> rootEvaluationEnvironment;
	
	public VMNestedEvaluationEnvironment(@NonNull IVMEvaluationEnvironment<T> evaluationEnvironment) {
		super(evaluationEnvironment);
		rootEvaluationEnvironment = evaluationEnvironment.getRootEvaluationEnvironment();
	}

	public @NonNull VMDebugCore getDebugCore() {
		return rootEvaluationEnvironment.getDebugCore();
	}

	public @NonNull T getDebuggableElement() {
		return rootEvaluationEnvironment.getDebuggableElement();
	}

	public @NonNull IRootVMEvaluationEnvironment<T> getRootEvaluationEnvironment() {
		return rootEvaluationEnvironment;
	}
}

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

import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

public abstract class VMEvaluationEnvironment<T extends NamedElement> extends BasicEvaluationEnvironment implements IVMEvaluationEnvironment<T>
{
	private final @NonNull Stack<StepperEntry> stepperStack = new Stack<StepperEntry>();
	
	protected VMEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull NamedElement executableObject, @NonNull IVMModelManager modelManager) {
		super(environmentFactory, executableObject, modelManager);
	}

	protected VMEvaluationEnvironment(@NonNull IVMEvaluationEnvironment<T> evaluationEnvironment, @NonNull NamedElement executableObject) {
		super(evaluationEnvironment, executableObject);
	}

	public @NonNull IVMModelManager getModelManager() {
		return (IVMModelManager) modelManager;
	}

	@SuppressWarnings("unchecked")
	public @Nullable IVMEvaluationEnvironment<T> getParentEvaluationEnvironment() {
		return (IVMEvaluationEnvironment<T>) parent;
	}

	@Override
	public @NonNull Stack<IVMEvaluationEnvironment.StepperEntry> getStepperStack() {
		return stepperStack;
	}
}

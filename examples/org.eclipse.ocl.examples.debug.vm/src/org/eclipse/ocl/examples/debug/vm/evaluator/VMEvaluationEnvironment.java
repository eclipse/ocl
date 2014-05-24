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
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public abstract class VMEvaluationEnvironment<T extends NamedElement> extends PivotEvaluationEnvironment implements IVMEvaluationEnvironment<T>
{
	protected final @NonNull IVMModelManager modelManager;
	private final @NonNull Stack<StepperEntry> stepperStack = new Stack<StepperEntry>();
	
	protected VMEvaluationEnvironment(@NonNull MetaModelManager metaModelManager, @NonNull IVMModelManager modelManager) {
		super(metaModelManager);
		this.modelManager = modelManager;
	}

	protected VMEvaluationEnvironment(@NonNull IVMEvaluationEnvironment<T> evaluationEnvironment) {
		super(evaluationEnvironment);
		this.modelManager = evaluationEnvironment.getModelManager();
	}

	public @NonNull IVMModelManager getModelManager() {
		return modelManager;
	}

	@SuppressWarnings("unchecked")
	public @Nullable IVMEvaluationEnvironment<T> getParentEvaluationEnvironment() {
		return (IVMEvaluationEnvironment<T>) parent;
	}

	@Override
	public @NonNull Stack<org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment.StepperEntry> getStepperStack() {
		return stepperStack;
	}
}

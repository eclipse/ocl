/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationEnvironment;

public abstract class VMEvaluationEnvironment extends BasicEvaluationEnvironment implements IVMEvaluationEnvironmentExtension
{
	protected final @NonNull IVMEnvironmentFactory vmEnvironmentFactory;
	private final @NonNull Stack<StepperEntry> stepperStack = new Stack<StepperEntry>();
	
	protected VMEvaluationEnvironment(@NonNull IVMEnvironmentFactory vmEnvironmentFactory, @NonNull NamedElement executableObject, @NonNull IVMModelManager modelManager) {
		super(vmEnvironmentFactory.getEnvironmentFactory(), executableObject, modelManager);
		this.vmEnvironmentFactory = vmEnvironmentFactory;
	}

	protected VMEvaluationEnvironment(@NonNull IVMEvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject) {
		super(evaluationEnvironment, executableObject);
		this.vmEnvironmentFactory = evaluationEnvironment.getVMEnvironmentFactory();
	}

	public @NonNull VariableFinder createVariableFinder(boolean isStoreValues) {
		return new VariableFinder(this, isStoreValues);
	}

	public @NonNull IVMModelManager getModelManager() {
		return (IVMModelManager) modelManager;
	}

	public @Nullable IVMEvaluationEnvironment getVMParentEvaluationEnvironment() {
		return (IVMEvaluationEnvironment) parent;
	}

	@Override
	public @NonNull Stack<IVMEvaluationEnvironment.StepperEntry> getStepperStack() {
		return stepperStack;
	}

	@Override
	public @NonNull IVMEnvironmentFactory getVMEnvironmentFactory() {
		return vmEnvironmentFactory;
	}
}

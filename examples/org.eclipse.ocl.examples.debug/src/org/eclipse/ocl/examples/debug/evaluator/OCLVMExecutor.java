/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.OCLDebugPlugin;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.BasicOCLExecutor;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;

public class OCLVMExecutor extends BasicOCLExecutor implements VMExecutor
{
	protected final @NonNull IVMContext vmContext;
	private long envId = 0;
	
	public OCLVMExecutor(@NonNull IVMContext vmContext, @NonNull IVMModelManager modelManager) {
		super(vmContext.getEnvironmentFactory(), modelManager);
		this.vmContext = vmContext;
	}

	@Override
	protected @NonNull OCLVMEvaluationVisitor createEvaluationVisitor() {
		OCLEvaluationVisitor evaluationVisitor = new OCLEvaluationVisitor(this);
		return new OCLVMEvaluationVisitor(evaluationVisitor, vmContext);
	}

	@Override
	protected @NonNull OCLVMEvaluationEnvironment createNestedEvaluationEnvironment(@NonNull EvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject) {
		return new OCLVMNestedEvaluationEnvironment((OCLVMEvaluationEnvironment) evaluationEnvironment, executableObject, ++envId);
	}

	@Override
	protected @NonNull OCLVMEvaluationEnvironment createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return new OCLVMRootEvaluationEnvironment(this, (ExpressionInOCL)executableObject, ++envId);
	}

	@Override
	public @NonNull OCLVMEvaluationVisitor getEvaluationVisitor() {
		return (OCLVMEvaluationVisitor) super.getEvaluationVisitor();
	}

	@Override
	public @NonNull String getPluginId() {
		return OCLDebugPlugin.PLUGIN_ID;
	}

	@Override
	public @NonNull OCLVMEvaluationEnvironment getRootEvaluationEnvironment() {
		return (OCLVMEvaluationEnvironment) super.getRootEvaluationEnvironment();
	}

	@Override
	public @NonNull IVMContext getVMContext() {
		return vmContext;
	}
}

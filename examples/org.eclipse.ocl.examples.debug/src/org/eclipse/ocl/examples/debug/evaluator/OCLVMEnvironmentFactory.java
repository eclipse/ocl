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
package org.eclipse.ocl.examples.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class OCLVMEnvironmentFactory extends PivotEnvironmentFactory implements IVMEnvironmentFactory
{
	private IVMDebuggerShell shell;
	private long envId = 0;
	
	public OCLVMEnvironmentFactory(@Nullable StandaloneProjectMap projectMap, @Nullable ModelManager modelManager) {
		super(projectMap, modelManager); //createModelManager(object));
	}

	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull IVMModelManager modelManager, @NonNull ExpressionInOCL expressionInOCL) {
		return new OCLVMRootEvaluationEnvironment(this, modelManager, expressionInOCL, ++envId);
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent) { // FIXME Pass 'operation'
		return new OCLVMNestedEvaluationEnvironment((IOCLVMEvaluationEnvironment) parent, ++envId, ((IOCLVMEvaluationEnvironment) parent).getOperation());
	}

//	@Override
	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull IVMEvaluationEnvironment<?> parent, @NonNull NamedElement operation) {
		return new OCLVMNestedEvaluationEnvironment((IOCLVMEvaluationEnvironment) parent, ++envId, operation);
	}

	public @NonNull OCLVMRootEvaluationVisitor createEvaluationVisitor(@NonNull IOCLVMEvaluationEnvironment evalEnv) {
		return new OCLVMRootEvaluationVisitor(evalEnv, ClassUtil.nonNullState(shell));
	}

	public @NonNull OCLVMModelManager createModelManager(@NonNull MetamodelManager metamodelManager) {
		return new OCLVMModelManager(metamodelManager);
	}

	public boolean keepDebug() {
		return true;
	}

	public void setShell(@Nullable IVMDebuggerShell shell) {
		this.shell = shell;
	}
}

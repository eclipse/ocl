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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;

public class OCLVMEnvironmentFactory extends PivotEnvironmentFactory implements IVMEnvironmentFactory
{
	private IVMDebuggerShell shell;
	private long envId = 0;
	
	public OCLVMEnvironmentFactory(EPackage.Registry reg, @NonNull MetaModelManager metaModelManager) {
		super(reg, metaModelManager);
	}

	@Override
	public @NonNull OCLVMEnvironment createEnvironment() {
		OCLVMEnvironment result = new OCLVMEnvironment(this, null);
		return result;
	}

	@Override
	public @NonNull OCLVMEnvironment createEnvironment(@NonNull Environment parent) {
		if (!(parent instanceof OCLVMEnvironment)) {
			throw new IllegalArgumentException(
				"Parent environment must be an OCLVM environment: " + parent); //$NON-NLS-1$
		}
		
		OCLVMEnvironment result = new OCLVMEnvironment((OCLVMEnvironment) parent);
		return result;
	}

	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull IVMModelManager modelManager, @NonNull ExpressionInOCL expressionInOCL) {
		return new OCLVMRootEvaluationEnvironment(getMetaModelManager(), modelManager, expressionInOCL, ++envId);
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent) {
		return new OCLVMNestedEvaluationEnvironment((IOCLVMEvaluationEnvironment) parent, ++envId, ((IOCLVMEvaluationEnvironment) parent).getOperation());
	}

//	@Override
	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull IVMEvaluationEnvironment<?> parent, @NonNull NamedElement operation) {
		return new OCLVMNestedEvaluationEnvironment((IOCLVMEvaluationEnvironment) parent, ++envId, operation);
	}

	public @NonNull OCLVMRootEvaluationVisitor createEvaluationVisitor(@NonNull OCLVMEnvironment env, @NonNull IOCLVMEvaluationEnvironment evalEnv) {
		return new OCLVMRootEvaluationVisitor(env, evalEnv, DomainUtil.nonNullState(shell));
	}

	public @NonNull OCLVMModelManager createModelManager(@NonNull MetaModelManager metaModelManager) {
		return new OCLVMModelManager(metaModelManager);
	}

	public boolean keepDebug() {
		return true;
	}

	public void setShell(@Nullable IVMDebuggerShell shell) {
		this.shell = shell;
	}
}

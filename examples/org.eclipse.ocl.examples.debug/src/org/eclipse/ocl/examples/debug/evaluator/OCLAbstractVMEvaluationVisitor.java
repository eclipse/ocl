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
import org.eclipse.ocl.examples.debug.OCLDebugPlugin;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;

/**
 * OCLAbstractVMEvaluationVisitor is the base abstract class for OCL
 * evaluation visitors.
 * 
 * @author Horacio Hoyos
 */
public abstract class OCLAbstractVMEvaluationVisitor extends EvaluationVisitorImpl implements IOCLVMEvaluationVisitor
{
   /**
     * Instantiates a new OCL imperative abstract visitor.
     *
     * @param env The environment
     * @param evalEnv The evaluation environment
     */
    public OCLAbstractVMEvaluationVisitor(@NonNull OCLVMEnvironment env, @NonNull IOCLVMEvaluationEnvironment evalEnv) {
        super(env, evalEnv, evalEnv.getModelManager());
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl#createNestedEvaluator()
     */
    @Override
	public abstract @NonNull IOCLVMEvaluationVisitor createNestedEvaluator();

	@Override
	public @NonNull IVMEvaluationVisitor<ExpressionInOCL> getClonedEvaluator() {
		IOCLVMEvaluationEnvironment oldEvaluationEnvironment = getEvaluationEnvironment();
		IOCLVMEvaluationEnvironment clonedEvaluationEnvironment = oldEvaluationEnvironment.createClonedEvaluationEnvironment();
		return new OCLVMEvaluationVisitorImpl(getEnvironment(), clonedEvaluationEnvironment);
	}

    @Override
	public @NonNull OCLVMEnvironment getEnvironment() {
		return (OCLVMEnvironment) super.getEnvironment();
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment getEvaluationEnvironment() {
		return (IOCLVMEvaluationEnvironment) super.getEvaluationEnvironment();
	}

	/* (non-Javadoc)
     * @see org.eclipse.ocl.examples.pivot.evaluation.AbstractEvaluationVisitor#getModelManager()
     */
    @Override
	public @NonNull IVMModelManager getModelManager() {
		return (IVMModelManager) modelManager;
	}

	@Override
	public @NonNull String getPluginId() {
		return OCLDebugPlugin.PLUGIN_ID;
	}
}

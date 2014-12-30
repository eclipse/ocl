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
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationVisitorImpl;

/**
 * OCLVMEvaluationVisitorImpl is the class for ...
 */
public class OCLVMEvaluationVisitorImpl extends EvaluationVisitorImpl implements IOCLVMEvaluationVisitor {

        
    /**
     * Instantiates a new OCL evaluation visitor impl.
     * 
     * @param env
     *            the env
     * @param evalEnv
     *            the eval env
     */
    public OCLVMEvaluationVisitorImpl(@NonNull IOCLVMEvaluationEnvironment evalEnv) {
        super(evalEnv, evalEnv.getModelManager());
    }

    @Override
    public @NonNull IOCLVMEvaluationVisitor createNestedEvaluator() { // FIXME Pass 'operation'
    	IOCLVMEvaluationEnvironment nestedEvalEnv = (IOCLVMEvaluationEnvironment) environmentFactory.createEvaluationEnvironment(evaluationEnvironment);
        OCLVMEvaluationVisitorImpl ne = new OCLVMEvaluationVisitorImpl(nestedEvalEnv);
        return ne;
    }

	@Override
	@NonNull
	public EvaluationVisitor createNestedUndecoratedEvaluator(@NonNull NamedElement operation) {
		EvaluationVisitor nestedEvaluationVisitor = super.createNestedUndecoratedEvaluator(operation);
		EvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluationVisitor.getEvaluationEnvironment();
		if (nestedEvaluationEnvironment instanceof OCLVMNestedEvaluationEnvironment) {
			((OCLVMNestedEvaluationEnvironment)nestedEvaluationEnvironment).setOperation(operation);
		}
		return nestedEvaluationVisitor;
	}

	public void dispose() {}

	@Override
	public @NonNull IVMEvaluationVisitor<ExpressionInOCL> getClonedEvaluator() {
		IOCLVMEvaluationEnvironment oldEvaluationEnvironment = getEvaluationEnvironment();
		IOCLVMEvaluationEnvironment clonedEvaluationEnvironment = oldEvaluationEnvironment.createClonedEvaluationEnvironment();
		return new OCLVMEvaluationVisitorImpl(clonedEvaluationEnvironment);
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment getEvaluationEnvironment() {
		return (IOCLVMEvaluationEnvironment) super.getEvaluationEnvironment();
	}

	/* (non-Javadoc)
     * @see org.eclipse.ocl.pivot.evaluation.AbstractEvaluationVisitor#getModelManager()
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

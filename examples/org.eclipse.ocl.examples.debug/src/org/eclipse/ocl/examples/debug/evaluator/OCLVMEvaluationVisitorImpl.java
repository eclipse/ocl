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

/**
 * OCLVMEvaluationVisitorImpl is the class for ...
 */
public class OCLVMEvaluationVisitorImpl extends OCLAbstractVMEvaluationVisitor {

        
    /**
     * Instantiates a new OCL evaluation visitor impl.
     * 
     * @param env
     *            the env
     * @param evalEnv
     *            the eval env
     */
    public OCLVMEvaluationVisitorImpl(@NonNull OCLVMEnvironment env, @NonNull IOCLVMEvaluationEnvironment evalEnv) {
        super(env, evalEnv);
    }

    @Override
    public @NonNull IOCLVMEvaluationVisitor createNestedEvaluator() {
    	OCLVMEnvironment vmEnvironment = getEnvironment();
		OCLVMEnvironmentFactory factory = vmEnvironment.getFactory();
		IOCLVMEvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
        OCLVMEvaluationVisitorImpl ne = new OCLVMEvaluationVisitorImpl(vmEnvironment, nestedEvalEnv);
        return ne;
    }

	public void dispose() {}
}

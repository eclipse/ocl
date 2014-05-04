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
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * A OCLPivotEvaluator supports loading a compiled transformation and models, performing a transformation
 * and then saving the models.
 * @see OCLVMEvaluator
 */
public class OCLPivotEvaluator
{
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull ExpressionInOCL expressionInOCL;
	protected final @NonNull OCLVMEnvironmentFactory envFactory;
	protected final @NonNull OCLVMEnvironment env;
	protected final @NonNull IVMModelManager modelManager;

    public OCLPivotEvaluator(@NonNull OCLVMEnvironmentFactory envFactory, @NonNull ExpressionInOCL expressionInOCL) {
    	this.envFactory = envFactory;
    	this.metaModelManager = envFactory.getMetaModelManager();
    	this.expressionInOCL = expressionInOCL;
    	this.env = envFactory.createEnvironment();
    	this.modelManager = envFactory.createModelManager(metaModelManager);
    }

    public OCLPivotEvaluator(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expressionInOCL) {
    	this.metaModelManager = metaModelManager;
    	this.expressionInOCL = expressionInOCL;
    	this.envFactory = new OCLVMEnvironmentFactory(null, metaModelManager);
    	this.env = envFactory.createEnvironment();
    	this.modelManager = envFactory.createModelManager(metaModelManager);
    }

	public void dispose() {
		modelManager.dispose();
	}

	public Boolean execute() {
        ExpressionInOCL expressionInOCL = getExpressionInOCL();
		IOCLVMEvaluationEnvironment evalEnv = envFactory.createEvaluationEnvironment(modelManager, expressionInOCL);
//		evalEnv.add(expressionInOCL.getContextVariable(), expressionInOCL.getContextVariable().g);
        IOCLVMEvaluationVisitor visitor = envFactory.createEvaluationVisitor(env, evalEnv);
        return (Boolean) expressionInOCL.accept(visitor);
	}

	public final @NonNull OCLVMEnvironment getEnvironment() {
		return env;
	}

	public final @NonNull OCLVMEnvironmentFactory getEnvironmentFactory() {
		return envFactory;
	}

	public final @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
	
	public final @NonNull IVMModelManager getModelManager() {
		return modelManager;
	}
	
	public @NonNull ExpressionInOCL getExpressionInOCL() {
		return DomainUtil.nonNullState(expressionInOCL);
	}
}

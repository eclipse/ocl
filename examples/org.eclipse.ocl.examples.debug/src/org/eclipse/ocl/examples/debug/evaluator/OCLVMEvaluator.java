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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluator;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * A OCLVMEvaluator supports loading a transformation as source then loading models, performing a transformation
 * and then saving the models.
 * 
 * @see OCLPivotEvaluator
 */
public class OCLVMEvaluator implements IVMEvaluator
{
    public static @NonNull EObject loadContext(@NonNull MetaModelManager metaModelManager, @NonNull URI contextURI) throws IOException {
        EObject eObject = metaModelManager.getExternalResourceSet().getEObject(contextURI, true);
        if (eObject == null) {
            throw new IOException("Nothing loadable as '" + contextURI + "'");
        }
        return eObject;
	}
    
    public static @NonNull ExpressionInOCL loadExpression(@NonNull MetaModelManager metaModelManager, @NonNull URI constraintURI, boolean keepDebug) throws IOException {
        EObject eObject = metaModelManager.getASResourceSet().getEObject(constraintURI, true);
        return loadExpression(eObject, constraintURI);
	}

	public static @NonNull ExpressionInOCL loadExpression(EObject eObject, URI constraintURI)
			throws IOException {
		if (eObject == null) {
            throw new IOException("Nothing loadable as '" + constraintURI + "'");
        }
        if (!(eObject instanceof Constraint)) {
            throw new IOException("Constraint rather than " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
        }
    	OpaqueExpression specification = ((Constraint)eObject).getSpecification();
    	if (specification != null) {
    		ExpressionInOCL expressionInOCL = specification.getExpressionInOCL();
        	if (expressionInOCL != null) {
        		return expressionInOCL;
        	}
    	}
        throw new IOException("Missing OCL expression " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
	}
    
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull ExpressionInOCL expressionInOCL;
	protected final @NonNull OCLVMEnvironmentFactory envFactory;
	protected final @NonNull OCLVMEnvironment env;
	protected final @NonNull IVMModelManager modelManager;
	private @Nullable EObject context;
	private boolean suspendOnStartup = false;

    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory envFactory, @NonNull URI oclURI, @Nullable URI contextURI) throws IOException {
    	this(envFactory, loadExpression(envFactory.getMetaModelManager(), oclURI, envFactory.keepDebug()), contextURI != null ? loadContext(envFactory.getMetaModelManager(), contextURI) : null);
    }

    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory envFactory, @NonNull Constraint constraint, @NonNull EObject context) throws IOException {
    	this(envFactory, loadExpression(constraint, EcoreUtil.getURI(constraint)), context);
    }
    
    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory envFactory, @NonNull ExpressionInOCL expressionInOCL, @Nullable EObject context) throws IOException {
    	this.envFactory = envFactory;
    	this.metaModelManager = envFactory.getMetaModelManager();
    	this.expressionInOCL = expressionInOCL;
    	this.env = envFactory.createEnvironment();
    	this.modelManager = envFactory.createModelManager(metaModelManager);
    	this.context = context;
    }

	public void dispose() {
		modelManager.dispose();
	}

	public Boolean execute() {
        ExpressionInOCL expressionInOCL = getExpressionInOCL();
		IOCLVMEvaluationEnvironment evalEnv = envFactory.createEvaluationEnvironment(modelManager, expressionInOCL);
		Variable contextVariable = expressionInOCL.getContextVariable();
		if (contextVariable != null) {
			evalEnv.add(contextVariable, context);
		}
        OCLVMRootEvaluationVisitor visitor = envFactory.createEvaluationVisitor(env, evalEnv);
        visitor.start(suspendOnStartup);
        return (Boolean) expressionInOCL.accept(visitor);
	}

	@Override
	public @NonNull ExpressionInOCL getDebuggable() {
		return getExpressionInOCL();
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
		return expressionInOCL;
	}

	@Override
	public void saveModels() {}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}

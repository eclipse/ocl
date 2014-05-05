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
public class OCLVMEvaluator extends OCLPivotEvaluator implements IVMEvaluator
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
    
	private @Nullable EObject context;
	private boolean suspendOnStartup = false;
    
    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory envFactory, @NonNull URI oclURI, @NonNull URI contextURI) throws IOException {
    	super(envFactory, loadExpression(envFactory.getMetaModelManager(), oclURI, envFactory.keepDebug()));
    	context = loadContext(envFactory.getMetaModelManager(), contextURI);
    }
    
    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory envFactory, @NonNull Constraint constraint, @NonNull EObject context) throws IOException {
    	super(envFactory, loadExpression(constraint, EcoreUtil.getURI(constraint)));
    	this.context = context;
    }

	public Boolean execute() {
        ExpressionInOCL expressionInOCL = getExpressionInOCL();
		IOCLVMEvaluationEnvironment evalEnv = envFactory.createEvaluationEnvironment(modelManager, expressionInOCL);
		Variable contextVariable = expressionInOCL.getContextVariable();
		if (contextVariable != null) {
			evalEnv.add(contextVariable, context);
		}
        OCLRootVMEvaluationVisitor visitor = envFactory.createEvaluationVisitor(env, evalEnv);
        visitor.start(suspendOnStartup);
        return (Boolean) expressionInOCL.accept(visitor);
	}

	@Override
	public @NonNull ExpressionInOCL getDebuggable() {
		return getExpressionInOCL();
	}

	@Override
	public void saveModels() {}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}

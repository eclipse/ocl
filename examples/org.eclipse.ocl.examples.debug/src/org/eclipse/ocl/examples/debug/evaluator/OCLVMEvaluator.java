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
package org.eclipse.ocl.examples.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluator;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ParserException;

/**
 * A OCLVMEvaluator supports loading a transformation as source then loading models, performing a transformation
 * and then saving the models.
 */
public class OCLVMEvaluator implements IVMEvaluator
{
    public static @NonNull EObject loadContext(@NonNull EnvironmentFactory environmentFactory, @NonNull URI contextURI) throws IOException {
        EObject eObject = environmentFactory.getResourceSet().getEObject(contextURI, true);
        if (eObject == null) {
            throw new IOException("Nothing loadable as '" + contextURI + "'");
        }
        return eObject;
	}
    
    public static @NonNull ExpressionInOCL loadExpression(@NonNull EnvironmentFactory environmentFactory, @NonNull URI constraintURI, boolean keepDebug) throws IOException, ParserException {
		MetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
        EObject eObject = metamodelManager.getASResourceSet().getEObject(constraintURI, true);
        return loadExpression(environmentFactory, eObject, constraintURI);
	}

	public static @NonNull ExpressionInOCL loadExpression(@NonNull EnvironmentFactory environmentFactory, EObject eObject, URI constraintURI) throws IOException, ParserException {
		if (eObject == null) {
            throw new IOException("Nothing loadable as '" + constraintURI + "'");
        }
        if (!(eObject instanceof Constraint)) {
            throw new IOException("Constraint rather than " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
        }
        LanguageExpression specification = ((Constraint)eObject).getOwnedSpecification();
    	if (specification == null) {
            throw new IOException("Missing OCL expression " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
    	}
		MetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		return metamodelManager.parseSpecification(specification);
	}
    
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull ExpressionInOCL expressionInOCL;
	protected final @NonNull IVMContext vmContext;
	protected final @NonNull OCLVMModelManager vmModelManager;
	private @Nullable EObject context;
	private boolean suspendOnStartup = false;

    public OCLVMEvaluator(@NonNull IVMContext vmContext, @NonNull URI oclURI, @Nullable URI contextURI) throws IOException, ParserException {
    	this(vmContext, loadExpression(vmContext.getEnvironmentFactory(), oclURI, vmContext.keepDebug()), contextURI != null ? loadContext(vmContext.getEnvironmentFactory(), contextURI) : null);
    }

    public OCLVMEvaluator(@NonNull IVMContext vmContext, @NonNull Constraint constraint, @NonNull EObject context) throws IOException, ParserException {
    	this(vmContext, loadExpression(vmContext.getEnvironmentFactory(), constraint, EcoreUtil.getURI(constraint)), context);
    }
    
    public OCLVMEvaluator(@NonNull IVMContext vmContext, @NonNull ExpressionInOCL expressionInOCL, @Nullable EObject context) throws IOException {
    	this.vmContext = vmContext;
    	this.environmentFactory = vmContext.getEnvironmentFactory();
    	this.expressionInOCL = expressionInOCL;
    	this.vmModelManager = new OCLVMModelManager(environmentFactory.getMetamodelManager());
    	this.context = context;
    }

	public void dispose() {
		vmModelManager.dispose();
	}

	public Object execute() {
        ExpressionInOCL expressionInOCL = getExpressionInOCL();
        OCLVMExecutor vmExecutor = new OCLVMExecutor(vmContext, vmModelManager);
		vmExecutor.initializeEvaluationEnvironment(expressionInOCL);
		OCLVMEvaluationEnvironment evalEnv = vmExecutor.getRootEvaluationEnvironment();
		Variable contextVariable = expressionInOCL.getOwnedContext();
		if (contextVariable != null) {
			evalEnv.add(contextVariable, context);
		}
//        OCLVMRootExecutor visitor = vmContext.createVMEvaluationVisitor(evalEnv);
        OCLVMEvaluationVisitor visitor = vmExecutor.getEvaluationVisitor();
        visitor.start(suspendOnStartup);
        return expressionInOCL.accept(visitor);
	}

	@Override
	public @NonNull ExpressionInOCL getDebuggable() {
		return getExpressionInOCL();
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}
	
	public @NonNull ExpressionInOCL getExpressionInOCL() {
		return expressionInOCL;
	}
	
	public final @NonNull OCLVMModelManager getVMModelManager() {
		return vmModelManager;
	}

	@Override
	public void saveModels() {}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}

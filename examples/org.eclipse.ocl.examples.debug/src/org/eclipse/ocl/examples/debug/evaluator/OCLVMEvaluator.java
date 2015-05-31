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
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluator;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ParserException;

/**
 * A OCLVMEvaluator supports loading a transformation as source then loading models, performing a transformation
 * and then saving the models.
 */
public class OCLVMEvaluator implements IVMEvaluator
{
    public static @NonNull EObject loadContext(@NonNull MetamodelManagerInternal metamodelManager, @NonNull URI contextURI) throws IOException {
        EObject eObject = metamodelManager.getEnvironmentFactory().getResourceSet().getEObject(contextURI, true);
        if (eObject == null) {
            throw new IOException("Nothing loadable as '" + contextURI + "'");
        }
        return eObject;
	}
    
    public static @NonNull ExpressionInOCL loadExpression(@NonNull MetamodelManagerInternal metamodelManager, @NonNull URI constraintURI, boolean keepDebug) throws IOException, ParserException {
        EObject eObject = metamodelManager.getASResourceSet().getEObject(constraintURI, true);
        return loadExpression(metamodelManager, eObject, constraintURI);
	}

	public static @NonNull ExpressionInOCL loadExpression(@NonNull MetamodelManagerInternal metamodelManager, EObject eObject, URI constraintURI) throws IOException, ParserException {
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
		return metamodelManager.parseSpecification(specification);
	}
    
	protected final @NonNull MetamodelManagerInternal metamodelManager;
	protected final @NonNull ExpressionInOCL expressionInOCL;
	protected final @NonNull OCLVMEnvironmentFactory vmEnvironmentFactory;
	protected final @NonNull OCLVMModelManager vmModelManager;
	private @Nullable EObject context;
	private boolean suspendOnStartup = false;

    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory vmEnvironmentFactory, @NonNull URI oclURI, @Nullable URI contextURI) throws IOException, ParserException {
    	this(vmEnvironmentFactory, loadExpression(vmEnvironmentFactory.getMetamodelManager(), oclURI, vmEnvironmentFactory.keepDebug()), contextURI != null ? loadContext(vmEnvironmentFactory.getMetamodelManager(), contextURI) : null);
    }

    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory vmEnvironmentFactory, @NonNull Constraint constraint, @NonNull EObject context) throws IOException, ParserException {
    	this(vmEnvironmentFactory, loadExpression(vmEnvironmentFactory.getMetamodelManager(), constraint, EcoreUtil.getURI(constraint)), context);
    }
    
    public OCLVMEvaluator(@NonNull OCLVMEnvironmentFactory vmEnvironmentFactory, @NonNull ExpressionInOCL expressionInOCL, @Nullable EObject context) throws IOException {
    	this.vmEnvironmentFactory = vmEnvironmentFactory;
    	this.metamodelManager = vmEnvironmentFactory.getMetamodelManager();
    	this.expressionInOCL = expressionInOCL;
    	this.vmModelManager = vmEnvironmentFactory.createVMModelManager(metamodelManager);
    	this.context = context;
    }

	public void dispose() {
		vmModelManager.dispose();
	}

	public Object execute() {
        ExpressionInOCL expressionInOCL = getExpressionInOCL();
		IOCLVMEvaluationEnvironment evalEnv = vmEnvironmentFactory.createVMEvaluationEnvironment(expressionInOCL, vmModelManager);
		Variable contextVariable = expressionInOCL.getOwnedContext();
		if (contextVariable != null) {
			evalEnv.add(contextVariable, context);
		}
        OCLVMRootEvaluationVisitor visitor = vmEnvironmentFactory.createVMEvaluationVisitor(evalEnv);
        visitor.start(suspendOnStartup);
        return expressionInOCL.accept(visitor);
	}

	@Override
	public @NonNull ExpressionInOCL getDebuggable() {
		return getExpressionInOCL();
	}

	public final @NonNull OCLVMEnvironmentFactory getEnvironmentFactory() {
		return vmEnvironmentFactory;
	}

	public final @NonNull MetamodelManagerInternal getMetamodelManager() {
		return metamodelManager;
	}
	
	public final @NonNull OCLVMModelManager getVMModelManager() {
		return vmModelManager;
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

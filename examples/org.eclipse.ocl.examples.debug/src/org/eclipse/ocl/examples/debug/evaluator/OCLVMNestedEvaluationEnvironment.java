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

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMNestedEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.debug.vm.utils.VMStackTraceBuilder;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;

public class OCLVMNestedEvaluationEnvironment extends VMNestedEvaluationEnvironment<ExpressionInOCL> implements IOCLVMEvaluationEnvironment
{
	private @NonNull Element myCurrentIP;
	private @NonNull NamedElement myOperation;		// Redundant if final
    private final int myStackDepth;
	private final long id;
    
	public OCLVMNestedEvaluationEnvironment(@NonNull IOCLVMEvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject, long id) {
		super(evaluationEnvironment, executableObject);
		myStackDepth = evaluationEnvironment.getDepth() + 1;
		this.id = id;
		this.myOperation = executableObject;
		this.myCurrentIP = executableObject;
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment createClonedEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Element getCurrentIP() {
		return myCurrentIP;
	}

	public @NonNull UnitLocation getCurrentLocation() {
//		if (myCurrentIP == null) {
//			return null;
//		}
//		else {
		int startPosition = ASTBindingHelper.getStartPosition(myCurrentIP);
		int endPosition = ASTBindingHelper.getEndPosition(myCurrentIP);
			return new UnitLocation(startPosition, endPosition, this, myCurrentIP); 
//		}
	}

	@Override
	public int getDepth() {
		return myStackDepth;
	}

	@Override
	public long getID() {
		return id;
	}
	
	public @NonNull Map<String, Resource> getModelParameterVariables() {
    	return getRootEvaluationEnvironment().getModelParameterVariables();
	}

	@Override
	public @NonNull NamedElement getOperation() {
		return myOperation;
	}

	@Override
	@NonNull public Variable getPCVariable() {
		return rootEvaluationEnvironment.getPCVariable();
	}

	@Override
	public @Nullable IOCLVMEvaluationEnvironment getParentEvaluationEnvironment() {
		return (IOCLVMEvaluationEnvironment) super.getParentEvaluationEnvironment();
	}

	@Override
	public @NonNull OCLVMRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return (OCLVMRootEvaluationEnvironment) rootEvaluationEnvironment;
	}

	public boolean isDeferredExecution() {
		return getRootEvaluationEnvironment().isDeferredExecution();
	}
    
    public void processDeferredTasks() {
    	getRootEvaluationEnvironment().processDeferredTasks();
    }

	public @NonNull Element setCurrentIP(@NonNull Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

	public void setOperation(@NonNull NamedElement operation) {
		this.myCurrentIP = operation;
		this.myOperation = operation;
	}

	public void throwVMException(@NonNull VMRuntimeException exception) throws VMRuntimeException {
		try {
			getRootEvaluationEnvironment().saveThrownException(exception);
			exception.setStackVMTrace(new VMStackTraceBuilder(this).buildStackTrace());
		} catch (Exception e) {
			getDebugCore().error("Failed to build VM stack trace", e); //$NON-NLS-1$
		}
		
		throw exception;
	}
}

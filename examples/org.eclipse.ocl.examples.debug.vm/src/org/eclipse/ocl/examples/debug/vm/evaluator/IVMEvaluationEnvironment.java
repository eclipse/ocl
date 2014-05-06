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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;

public interface IVMEvaluationEnvironment<T extends NamedElement> extends EvaluationEnvironment
{
	@NonNull Element getCurrentIP();
	@NonNull UnitLocation getCurrentLocation();
	@NonNull VMDebugCore getDebugCore();
	@NonNull T getDebuggableElement();
	int getDepth();
	long getID();
	@NonNull IVMModelManager getModelManager();
	@NonNull Map<String, Resource> getModelParameterVariables();
	@NonNull NamedElement getOperation();
	@Nullable IVMEvaluationEnvironment<?> getParentEvaluationEnvironment();
	@NonNull IVMRootEvaluationEnvironment<T> getRootEvaluationEnvironment();
	boolean isDeferredExecution();
	void processDeferredTasks();
	@NonNull Element setCurrentIP(@NonNull Element element);
	void throwVMException(@NonNull VMRuntimeException vmRuntimeException);
}

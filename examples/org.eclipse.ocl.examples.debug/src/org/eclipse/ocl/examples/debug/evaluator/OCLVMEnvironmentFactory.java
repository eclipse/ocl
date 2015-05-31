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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.AbstractVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

public class OCLVMEnvironmentFactory extends AbstractVMEnvironmentFactory
{
	public OCLVMEnvironmentFactory(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull IOCLVMEvaluationEnvironment createVMEvaluationEnvironment(@NonNull ExpressionInOCL executableObject, @NonNull IVMModelManager vmModelManager) {
		return new OCLVMRootEvaluationEnvironment(this, executableObject, vmModelManager, getNextEnvironmentId());
	}

	public @NonNull IOCLVMEvaluationEnvironment createVMEvaluationEnvironment(@NonNull IOCLVMEvaluationEnvironment parent, @NonNull NamedElement executableObject) {
		return new OCLVMNestedEvaluationEnvironment(parent, executableObject, getNextEnvironmentId());
	}

	public @NonNull OCLVMRootEvaluationVisitor createVMEvaluationVisitor(@NonNull IOCLVMEvaluationEnvironment evalEnv) {
		return new OCLVMRootEvaluationVisitor(evalEnv, getShell());
	}

	public @NonNull OCLVMModelManager createVMModelManager(@NonNull MetamodelManagerInternal metamodelManager) {
		return new OCLVMModelManager(metamodelManager);
	}

	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}
}

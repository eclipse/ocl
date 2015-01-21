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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.AbstractVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMModelManager;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;

public class OCLVMEnvironmentFactory extends AbstractVMEnvironmentFactory
{
	public OCLVMEnvironmentFactory(@Nullable ProjectManager projectMap) {
		super(projectMap);
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull NamedElement executableObject, @NonNull ModelManager modelManager) {
		if (executableObject instanceof ExpressionInOCL) {
			return new OCLVMRootEvaluationEnvironment(this, (ExpressionInOCL)executableObject, (IVMModelManager)modelManager, getNextEnvironmentId());
		}
		else {
			throw new IllegalArgumentException("Unsupported executableObject " + executableObject.eClass().getName());
		}
	}

	@Override
	public @NonNull IOCLVMEvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent, @NonNull NamedElement executableObject) {
		return new OCLVMNestedEvaluationEnvironment((IOCLVMEvaluationEnvironment) parent, executableObject, getNextEnvironmentId());
	}

	@Override
	public @NonNull OCLVMRootEvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv) {
		return new OCLVMRootEvaluationVisitor((IOCLVMEvaluationEnvironment)evalEnv, getShell());
	}

	public @NonNull OCLVMModelManager createModelManager(@NonNull PivotMetamodelManager metamodelManager) {
		return new OCLVMModelManager(metamodelManager);
	}
}

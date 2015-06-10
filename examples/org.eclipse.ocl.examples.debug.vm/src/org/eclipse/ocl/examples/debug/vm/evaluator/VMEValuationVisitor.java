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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;

public interface VMEValuationVisitor extends EvaluationVisitor
{
	@NonNull UnitLocation getCurrentLocation();
	@NonNull VMEvaluationEnvironment getVMEvaluationEnvironment();
	@NonNull List<UnitLocation> getLocationStack();
	@NonNull IStepperVisitor getStepperVisitor();
	void postIterate(@NonNull LoopExp element);
	void preIterate(@NonNull LoopExp element);
}

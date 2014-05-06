/**
 * <copyright>
 * 
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMRootEvaluationVisitor;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LoopExp;

public class LoopExpStepper extends CallExpStepper
{
	public static @NonNull LoopExpStepper INSTANCE = new LoopExpStepper();

	@Override
	public @Nullable Element isPostStoppable(@NonNull IVMRootEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element childElement, @Nullable Element parentElement) {
		if (parentElement instanceof LoopExp) {
			rootVMEvaluationVisitor.postIterate((LoopExp)parentElement);
		}
		return parentElement;
	}

	@Override
	public boolean isPreStoppable(@NonNull IVMRootEvaluationVisitor<?> rootVMEvaluationVisitor, @NonNull Element element) {
		rootVMEvaluationVisitor.preIterate((LoopExp)element);
		return super.isPreStoppable(rootVMEvaluationVisitor, element);
	}
}

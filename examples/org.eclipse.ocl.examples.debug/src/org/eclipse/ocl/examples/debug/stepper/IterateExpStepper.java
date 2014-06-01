/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.stepper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMRootEvaluationVisitor;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Variable;

public class IterateExpStepper extends LoopExpStepper
{
	public static @NonNull IterateExpStepper INSTANCE = new IterateExpStepper();

	@Override
	public @Nullable Element isPostStoppable(@NonNull IVMRootEvaluationVisitor<?> vmEvaluationVisitor, @NonNull Element childElement, @Nullable Object result) {
		EObject parentElement = childElement.eContainer();
		if (parentElement instanceof Variable) {
			parentElement = parentElement.eContainer();
		}
		if (parentElement instanceof IterateExp) {
			IterateExp iterateExp = (IterateExp)parentElement;
			if (childElement == iterateExp.getSource()) {
				Variable accumulator = iterateExp.getResult();
				if (accumulator != null) {
					return getFirstElement(vmEvaluationVisitor, accumulator);
				}
			}
		}
		return super.isPostStoppable(vmEvaluationVisitor, childElement, result);
	}
}

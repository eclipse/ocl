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
import org.eclipse.ocl.examples.pivot.LetExp;

public class LetExpStepper extends AbstractStepper
{
	public static @NonNull LetExpStepper INSTANCE = new LetExpStepper();

	@Override
	public @Nullable Element getFirstElement(@NonNull Element element) {
		return element instanceof LetExp ? ((LetExp)element).getVariable() : element;
	}

	@Override
	public @Nullable Element isPostStoppable(@NonNull IVMRootEvaluationVisitor<?> vmEvaluationVisitor, @NonNull Element childElement, @Nullable Object result) {
		EObject parentElement = childElement.eContainer();
		if (parentElement instanceof LetExp) {
			LetExp letExp = (LetExp)parentElement;
			if (childElement == letExp.getVariable()) {
				return getFirstElement(vmEvaluationVisitor, letExp.getIn());
			}
			return letExp;
		}
		return null;
	}
}

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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepperVisitor;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

public class OCLStepperVisitor extends AbstractExtendingVisitor<IStepper, Object> implements IStepperVisitor
{
	public static @NonNull OCLStepperVisitor INSTANCE = new OCLStepperVisitor(OCLStepperVisitor.class);
	
	protected OCLStepperVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @NonNull IStepper getStepper(@NonNull Element object) {
		return DomainUtil.nonNullState(object.accept(this));
	}

	@Override
	public @Nullable IStepper visitElement(@NonNull Element object) {
		return PostStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		return ExpressionInOCLStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitIfExp(@NonNull IfExp object) {
		return IfExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitIterateExp(@NonNull IterateExp object) {
		return IterateExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitIteratorExp(@NonNull IteratorExp object) {
		return LoopExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitLetExp(@NonNull LetExp object) {
		return LetExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitOperationCallExp(@NonNull OperationCallExp object) {
		return OperationCallExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitPropertyCallExp(@NonNull PropertyCallExp object) {
		return PropertyCallExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitVariable(@NonNull Variable object) {
		return VariableStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for OCLStepperVisitor");
	}
}

/*******************************************************************************
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.library;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;

/**
 * AbstractBinaryOperation defines the default implementation of a binary operation redirecting the
 * call-expression invocation to the return type-id form.
 */
public abstract class AbstractBinaryOperation extends AbstractOperation implements LibraryBinaryOperation
{
	public @Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		List<? extends DomainExpression> arguments = callExp.getArgument();
		DomainExpression argument0 = arguments.get(0);
		assert argument0 != null;
		Object firstArgument = evaluator.evaluate(argument0);
		return evaluate(evaluator, callExp.getTypeId(), sourceValue, firstArgument);
	}

	// Redundant declaration avoids @Override dilemma for 1.5/1.6
	public abstract @Nullable /*@Thrown*/ Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue);
}

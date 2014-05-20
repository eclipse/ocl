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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;

/**
 * AbstractUnaryOperation defines the default implementation of a unary operation redirecting the
 * call-expression invocation to the return type-id form.
 */
public abstract class AbstractUnaryOperation extends AbstractOperation implements LibraryUnaryOperation
{
	public @Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		return evaluate(evaluator, callExp.getTypeId(), sourceValue);
	}

	// Redundant declaration avoids @Override dilemma for 1.5/1.6
	public abstract @Nullable /*@Thrown*/ Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue);
}

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
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;

/**
 * LibraryUnaryOperation defines the invocation API of a unary operation using
 * <br>
 * either an evaluator call expression, source and argument array
 * <br>
 * or an evaluator return type id and arguments.
 */
public interface LibraryUnaryOperation extends LibraryOperation {
	/**
	 * Return the result of evaluating the operation on an argument.
	 * An invalid return may be indicated by throwing an exception returning Java null or OCL invalid.
	 */
	@Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue);
}

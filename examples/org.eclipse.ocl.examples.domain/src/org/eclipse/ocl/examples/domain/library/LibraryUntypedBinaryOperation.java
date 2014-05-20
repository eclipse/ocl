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

/**
 * LibraryUntypedBinaryOperation extends the invocation API of a binary operation to support using just
 * <br>
 * an evaluator and arguments.
 */
public interface LibraryUntypedBinaryOperation extends LibraryBinaryOperation, LibraryUntypedOperation
{
	@Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @Nullable Object sourceValue, @Nullable Object argumentValue) throws Exception;
}

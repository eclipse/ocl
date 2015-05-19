/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.library.AbstractUntypedBinaryOperation;

/**
 * OclAnyOclIsKindOfOperation realises the OclAny::oclIsKindOf() library operation.
 */
public class OclAnyOclIsKindOfOperation extends AbstractUntypedBinaryOperation
{
	public static final @NonNull OclAnyOclIsKindOfOperation INSTANCE = new OclAnyOclIsKindOfOperation();

	@Override
	public @NonNull Boolean evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceVal, @Nullable Object argVal) {
		StandardLibrary standardLibrary = evaluator.getStandardLibrary();
		Type sourceType = evaluator.getIdResolver().getDynamicTypeOf(sourceVal);
		Type argType = asType(argVal);
		boolean result = sourceType.conformsTo(standardLibrary, argType);	// FIXME this fails because ExecutableStandardLibrary.getMetaclass is bad
		return result;
	}
}

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
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.library.AbstractUntypedBinaryOperation;

/**
 * OclAnyOclIsKindOfOperation realises the OclAny::oclIsKindOf() library operation.
 */
public class OclAnyOclIsKindOfOperation extends AbstractUntypedBinaryOperation
{
	public static final @NonNull OclAnyOclIsKindOfOperation INSTANCE = new OclAnyOclIsKindOfOperation();

	@Override
	public @NonNull Boolean evaluate(@NonNull DomainEvaluator evaluator, @Nullable Object sourceVal, @Nullable Object argVal) {
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		DomainType sourceType = evaluator.getIdResolver().getDynamicTypeOf(sourceVal);
		DomainType argType = asType(argVal);
		boolean result = sourceType.conformsTo(standardLibrary, argType);
		return result;
	}
}

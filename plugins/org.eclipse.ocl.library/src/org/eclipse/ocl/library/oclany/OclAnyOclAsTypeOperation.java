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
package org.eclipse.ocl.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.library.AbstractUntypedBinaryOperation;
import org.eclipse.ocl.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclAnyOclAsTypeOperation realises the OclAny::oclAsType() library operation.
 */
public class OclAnyOclAsTypeOperation extends AbstractUntypedBinaryOperation
{
	public static final @NonNull OclAnyOclAsTypeOperation INSTANCE = new OclAnyOclAsTypeOperation();

	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceVal, @Nullable Object argVal) {
		if (sourceVal instanceof InvalidValueException) {
			throw (InvalidValueException)sourceVal;
		}
		Type argType = asType(argVal);
		Type sourceType = evaluator.getIdResolver().getDynamicTypeOf(sourceVal);
		StandardLibrary standardLibrary = evaluator.getStandardLibrary();
		if (sourceType.conformsTo(standardLibrary, argType)) {
			return sourceVal;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.IncompatibleOclAsTypeSourceType, sourceType, argType);
		}
	}
}

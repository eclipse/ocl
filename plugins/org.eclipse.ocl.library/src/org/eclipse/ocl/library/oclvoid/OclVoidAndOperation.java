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
package org.eclipse.ocl.library.oclvoid;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;

/**
 * OclVoidAndOperation realises the OclVoid::and() library operation.
 */
public class OclVoidAndOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclVoidAndOperation INSTANCE = new OclVoidAndOperation();

	@Override
	public @Nullable Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		if ((left == Boolean.FALSE) || (right == Boolean.FALSE)) {
			return FALSE_VALUE;
		}
		else if ((left == Boolean.TRUE) && (right == Boolean.TRUE)) {
			return TRUE_VALUE;
		}
		else if (left instanceof InvalidValueException) {
			throw (InvalidValueException)left;
		}
		else if (right instanceof InvalidValueException) {
			throw (InvalidValueException)right;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(left));
		}
	}
}

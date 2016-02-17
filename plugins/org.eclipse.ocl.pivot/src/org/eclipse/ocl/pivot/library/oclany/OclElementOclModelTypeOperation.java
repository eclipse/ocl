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
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractUntypedUnaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclElementOclModelTypeOperation realises the OclElement::oclModelType() library operation.
 * 
 * @since 1.1
 */
public class OclElementOclModelTypeOperation extends AbstractUntypedUnaryOperation
{
	public static final @NonNull OclElementOclModelTypeOperation INSTANCE = new OclElementOclModelTypeOperation();
	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Type evaluate(@NonNull Executor executor, @Nullable Object sourceVal) {
		Type sourceType = executor.getIdResolver().getDynamicTypeOf(sourceVal);
		throw new InvalidValueException(PivotMessages.IncompatibleModelType, sourceType);
	}
}

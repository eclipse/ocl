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
import org.eclipse.ocl.domain.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;

/**
 * OclAnyOclIsInvalidOperation realises the OclAny::oclIsInvalid() library operation.
 */
public class OclAnyOclIsInvalidOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull OclAnyOclIsInvalidOperation INSTANCE = new OclAnyOclIsInvalidOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object argument) {
		return argument instanceof InvalidValueException;
	}
}

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
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.domain.values.SetValue;

/**
 * OclVoidAllInstancesOperation realises the OclVoid::allInstances() library operation.
 */
public class OclVoidAllInstancesOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull OclVoidAllInstancesOperation INSTANCE = new OclVoidAllInstancesOperation();
	public static final @NonNull CollectionTypeId SET_OCL_VOID = TypeId.SET.getSpecializedId(TypeId.OCL_VOID);

	@Override
	public @NonNull SetValue evaluate(@Nullable Object sourceVal) {
		// OclVoid has a single instance: null
		return createSetOfEach(SET_OCL_VOID, (Object)null);
	}
}

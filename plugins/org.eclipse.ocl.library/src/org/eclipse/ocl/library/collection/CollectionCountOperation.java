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
package org.eclipse.ocl.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.domain.values.CollectionValue;
import org.eclipse.ocl.domain.values.IntegerValue;

/**
 * CollectionCountOperation realises the Collection::count() library operation.
 */
public class CollectionCountOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull CollectionCountOperation INSTANCE = new CollectionCountOperation();

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object left, @Nullable Object right) {
		CollectionValue leftCollectionValue = asCollectionValue(left);
		return leftCollectionValue.count(right);
	}
}

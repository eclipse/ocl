/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;

/**
 * OrderedCollectionAppendAllOperation realises the OrderedCollection::appendAll() library operation.
 */
public class OrderedCollectionAppendAllOperation extends AbstractBinaryOperation
{
	public static final @NonNull OrderedCollectionAppendAllOperation INSTANCE = new OrderedCollectionAppendAllOperation();

	@Override
	public @NonNull Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object argumentValue) {
		OrderedCollectionValue leftOrderedCollectionValue = asOrderedCollectionValue(sourceValue);
		OrderedCollectionValue rightOrderedCollectionValue = asOrderedCollectionValue(argumentValue);
		return leftOrderedCollectionValue.appendAll((CollectionTypeId) returnTypeId, rightOrderedCollectionValue);
	}
}

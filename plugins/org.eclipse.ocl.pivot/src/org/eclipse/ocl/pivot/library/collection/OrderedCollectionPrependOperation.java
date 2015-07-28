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
package org.eclipse.ocl.pivot.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;

/**
 * OrderedCollectionPrependOperation realises the OrderedCollection::prepend() library operation.
 */
public class OrderedCollectionPrependOperation extends AbstractBinaryOperation
{
	public static final @NonNull OrderedCollectionPrependOperation INSTANCE = new OrderedCollectionPrependOperation();
	
	/** @deprecated supply returnTypeId */
	@Deprecated
	public @NonNull OrderedCollectionValue evaluate(@Nullable Object sourceValue, @Nullable Object argumentValue) {
		OrderedCollectionValue left = asOrderedCollectionValue(sourceValue);
		return left.prepend(left.getTypeId(), argumentValue);
	}

	@Override
	public @NonNull OrderedCollectionValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object argumentValue) {
		OrderedCollectionValue left = asOrderedCollectionValue(sourceValue);
		return left.prepend((CollectionTypeId) returnTypeId, argumentValue);
	}
}

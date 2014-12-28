/*******************************************************************************
 * Copyright (c) 2009, 2012 E.D.Willink and others.
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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * CollectionElementTypeProperty realizes the Collection::elementType library property.
 */
public class CollectionElementTypeProperty extends AbstractProperty
{
	public static final @NonNull CollectionElementTypeProperty INSTANCE = new CollectionElementTypeProperty();

	@Override
	public @NonNull Type evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		CollectionType sourceType = asCollectionType(sourceValue);
		return ClassUtil.nonNullModel(sourceType.getElementType());
	}
}

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
package org.eclipse.ocl.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractProperty;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.pivot.CollectionType;

/**
 * CollectionLowerProperty realizes the Collection::lower() library property.
 */
public class CollectionLowerProperty extends AbstractProperty
{
	public static final @NonNull CollectionLowerProperty INSTANCE = new CollectionLowerProperty();

	@Override
	public @NonNull IntegerValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		CollectionType sourceType = asCollectionType(sourceValue);
		return sourceType.getLowerValue();
	}
}

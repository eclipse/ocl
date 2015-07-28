/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

/**
 * A CollectionTypeId provides a unique identifier for an unspecialized collection type such as Set(T).
 */
public interface CollectionTypeId extends BuiltInTypeId, TemplateableId
{
	@NonNull TypeId getElementTypeId();
	@Override
	@NonNull CollectionTypeId getGeneralizedId();
	@NonNull IntegerValue getLowerValue();
	@Override
	@NonNull String getMetaTypeName();
	/**
	 * Return a new CollectionTypeId based on the CollectionTypeId after replacing the
	 * nullFree, lower and upper bounds by isNullFree, size and size. 
	 */
	@NonNull CollectionTypeId getRespecializedId(boolean isNullFree, int size);
	@Override
	@NonNull CollectionTypeId getSpecializedId(@NonNull BindingsId templateBindings);
	@NonNull CollectionTypeId getSpecializedId(@NonNull ElementId... templateBindings);
	@NonNull CollectionTypeId getSpecializedId(@NonNull Type elementType, @Nullable Boolean isNullFree, @Nullable IntegerValue lowerValue, @Nullable UnlimitedNaturalValue upperValue);
	@NonNull UnlimitedNaturalValue getUpperValue();
	boolean isNullFree();
}
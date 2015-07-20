/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;

public class ExecutorSpecializedCollectionType extends ExecutorSpecializedType
{
	private static @NonNull CollectionTypeId getTypeId(@NonNull String name, ExecutorTypeArgument[] typeArguments) {
		int length = typeArguments.length;
		assert (1 <= length) && (length <= 4);
		BindingsId bindingsId = IdManager.getBindingsId(typeArguments[0].getTypeId(), TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
		if (length >= 2) {
			assert typeArguments[1].getTypeId() == TypeId.BOOLEAN;
			if (length >= 3) {
				assert typeArguments[2].getTypeId() == TypeId.INTEGER;
				if (length >= 4) {
					assert typeArguments[3].getTypeId() == TypeId.UNLIMITED_NATURAL;
				}	
			}	
		}	
		CollectionTypeId collectionTypeId = IdManager.getCollectionTypeId(name);
		return (CollectionTypeId) collectionTypeId.specialize(bindingsId);
	}

	public ExecutorSpecializedCollectionType(@NonNull String name, @NonNull ExecutorTypeArgument... typeArguments) {
		super(name, getTypeId(name, typeArguments));
	}

	@Override
	public @NonNull CollectionTypeId getTypeId() {
		return (CollectionTypeId) typeId;
	}
}
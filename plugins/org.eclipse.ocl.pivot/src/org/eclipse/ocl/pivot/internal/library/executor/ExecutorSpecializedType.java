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
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.MapTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.ids.ValueId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorClass;
import org.eclipse.ocl.pivot.library.LibraryFeature;

public class ExecutorSpecializedType extends AbstractExecutorClass implements ExecutorTypeArgument
{
	/** @deprecated use derived Collection/Map class */
	@Deprecated
	private static @NonNull CollectionTypeId getTypeId(@NonNull String name, ExecutorTypeArgument[] typeArguments) {
		int length = typeArguments.length;
		assert (1 <= length) && (length <= 4);
		BindingsId bindingsId = IdManager.getBindingsId(typeArguments[0].getTypeId(), TypeId.BOOLEAN, TypeId.INTEGER, TypeId.UNLIMITED_NATURAL);
		if (length >= 2) {
			ValueId valueId = (ValueId) typeArguments[1];
			assert valueId.getTypeId() == TypeId.BOOLEAN;
			if (length >= 3) {
				assert typeArguments[2] == TypeId.INTEGER;
				if (length >= 4) {
					assert typeArguments[3] == TypeId.UNLIMITED_NATURAL;
				}	
			}	
		}	
		CollectionTypeId collectionTypeId = IdManager.getCollectionTypeId(name);
		return (CollectionTypeId) collectionTypeId.specialize(bindingsId);
	}

	protected final @NonNull TypeId typeId;

	/** @deprecated use derived Collection/Map class */
	@Deprecated
	public ExecutorSpecializedType(@NonNull String name, @NonNull ExecutorTypeArgument... typeArguments) {
		super(name, 0);
		BindingsId bindingsId = IdManager.getBindingsId(typeArguments);
		if (typeArguments.length == 2) {
			MapTypeId mapTypeId = IdManager.getMapTypeId(name);
			typeId = (TypeId) mapTypeId.specialize(bindingsId);
		}
		else {
			typeId = getTypeId(name, typeArguments);
		}
	}

	protected ExecutorSpecializedType(@NonNull String name, @NonNull TypeId typeId) {
		super(name, 0);
		this.typeId = typeId;
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull Operation lookupActualOperation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public Operation lookupOperation(StandardLibrary standardLibrary, @NonNull String operationName, Type... argumentTypes) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return typeId;
	}
}
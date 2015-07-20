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
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.MapTypeId;

public class ExecutorSpecializedMapType extends ExecutorSpecializedType
{
	private static @NonNull MapTypeId getTypeId(@NonNull String name, ExecutorTypeArgument[] typeArguments) {
		assert typeArguments.length == 2;
		BindingsId bindingsId = IdManager.getBindingsId(typeArguments);
		MapTypeId mapTypeId = IdManager.getMapTypeId(name);
		return (MapTypeId) mapTypeId.specialize(bindingsId);
	}

	public ExecutorSpecializedMapType(@NonNull String name, @NonNull ExecutorTypeArgument... typeArguments) {
		super(name, getTypeId(name, typeArguments));
	}

	@Override
	public @NonNull MapTypeId getTypeId() {
		return (MapTypeId) typeId;
	}
}
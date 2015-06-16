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
package org.eclipse.ocl.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 */
public abstract class AbstractProperty extends AbstractFeature implements LibraryProperty
{
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		throw new UnsupportedOperationException();	// Mars SR0 clients may override.
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull NavigationCallExp callExp, @Nullable Object sourceValue) {
		return evaluate(executor, callExp.getTypeId(), sourceValue);
	}
}

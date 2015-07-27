/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractUntypedUnaryOperation;

/**
 * OclAnyOclTypeOperation realises the OclAny::oclType() library operation.
 */
public class CollectionStaticTypeOperation extends AbstractUntypedUnaryOperation
{
	public static final @NonNull CollectionStaticTypeOperation INSTANCE = new CollectionStaticTypeOperation();

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Type evaluate(@NonNull Executor executor, @Nullable Object sourceVal) {
//		return executor.getStaticTypeOf(sourceVal);
		return executor.getIdResolver().getStaticTypeOf(sourceVal);
	}
}

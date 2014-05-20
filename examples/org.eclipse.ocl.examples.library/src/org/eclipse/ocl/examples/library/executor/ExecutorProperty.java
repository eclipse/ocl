/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;

public class ExecutorProperty extends AbstractExecutorProperty		 // FIXME Make abstract merging AbstractExecutorProperty, eliminating 'implementation'
{
	@Deprecated
	private static @NonNull LibraryProperty UNSUPPORTED = new LibraryProperty()
		{
			public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
				throw new UnsupportedOperationException();
		}
	};

	@Deprecated			// Moved to ExecutorPropertyWithImplementation
	protected final @NonNull LibraryProperty implementation;
	
	protected ExecutorProperty(@NonNull String name, @NonNull DomainInheritance executorType, int propertyIndex) {
		super(name, executorType, propertyIndex);
		this.implementation = UNSUPPORTED;
	}
	
	@Deprecated
	public ExecutorProperty(@NonNull String name, @NonNull DomainInheritance executorType, int propertyIndex, @NonNull LibraryProperty implementation) {
		super(name, executorType, propertyIndex);
		this.implementation = implementation;
	}

	public @NonNull LibraryProperty getImplementation() {
		return implementation;
	}
}
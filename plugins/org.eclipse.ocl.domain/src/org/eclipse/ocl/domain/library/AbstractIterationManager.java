/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.domain.values.CollectionValue;
import org.eclipse.ocl.pivot.StandardLibrary;

public abstract class AbstractIterationManager implements DomainIterationManager
{
	protected final @NonNull DomainEvaluator evaluator;

	public AbstractIterationManager(@NonNull DomainEvaluator evaluator) {
		this.evaluator = evaluator;
	}

	@Override
	public @NonNull DomainIterationManager createNestedIterationManager(@NonNull CollectionValue value) {
		throw new UnsupportedOperationException();	// Only required for single iterator managers
	}

	@Override
	public void dispose() {
		evaluator.dispose();
	}

	@Override
	public @Nullable Object get() {
		throw new UnsupportedOperationException();	// Only required for single iterator managers
	}
	
	@Override
	public @NonNull DomainEvaluator getEvaluator() {
		return evaluator;
	}

	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return evaluator.getStandardLibrary();
	}
}
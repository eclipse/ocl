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
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

public class EvaluatorSingleIterationManager extends EvaluatorIterationManager
{
	class Nested extends EvaluatorSingleIterationManager
	{
		protected final @NonNull EvaluatorSingleIterationManager rootIterationManager;
		protected final int depth;

		protected Nested(@NonNull EvaluatorSingleIterationManager iterationManager, @NonNull CollectionValue value) {
			super(iterationManager, value);
			this.rootIterationManager = iterationManager.getRootIterationManager();
			this.depth = iterationManager.getDepth() + 1;
		}

		@Override
		public int getDepth() {
			return depth;
		}
		
		@Override
		public @NonNull EvaluatorSingleIterationManager getRootIterationManager() {
			return rootIterationManager;
		}

		@Override
		public @NonNull CollectionValue getSourceCollection() {
			return rootIterationManager.getSourceCollection();
		}
	}

	protected final @NonNull DomainTypedElement referredIterator;
	protected final @NonNull ValueIterator iterator;

	public EvaluatorSingleIterationManager(@NonNull DomainEvaluator invokingEvaluator,
			@NonNull DomainExpression body, @NonNull CollectionValue collectionValue,
			@Nullable DomainTypedElement accumulator, @Nullable Object accumulatorValue,
			@NonNull DomainTypedElement referredIterator) {
		super(invokingEvaluator.createNestedEvaluator(), body, collectionValue, accumulator, accumulatorValue);
		this.referredIterator = referredIterator;
		this.iterator = new ValueIterator(evaluator, collectionValue, referredIterator);
	}

	protected EvaluatorSingleIterationManager(@NonNull EvaluatorSingleIterationManager iterationManager, @NonNull CollectionValue value) {
		super(iterationManager, value);
		this.referredIterator = iterationManager.referredIterator;
		this.iterator = new ValueIterator(evaluator, collectionValue, referredIterator);
	}

	public boolean advanceIterators() {
		iterator.next();
		return hasCurrent();
	}

	@Override
	public @NonNull DomainIterationManager createNestedIterationManager(@NonNull CollectionValue value) {
		return new Nested(this, value);
	}

	@Override
	public @Nullable Object get() {
		return iterator.get();
	}

	public int getDepth() {
		return 0;
	}
	
	public @NonNull EvaluatorSingleIterationManager getRootIterationManager() {
		return this;
	}

	public boolean hasCurrent() {
		return iterator.hasCurrent();
	}
}
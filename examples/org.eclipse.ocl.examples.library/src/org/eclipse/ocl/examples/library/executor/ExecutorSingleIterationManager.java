/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.executor;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIterationManager;
import org.eclipse.ocl.examples.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public class ExecutorSingleIterationManager extends AbstractIterationManager
{	
	class Nested extends ExecutorSingleIterationManager
	{
		protected final @NonNull ExecutorSingleIterationManager rootIterationManager;
		protected final int depth;

		protected Nested(@NonNull ExecutorSingleIterationManager iterationManager, @NonNull CollectionValue value) {
			super(iterationManager, value);
			this.rootIterationManager = iterationManager.getRootIterationManager();
			this.depth = iterationManager.getDepth() + 1;
		}

		@Override
		public int getDepth() {
			return depth;
		}
		
		@Override
		public @NonNull ExecutorSingleIterationManager getRootIterationManager() {
			return rootIterationManager;
		}

		@Override
		public @NonNull CollectionValue getSourceCollection() {
			return rootIterationManager.getSourceCollection();
		}
	}
	
	protected final @NonNull CollectionValue collectionValue;
	protected final @NonNull TypeId returnTypeId;
	protected final @NonNull LibraryBinaryOperation body;
	private @Nullable Object accumulatorValue;
	protected final @NonNull Iterator<? extends Object> iteratorValue;
	private Object currentValue;		// 'null' is a valid value so 'iteratorValue' is used as end of iteration

	public ExecutorSingleIterationManager(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @NonNull LibraryBinaryOperation body,
			@Nullable CollectionValue value, @Nullable Object accumulatorValue) {
		super(evaluator);
		this.collectionValue = ValuesUtil.asCollectionValue(value);
		this.returnTypeId = returnTypeId;
		this.body = body;
		updateAccumulator(accumulatorValue);
		this.iteratorValue = collectionValue.iterator();
		advanceIterators();
	}

	protected ExecutorSingleIterationManager(@NonNull ExecutorSingleIterationManager iterationManager, @NonNull CollectionValue collectionValue) {
		super(iterationManager.getEvaluator());
		this.collectionValue = collectionValue;
		this.returnTypeId = iterationManager.returnTypeId;
		this.body = iterationManager.body;
		this.accumulatorValue = iterationManager.accumulatorValue;
		this.iteratorValue = collectionValue.iterator();
		advanceIterators();
	}
	
	public boolean advanceIterators() {
		currentValue = iteratorValue.hasNext() ? iteratorValue.next() : iteratorValue;
		return currentValue != iteratorValue;
	}

	@Override
	public @NonNull DomainIterationManager createNestedIterationManager(@NonNull CollectionValue value) {
		return new Nested(this, value);
	}

	public @Nullable Object evaluateBody() {
		return body.evaluate(evaluator, returnTypeId, accumulatorValue, get());
	}

	@Override
	public @Nullable Object get() {
		return currentValue;
	}

	public @Nullable Object getAccumulatorValue() {
		return accumulatorValue;
	}

	public int getDepth() {
		return 0;
	}
	
	public @NonNull ExecutorSingleIterationManager getRootIterationManager() {
		return this;
	}

	public @NonNull CollectionValue getSourceCollection() {
		return collectionValue;
	}
	
	public boolean hasCurrent() {
		return currentValue != iteratorValue;
	}

	public @Nullable Object updateAccumulator(Object newValue) {
		this.accumulatorValue = newValue;
		return null;					// carry on
	}
}
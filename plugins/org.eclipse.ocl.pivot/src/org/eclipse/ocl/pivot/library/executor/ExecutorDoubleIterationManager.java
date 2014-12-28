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
package org.eclipse.ocl.pivot.library.executor;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIterationManager;
import org.eclipse.ocl.pivot.library.LibraryTernaryOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;

public class ExecutorDoubleIterationManager extends AbstractIterationManager
{	
	protected final @NonNull TypeId returnTypeId;
	protected final @NonNull LibraryTernaryOperation body;
	private @Nullable Object accumulatorValue;
	protected final @NonNull CollectionValue collectionValue;
	private @NonNull Iterator<? extends Object> iteratorValue1;
	private final @NonNull Iterator<? extends Object> iteratorValue2;
	private Object currentValue1;
	private Object currentValue2;
	
	public ExecutorDoubleIterationManager(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @NonNull LibraryTernaryOperation body,
			@Nullable CollectionValue collectionValue, @Nullable Object accumulatorValue) {
		super(evaluator);
		this.returnTypeId = returnTypeId;
		this.body = body;
		this.accumulatorValue = accumulatorValue;
		this.collectionValue = ValueUtil.asCollectionValue(collectionValue);
		this.iteratorValue1 = this.collectionValue.iterator();
		this.iteratorValue2 = this.collectionValue.iterator();
		currentValue1 = iteratorValue1.hasNext() ? iteratorValue1.next() : null;
		currentValue2 = iteratorValue2.hasNext() ? iteratorValue2.next() : null;
	}
	
	@Override
	public boolean advanceIterators() {
		if (iteratorValue1.hasNext()) {
			currentValue1 = iteratorValue1.next();
		}
		else if (iteratorValue2.hasNext()) {
			currentValue2 = iteratorValue2.next();
			iteratorValue1 = collectionValue.iterator();
			currentValue1 = iteratorValue1.hasNext() ? iteratorValue1.next() : null;
		}
		else {
			currentValue1 = null;
			currentValue2 = null;
		}
		return currentValue1 != null;
	}

	@Override
	public @Nullable Object evaluateBody() {
		return body.evaluate(evaluator, returnTypeId, accumulatorValue,
			ClassUtil.nonNullState(currentValue1), ClassUtil.nonNullState(currentValue2));
	}

	@Override
	public @Nullable Object getAccumulatorValue() {
		return accumulatorValue;
	}

	@Override
	public @NonNull CollectionValue getSourceCollection() {
		return collectionValue;
	}
	
	@Override
	public boolean hasCurrent() {
		return currentValue1 != null;
	}

	@Override
	public @Nullable Object updateAccumulator(Object newValue) {
		this.accumulatorValue = newValue;
		return null;					// carry on
	}
}
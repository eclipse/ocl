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
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

public class EvaluatorMultipleIterationManager extends EvaluatorIterationManager
{
	protected final ValueIterator[] iterators;
	protected boolean hasCurrent;
	
	public EvaluatorMultipleIterationManager(@NonNull DomainEvaluator invokingEvaluator, @NonNull DomainExpression body, @NonNull CollectionValue collectionValue,
			@Nullable DomainTypedElement accumulator, @Nullable Object accumulatorValue, DomainTypedElement... referredIterators) {
		super(invokingEvaluator.createNestedEvaluator(), body, collectionValue, accumulator, accumulatorValue);
		int iMax = referredIterators.length;
		ValueIterator[] iterators = new ValueIterator[iMax];
		for (int i = 0; i < iMax; i++) {
			DomainTypedElement referredIterator = referredIterators[i];
			if (referredIterator != null) {
				ValueIterator valueIterator = new ValueIterator(evaluator, collectionValue, referredIterator);
				if (!valueIterator.hasCurrent()) {
					this.iterators = null;
					this.hasCurrent = false;
					return;
				}
				iterators[i] = valueIterator;
			}
		}
		this.iterators = iterators;
		this.hasCurrent = true;
	}
	
	public boolean advanceIterators() {
		if (hasCurrent) {
			for (ValueIterator advancingIterator : iterators) {
				advancingIterator.next();
				if (advancingIterator.hasCurrent()) {
					for (ValueIterator previousIterator : iterators) {
						if (previousIterator == advancingIterator) {
							return true;
						}
						previousIterator.reset();
					}
				}			
			}
			hasCurrent = false;
		}
		return false;
	}

	public @NonNull Object get(int i) {
		Object currentValue = iterators[i].get();
		if (currentValue == null) {
			throw new IllegalStateException("cannot get() after iteration complete"); //$NON-NLS-1$
		}
		return currentValue;		
	}
	
	public boolean hasCurrent() {
		return hasCurrent;
	}
}
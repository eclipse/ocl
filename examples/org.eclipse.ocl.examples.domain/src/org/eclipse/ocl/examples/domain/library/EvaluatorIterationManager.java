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

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.CollectionValue;

public abstract class EvaluatorIterationManager extends AbstractIterationManager
{
	protected static class ValueIterator
	{
		private final DomainEvaluationEnvironment evaluationEnvironment;
		private final @NonNull CollectionValue collectionValue;
		private final @NonNull DomainTypedElement variable;
		private Iterator<? extends Object> javaIter;
		private Object value;		// 'null' is a valid value so 'this' is used as end of iteration

		public ValueIterator(@NonNull DomainEvaluator evaluator, @NonNull CollectionValue collectionValue, @NonNull DomainTypedElement variable) {
			this.evaluationEnvironment = evaluator.getEvaluationEnvironment();
			this.collectionValue = collectionValue;
			this.variable = variable;
			reset();
		}
		
		public @Nullable Object get() {
			return value;
		}

		public boolean hasCurrent() {
			return value != this;
		}
		
		public @Nullable Object next() {
			if (!javaIter.hasNext()) {
				value = this;
			}
			else {
				value = javaIter.next();
				evaluationEnvironment.replace(variable, value);
//				System.out.println(name + " = " + value);
			}
			return value;
		}

		public Object reset() {
			javaIter = collectionValue.iterator();
			return next();
		}

		@Override
		public String toString() {
			return String.valueOf(variable) + " = " + (value != this ? String.valueOf(value) : "<<END>>");
		}
	}

	protected static ValueIterator[] createIterators(@NonNull DomainTypedElement[] referredIterators, @NonNull DomainEvaluator evaluator, @NonNull CollectionValue collectionValue) {
		int iMax = referredIterators.length;
		ValueIterator[] iterators = new ValueIterator[iMax];
		for (int i = 0; i < iMax; i++) {
			DomainTypedElement referredIterator = referredIterators[i];
			if (referredIterator != null) {
				ValueIterator valueIterator = new ValueIterator(evaluator, collectionValue, referredIterator);
				if (!valueIterator.hasCurrent()) {
					return null;
				}
				iterators[i] = valueIterator;
			}
		}
		return iterators;
	}

	protected final @NonNull CollectionValue collectionValue;
	protected final @NonNull DomainExpression body;
	protected final @Nullable DomainTypedElement accumulatorVariable;
	private @Nullable Object accumulatorValue;

	public EvaluatorIterationManager(@NonNull DomainEvaluator evaluator, @NonNull DomainExpression body, @NonNull CollectionValue collectionValue,
			@Nullable DomainTypedElement accumulatorVariable, @Nullable Object accumulatorValue) {
		super(evaluator);
		this.collectionValue = collectionValue;
		this.body = body;
		this.accumulatorVariable = accumulatorVariable;
		this.accumulatorValue = accumulatorValue;
		if (accumulatorVariable != null) {
			getEvaluationEnvironment().add(accumulatorVariable, accumulatorValue);
		}
	}

	public EvaluatorIterationManager(@NonNull EvaluatorIterationManager iterationManager, @NonNull CollectionValue collectionValue) {
		super(iterationManager.evaluator);
		this.body = iterationManager.body;
		this.collectionValue = collectionValue;
		this.accumulatorValue = iterationManager.accumulatorValue;
		this.accumulatorVariable = iterationManager.accumulatorVariable;
	}

	public @Nullable Object evaluateBody() {
		return evaluator.evaluate(body);
	}
	
	public @Nullable Object getAccumulatorValue() {
		return accumulatorValue;
	}
	
	public @NonNull CollectionValue getCollectionValue() {
		return collectionValue;
	}

	public @NonNull DomainEvaluationEnvironment getEvaluationEnvironment() {
		return evaluator.getEvaluationEnvironment();
	}

	public @NonNull CollectionValue getSourceCollection() {
		return collectionValue;
	}

	@Override
	public String toString() {
//		return body.eContainer().toString();
		return body.toString();
	}

	public @Nullable Object updateAccumulator(Object newValue) {
		this.accumulatorValue = newValue;
		DomainTypedElement accumulatorVariable2 = accumulatorVariable;
		if (accumulatorVariable2 != null) {
			getEvaluationEnvironment().replace(accumulatorVariable2, accumulatorValue);
		}
		return null;					// carry on
	}
}
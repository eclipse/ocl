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
package org.eclipse.ocl.pivot.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * ClosureIteration realizes the Collection::closure() library iteration.
 */
public class ClosureIteration extends AbstractIteration
{
	public static final @NonNull ClosureIteration INSTANCE = new ClosureIteration();

	@Override
	public @NonNull CollectionValue.Accumulator createAccumulatorValue(@NonNull Evaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createCollectionAccumulatorValue((CollectionTypeId) accumulatorTypeId);
	}

	/**
	 * Recursively evaluates the iterator body expression.
	 * @throws Exception 
	 */
    @Override
	protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		// The parent is the iterator
		Object value = iterationManager.get();
		CollectionValue.Accumulator accumulatorValue = (CollectionValue.Accumulator)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		if (!accumulatorValue.add(value)) {
			return CARRY_ON;
		}
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal instanceof InvalidValueException) {
			throw (InvalidValueException)bodyVal;				// FIXME Analyze away
		}
		if (bodyVal == null) {
			return iterationManager.getAccumulatorValue();		// Null body is termination
		}
		CollectionValue collectionValue;
		if (bodyVal instanceof CollectionValue) {
			collectionValue = (CollectionValue) bodyVal;
		}
		else {
			Evaluator evaluator = iterationManager.getEvaluator();
			Type elementType = evaluator.getStaticTypeOf(bodyVal);
			CollectionTypeId sequenceId = TypeId.SEQUENCE.getSpecializedId(elementType.getTypeId());
			collectionValue = evaluator.getIdResolver().createSequenceOfEach(sequenceId, bodyVal);
		}
		evaluateIteration(iterationManager.createNestedIterationManager(collectionValue));
		return CARRY_ON;
	}
}

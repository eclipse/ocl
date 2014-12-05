/*******************************************************************************
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractIteration;
import org.eclipse.ocl.domain.values.CollectionValue;

/**
 * CollectIteration realizes the Collection::collect() library iteration.
 */
public class CollectIteration extends AbstractIteration
{
	public static final @NonNull CollectIteration INSTANCE = new CollectIteration();

	@Override
	public @NonNull CollectionValue.Accumulator createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createCollectionAccumulatorValue((CollectionTypeId) accumulatorTypeId);
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		CollectionValue.Accumulator accumulatorValue = (CollectionValue.Accumulator)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		if (bodyVal == null) {
			accumulatorValue.add(bodyVal);
		}
		else if (bodyVal instanceof CollectionValue) {
			CollectionValue bodyColl = (CollectionValue) bodyVal;
//			try {
				for (Object value : bodyColl.flatten().iterable()) {
					if (value != null) {
						accumulatorValue.add(value);
					}
				}
//			} catch (InvalidValueException e) {
//				iterationManager.throwInvalidEvaluation(e);
//			}
		}
		else
			accumulatorValue.add(bodyVal);
		return CARRY_ON;								// Carry on
	}
}

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
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractIteration;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.InvalidValueException;

/**
 * OnlyIteration realizes the Collection::only() library iteration.
 */
public class OnlyIteration extends AbstractIteration
{
	public static final @NonNull OnlyIteration INSTANCE = new OnlyIteration();

	@Override
	public @NonNull Object createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new MutableObject(null);
	}
	
	@Override
	protected @NonNull Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		Object object = accumulatorValue.get();
		if (object != null) {
			return object;		// Normal something found result.
		}
		else {
			throw new InvalidValueException("No matching content for 'only'"); //$NON-NLS-1$
		}
	}
	
	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal == null) {
			throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "only"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal == Boolean.FALSE) {
			return CARRY_ON;									// Carry on for nothing found
		}
		else if (bodyVal != Boolean.TRUE) {
			throw new InvalidValueException(EvaluatorMessages.NonBooleanBody, "only"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		else {
			MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			Object object = accumulatorValue.get();
			if (object != null) {
				throw new InvalidValueException("Multiple matching content for 'only'"); //$NON-NLS-1$
			}
			else {
				Object value = iterationManager.get();		
				accumulatorValue.set(value);
				return CARRY_ON;									// Carry on after first find
			}
		}
	}
}

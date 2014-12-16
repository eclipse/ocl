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
import org.eclipse.ocl.pivot.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.evaluation.DomainIterationManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * AnyIteration realizes the Collection::any() library iteration.
 */
public class AnyIteration extends AbstractIteration
{
	public static final @NonNull AnyIteration INSTANCE = new AnyIteration();

	@Override
	public @NonNull Object createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return INSTANCE;		// Not used
	}
	
	@Override
	protected @Nullable Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
//		return null;
		throw new InvalidValueException("No matching content for 'any'"); // OMG Issue 18504 //$NON-NLS-1$
	}
	
	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal == null) {
			throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "any"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal == Boolean.FALSE) {
			return CARRY_ON;								// Carry on for nothing found
		}
		else if (bodyVal != Boolean.TRUE) {
			throw new InvalidValueException(EvaluatorMessages.NonBooleanBody, "any"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		else {
			Object value = iterationManager.get();		
			return value;									// Terminate after first find
		}
	}
}

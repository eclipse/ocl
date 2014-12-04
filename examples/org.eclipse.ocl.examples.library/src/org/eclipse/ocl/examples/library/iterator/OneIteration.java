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
package org.eclipse.ocl.examples.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * OneIteration realizes the Collection::one() library iteration.
 */
public class OneIteration extends AbstractIteration
{
	public static class MutableBoolean 
	{
		private boolean value = false;
		
		public boolean isSet() {
			return value;
		}
		
		public void set() {
			this.value = true;
		}
	}

	public static final @NonNull OneIteration INSTANCE = new OneIteration();

	@Override
	public @NonNull MutableBoolean createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new MutableBoolean();
	}

	@Override
	protected @NonNull
	Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		MutableBoolean accumulatorValue = (MutableBoolean) iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		return accumulatorValue.isSet() != false;			// FIXME redundant test to suppress warning
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal == null) {
			throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "one"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal == Boolean.FALSE) {
			return CARRY_ON;								// Carry on for nothing found
		}
		else if (bodyVal != Boolean.TRUE) {
			throw new InvalidValueException(EvaluatorMessages.NonBooleanBody, "one"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		else {
			MutableBoolean accumulatorValue = (MutableBoolean) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			if (accumulatorValue.isSet()) {
				return Boolean.FALSE;						// Abort after second find
			}
			else {
				accumulatorValue.set();
				return CARRY_ON;							// Carry on after first find
			}
		}
	}
}

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
import org.eclipse.ocl.examples.domain.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractIteration;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * ForAllIteration realizes the Collection::forAll() library iteration.
 */
public class ForAllIteration extends AbstractIteration
{
	public static final @NonNull ForAllIteration INSTANCE = new ForAllIteration();

	public @NonNull Object createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new MutableObject(Boolean.TRUE);
	}

	@Override
	protected @Nullable Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		Object object = accumulatorValue.get();
		if ((object == null) || (object == Boolean.TRUE)) {
			return object;
		}
		throw (InvalidValueException)object;
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		try {
			Object bodyVal = iterationManager.evaluateBody();
			if (bodyVal == Boolean.FALSE) {
				return Boolean.FALSE;							// Abort after a find
			}
			else if (bodyVal == Boolean.TRUE) {
				return CARRY_ON;						// Carry on for nothing found
			}
			else if (bodyVal == null) {
				MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
				assert accumulatorValue != null;
				if (accumulatorValue.get() == Boolean.TRUE) {
					accumulatorValue.set(null);
				}
				return CARRY_ON;						// Carry on for nothing found
			}
			else {
				throw new InvalidValueException(EvaluatorMessages.NonBooleanBody, "exists"); 	// Non boolean body is invalid //$NON-NLS-1$
			}
		}
		catch (EvaluationHaltedException e) {
			throw e;
		}
		catch (InvalidValueException e) {
			MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			accumulatorValue.set(e);
			return CARRY_ON;							// Carry on for nothing found
		}
		catch (Exception e) {
			MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			accumulatorValue.set(ValuesUtil.createInvalidValue(e));
			return CARRY_ON;							// Carry on for nothing found
		}
	}
}

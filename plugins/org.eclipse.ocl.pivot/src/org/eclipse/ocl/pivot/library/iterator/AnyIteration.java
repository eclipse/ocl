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
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * AnyIteration realizes the Collection::any() library iteration.
 */
public class AnyIteration extends AbstractIteration
{
	private static class MutableObject 
	{
		private static final @NonNull Object NOT_SET = MutableObject.class;	
		private Object value = NOT_SET;	
	}

	public static final @NonNull AnyIteration INSTANCE = new AnyIteration();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull Object createAccumulatorValue(@NonNull Evaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createAccumulatorValue(ValueUtil.getExecutor(evaluator), accumulatorTypeId, bodyTypeId);
	}
	
	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Object createAccumulatorValue(@NonNull Executor executor, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new MutableObject();
	}
	
	@Override
	protected @Nullable Object resolveTerminalValue(@NonNull IterationManager iterationManager) {
		MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;												// createAccumulatorValue is @NonNull
		if (accumulatorValue.value != MutableObject.NOT_SET) {
			return accumulatorValue.value;
		}
		throw new InvalidValueException("No matching content for 'any'"); // OMG Issue 18504 //$NON-NLS-1$
	}
	
	@Override
    protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal == Boolean.TRUE) {
			MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;												// createAccumulatorValue is @NonNull
			if (accumulatorValue.value == MutableObject.NOT_SET) {
				accumulatorValue.value = iterationManager.get();
			}
		}
		else if ((bodyVal != null) && (bodyVal != Boolean.FALSE)) {
			throw new InvalidValueException(PivotMessages.UndefinedBody, "any"); 	// Null body is invalid //$NON-NLS-1$
		}
		return CARRY_ON;								// Carry on till all possible invalids detected
	}
}

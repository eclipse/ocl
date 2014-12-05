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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.evaluation.DomainIterationManager;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractIteration;
import org.eclipse.ocl.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.Value;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.domain.values.impl.ValueImpl;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.library.LibraryConstants;

/**
 * SelectIteration realizes the Collection::sortedBy() library iteration.
 */
public class SortedByIteration extends AbstractIteration
{
	protected static class SortingValue extends ValueImpl implements Comparator<Object>
	{
		protected final @NonNull CollectionTypeId typeId;
		private final @NonNull DomainEvaluator evaluator;
		private final boolean isUnique;
		private final @NonNull LibraryBinaryOperation implementation;
		private final @NonNull Map<Object, Object> content = new HashMap<Object, Object>();	// User object to sortedBy value
		private Map<Object, Integer> repeatCounts = null;						// Repeat counts for non-unique content

		public SortingValue(@NonNull DomainEvaluator evaluator, @NonNull CollectionTypeId returnTypeId, @NonNull LibraryBinaryOperation implementation) {
			this.typeId = returnTypeId;
			this.evaluator = evaluator;
			this.implementation = implementation;
			CollectionTypeId generalizedId = typeId.getGeneralizedId();
			isUnique = (generalizedId == TypeId.SET) || (generalizedId == TypeId.ORDERED_SET);
		}

		@Override
		public @NonNull Object asObject() {
			return content;
		}
		
		@Override
		public int compare(Object o1, Object o2) {
			if (o1 == o2) {
				return 0;
			}
			Object v1 = content.get(o1);
			Object v2 = content.get(o2);
			if (v1 == v2) {
				return 0;
			}
			else if (v1 == null) {
				return -1;
			}
			else if (v2 == null) {
				return 1;
			}
			try {
				IntegerValue comparison = ValuesUtil.asIntegerValue(implementation.evaluate(evaluator, TypeId.INTEGER, v1, v2));
				return comparison.signum();
			} catch (InvalidValueException e) {
				throw e;
			} catch (Exception e) {
				throw new InvalidValueException(e);
			}
		}

		public @NonNull Value createSortedValue() {
			List<Object> result = new ArrayList<Object>(content.keySet());
			Collections.sort(result, this);
			if (isUnique || (repeatCounts == null)) {
				return evaluator.getIdResolver().createCollectionOfAll(true, isUnique, typeId, result);
			}
			else {
				List<Object> nonUniqueResult = new ArrayList<Object>();
				for (Object resultValue : result) {
					nonUniqueResult.add(resultValue);
					Integer repeatCount = repeatCounts.get(resultValue);
					if (repeatCount != null) {
						for (int i = repeatCount; i > 0; i--) {
							nonUniqueResult.add(resultValue);
						}
					}
				}
				return evaluator.getIdResolver().createCollectionOfAll(true, false, typeId, nonUniqueResult);
			}
		}

//		public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
//			return type;
//		}

		@Override
		public @NonNull TypeId getTypeId() {
			return typeId;
		}

		public void put(@Nullable Object iterVal, @Nullable Object comparable) {
			if (content.put(iterVal, comparable) != null) {
				if (!isUnique) {
					if (repeatCounts == null) {
						repeatCounts = new HashMap<Object, Integer>();
					}
					Integer repeatCount = repeatCounts.get(iterVal);
					if (repeatCount == null) {
						repeatCount = 1;
					}
					else {
						repeatCount++;
					}
					repeatCounts.put(iterVal, repeatCount);
				}
			}
		}

		@Override
		public String toString() {
			return content.toString();
		}
	}

	public static final @NonNull SortedByIteration INSTANCE = new SortedByIteration();

	@Override
	public @NonNull SortedByIteration.SortingValue createAccumulatorValue(@NonNull DomainEvaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		DomainInheritance comparableType = standardLibrary.getOclComparableType().getInheritance(standardLibrary);
		DomainInheritance selfType = standardLibrary.getOclSelfType().getInheritance(standardLibrary);
		DomainOperation staticOperation = comparableType.lookupLocalOperation(standardLibrary, LibraryConstants.COMPARE_TO, selfType);
		if (staticOperation != null) {
			DomainClass bodyType = evaluator.getIdResolver().getClass(bodyTypeId, null);
			LibraryFeature implementation = bodyType.lookupImplementation(standardLibrary, staticOperation);
			return new SortingValue(evaluator, (CollectionTypeId)accumulatorTypeId, (LibraryBinaryOperation) implementation);
		}
		throw new InvalidValueException(EvaluatorMessages.UndefinedOperation, String.valueOf(comparableType) + "::" + LibraryConstants.COMPARE_TO); //$NON-NLS-1$
	}
	
	@Override
	protected @NonNull Object resolveTerminalValue(@NonNull DomainIterationManager iterationManager) {
		SortingValue accumulatorValue = (SortingValue) iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		return accumulatorValue.createSortedValue();
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull DomainIterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal == null) {
			throw new InvalidValueException(EvaluatorMessages.UndefinedBody, "sortedBy"); 	// Null body is invalid //$NON-NLS-1$
		}
		Object iterValue = iterationManager.get();		
		SortingValue accumulatorValue = (SortingValue) iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		accumulatorValue.put(iterValue, bodyVal);
		return CARRY_ON;										// Carry on
	}
}

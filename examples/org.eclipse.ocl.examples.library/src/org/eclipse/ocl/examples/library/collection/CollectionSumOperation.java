/**
 * <copyright>
 *
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.numeric.NumericPlusOperation;

/**
 * CollectionSumOperation realises the Collection::sum() library operation.
 */
public class CollectionSumOperation extends AbstractUnaryOperation
{
	public static final @NonNull CollectionSumOperation INSTANCE = new CollectionSumOperation();

	@Override
	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		CollectionValue collectionValue = asCollectionValue(sourceVal);
		// FIXME Bug 301351 Look for user-defined zero
//			resultType.getZero();
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		DomainType returnType = evaluator.getIdResolver().getType(returnTypeId, null);
		Object result;
		if (returnType.conformsTo(standardLibrary, standardLibrary.getIntegerType())) {
			result = ValuesUtil.integerValueOf(0);
		}
		else {
			result = ValuesUtil.realValueOf(0.0);
		}
        for (Object element : collectionValue.iterable()) {
        	result = NumericPlusOperation.INSTANCE.evaluate(result, element);
        }
        return result;
	}
}

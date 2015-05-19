/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUntypedBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OclComparableComparisonOperation provides the abstract support for a comparison operation.
 */
public abstract class OclComparableComparisonOperation extends AbstractUntypedBinaryOperation
{
	@Override
	public @NonNull Boolean evaluate(@NonNull Evaluator evaluator, @Nullable Object left, @Nullable Object right) {
		StandardLibrary standardLibrary = evaluator.getStandardLibrary();
		CompleteInheritance leftType = evaluator.getIdResolver().getDynamicTypeOf(left).getInheritance(standardLibrary);
		CompleteInheritance rightType = evaluator.getIdResolver().getDynamicTypeOf(right).getInheritance(standardLibrary);
		CompleteInheritance commonType = leftType.getCommonInheritance(rightType);
		CompleteInheritance comparableType = standardLibrary.getOclComparableType().getInheritance(standardLibrary);
		CompleteInheritance selfType = standardLibrary.getOclSelfType().getInheritance(standardLibrary);
		Operation staticOperation = comparableType.lookupLocalOperation(standardLibrary, LibraryConstants.COMPARE_TO, selfType);
		int intComparison;
		LibraryBinaryOperation implementation = null;
		try {
			if (staticOperation != null) {
				implementation = (LibraryBinaryOperation) commonType.lookupImplementation(standardLibrary, staticOperation);
			}
		} catch (Exception e) {
			throw new InvalidValueException(e, "No 'compareTo' implementation"); //$NON-NLS-1$
		}
		if (implementation != null) {
			Object comparison = implementation.evaluate(evaluator, TypeId.INTEGER, left, right);
			intComparison = ValueUtil.asInteger(comparison);
			return getResultValue(intComparison) != false;			// FIXME redundant test to suppress warning
		}
		else {
			throw new InvalidValueException("Unsupported compareTo for ''{0}''", left != null ? left.getClass().getName() : NULL_STRING); //$NON-NLS-1$
		}
	}

	protected abstract boolean getResultValue(Integer comparison);
}

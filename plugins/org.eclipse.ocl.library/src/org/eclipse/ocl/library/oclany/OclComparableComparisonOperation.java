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
package org.eclipse.ocl.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractUntypedBinaryOperation;
import org.eclipse.ocl.domain.library.LibraryBinaryOperation;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.library.LibraryConstants;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;

/**
 * OclComparableComparisonOperation provides the abstract support for a comparison operation.
 */
public abstract class OclComparableComparisonOperation extends AbstractUntypedBinaryOperation
{
	@Override
	public @NonNull Boolean evaluate(@NonNull DomainEvaluator evaluator, @Nullable Object left, @Nullable Object right) {
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
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
				implementation = (LibraryBinaryOperation) commonType.getType().lookupImplementation(standardLibrary, staticOperation);
			}
		} catch (Exception e) {
			throw new InvalidValueException(e, "No 'compareTo' implementation"); //$NON-NLS-1$
		}
		if (implementation != null) {
			Object comparison = implementation.evaluate(evaluator, TypeId.INTEGER, left, right);
			intComparison = ValuesUtil.asInteger(comparison);
			return getResultValue(intComparison) != false;			// FIXME redundant test to suppress warning
		}
		else {
			throw new InvalidValueException("Unsupported compareTo for ''{0}''", left != null ? left.getClass().getName() : NULL_STRING); //$NON-NLS-1$
		}
	}

	protected abstract boolean getResultValue(Integer comparison);
}

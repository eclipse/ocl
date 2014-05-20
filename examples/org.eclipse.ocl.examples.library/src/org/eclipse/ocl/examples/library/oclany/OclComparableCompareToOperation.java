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
package org.eclipse.ocl.examples.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * OclComparableCompareToOperation realizes the abstract compareTo library operation using intrinsic Java functionality.
 */
public class OclComparableCompareToOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull OclComparableCompareToOperation INSTANCE = new OclComparableCompareToOperation();

	@Override
	public @NonNull Object evaluate(@Nullable Object left, @Nullable Object right) {
		Object leftObject = asObject(left);
		Object rightObject = asObject(right);
		if (left == null) {
			return ValuesUtil.integerValueOf(right == null);
		}
		if (!(leftObject instanceof Comparable<?>)) {
			throw new InvalidValueException("Unsupported compareTo for ''{0}''", left.getClass().getName()); //$NON-NLS-1$
		}
		@SuppressWarnings("unchecked")
		int intComparison = ((Comparable<Object>)leftObject).compareTo(rightObject);
		return ValuesUtil.integerValueOf(intComparison);
	}
}

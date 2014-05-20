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
package org.eclipse.ocl.examples.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.AbstractSimpleTernaryOperation;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 * StringSubstringOperation realises the String::substring() library operation.
 */
public class StringSubstringOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull StringSubstringOperation INSTANCE = new StringSubstringOperation();

	@Override
	public @NonNull String evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String sourceString = asString(sourceValue);
		Integer startInteger = asInteger(firstArgumentValue);
		Integer endInteger = asInteger(secondArgumentValue);
		int size = sourceString.length();
		int lower = startInteger.intValue();
		int upper = endInteger.intValue();
		if ((0 < lower) && (lower <= upper) && (upper <= size)) {
			@SuppressWarnings("null")@NonNull String result = sourceString.substring(lower-1, upper);
			return result;
		}
		else {
			throw new InvalidValueException(DomainUtil.bind(EvaluatorMessages.IndexesOutOfRange, lower, upper, size));
		}
	}
}

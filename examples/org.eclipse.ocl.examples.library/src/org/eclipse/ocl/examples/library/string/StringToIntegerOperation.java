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
import org.eclipse.ocl.examples.domain.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

/**
 * StringToIntegerOperation realises the String::toInteger() library operation.
 */
public class StringToIntegerOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull StringToIntegerOperation INSTANCE = new StringToIntegerOperation();

	@Override
	public @NonNull IntegerValue evaluate(@Nullable Object sourceVal) {
		String sourceString = asString(sourceVal);
		@SuppressWarnings("null") @NonNull String result = sourceString.trim();
		return ValuesUtil.integerValueOf(result);
	}
}

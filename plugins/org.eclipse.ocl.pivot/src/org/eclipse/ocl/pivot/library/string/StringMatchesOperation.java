/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

/**
 * StringMatchesOperation realises the String::matches() library operation.
 */
public class StringMatchesOperation extends AbstractBinaryOperation
{
	public static final @NonNull StringMatchesOperation INSTANCE = new StringMatchesOperation();

	@Override
	public @NonNull Boolean evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object left, @Nullable Object right) {
		String leftString = asString(left);
		String rightString = asString(right);
		Pattern pattern = evaluator.getRegexPattern(rightString);
		Matcher matcher = pattern.matcher(leftString);
		return matcher.matches() == true;
	}
}

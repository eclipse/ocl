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
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.library.oclany.OclAnyOclAsTypeOperation;

/**
 * UnlimitedNaturalOclAsTypeOperation realizes the UnlimitedNatural::oclAsType() library operation.
 */
public class UnlimitedNaturalOclAsTypeOperation extends OclAnyOclAsTypeOperation
{
	public static final @NonNull UnlimitedNaturalOclAsTypeOperation INSTANCE = new UnlimitedNaturalOclAsTypeOperation();

	@Override
	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @Nullable Object sourceVal, @Nullable Object argVal) {
		DomainStandardLibrary standardLibrary = evaluator.getStandardLibrary();
		DomainType sourceType = evaluator.getStaticTypeOf(sourceVal);
		DomainType argType = asType(argVal);
		if (sourceType.conformsTo(standardLibrary, argType)) {
			if (isUnlimited(sourceVal) && ((argType == standardLibrary.getRealType()) || (argType == standardLibrary.getIntegerType()))) {
				throw new InvalidValueException(EvaluatorMessages.NonFiniteIntegerValue);
			}
			assert sourceVal != null;
			return sourceVal;
		}
		else {
			throw new InvalidValueException(EvaluatorMessages.IncompatibleOclAsTypeSourceType, sourceType, argType);
		}
	}
}

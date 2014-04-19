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
 *
 * $Id: LibraryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.domain.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

/**
 */
public interface LibraryOperation extends LibraryFeature
{
	/**
	 * Return the result of evaluating callExp upon sourceValue within the environment
	 * provided by evaluator. An invalid return may be indicated by throwing an exception,
	 * returning Java null, or returning OCL invalid.
	 * <p>
	 * This method should be used in preference to evaluate() since it allows the derived implementation to short circuit evluation
	 * and so avoid evlauating unwanted arguments.
	 */
	@Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue);

	/**
	 * Return the result of evaluating operationCall upon sourceVal within the environment
	 * provided by EvaluationVisitor. An invalid return may be indicated by throwing an exception
	 * returning Java null or OCL invalid.
	 *
	 * @param evaluationVisitor the evaluation context
	 * @param sourceVal the source operand for the operation
	 * @param operationCall the operation and additional arguments
	 * @return the evaluated value
	 * @throws Exception 
	 * @throws InvalidValueException 
	 */
//	Value evaluate(Evaluator evaluator, Value sourceVal, OperationCallExp operationCall)
//		throws InvalidEvaluationException, InvalidValueException;
	@Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, @NonNull Object... argumentValues);
}

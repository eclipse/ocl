/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.evaluation;

import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.types.IdResolver;

public interface DomainEvaluator
{
	@NonNull DomainEvaluator createNestedEvaluator();
	void dispose();
	@Nullable Object evaluate(@NonNull DomainExpression body);
	@NonNull DomainEvaluationEnvironment getEvaluationEnvironment();
	@NonNull IdResolver getIdResolver();

	/**
	 * Return the logger handling oclLog() invocations or null for none.
	 */
	@Nullable DomainLogger getLogger();
	
	/**
	 * Return the manager of all model instances for use by allInstances() and hidden opposite support.
	 */
	@NonNull DomainModelManager getModelManager();

	/**
	 * Return a cached matcher for a give regular expression.
	 */
	@NonNull Pattern getRegexPattern(@NonNull String regex);

	@NonNull DomainStandardLibrary getStandardLibrary();

	@NonNull DomainType getStaticTypeOf(@Nullable Object value);
	@NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Object... values);
	@NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values);
	
	/**
	 * Return true if the evaluation has been canceled.
	 */
	boolean isCanceled();
	
	/**
	 * Request cancelation of the current the evaluation, or reset the request for a new evaluation.
	 * Cancelation occurs by throwing an {@link EvaluationHaltedException} when an expression,
	 * operation or iteration is next invoked. 
	 */
	void setCanceled(boolean isCanceled);

	/**
	 * Specify the logger to handle oclLog() invocations or null for none.
	 */
	void setLogger(@Nullable DomainLogger loger);
}

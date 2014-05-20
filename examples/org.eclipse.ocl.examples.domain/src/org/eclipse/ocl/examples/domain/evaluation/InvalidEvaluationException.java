/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.domain.evaluation;

import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

@Deprecated
public class InvalidEvaluationException extends DomainException
{
	private static final long serialVersionUID = 1L;

	protected final DomainEvaluationEnvironment evaluationEnvironment;
	protected final DomainExpression expression;
	protected final Object context;

	public InvalidEvaluationException(DomainEvaluationEnvironment evaluationEnvironment, String message, Throwable e, DomainExpression expression, Object context) {
		super(message, e);
		this.evaluationEnvironment = evaluationEnvironment;
		this.expression = expression;
		this.context = context;
	}

	public InvalidEvaluationException(DomainEvaluationEnvironment evaluationEnvironment, InvalidValueException e) {
		super(e.getMessage(), e.getCause());
		this.evaluationEnvironment = evaluationEnvironment;
		this.expression = null;
		this.context = null;
	}
}

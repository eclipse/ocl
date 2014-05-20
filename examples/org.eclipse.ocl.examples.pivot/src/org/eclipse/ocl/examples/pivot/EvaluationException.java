/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Exception indicating a failure to evaluate an OCL constraint or expression.
 */
public class EvaluationException extends Exception
{
	private static final long serialVersionUID = 8309911574900800121L;

	public EvaluationException(@NonNull String message) {
		super(message);
	}

	public EvaluationException(@NonNull String message, @NonNull Throwable e) {
		super(message, e);
	}
}

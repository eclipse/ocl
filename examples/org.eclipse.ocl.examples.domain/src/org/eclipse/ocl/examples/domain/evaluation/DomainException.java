/*******************************************************************************
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.evaluation;


public abstract class DomainException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	protected DomainException(String message) {
		super(message);
	}

	protected DomainException(Throwable cause) {
		super(cause);
	}

	protected DomainException(String message, Throwable cause) {
		super(message, cause);
	}
}

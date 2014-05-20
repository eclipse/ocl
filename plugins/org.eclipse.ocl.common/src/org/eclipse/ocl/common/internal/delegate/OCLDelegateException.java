/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.common.internal.delegate;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.annotation.NonNull;

/**
 * An OCLDelegateException wraps an exception that explains a problem that occurred during delegated evaluation.
 * <p>
 * For simple problems this class was once used directly rather than as a wrapper requiring the handler to
 * determine whether a direct or wrapped exception was involved. It is intended that this should only be a wrapper
 * consequently constructors permitting a non-null message are deprecated.
 * <p>
 * Code supporting the Classic LPG evaluator must be prepared to handle unwrapped exceptions.
 */
public class OCLDelegateException extends WrappedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Deprecated but still in use by Classic LPG delegation
	public OCLDelegateException(String message) {
		super(message, null);
	}

//	@Deprecated but still in use by Classic LPG delegation
	public OCLDelegateException(String message, Exception cause) {
		super(message, cause);
	}

	public OCLDelegateException(@NonNull Exception cause) {
		super(null, cause);
	}
}

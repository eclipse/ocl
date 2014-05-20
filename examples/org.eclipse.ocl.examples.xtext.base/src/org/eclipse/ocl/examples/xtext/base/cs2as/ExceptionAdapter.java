/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.cs2as;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * An ExceptionAdapter may be attached to a CS Element to capture an exception
 * for diagnosis of an unresolved proxy.
 */
public class ExceptionAdapter extends AdapterImpl
{
	private final Exception exception;

	public ExceptionAdapter(Exception exception) {
		this.exception = exception;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ExceptionAdapter.class;
	}

	public String getErrorMessage() {
		return exception.getLocalizedMessage();
	}
}

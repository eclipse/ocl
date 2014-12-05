/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.delegate;

import org.eclipse.jdt.annotation.NonNull;

public class ValidationBehavior extends org.eclipse.ocl.pivot.delegate.ValidationBehavior
{
	public static final @NonNull ValidationBehavior INSTANCE = new ValidationBehavior();
}
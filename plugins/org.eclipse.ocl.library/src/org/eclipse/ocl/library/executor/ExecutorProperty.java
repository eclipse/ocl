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
package org.eclipse.ocl.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.elements.AbstractExecutorProperty;

public abstract class ExecutorProperty extends AbstractExecutorProperty		 // FIXME Make abstract merging AbstractExecutorProperty, eliminating 'implementation'
{
	protected ExecutorProperty(@NonNull String name, @NonNull Type executorType, int propertyIndex) {
		super(name, executorType, propertyIndex);
	}
}
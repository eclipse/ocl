/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation.tx;

import org.eclipse.jdt.annotation.NonNull;

/**
 * AbstractObjectManager provides the mandatory shared functionality for an object state manager.
 * @since 1.1
 */
public abstract class AbstractObjectManager implements ObjectManager
{
	protected final @NonNull InvocationManager invocationManager;
	
	protected AbstractObjectManager(@NonNull InvocationManager invocationManager) {
		this.invocationManager = invocationManager;
	}

	public void unblock(@NonNull Invocation anInvocation) {
		invocationManager.unblock(anInvocation);
	}
}
/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.internal.impl.CompleteClassImpl;

/**
 * An OrphanTypeServer provides a 'merge' type behaviour for a synthesized type that forms part of the
 * OrphanPackage rather than a true package. OrphanTypeServer provides lightweight support that
 * eliminates the redundant notification tracking.
 */
public class OrphanTypeServer extends AbstractTypeServer
{
 	protected final @NonNull org.eclipse.ocl.examples.pivot.Class target;
	
	public OrphanTypeServer(@NonNull CompleteClassImpl completeClass, @NonNull org.eclipse.ocl.examples.pivot.Class type) {
		super(completeClass, type);
		this.target = type;
	}

	@Override
	public String toString() {
		return String.valueOf(target);
	}
}

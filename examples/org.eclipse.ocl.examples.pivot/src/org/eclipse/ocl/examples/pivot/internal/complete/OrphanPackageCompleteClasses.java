/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.complete;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.internal.impl.OrphanCompletePackageImpl;

public class OrphanPackageCompleteClasses extends AbstractCompleteClasses
{
	public static final long serialVersionUID = 1L;

	public OrphanPackageCompleteClasses(@NonNull OrphanCompletePackageImpl owner) {
		super(owner);
	}

	@Override
	protected void doRefreshPartialClass(@NonNull Class partialClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull OrphanCompletePackageImpl getCompletePackage() {
		return (OrphanCompletePackageImpl) owner;
	}
}
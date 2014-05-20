/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.pivot.AnyType;

public class AnyTypeServer extends ExtensibleTypeServer
{
	public AnyTypeServer(@NonNull PackageServer packageServer, @NonNull AnyType type) {
		super(packageServer, type);
	}

	@Override
	public @NonNull DomainInheritance getCommonInheritance(@NonNull DomainInheritance thatInheritance) {
		return this;
	}

	@Override
	public @NonNull Iterable<? extends DomainInheritance> getInitialSuperInheritances() {
		return MetaModelManager.EMPTY_TYPE_SERVER_LIST;
	}
	
	@Override
	public boolean install() {
		if (!isInstalled()) {
			installOclAny();
		}
		return true;
	}

	@Override
	public boolean isInstallable() {
		return true;
	}

	@Override
	public boolean isUndefined() {
		return false;
	}
}

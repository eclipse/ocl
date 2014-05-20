/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.RootPackageId;

public class RootPackageIdImpl extends PackageIdImpl implements RootPackageId
{
	protected final @NonNull String name;

	@SuppressWarnings("null")
	public RootPackageIdImpl(@NonNull IdManager idManager, @NonNull String name) {
		super(name.hashCode());
		this.name = name;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitRootPackageId(this);
	}

	public @NonNull String getDisplayName() {
		return name;
	}

	public @NonNull String getName() {
		return name;
	}
}
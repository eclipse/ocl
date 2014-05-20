/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.NestedPackageId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.PackageId;

public class NestedPackageIdImpl extends PackageIdImpl implements NestedPackageId
{
	protected final @NonNull PackageId parent;
	protected final @NonNull String name;

	NestedPackageIdImpl(@NonNull PackageId parent, @NonNull String name) {
		super(97 * parent.hashCode() + name.hashCode());
		this.parent = parent;
		this.name = name;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitNestedPackageId(this);
	}

	public @NonNull String getDisplayName() {
		if (parent instanceof NsURIPackageId) {
			return name;
		}
		else {
			return parent + "::" + name;
		}
	}

	public @NonNull String getName() {
		return name;
	}
	
	public @NonNull PackageId getParent() {
		return parent;
	}
	
	@Override
	public String toString() {
		return parent + "::" + name;
	}

}
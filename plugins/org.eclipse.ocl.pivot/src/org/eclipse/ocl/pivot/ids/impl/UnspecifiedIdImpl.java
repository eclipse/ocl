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
package org.eclipse.ocl.pivot.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.UnspecifiedId;
import org.eclipse.ocl.pivot.utilities.NameUtil;

public class UnspecifiedIdImpl extends AbstractTypeId implements UnspecifiedId, ClassId, DataTypeId
{
	protected final @NonNull Type type;
	
	public UnspecifiedIdImpl(@NonNull IdManager idManager, @NonNull Type type) {
		this.type = type;
	}

	@Override
	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitUnspecifiedId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return NameUtil.getSafeName(type);
	}

	@Override
	public @NonNull String getName() {
		throw new UnsupportedOperationException();
	}

	
	@Override
	public @NonNull PackageId getParent() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Object getSpecifier() {
		return type;
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}
}
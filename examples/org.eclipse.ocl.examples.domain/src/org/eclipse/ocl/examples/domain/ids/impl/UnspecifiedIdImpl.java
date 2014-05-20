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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ClassId;
import org.eclipse.ocl.examples.domain.ids.DataTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.UnspecifiedId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

public class UnspecifiedIdImpl extends AbstractTypeId implements UnspecifiedId, ClassId, DataTypeId
{
	protected final @NonNull DomainType type;
	
	public UnspecifiedIdImpl(@NonNull IdManager idManager, @NonNull DomainType type) {
		this.type = type;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitUnspecifiedId(this);
	}

	public @NonNull String getDisplayName() {
		return DomainUtil.getSafeName(type);
	}

	public @NonNull String getName() {
		throw new UnsupportedOperationException();
	}

	
	public @NonNull PackageId getParent() {
		throw new UnsupportedOperationException();
	}

	public @NonNull Object getSpecifier() {
		return type;
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}
}
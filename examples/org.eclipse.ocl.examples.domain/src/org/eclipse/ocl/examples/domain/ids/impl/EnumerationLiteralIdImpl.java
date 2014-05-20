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
import org.eclipse.ocl.examples.domain.ids.EnumerationId;
import org.eclipse.ocl.examples.domain.ids.EnumerationLiteralId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class EnumerationLiteralIdImpl extends UnscopedId implements EnumerationLiteralId
{
	protected final @NonNull EnumerationId parentId;

	public EnumerationLiteralIdImpl(@NonNull EnumerationId parentId, @NonNull String name) {
		super(name);
		this.parentId = parentId;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitEnumerationLiteralId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return parentId + "::" + name;
	}

	@Override public @NonNull String getMetaTypeName() {
		return TypeId.ENUMERATION_NAME;
	}

	public @NonNull EnumerationId getParentId() {
		return parentId;
	}
}
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
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class SpecializedCollectionTypeIdImpl extends AbstractSpecializedIdImpl<CollectionTypeId> implements CollectionTypeId
{
	private @Nullable TypeId elementTypeId;

	public SpecializedCollectionTypeIdImpl(@NonNull CollectionTypeId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectionTypeId(this);
	}

	@Override
	protected @NonNull CollectionTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedCollectionTypeIdImpl(this, templateBindings);
	}

	public @NonNull TypeId getElementTypeId() {
		TypeId elementTypeId2 = elementTypeId;
		if (elementTypeId2 == null) {
			elementTypeId = elementTypeId2 = (TypeId) generalizedId.getElementTypeId().specialize(templateBindings);
		}
		return elementTypeId2;
	}

    public @NonNull CollectionTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}
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
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;

public class SpecializedTypeIdImpl extends AbstractSpecializedIdImpl<TemplateableTypeId> implements TemplateableTypeId
{
	public SpecializedTypeIdImpl(@NonNull TemplateableTypeId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTemplateableTypeId(this);
	}

	@Override
	protected @NonNull TemplateableTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedTypeIdImpl(this, templateBindings);
	}

//	public @NonNull String getDisplayName() {
//		return parent + "::" + typeParameters;
//	}

    public @NonNull TemplateableTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}
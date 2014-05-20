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
import org.eclipse.ocl.examples.domain.ids.IdHash;
import org.eclipse.ocl.examples.domain.ids.NestedTypeId;
import org.eclipse.ocl.examples.domain.ids.NsURIPackageId;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.TemplateableTypeId;

public abstract class GeneralizedNestedTypeIdImpl extends GeneralizedTypeIdImpl<TemplateableTypeId> implements NestedTypeId,TemplateableTypeId
{
	protected final @NonNull PackageId parent;

	protected GeneralizedNestedTypeIdImpl(@NonNull PackageId parent, int templateParameters, @NonNull String name) {
		super(IdHash.createChildHash(parent, name), templateParameters, name);
		this.parent = parent;
	}

	@Override
	protected @NonNull TemplateableTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedTypeIdImpl(this, templateBindings);
	}

	public @NonNull String getDisplayName() {
		if (parent instanceof NsURIPackageId) {
			return name;
		}
		else {
			return parent + "::" + name;
		}
	}

	public @NonNull TemplateableTypeId getGeneralizedId() {
		return this;
	}
	
	public @NonNull PackageId getParent() {
		return parent;
	}

    public @NonNull TemplateableTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}
	
	@Override
	public String toString() {
		return parent + "::" + name;
	}

}
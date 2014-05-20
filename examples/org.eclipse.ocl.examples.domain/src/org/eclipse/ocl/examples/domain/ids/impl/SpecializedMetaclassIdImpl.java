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
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class SpecializedMetaclassIdImpl extends AbstractMetaclassId
{
	private @NonNull ElementId elementId;

	public SpecializedMetaclassIdImpl(@NonNull ElementId elementId) {
		super(TypeId.METACLASS.hashCode() + elementId.hashCode());
		this.elementId = elementId;
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(TypeId.METACLASS_NAME);
		s.append("<");
		s.append(elementId);
		s.append(">");
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull ElementId getElementId() {
		return elementId;
	}

	public @NonNull MetaclassId getSpecializedId(@NonNull ElementId elementId) {
		throw new UnsupportedOperationException();
	}
}
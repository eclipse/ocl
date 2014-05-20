/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.types;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class AbstractTuplePart implements DomainTypedElement
{
	protected final DomainType type;
	protected final String name;

	public AbstractTuplePart(DomainType type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public DomainType getType() {
		return type;
	}

	public @NonNull TypeId getTypeId() {
		DomainType type2 = getType();
		return type2 != null ? type2.getTypeId() : TypeId.OCL_INVALID;
	}

	@Override
	public String toString() {
		return String.valueOf(name) + " : " + String.valueOf(type); //$NON-NLS-1$
	}
}
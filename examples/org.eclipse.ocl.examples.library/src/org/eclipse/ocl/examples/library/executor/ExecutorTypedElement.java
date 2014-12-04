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
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class ExecutorTypedElement implements DomainTypedElement
{
	private @NonNull String name;
	private @NonNull DomainType type;

	public ExecutorTypedElement(@NonNull String name, @NonNull DomainType type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull DomainType getType() {
		return type;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		DomainType type2 = getType();
		return type2.getTypeId();
	}

	@Override
	public String toString() {
		return String.valueOf(name) + " : " + String.valueOf(type); //$NON-NLS-1$
	}
}
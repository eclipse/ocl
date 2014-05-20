/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;

public abstract class AbstractSpecializedType extends AbstractType
{
	protected final @NonNull DomainType containerType;
	
	public AbstractSpecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name, @NonNull DomainType containerType) {
		super(standardLibrary, name);
		this.containerType = containerType;
	}

	public DomainType getContainerType() {
		return containerType;
	}

	@Override
	public boolean isOrdered() {
		return containerType.isOrdered();
	}

	@Override
	public boolean isUnique() {
		return containerType.isUnique();
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation staticOperation) {
		return containerType.lookupImplementation(standardLibrary, staticOperation);
	}
}
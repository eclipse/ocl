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
package org.eclipse.ocl.domain.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.library.LibraryFeature;

public abstract class AbstractSpecializedType extends AbstractClass
{
	protected final @NonNull DomainClass containerType;
	
	public AbstractSpecializedType(@NonNull DomainEnvironment environment, @NonNull String name, @NonNull DomainClass containerType) {
		super(environment, name);
		this.containerType = containerType;
	}

	public DomainClass getContainerType() {
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

	@Override
	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		return containerType.lookupActualOperation(standardLibrary, apparentOperation);
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		return containerType.lookupImplementation(standardLibrary, apparentOperation);
	}
}
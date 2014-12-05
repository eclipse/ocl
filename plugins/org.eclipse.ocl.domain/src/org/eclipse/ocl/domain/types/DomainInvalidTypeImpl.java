/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainInvalidType;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.library.UnsupportedOperation;

public class DomainInvalidTypeImpl extends AbstractClass implements DomainInvalidType
{
	protected final @NonNull String message;

	public DomainInvalidTypeImpl(@NonNull DomainEnvironment environment, @NonNull String message) {
		super(environment, "Invalid");
		this.message = message;
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType) {
		return false;
	}

	@Override
	public @NonNull DomainClass getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		return this;
	}	

	@Override
	public @NonNull TypeId getTypeId() {
		return TypeId.OCL_INVALID;
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType) {
		return false;
	}

	@Override
	public boolean isInvalid() {
		return true;
	}

	@Override
	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		return standardLibrary.getOclInvalidOperation();
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		return UnsupportedOperation.INSTANCE;
	}
}

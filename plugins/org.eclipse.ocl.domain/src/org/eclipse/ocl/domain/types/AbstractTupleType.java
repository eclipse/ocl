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
import org.eclipse.ocl.domain.elements.DomainTupleType;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.TupleTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.LibraryFeature;

public class AbstractTupleType extends AbstractClass implements DomainTupleType
{
	protected final @NonNull TupleTypeId typeId;

	public AbstractTupleType(@NonNull DomainEnvironment environment, @NonNull TupleTypeId typeId) {
		super(environment, TypeId.TUPLE_NAME);
		this.typeId = typeId;
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainTupleType)) {
			return false;
		}
		return standardLibrary.conformsToTupleType(this, (DomainTupleType)type);
	}

	@Override
	public @NonNull DomainClass getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (type != this) {
			return idResolver.getStandardLibrary().getOclAnyType();
		}
		return this;
	}

	@Override
	public @NonNull TupleTypeId getTupleTypeId() {
		return typeId;
	}

	@Override
	public @NonNull TupleTypeId getTypeId() {
		return typeId;
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainTupleType)) {
			return false;
		}
		return standardLibrary.isEqualToTupleType(this, (DomainTupleType)type);
	}
	
	@Override
	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		return standardLibrary.getOclTupleType().lookupActualOperation(standardLibrary, apparentOperation);
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		return standardLibrary.getOclTupleType().lookupImplementation(standardLibrary, apparentOperation);
	}

	@Override
	public String toString() {
		return typeId.toString();
	}
}
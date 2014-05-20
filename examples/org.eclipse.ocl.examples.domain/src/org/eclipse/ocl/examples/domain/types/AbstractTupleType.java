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
import org.eclipse.ocl.examples.domain.elements.DomainTupleType;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;

public class AbstractTupleType extends AbstractType implements DomainTupleType
{
	protected final @NonNull TupleTypeId typeId;

	public AbstractTupleType(@NonNull DomainStandardLibrary standardLibrary, @NonNull TupleTypeId typeId) {
		super(standardLibrary, TypeId.TUPLE_NAME);
		this.typeId = typeId;
	}

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
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (type != this) {
			return idResolver.getStandardLibrary().getOclAnyType();
		}
		return this;
	}

	public @NonNull TupleTypeId getTupleTypeId() {
		return typeId;
	}

	public @NonNull TupleTypeId getTypeId() {
		return typeId;
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainTupleType)) {
			return false;
		}
		return standardLibrary.isEqualToTupleType(this, (DomainTupleType)type);
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation staticOperation) {
		return standardLibrary.getOclTupleType().lookupImplementation(standardLibrary, staticOperation);
	}

	@Override
	public String toString() {
		return typeId.toString();
	}
}
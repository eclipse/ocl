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
package org.eclipse.ocl.domain.types;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.values.OCLValue;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Constraint;

public abstract class AbstractType implements DomainType	// FIXME rename as perhaps DerivativeType
{
	protected final @NonNull DomainEnvironment environment;
	protected final @NonNull DomainStandardLibrary standardLibrary;

	protected final @NonNull String name;

	public AbstractType(@NonNull DomainEnvironment environment, @NonNull String name) {
		this.environment = environment;
		this.standardLibrary = environment.getStandardLibrary();
		this.name = name;
	}
	
	@Override
	public @NonNull DomainType flattenedType() {
		return this;
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
//		return standardLibrary.getInheritance(this);
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

//	public @NonNull String getMetaTypeName() {
//		TypeId typeId = getTypeId();
//		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
//	}

	@Override
	public @NonNull String getMetaTypeName() {
		return getTypeId().getMetaTypeName();
	}
	
	@Override
	public final String getName() {
		return name;
	}

	@Override
	public @NonNull DomainClass getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public @NonNull List<? extends Constraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	public final DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isInvalid() {
		return false;
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof DomainType)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((DomainType)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	@Override
	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	@Override
	public DomainType specializeIn(@NonNull CallExp expr, DomainType selfType) {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
}

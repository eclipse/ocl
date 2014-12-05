/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainCallExp;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.values.OCLValue;

public abstract class AbstractReflectiveInheritanceType extends ReflectiveInheritance implements DomainClass
{
	public AbstractReflectiveInheritanceType(@NonNull String name, int flags) {
		super(name, flags);
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		DomainInheritance thatInheritance = type.getInheritance(standardLibrary);
		if (this == thatInheritance) {
			return true;
		}
		return thatInheritance.isSuperInheritanceOf(this);
	}
	
	@Override
	public @NonNull DomainClass flattenedType() {
		return this;
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return this;
	}

	@Override
	public @NonNull DomainClass getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		return getType();
	}

	@Override
	public @NonNull DomainClass isClass() {
		return getType();
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return getType() == type;
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return getType() == type;
	}

	@Override
	public @Nullable DomainTemplateParameter isTemplateParameter() {
		return null;
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
	public DomainType specializeIn(@NonNull DomainCallExp expr, DomainType selfType) {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
}
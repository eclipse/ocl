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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainPackage;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.values.OCLValue;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.Value;

public abstract class AbstractType implements DomainType	// FIXME rename as perhaps DerivativeType
{
	protected final @NonNull DomainStandardLibrary standardLibrary;

	protected final @NonNull String name;

	public AbstractType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name) {
		this.standardLibrary = standardLibrary;
		this.name = name;
	}

	public @NonNull ObjectValue createInstance() {
		throw new UnsupportedOperationException();
	}

	public @NonNull Value createInstance(@NonNull String value) {
		throw new UnsupportedOperationException();
	}

	public abstract @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type);

	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getInheritance(this);
//		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull List<? extends DomainOperation> getLocalOperations() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull List<? extends DomainProperty> getLocalProperties() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull List<? extends DomainType> getLocalSuperTypes() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

//	public @NonNull String getMetaTypeName() {
//		TypeId typeId = getTypeId();
//		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
//	}

	public @NonNull String getMetaTypeName() {
		return getTypeId().getMetaTypeName();
	}
	
	public final String getName() {
		return name;
	}

	public @NonNull DomainType getNormalizedType(@NonNull DomainStandardLibrary standardLibrary) {
		return getInheritance(standardLibrary);
	}

	public @NonNull List<? extends DomainProperty> getOwnedAttribute() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull List<? extends DomainConstraint> getOwnedInvariant() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull List<? extends DomainOperation> getOwnedOperation() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull List<? extends DomainConstraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public DomainPackage getPackage() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
	
	public final DomainStandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return DomainTypeParameters.EMPTY_LIST;
	}

	public boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		return false;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isUnique() {
		return false;
	}

	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof DomainType)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((DomainType)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	public DomainType specializeIn(@NonNull DomainCallExp expr, DomainType selfType) {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
}
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainCollectionType;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.pivot.Operation;

public class AbstractCollectionType extends AbstractSpecializedType implements DomainCollectionType
{
	protected final @NonNull DomainType elementType;
	protected final @NonNull IntegerValue lower;
	protected final @NonNull UnlimitedNaturalValue upper;
	protected final @NonNull CollectionTypeId typeId;
	
	public AbstractCollectionType(@NonNull DomainEnvironment environment, @NonNull String name,
			@NonNull DomainClass containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		super(environment, name, containerType);
		this.elementType = elementType;
		this.lower = lower != null ? lower : ValuesUtil.ZERO_VALUE;
		this.upper = upper != null ? upper : ValuesUtil.UNLIMITED_VALUE;
		this.typeId = IdManager.getCollectionTypeId(name).getSpecializedId(elementType.getTypeId());
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainCollectionType)) {
			return false;
		}
		return standardLibrary.conformsToCollectionType(this, (DomainCollectionType)type);
	}

	@Override
	public @NonNull DomainClass getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (!(type instanceof AbstractCollectionType)) {
			return standardLibrary.getOclAnyType();
		}
		AbstractCollectionType thatClass = (AbstractCollectionType) type;
		// FIXME kind
		DomainClass commonContainerClass = containerType;		// FIXME WIP
		DomainType commonElementClass = elementType.getCommonType(idResolver, thatClass.getElementType());
		if ((commonContainerClass == containerType) && (commonElementClass == elementType)) {
			return this;
		}
		else if ((commonContainerClass == thatClass.containerType) && (commonElementClass == thatClass.elementType)) {
			return thatClass;
		}
		else {
			if (commonContainerClass.isOrdered()) {
				if (commonContainerClass.isUnique()) {
					return environment.getOrderedSetType(commonElementClass, null, null);
				}
				else {
					return environment.getSequenceType(commonElementClass, null, null);
				}
			}
			else {
				if (commonContainerClass.isUnique()) {
					return environment.getSetType(commonElementClass, null, null);
				}
				else {
					return environment.getBagType(commonElementClass, null, null);
				}
			}
		}
	}

	@Override
	public DomainClass getContainerType() {
		return containerType;
	}

	@Override
	public @NonNull DomainType getElementType() {
		return elementType;
	}

	@Override
	public @NonNull IntegerValue getLowerValue() {
		return lower;
	}

//	@Override
//	public @NonNull String getMetaTypeName() {
//		return getTypeId().getCollectionTypeId().getMetaTypeName();
//	}

	@Override
	public @NonNull List<Operation> getOwnedOperations() {
		return containerType.getOwnedOperations();
	}

	@Override
	public @NonNull CollectionTypeId getTypeId() {
		return typeId;
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		return upper;
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		if (this == type) {
			return true;
		}
		if (!(type instanceof DomainCollectionType)) {
			return false;
		}
		return standardLibrary.isEqualToCollectionType(this, (DomainCollectionType)type);
	}

	@Override
	public String toString() {
		return String.valueOf(containerType) + "(" + String.valueOf(elementType) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
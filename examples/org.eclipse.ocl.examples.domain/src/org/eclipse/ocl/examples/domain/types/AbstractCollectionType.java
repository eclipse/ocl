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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCollectionType;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;

public class AbstractCollectionType extends AbstractSpecializedType implements DomainCollectionType
{
	protected final @NonNull DomainType elementType;
	protected final @NonNull IntegerValue lower;
	protected final @NonNull IntegerValue upper;
	protected final @NonNull CollectionTypeId typeId;
	
	public AbstractCollectionType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name,
			@NonNull DomainType containerType, @NonNull DomainType elementType, @Nullable IntegerValue lower, @Nullable IntegerValue upper) {
		super(standardLibrary, name, containerType);
		this.elementType = elementType;
		this.lower = lower != null ? lower : ValuesUtil.ZERO_VALUE;
		this.upper = upper != null ? upper : ValuesUtil.UNLIMITED_VALUE;
		this.typeId = IdManager.getCollectionTypeId(name).getSpecializedId(elementType.getTypeId());
	}

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
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (!(type instanceof AbstractCollectionType)) {
			return standardLibrary.getOclAnyType();
		}
		AbstractCollectionType thatClass = (AbstractCollectionType) type;
		// FIXME kind
		DomainType commonContainerClass = containerType;		// FIXME WIP
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
					return standardLibrary.getOrderedSetType(commonElementClass, null, null);
				}
				else {
					return standardLibrary.getSequenceType(commonElementClass, null, null);
				}
			}
			else {
				if (commonContainerClass.isUnique()) {
					return standardLibrary.getSetType(commonElementClass, null, null);
				}
				else {
					return standardLibrary.getBagType(commonElementClass, null, null);
				}
			}
		}
	}

	@Override
	public DomainType getContainerType() {
		return containerType;
	}

	public @NonNull DomainType getElementType() {
		return elementType;
	}

	public @NonNull IntegerValue getLowerValue() {
		return lower;
	}

//	@Override
//	public @NonNull String getMetaTypeName() {
//		return getTypeId().getCollectionTypeId().getMetaTypeName();
//	}

	@Override
	public @NonNull List<? extends DomainOperation> getOwnedOperation() {
		return containerType.getOwnedOperation();
	}

	public @NonNull CollectionTypeId getTypeId() {
		return typeId;
	}

	public @NonNull IntegerValue getUpperValue() {
		return upper;
	}

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
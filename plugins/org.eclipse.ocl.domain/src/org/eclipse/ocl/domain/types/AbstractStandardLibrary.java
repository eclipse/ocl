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

import java.lang.ref.WeakReference;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainCollectionType;
import org.eclipse.ocl.domain.elements.DomainCompletePackage;
import org.eclipse.ocl.domain.elements.DomainElement;
import org.eclipse.ocl.domain.elements.DomainEnumeration;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainLambdaType;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainTupleType;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.values.IntegerValue;

public abstract class AbstractStandardLibrary implements DomainStandardLibrary
{
	
	protected AbstractStandardLibrary() {}

	@Override
	public boolean conformsToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType) {
		DomainType firstContainerType = firstCollectionType.getContainerType();
		DomainType secondContainerType = secondCollectionType.getContainerType();
		if (firstContainerType != secondContainerType) {
			if ((firstContainerType == null) || (secondContainerType == null)) {
				return false;
			}
			DomainInheritance firstInheritance = firstContainerType.getInheritance(this);
			DomainInheritance secondInheritance = secondContainerType.getInheritance(this);
			if (!secondInheritance.isSuperInheritanceOf(firstInheritance)) {
				return false;
			}
		}
		DomainType firstElementType = firstCollectionType.getElementType();
		DomainType secondElementType = secondCollectionType.getElementType();
		if (firstElementType != secondElementType) {
			if ((firstElementType == null) || (secondElementType == null)) {
				return false;
			}
			if (!firstElementType.conformsTo(this, secondElementType)) {
				return false;
			}
		}
		IntegerValue firstLower = firstCollectionType.getLowerValue();
		IntegerValue secondLower = secondCollectionType.getLowerValue();
		if (firstLower.compareTo(secondLower) < 0) {
			return false;
		}
		IntegerValue firstUpper = firstCollectionType.getUpperValue();
		IntegerValue secondUpper = secondCollectionType.getUpperValue();
		if (firstUpper.compareTo(secondUpper) > 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean conformsToLambdaType(@NonNull DomainLambdaType firstLambdaType, @NonNull DomainLambdaType secondLambdaType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean conformsToTupleType(@NonNull DomainTupleType firstTupleType, @NonNull DomainTupleType secondTupleType) {
		if (isEqualToTupleType(firstTupleType, secondTupleType)) {
			return true;
		}
		DomainInheritance firstInheritance = firstTupleType.getInheritance(this);
		DomainInheritance secondInheritance = secondTupleType.getInheritance(this);
		return firstInheritance.isSuperInheritanceOf(secondInheritance);
	}

	public void dispose() {}

	public @NonNull Iterable<? extends DomainClass> getAllClasses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<? extends DomainCompletePackage> getAllCompletePackages() {
		throw new UnsupportedOperationException();
	}

	@Override
	public DomainEnumeration getEnumeration(@NonNull Enumerator enumerator) {
		throw new UnsupportedOperationException();
	}

	@Override
	public DomainType getMetaType(@NonNull DomainType instanceType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable DomainPackage getNsURIPackage(@NonNull String nsURI) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable DomainElement getOperationTemplateParameter(@NonNull DomainOperation anOperation, int index) {
		return anOperation.getTypeParameters().get(index);
	}

	@Override
	public @Nullable DomainType getPrimitiveType(@NonNull PrimitiveTypeId typeId) {
		if (typeId == TypeId.BOOLEAN) {
			return getBooleanType();
		}
		else if (typeId == TypeId.INTEGER) {
			return getIntegerType();
		}
		else if (typeId == TypeId.REAL) {
			return getRealType();
		}
		else if (typeId == TypeId.STRING) {
			return getStringType();
		}
		else if (typeId == TypeId.UNLIMITED_NATURAL) {
			return getUnlimitedNaturalType();
		}
		else if (typeId == TypeId.OCL_ANY) {
			return getOclAnyType();
		}
		else if (typeId == TypeId.OCL_COMPARABLE) {
			return getOclComparableType();
		}
		else if (typeId == TypeId.OCL_SELF) {
			return getOclSelfType();
		}
		else if (typeId == TypeId.OCL_SUMMABLE) {
			return getOclSummableType();
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public DomainPackage getRootPackage(@NonNull String name) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean isEqualToCollectionType(@NonNull DomainCollectionType firstCollectionType, @NonNull DomainCollectionType secondCollectionType) {
		DomainType firstContainerType = firstCollectionType.getContainerType();
		DomainType secondContainerType = secondCollectionType.getContainerType();
		if (firstContainerType != secondContainerType) {
			if ((firstContainerType == null) || (secondContainerType == null)) {
				return false;
			}
			if (!firstContainerType.isEqualToUnspecializedType(this, secondContainerType)) {
				return false;
			}
		}
		DomainType firstElementType = firstCollectionType.getElementType();
		DomainType secondElementType = secondCollectionType.getElementType();
		if (firstElementType != secondElementType) {
			if ((firstElementType == null) || (secondElementType == null)) {
				return false;
			}
			if (!firstElementType.isEqualTo(this, secondElementType)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEqualToTupleType(@NonNull DomainTupleType firstTupleType, @NonNull DomainTupleType secondTupleType) {
		TypeId firstParts = firstTupleType.getTypeId();
		TypeId secondParts = secondTupleType.getTypeId();
		return firstParts == secondParts;
	}

	/**
	 * Return the map.get(key).get() entry if there is one or null if not, removing any stale
	 * entry that may be encountered.
	 */
	protected <K, V> V weakGet(@NonNull Map<K, WeakReference<V>> map, @NonNull K key) {
		WeakReference<V> ref = map.get(key);
		if (ref == null) {
			return null;
		}
		V value = ref.get();
		if (value == null) {
			map.remove(key);
		}
		return value;
	}
}

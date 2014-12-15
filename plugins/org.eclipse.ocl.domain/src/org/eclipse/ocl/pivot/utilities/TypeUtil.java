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
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.PrimitiveTypeId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.types.ParameterTypesImpl;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;

public class TypeUtil
{
	public static boolean conformsToCollectionType(@NonNull StandardLibrary standardLibrary, @NonNull CollectionType firstCollectionType, @NonNull CollectionType secondCollectionType) {
		Type firstContainerType = firstCollectionType.getContainerType();
		Type secondContainerType = secondCollectionType.getContainerType();
		if (firstContainerType != secondContainerType) {
			CompleteInheritance firstInheritance = firstContainerType.getInheritance(standardLibrary);
			CompleteInheritance secondInheritance = secondContainerType.getInheritance(standardLibrary);
			if (!secondInheritance.isSuperInheritanceOf(firstInheritance)) {
				return false;
			}
		}
		Type firstElementType = firstCollectionType.getElementType();
		Type secondElementType = secondCollectionType.getElementType();
		if (firstElementType != secondElementType) {
			if ((firstElementType == null) || (secondElementType == null)) {
				return false;
			}
			if (!firstElementType.conformsTo(standardLibrary, secondElementType)) {
				return false;
			}
		}
		IntegerValue firstLower = firstCollectionType.getLowerValue();
		IntegerValue secondLower = secondCollectionType.getLowerValue();
		if (firstLower.compareTo(secondLower) < 0) {
			return false;
		}
		UnlimitedNaturalValue firstUpper = firstCollectionType.getUpperValue();
		UnlimitedNaturalValue secondUpper = secondCollectionType.getUpperValue();
		if (firstUpper.compareTo(secondUpper) > 0) {
			return false;
		}
		return true;
	}

	public static boolean conformsToLambdaType(@NonNull StandardLibrary standardLibrary, @NonNull LambdaType firstLambdaType, @NonNull LambdaType secondLambdaType) {
		throw new UnsupportedOperationException();
	}
	
	public static boolean conformsToTupleType(@NonNull StandardLibrary standardLibrary, @NonNull TupleType firstTupleType, @NonNull TupleType secondTupleType) {
		if (isEqualToTupleType(standardLibrary, firstTupleType, secondTupleType)) {
			return true;
		}
		CompleteInheritance firstInheritance = firstTupleType.getInheritance(standardLibrary);
		CompleteInheritance secondInheritance = secondTupleType.getInheritance(standardLibrary);
		return firstInheritance.isSuperInheritanceOf(secondInheritance);
	}

	public static @NonNull ParameterTypes createParameterTypes(@NonNull Type... parameterTypes) {
		return new ParameterTypesImpl(parameterTypes);
	}

	public static @Nullable Type getPrimitiveType(@NonNull StandardLibrary standardLibrary, @NonNull PrimitiveTypeId typeId) {
		if (typeId == TypeId.BOOLEAN) {
			return standardLibrary.getBooleanType();
		}
		else if (typeId == TypeId.INTEGER) {
			return standardLibrary.getIntegerType();
		}
		else if (typeId == TypeId.REAL) {
			return standardLibrary.getRealType();
		}
		else if (typeId == TypeId.STRING) {
			return standardLibrary.getStringType();
		}
		else if (typeId == TypeId.UNLIMITED_NATURAL) {
			return standardLibrary.getUnlimitedNaturalType();
		}
		else if (typeId == TypeId.OCL_ANY) {
			return standardLibrary.getOclAnyType();
		}
		else if (typeId == TypeId.OCL_COMPARABLE) {
			return standardLibrary.getOclComparableType();
		}
		else if (typeId == TypeId.OCL_SELF) {
			return standardLibrary.getOclSelfType();
		}
		else if (typeId == TypeId.OCL_SUMMABLE) {
			return standardLibrary.getOclSummableType();
		}
		throw new UnsupportedOperationException();
	}
	
	public static boolean isEqualToCollectionType(@NonNull StandardLibrary standardLibrary, @NonNull CollectionType firstCollectionType, @NonNull CollectionType secondCollectionType) {
		Type firstContainerType = firstCollectionType.getContainerType();
		Type secondContainerType = secondCollectionType.getContainerType();
		if ((firstContainerType != secondContainerType) && !firstContainerType.isEqualToUnspecializedType(standardLibrary, secondContainerType)) {
			return false;
		}
		Type firstElementType = firstCollectionType.getElementType();
		Type secondElementType = secondCollectionType.getElementType();
		if (firstElementType != secondElementType) {
			if ((firstElementType == null) || (secondElementType == null)) {
				return false;
			}
			if (!firstElementType.isEqualTo(standardLibrary, secondElementType)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEqualToTupleType(@NonNull StandardLibrary standardLibrary, @NonNull TupleType firstTupleType, @NonNull TupleType secondTupleType) {
		TypeId firstParts = firstTupleType.getTypeId();
		TypeId secondParts = secondTupleType.getTypeId();
		return firstParts == secondParts;
	}
}

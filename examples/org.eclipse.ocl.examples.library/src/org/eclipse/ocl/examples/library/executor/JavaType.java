/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainEnvironment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.AbstractClass;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * JavaType supports the usage of Java Class to define the type of an object.
 */
public class JavaType extends AbstractClass
{
	protected final @NonNull Class<?> javaClass;
	
	public JavaType(@NonNull DomainEnvironment environment, @NonNull Class<?> javaClass) {
		super(environment, DomainUtil.nonNullState(javaClass.getName()));
		this.javaClass = javaClass;
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType) {
		throw new UnsupportedOperationException();
	}

	public @NonNull DomainClass getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		if (this == type) {
			return this;
		}
		if (!(type instanceof JavaType)) {
			return idResolver.getStandardLibrary().getOclAnyType();
		}
		Class<?> commonClass = getCommonClass1(javaClass, ((JavaType)type).javaClass);
		if (commonClass != null) {
			return idResolver.getJavaType(commonClass);
		}
		else {
			return idResolver.getStandardLibrary().getOclAnyType();
		}
	}
	private static @Nullable Class<?> getCommonClass1(@NonNull Class<?> thisClass, @NonNull Class<?> thatClass) {
		Class<?> commonClass = getCommonClass2(thisClass, thatClass);
		if (commonClass != null) {
			return commonClass;
		}
		Class<?> superclass = thisClass.getSuperclass();
		if (superclass != null) {
			commonClass = getCommonClass1(superclass, thatClass);
			if (commonClass != null) {
				return commonClass;
			}
		}
		for (Class<?> superInterface : thisClass.getInterfaces()) {
			if (superInterface != null) {
				commonClass = getCommonClass1(superInterface, thatClass);
				if (commonClass != null) {
					return commonClass;
				}
			}
		}
		return null;
	}
	private static @Nullable Class<?> getCommonClass2(@NonNull Class<?> thisClass, @NonNull Class<?> thatClass) {
		if (thisClass == thatClass) {
			return thisClass;
		}
		Class<?> superclass = thatClass.getSuperclass();
		if (superclass != null) {
			Class<?> commonClass = getCommonClass2(thisClass, superclass);
			if (commonClass != null) {
				return commonClass;
			}
		}
		for (Class<?> superInterface : thatClass.getInterfaces()) {
			if (superInterface != null) {
				Class<?> commonClass = getCommonClass2(thisClass, superInterface);
				if (commonClass != null) {
					return commonClass;
				}
			}
		}
		return null;
	}
	
	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		if (Comparable.class.isAssignableFrom(javaClass)) {
			return standardLibrary.getOclComparableType().getInheritance(standardLibrary);
		}
		else {
			return standardLibrary.getOclAnyType().getInheritance(standardLibrary);
		}
	}

	@NonNull
	public TypeId getTypeId() {
		throw new UnsupportedOperationException();
//		return TypeId.OCL_VOID;
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType) {
		return this == thatType;
	}

	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		DomainInheritance inheritance = getInheritance(standardLibrary);
		return inheritance.lookupActualOperation(standardLibrary, apparentOperation);
	}

	@NonNull
	public LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		DomainInheritance inheritance = standardLibrary.getInheritance(standardLibrary.getOclAnyType());
		return inheritance.lookupImplementation(standardLibrary, apparentOperation);
	}

	@Override
	public String toString() {
		return getName();
	}
}

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
package org.eclipse.ocl.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.AbstractExecutorClass;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Type;

/**
 * JavaType supports the usage of Java Class to define the type of an object.
 */
public class JavaType extends AbstractExecutorClass
{
	protected final @NonNull Class<?> javaClass;
	
	public JavaType(@NonNull DomainEnvironment environment, @NonNull Class<?> javaClass) {
		super(DomainUtil.nonNullState(javaClass.getName()), 0);
		this.javaClass = javaClass;
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull Type thatType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull org.eclipse.ocl.pivot.Class getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
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

	@Override
	@NonNull
	public TypeId getTypeId() {
		throw new UnsupportedOperationException();
//		return TypeId.OCL_VOID;
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull Type thatType) {
		return this == thatType;
	}

	@Override
	public @NonNull Operation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		DomainInheritance inheritance = getInheritance(standardLibrary);
		return inheritance.lookupActualOperation(standardLibrary, apparentOperation);
	}

	@Override
	@NonNull
	public LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		DomainInheritance inheritance = standardLibrary.getInheritance(standardLibrary.getOclAnyType());
		return inheritance.lookupImplementation(standardLibrary, apparentOperation);
	}

	@Override
	public String toString() {
		return getName();
	}
}

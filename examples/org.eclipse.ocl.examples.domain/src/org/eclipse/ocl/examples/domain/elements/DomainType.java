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
package org.eclipse.ocl.examples.domain.elements;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.OCLValue;

public interface DomainType extends DomainNamespace, OCLValue
{
	/**
	 * Return true if this type conform to thatType within standardLibrary.
	 */
	boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType);

	/**
	 * Return a new instance of this type from valueFactory. Properties may be initialised using
	 * {@link DomainProperty#initValue(Object, Object) } provided no side-effect free
	 * OCL functionality is permitted to use the ObjectValue until initialisation has completed.
	 */
	@NonNull Object createInstance();

	/**
	 * Return a new instance of this data type from valueFactory.
	 * @param value string initial value
	 */
	@Nullable Object createInstance( @NonNull String value);
	
	/**
	 * Return the most derived type com mon to this type and thatType within standardLibrary.
	 */
	@NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType thatType);

	/**
	 * Return the inheritance description for this type within standardLibrary.
	 */
	@NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary);
	@NonNull List<? extends DomainOperation> getLocalOperations();
	@NonNull List<? extends DomainProperty> getLocalProperties();
	@NonNull List<? extends DomainType> getLocalSuperTypes();
	
	/**
	 * Return the name of the meta-type of this type.
	 */
	@NonNull String getMetaTypeName();
	
	/**
	 * Return the name of this type (without any decorations for specializations).
	 */
	/* @NonNull*/ String getName();
	
	/**
	 * Return the unique executable form of this type within standardLibrary.
	 */
	@NonNull DomainType getNormalizedType(@NonNull DomainStandardLibrary standardLibrary);

	@NonNull List<? extends DomainProperty> getOwnedAttribute();

	@NonNull List<? extends DomainOperation> getOwnedOperation();
	
	/**
	 * Return the package containing this type.
	 */
	/* @NonNull*/ DomainPackage getPackage();

	/**
	 * Return the ordered list of type parameters of this type.
	 */
	@NonNull DomainTypeParameters getTypeParameters();

	/**
	 * Return a unique StandardLibrary-independent identifier for this type.
	 */
	@NonNull TypeId getTypeId();
	
	/**
	 * Return true if this is the same type as thatType within standardLibrary.
	 */
	boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType);
	boolean isEqualToUnspecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type);
	
	/**
	 * Return true if this is an invalid type (with an associated error message).
	 */
	boolean isInvalid();
	
	/**
	 * Return true if this type is a Collection type and has ordered elements.
	 */
	boolean isOrdered();		
	
	/**
	 * Return true if this type is a Collection type and has unique elements.
	 */
	boolean isUnique();
	
	/**
	 * Return the dynamic (overloaded) implementation of the staticOperation applicable to the types managed
	 * by the given Standard Library.
	 */
	@NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation staticOperation);

	/*@NonNull*/ DomainType specializeIn(@NonNull DomainCallExp expr, /*@NonNull*/ DomainType selfType);

	@NonNull List<? extends DomainConstraint> getOwnedInvariant();
}

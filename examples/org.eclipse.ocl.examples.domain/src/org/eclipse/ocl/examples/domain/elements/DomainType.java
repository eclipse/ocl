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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.OCLValue;

public interface DomainType extends DomainNamespace, OCLValue
{
	/**
	 * Return true if this type conform to thatType within standardLibrary.
	 */
	boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType thatType);
	
	/**
	 * Return the most derived type common to this type and thatType within standardLibrary.
	 */
	@NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType thatType);

	/**
	 * Return the inheritance description for this type within standardLibrary.
	 */
	@NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary);
	
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
	@NonNull DomainClass getNormalizedType(@NonNull DomainStandardLibrary standardLibrary);
	
	/**
	 * Return the package containing this type.
	 */
//	/* @NonNull*/ DomainPackage getPackage();

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

	/*@NonNull*/ DomainType specializeIn(@NonNull DomainCallExp expr, /*@NonNull*/ DomainType selfType);

	@Nullable DomainClass isClass();
	@Nullable DomainTemplateParameter isTemplateParameter();
}

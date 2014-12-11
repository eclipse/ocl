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
package org.eclipse.ocl.domain.elements;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;

public interface DomainClass extends DomainType
{
	/**
	 * Return a new instance of this type from valueFactory. Properties may be initialised using
	 * {@link Property#initValue(Object, Object) } provided no side-effect free
	 * OCL functionality is permitted to use the ObjectValue until initialisation has completed.
	 */
	@NonNull EObject createInstance();

	/**
	 * Return a new instance of this data type from valueFactory.
	 * @param value string initial value
	 */
	@Nullable Object createInstance( @NonNull String value);

	@NonNull List<Constraint> getOwnedInvariants();

	@NonNull List<Operation> getOwnedOperations();

	@NonNull List<Property> getOwnedProperties();
	
	DomainPackage getOwningPackage();

	@NonNull List<org.eclipse.ocl.pivot.Class> getSuperClasses();

	/**
	 * Return the ordered list of type parameters of this type.
	 */
	@NonNull DomainTypeParameters getTypeParameters();
	
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
	@NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation);
	@NonNull Operation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation);
}

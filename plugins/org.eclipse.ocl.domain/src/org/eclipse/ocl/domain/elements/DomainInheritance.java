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
package org.eclipse.ocl.domain.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.ids.OperationId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.utilities.IndexableIterable;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;

/**
 * An Inheritance provides access to the transitive inheritance relationships of a type
 * with respect to a particular type regime, noting that the complexities of CompleteOCL allow
 * for different inheritance for different applications.
 * 
 * The allSuperInheritances relationship is computed lazily and invalidated whenever a superclass changes.
 * KnownSubInheritances are also notified of invalidation avoiding the need for an adapting Inheritance
 * to adapt more than its own target class.
 */
public interface DomainInheritance extends Nameable
{
	public static @NonNull DomainInheritance[] EMPTY_ARRAY = new DomainInheritance[0];
	
	/**
	 * Return a depth ordered, OclAny-first, OclSelf-last, Iterable of all the super-adapters excluding this one.
	 */
	@NonNull Iterable<DomainFragment> getAllProperSuperFragments();
	
	/**
	 * Return a depth ordered, OclAny-first, OclSelf-last, Iterable of all the super-adapters including this one.
	 */
	@NonNull Iterable<DomainFragment> getAllSuperFragments();

	@NonNull DomainInheritance getCommonInheritance(@NonNull DomainInheritance inheritance);

	/**
	 * Return the inheritance depth of the target type: OclAny is at depth 0.
	 */
	int getDepth();
	
	@Nullable DomainFragment getFragment(@NonNull DomainInheritance thatInheritance);
	@NonNull Iterable<DomainFragment> getFragments();
	/*@Nullable*/ DomainFragment getFragment(int fragmentNumber);
	int getIndex(int fragmentNumber);
	int getIndexes();
	@Nullable Operation getMemberOperation(@NonNull OperationId id);
	@Nullable Property getMemberProperty(@NonNull String name);

	@NonNull DomainFragment getSelfFragment();
	
	/**
	 * Return an Iterable of all the super-inheritances at a specified depth, between 0 and getDepth() inclusive.
	 */
	@NonNull IndexableIterable<DomainFragment> getSuperFragments(int depth);

	@NonNull org.eclipse.ocl.pivot.Class getType();

	boolean isOclAny();
	boolean isSubInheritanceOf(@NonNull DomainInheritance inheritance);
	boolean isSuperInheritanceOf(@NonNull DomainInheritance inheritance);
	boolean isUndefined();

	@NonNull Operation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation);
	/**
	 * Return the dynamic (overloaded) implementation of the staticOperation applicable to the types managed
	 * by the given Standard Library.
	 */
	@NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation);
	@Nullable Operation lookupLocalOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainInheritance... argumentTypes);
}

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
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.utilities.IndexableIterable;

/**
 * An Inheritance provides access to the transitive inheritance relationships of a type
 * with respect to a particular type regime, noting that the complexities of CompleteOCL allow
 * for different inheritance for different applications.
 * 
 * The allSuperInheritances relationship is computed lazily and invalidated whenever a superclass changes.
 * KnownSubInheritances are also notified of invalidation avoiding the need for an adapting Inheritance
 * to adapt more than its own target class.
 */
public interface DomainInheritance extends DomainType
{
	public static DomainInheritance[] EMPTY_ARRAY = new DomainInheritance[0];

	@NonNull Iterable<? extends DomainOperation> getAllOperations(@Nullable FeatureFilter featureFilter);
	@NonNull Iterable<? extends DomainProperty> getAllProperties(@Nullable FeatureFilter featureFilter);
	
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
	/*@Nullable*/ DomainFragment getFragment(int fragmentNumber);
	int getIndex(int fragmentNumber);
	int getIndexes();
	@Nullable DomainOperation getMemberOperation(@NonNull OperationId id);
// FIXME	@NonNull Iterable<String> getMemberOperationNames();
// FIXME	@NonNull Iterable<DomainOperation> getMemberOperations();
	@Nullable DomainProperty getMemberProperty(@NonNull String name);

	@NonNull DomainFragment getSelfFragment();
	
	/**
	 * Return the Standard Library managing the dispatch tables.
	 */
	@NonNull DomainStandardLibrary getStandardLibrary();
	
	/**
	 * Return an Iterable of all the super-inheritances at a specified depth, between 0 and getDepth() inclusive.
	 */
	@NonNull IndexableIterable<DomainFragment> getSuperFragments(int depth);


	boolean isSubInheritanceOf(@NonNull DomainInheritance inheritance);
	boolean isSuperInheritanceOf(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainInheritance inheritance);
	boolean isUndefined();
	@Nullable DomainOperation lookupLocalOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainInheritance... argumentTypes);
}

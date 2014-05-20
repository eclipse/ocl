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
import org.eclipse.ocl.examples.domain.library.LibraryFeature;

/**
 * A DomainFragment identifies the capabilities introduced by a particular inheritance.
 */
public interface DomainFragment
{	
	/**
	 * Return the unoverloaded fragment, which is getBaseInheritance().getSelfFragment().
	 */
	@NonNull DomainFragment getBaseFragment();
	
	/**
	 * Return the inheritance that introduces the operations and properties in this fragment.
	 */
	@NonNull DomainInheritance getBaseInheritance();
	
	/**
	 * Return the inheritance that overloads the operations and properties in this fragment.
	 */
	@NonNull DomainInheritance getDerivedInheritance();
	
	/**
	 * Return the implementation of the operation within this fragment that has the same signature as staticOperation.
	 * If there is no local overload, returns an inherited operation if unambiguous or OclAnyUnsupportedOperation.AMBIGUOUS
	 * if ambiguous.
	 */
	@NonNull LibraryFeature getImplementation(@NonNull DomainOperation staticOperation);
	
	/**
	 * Return the operation within this fragment that has the same signature as staticOperation. Returns null if none.
	 */
	@Nullable DomainOperation getLocalOperation(@NonNull DomainOperation staticOperation);
	
	/**
	 * Return the operations within this fragment in operation index order.
	 */
	@NonNull Iterable<? extends DomainOperation> getLocalOperations();
	
	/**
	 * Return the properties within this fragment in property index order.
	 */
	@NonNull Iterable<? extends DomainProperty> getLocalProperties();
}
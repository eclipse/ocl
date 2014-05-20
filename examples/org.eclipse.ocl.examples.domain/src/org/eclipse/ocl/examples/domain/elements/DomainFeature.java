/*******************************************************************************
 * Copyright (c) 2011,2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.elements;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;

public interface DomainFeature extends DomainTypedElement
{
	/**
	 * Return the implementation of this feature.
	 */
	@Nullable LibraryFeature getImplementation();

	/**
	 * Return the owner this feature.
	 */
	/*@NonNull*/ DomainType getOwningType();

	/**
	 * Return true if this is a static operation.
	 */
	boolean isStatic();
}

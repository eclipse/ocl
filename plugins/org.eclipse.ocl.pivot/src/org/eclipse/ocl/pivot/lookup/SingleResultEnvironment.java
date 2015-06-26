/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;


/**
 * @since 1.1
 */
public interface SingleResultEnvironment extends LookupEnvironment {

	/**
	 * @return the matched result (or the first ambiguous one), otherwise <code>null</code>
	 */
	@Nullable
	NamedElement getSingleResult();
	
	/**
	 * @return a list with all matched (ambiguous) results. If no results are found,  it will return an empty list
	 */
	@NonNull
	List<NamedElement> getAllResults();	// FIXME, if no case of heterogeneous results is needed, change to List<? extends DomainNamedElement>
}

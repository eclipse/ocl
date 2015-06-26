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
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment;

/**
 * @since 1.1
 * 
 */
public interface AllResultsEnvironment  extends LookupEnvironment {

	/**
	 * @return a named indexed map of all reachable named  objects
	 */
	@NonNull
	Map<String, List<? extends NamedElement>> getAllResults();
	
}

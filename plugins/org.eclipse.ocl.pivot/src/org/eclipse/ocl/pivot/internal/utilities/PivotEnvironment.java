/*******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 182994, 252600
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.AbstractEnvironment;
import org.eclipse.ocl.pivot.internal.EnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;

/**
 * Implementation of the {@link EnvironmentInternal} for parsing OCL expressions on
 * Pivot models.
 */
public class PivotEnvironment extends AbstractEnvironment
{
	/**
	 * Initializes me with an environment factory from which package registry
	 * and opposite end finder (if any) are obtained consistently, and from a
	 * resource in which I am persisted (and from which I load myself if it
	 * already has content).
	 * 
	 * @param factory
	 *            a factory
	 */
	protected PivotEnvironment(@NonNull PivotEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

    /**
     * Initializes me with a parent environment, from which I inherit such things
     * as a package registry and a resource.
     * 
     * @param parent my parent environment
     */
	protected PivotEnvironment(@NonNull PivotEnvironment parent) {		
		super(parent);
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return getEnvironmentFactory().getMetaModelManager();
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return getMetaModelManager().getStandardLibrary();
	}
}

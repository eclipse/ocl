/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 *******************************************************************************/
package org.eclipse.ocl.pivot.resource;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * AbstractProjectManager provides a default implementation of the ProjectManager API that should be used by
 * all clients. The default provides very lightweight functionality that contributes no external projects
 * to a user application and incurs no classpath analysis ciosts to do so.
 */
public class AbstractProjectManager extends AdapterImpl implements ProjectManager
{
	/**
	 * The NO_PROJECTS instance of ProjectManager contributes no external projects to a user application. 
	 */
	public static final @NonNull ProjectManager NO_PROJECTS = new AbstractProjectManager();

	@Override
	public void addResourceDescriptor(@NonNull IResourceDescriptor resourceDescriptor) {
	}

	@Override
	public void configure(@NonNull ResourceSet resourceSet, @NonNull IResourceLoadStrategy instance, @Nullable IConflictHandler instance2) {
	}

	@Override
	public IPackageDescriptor getPackageDescriptor(@NonNull URI ecoreURI) {
		return null;
	}

	@Override
	public void initializeResourceSet(@NonNull ResourceSet resourceSet) {
	}

	@Override
	public void useGeneratedResource(@NonNull Resource resource, @NonNull ResourceSet resourceSet) {
	}
}
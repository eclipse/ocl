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
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;

/**
 * BasicProjectManager provides a default implementation of the ProjectManager API that should be used by
 * all clients. The default provides very lightweight functionality that contributes no external projects
 * to a user application and incurs no classpath analysis costs to do so.
 */
public class BasicProjectManager extends AdapterImpl implements ProjectManager
{

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
	public void unload(@NonNull ResourceSet resourceSet) {
	}

	@Override
	public void useGeneratedResource(@NonNull Resource resource, @NonNull ResourceSet resourceSet) {
	}
	
	
	public static @NonNull ProjectManager createDefaultProjectManager() { 
		return EcorePlugin.IS_ECLIPSE_RUNNING ? new ProjectMap() : new StandaloneProjectMap();
	}
	
	/**
	 * Return any {@link ProjectManager} already installed as an adapter on a
	 * <tt>resourceSet</tt>. Returns null if there is no such adapter.
	 */
	public static @Nullable ProjectManager findAdapter(@NonNull ResourceSet resourceSet) {
		return (ProjectManager) EcoreUtil.getAdapter(
			resourceSet.eAdapters(), ProjectManager.class);
	}
}
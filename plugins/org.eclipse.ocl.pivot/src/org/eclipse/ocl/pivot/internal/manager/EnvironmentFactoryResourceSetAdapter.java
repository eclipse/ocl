/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * An EnvironmentFactoryResourceSetAdapter associates an EnvironmentFactory with a ResourceSet so
 * that Resource creation can re-use a shared EnvironmentFactory.
 */
public class EnvironmentFactoryResourceSetAdapter implements Adapter.Internal
{		
	public static @Nullable EnvironmentFactoryResourceSetAdapter findAdapter(@NonNull ResourceSet resourceSet) {
		return ClassUtil.getAdapter(EnvironmentFactoryResourceSetAdapter.class, resourceSet);
	}
	
	public static @NonNull EnvironmentFactoryResourceSetAdapter getAdapter(@NonNull ResourceSet resourceSet, @Nullable EnvironmentFactory environmentFactory) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(resourceSet.eAdapters());
		EnvironmentFactoryResourceSetAdapter adapter = ClassUtil.getAdapter(EnvironmentFactoryResourceSetAdapter.class, eAdapters);
		if (adapter == null) {
			if (environmentFactory == null) {
				environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(StandaloneProjectMap.findAdapter(resourceSet));
			}
			adapter = new EnvironmentFactoryResourceSetAdapter(resourceSet, environmentFactory);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	protected final @NonNull ResourceSet resourceSet;
	protected final @NonNull EnvironmentFactory environmentFactory;
	
	public EnvironmentFactoryResourceSetAdapter(@NonNull ResourceSet resourceSet, @NonNull EnvironmentFactory environmentFactory) {
		this.resourceSet = resourceSet;
		this.environmentFactory = environmentFactory;
	}
	
	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull ResourceSet getTarget() {
		return resourceSet;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == EnvironmentFactoryResourceSetAdapter.class;
	}	

	@Override
	public void notifyChanged(Notification notification) {
	}

	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == resourceSet) || (newTarget == null);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		// TODO Auto-generated method stub		
	}
}
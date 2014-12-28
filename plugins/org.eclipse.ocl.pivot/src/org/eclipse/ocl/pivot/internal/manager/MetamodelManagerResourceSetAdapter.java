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
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A MetamodelManagerResourceSetAdapter associates a MetamodelManager with a ResourceSet so
 * that Resource creation can re-use a shared MetamodelManager.
 */
public class MetamodelManagerResourceSetAdapter implements MetamodelManagedAdapter
{		
	public static @Nullable MetamodelManagerResourceSetAdapter findAdapter(@NonNull ResourceSet resourceSet) {
		return ClassUtil.getAdapter(MetamodelManagerResourceSetAdapter.class, resourceSet);
	}
	
	public static @NonNull MetamodelManagerResourceSetAdapter getAdapter(@NonNull ResourceSet resourceSet, @Nullable MetamodelManager metamodelManager) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(resourceSet.eAdapters());
		MetamodelManagerResourceSetAdapter adapter = ClassUtil.getAdapter(MetamodelManagerResourceSetAdapter.class, eAdapters);
		if (adapter == null) {
			if (metamodelManager == null) {
				metamodelManager = new PivotEnvironmentFactory(null, null).getMetamodelManager();
			}
			adapter = new MetamodelManagerResourceSetAdapter(resourceSet, metamodelManager);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	protected final @NonNull ResourceSet resourceSet;
	protected final @NonNull MetamodelManager metamodelManager;
	
	public MetamodelManagerResourceSetAdapter(@NonNull ResourceSet resourceSet, @NonNull MetamodelManager metamodelManager) {
		this.resourceSet = resourceSet;
		this.metamodelManager = metamodelManager;
		metamodelManager.addListener(this);
	}

	public void dispose() {
		resourceSet.eAdapters().remove(this);
		metamodelManager.removeListener(this);
	}
	
	public @NonNull MetamodelManager getMetamodelManager() {
		return metamodelManager;
	}

	@Override
	public @NonNull ResourceSet getTarget() {
		return resourceSet;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == MetamodelManagerResourceSetAdapter.class;
	}	

	@Override
	public boolean isAdapterFor(@NonNull MetamodelManager metamodelManager) {
		return this.metamodelManager == metamodelManager;
	}

	@Override
	public void metamodelManagerDisposed(@NonNull MetamodelManager metamodelManager) {
		dispose();
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
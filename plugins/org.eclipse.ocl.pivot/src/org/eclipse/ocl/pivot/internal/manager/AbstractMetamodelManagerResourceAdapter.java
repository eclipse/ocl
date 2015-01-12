/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A MetamodelManagerResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public abstract class AbstractMetamodelManagerResourceAdapter<T extends Resource> implements MetamodelManagedAdapter
{		
	public static void disposeAll(@NonNull Resource resource) {
		List<Adapter> eAdapters = resource.eAdapters();
		for (int i = eAdapters.size(); --i >= 0; ) {
			Adapter adapter = eAdapters.get(i);
			if (adapter instanceof AbstractMetamodelManagerResourceAdapter) {
				eAdapters.remove(i);
			}
		}
	}

	public static @Nullable AbstractMetamodelManagerResourceAdapter<?> findAdapter(@NonNull Resource resource) {
		return ClassUtil.getAdapter(AbstractMetamodelManagerResourceAdapter.class, resource);
	}
	
//	public static LiveInstances<MetamodelManagerResourceAdapter> INSTANCES = new LiveInstances(MetamodelManagerResourceAdapter.class);
	
	protected final @NonNull T resource;
	protected final @NonNull MetamodelManager metamodelManager;
	
	public AbstractMetamodelManagerResourceAdapter(@NonNull T resource, @NonNull MetamodelManager metamodelManager) {
		this.resource = resource;
		this.metamodelManager = metamodelManager;
		metamodelManager.addListener(this);
//		INSTANCES.add(this);		
	}

	public void dispose() {
//		INSTANCES.remove(this);
		resource.eAdapters().remove(this);
		metamodelManager.removeListener(this);
	}
	
	public @NonNull MetamodelManager getMetamodelManager() {
		return metamodelManager;
	}

	@Override
	public T getTarget() {
		return resource;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == AbstractMetamodelManagerResourceAdapter.class;
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
		assert newTarget == resource;
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		assert oldTarget == resource;
	}
}
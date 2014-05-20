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
package org.eclipse.ocl.examples.pivot.manager;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * A MetaModelManagerResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public abstract class AbstractMetaModelManagerResourceAdapter<T extends Resource> implements MetaModelManagedAdapter
{		
	public static void disposeAll(@NonNull Resource resource) {
		List<Adapter> eAdapters = resource.eAdapters();
		for (int i = eAdapters.size(); --i >= 0; ) {
			Adapter adapter = eAdapters.get(i);
			if (adapter instanceof AbstractMetaModelManagerResourceAdapter) {
				eAdapters.remove(i);
			}
		}
	}

	public static @Nullable AbstractMetaModelManagerResourceAdapter<?> findAdapter(@NonNull Resource resource) {
		return PivotUtil.getAdapter(AbstractMetaModelManagerResourceAdapter.class, resource);
	}
	
//	public static LiveInstances<MetaModelManagerResourceAdapter> INSTANCES = new LiveInstances(MetaModelManagerResourceAdapter.class);
	
	protected final @NonNull T resource;
	protected final @NonNull MetaModelManager metaModelManager;
	
	public AbstractMetaModelManagerResourceAdapter(@NonNull T resource, @NonNull MetaModelManager metaModelManager) {
		this.resource = resource;
		this.metaModelManager = metaModelManager;
		metaModelManager.addListener(this);
//		INSTANCES.add(this);		
	}

	public void dispose() {
//		INSTANCES.remove(this);
		resource.eAdapters().remove(this);
		metaModelManager.removeListener(this);
	}
	
	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	public T getTarget() {
		return resource;
	}

	public boolean isAdapterFor(@NonNull MetaModelManager metaModelManager) {
		return this.metaModelManager == metaModelManager;
	}

	public boolean isAdapterForType(Object type) {
		return type == AbstractMetaModelManagerResourceAdapter.class;
	}	

	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		dispose();
	}

	public void notifyChanged(Notification notification) {
	}

	public void setTarget(Notifier newTarget) {
		assert newTarget == resource;
	}

	public void unsetTarget(Notifier oldTarget) {
		assert oldTarget == resource;
	}
}
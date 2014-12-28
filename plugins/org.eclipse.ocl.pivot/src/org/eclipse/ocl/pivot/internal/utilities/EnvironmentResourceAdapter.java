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
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * A EnvironmentResourceAdapter enhances the Resource to idenify its environment.
 */
public class EnvironmentResourceAdapter implements Adapter
{		
	public static EnvironmentResourceAdapter findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return ClassUtil.getAdapter(EnvironmentResourceAdapter.class, resource);
	}
	
	public static EnvironmentResourceAdapter getAdapter(@NonNull Resource resource, @NonNull PivotEnvironment environment) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(resource.eAdapters());
		EnvironmentResourceAdapter adapter = ClassUtil.getAdapter(EnvironmentResourceAdapter.class, eAdapters);
		if (adapter == null) {
			adapter = new EnvironmentResourceAdapter(resource, environment);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	protected final @NonNull Resource resource;
	protected final @NonNull PivotEnvironment environment;
	
	public EnvironmentResourceAdapter(@NonNull Resource resource, @NonNull PivotEnvironment environment) {
		this.resource = resource;
		this.environment = environment;
	}

	public MetaModelManager createMetaModelManager() {
		return new MetaModelManager();
	}

	@Override
	public @NonNull Resource getTarget() {
		return resource;
	}

	public @NonNull PivotEnvironment getEnvironment() {
		return environment;
	}
	
//	public MetaModelManager getMetaModelManager() {
//		return metaModelManager;
//	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == EnvironmentResourceAdapter.class;
	}	

	@Override
	public void notifyChanged(Notification notification) {
	}

	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == resource) || (newTarget == null);
	}
}
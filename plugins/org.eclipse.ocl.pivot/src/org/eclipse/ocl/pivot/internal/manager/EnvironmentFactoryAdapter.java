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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;

/**
 * An EnvironmentFactoryResourceSetAdapter associates an EnvironmentFactory with a ResourceSet so
 * that Resource creation can re-use a shared EnvironmentFactory.
 */
public class EnvironmentFactoryAdapter implements Adapter.Internal
{		
	public static void disposeAll(@NonNull Resource resource) {
/*		List<Adapter> eAdapters = resource.eAdapters();
		for (int i = eAdapters.size(); --i >= 0; ) {
			Adapter adapter = eAdapters.get(i);
			if (adapter instanceof MetamodelManagerResourceAdapter) {
				eAdapters.remove(i);
			}
		} */
	}

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull Notifier notifier;
	
	public EnvironmentFactoryAdapter( @NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Notifier notifier) {
		this.environmentFactory = environmentFactory;
		this.notifier = notifier;
	}
	
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}
	
	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull Notifier getTarget() {
		return notifier;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == EnvironmentFactoryAdapter.class;
	}	

	@Override
	public void notifyChanged(Notification notification) {
	}

	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == notifier) || (newTarget == null);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		// TODO Auto-generated method stub		
	}
}
/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * An OCLAdapter extends an EnvironmentFactoryAdapter so that the lifetime
 * of the OCL for a ResourceSet terminates with the ResourceSet adapter.
 */
public class OCLAdapter extends EnvironmentFactoryAdapter
{		
	public static @NonNull EnvironmentFactoryInternal adapt(@Nullable ProjectManager projectManager, @NonNull ResourceSet resourceSet) {
		OCL.Internal ocl = OCL.Internal.newInstance(projectManager);
		OCLAdapter adapter = new OCLAdapter(ocl, resourceSet);
		resourceSet.eAdapters().add(adapter);
		return adapter.getEnvironmentFactory();
	}
	
	protected final @NonNull OCL ocl;
	
	public OCLAdapter(@NonNull OCL.Internal ocl, @NonNull ResourceSet notifier) {
		super(ocl.getEnvironmentFactory(), notifier);
		this.ocl = ocl;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		super.setTarget(newTarget);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		super.unsetTarget(oldTarget);
		ocl.dispose();
	}
}
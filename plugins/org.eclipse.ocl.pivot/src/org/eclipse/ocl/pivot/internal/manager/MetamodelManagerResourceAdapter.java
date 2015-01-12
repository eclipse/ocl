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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * A MetamodelManagerResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public class MetamodelManagerResourceAdapter extends AbstractMetamodelManagerResourceAdapter
{		
/*	public static MetamodelManagerResourceAdapter findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return PivotUtil.getAdapter(MetamodelManagerResourceAdapter.class, resource);
	} */
	
	public static @NonNull MetamodelManagerResourceAdapter getAdapter(@NonNull Resource resource, @Nullable MetamodelManager metamodelManager) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(resource.eAdapters());
		MetamodelManagerResourceAdapter adapter = ClassUtil.getAdapter(MetamodelManagerResourceAdapter.class, eAdapters);
//		if ((adapter != null) && (metamodelManager != null) && (adapter.getMetamodelManager() != metamodelManager)) {
//			eAdapters.remove(adapter);
//			adapter = null;
//		}
		if (adapter == null) {
			if (metamodelManager == null) {
				ProjectManager projectManager = null;
				if (resource instanceof CSResource) {
					projectManager = ((CSResource)resource).getProjectManager();
				}
				metamodelManager = OCL.createEnvironmentFactory(projectManager).getMetamodelManager();
			}
			adapter = new MetamodelManagerResourceAdapter(resource, metamodelManager);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	public MetamodelManagerResourceAdapter(@NonNull Resource resource, @NonNull MetamodelManager metamodelManager) {
		super(resource, metamodelManager);		
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || (type == MetamodelManagerResourceAdapter.class);
	}
}
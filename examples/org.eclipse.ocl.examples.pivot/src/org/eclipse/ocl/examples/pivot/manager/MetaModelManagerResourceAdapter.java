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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * A MetaModelManagerResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public class MetaModelManagerResourceAdapter extends AbstractMetaModelManagerResourceAdapter<Resource>
{		
/*	public static MetaModelManagerResourceAdapter findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return PivotUtil.getAdapter(MetaModelManagerResourceAdapter.class, resource);
	} */
	
	public static @NonNull MetaModelManagerResourceAdapter getAdapter(@NonNull Resource resource, @Nullable MetaModelManager metaModelManager) {
		List<Adapter> eAdapters = DomainUtil.nonNullEMF(resource.eAdapters());
		MetaModelManagerResourceAdapter adapter = PivotUtil.getAdapter(MetaModelManagerResourceAdapter.class, eAdapters);
//		if ((adapter != null) && (metaModelManager != null) && (adapter.getMetaModelManager() != metaModelManager)) {
//			eAdapters.remove(adapter);
//			adapter = null;
//		}
		if (adapter == null) {
			if (metaModelManager == null) {
				metaModelManager = new MetaModelManager();
			}
			adapter = new MetaModelManagerResourceAdapter(resource, metaModelManager);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	public MetaModelManagerResourceAdapter(@NonNull Resource resource, @NonNull MetaModelManager metaModelManager) {
		super(resource, metaModelManager);		
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || (type == MetaModelManagerResourceAdapter.class);
	}
}
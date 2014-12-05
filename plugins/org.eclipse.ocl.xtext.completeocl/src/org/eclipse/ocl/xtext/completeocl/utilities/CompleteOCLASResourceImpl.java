/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactory;
import org.eclipse.ocl.examples.pivot.resource.ASResourceImpl;
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CS2ASResourceAdapter;

public class CompleteOCLASResourceImpl extends ASResourceImpl
{
	public CompleteOCLASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri, asResourceFactory);
	}

	@Override
	public EObject getEObject(String uriFragment) {
		if (idToEObjectMap == null) {
			AS2XMIid as2id = new AS2XMIid();
			as2id.assignIds(this, null);
		}
		return super.getEObject(uriFragment);
	}

	@Override
	public String getURIFragment(EObject eObject) {
		if (idToEObjectMap == null) {
			AS2XMIid as2id = new AS2XMIid();
			as2id.assignIds(this, null);
		}
		return super.getURIFragment(eObject);
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		@SuppressWarnings("null")@NonNull URI oclURI = uri.trimFileExtension();
		MetaModelManager metaModelManager = PivotUtil.getMetaModelManager(this);
		BaseCSResource csResource = (BaseCSResource) metaModelManager.getExternalResourceSet().getResource(oclURI, true);
		CS2ASResourceAdapter adapter = null;
//		try {
			adapter = csResource.getCS2ASAdapter(metaModelManager);
			ASResource asResource = adapter.getASResource(csResource);
			@SuppressWarnings("unused")
			List<EObject> pivotContents = asResource.getContents();
//			return asResource;
//		}
//		finally {
//			if (adapter != null) {
//				adapter.dispose();
//			}
//		}
//		Resource csResource = metaModelManager.getExternalResourceSet().getResource(oclURI, true);
//		CS2AS.loadFromEcore(this, ecoreURI);
		super.load(options);
	}
}
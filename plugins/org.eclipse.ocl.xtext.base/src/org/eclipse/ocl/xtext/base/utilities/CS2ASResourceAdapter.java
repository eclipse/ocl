/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.manager.AbstractMetamodelManagerResourceAdapter;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;

/**
 * A CS2ASResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public class CS2ASResourceAdapter extends AbstractMetamodelManagerResourceAdapter
{
	public static class TransientASResourceFactory extends AbstractASResourceFactory
	{
		public static @NonNull TransientASResourceFactory INSTANCE = new TransientASResourceFactory();
		
		public TransientASResourceFactory() {
			super("transient");
		}

		@Override
		public @NonNull ASResourceFactory getASResourceFactory() {
			return INSTANCE;
		}
	}

	/**
	 * A TransientASResource acts as the ASResource while parsing the body of an ExpressionInOCL. It enables
	 * the parsing to behave as if it has a Resource within a ResourceSet without disturbing the REsourceSet
	 * which may provoke Bug 451268.
	 */
	public static class TransientASResource extends ASResourceImpl
	{
		protected final @NonNull ResourceSet asResourceSet;

		public TransientASResource(@NonNull ResourceSet asResourceSet, @NonNull URI asURI) {
			super(asURI, TransientASResourceFactory.INSTANCE);
			this.asResourceSet = asResourceSet;
		}
		
		@Override
		public @NonNull ResourceSet getResourceSet() {
			return asResourceSet;
		}
	}

	private final @NonNull CS2AS converter;
	
	public CS2ASResourceAdapter(@NonNull BaseCSResource csResource, @NonNull EnvironmentFactoryInternal environmentFactory, @NonNull CS2AS converter) {
		super(csResource, environmentFactory.getMetamodelManager());
		this.converter = converter;
	}

	public @NonNull Map<BaseCSResource, ASResource> computeCS2ASResourceMap(@NonNull BaseCSResource csResource, @Nullable ASResource asResource, @NonNull MetamodelManager metamodelManager) {
		metamodelManager.getProjectManager();					// Ensures ProjectMap is notified of loaded resources
		final ResourceSet asResourceSet = metamodelManager.getTarget();
		Map<BaseCSResource,ASResource> cs2asResourceMap = new HashMap<BaseCSResource,ASResource>();
		URI uri = csResource.getURI();
		if ((uri != null) && (asResourceSet != null)) {
			if (asResource != null) {
				cs2asResourceMap.put(csResource, asResource);
			}
			else if (csResource.getContents().size() > 0) {
				URI asURI = csResource.getASURI(uri);
				if (uri.fileExtension().equals(PivotConstants.ESSENTIAL_OCL_FILE_EXTENSION)) {	// FIXME use csResource.getASResource(metamodelManager);
					asResource = new TransientASResource(asResourceSet, asURI);
				}
				else {
					asResource = (ASResource) asResourceSet.getResource(asURI, false);
					if (asResource == null) {
						asResource = (ASResource) asResourceSet.createResource(asURI, csResource.getASContentType());
					}
				}
				cs2asResourceMap.put(csResource, asResource);
			}
		}
		return cs2asResourceMap;
	}

	@Override
	public void dispose() {
		super.dispose();
		converter.dispose();
	}

	public @NonNull ASResource getASResource() {
		return converter.getASResource();
	}
	
	public @NonNull CS2AS getConverter() {
		return converter;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || (type == CS2ASResourceAdapter.class);
	}	
}

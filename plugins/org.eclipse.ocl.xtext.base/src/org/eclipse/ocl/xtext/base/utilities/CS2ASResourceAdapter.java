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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.manager.AbstractMetaModelManagerResourceAdapter;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.resource.AbstractASResourceFactory;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

/**
 * A CS2ASResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public class CS2ASResourceAdapter extends AbstractMetaModelManagerResourceAdapter<BaseCSResource>
{
	public static class TransientASResourceFactory extends AbstractASResourceFactory
	{
		public static @NonNull TransientASResourceFactory INSTANCE = new TransientASResourceFactory();
		
		public TransientASResourceFactory() {
			super("xyzzy", "essentialocl");
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
	
	public CS2ASResourceAdapter(@NonNull BaseCSResource csResource, @NonNull MetaModelManager metaModelManager) {
		super(csResource, metaModelManager);
		Map<BaseCSResource, ASResource> cs2asResourceMap = computeCS2ASResourceMap(csResource, metaModelManager);
		converter = csResource.createCS2AS(cs2asResourceMap, metaModelManager);
	}

	public @NonNull Map<BaseCSResource, ASResource> computeCS2ASResourceMap(@NonNull BaseCSResource csResource, @NonNull MetaModelManager metaModelManager) {
		metaModelManager.getProjectMap();					// Ensures ProjectMap is notified of loaded resources
		final ResourceSet asResourceSet = metaModelManager.getTarget();
		Map<BaseCSResource,ASResource> cs2asResourceMap = new HashMap<BaseCSResource,ASResource>();
		URI uri = csResource.getURI();
		if ((uri != null) && (csResource.getContents().size() > 0) && (asResourceSet != null)) {
			URI asURI = csResource.getASURI(uri);
			Resource asResource = null;
			if (uri.fileExtension().equals("essentialocl")) {	// FIXME use csResource.getASResource(metaModelManager);
				asResource = new TransientASResource(asResourceSet, asURI);
			}
			else {
				asResource = asResourceSet.getResource(asURI, false);
				if (asResource == null) {
					asResource = asResourceSet.createResource(asURI, csResource.getASContentType());
				}
			}
			cs2asResourceMap.put(csResource, (ASResource) asResource);
		}
		return cs2asResourceMap;
	}

	@Override
	public void dispose() {
		super.dispose();
		converter.dispose();
	}

	public ASResource getASResource(@NonNull BaseCSResource csResource) {
		return converter.getPivotResource(csResource);
	}
	
	public CS2AS getConverter() {
		return converter;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || (type == CS2ASResourceAdapter.class);
	}	
	
	public void refreshPivotMappings(@NonNull IDiagnosticConsumer diagnosticsConsumer) throws Exception {
		try {
			converter.update(diagnosticsConsumer);
		}
		catch (Exception e) {
			dispose();
			throw e;
		}
	}
}
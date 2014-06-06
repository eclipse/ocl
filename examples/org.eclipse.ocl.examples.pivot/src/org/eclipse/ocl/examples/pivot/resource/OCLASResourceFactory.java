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
package org.eclipse.ocl.examples.pivot.resource;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.library.StandardLibraryContribution;

/**
 * The <b>Resource Factory</b> for the pivot abstract syntax.
 */
public class OCLASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull OCLASResourceFactory INSTANCE = new OCLASResourceFactory();

	private static final @NonNull ContentHandler PIVOT_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		ASResource.CONTENT_TYPE, new String[]{ASResource.FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, PivotPackage.eNS_URI, null);

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, PIVOT_CONTENT_HANDLER);
	}

	/**
	 * Creates an instance of the resource factory.
	 */
	public OCLASResourceFactory() {
		super(ASResource.CONTENT_TYPE, ASResource.FILE_EXTENSION);
	}

	@Override
	public Resource createResource(URI uri) {
		//
		//	If *.oclas exists use it.
		//
		if (uri.isFile() && URIConverter.INSTANCE.exists(uri, null)) {
			return super.createResource(uri);
		}
		else if (uri.isPlatform()) {
			if (URIConverter.INSTANCE.exists(uri, null)) {
				return super.createResource(uri);
			}
			if (uri.isPlatformResource() && EMFPlugin.IS_ECLIPSE_RUNNING) {
				URI deresolvedURI = uri.deresolve(URI.createPlatformResourceURI("/", true));
				URI pluginURI = deresolvedURI.resolve(URI.createPlatformPluginURI("/", true));
				if (URIConverter.INSTANCE.exists(pluginURI, null)) {
					return super.createResource(pluginURI);
				}
			}
		}
		//
		//	Otherwise trim *.oclas and create a *.oclas by converting the trimmed resource to OCL AS.
		//
		URI nonASuri = uri.trimFileExtension();
		@SuppressWarnings("null")@NonNull String nonASuriString = nonASuri.toString();
		StandardLibraryContribution standardLibraryContribution = StandardLibraryContribution.REGISTRY.get(nonASuriString);
		if (standardLibraryContribution != null) {
			return standardLibraryContribution.getResource();
		}
		ASResourceFactory asResourceFactory = ASResourceFactoryRegistry.INSTANCE.getResourceFactory(nonASuri);
	    return asResourceFactory != null ? asResourceFactory.createResource(uri) : null;
	}
}

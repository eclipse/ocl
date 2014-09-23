/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclinecore.utilities;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.AbstractASResourceFactory;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;

public final class OCLinEcoreASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull OCLinEcoreASResourceFactory INSTANCE = new OCLinEcoreASResourceFactory();
	
	protected OCLinEcoreASResourceFactory() {
		super(ASResource.OCLINECORE_CONTENT_TYPE, null);
	}

	@Override
	public int getHandlerPriority(@NonNull Resource resource) {
		return resource instanceof OCLinEcoreCSResource ? CAN_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public int getHandlerPriority(@NonNull URI uri) {
		return "oclinecore".equals(uri.fileExtension()) ? CAN_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public URI getPackageURI(@NonNull EObject eObject) {
		if (eObject instanceof RootPackageCS) {
			Element pivot = ((RootPackageCS)eObject).getPivot();
			if (pivot instanceof Model) {
				String uri = ((Model)pivot).getExternalURI();
				if (uri != null) {
					if (uri.endsWith("oclinecore")) {
						uri = uri.substring(0, uri.length()-10) + "ecore"; 
					}
					return URI.createURI(uri);
				}
			}
		}
		else if (eObject instanceof PackageCS) {
			Element pivot = ((PackageCS)eObject).getPivot();
			if (pivot instanceof org.eclipse.ocl.examples.pivot.Package) {
				String uri = ((org.eclipse.ocl.examples.pivot.Package)pivot).getURI();
				if (uri != null) {
					return URI.createURI(uri);
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource resource, @Nullable URI uri) {
		Resource asResource = ((OCLinEcoreCSResource)resource).getASResource(metaModelManager);
		List<EObject> contents = asResource.getContents();
		if (contents.size() <= 0) {
			return null;
		}
		if ((uri != null) && (uri.fragment() == null)) {
			return (Element) contents.get(0);
		}
		else {
			throw new UnsupportedOperationException();	// FIXME
		}
	}

	@Override
	public boolean isCompatibleResource(@NonNull Resource newResource, @NonNull Resource oldResource) {
		URI newURI = newResource.getURI();
		URI oldURI = oldResource.getURI();
		if ((newURI == null) || (oldURI == null)) {
			return false;
		}
		URI newStem = newURI.trimFileExtension();
		URI oldStem = oldURI.trimFileExtension();
		return newStem.equals(oldStem);
	}
}
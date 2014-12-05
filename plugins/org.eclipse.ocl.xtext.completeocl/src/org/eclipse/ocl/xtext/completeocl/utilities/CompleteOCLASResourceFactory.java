/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.utilities;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;

public class CompleteOCLASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull CompleteOCLASResourceFactory INSTANCE = new CompleteOCLASResourceFactory();
	
	protected CompleteOCLASResourceFactory() {
		super(ASResource.COMPLETE_OCL_CONTENT_TYPE, null);
	}

	@Override
	public @NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id) {
		return new CompleteOCLAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull Resource createResource(URI uri) {
		assert uri != null;
		ASResource asResource = new CompleteOCLASResourceImpl(uri, this);
		configureResource(asResource);
	    return asResource;
	}

	@Override
	public int getHandlerPriority(@NonNull Resource resource) {
		return resource instanceof CompleteOCLCSResource ? CAN_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public int getHandlerPriority(@NonNull URI uri) {
		return "ocl".equals(uri.fileExtension()) ? CAN_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource resource, @Nullable URI uri) {
		Resource asResource = ((CompleteOCLCSResource)resource).getASResource(metaModelManager);
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
}
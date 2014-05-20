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
package org.eclipse.ocl.examples.pivot.ecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.resource.AbstractASResourceFactory;

public final class EcoreASResourceFactory extends AbstractASResourceFactory
{
	public static final @NonNull EcoreASResourceFactory INSTANCE = new EcoreASResourceFactory();

	public EcoreASResourceFactory() {
		super(ASResource.ECORE_CONTENT_TYPE, null);
	}

	@Override
	public @NonNull Resource createResource(URI uri) {
		assert uri != null;
		ASResource asResource = new EcoreASResourceImpl(uri, this);
		configureResource(asResource);
	    return asResource;
	}

	@Override
	public @Nullable <T extends Element> T getASElement(@NonNull MetaModelManager metaModelManager, @NonNull Class<T> pivotClass, @NonNull EObject eObject) {
		return metaModelManager.getPivotOfEcore(pivotClass, eObject);
	}

	@Override
	public int getHandlerPriority(@NonNull EObject eObject) {
		if (eObject instanceof ENamedElement) {  // Not EModelElement which could be UML
			return MAY_HANDLE;
		}
		else if (eObject instanceof DynamicEObjectImpl) {
			return MAY_HANDLE;
		}
		else {
			return CANNOT_HANDLE;
		}
	}

	@Override
	public int getHandlerPriority(@NonNull Resource resource) {
		return Ecore2Pivot.isEcore(resource) ? MAY_HANDLE : CANNOT_HANDLE;
	}

	@Override
	public int getHandlerPriority(@NonNull URI uri) {
		return "ecore".equals(uri.fileExtension()) ? CAN_HANDLE : MAY_HANDLE;
	}

	@Override
	public @Nullable URI getPackageURI(@NonNull EObject eObject) {
		if (eObject instanceof EPackage) {
			String uri = ((EPackage)eObject).getNsURI();
			if (uri != null) {
				return URI.createURI(uri);
			}
		}
		return null;
	}
	@Override
	public @Nullable Element importFromResource(@NonNull MetaModelManager metaModelManager, @NonNull Resource ecoreResource, @Nullable URI uri) {
		Ecore2Pivot conversion = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		conversion.setEcoreURI(uri);
		Root pivotRoot = conversion.getPivotRoot();
		String uriFragment = uri != null ? uri.fragment() : null;
		if (uriFragment == null) {
			return pivotRoot;
		}
		else {
			EObject eObject = ecoreResource.getEObject(uriFragment);
			if (eObject == null) {
				return null;
			}
			return conversion.newCreateMap.get(eObject);
		}
	}
}
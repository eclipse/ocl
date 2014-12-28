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
package org.eclipse.ocl.pivot.internal.ecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;

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
	public @Nullable <T extends Element> T getASElement(@NonNull MetamodelManager metamodelManager, @NonNull Class<T> pivotClass, @NonNull EObject eObject) {
		return metamodelManager.getPivotOfEcore(pivotClass, eObject);
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
		return Ecore2AS.isEcore(resource) ? MAY_HANDLE : CANNOT_HANDLE;
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
	public @Nullable Element importFromResource(@NonNull MetamodelManager metamodelManager, @NonNull Resource ecoreResource, @Nullable URI uri) {
		Ecore2AS conversion = Ecore2AS.getAdapter(ecoreResource, metamodelManager);
		conversion.setEcoreURI(uri);
		Model pivotModel = conversion.getPivotModel();
		String uriFragment = uri != null ? uri.fragment() : null;
		if (uriFragment == null) {
			return pivotModel;
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
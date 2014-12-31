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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.internal.validation.EcoreOCLEValidator;
import org.eclipse.ocl.pivot.resource.ASResource;

public final class EcoreASResourceFactory extends AbstractASResourceFactory
{
	private static @Nullable EcoreASResourceFactory INSTANCE = null;

	public static @NonNull EcoreASResourceFactory getInstance() {
		if (INSTANCE == null) {
			ASResourceFactoryContribution asResourceRegistry = ASResourceFactoryRegistry.INSTANCE.get(ASResource.ECORE_CONTENT_TYPE);
			if (asResourceRegistry != null) {
				asResourceRegistry.getASResourceFactory();						// Create the registered singleton
			}
			if (INSTANCE == null) {
				new EcoreASResourceFactory();									// Create our own singleton
			}
			assert INSTANCE != null;
			INSTANCE.install("ecore", null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	public EcoreASResourceFactory() {
		super(ASResource.ECORE_CONTENT_TYPE);
		INSTANCE = this;
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

	@Override
	public void initializeEValidatorRegistry(@NonNull org.eclipse.emf.ecore.EValidator.Registry eValidatorRegistry) {
		eValidatorRegistry.put(EcorePackage.eINSTANCE, EcoreOCLEValidator.NO_NEW_LINES);
	}
}

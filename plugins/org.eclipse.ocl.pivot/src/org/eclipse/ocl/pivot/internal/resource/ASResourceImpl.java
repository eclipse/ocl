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
package org.eclipse.ocl.pivot.internal.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.DerivedConstants;

public class ASResourceImpl extends XMIResourceImpl implements ASResource
{
	protected final @NonNull ASResourceFactory asResourceFactory;

	/**
	 * Creates an instance of the resource.
	 */
	public ASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri);
		this.asResourceFactory = asResourceFactory;
//		PivotUtilInternal.debugPrintln("Create " + NameUtil.debugSimpleName(this));	
	}

	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		if (resourceSet != null) {
			PivotMetamodelManager metamodelManager = PivotMetamodelManager.findAdapter(resourceSet);
			EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.findEnvironmentFactory(resourceSet);
			assert (metamodelManager != null) || (environmentFactory == null);
		}
		return super.basicSetResourceSet(resourceSet, notifications);
	}

	@Override
	protected XMLSave createXMLSave() {
		return new PivotSaveImpl(new XMIHelperImpl(this));
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return asResourceFactory;
	}

	@Override
	public @NonNull Model getModel() {
		EList<EObject> contents = getContents();
		if (contents.size() <= 0) {
			throw new IllegalStateException("No Model at root of empty '" + getURI() + "'");
		}
		EObject eObject = contents.get(0);
		if (!(eObject instanceof Model)) {
			throw new IllegalStateException("Non-Model at root of '" + getURI() + "'");
		}
		return (Model)eObject;
	}

	@Override
	public Map<Object, Object> getDefaultSaveOptions() {
		if (defaultSaveOptions == null) {
			defaultSaveOptions = new HashMap<Object, Object>();
			defaultSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
			defaultSaveOptions.put(DerivedConstants.RESOURCE_OPTION_LINE_DELIMITER, "\n");
		}
		return defaultSaveOptions;
	}

	@Override
	protected void unloaded(InternalEObject internalEObject) {
		if (internalEObject instanceof PivotObjectImpl) {
			((PivotObjectImpl)internalEObject).unloaded(this);
		}
		super.unloaded(internalEObject);
	}

	@Override
	protected boolean useIDs() {
		return true;
	}
}

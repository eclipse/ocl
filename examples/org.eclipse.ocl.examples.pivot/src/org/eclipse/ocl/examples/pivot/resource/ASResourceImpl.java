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
package org.eclipse.ocl.examples.pivot.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.PivotSaveImpl;

public class ASResourceImpl extends XMIResourceImpl implements ASResource
{
	protected final @NonNull ASResourceFactory asResourceFactory;

	/**
	 * Creates an instance of the resource.
	 */
	public ASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri);
		this.asResourceFactory = asResourceFactory;
	}

	@Override
	protected XMLSave createXMLSave() {
		return new PivotSaveImpl(new XMIHelperImpl(this));
	}

	public @NonNull ASResourceFactory getASResourceFactory() {
		return asResourceFactory;
	}

	@Override
	public Map<Object, Object> getDefaultSaveOptions() {
		if (defaultSaveOptions == null) {
			defaultSaveOptions = new HashMap<Object, Object>();
			defaultSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 132);
			defaultSaveOptions.put("LINE_DELIMITER", "\n");	// XMLResource.OPTION_LINE_DELIMITER
		}
		return defaultSaveOptions;
	}

	@Override
	protected boolean useIDs() {
		return true;
	}
}

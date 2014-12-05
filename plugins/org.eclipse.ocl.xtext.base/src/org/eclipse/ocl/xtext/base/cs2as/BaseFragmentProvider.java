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
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CS2ASResourceAdapter;
import org.eclipse.xtext.resource.DefaultFragmentProvider;

public class BaseFragmentProvider extends DefaultFragmentProvider
{
	@Override
	public EObject getEObject(Resource resource, String fragment, Fallback fallback) {
		// fragment should be a CS fragment
		if (resource == null) {
			return null;
		}
		if (fragment.startsWith("/")) {
			return super.getEObject(resource, fragment, fallback);
		}
		EObject eObject = super.getEObject(resource, fragment, fallback);
		if (eObject != null) {
			return eObject;
		}
		BaseCSResource csResource = (BaseCSResource)resource;
		CS2ASResourceAdapter converter = csResource.findCS2ASAdapter();
		if (converter != null) {
			Resource asResource = converter.getASResource(csResource);
			if (asResource != null) {
				eObject = asResource.getEObject(fragment);
				if (eObject != null) {
					return eObject;
				}
			}
		}
		return null;
	}
}

/***********************************************************************************************************************
 * Copyright (c) 2008-2009 Communication & Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.eclipse.ocl.ui.wizards.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ui.common.OCLUIPlugin;

/**
 * Set of utility methods helping to register/consult metamodels.<br>
 * 
 * @author mrostren
 * 
 */
public final class MetamodelUtils {

	/**
	 * Private constructor
	 */
	private MetamodelUtils() {
		// cannot be instantiated
	}

	/**
	 * Register the meta model if it has not been registered before. This is
	 * necessary to take into account local meta models that have not been
	 * prepared as new plugin.
	 * 
	 * @param theModel
	 */
	public static void registerMetaModel(EObject theModel) {
		if (theModel instanceof EPackage) {
			EPackage modelPackage = (EPackage) theModel;
			List<EPackage> packages = new ArrayList<EPackage>();
			packages.addAll(modelPackage.getESubpackages());
			packages.add(0, modelPackage);
			for (Iterator<EPackage> it = packages.iterator(); it.hasNext();) {
				EPackage p = it.next();
				String nsURI = p.getNsURI();
				if (nsURI == null) {
					nsURI = p.getName();
					p.setNsURI(nsURI);
				}
				if (!EPackage.Registry.INSTANCE.containsKey(nsURI)) {
					EPackage.Registry.INSTANCE.put(nsURI, p);
					OCLUIPlugin.log(
						"Model loaded : ".concat(nsURI), IStatus.INFO); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * Gets the highest package from a meta model
	 * 
	 * @param mmUri
	 * @return URI from the container package at the highest level
	 */
	public static String getESuperPackage(String mmUri) {

		EPackage packageTemp = EPackage.Registry.INSTANCE.getEPackage(mmUri);
		// Calling register on superPackage
		if (packageTemp != null) {
			EPackage eSuperPackage = packageTemp.getESuperPackage();
			if (eSuperPackage != null) {
				while (eSuperPackage != null
					&& eSuperPackage.getESuperPackage() != null) {
					eSuperPackage = eSuperPackage.getESuperPackage();
					// if the current package is unknown, we register it
					registerMetaModel(eSuperPackage);
				}
				return eSuperPackage.getNsURI();
			} else {
				return packageTemp.getNsURI();
			}
		}
		return ""; //$NON-NLS-1$
	}
}

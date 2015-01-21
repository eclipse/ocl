/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA List) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.es2as;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;






//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 * UML2ASUtil provides a variety of helpful routines for dealing with UML midels in conjunction with the Pivot-based OCL.
 */
public class UML2ASUtil
{
//	private static final Logger logger = Logger.getLogger(UML2ASUtil.class);

	public static @NonNull Map<EObject, List<org.eclipse.uml2.uml.Element>> computeAppliedStereotypes(@NonNull Iterable<EObject> umlStereotypeApplications) {
		//
		// Compute the list of UML elements stereotyped by each UML stereotype application.
		//
		// Note that the UML stereotype application object is an EDynamicObject unless the Profile has been genmodelled as
		// is the case for the standard UML profile(s).
		//
		Map<EObject, List<org.eclipse.uml2.uml.Element>> umlStereotypeApplication2umlStereotypedElements = new HashMap<EObject, List<org.eclipse.uml2.uml.Element>>();
		for (@SuppressWarnings("null")@NonNull EObject umlStereotypeApplication : umlStereotypeApplications) {
			List<org.eclipse.uml2.uml.Element> umlStereotypedElements = resolveStereotypedElements(umlStereotypeApplication);
			umlStereotypeApplication2umlStereotypedElements.put(umlStereotypeApplication, umlStereotypedElements);
		}
		if (UML2AS.ADD_STEREOTYPE_APPLICATION.isActive()) {
			Map<EClass, Set<org.eclipse.uml2.uml.Element>> umlStereotypeEClass2umlStereotypedElements = new HashMap<EClass, Set<org.eclipse.uml2.uml.Element>>();
			for (@SuppressWarnings("null")@NonNull EObject umlStereotypeApplication : umlStereotypeApplications) {
				List<org.eclipse.uml2.uml.Element> umlStereotypedElements = umlStereotypeApplication2umlStereotypedElements.get(umlStereotypeApplication);
				Set<org.eclipse.uml2.uml.Element> perEClassUMLStereotypedElements = umlStereotypeEClass2umlStereotypedElements.get(umlStereotypeApplication.eClass());
				if (perEClassUMLStereotypedElements == null) {
					perEClassUMLStereotypedElements = new HashSet<org.eclipse.uml2.uml.Element>();
					umlStereotypeEClass2umlStereotypedElements.put(umlStereotypeApplication.eClass(), perEClassUMLStereotypedElements);
				}
				perEClassUMLStereotypedElements.addAll(umlStereotypedElements);
			}
			StringBuffer s = new StringBuffer();
			for (@SuppressWarnings("null")@NonNull EClass umlStereotypeEClass : umlStereotypeEClass2umlStereotypedElements.keySet()) {
				s.append("\n\t" + NameUtil.qualifiedNameFor(umlStereotypeEClass));
				for (org.eclipse.uml2.uml.Element umlStereotypedElement : umlStereotypeEClass2umlStereotypedElements.get(umlStereotypeEClass)) {
					if (umlStereotypedElement != null) {
						s.append("\n\t\t" + NameUtil.qualifiedNameFor(umlStereotypedElement));
					}
				}
			}
			UML2AS.ADD_STEREOTYPE_APPLICATION.println("Applications per Stereotype" + s.toString());
		}
		return umlStereotypeApplication2umlStereotypedElements;
	}

	/**
	 * Return the metaType of umlElement using the UML meta namespace identifiable from stereotype applications.
	 */
	public static @Nullable org.eclipse.ocl.pivot.Class getMetaType(@NonNull EnvironmentFactory environmentFactory, @NonNull org.eclipse.uml2.uml.Element umlElement) {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		EClass umlEClass = umlElement.eClass();
		for (org.eclipse.uml2.uml.Stereotype umlStereotype : umlElement.getApplicableStereotypes()) {
			for (org.eclipse.uml2.uml.Class umlMetaclass : umlStereotype.getAllExtendedMetaclasses()) {
				org.eclipse.uml2.uml.Package umlPackage = umlMetaclass.getPackage();
				org.eclipse.uml2.uml.Type umlType = umlPackage.getOwnedType(umlEClass.getName());
				if (umlType != null) {
					try {
						org.eclipse.ocl.pivot.Class umlAStype = metamodelManager.getASOf(org.eclipse.ocl.pivot.Class.class, umlType);
						if (umlAStype != null) {
							return umlAStype;
						}
					} catch (ParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	/**
	 *	Determine the list of UML elements stereotyped by a UML stereotype application.
	 *	These are the targets of base_XXX XML elements.
	 */
	public static @NonNull List<org.eclipse.uml2.uml.Element> resolveStereotypedElements(@NonNull EObject umlStereotypeApplication) {
		EClass eClass = umlStereotypeApplication.eClass();
		List<org.eclipse.uml2.uml.Element> umlStereotypedElements = new ArrayList<org.eclipse.uml2.uml.Element>();
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			String featureName = eStructuralFeature.getName();
			if ((featureName != null) && featureName.startsWith(UML2AS.STEREOTYPE_BASE_PREFIX)
			  && (eStructuralFeature instanceof EReference)
			  && umlStereotypeApplication.eIsSet(eStructuralFeature)) {						// Unset for an applicable stereotype that has not been applied
				Object umlStereotypedElement = umlStereotypeApplication.eGet(eStructuralFeature);
				if (umlStereotypedElement instanceof org.eclipse.uml2.uml.Element) {
					umlStereotypedElements.add((org.eclipse.uml2.uml.Element) umlStereotypedElement);
				}
			}
		}
		return umlStereotypedElements;
	}
}

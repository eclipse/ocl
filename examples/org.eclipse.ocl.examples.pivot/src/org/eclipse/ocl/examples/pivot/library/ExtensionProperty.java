/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ExplicitNavigationProperty.java,v 1.2 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * The static instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class ExtensionProperty extends AbstractProperty
{
	protected @NonNull DomainProperty property;
	
	public ExtensionProperty(@NonNull DomainProperty property) {
		this.property = property;
	}
	
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		Element element = null;
		if (sourceValue instanceof Element) {
			element = (Element)sourceValue;
		}
		else {
			try {
				element = ((MetaModelManager)evaluator.getStandardLibrary()).getPivotOf(Element.class, (EObject)sourceValue);
			} catch (ParserException e) {
				return new InvalidValueException(e, "Failed to parse " + property);
			}
		}
		if (element != null) {
/*			EObject eTarget = ((Element)sourceValue).getETarget();
			if (eTarget instanceof org.eclipse.uml2.uml.Element) {
				org.eclipse.uml2.uml.Element umlElement = (org.eclipse.uml2.uml.Element)eTarget;
				DomainType type = property.getType();
				if (type instanceof Stereotype) {
					EObject umlRequiredStereotype = ((Stereotype)type).getETarget();
					if (umlRequiredStereotype instanceof org.eclipse.uml2.uml.Stereotype) {
						List<Stereotype> appliedStereotypes = null;
						EList<EObject> umlStereotypeApplications = umlElement.getStereotypeApplications();
						for (EObject umlStereotypeApplication : umlStereotypeApplications) {
							org.eclipse.uml2.uml.Stereotype umlAppliedStereotype = resolveStereotype(umlStereotypeApplication);
							if ((umlAppliedStereotype != null) && umlAppliedStereotype.conformsTo((org.eclipse.uml2.uml.Stereotype)umlRequiredStereotype)) {
								try {
									Stereotype appliedStereotype = ((MetaModelManager)evaluator.getStandardLibrary()).getPivotOf(Stereotype.class, umlAppliedStereotype);
									if (appliedStereotype != null) {
										if (appliedStereotypes == null) {
											appliedStereotypes = new ArrayList<Stereotype>();
										}
										appliedStereotypes.add(appliedStereotype);
									}
								} catch (ParserException e) {
									// TODO Auto-generated catch block
									//e.printStackTrace();
								}
							}
						}
						if (appliedStereotypes == null) {
							return null;
						}
						TypeId typeId = property.getTypeId();
						if (typeId instanceof CollectionTypeId) {
							return ValuesUtil.createSetValue((CollectionTypeId) typeId, appliedStereotypes);
						}
						else if (appliedStereotypes.size() == 1) {
							return appliedStereotypes.get(0);
						}
						else {
							return new InvalidValueException("Multiple apploied stereotypes for " + property);
						}
					}
				}
			} */
			List<ElementExtension> selectedExtensions = null;
			for (ElementExtension elementExtension : element.getExtension()) {
				Stereotype stereotype = elementExtension.getStereotype();
				if (stereotype.conformsTo(evaluator.getStandardLibrary(), property.getType())) {
					if (selectedExtensions == null) {
						selectedExtensions = new ArrayList<ElementExtension>();
					}
					selectedExtensions.add(elementExtension);
				}
			}
			if (selectedExtensions == null) {
				return null;
			}
			TypeId typeId = property.getTypeId();
			if (typeId instanceof CollectionTypeId) {
				return ValuesUtil.createSetValue((CollectionTypeId) typeId, selectedExtensions);
			}
			else if (selectedExtensions.size() == 1) {
				return selectedExtensions.get(0);
			}
			else {
				return new InvalidValueException("Multiple applied stereotypes for " + property);
			}
		}
		return property.getType(); 
	}
	

	/**
	 * Return the UML Stereotype referenced by the UML stereotype application to some UML Stereotyped Elements.
	 *<p>
	 * Note that the reference in the UML Stereotype application is to a particular Ecore version of the Profile, rather than
	 * to the UML profile, so we have to locate the UML profile by URI and name.
	 */
	private static @Nullable org.eclipse.uml2.uml.Stereotype resolveStereotype(@NonNull EObject umlStereotypeApplication) {
		EClass umlStereotypeEClass = umlStereotypeApplication.eClass();
		if (umlStereotypeEClass == null) {
			return null;
		}
//		if (!(umlStereotypeApplication instanceof DynamicEObjectImpl)) {					// If stereotyped element has been genmodelled
//			Stereotype asStereotype = metaModelManager.getPivotOfEcore(Stereotype.class, umlStereotypeEClass);
//			return asStereotype;		// then it is already a Type rather than a Stereotype
//		}
		EPackage umlStereotypeEPackage = umlStereotypeEClass.getEPackage();
		if (umlStereotypeEPackage == null) {
			return null;
		}
		EObject eAnnotation = umlStereotypeEPackage.eContainer();
		if (eAnnotation == null) {
			return null;
		}
		EObject eAnnotationContainer = eAnnotation.eContainer();
		if (!(eAnnotationContainer instanceof org.eclipse.uml2.uml.Profile)) {
			return null;
		}
		org.eclipse.uml2.uml.Profile umlProfile = (org.eclipse.uml2.uml.Profile) eAnnotationContainer;
		org.eclipse.uml2.uml.Stereotype umlStereotype = umlProfile.getOwnedStereotype(umlStereotypeEClass.getName());
//		logger.error("Missing package for stereotype application of " + umlStereotypeEClass.getName());
		return umlStereotype;
	}

}
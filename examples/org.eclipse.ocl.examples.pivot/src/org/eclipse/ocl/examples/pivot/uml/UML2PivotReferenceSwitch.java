/*******************************************************************************
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 400744
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Profile;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.uml2.uml.util.UMLSwitch;

//
//	Originally everthing was in the Reference pass but the Stereotype resolution preceded it and got steadily more complicated
//  so all activities were moved to a new last Use pass. Simple reference resolving activities can be moved from the Use pass to the REference pass.
//
public class UML2PivotReferenceSwitch extends UMLSwitch<Object>
{
	private static final Logger logger = Logger.getLogger(UML2PivotReferenceSwitch.class);

	protected final @NonNull UML2Pivot converter;
	protected final @NonNull MetaModelManager metaModelManager;
	private Set<EClass> doneWarnings = null;
	
	public UML2PivotReferenceSwitch(@NonNull UML2Pivot converter) {
		this.converter = converter;
		this.metaModelManager = converter.getMetaModelManager();
	}

	@Override
	public Object caseAssociation(org.eclipse.uml2.uml.Association umlAssociation) {
		assert umlAssociation != null;
		List<org.eclipse.uml2.uml.Property> memberEnds = umlAssociation.getMemberEnds();
		if (memberEnds.size() == 2) {
			org.eclipse.uml2.uml.Property firstEnd = memberEnds.get(0);
			org.eclipse.uml2.uml.Property secondEnd = memberEnds.get(1);
			if ((firstEnd != null) && (secondEnd != null)) {
				Property firstProperty = converter.getCreated(Property.class, firstEnd);
				Property secondProperty = converter.getCreated(Property.class, secondEnd);
				if ((firstProperty != null) && (secondProperty != null)) {
					firstProperty.setOpposite(secondProperty);
					secondProperty.setOpposite(firstProperty);
				}
			}
		}
		return this;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		assert umlClass != null;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, umlClass);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getSuperClass(), umlClass.getSuperClasses());
			if (pivotElement.getSuperClass().isEmpty()) {
				org.eclipse.ocl.examples.pivot.Class oclElementType = metaModelManager.getOclElementType();
				pivotElement.getSuperClass().add(oclElementType);
			}
		}
		return pivotElement;
	}

	@Override
	public Object caseExtension(org.eclipse.uml2.uml.Extension umlExtension) {
		caseAssociation(umlExtension);
		assert umlExtension != null;
		TypeExtension asTypeExtension = converter.getCreated(TypeExtension.class, umlExtension);
		if (asTypeExtension != null) {
			org.eclipse.uml2.uml.Class umlMetaclass = umlExtension.getMetaclass();
			org.eclipse.uml2.uml.Stereotype umlStereotype = umlExtension.getStereotype();
			if ((umlMetaclass != null) && (umlStereotype != null)) {
				Type asMetaclass = converter.getCreated(Type.class, umlMetaclass);
				Stereotype asStereotype = converter.getCreated(Stereotype.class, umlStereotype);
				if ((asMetaclass != null) && (asStereotype != null)) {
					asTypeExtension.setStereotype(asStereotype);
					asTypeExtension.setType(asMetaclass);
					if (UML2Pivot.ADD_TYPE_EXTENSION.isActive()) {
						UML2Pivot.ADD_TYPE_EXTENSION.println(asTypeExtension.toString());
					}
					converter.addTypeExtension(asTypeExtension);
				}
			}
		}
		return this;
	}

	@Override
	public Object caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication umlProfileApplication) {
		assert umlProfileApplication != null;
		ProfileApplication asProfileApplication = converter.getCreated(ProfileApplication.class, umlProfileApplication);
		if (asProfileApplication != null) {
			org.eclipse.uml2.uml.Profile umlProfile = umlProfileApplication.getAppliedProfile();
			if (umlProfile != null) {
				Profile asProfile = converter.getCreated(Profile.class, umlProfile);
				asProfileApplication.setAppliedProfile(asProfile);
				converter.addProfileApplication(asProfileApplication);
			}
		}
		return this;
	}

	@Override
	public Object caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		assert umlProperty != null;
		caseTypedElement(umlProperty);
		Property asProperty = converter.getCreated(Property.class, umlProperty);
		if (asProperty != null) {
			if (asProperty.getName() == null) {
				org.eclipse.uml2.uml.Type umlTargetType = umlProperty.getType();
				if (umlTargetType != null) {
					Type asTargetType = converter.getCreated(Type.class, umlTargetType);
					if (asTargetType != null) {
						asProperty.setName(asTargetType.getName());
					}
				}
			}
			Type pivotType = null;
			org.eclipse.uml2.uml.Association umlAssociation = umlProperty.getAssociation();
			if (umlAssociation != null) {
				if (umlProperty.getOwningAssociation() != null) {
					asProperty.setImplicit(true);
				}
				org.eclipse.uml2.uml.Property opposite = getOtherEnd(umlProperty);
				if (opposite != null) {
					org.eclipse.uml2.uml.Type oppositeType = opposite.getType();
					if (oppositeType != null) {
						pivotType = converter.getCreated(Type.class, oppositeType);
					}
				}
			}
			if (pivotType == null) {
				EObject eContainer = umlProperty.eContainer();
				if (eContainer !=null){
					pivotType = converter.getCreated(Type.class, eContainer);
				}
			}
			if (pivotType != null) {
				converter.addProperty(pivotType, asProperty);
			}
			else {
//				System.err.println("Failed to find parent for " + umlProperty);
			}
		}
		return asProperty;
	}

	@Override
	public Object caseStereotype(org.eclipse.uml2.uml.Stereotype umlStereotype) {
		assert umlStereotype != null;
		caseClass(umlStereotype);
		Stereotype asStereotype = converter.getCreated(Stereotype.class, umlStereotype);
		if (asStereotype != null) {
			converter.addStereotype(asStereotype);
		}
		return asStereotype;
	}

	@Override
	public EObject caseTypedElement(org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		assert umlTypedElement != null;
		TypedElement pivotElement = converter.getCreated(TypedElement.class, umlTypedElement);
		if (pivotElement != null) {
			resolveMultiplicity(pivotElement, umlTypedElement);
		}
		return pivotElement;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	public <T extends Element> void doSwitchAll(@NonNull Class<T> pivotClass, /*@NonNull*/ Collection<T> pivotElements, /*@NonNull*/ List<? extends EObject> eObjects) {
		assert pivotElements != null;
		assert eObjects != null;
		for (EObject eObject : eObjects) {
			if (eObject != null) {
				T pivotElement = converter.getCreated(pivotClass, eObject);
				if (pivotElement == null) {
					Resource eResource = eObject.eResource();
					if (eResource != null) {
						UML2Pivot adapter = UML2Pivot.findAdapter(eResource, metaModelManager);
						if (adapter != null) {
							pivotElement = adapter.getCreated(pivotClass,
								eObject);
						}
					}
				}
				if (pivotElement == null) {
					if (!(eObject instanceof org.eclipse.uml2.uml.Constraint)) {
						System.out.println("Reference switching " + eObject);
					}
					@SuppressWarnings("unchecked")T doSwitchResult = (T) doSwitch(eObject);
					pivotElement = doSwitchResult;
				}
				if (pivotElement != null) {
					pivotElements.add(pivotElement);
				}
				else {
					if (doneWarnings == null) {
						doneWarnings = new HashSet<EClass>();
					}
					EClass eClass = eObject.eClass();
					if (doneWarnings.add(eClass)) {
						logger.warn("Failed to create a pivot representation of a UML '" + eClass.getName() + "'");
					}
				}
			}
		}
	}

	protected org.eclipse.uml2.uml.Property getOtherEnd(@NonNull org.eclipse.uml2.uml.Property umlProperty) {
		org.eclipse.uml2.uml.Property otherEnd = umlProperty.getOtherEnd();
		if (otherEnd != null) {
			return otherEnd;
		}
		// Workaround problem whereby UML has three ends two of them duplicates with distinct Class/Association ownership.
		org.eclipse.uml2.uml.Association association = umlProperty.getAssociation();
		if (association != null) {
			List<org.eclipse.uml2.uml.Property> memberEnds = new ArrayList<org.eclipse.uml2.uml.Property>(association.getMemberEnds());
			memberEnds.remove(umlProperty);
			for (org.eclipse.uml2.uml.Property aProperty : memberEnds) {
				if (!aProperty.getName().equals(umlProperty)) {
					return aProperty;
				}
			}
		}
		return otherEnd;
	}

	public @Nullable org.eclipse.uml2.uml.Property getOtherEnd(@NonNull List<org.eclipse.uml2.uml.Property> umlMemberEnds, @NonNull org.eclipse.uml2.uml.Property umlProperty) {
		for (org.eclipse.uml2.uml.Property umlMemberEnd : umlMemberEnds) {
			if (umlMemberEnd != umlProperty) {
				return umlMemberEnd;
			}
		}
		return null;
	}

	protected void resolveMultiplicity(@NonNull TypedElement pivotElement, @NonNull org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		boolean isRequired = false;
		org.eclipse.uml2.uml.Type umlType = umlTypedElement.getType();
		if (umlType != null) {
			Type pivotType = converter.resolveType(umlType);
			if ((umlTypedElement instanceof org.eclipse.uml2.uml.MultiplicityElement) && (pivotType != null)) {
				org.eclipse.uml2.uml.MultiplicityElement umlMultiplicity = (org.eclipse.uml2.uml.MultiplicityElement)umlTypedElement;
				int lower = umlMultiplicity.getLower();
				int upper = umlMultiplicity.getUpper();
				if (upper == 1) {
					isRequired = lower == 1;
				}
				else {
					isRequired = true;
					boolean isOrdered = umlMultiplicity.isOrdered();
					boolean isUnique = umlMultiplicity.isUnique();
					IntegerValue lowerValue = ValuesUtil.integerValueOf(lower);
					IntegerValue upperValue = upper == -1 ? ValuesUtil.UNLIMITED_VALUE : ValuesUtil.integerValueOf(upper);
					pivotType = metaModelManager.getCollectionType(isOrdered, isUnique, pivotType, lowerValue, upperValue);
				}
			}
			pivotElement.setType(pivotType);
		}
		else {
			pivotElement.setType(metaModelManager.getOclVoidType());
		}
		pivotElement.setIsRequired(isRequired);
	}
}
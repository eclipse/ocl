/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink - initial API and implementation
 *	E.D.Willink (CEA LIST) - Bug 400744
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.es2as;

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
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Slot;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.uml2.uml.util.UMLSwitch;

//
//	Originally everthing was in the Reference pass but the Stereotype resolution preceded it and got steadily more complicated
//  so all activities were moved to a new last Use pass. Simple reference resolving activities can be moved from the Use pass to the REference pass.
//
public class UML2ASReferenceSwitch extends UMLSwitch<Object>
{
	private static final Logger logger = Logger.getLogger(UML2ASReferenceSwitch.class);

	protected final @NonNull UML2AS converter;
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	private Set<EClass> doneWarnings = null;
	
	public UML2ASReferenceSwitch(@NonNull UML2AS converter) {
		this.converter = converter;
		this.environmentFactory = converter.getEnvironmentFactory();
		this.standardLibrary = converter.getStandardLibrary();
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
	public org.eclipse.ocl.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		assert umlClass != null;
		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClass);
		if (pivotElement != null) {
			doSwitchAll(org.eclipse.ocl.pivot.Class.class, ClassUtil.nullFree(pivotElement.getSuperClasses()), umlClass.getSuperClasses());
			if (pivotElement.getSuperClasses().isEmpty()) {
				org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
				pivotElement.getSuperClasses().add(oclElementType);
			}
		}
		return pivotElement;
	}

	@Override
	public Object caseDataType(org.eclipse.uml2.uml.DataType umlDataType) {
		assert umlDataType != null;
		DataType pivotElement = converter.getCreated(DataType.class, umlDataType);
		List<org.eclipse.ocl.pivot.Class> asSuperClasses = new ArrayList<org.eclipse.ocl.pivot.Class>();
		if (pivotElement != null) {
			for (org.eclipse.uml2.uml.Generalization umlGeneralization : umlDataType.getGeneralizations()) {
				org.eclipse.uml2.uml.Classifier umlGeneral = umlGeneralization.getGeneral();
				if (umlGeneral != null) {
					org.eclipse.ocl.pivot.Class asGeneral = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlGeneral);
					if ((asGeneral != null) && !asSuperClasses.contains(asGeneral)) {
						asSuperClasses.add(asGeneral);
					}
				}
			}
			if (asSuperClasses.isEmpty()) {
				org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
				asSuperClasses.add(oclElementType);
			}
			converter.refreshList(pivotElement.getSuperClasses(), asSuperClasses);
		}
		return pivotElement;
	}

	@Override
	public Object caseExtension(org.eclipse.uml2.uml.Extension umlExtension) {
		caseAssociation(umlExtension);
		assert umlExtension != null;
		StereotypeExtender asTypeExtension = converter.getCreated(StereotypeExtender.class, umlExtension);
		if (asTypeExtension != null) {
			org.eclipse.uml2.uml.Class umlMetaclass = umlExtension.getMetaclass();
			org.eclipse.uml2.uml.Stereotype umlStereotype = umlExtension.getStereotype();
			if ((umlMetaclass != null) && (umlStereotype != null)) {
				org.eclipse.ocl.pivot.Class asMetaclass = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlMetaclass);
				Stereotype asStereotype = converter.getCreated(Stereotype.class, umlStereotype);
				if ((asMetaclass != null) && (asStereotype != null)) {
					asTypeExtension.setOwningStereotype(asStereotype);
					asTypeExtension.setClass(asMetaclass);
					if (UML2AS.ADD_TYPE_EXTENSION.isActive()) {
						UML2AS.ADD_TYPE_EXTENSION.println(asTypeExtension.toString());
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
			org.eclipse.ocl.pivot.Class pivotType = null;
			org.eclipse.uml2.uml.Association umlAssociation = umlProperty.getAssociation();
			if (umlAssociation != null) {
				if (umlProperty.getOwningAssociation() != null) {
					asProperty.setIsImplicit(true);
				}
				org.eclipse.uml2.uml.Property opposite = getOtherEnd(umlProperty);
				if (opposite != null) {
					org.eclipse.uml2.uml.Type oppositeType = opposite.getType();
					if (oppositeType != null) {
						pivotType = converter.getCreated(org.eclipse.ocl.pivot.Class.class, oppositeType);
					}
				}
			}
			if (pivotType == null) {
				EObject eContainer = umlProperty.eContainer();
				if (eContainer != null) {
					pivotType = converter.getCreated(org.eclipse.ocl.pivot.Class.class, eContainer);
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
	public Object caseSlot(org.eclipse.uml2.uml.Slot umlSlot) {
		assert umlSlot != null;
		Slot asSlot = converter.getCreated(Slot.class, umlSlot);
		if (asSlot != null) {
			org.eclipse.uml2.uml.StructuralFeature umlDefiningFeature = umlSlot.getDefiningFeature();
			Property asProperty = umlDefiningFeature != null ? converter.getCreated(Property.class, umlDefiningFeature) : null;
			asSlot.setDefiningProperty(asProperty);
		}
		return this;
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
			converter.resolveMultiplicity(pivotElement, umlTypedElement);
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
				@Nullable T pivotElement = converter.getCreated(pivotClass, eObject);
				if (pivotElement == null) {
					Resource eResource = eObject.eResource();
					if (eResource != null) {
						External2AS adapter = UML2AS.findAdapter(eResource, environmentFactory);
						if (adapter != null) {
							pivotElement = adapter.getCreated(pivotClass, eObject);
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

	protected org.eclipse.uml2.uml.Property getOtherEnd(org.eclipse.uml2.uml.@NonNull Property umlProperty) {
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

	public org.eclipse.uml2.uml.@Nullable Property getOtherEnd(@NonNull List<org.eclipse.uml2.uml.Property> umlMemberEnds, org.eclipse.uml2.uml.@NonNull Property umlProperty) {
		for (org.eclipse.uml2.uml.Property umlMemberEnd : umlMemberEnds) {
			if (umlMemberEnd != umlProperty) {
				return umlMemberEnd;
			}
		}
		return null;
	}
}
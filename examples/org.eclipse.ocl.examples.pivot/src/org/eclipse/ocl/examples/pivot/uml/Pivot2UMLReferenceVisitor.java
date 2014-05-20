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
package org.eclipse.ocl.examples.pivot.uml;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.uml2.uml.MultiplicityElement;

public class Pivot2UMLReferenceVisitor
	extends AbstractExtendingVisitor<EObject, Pivot2UML>
{
	private static final Logger logger = Logger.getLogger(Pivot2UMLReferenceVisitor.class);

//	protected final Pivot2EcoreTypeRefVisitor typeRefVisitor;
	
	public Pivot2UMLReferenceVisitor(@NonNull Pivot2UML context) {
		super(context);
//		typeRefVisitor = new Pivot2EcoreTypeRefVisitor(context);
	}

	public <T extends org.eclipse.uml2.uml.Element> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	public EObject visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2UML Reference pass");
	}

/*	@Override
	public EObject visitAnnotation(Annotation pivotAnnotation) {
		EAnnotation eAnnotation = context.getCreated(EAnnotation.class, pivotAnnotation);
		eAnnotation.getReferences().clear();
		for (Element pivotReference : pivotAnnotation.getReference()) {
			EObject eReference = context.getCreated(EObject.class, pivotReference);
			eAnnotation.getReferences().add(eReference);
		}
		return eAnnotation;
	} */

	@Override
	public EObject visitClass(@NonNull Class pivotClass) {
		org.eclipse.uml2.uml.Class umlClass = context.getCreated(org.eclipse.uml2.uml.Class.class, pivotClass);
		safeVisitAll(umlClass.getSuperClasses(), pivotClass.getSuperClass());
		return umlClass;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		org.eclipse.uml2.uml.DataType umlDataType = context.getCreated(org.eclipse.uml2.uml.DataType.class, pivotDataType);
		return umlDataType;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		org.eclipse.uml2.uml.Operation umlOperation = context.getCreated(org.eclipse.uml2.uml.Operation.class, pivotOperation);
		safeVisitAll(umlOperation.getRaisedExceptions(), pivotOperation.getRaisedException());
		Type pivotType = pivotOperation.getType();
		if (pivotType == null) {
			return null;				// Occurs for Operation return type
		}
		org.eclipse.uml2.uml.Type umlType = context.getCreated(org.eclipse.uml2.uml.Type.class, pivotType);
		umlOperation.setType(umlType);
		return null;
	}

	@Override
	public EObject visitPackage(@NonNull Package pivotPackage) {
//		org.eclipse.uml2.uml.Package umlPackage = context.getCreated(org.eclipse.uml2.uml.Package.class, pivotPackage);
/*		boolean needsDelegates = false;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = eClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				needsDelegates = true;
				break;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = eFeature.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = eOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
			}
		}
		if (needsDelegates) {
		    EAnnotation packageAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
		    if (packageAnnotation == null) {
		    	packageAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		    	packageAnnotation.setSource(EcorePackage.eNS_URI);
		    	ePackage.getEAnnotations().add(packageAnnotation);
		    }
		    EMap<String, String> details = packageAnnotation.getDetails();
			details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		    details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		    details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		} */
		return null;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		org.eclipse.uml2.uml.Property umlProperty = context.getCreated(org.eclipse.uml2.uml.Property.class, pivotProperty);
		Property pivotOpposite = pivotProperty.getOpposite();
		if (pivotOpposite != null) {
			org.eclipse.uml2.uml.Property umlOpposite = context.getCreated(org.eclipse.uml2.uml.Property.class, pivotOpposite);
			if (umlOpposite != null) {
				umlProperty.setOpposite(umlOpposite);
			}
		}
//		for (Property pivotKey : pivotProperty.getKeys()) {
//			EAttribute eAttribute = context.getCreated(EAttribute.class, pivotKey);
//			if (eAttribute != null) {
//				eReference.getEKeys().add(eAttribute);
//			}
//		}
		return super.visitProperty(pivotProperty);
	}

	@Override
	public EObject visitTypeTemplateParameter(@NonNull TypeTemplateParameter pivotTypeTemplateParameter) {
//		org.eclipse.uml2.uml.ClassifierTemplateParameter umlTypeParameter = context.getCreated(org.eclipse.uml2.uml.ClassifierTemplateParameter.class, pivotTypeTemplateParameter);
//		for (Type constrainingType : pivotTypeTemplateParameter.getConstrainingType()) {
//			EGenericType eGenericType = typeRefVisitor.resolveEGenericType(constrainingType);
//			umlTypeParameter.getEBounds().add(eGenericType);
//		}
		return null;
	}

	@Override
	public EObject visitTypedElement(@NonNull TypedElement pivotTypedElement) {
		org.eclipse.uml2.uml.TypedElement umlTypedElement = context.getCreated(org.eclipse.uml2.uml.TypedElement.class, pivotTypedElement);
		Type pivotType = pivotTypedElement.getType();
		if (pivotType == null) {
			return null;				// Occurs for Operation return type
		}
		org.eclipse.uml2.uml.Type umlType = context.getCreated(org.eclipse.uml2.uml.Type.class, pivotType);
		umlTypedElement.setType(umlType);
		return null;
	}

	@Override
	public EObject visitTypedMultiplicityElement(@NonNull TypedMultiplicityElement pivotTypedElement) {
		org.eclipse.uml2.uml.TypedElement umlTypedElement = context.getCreated(org.eclipse.uml2.uml.TypedElement.class, pivotTypedElement);
		Type pivotType = pivotTypedElement.getType();
		if ((pivotType == null) || (pivotType instanceof VoidType)) {				// Occurs for Operation return type
			if (umlTypedElement instanceof MultiplicityElement) {
				MultiplicityElement umlMultiplicityElement = (MultiplicityElement)umlTypedElement;
				umlMultiplicityElement.setLower(1);
				umlMultiplicityElement.setUpper(1);
				umlMultiplicityElement.setIsOrdered(true);
				umlMultiplicityElement.setIsUnique(true);
			}
			umlTypedElement.setType(null);
			return null;
		}
		else if (pivotType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)pivotType;
			Type elementType = collectionType.getElementType();
			org.eclipse.uml2.uml.Type umlElementType = elementType != null ? context.getCreated(org.eclipse.uml2.uml.Type.class, elementType) : null;
			umlTypedElement.setType(umlElementType);
			if (umlTypedElement instanceof MultiplicityElement) {
				MultiplicityElement umlMultiplicityElement = (MultiplicityElement)umlTypedElement;
				umlMultiplicityElement.setIsOrdered(collectionType.isOrdered());
				umlMultiplicityElement.setIsUnique(collectionType.isUnique());
				IntegerValue lower = collectionType.getLowerValue();
				IntegerValue upper = collectionType.getUpperValue();
				try {
					umlMultiplicityElement.setLower(lower.intValue());
				} catch (InvalidValueException e) {
					logger.error("Out of range lower bound", e);
				}
				try {
					umlMultiplicityElement.setUpper(upper.isUnlimited() ? -1 : upper.intValue());
				} catch (InvalidValueException e) {
					logger.error("Out of range upper bound", e);
				}
			}
			return null;
		}
		else {
			if (umlTypedElement instanceof MultiplicityElement) {
				MultiplicityElement umlMultiplicityElement = (MultiplicityElement)umlTypedElement;
				if (pivotTypedElement.isRequired()) {
					umlMultiplicityElement.setLower(1);
					umlMultiplicityElement.setUpper(1);
				}
				else {
					umlMultiplicityElement.setLower(0);
					umlMultiplicityElement.setUpper(1);
				}
				umlMultiplicityElement.setIsUnique(true);
				umlMultiplicityElement.setIsOrdered(false);		// UML default
			}
			org.eclipse.uml2.uml.Type umlType = context.getCreated(org.eclipse.uml2.uml.Type.class, pivotType);
			umlTypedElement.setType(umlType);
			return null;
		}
	}
	
/*	@Override
	public Object caseEAnnotation(EAnnotation eAnnotation) {
		AnnotationCS csAnnotation = (AnnotationCS) deferMap.get(eAnnotation);
		for (ModelElementCSRef csReference : csAnnotation.getReferences()) {
			EObject eObject = createMap.get(csReference.getRef());
			if (eObject != null) {
				eAnnotation.getReferences().add(eObject);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEGenericType(EGenericType eGenericType) {
		TypedTypeRefCS csTypeRef = (TypedTypeRefCS) deferMap.get(eGenericType);
		TypeCS typeRef = csTypeRef.getType();
		if (typeRef != null) {
			EModelElement eType = (EModelElement) createMap.get(typeRef);
			if (eType == null) {
				eGenericType.setEClassifier((EClassifier) ((ModelElementCS)typeRef).getOriginalObject());
			}
			else if (eType instanceof EClassifier) {
				eGenericType.setEClassifier((EClassifier) eType);
			}
			else if (eType instanceof ETypeParameter) {
				eGenericType.setETypeParameter((ETypeParameter) eType);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEReference(EReference eReference) {
		OCLinEcoreReferenceCS csReference = (OCLinEcoreReferenceCS) deferMap.get(eReference);
		ReferenceCSRef csOpposite = csReference.getOpposite();
		if (csOpposite != null) {
			EReference eOpposite = (EReference) createMap.get(csOpposite.getRef());
			if (eOpposite != null) {
				eReference.setEOpposite(eOpposite);
			}
		}
		for (AttributeCSRef csKey : csReference.getKeys()) {
			EAttribute eAttribute = (EAttribute) createMap.get(csKey.getRef());
			if (eAttribute != null) {
				eReference.getEKeys().add(eAttribute);
			}
		}
		return null;
	} */

//	@Override
//	public Object caseETypeParameter(ETypeParameter eTypeParameter) {
//		TypeParameterCS csTypeParameter = (TypeParameterCS) deferMap.get(eTypeParameter);
/*			ClassifierRef classifierRef = csTypedElement.getType();
		if (classifierRef != null) {
			EClassifier eClassifier = resolveClassifierRef(classifierRef);
			if (eClassifier != null) {
				eTypedElement.setEType(eClassifier);
			}
		} */
//		return null;
//	}
	
}
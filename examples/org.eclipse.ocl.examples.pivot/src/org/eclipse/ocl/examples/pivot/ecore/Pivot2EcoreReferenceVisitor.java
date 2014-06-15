/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;

public class Pivot2EcoreReferenceVisitor extends AbstractExtendingVisitor<EObject, Pivot2Ecore>
{
	protected static class OptionalType
	{
		public final @Nullable Type type;
		public final boolean isRequired;
		
		public OptionalType(@Nullable Type type, boolean isRequired) {
			this.type = type;
			this.isRequired = isRequired;
		}
	}
	
	private static final Logger logger = Logger.getLogger(Pivot2EcoreReferenceVisitor.class);

	protected final @NonNull Pivot2EcoreTypeRefVisitor typeRefVisitor;
	
	public Pivot2EcoreReferenceVisitor(@NonNull Pivot2Ecore context) {
		super(context);
		typeRefVisitor = new Pivot2EcoreTypeRefVisitor(context);
	}

	protected @Nullable OptionalType addPropertyRedefinitionEAnnotations(@NonNull EStructuralFeature eStructuralFeature, @NonNull Property pivotProperty) {
		@Nullable OptionalType optionalType = null;
		Type redefiningType = pivotProperty.getType();
		EAnnotation eRedefinesAnnotation = null;
		String changedEType = null;
		String changedLower = null;
		String changedUpper = null;
		for (@SuppressWarnings("null")@NonNull Property redefinedProperty : pivotProperty.getRedefinedProperty()) {
			EStructuralFeature eRedefined = context.getCreated(EStructuralFeature.class, redefinedProperty);
			if (eRedefined != null) {
				if (eRedefinesAnnotation == null) {
					eRedefinesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eRedefinesAnnotation.setSource(PivotConstants.REDEFINES_ANNOTATION_SOURCE);
					eStructuralFeature.getEAnnotations().add(eRedefinesAnnotation);
				}
				eRedefinesAnnotation.getReferences().add(eRedefined);
				//
				IntegerValue redefinedLower = redefinedProperty.isRequired() ? ValuesUtil.ONE_VALUE :  ValuesUtil.ZERO_VALUE;
				IntegerValue redefinedUpper = ValuesUtil.ONE_VALUE;
				Type redefinedType = redefinedProperty.getType();
				Type redefinedElementType = redefinedType;
				if (redefinedElementType instanceof CollectionType) {
					CollectionType redefinedCollectionType = (CollectionType)redefinedElementType;
					redefinedLower = redefinedCollectionType.getLowerValue();
					redefinedUpper = redefinedCollectionType.getUpperValue();
					redefinedElementType = redefinedCollectionType.getElementType();
				}
				//
				IntegerValue redefiningLower = pivotProperty.isRequired() ? ValuesUtil.ONE_VALUE :  ValuesUtil.ZERO_VALUE;
				IntegerValue redefiningUpper = ValuesUtil.ONE_VALUE;
				Type redefiningElementType = redefiningType;
				if (redefiningElementType instanceof CollectionType) {
					CollectionType redefiningCollectionType = (CollectionType)redefiningElementType;
					redefiningLower = redefiningCollectionType.getLowerValue();
					redefiningUpper = redefiningCollectionType.getUpperValue();
					redefiningElementType = redefiningCollectionType.getElementType();
				}
				//
				if (!(redefinedType instanceof CollectionType) && (redefinedElementType != redefiningElementType)) {
					changedEType = redefiningElementType.toString();
				}
				if (!redefinedLower.equals(redefiningLower)) {
					changedLower = redefiningLower.toString();
				}
				if (!redefinedUpper.equals(redefiningUpper)) {
					changedUpper = redefiningUpper.equals(ValuesUtil.UNLIMITED_VALUE) ? "-1" : redefiningUpper.toString();
				}
				//
				if (!(redefiningType instanceof CollectionType)) {
					if (!(redefinedType instanceof CollectionType)) {
						optionalType = new OptionalType(redefinedElementType, redefinedProperty.isRequired());
					}
					else if (redefiningType != null) {
						CollectionType redefinedCollectionType = (CollectionType)redefinedType;
						optionalType = new OptionalType(context.getMetaModelManager().getCollectionType(redefinedCollectionType.isOrdered(), redefinedCollectionType.isUnique(),
							redefiningType, redefinedCollectionType.getLowerValue(), redefinedCollectionType.getUpperValue()), redefinedProperty.isRequired());
					}
				}
			}
		}
		if ((changedEType != null) || (changedLower != null) || (changedUpper != null)) {
			EAnnotation eCorrection = EcoreFactory.eINSTANCE.createEAnnotation();
			eCorrection.setSource(eStructuralFeature.getName());
			EMap<String, String> eDetails = eCorrection.getDetails();
			if (changedEType != null) {
				eDetails.put("eType", changedEType);
			}
			if (changedLower != null) {
				eDetails.put("lowerBound", changedLower);
			}
			if (changedUpper != null) {
				eDetails.put("upperBound", changedUpper);
			}
			EModelElement eContainer = (EModelElement) eStructuralFeature.eContainer();
			eContainer.getEAnnotations().add(eCorrection);
		}
		return optionalType;
	}

	protected boolean addPropertyRenameEAnnotations(@NonNull EStructuralFeature eStructuralFeature, @NonNull Property pivotProperty) {
		for (@SuppressWarnings("null")@NonNull Property redefinedProperty1 :  pivotProperty.getRedefinedProperty()) {
			if (!DomainUtil.safeEquals(pivotProperty.getName(), redefinedProperty1.getName())) {
				EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(PivotConstants.REDEFINES_ANNOTATION_SOURCE);
				for (@SuppressWarnings("null")@NonNull Property redefinedProperty2 :  pivotProperty.getRedefinedProperty()) {
					EStructuralFeature eRedefined = context.getCreated(EStructuralFeature.class, redefinedProperty2);
					if (eRedefined != null) {
						eAnnotation.getReferences().add(eRedefined);
					}
				}
				eStructuralFeature.getEAnnotations().add(eAnnotation);
				return true;
			}
		}
		return false;
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	public <T extends EClassifier> void safeVisitAll(Class<?> javaClass, List<EGenericType> eGenericTypes, List<T> eTypes, List<? extends Type> asTypes) {
		if (asTypes.size() > 0) {
			List<EObject> eClasses = new ArrayList<EObject>(asTypes.size());
			typeRefVisitor.safeVisitAll(eClasses, asTypes);
			eTypes.clear();
			eGenericTypes.clear();
			for (EObject superEClass : eClasses) {
				if (superEClass instanceof EGenericType) {
					eGenericTypes.add((EGenericType)superEClass);
				}
				else if (javaClass.isAssignableFrom(superEClass.getClass())){
					@SuppressWarnings("unchecked") T castSuperEClass = (T)superEClass;
					eTypes.add(castSuperEClass);
				}
			}
		}
		else {
			eGenericTypes.clear();
		}
	}

	protected void setEType(@NonNull ETypedElement eTypedElement, @NonNull Type pivotType) {
		EObject eObject = typeRefVisitor.safeVisit(pivotType);
		if (eObject instanceof EGenericType) {
			eTypedElement.setEGenericType((EGenericType)eObject);
		}
		else if (eObject instanceof EClassifier) {
			eTypedElement.setEType((EClassifier)eObject);
		}
		else if (eObject instanceof ETypeParameter) {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setETypeParameter((ETypeParameter)eObject);
			eTypedElement.setEGenericType(eGenericType);
		}
		else {
			@SuppressWarnings("unused")
			EObject eObject2 = typeRefVisitor.safeVisit(pivotType);
//			throw new IllegalArgumentException("Unsupported pivot type '" + pivotType + "' in Pivot2Ecore Reference pass");
		}
	}

	protected void setETypeAndMultiplicity(@NonNull ETypedElement eTypedElement, @Nullable Type pivotType, boolean isRequired) {
		if ((pivotType == null) || (pivotType instanceof VoidType)) {				// Occurs for Operation return type
			eTypedElement.setLowerBound(0);
			eTypedElement.setUpperBound(1);
			eTypedElement.setOrdered(true);
			eTypedElement.setUnique(true);
		}
		else if ((pivotType instanceof CollectionType) && (pivotType.getUnspecializedElement() != context.getMetaModelManager().getCollectionType())) {		// Collection(T) cannot be distinguished from concrete Ecore collections
			CollectionType collectionType = (CollectionType)pivotType;
			Type elementType = collectionType.getElementType();
			EObject eObject = typeRefVisitor.safeVisit(elementType);
			if (eObject instanceof EGenericType) {
				eTypedElement.setEGenericType((EGenericType)eObject);
			}
			else {
				eTypedElement.setEType((EClassifier)eObject);
			}
			eTypedElement.setOrdered(collectionType.isOrdered());
			eTypedElement.setUnique(collectionType.isUnique());
			IntegerValue lower = collectionType.getLowerValue();
			IntegerValue upper = collectionType.getUpperValue();
			try {
				eTypedElement.setLowerBound(lower.intValue());
			} catch (InvalidValueException e) {
				logger.error("Illegal lower bound", e);
			}
			try {
				eTypedElement.setUpperBound(upper.isUnlimited() ? -1 : upper.intValue());
			} catch (InvalidValueException e) {
				logger.error("Illegal upper bound", e);
			}
		}
		else {
			if (isRequired) {
				eTypedElement.setLowerBound(1);
				eTypedElement.setUpperBound(1);
			}
			else {
				eTypedElement.setLowerBound(0);
				eTypedElement.setUpperBound(1);
			}
			eTypedElement.setUnique(true);
			eTypedElement.setOrdered(true);		// Ecore default
			setEType(eTypedElement, pivotType);
		}
	}

	public EObject visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2Ecore Reference pass");
	}

	@Override
	public EObject visitAnnotation(@NonNull Annotation pivotAnnotation) {
		EAnnotation eAnnotation = context.getCreated(EAnnotation.class, pivotAnnotation);
		eAnnotation.getReferences().clear();
		for (Element pivotReference : pivotAnnotation.getReference()) {
			if (pivotReference != null) {
				EObject target = context.getCreated(EObject.class, pivotReference);
				if ((target == null) && (pivotReference instanceof PivotObjectImpl)) {
					target = ((PivotObjectImpl)pivotReference).getTarget();
				}
				if (target != null) {
					eAnnotation.getReferences().add(target);
				}
			}
		}
		return eAnnotation;
	}

	@Override
	public EObject visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class pivotClass) {
		EClass eClass = context.getCreated(EClass.class, pivotClass);
		safeVisitAll(EClass.class, eClass.getEGenericSuperTypes(), eClass.getESuperTypes(), pivotClass.getSuperClass());
		return eClass;
	}

	@Override
	public EObject visitConstraint(@NonNull Constraint pivotConstraint) {
		EOperation eOperation = context.getCreated(EOperation.class, pivotConstraint);
		EAnnotation eRedefinesAnnotation = null;
		for (@SuppressWarnings("null")@NonNull Constraint redefinedConstraint : pivotConstraint.getRedefinedConstraint()) {
			EOperation eRedefined = context.getCreated(EOperation.class, redefinedConstraint);
			if (eRedefined != null) {
				if (eRedefinesAnnotation == null) {
					eRedefinesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eRedefinesAnnotation.setSource(PivotConstants.REDEFINES_ANNOTATION_SOURCE);
				}
				eRedefinesAnnotation.getReferences().add(eRedefined);
			}
		}
		if (eRedefinesAnnotation != null) {
			eOperation.getEAnnotations().add(eRedefinesAnnotation);
		}
		return eOperation;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		EDataType eDataType = context.getCreated(EDataType.class, pivotDataType);
		return eDataType;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		EOperation eOperation = context.getCreated(EOperation.class, pivotOperation);
		safeVisitAll(EClassifier.class, eOperation.getEGenericExceptions(), eOperation.getEExceptions(), pivotOperation.getRaisedException());
		EAnnotation eRedefinesAnnotation = null;
		for (@SuppressWarnings("null")@NonNull Operation redefinedOperation : pivotOperation.getRedefinedOperation()) {
			EOperation eRedefined = context.getCreated(EOperation.class, redefinedOperation);
			if (eRedefined != null) {
				if (eRedefinesAnnotation == null) {
					eRedefinesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eRedefinesAnnotation.setSource(PivotConstants.REDEFINES_ANNOTATION_SOURCE);
				}
				eRedefinesAnnotation.getReferences().add(eRedefined);
			}
		}
		if (eRedefinesAnnotation != null) {
			eOperation.getEAnnotations().add(eRedefinesAnnotation);
		}
		return super.visitOperation(pivotOperation);
	}

	@Override
	public EObject visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		EPackage ePackage = context.getCreated(EPackage.class, pivotPackage);
		if (ePackage == null) {
			return null;
		}
		boolean needsDelegates = DelegateInstaller.needsDelegates(ePackage);
		if (needsDelegates) {
			context.getDelegateInstaller().installDelegates(ePackage);
		}
		if (context.isPivot(pivotPackage)) {
			DomainUtil.getMetamodelAnnotation(ePackage);
		}
		return null;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.isImplicit()) {
			return null;
		}
		EStructuralFeature eStructuralFeature = context.getCreated(EStructuralFeature.class, pivotProperty);
		if (eStructuralFeature == null) {
			return null;
		}
		if (eStructuralFeature instanceof EReference) {
			EReference eReference = (EReference) eStructuralFeature;
			Property pivotOpposite = pivotProperty.getOpposite();
			if (pivotOpposite != null) {
				if (pivotOpposite.isImplicit()) {
					// FIXME Use EAnnotations for non-navigable opposites as identified by an Association
				}
				else {
					EReference eOpposite = context.getCreated(EReference.class, pivotOpposite);
					if (eOpposite != null) {
						eReference.setEOpposite(eOpposite);
					}
				}
			}
			for (Property pivotKey : pivotProperty.getKeys()) {
				if (pivotKey != null) {
					EAttribute eAttribute = context.getCreated(EAttribute.class, pivotKey);
					if (eAttribute != null) {
						eReference.getEKeys().add(eAttribute);
					}
				}
			}
		}
		Type pivotType = pivotProperty.getType();
		boolean pivotIsRequired = pivotProperty.isRequired();
		if (!addPropertyRenameEAnnotations(eStructuralFeature, pivotProperty)) {
			OptionalType optionalType = addPropertyRedefinitionEAnnotations(eStructuralFeature, pivotProperty);
			if (optionalType != null) {
				pivotType = optionalType.type;
				pivotIsRequired = optionalType.isRequired;
			}
		}
		setETypeAndMultiplicity(eStructuralFeature, pivotType, pivotIsRequired);
		return null;
	}

	@Override
	public EObject visitTypeTemplateParameter(@NonNull TypeTemplateParameter pivotTypeTemplateParameter) {
		ETypeParameter eTypeParameter = context.getCreated(ETypeParameter.class, pivotTypeTemplateParameter);
		for (Type constrainingType : pivotTypeTemplateParameter.getConstrainingType()) {
			EGenericType eGenericType = typeRefVisitor.resolveEGenericType(constrainingType);
			eTypeParameter.getEBounds().add(eGenericType);
		}
		return null;
	}

	@Override
	public EObject visitTypedElement(@NonNull TypedElement pivotTypedElement) {
		ETypedElement eTypedElement = context.getCreated(ETypedElement.class, pivotTypedElement);
		if (eTypedElement != null) {
			Type pivotType = pivotTypedElement.getType();
			if (pivotType == null) {
				return null;				// Occurs for Operation return type
			}
			setEType(eTypedElement, pivotType);
		}
		return null;
	}

	@Override
	public EObject visitTypedMultiplicityElement(@NonNull TypedMultiplicityElement pivotTypedElement) {
		ETypedElement eTypedElement = context.getCreated(ETypedElement.class, pivotTypedElement);
		if (eTypedElement != null) {
			Type pivotType = pivotTypedElement.getType();
			setETypeAndMultiplicity(eTypedElement, pivotType, pivotTypedElement.isRequired());
		}
		return null;
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
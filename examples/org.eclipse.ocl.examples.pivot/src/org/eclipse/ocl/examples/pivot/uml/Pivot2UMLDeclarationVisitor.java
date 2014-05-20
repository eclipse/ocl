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
package org.eclipse.ocl.examples.pivot.uml;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.common.utils.StringUtils;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.UMLFactory;

public class Pivot2UMLDeclarationVisitor
	extends AbstractExtendingVisitor<EModelElement, Pivot2UML>
{
	public Pivot2UMLDeclarationVisitor(@NonNull Pivot2UML context) {
		super(context);
	}

	protected void copyClassifier(@NonNull org.eclipse.uml2.uml.Classifier umlClassifier, @NonNull Type pivotType) {
		copyNamedElement(umlClassifier, pivotType);
		TemplateSignature pivotTemplateSignature = pivotType.getOwnedTemplateSignature();
		if (pivotTemplateSignature != null) {
			umlClassifier.setOwnedTemplateSignature((org.eclipse.uml2.uml.TemplateSignature)safeVisit(pivotTemplateSignature));
		}
		safeVisitAll(umlClassifier.getEAnnotations(), pivotType.getOwnedAnnotation());
//		if (pivotType.eIsSet(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME)) {
//			umlClassifier.setInstanceClassName(pivotType.getInstanceClassName());
//		}
//		else {
//			umlClassifier.eUnset(UMLPackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
//		}
//		visitAll(eClassifier.getETypeParameters(), pivotType.getTypeParameters());
		StringBuilder s = null;
		for (Constraint pivotConstraint : pivotType.getOwnedInvariant()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
			if (s == null) {
				s = new StringBuilder();
			}
			else {
				s.append(" ");
			}
			s.append(pivotConstraint.getName());
		}
/*		EAnnotation eAnnotation = umlClassifier.getEAnnotation(UMLPackage.eNS_URI);
		if (s != null) {
			if (eAnnotation == null) {
				eAnnotation = UMLFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(UMLPackage.eNS_URI);
				umlClassifier.getEAnnotations().add(0, eAnnotation);
			}
			eAnnotation.getDetails().put("constraints", s.toString());
		}
		else {
			umlClassifier.getEAnnotations().remove(eAnnotation);
		} */
	}

	protected void copyDataTypeOrEnum(@NonNull org.eclipse.uml2.uml.DataType umlDataType, @NonNull DataType pivotDataType) {
		copyClassifier(umlDataType, pivotDataType);
//		umlDataType.setSerializable(pivotDataType.isSerializable());
	}

	protected void copyDetails(@NonNull EAnnotation umlAnnotation, @NonNull Annotation pivotAnnotation) {
		copyEModelElement(umlAnnotation, pivotAnnotation);
		safeVisitAll(umlAnnotation.getEAnnotations(), pivotAnnotation.getOwnedAnnotation());
		for (Detail pivotDetail : pivotAnnotation.getOwnedDetail()) {
			String name = pivotDetail.getName();
			String value = StringUtils.splice(pivotDetail.getValue(), "");
			umlAnnotation.getDetails().put(name, value);
		}
	}

	protected void copyEModelElement(@NonNull EModelElement umlElement, @NonNull Element pivotModelElement) {
		context.putCreated(pivotModelElement, umlElement);
	}

	protected void copyModelElement(@NonNull org.eclipse.uml2.uml.Element umlElement, @NonNull Element pivotModelElement) {
		copyEModelElement(umlElement, pivotModelElement);
		safeVisitAll(umlElement.getOwnedComments(), pivotModelElement.getOwnedComment());
	}

	protected void copyNamedElement(@NonNull org.eclipse.uml2.uml.NamedElement umlNamedElement, @NonNull NamedElement pivotNamedElement) {
		copyModelElement(umlNamedElement, pivotNamedElement);
		umlNamedElement.setName(pivotNamedElement.getName());
		safeVisitAll(umlNamedElement.getOwnedComments(), pivotNamedElement.getOwnedComment());
	}

	protected void copyTypedElement(@NonNull org.eclipse.uml2.uml.TypedElement umlTypedElement, @NonNull TypedMultiplicityElement pivotTypedElement) {
		copyNamedElement(umlTypedElement, pivotTypedElement);
		context.defer(pivotTypedElement);		// Defer type/multiplicity setting
	}

/*	protected void zzcopyMultiplicityElement(@NonNull org.eclipse.uml2.uml.MultiplicityElement umlMultiplicityElement, @NonNull TypedMultiplicityElement pivotTypedElement) {
		Integer lower = pivotTypedElement.getLower().intValue();
		if (lower.equals(UMLPackage.Literals.MULTIPLICITY_ELEMENT__LOWER.getDefaultValue())) {
//			umlMultiplicityElement.eUnset(UMLPackage.Literals.MULTIPLICITY_ELEMENT__LOWER);
		}
		else {
			umlMultiplicityElement.setLower(lower);
		}
		Integer upper = pivotTypedElement.getUpper().intValue();
		if (upper.equals(UMLPackage.Literals.MULTIPLICITY_ELEMENT__UPPER.getDefaultValue())) {
//			umlMultiplicityElement.eUnset(UMLPackage.Literals.MULTIPLICITY_ELEMENT__UPPER);
		}
		else {
			umlMultiplicityElement.setUpper(upper);
		}
//		umlMultiplicityElement.setIsUnique(pivotTypedElement.isUnique());
//		umlMultiplicityElement.setIsOrdered(pivotTypedElement.isOrdered());
	} */

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

	public org.eclipse.uml2.uml.Element visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2UML Declaration pass");
	}

	@Override
	public EAnnotation visitAnnotation(@NonNull Annotation pivotAnnotation) {
		@SuppressWarnings("null")
		@NonNull EAnnotation umlAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		copyDetails(umlAnnotation, pivotAnnotation);
		umlAnnotation.setSource(pivotAnnotation.getName());
		safeVisitAll(umlAnnotation.getContents(), pivotAnnotation.getOwnedContent());
		if (!pivotAnnotation.getReference().isEmpty()) {
			context.defer(pivotAnnotation);
		}
		return umlAnnotation;
	}

	@Override
	public org.eclipse.uml2.uml.Classifier visitClass(@NonNull org.eclipse.ocl.examples.pivot.Class pivotClass) {
		if (pivotClass.getTemplateBinding().size() > 0) {
			return null;
		}
		Classifier umlClassifier;
		if (pivotClass.isInterface()) {
			Interface umlInterface = UMLFactory.eINSTANCE.createInterface();
			safeVisitAll(umlInterface.getOwnedOperations(), pivotClass.getOwnedOperation());
			safeVisitAll(umlInterface.getOwnedAttributes(), pivotClass.getOwnedAttribute());
			umlClassifier = umlInterface;
		}
		else {
			org.eclipse.uml2.uml.Class umlClass = UMLFactory.eINSTANCE.createClass();
			safeVisitAll(umlClass.getOwnedOperations(), pivotClass.getOwnedOperation());
			safeVisitAll(umlClass.getOwnedAttributes(), pivotClass.getOwnedAttribute());
			umlClassifier = umlClass;
		}
		copyClassifier(umlClassifier, pivotClass);
		context.defer(pivotClass);		// Defer superclass resolution
		umlClassifier.setIsAbstract(pivotClass.isAbstract());
		return umlClassifier;
	}

 	@Override
	public EModelElement visitComment(@NonNull Comment pivotComment) {
		org.eclipse.uml2.uml.Comment umlComment = UMLFactory.eINSTANCE.createComment();
		umlComment.setBody(pivotComment.getBody());
		return umlComment;
	}

	@Override
	public org.eclipse.uml2.uml.Constraint visitConstraint(@NonNull Constraint pivotConstraint) {
		OpaqueExpression specification = pivotConstraint.getSpecification();
		if (specification == null) {
			return null;
		}
		String exprString = PivotUtil.getBody(specification);
		if (exprString == null) {
			return null;
		}
//		EModelElement eModelElement = context.getCreated(EModelElement.class, (Element)pivotConstraint.eContainer());
//		EAnnotation oclAnnotation = eModelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
//		if (oclAnnotation == null) {
//			oclAnnotation = UMLFactory.eINSTANCE.createEAnnotation();
//			oclAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
//			eModelElement.getEAnnotations().add(oclAnnotation);
//		}
//		String stereotype = pivotConstraint.getStereotype();
//		String name = pivotConstraint.getName();
/*		if (UMLReflection.INVARIANT.equals(stereotype)) {
			oclAnnotation.getDetails().put(name, exprString);
		}
		else if (UMLReflection.DERIVATION.equals(stereotype)) {
			oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		}
		else if (UMLReflection.INITIAL.equals(stereotype)) {
			oclAnnotation.getDetails().put(SettingBehavior.INITIAL_CONSTRAINT_KEY, exprString);
		}
		else if (UMLReflection.BODY.equals(stereotype)) {
			String key = name != null ? "body_" + name : InvocationBehavior.BODY_CONSTRAINT_KEY;
			oclAnnotation.getDetails().put(key, exprString);
		}
		else if ("UMLReflection.PRECONDITION.equals(stereotype)) {
			oclAnnotation.getDetails().put("pre_" + name, exprString);
		}
		else if (UMLReflection.POSTCONDITION.equals(stereotype)) {
			oclAnnotation.getDetails().put("post_" + name, exprString);
		}
		else {
//			error("Unsupported " + pivotConstraint);
		} */
		return null;
	}

	@Override
	public org.eclipse.uml2.uml.DataType visitDataType(@NonNull DataType pivotDataType) {
		if (pivotDataType.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.DataType umlDataType = UMLFactory.eINSTANCE.createDataType();
		copyDataTypeOrEnum(umlDataType, pivotDataType);
		return umlDataType;
	}

	@Override
	public org.eclipse.uml2.uml.Enumeration visitEnumeration(@NonNull Enumeration pivotEnumeration) {
		if (pivotEnumeration.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.Enumeration umlEnumeration = UMLFactory.eINSTANCE.createEnumeration();
		copyDataTypeOrEnum(umlEnumeration, pivotEnumeration);
		safeVisitAll(umlEnumeration.getOwnedLiterals(), pivotEnumeration.getOwnedLiteral());
		return umlEnumeration;
	}

	@Override
	public org.eclipse.uml2.uml.EnumerationLiteral visitEnumerationLiteral(@NonNull EnumerationLiteral pivotEnumLiteral) {
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral = UMLFactory.eINSTANCE.createEnumerationLiteral();
		copyNamedElement(umlEnumLiteral, pivotEnumLiteral);
//		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
//			umlEnumLiteral.setValue(pivotEnumLiteral.getValue().intValue());
//		}
//		else {
//			umlEnumLiteral.eUnset(UMLPackage.Literals.EENUM_LITERAL__VALUE);
//		}
		return umlEnumLiteral;
	}

	@Override
	public org.eclipse.uml2.uml.Operation visitOperation(@NonNull Operation pivotOperation) {
		if (pivotOperation.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.Operation umlOperation = UMLFactory.eINSTANCE.createOperation();
		copyNamedElement(umlOperation, pivotOperation);
//		safeVisitAll(umlOperation.getEAnnotations(), pivotOperation.getOwnedAnnotation());
		context.defer(pivotOperation);		// Defer type setting
		TemplateSignature pivotTemplateSignature = pivotOperation.getOwnedTemplateSignature();
		umlOperation.setOwnedTemplateSignature((org.eclipse.uml2.uml.TemplateSignature)safeVisit(pivotTemplateSignature));
//		copyTemplateSignature(pivotOperation.getETypeParameters(), pivotOperation);
		safeVisitAll(umlOperation.getOwnedParameters(), pivotOperation.getOwnedParameter());
		safeVisitAll(umlOperation.getRaisedExceptions(), pivotOperation.getRaisedException());
		for (Constraint pivotConstraint : pivotOperation.getOwnedRule()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return umlOperation;
	}

	@Override
	public org.eclipse.uml2.uml.Package visitPackage(@NonNull Package pivotPackage) {
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.Package umlPackage = UMLFactory.eINSTANCE.createPackage();
		copyNamedElement(umlPackage, pivotPackage);
//		safeVisitAll(ePackage.getEAnnotations(), pivotPackage.getOwnedAnnotation());
		context.defer(pivotPackage);		// Defer delegate annotation analysis
//		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_PREFIX)) {
//			umlPackage.setNsPrefix(pivotPackage.getNsPrefix());
//		}
//		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_URI)) {
//			umlPackage.setNsURI(pivotPackage.getNsURI());
//		}
		safeVisitAll(umlPackage.getNestedPackages(), pivotPackage.getNestedPackage());
		safeVisitAll(umlPackage.getOwnedTypes(), pivotPackage.getOwnedType());
		return umlPackage;
	}

	@Override
	public org.eclipse.uml2.uml.Parameter visitParameter(@NonNull Parameter pivotParameter) {
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.Parameter umlParameter = UMLFactory.eINSTANCE.createParameter();
		copyTypedElement(umlParameter, pivotParameter);
		return umlParameter;
	}

	@Override
	public org.eclipse.uml2.uml.Element visitPrimitiveType(@NonNull PrimitiveType pivotPrimitiveType) {
		if (pivotPrimitiveType.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType = UMLFactory.eINSTANCE.createPrimitiveType();
		copyDataTypeOrEnum(umlPrimitiveType, pivotPrimitiveType);
		return umlPrimitiveType;
	}

	@Override
	public org.eclipse.uml2.uml.Property visitProperty(@NonNull Property pivotProperty) {
//		Type type = pivotProperty.getType();
		@SuppressWarnings("null")
		@NonNull org.eclipse.uml2.uml.Property umlProperty = UMLFactory.eINSTANCE.createProperty();
		copyTypedElement(umlProperty, pivotProperty);
//		umlProperty.setIsID(pivotProperty.isID());
		umlProperty.setIsComposite(pivotProperty.isComposite());
//		umlProperty.setIsResolveProxies(pivotProperty.isResolveProxies());
		umlProperty.setIsReadOnly(pivotProperty.isReadOnly());
		umlProperty.setIsDerived(pivotProperty.isDerived());
//		umlProperty.setIsTransient(pivotProperty.isTransient());
//		umlProperty.setIsUnsettable(pivotProperty.isUnsettable());
//		umlProperty.setIsVolatile(pivotProperty.isVolatile());
		if ((pivotProperty.getOpposite() != null) || !pivotProperty.getKeys().isEmpty()) {
			context.defer(pivotProperty);
		}
//		if (pivotProperty.eIsSet(PivotPackage.Literals.PROPERTY__DEFAULT)) {
//			umlProperty.setDefaultValueLiteral(pivotProperty.getDefault());
//		}
//		else {
//			umlProperty.eUnset(UMLPackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
//		}
//FIXME		for (Constraint pivotConstraint : pivotProperty.getOwnedRule()) {
//			safeVisit(pivotConstraint);		// Results are inserted directly
//		}
		return umlProperty;
	}

	@Override
	public org.eclipse.uml2.uml.TemplateSignature visitTemplateSignature(@NonNull TemplateSignature pivotTemplateSignature) {
		org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature = UMLFactory.eINSTANCE.createRedefinableTemplateSignature();
		safeVisitAll(umlTemplateSignature.getOwnedParameters(), pivotTemplateSignature.getOwnedParameter());
//		safeVisitAll(umlTemplateSignature.getParameters(), pivotTemplateSignature.getParameter());
		return umlTemplateSignature;
	}


	@Override
	public org.eclipse.uml2.uml.ClassifierTemplateParameter visitTypeTemplateParameter(@NonNull TypeTemplateParameter pivotTypeTemplateParameter) {
		org.eclipse.uml2.uml.ClassifierTemplateParameter umlTypeParameter = UMLFactory.eINSTANCE.createClassifierTemplateParameter();
		umlTypeParameter.setOwnedParameteredElement((ParameterableElement) safeVisit(pivotTypeTemplateParameter.getOwnedParameteredElement()));
//		umlTypeParameter.setName(((Type) pivotTypeTemplateParameter.getParameteredElement()).getName());
		context.putCreated(pivotTypeTemplateParameter, umlTypeParameter);
		if (!pivotTypeTemplateParameter.getConstrainingType().isEmpty()) {
			context.defer(pivotTypeTemplateParameter);
		}
		return umlTypeParameter;
	}
}
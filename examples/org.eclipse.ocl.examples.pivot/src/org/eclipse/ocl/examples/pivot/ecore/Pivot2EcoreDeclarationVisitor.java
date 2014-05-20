/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.StringUtils;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.manager.Orphanage;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class Pivot2EcoreDeclarationVisitor
	extends AbstractExtendingVisitor<Object, Pivot2Ecore>
{
	public static final @NonNull DuplicateConstraintsFilter duplicateConstraintsFilter = new DuplicateConstraintsFilter();
	public static final @NonNull DuplicateOperationsFilter duplicateOperationsFilter = new DuplicateOperationsFilter();
	public static final @NonNull DuplicatePropertiesFilter duplicatePropertiesFilter = new DuplicatePropertiesFilter();
	public static final @NonNull NonDuplicateConstraintsFilter nonDuplicateConstraintsFilter = new NonDuplicateConstraintsFilter();
	public static final @NonNull NonDuplicateOperationsFilter nonDuplicateOperationsFilter = new NonDuplicateOperationsFilter();
	public static final @NonNull NonDuplicatePropertiesFilter nonDuplicatePropertiesFilter = new NonDuplicatePropertiesFilter();

	protected static class DuplicateConstraintsFilter implements Predicate<Constraint>
	{
		public boolean apply(@Nullable Constraint aConstraint) {
			if (aConstraint == null) {
				return false;
			}
			if (aConstraint.getRedefinedConstraint().size() == 0) {
				return false;
			}
			return true;
		}
	}

	protected static class DuplicateOperationsFilter implements Predicate<Operation>
	{
		public boolean apply(@Nullable Operation anOperation) {
			if (anOperation == null) {
				return false;
			}
			if (anOperation.getRedefinedOperation().size() == 0) {
				return false;
			}
			if ("containingActivity".equals(anOperation.getName()) && "ActivityNode".equals(anOperation.getOwningType().getName())) {
				return false;		// FIXME Bug 405061 workaround
			}
			return true;
//			return (anOperation != null) && (anOperation.getRedefinedOperation().size() != 0);
		}
	}

	protected static class DuplicatePropertiesFilter implements Predicate<Property>
	{
		public boolean apply(@Nullable Property aProperty) {
			if (aProperty == null) {
				return false;
			}
			if (aProperty.getRedefinedProperty().size() == 0) {
				return false;
			}
			return DomainUtil.safeEquals(aProperty.getName(), aProperty.getRedefinedProperty().get(0).getName());
		}
	}

	protected static class NonDuplicateConstraintsFilter implements Predicate<Constraint>
	{
		public boolean apply(@Nullable Constraint aConstraint) {
			if (aConstraint == null) {
				return false;
			}
			if (aConstraint.getRedefinedConstraint().size() == 0) {
				return true;
			}
			return false;
		}
	}

	protected static class NonDuplicateOperationsFilter implements Predicate<Operation>
	{
		public boolean apply(@Nullable Operation anOperation) {
			if (anOperation == null) {
				return false;
			}
			if (anOperation.getRedefinedOperation().size() == 0) {
				return true;
			}
			if ("containingActivity".equals(anOperation.getName()) && "ActivityNode".equals(anOperation.getOwningType().getName())) {
				return true;		// FIXME Bug 405061 workaround
			}
			return false;
//			return (anOperation != null) && (anOperation.getRedefinedOperation().size() == 0);
		}
	}

	protected static class NonDuplicatePropertiesFilter implements Predicate<Property>
	{
		public boolean apply(@Nullable Property aProperty) {
			if (aProperty == null) {
				return false;
			}
			if (aProperty.getRedefinedProperty().size() == 0) {
				return true;
			}
			return !DomainUtil.safeEquals(aProperty.getName(), aProperty.getRedefinedProperty().get(0).getName());
//			return (aProperty != null) && (aProperty.getRedefinedProperty().size() == 0);
		}
	}

	protected final @NonNull DelegateInstaller delegateInstaller;
	
	public Pivot2EcoreDeclarationVisitor(@NonNull Pivot2Ecore context) {
		super(context);
		this.delegateInstaller = context.getDelegateInstaller();
	}

	protected void copyClassifier(@NonNull EClassifier eClassifier, @NonNull Type pivotType) {
		copyNamedElement(eClassifier, pivotType);
		@SuppressWarnings("null")@NonNull List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		copyTemplateSignature(eTypeParameters, pivotType);
		@SuppressWarnings("null")@NonNull List<EAnnotation> eAnnotations = eClassifier.getEAnnotations();
		safeVisitAll(eAnnotations, pivotType.getOwnedAnnotation());
		if (pivotType.eIsSet(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME)) {
			eClassifier.setInstanceClassName(pivotType.getInstanceClassName());
		}
		else {
			eClassifier.eUnset(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
		}
//		visitAll(eClassifier.getETypeParameters(), pivotType.getTypeParameters());
		delegateInstaller.installDelegates(eClassifier, pivotType);
		for (Constraint pivotInvariant : pivotType.getOwnedInvariant()) {
			if (!pivotInvariant.isCallable()) {
				safeVisit(pivotInvariant);		// Results are inserted directly
			}
		}
	}

	protected @Nullable EAnnotation copyConstraint(@NonNull EModelElement eModelElement, @NonNull Constraint pivotConstraint) {
		EAnnotation eAnnotation = delegateInstaller.createConstraintDelegate(eModelElement, pivotConstraint, context.getEcoreURI());
		if (eAnnotation != null) {
			if (eModelElement instanceof EOperation) {
				Pivot2Ecore.copyAnnotationComments(eAnnotation, pivotConstraint);
			}
			else {
				Pivot2Ecore.copyComments(eAnnotation, pivotConstraint);
			}
		}
		return eAnnotation;
	}

	protected void copyDataTypeOrEnum(@NonNull EDataType eDataType, @NonNull DataType pivotDataType) {
		copyClassifier(eDataType, pivotDataType);
		eDataType.setSerializable(pivotDataType.isSerializable());
	}

	protected void copyDetails(@NonNull EAnnotation eAnnotation, @NonNull Annotation pivotAnnotation) {
		copyModelElement(eAnnotation, pivotAnnotation);
		@SuppressWarnings("null")@NonNull List<EAnnotation> eAnnotations = eAnnotation.getEAnnotations();
		safeVisitAll(eAnnotations, pivotAnnotation.getOwnedAnnotation());
		for (Detail pivotDetail : pivotAnnotation.getOwnedDetail()) {
			String name = pivotDetail.getName();
			String value = StringUtils.splice(pivotDetail.getValue(), "");
			eAnnotation.getDetails().put(name, value);
		}
	}

	protected void copyModelElement(@NonNull EModelElement eModelElement, @NonNull Element pivotModelElement) {
		context.putCreated(pivotModelElement, eModelElement);
		Pivot2Ecore.copyComments(eModelElement, pivotModelElement);
	}

	protected void copyNamedElement(@NonNull ENamedElement eNamedElement, @NonNull NamedElement pivotNamedElement) {
		copyModelElement(eNamedElement, pivotNamedElement);
		String name = pivotNamedElement.getName();
		if ("containingActivity".equals(name)) {		// FIXME Bug 405061 workaround
			EObject eContainer = pivotNamedElement.eContainer();
			if ((eContainer instanceof Type) && "ActivityNode".equals(((Type)eContainer).getName())) {
				name = "ActivityNode_" + name;
			}
		}
		else if ("inActivity".equals(name)) {		// FIXME Bug 420330 workaround
			EObject eContainer = pivotNamedElement.eContainer();
			if ((eContainer instanceof Type) && "StructuredActivityNode".equals(((Type)eContainer).getName())) {
				name = "activity";
			}
		}
		eNamedElement.setName(name);
	}

	protected void copyTemplateSignature(@NonNull List<ETypeParameter> eTypeParameters, TemplateableElement pivotElement) {
		TemplateSignature templateSignature = pivotElement.getOwnedTemplateSignature();
		if (templateSignature != null) {
			List<TemplateParameter> parameters = templateSignature.getOwnedParameter();
			safeVisitAll(eTypeParameters, parameters);
		}
	}

	protected void copyTypedElement(@NonNull ETypedElement eTypedElement, @NonNull TypedMultiplicityElement pivotTypedElement) {
		copyNamedElement(eTypedElement, pivotTypedElement);
		@SuppressWarnings("null")@NonNull List<EAnnotation> eAnnotations = eTypedElement.getEAnnotations();
		safeVisitAll(eAnnotations, pivotTypedElement.getOwnedAnnotation());
		context.defer(pivotTypedElement);		// Defer type/multiplicity setting
	}

	protected @Nullable EAnnotation createOppositeEAnnotation(@NonNull Property property) {
		String lower = null;
		String ordered = null;
		String unique = null;
		String upper = null;
		IntegerValue lowerValue;
		IntegerValue upperValue;
		Type propertyType = property.getType();
		Type type;
		if (propertyType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)propertyType;
			type = collectionType.getElementType();
			lowerValue = collectionType.getLowerValue();
			upperValue = collectionType.getUpperValue();
			if (collectionType.isOrdered() != PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_ORDERED) {
				ordered = Boolean.toString(collectionType.isOrdered());
			}
			if (collectionType.isUnique() != PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE) {
				unique = Boolean.toString(collectionType.isUnique());
			}
			if (!PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_LOWER_VALUE.equals(lowerValue)) {
				lower = lowerValue.toString();
			}
			if (!PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_UPPER_VALUE.equals(upperValue)) {
				upper = upperValue.toString();
			}
		}
		else {
			type = propertyType;
			lowerValue = property.isRequired() ? ValuesUtil.ONE_VALUE : ValuesUtil.ZERO_VALUE;
			upperValue = ValuesUtil.ONE_VALUE;
			if (!ValuesUtil.ZERO_VALUE.equals(lowerValue)) {
				lower = lowerValue.toString();
			}
			if (!ValuesUtil.ONE_VALUE.equals(upperValue)) {
				upper = upperValue.toString();
			}
		}
		String name = property.getName();
		if (name.equals(type.getName()) && (lower == null) && (ordered == null) && (unique == null) && (upper == null)) {
			return null;
		}
		lower = null;
		ordered = null;
		unique = null;
		upper = null;
		if (propertyType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType)propertyType;
			if (collectionType.isOrdered() != PivotConstants.ANNOTATED_IMPLICIT_OPPOSITE_ORDERED) {
				ordered = Boolean.toString(collectionType.isOrdered());
			}
			if (collectionType.isUnique() != PivotConstants.ANNOTATED_IMPLICIT_OPPOSITE_UNIQUE) {
				unique = Boolean.toString(collectionType.isUnique());
			}
		}
		if (!PivotConstants.ANNOTATED_IMPLICIT_OPPOSITE_LOWER_VALUE.equals(lowerValue)) {
			lower = lowerValue.toString();
		}
		if (!PivotConstants.ANNOTATED_IMPLICIT_OPPOSITE_UPPER_VALUE.equals(upperValue)) {
			upper = upperValue.toString();
		}
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
		EMap<String, String> details = eAnnotation.getDetails();
		details.put(EMOFExtendedMetaData.EMOF_COMMENT_BODY, name);
		if (lower != null) {
			details.put("lower", lower);
		}
		if (ordered != null) {
			details.put("ordered", ordered);
		}
		if (unique != null) {
			details.put("unique", unique);
		}
		if (upper != null) {
			details.put("upper", upper);
		}
		return eAnnotation;
	}

	public <T extends EObject> void safeVisitAll(@NonNull List<T> eObjects, @NonNull Iterable<? extends Element> pivotObjects) {
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
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for Pivot2Ecore Declaration pass");
	}

	@Override
	public EObject visitAnnotation(@NonNull Annotation pivotAnnotation) {
		@SuppressWarnings("null")
		@NonNull EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		copyDetails(eAnnotation, pivotAnnotation);
		eAnnotation.setSource(pivotAnnotation.getName());
		@SuppressWarnings("null")@NonNull List<EObject> contents = eAnnotation.getContents();
		safeVisitAll(contents, pivotAnnotation.getOwnedContent());
		if (!pivotAnnotation.getReference().isEmpty()) {
			context.defer(pivotAnnotation);
		}
		return eAnnotation;
	}

	@Override
	public EObject visitClass(@NonNull Class pivotClass) {
		if (pivotClass.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		copyClassifier(eClass, pivotClass);
		eClass.setAbstract(pivotClass.isAbstract());
		eClass.setInterface(pivotClass.isInterface());
		context.defer(pivotClass);		// Defer superclass resolution
		@SuppressWarnings("null")@NonNull List<EOperation> eOperations = eClass.getEOperations();
		@SuppressWarnings("null")@NonNull Iterable<Constraint> nonDuplicateConstraints = Iterables.filter(pivotClass.getOwnedInvariant(), nonDuplicateConstraintsFilter);
//		safeVisitAll(eOperations, nonDuplicateConstraints);
		@SuppressWarnings("null")@NonNull Iterable<Operation> nonDuplicateOperations = Iterables.filter(pivotClass.getOwnedOperation(), nonDuplicateOperationsFilter);
		safeVisitAll(eOperations, nonDuplicateOperations);
		@SuppressWarnings("null")@NonNull List<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
		@SuppressWarnings("null")@NonNull Iterable<Property> nonDuplicateProperties = Iterables.filter(pivotClass.getOwnedAttribute(), nonDuplicatePropertiesFilter);
		safeVisitAll(eStructuralFeatures, nonDuplicateProperties);
		for (Constraint pivotInvariant : nonDuplicateConstraints) {
			if (pivotInvariant.isCallable()) {
				EOperation eOperation = Pivot2Ecore.createConstraintEOperation(pivotInvariant, pivotInvariant.getName(), context.getOptions());
				eOperations.add(eOperation);
				context.putCreated(pivotInvariant, eOperation);
				copyConstraint(eOperation, pivotInvariant);
			}
		}
		if (!context.isSuppressDuplicates()) {
			List<ETypedElement> eDuplicates = null;
			@SuppressWarnings("null")@NonNull Iterable<Constraint> duplicateConstraints = Iterables.filter(pivotClass.getOwnedInvariant(), duplicateConstraintsFilter);
			for (Constraint asConstraint : duplicateConstraints) {
				if (eDuplicates == null) {
					eDuplicates = new ArrayList<ETypedElement>();
				}
//				Object eOperation = safeVisit(asConstraint);
				if (asConstraint.isCallable()) {
					EOperation eOperation = Pivot2Ecore.createConstraintEOperation(asConstraint, asConstraint.getName(), context.getOptions());
					eOperations.add(eOperation);
					context.putCreated(asConstraint, eOperation);
					copyConstraint(eOperation, asConstraint);
					eDuplicates.add(eOperation);
					context.defer(asConstraint);		// Defer references
				}
			}
			@SuppressWarnings("null")@NonNull Iterable<Operation> duplicateOperations = Iterables.filter(pivotClass.getOwnedOperation(), duplicateOperationsFilter);
			for (Operation asOperation : duplicateOperations) {
				if (eDuplicates == null) {
					eDuplicates = new ArrayList<ETypedElement>();
				}
				Object eOperation = safeVisit(asOperation);
				if (eOperation instanceof EOperation) {
					eDuplicates.add((EOperation)eOperation);
				}
			}
			@SuppressWarnings("null")@NonNull Iterable<Property> duplicateProperties = Iterables.filter(pivotClass.getOwnedAttribute(), duplicatePropertiesFilter);
			for (Property asProperty : duplicateProperties) {
				if (eDuplicates == null) {
					eDuplicates = new ArrayList<ETypedElement>();
				}
				Object eStructuralFeature = safeVisit(asProperty);
				if (eStructuralFeature instanceof EStructuralFeature) {
					eDuplicates.add((EStructuralFeature) eStructuralFeature);
				}
			}
			if (eDuplicates != null) {
				EAnnotation eAnnotation = eClass.getEAnnotation(PivotConstants.DUPLICATES_ANNOTATION_SOURCE);
				if (eAnnotation == null) {
					eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					eAnnotation.setSource(PivotConstants.DUPLICATES_ANNOTATION_SOURCE);
					eClass.getEAnnotations().add(eAnnotation);
				}
				context.refreshList(eAnnotation.getContents(), eDuplicates);
			}
		}
		return eClass;
	}

	@Override
	public EObject visitConstraint(@NonNull Constraint pivotConstraint) {
		Element eContainer = (Element)pivotConstraint.eContainer();
		if (eContainer != null) {
			EModelElement eModelElement = context.getCreated(EModelElement.class, eContainer);
			if (eModelElement != null) {
				copyConstraint(eModelElement, pivotConstraint);
				return null;
			}
		}
		return null;
	}

	@Override
	public EObject visitDataType(@NonNull DataType pivotDataType) {
		if (pivotDataType.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
		copyDataTypeOrEnum(eDataType, pivotDataType);
		return eDataType;
	}

	@Override
	public EObject visitEnumeration(@NonNull Enumeration pivotEnumeration) {
		if (pivotEnumeration.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		copyDataTypeOrEnum(eEnum, pivotEnumeration);
		@SuppressWarnings("null")@NonNull List<EEnumLiteral> eLiterals = eEnum.getELiterals();
		safeVisitAll(eLiterals, pivotEnumeration.getOwnedLiteral());
		return eEnum;
	}

	@Override
	public EObject visitEnumerationLiteral(@NonNull EnumerationLiteral pivotEnumLiteral) {
		@SuppressWarnings("null")
		@NonNull EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		copyNamedElement(eEnumLiteral, pivotEnumLiteral);
		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			eEnumLiteral.setValue(pivotEnumLiteral.getValue().intValue());
		}
		else {
			eEnumLiteral.eUnset(EcorePackage.Literals.EENUM_LITERAL__VALUE);
		}
		return eEnumLiteral;
	}

	@Override
	public EObject visitOperation(@NonNull Operation pivotOperation) {
		if (pivotOperation.getTemplateBinding().size() > 0) {
			return null;
		}
		@SuppressWarnings("null")
		@NonNull EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		copyTypedElement(eOperation, pivotOperation);
		@SuppressWarnings("null")@NonNull List<ETypeParameter> eTypeParameters = eOperation.getETypeParameters();
		copyTemplateSignature(eTypeParameters, pivotOperation);
		@SuppressWarnings("null")@NonNull List<EParameter> eParameters = eOperation.getEParameters();
		safeVisitAll(eParameters, pivotOperation.getOwnedParameter());
//		safeVisitAll(eOperation.getEGenericExceptions(), pivotOperation.getRaisedException());
		OpaqueExpression bodyExpression = pivotOperation.getBodyExpression();
		if (bodyExpression != null) {
			EAnnotation eBodyConstraint = delegateInstaller.createOperationDelegate(eOperation, bodyExpression, context.getEcoreURI());
			if (eBodyConstraint != null) {
//				Pivot2Ecore.copyComments(eBodyConstraint, bodyExpression);
			}
		}
		for (Constraint pivotConstraint : pivotOperation.getPrecondition()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		for (Constraint pivotConstraint : pivotOperation.getPostcondition()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return eOperation;
	}

	@Override
	public EObject visitPackage(@NonNull Package pivotPackage) {
		@SuppressWarnings("null")
		@NonNull EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		copyNamedElement(ePackage, pivotPackage);
		@SuppressWarnings("null")@NonNull List<EAnnotation> eAnnotations = ePackage.getEAnnotations();
		safeVisitAll(eAnnotations, pivotPackage.getOwnedAnnotation());
		context.defer(pivotPackage);		// Defer delegate annotation analysis
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_PREFIX)) {
			ePackage.setNsPrefix(pivotPackage.getNsPrefix());
		}
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_URI)) {
			ePackage.setNsURI(pivotPackage.getNsURI());
		}
		@SuppressWarnings("null")@NonNull List<EPackage> eSubpackages = ePackage.getESubpackages();
		safeVisitAll(eSubpackages, pivotPackage.getNestedPackage());
		@SuppressWarnings("null")@NonNull List<EClassifier> eClassifiers = ePackage.getEClassifiers();
		safeVisitAll(eClassifiers, pivotPackage.getOwnedType());
		return ePackage;
	}

	@Override
	public EObject visitParameter(@NonNull Parameter pivotParameter) {
		@SuppressWarnings("null")
		@NonNull EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		copyTypedElement(eParameter, pivotParameter);
		return eParameter;
	}

	@Override
	public EObject visitProperty(@NonNull Property pivotProperty) {
		if (pivotProperty.isImplicit()) {
			return null;
		}
		EStructuralFeature eStructuralFeature;
		Type type = pivotProperty.getType();
		CollectionType ecoreCollectionType = context.isEcoreCollection(type);
		if (ecoreCollectionType != null) {
			type = ecoreCollectionType.getElementType();
		}
		if (type instanceof DataType) {
			EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			eAttribute.setID(pivotProperty.isID());
			eStructuralFeature = eAttribute;
		}
		else {
			EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			if ((pivotProperty.getOpposite() != null) || !pivotProperty.getKeys().isEmpty()) {
				context.defer(pivotProperty);
			}
			eReference.setContainment(pivotProperty.isComposite());
			eReference.setResolveProxies(pivotProperty.isResolveProxies());
			eStructuralFeature = eReference;
		}
		Property opposite = pivotProperty.getOpposite();
		if ((opposite != null) && opposite.isImplicit()) {
			EAnnotation eAnnotation = createOppositeEAnnotation(opposite);
			if (eAnnotation != null) {
				eStructuralFeature.getEAnnotations().add(eAnnotation);
			}
		}
		copyTypedElement(eStructuralFeature, pivotProperty);
		eStructuralFeature.setChangeable(!pivotProperty.isReadOnly());
		eStructuralFeature.setDerived(pivotProperty.isDerived());
		eStructuralFeature.setTransient(pivotProperty.isTransient());
		eStructuralFeature.setUnsettable(pivotProperty.isUnsettable());
		eStructuralFeature.setVolatile(pivotProperty.isVolatile());
		if (pivotProperty.eIsSet(PivotPackage.Literals.PROPERTY__DEFAULT)) {
			eStructuralFeature.setDefaultValueLiteral(pivotProperty.getDefault());
		}
		else {
			eStructuralFeature.eUnset(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
		}
		OpaqueExpression defaultExpression = pivotProperty.getDefaultExpression();
		if (defaultExpression != null) {
			delegateInstaller.createPropertyDelegate(eStructuralFeature, defaultExpression, context.getEcoreURI());
		}
/*		for (Property redefinedProperty : pivotProperty.getRedefinedProperty()) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(PivotConstants.REDEFINES_ANNOTATION_SOURCE);
			eStructuralFeature.getEAnnotations().add(eAnnotation);
		} */
		return eStructuralFeature;
	}

	@Override
	public Object visitRoot(@NonNull Root pivotRoot) {
		EModelElement firstElement = null;
		List<EObject> outputObjects = new ArrayList<EObject>();
		for (org.eclipse.ocl.examples.pivot.Package pivotObject : pivotRoot.getNestedPackage()) {
			if (!Orphanage.isTypeOrphanage(pivotObject)) {
				Object ecoreObject = safeVisit(pivotObject);
				if (ecoreObject instanceof EObject) {
					outputObjects.add((EObject) ecoreObject);
					if ((firstElement == null) && (ecoreObject instanceof EModelElement)) {
						firstElement = (EModelElement) ecoreObject;
					}
				}
			}
		}
		List<Import> imports = pivotRoot.getImports();
		if (imports.size() > 0) {
			if (imports.size() > 0) {
				imports = new ArrayList<Import>(imports);
				Collections.sort(imports, new Comparator<Import>()
						{
						public int compare(Import o1, Import o2) {
							String n1 = o1.getName();
							String n2 = o2.getName();
							if (n1 == null) n1 = "";
							if (n2 == null) n1 = "";
							return n1.compareTo(n2);
						}
					}
				);
			}
			EAnnotation importAnnotation = null;
			URI ecoreURI = context.getEcoreURI();
			for (Import anImport : imports) {
				Namespace importedNamespace = anImport.getImportedNamespace();
				if (importedNamespace != null) {
					if (importAnnotation == null) {
						importAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
						importAnnotation.setSource(PivotConstants.IMPORT_ANNOTATION_SOURCE);
					}
					EObject eTarget = importedNamespace.getETarget();
					if (eTarget != null) {
						URI uri = null;
						if ((eTarget instanceof EPackage) && DomainUtil.isRegistered(eTarget.eResource())) {
	 						String nsURI = ((EPackage)eTarget).getNsURI();
							if (nsURI != null) {
								uri = URI.createURI(nsURI);
							}
						}
						if (uri == null) {
							uri = EcoreUtil.getURI(eTarget);
						}
						URI uri2 = uri.deresolve(ecoreURI, true, true, true);
						importAnnotation.getDetails().put(anImport.getName(), uri2.toString());
					}
					else if (importedNamespace instanceof org.eclipse.ocl.examples.pivot.Package) {
						importAnnotation.getDetails().put(anImport.getName(), ((org.eclipse.ocl.examples.pivot.Package)importedNamespace).getNsURI());
					}
					else {
						importAnnotation.getDetails().put(anImport.getName(), importedNamespace.toString());
					}
				}
			}
			if ((firstElement != null) && (importAnnotation != null)) {
				firstElement.getEAnnotations().add(importAnnotation);
			}
		}
		return outputObjects;
	}

	@Override
	public EObject visitTypeTemplateParameter(@NonNull TypeTemplateParameter pivotTypeTemplateParameter) {
		ETypeParameter eTypeParameter = EcoreFactory.eINSTANCE.createETypeParameter();
		eTypeParameter.setName(((Type) pivotTypeTemplateParameter.getParameteredElement()).getName());
		context.putCreated(pivotTypeTemplateParameter, eTypeParameter);
		if (!pivotTypeTemplateParameter.getConstrainingType().isEmpty()) {
			context.defer(pivotTypeTemplateParameter);
		}
		return eTypeParameter;
	}
}

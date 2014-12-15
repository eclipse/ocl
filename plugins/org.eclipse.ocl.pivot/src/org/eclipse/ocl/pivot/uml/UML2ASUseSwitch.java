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
package org.eclipse.ocl.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.Unlimited;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.util.ValuesUtil;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.Region;
import org.eclipse.ocl.pivot.State;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.Transition;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Vertex;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
//import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2ASUseSwitch extends UMLSwitch<Object>
{
	private static final Logger logger = Logger.getLogger(UML2ASUseSwitch.class);

	protected final @NonNull UML2AS converter;
	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull StandardLibraryInternal standardLibrary;
	private Set<EClass> doneWarnings = null;
	
	public UML2ASUseSwitch(@NonNull UML2AS converter) {
		this.converter = converter;
		this.metaModelManager = converter.getMetaModelManager();
		this.standardLibrary = converter.getStandardLibrary();
	}
	
//	@Override
//	public Object caseEAnnotation(EAnnotation eObject) {
//		Annotation pivotElement = converter.getCreated(Annotation.class, eObject);
//		doSwitchAll(Element.class, pivotElement.getReference(), eObject.getReferences());
//		return pivotElement;
//	}

	@Override
	public org.eclipse.ocl.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		assert umlClass != null;
		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClass);
		if (pivotElement != null) {
//			doSwitchAll(Type.class, pivotElement.getSuperClass(), umlClass.getSuperClasses());
//			if (pivotElement.getSuperClass().isEmpty()) {
//				org.eclipse.ocl.pivot.Class oclElementType = metaModelManager.getOclElementType();
//				pivotElement.getSuperClass().add(oclElementType);
//			}
			List<org.eclipse.uml2.uml.Constraint> invariants = umlClass.getOwnedRules();
			doSwitchAll(Constraint.class, pivotElement.getOwnedInvariants(), invariants);
			copyConstraints(pivotElement, umlClass, invariants);
		}
		return pivotElement;
	}

/*	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		assert umlConstraint != null;
		Constraint pivotElement = converter.getCreated(Constraint.class, umlConstraint);
		if (pivotElement != null) {
			doSwitchAll(Element.class, pivotElement.getConstrainedElement(), umlConstraint.getConstrainedElements());
		}
		return pivotElement;
	} */

	@Override
	public Object caseClassifier(org.eclipse.uml2.uml.Classifier umlClassifier) {
		assert umlClassifier != null;
		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlClassifier);
		if (pivotElement != null) {
			List<org.eclipse.uml2.uml.Constraint> invariants = umlClassifier.getOwnedRules();
			doSwitchAll(Constraint.class, pivotElement.getOwnedInvariants(), invariants);
			copyConstraints(pivotElement, umlClassifier, invariants);
		}
		return umlClassifier;
	}

	@Override
	public Constraint caseConstraint(org.eclipse.uml2.uml.Constraint umlConstraint) {
		assert umlConstraint != null;
		Constraint pivotElement = converter.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, umlConstraint);
		org.eclipse.uml2.uml.ValueSpecification umlSpecification = umlConstraint.getSpecification();
		Object pivotSpecification = umlSpecification != null ? doSwitch(umlSpecification) : null;
		pivotElement.setSpecification((ExpressionInOCL) pivotSpecification);
		converter.copyNamedElement(pivotElement, umlConstraint);
//		if (!umlConstraint.getConstrainedElements().isEmpty()) {
//			converter.queueReference(umlConstraint);	// Defer
//		}
//		else {
//			pivotElement.getConstrainedElement().clear();
//		}
		doSwitchAll(Element.class, pivotElement.getConstrainedElement(), umlConstraint.getConstrainedElements());
		return pivotElement;
	}

	@Override
	public Object caseInstanceValue(org.eclipse.uml2.uml.InstanceValue umlInstanceValue) {
		assert umlInstanceValue != null;
		org.eclipse.uml2.uml.InstanceSpecification umlInstance = umlInstanceValue.getInstance();
		if (umlInstance instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
			EnumerationLiteral pivotEnumerationLiteral = converter.getCreated(EnumerationLiteral.class, umlInstance);
			ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlInstanceValue);
			OCLExpression body = pivotElement.getBodyExpression();
			if (!(body instanceof EnumLiteralExp)) {
				body = PivotFactory.eINSTANCE.createEnumLiteralExp();
				pivotElement.setBodyExpression(body);
				if (pivotEnumerationLiteral != null) {
					Type type = pivotEnumerationLiteral.getEnumeration();
					body.setType(type);
					pivotElement.setType(type);
				}
			}
			((EnumLiteralExp)body).setReferredEnumLiteral(pivotEnumerationLiteral);
			converter.copyNamedElement(pivotElement, umlInstanceValue);
			return pivotElement;
		}
		else {
			converter.error("Unknown InstanceValue " + umlInstance.getClass() + " for UML2ASReferenceSwitch");
			return null;
		}
	}

	@Override
	public org.eclipse.ocl.pivot.Class caseInterface(org.eclipse.uml2.uml.Interface umlInterface) {
		assert umlInterface != null;
		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlInterface);
		if (pivotElement != null) {
			List<org.eclipse.uml2.uml.Generalization> umlGeneralizations = umlInterface.getGeneralizations();
			List<org.eclipse.ocl.pivot.Class> newSuperTypes = new ArrayList<org.eclipse.ocl.pivot.Class>(Math.max(1, umlGeneralizations.size()));
			for (org.eclipse.uml2.uml.Generalization umlGeneralization : umlGeneralizations) {
				org.eclipse.uml2.uml.Classifier umlGeneral = umlGeneralization.getGeneral();
				if (umlGeneral != null) {
					org.eclipse.ocl.pivot.Class pivotGeneral = converter.getCreated(org.eclipse.ocl.pivot.Class.class, umlGeneral);
					if (!newSuperTypes.contains(pivotGeneral)) {
						newSuperTypes.add(pivotGeneral);
					}
				}
			}
			if (newSuperTypes.isEmpty()) {
				org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
				newSuperTypes.add(oclElementType);
			}
			PivotUtil.refreshList(pivotElement.getSuperClasses(), newSuperTypes);
		}
		return pivotElement;
	}

	@Override
	public Object caseLiteralBoolean(org.eclipse.uml2.uml.LiteralBoolean umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getBodyExpression();
		if (!(body instanceof BooleanLiteralExp)) {
			body = PivotFactory.eINSTANCE.createBooleanLiteralExp();
			pivotElement.setBodyExpression(body);
			Type type = standardLibrary.getBooleanType();
			body.setType(type);
			pivotElement.setType(type);
		}
		((BooleanLiteralExp)body).setBooleanSymbol(umlLiteral.booleanValue());
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralInteger(org.eclipse.uml2.uml.LiteralInteger umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getBodyExpression();
		if (!(body instanceof IntegerLiteralExp)) {
			body = PivotFactory.eINSTANCE.createIntegerLiteralExp();
			pivotElement.setBodyExpression(body);
			Type type = standardLibrary.getIntegerType();
			body.setType(type);
			pivotElement.setType(type);
		}
		((IntegerLiteralExp)body).setIntegerSymbol(umlLiteral.getValue());
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralNull(org.eclipse.uml2.uml.LiteralNull umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getBodyExpression();
		if (!(body instanceof NullLiteralExp)) {
			body = PivotFactory.eINSTANCE.createNullLiteralExp();
			pivotElement.setBodyExpression(body);
			Type type = standardLibrary.getOclVoidType();
			body.setType(type);
			pivotElement.setType(type);
		}
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralReal(org.eclipse.uml2.uml.LiteralReal umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getBodyExpression();
		if (!(body instanceof RealLiteralExp)) {
			body = PivotFactory.eINSTANCE.createRealLiteralExp();
			pivotElement.setBodyExpression(body);
			Type type = standardLibrary.getRealType();
			body.setType(type);
			pivotElement.setType(type);
		}
		((RealLiteralExp)body).setRealSymbol(umlLiteral.getValue());
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralString(org.eclipse.uml2.uml.LiteralString umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getBodyExpression();
		if (!(body instanceof StringLiteralExp)) {
			body = PivotFactory.eINSTANCE.createStringLiteralExp();
			pivotElement.setBodyExpression(body);
			Type type = standardLibrary.getStringType();
			body.setType(type);
			pivotElement.setType(type);
		}
		String umlValue = umlLiteral.getValue();
		((StringLiteralExp)body).setStringSymbol(umlValue != null ? umlValue : "");
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public Object caseLiteralUnlimitedNatural(org.eclipse.uml2.uml.LiteralUnlimitedNatural umlLiteral) {
		assert umlLiteral != null;
		ExpressionInOCL pivotElement = converter.refreshNamedElement(ExpressionInOCL.class, PivotPackage.Literals.EXPRESSION_IN_OCL, umlLiteral);
		OCLExpression body = pivotElement.getBodyExpression();
		if (!(body instanceof UnlimitedNaturalLiteralExp)) {
			body = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
			pivotElement.setBodyExpression(body);
			Type type = standardLibrary.getUnlimitedNaturalType();
			body.setType(type);
			pivotElement.setType(type);
		}
		long value = umlLiteral.getValue();
		((UnlimitedNaturalLiteralExp)body).setUnlimitedNaturalSymbol(value >= 0 ? value : Unlimited.INSTANCE);
		converter.copyNamedElement(pivotElement, umlLiteral);
		return pivotElement;
	}

	@Override
	public ExpressionInOCL caseOpaqueExpression(org.eclipse.uml2.uml.OpaqueExpression umlExpression) {
		assert umlExpression != null;
		ExpressionInOCL pivotElement = converter.refreshOpaqueExpression(umlExpression);
		return pivotElement;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		assert umlOperation != null;
		Operation pivotElement = converter.getCreated(Operation.class, umlOperation);
		if (pivotElement != null) {
			doSwitchAll(Type.class, pivotElement.getRaisedException(), umlOperation.getRaisedExceptions());
			doSwitchAll(Operation.class, pivotElement.getRedefinedOperation(), umlOperation.getRedefinedOperations());
			for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation.getOwnedParameters()) {
				org.eclipse.uml2.uml.ParameterDirectionKind direction = umlParameter.getDirection();
				if (direction == org.eclipse.uml2.uml.ParameterDirectionKind.RETURN_LITERAL) {
					resolveMultiplicity(pivotElement, umlParameter);
				}
			}
			List<org.eclipse.uml2.uml.Constraint> preconditions = umlOperation.getPreconditions();
			org.eclipse.uml2.uml.Constraint bodyCondition = umlOperation.getBodyCondition();
			List<org.eclipse.uml2.uml.Constraint> postconditions = umlOperation.getPostconditions();
			doSwitchAll(Constraint.class, pivotElement.getPrecondition(), preconditions);
			doSwitchAll(Constraint.class, pivotElement.getPostcondition(), postconditions);
			Constraint constraint = bodyCondition != null ? (Constraint) doSwitch(bodyCondition) : null;
			LanguageExpression specification = null;
			if (constraint != null) {
				specification = constraint.getSpecification();
				constraint.setSpecification(null);			// Avoid a child-stealing detection
			}
			pivotElement.setBodyExpression(specification);
			List<org.eclipse.uml2.uml.Constraint> exclusions;
			if ((preconditions.size() > 0) || (bodyCondition != null) || (postconditions.size() > 0)) {
				exclusions = new ArrayList<org.eclipse.uml2.uml.Constraint>();
				exclusions.addAll(preconditions);
				if (bodyCondition != null) {
					exclusions.add(bodyCondition);
				}
				exclusions.addAll(postconditions);
			}
			else {
				exclusions = Collections.emptyList();
			}
//			copyNamespace(pivotElement, umlOperation, exclusions);
//			copyNamedElement(pivotElement, umlOperation);
			copyConstraints(pivotElement, umlOperation, exclusions);
		}
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		assert umlPackage != null;
		org.eclipse.ocl.pivot.Package pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Package.class, umlPackage);
		if (pivotElement != null) {
			doSwitchAll(org.eclipse.ocl.pivot.Package.class, pivotElement.getImportedPackage(), umlPackage.getImportedPackages());
			copyConstraints(pivotElement, umlPackage, null);
		}
		return pivotElement;
	}

//	@Override
//	public ProfileApplication caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication umlProfileApplication) {
//	resolved during installStereotypes
//	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
//		if ((umlProperty.getName() != null) && umlProperty.getName().startsWith(UML2AS.STEREOTYPE_BASE_PREFIX)) {
//			System.out.println("Got it");
//		}
		assert umlProperty != null;
		Property pivotElement = converter.getCreated(Property.class, umlProperty);
		if (pivotElement != null) {
			resolveMultiplicity(pivotElement, umlProperty);
			doSwitchAll(Property.class, pivotElement.getRedefinedProperty(), umlProperty.getRedefinedProperties());
	//		doSwitchAll(Property.class, pivotElement.getSubsettedProperty(), umlProperty.getSubsettedProperties());
			ExpressionInOCL asExpression = null;
			//
			//	Synthesize xxx() for idiomatic UML xxx property default.
			//
			String propertyName = pivotElement.getName();
			if (propertyName != null) {
				org.eclipse.uml2.uml.Class umlClass = umlProperty.getClass_();
				if (umlClass != null) {
					for (org.eclipse.uml2.uml.Operation umlOperation : umlClass.getOwnedOperations()) {
						if (propertyName.equals(umlOperation.getName()) && (umlOperation.getOwnedParameters().size() == 1)) {
						{
							org.eclipse.uml2.uml.Constraint bodyCondition = umlOperation.getBodyCondition();
							if (bodyCondition != null) {
								List<org.eclipse.uml2.uml.Element> constrainedElement = bodyCondition.getConstrainedElements();
								if ((constrainedElement.size() >= 2)
									 && (constrainedElement.get(0) == umlOperation)
									 && (constrainedElement.get(1) == umlProperty)) {
										asExpression = PivotFactory.eINSTANCE.createExpressionInOCL();
										asExpression.setBody(propertyName + "()");
										asExpression.setIsRequired(pivotElement.isRequired());
										asExpression.setType(pivotElement.getType());
									}
								}
							}
							break;
						}
					}
				}
			}
			if (asExpression == null) {
				org.eclipse.uml2.uml.ValueSpecification umlValue = umlProperty.getDefaultValue();
				if (umlValue != null) {
					asExpression = (ExpressionInOCL) doSwitch(umlValue);
					Type requiredType = pivotElement.getType();
					Type defaultValueType = asExpression != null ? asExpression.getType() : null;
					if ((requiredType != null) && (defaultValueType != null) && !defaultValueType.conformsTo(standardLibrary, requiredType)) {
						converter.error("Incompatible '" + defaultValueType + "' initializer for " + pivotElement + " when '" + requiredType + "' required");
					}
				}
			}
			pivotElement.setDefaultExpression(asExpression);
		}
		return pivotElement;
	}

	@Override
	public Region caseRegion(org.eclipse.uml2.uml.Region umlRegion) {
		assert umlRegion != null;
		Region pivotElement = converter.getCreated(Region.class, umlRegion);
		if (pivotElement != null) {
			copyConstraints(pivotElement, umlRegion, null);
		}
		return pivotElement;
	}

	@Override
	public Object caseSlot(org.eclipse.uml2.uml.Slot umlSlot) {
		assert umlSlot != null;
		Element asElement = converter.getCreated(Element.class, umlSlot);
		return asElement;
	}

	@Override
	public State caseState(org.eclipse.uml2.uml.State umlState) {
		assert umlState != null;
		State pivotElement = converter.getCreated(State.class, umlState);
		if (pivotElement != null) {
			copyConstraints(pivotElement, umlState, null);
		}
		return pivotElement;
	}

	@Override
	public Transition caseTransition(org.eclipse.uml2.uml.Transition umlTransition) {
		assert umlTransition != null;
		Transition pivotElement = converter.getCreated(Transition.class, umlTransition);
		if (pivotElement != null) {
			org.eclipse.uml2.uml.Vertex umlSource = umlTransition.getSource();
			org.eclipse.uml2.uml.Vertex umlTarget = umlTransition.getTarget();
			Vertex pivotSource = umlSource != null ? converter.getCreated(Vertex.class, umlSource) : null;
			Vertex pivotTarget = umlTarget != null ? converter.getCreated(Vertex.class, umlTarget) : null;
			pivotElement.setSource(pivotSource);
			pivotElement.setTarget(pivotTarget);
			copyConstraints(pivotElement, umlTransition, null);
		}
		return pivotElement;
	}

	@Override
	public EObject caseTypedElement(org.eclipse.uml2.uml.TypedElement umlTypedElement) {
		assert umlTypedElement != null;			// FIXME Testing that this has migrated to UML2ASReference pass
		TypedElement pivotElement = converter.getCreated(TypedElement.class, umlTypedElement);
		if (pivotElement != null) {
			assert pivotElement.getType() != null;
			resolveMultiplicity(pivotElement, umlTypedElement);		// FIXME redundant
		}
		return pivotElement;
	}

//	@Override
//	public Object caseETypeParameter(ETypeParameter eObject) {
//		org.eclipse.ocl.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.pivot.Class.class, eObject);
//		TemplateParameter TemplateParameter = (TemplateParameter) pivotElement.getTemplateParameter();
//		doSwitchAll(Type.class, TemplateParameter.getConstrainingType(), eObject.getEBounds());
//		return null;
//	}

	protected void copyConstraints(@NonNull Namespace pivotElement, @NonNull org.eclipse.uml2.uml.Namespace umlNamespace,
			@Nullable List<org.eclipse.uml2.uml.Constraint> exclusions) {	
		List<org.eclipse.uml2.uml.Constraint> ownedRules = umlNamespace.getOwnedRules();
		if ((exclusions != null) && (exclusions.size() > 0)) {
			ownedRules = new ArrayList<org.eclipse.uml2.uml.Constraint>(ownedRules);
			ownedRules.removeAll(exclusions);
		}
		doSwitchAll(Constraint.class, pivotElement.getOwnedRule(), ownedRules);
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
						UML2AS adapter = UML2AS.findAdapter(eResource, metaModelManager);
						if (adapter != null) {
							pivotElement = adapter.getCreated(pivotClass,
								eObject);
						}
					}
				}
				if (pivotElement == null) {
					if (!(eObject instanceof org.eclipse.uml2.uml.Constraint)) {
						System.out.println("Use switching " + eObject);
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
					UnlimitedNaturalValue upperValue = upper == -1 ? ValuesUtil.UNLIMITED_VALUE : ValuesUtil.unlimitedNaturalValueOf(upper);
					pivotType = metaModelManager.getCollectionType(isOrdered, isUnique, pivotType, lowerValue, upperValue);
				}
			}
			pivotElement.setType(pivotType);
		}
		else {
			pivotElement.setType(standardLibrary.getOclVoidType());
		}
		pivotElement.setIsRequired(isRequired);
	}
}
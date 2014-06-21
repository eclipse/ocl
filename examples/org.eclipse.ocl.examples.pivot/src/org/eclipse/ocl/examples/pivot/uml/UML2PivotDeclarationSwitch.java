/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     E.D.Willink (CEA LIST) - Bug 388493, 399252, 399378
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.DomainConstants;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ConnectionPointReference;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.DynamicBehavior;
import org.eclipse.ocl.examples.pivot.DynamicElement;
import org.eclipse.ocl.examples.pivot.DynamicType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.FinalState;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Profile;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Pseudostate;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2PivotDeclarationSwitch;
import org.eclipse.ocl.examples.pivot.internal.impl.PackageImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

public class UML2PivotDeclarationSwitch extends UMLSwitch<Object>
{
	private static final Logger logger = Logger.getLogger(UML2PivotDeclarationSwitch.class);

	protected final Ecore2PivotDeclarationSwitch ecoreSwitch;
	protected final UML2Pivot converter;
	protected final MetaModelManager metaModelManager;
	
	public UML2PivotDeclarationSwitch(UML2Pivot converter) {
		this.converter = converter;
		this.ecoreSwitch = new Ecore2PivotDeclarationSwitch(converter);
		this.metaModelManager = converter.getMetaModelManager();
	}
	
	@Override
	public Object caseAssociation(org.eclipse.uml2.uml.Association umlAssociation) {
		assert umlAssociation != null;
//		System.out.println("Association " + umlAssociation.getName());
		@SuppressWarnings("null") @NonNull List<org.eclipse.uml2.uml.Property> ownedEnds = umlAssociation.getOwnedEnds();
		for (org.eclipse.uml2.uml.Property umlProperty : ownedEnds) {
			doSwitch(umlProperty);
		}
/*		@SuppressWarnings("null") @NonNull List<org.eclipse.uml2.uml.Property> memberEnds = umlAssociation.getMemberEnds();
//		boolean isSubsetted = false;
		boolean isUnnamed = false;
		for (org.eclipse.uml2.uml.Property memberEnd : memberEnds) {
//			if (memberEnd.getSubsettedProperties().size() > 0) {
//				isSubsetted = true;
//			}
			if (memberEnd.getName() == null) {
				isUnnamed = true;
			}
		}
		converter.addProperties(memberEnds, null);
		Property firstPivotElement = null;
		for (org.eclipse.uml2.uml.Property umlProperty : memberEnds) {
			Property pivotElement = (Property) doSwitch(umlProperty);
			if (!isUnnamed) { //isSubsetted) {
	//			converter.copyProperty(pivotElement, umlProperty, null);
	//			pivotElement.setImplicit(umlProperty.getAssociation() != null);
	//			converter.queueReference(umlAssociation);				// For opposite installation
				if (firstPivotElement == null) {
					firstPivotElement = pivotElement;
				}
				else {
					firstPivotElement.setOpposite(pivotElement);
					pivotElement.setOpposite(firstPivotElement);
				}
			}
		} */
		converter.queueReference(umlAssociation);	// opposites
		return this;
	}

	@Override
	public Object caseBehavior(org.eclipse.uml2.uml.Behavior umlBehavior) {
		assert umlBehavior != null;
		DynamicBehavior pivotElement = converter.refreshElement(DynamicBehavior.class, PivotPackage.Literals.DYNAMIC_BEHAVIOR, umlBehavior);
		pivotElement.setName(((org.eclipse.uml2.uml.Type)umlBehavior).getName());
		doSwitchAll(pivotElement.getOwnedAnnotation(), ((org.eclipse.uml2.uml.Element)umlBehavior).getOwnedElements(), null);
		EClass umlMetaClass = umlBehavior.eClass();
		Type metaType = metaModelManager.getPivotOfEcore(Type.class, umlMetaClass);
		pivotElement.setMetaType(metaType);
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		assert umlClass != null;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlClass);
//		System.out.println("Class " + umlClass.getName() + " => " + DomainUtil.debugSimpleName(pivotElement));
		copyClass(pivotElement, umlClass);
		converter.queueReference(umlClass);		// superClasses
		return pivotElement;
	}

	@Override
	public Object caseClassifierTemplateParameter(org.eclipse.uml2.uml.ClassifierTemplateParameter umlTemplateParameter) {
		assert umlTemplateParameter != null;
		@SuppressWarnings("null") @NonNull org.eclipse.uml2.uml.Class umlParameterClass = (org.eclipse.uml2.uml.Class) umlTemplateParameter.getParameteredElement();
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlParameterClass);
//		TypeTemplateParameter pivotTemplateParameter = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlTemplateParameter);
//		setOriginalMapping(pivotElement, umlTemplateParameter);
//		String name = umlTemplateParameter.getName();
//		pivotElement.setName(name);
		TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter) pivotElement.getTemplateParameter();
		if (typeTemplateParameter == null) {
			typeTemplateParameter = PivotFactory.eINSTANCE.createTypeTemplateParameter();
			typeTemplateParameter.setOwnedParameteredElement(pivotElement);
			converter.setOriginalMapping(typeTemplateParameter, umlTemplateParameter);
		}
		converter.setOriginalMapping(pivotElement, umlParameterClass);
//		List<EGenericType> eBounds = umlTemplateParameter.getEBounds();
//		if (!eBounds.isEmpty()) {
//			doSwitchAll(eBounds);
//			converter.queueReference(umlTemplateParameter);
//		}
		return typeTemplateParameter;
	}

	@Override
	public Comment caseComment(org.eclipse.uml2.uml.Comment umlComment) {
		assert umlComment != null;
		Comment pivotElement = converter.refreshElement(Comment.class, PivotPackage.Literals.COMMENT, umlComment);
		pivotElement.setBody(umlComment.getBody());
		copyComments(pivotElement, umlComment);
		return pivotElement;
	}

	@Override
	public ConnectionPointReference caseConnectionPointReference(org.eclipse.uml2.uml.ConnectionPointReference umlConnectionPointReference) {
		assert umlConnectionPointReference != null;
		ConnectionPointReference pivotElement = converter.refreshNamedElement(ConnectionPointReference.class, PivotPackage.Literals.CONNECTION_POINT_REFERENCE, umlConnectionPointReference);
		copyNamedElement(pivotElement, umlConnectionPointReference);
		return pivotElement;
	}

	@Override
	public DataType caseDataType(org.eclipse.uml2.uml.DataType umlDataType) {
		assert umlDataType != null;
		DataType pivotElement = converter.refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, umlDataType);
		copyDataTypeOrEnum(pivotElement, umlDataType);
		@SuppressWarnings("null") @NonNull List<org.eclipse.uml2.uml.Property> umlAttributes = umlDataType.getAttributes();
		doSwitchAll(umlAttributes);
//		converter.addProperties(umlAttributes, null);
		pivotElement.getSuperClass().add(metaModelManager.getOclAnyType());
		return pivotElement;
	}

	@Override
	public Enumeration caseEnumeration(org.eclipse.uml2.uml.Enumeration umlEnumeration) {
		assert umlEnumeration != null;
		Enumeration pivotElement = converter.refreshNamedElement(Enumeration.class, PivotPackage.Literals.ENUMERATION, umlEnumeration);
		copyDataTypeOrEnum(pivotElement, umlEnumeration);
		doSwitchAll(pivotElement.getOwnedLiteral(), umlEnumeration.getOwnedLiterals(), null);
//		pivotElement.getSuperClass().add(metaModelManager.getOclAnyType());
		pivotElement.getSuperClass().add(metaModelManager.getEnumerationType());
		return pivotElement;
	}

	@Override
	public EnumerationLiteral caseEnumerationLiteral(org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral) {
		assert umlEnumLiteral != null;
		EnumerationLiteral pivotElement = converter.refreshNamedElement(EnumerationLiteral.class,
			PivotPackage.Literals.ENUMERATION_LITERAL, umlEnumLiteral);
		copyNamedElement(pivotElement, umlEnumLiteral);
//		if (eEnumLiteral.eIsSet(EcorePackage.Literals.EENUM_LITERAL__VALUE)) {
//			pivotElement.setValue(BigInteger.valueOf(eEnumLiteral.getValue()));
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE);
//		}
//			String literal = basicGet(eObject, EcorePackage.Literals.EENUM_LITERAL__LITERAL, String.class);
//			Enumerator instance = eEnumLiteral.getInstance();
//			if (literal != null) {
/*				AnnotationCS csAnnotation = PivotFactory.eINSTANCE.createAnnotationCS();
				csAnnotation.setIdSource(EcorePackage.eNS_URI);
				DetailCS csDetail = PivotFactory.eINSTANCE.createDetailCS();
				csDetail.setIdName("literal");
				copyDetailLines(csDetail.getValue(), literal);
				csAnnotation.getDetails().add(csDetail);
				pivotElement.getAnnotations().add(csAnnotation); */
//			}
		return pivotElement;
	}

	@Override
	public Object caseExtension(Extension umlExtension) {
		assert umlExtension != null;
/* Redundant while NsURI set at start of convert
		org.eclipse.uml2.uml.Class metaclass = umlExtension.getMetaclass();
		if (metaclass != null) {
			org.eclipse.uml2.uml.Package metapackage = metaclass.getPackage();
			if (metapackage != null) {
				String metaNsURI = metapackage.getURI();
				if (metaNsURI != null) {
					metaModelManager.setMetamodelNsURI(metaNsURI);
				}
			}
		} */
		TypeExtension asTypeExtension = converter.refreshElement(TypeExtension.class, PivotPackage.Literals.TYPE_EXTENSION, umlExtension);
		if (asTypeExtension != null) {
			copyModelElement(asTypeExtension, umlExtension);
//			converter.queueReference(umlProfileApplication);
//			converter.addProfileApplication(umlProfileApplication);
			boolean isRequired = false;
			for (org.eclipse.uml2.uml.Property umlProperty : umlExtension.getOwnedEnds()) {
				@SuppressWarnings("unused")Object eObject = doSwitch(umlProperty);
				int lower = umlProperty.getLower();
				if (lower == 1) {
					isRequired = false;
				}
			}
			asTypeExtension.setIsRequired(isRequired);
			org.eclipse.uml2.uml.Class umlMetaclass = umlExtension.getMetaclass();
			if (umlMetaclass != null) {
				Package umlMetapackage = umlMetaclass.getPackage();
				if (umlMetapackage != null) {
					String nsURI = umlMetapackage.getURI();
					if (nsURI != null) {
						metaModelManager.getPackageManager().addPackageNsURISynonym(nsURI, DomainConstants.UML_METAMODEL_NAME);
					}
					converter.addImportedPackage(umlMetapackage);
				}
			}
			converter.queueReference(umlExtension);		// stereotype, type, opposites
		}
		return this;
	}

/*	@Override
	public Object caseExtensionEnd(ExtensionEnd umlExtensionEnd) {
		int lower = umlExtensionEnd.getLower();
		if (lower == 1) {
//			converter.addRequiredExtensionEnd(umlExtensionEnd);
		}
		return this;
	} */

	@Override
	public FinalState caseFinalState(org.eclipse.uml2.uml.FinalState umlState) {
		assert umlState != null;
		FinalState pivotElement = converter.refreshNamedElement(FinalState.class, PivotPackage.Literals.FINAL_STATE, umlState);
		copyState(pivotElement, umlState);
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseInterface(org.eclipse.uml2.uml.Interface umlInterface) {
		assert umlInterface != null;
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlInterface);
		pivotElement.setIsInterface(true);			
		copyClassOrInterface(pivotElement, umlInterface);
		return pivotElement;
	}

	@Override
	public Object caseOpaqueExpression(org.eclipse.uml2.uml.OpaqueExpression umlObject) {
		assert umlObject != null;
		converter.queueUse(umlObject);
		return null;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		assert umlOperation != null;
		Operation pivotElement = converter.refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, umlOperation);
		copyNamedElement(pivotElement, umlOperation);
		for (org.eclipse.uml2.uml.Parameter umlParameter : umlOperation.getOwnedParameters()) {
			org.eclipse.uml2.uml.ParameterDirectionKind direction = umlParameter.getDirection();
			if (direction == org.eclipse.uml2.uml.ParameterDirectionKind.IN_LITERAL) {
				Parameter pivotObject = (Parameter) doSwitch(umlParameter);
				if (pivotObject != null) {
					pivotElement.getOwnedParameter().add(pivotObject);
				}
			}
		}
		copyTemplateSignature(pivotElement, umlOperation.getOwnedTemplateSignature());
//		doSwitchAll(umlOperation.getEGenericExceptions());
		converter.queueUse(umlOperation);				// For exceptions
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		assert umlPackage != null;
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, umlPackage);
		copyPackage(pivotElement, umlPackage);
//		if (pivotElement.getName() == null) {
//			pivotElement.setName("anon_" + Integer.toHexString(System.identityHashCode(umlPackage)));
//			logger.error("Anonymous package named as '" + pivotElement.getName() + "'");
//		}
		return pivotElement;
	}

	@Override
	public Parameter caseParameter(org.eclipse.uml2.uml.Parameter eObject) {
		assert eObject != null;
		Parameter pivotElement = converter.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, eObject);
		copyTypedMultiplicityElement(pivotElement, eObject, null);
		return pivotElement;
	}

	@Override
	public DataType casePrimitiveType(org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType) {
		assert umlPrimitiveType != null;
		PrimitiveType primaryElement = null;
		String name = umlPrimitiveType.getName();
		if (UMLUtil.isBoolean(umlPrimitiveType) || TypeId.BOOLEAN_NAME.equals(name)) {
			primaryElement = metaModelManager.getBooleanType();
		}
		else if (UMLUtil.isInteger(umlPrimitiveType) || TypeId.INTEGER_NAME.equals(name)) {
			primaryElement = metaModelManager.getIntegerType();
		}
		else if (UMLUtil.isReal(umlPrimitiveType) || TypeId.REAL_NAME.equals(name)) {
			primaryElement = metaModelManager.getRealType();
		}
		else if (UMLUtil.isString(umlPrimitiveType) || TypeId.STRING_NAME.equals(name)) {
			primaryElement = metaModelManager.getStringType();
		}
		else if (UMLUtil.isUnlimitedNatural(umlPrimitiveType) || TypeId.UNLIMITED_NATURAL_NAME.equals(name)) {
			primaryElement = metaModelManager.getUnlimitedNaturalType();
		}
		else {
			org.eclipse.uml2.uml.Package umlPackage = umlPrimitiveType.getPackage();
			if ((umlPackage != null) && "EcorePrimitiveTypes". equals(umlPackage.getName())) {		// FIXME Bug 412918 for extra cases
				if ("EBigDecimal".equals(name)
					  || "EFloat".equals(name) || "EFloatObject".equals(name)) {
						primaryElement = metaModelManager.getRealType();
				}
				else if ("EBigInteger".equals(name)
					  || "EByte".equals(name) || "EByteObject".equals(name)
					  || "EChar".equals(name) || "ECharacterObject".equals(name)
					  || "ELong".equals(name) || "ELongObject".equals(name)
					  || "EShortObject".equals(name) || "EShortObject".equals(name)) {
						primaryElement = metaModelManager.getIntegerType();
				}
			}
		}
//		if (pivotElement != null) {
//			converter.addCreated(umlPrimitiveType, pivotElement);
//		}
		org.eclipse.uml2.uml.Stereotype ecoreStereotype = umlPrimitiveType.getAppliedStereotype("Ecore::EDataType");
		DataType pivotElement;
		if (primaryElement == metaModelManager.getBooleanType()) {
			pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		}
		else if (primaryElement == metaModelManager.getIntegerType()) {
			pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		}
		else if (primaryElement == metaModelManager.getRealType()) {
			pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		}
		else if (primaryElement == metaModelManager.getStringType()) {
			pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		}
		else if (primaryElement == metaModelManager.getUnlimitedNaturalType()) {
			pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		}
		else if (ecoreStereotype != null) {
			pivotElement = converter.refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, umlPrimitiveType);
		}
		else {
			pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		}
		if (primaryElement != null) {
//			@SuppressWarnings("unused")TypeServer typeServer1 = metaModelManager.getTypeServer(primaryElement);
//			@SuppressWarnings("unused")TypeServer typeServer2 = metaModelManager.getTypeServer(pivotElement);
			pivotElement.setBehavioralType(primaryElement);
			org.eclipse.uml2.uml.Package umlPackage = umlPrimitiveType.getPackage();
			if (umlPackage != null) {
				String nsURI = umlPackage.getURI();
				if (nsURI != null) {
//					metaModelManager.getPackageManager().addPackageNsURISynonym(nsURI, PackageId.METAMODEL_NAME);
				}
			}
		}
		else {
//			System.out.println("unknown PrimitiveType " + umlPrimitiveType);
		}
		copyClassifier(pivotElement, umlPrimitiveType);
		String instanceClassName = null;
		if (ecoreStereotype != null) {
			Object object = umlPrimitiveType.getValue(ecoreStereotype, "instanceClassName");
			if (object instanceof String) {
				instanceClassName = (String) object;
			}
		}
		pivotElement.setInstanceClassName(instanceClassName);
		return pivotElement;
	}

	@Override
	public Object caseProfile(org.eclipse.uml2.uml.Profile umlProfile) {
		assert umlProfile != null;
		Profile pivotElement = converter.refreshNamedElement(Profile.class, PivotPackage.Literals.PROFILE, umlProfile);
		copyPackage(pivotElement, umlProfile);
		return pivotElement;
	}

	@Override
	public Object caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication umlProfileApplication) {
		assert umlProfileApplication != null;
		ProfileApplication pivotElement = converter.refreshElement(ProfileApplication.class, PivotPackage.Literals.PROFILE_APPLICATION, umlProfileApplication);
		if (pivotElement != null) {
			copyModelElement(pivotElement, umlProfileApplication);
			converter.queueReference(umlProfileApplication);		// Resolve Profile reference
		}
		return pivotElement;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		assert umlProperty != null;
//		if ((umlProperty.getName() != null) && umlProperty.getName().startsWith(UML2Pivot.STEREOTYPE_BASE_PREFIX)) {
//			System.out.println("Got it");
//		}
		Property pivotElement = converter.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, umlProperty);
//		System.out.println("Property " + ((org.eclipse.uml2.uml.NamedElement)umlProperty.eContainer()).getName() + "::" + umlProperty.getName() + " => " + DomainUtil.debugSimpleName(pivotElement));
		copyProperty(pivotElement, umlProperty, null);
		// NB MDT/UML2's base_XXX/extension_YYY are spurious composites
		@SuppressWarnings("unused")org.eclipse.uml2.uml.Element owner = umlProperty.getOwner();
		boolean isComposer = true; //(owner instanceof org.eclipse.uml2.uml.Classifier) && !(owner instanceof org.eclipse.uml2.uml.Association);
		pivotElement.setIsComposite(isComposer && umlProperty.isComposite());			
		pivotElement.setImplicit(!isComposer);
//		pivotElement.setIsID(umlProperty.isID());			
//		pivotElement.setIsResolveProxies(umlProperty.isResolveProxies());
//		converter.addProperty(umlProperty);
		converter.queueReference(umlProperty);	// type
		converter.queueUse(umlProperty);	// Defer
		return pivotElement;
	}

	@Override
	public Pseudostate casePseudostate(org.eclipse.uml2.uml.Pseudostate umlPseudostate) {
		assert umlPseudostate != null;
		Pseudostate pivotElement = converter.refreshNamedElement(Pseudostate.class, PivotPackage.Literals.PSEUDOSTATE, umlPseudostate);
		copyNamedElement(pivotElement, umlPseudostate);
		return pivotElement;
	}

	@Override
	public Region caseRegion(org.eclipse.uml2.uml.Region umlRegion) {
		assert umlRegion != null;
		Region pivotElement = converter.refreshNamedElement(Region.class, PivotPackage.Literals.REGION, umlRegion);
		copyNamespace(pivotElement, umlRegion);
		doSwitchAll(pivotElement.getSubvertex(), umlRegion.getSubvertices(), null);
		doSwitchAll(pivotElement.getTransition(), umlRegion.getTransitions(), null);
		return pivotElement;
	}

	@Override
	public State caseState(org.eclipse.uml2.uml.State umlState) {
		assert umlState != null;
		State pivotElement = converter.refreshNamedElement(State.class, PivotPackage.Literals.STATE, umlState);
		copyState(pivotElement, umlState);
		return pivotElement;
	}

	@Override
	public StateMachine caseStateMachine(org.eclipse.uml2.uml.StateMachine umlStateMachine) {
		assert umlStateMachine != null;
		StateMachine pivotElement = converter.refreshNamedElement(StateMachine.class, PivotPackage.Literals.STATE_MACHINE, umlStateMachine);
		copyClass(pivotElement, umlStateMachine);
		doSwitchAll(pivotElement.getRegion(), umlStateMachine.getRegions(), null);
		return pivotElement;
	}

	@Override
	public Stereotype caseStereotype(org.eclipse.uml2.uml.Stereotype umlStereotype) {
		assert umlStereotype != null;
		Stereotype pivotElement = converter.refreshNamedElement(Stereotype.class, PivotPackage.Literals.STEREOTYPE, umlStereotype);
		copyClass(pivotElement, umlStereotype);
		converter.queueReference(umlStereotype);		// superClasses
		return pivotElement;
	}

	@Override
	public Transition caseTransition(org.eclipse.uml2.uml.Transition umlTransition) {
		assert umlTransition != null;
		Transition pivotElement = converter.refreshNamedElement(Transition.class, PivotPackage.Literals.TRANSITION, umlTransition);
		copyNamespace(pivotElement, umlTransition);
		return pivotElement;
	}

	protected void copyAnnotatedElement(@NonNull NamedElement pivotElement,
			@NonNull EModelElement umlElement, @Nullable List<EAnnotation> excludedAnnotations) {
		List<Element> pivotAnnotations = pivotElement.getOwnedAnnotation();
		for (EAnnotation eAnnotation : umlElement.getEAnnotations()) {
			if ((excludedAnnotations == null) || !excludedAnnotations.contains(eAnnotation)) {
				Element pivotAnnotation = (Element) doSwitch(eAnnotation);
				if (pivotAnnotation != null) {
					pivotAnnotations.add(pivotAnnotation);
				}
			}
		}
	}

	protected void copyClassOrInterface(@NonNull org.eclipse.ocl.examples.pivot.Class pivotElement, @NonNull org.eclipse.uml2.uml.Classifier umlClassifier) {
		copyClassifier(pivotElement, umlClassifier);
		pivotElement.setIsAbstract(umlClassifier.isAbstract());			
		String instanceClassName = null;
		org.eclipse.uml2.uml.Stereotype ecoreStereotype = umlClassifier.getAppliedStereotype("Ecore::EClass");
		if (ecoreStereotype != null) {
			Object object = umlClassifier.getValue(ecoreStereotype, "instanceClassName");
			if (object instanceof String) {
				instanceClassName = (String) object;
			}
		}
		pivotElement.setInstanceClassName(instanceClassName);
//		doSwitchAll(umlClass.getSuperClasses());
		doSwitchAll(pivotElement.getOwnedOperation(), umlClassifier.getOperations(), null);
		@SuppressWarnings("null") @NonNull List<org.eclipse.uml2.uml.Property> umlAttributes = umlClassifier.getAttributes();
/*		converter.addProperties(umlAttributes, new UML2Pivot.Predicate<org.eclipse.uml2.uml.Property>()
		{
			public boolean filter(@NonNull org.eclipse.uml2.uml.Property element) {
				if (element.getAssociation() == null) {
					doSwitch(element);
				}
				return element.getAssociation() == null;
			}
		}); */
//		doSwitchAll(pivotElement.getOwnedAttribute(), umlClassifier.getAttributes());
		doSwitchAll(umlAttributes);
		converter.queueUse(umlClassifier);				// For superclasses
	}

	protected void copyClass(@NonNull org.eclipse.ocl.examples.pivot.Class pivotElement, @NonNull org.eclipse.uml2.uml.Class umlClass) {
		pivotElement.setIsInterface(false);			
		copyClassOrInterface(pivotElement, umlClass);
/*		for (org.eclipse.uml2.uml.Classifier umlType : umlClass.getNestedClassifiers()) {
//			doSwitch(umlType);
			Type pivotObject = (Type) doSwitch(umlType);
			if (pivotObject != null) {
				metaModelManager.addOrphanClass(pivotObject);
			}
		} */
		doSwitchAll(pivotElement.getNestedType(), umlClass.getNestedClassifiers(), null);
		doSwitchAll(pivotElement.getOwnedBehavior(), umlClass.getOwnedBehaviors(), null);
	}

	protected void copyClassifier(@NonNull org.eclipse.ocl.examples.pivot.Class pivotElement, @NonNull org.eclipse.uml2.uml.Classifier umlClassifier) {
		copyNamespace(pivotElement, umlClassifier);
		copyTemplateSignature(pivotElement, umlClassifier.getOwnedTemplateSignature());
	}

	protected void copyComments(@NonNull Element pivotElement, @NonNull org.eclipse.uml2.uml.Element umlElement) {
		doSwitchAll(pivotElement.getOwnedComment(), umlElement.getOwnedComments(), null);
	}

/*	protected void copyConstraints(@NonNull Namespace pivotElement, @NonNull org.eclipse.uml2.uml.Namespace umlNamespace,
			@Nullable List<org.eclipse.uml2.uml.Constraint> exclusions) {	
		List<org.eclipse.uml2.uml.Constraint> ownedRules = umlNamespace.getOwnedRules();
		if ((exclusions != null) && (exclusions.size() > 0)) {
			ownedRules = new ArrayList<org.eclipse.uml2.uml.Constraint>(ownedRules);
			ownedRules.removeAll(exclusions);
		}
		doSwitchAll(pivotElement.getOwnedRule(), ownedRules, null);
	} */

	protected void copyDataTypeOrEnum(@NonNull DataType pivotElement, @NonNull org.eclipse.uml2.uml.DataType umlDataType) {
		copyClassifier(pivotElement, umlDataType);
		String instanceClassName = null;
		org.eclipse.uml2.uml.Stereotype ecoreStereotype = umlDataType.getAppliedStereotype("Ecore::EDataType");
		if (ecoreStereotype != null) {
			Object object = umlDataType.getValue(ecoreStereotype, "instanceClassName");
			if (object instanceof String) {
				instanceClassName = (String) object;
			}
		}
		pivotElement.setInstanceClassName(instanceClassName);
//		pivotElement.setIsSerializable(umlDataType.isSerializable());
	}

/*		public void copyDetailLines(List<String> lines, String value) {
			String[] splitLines = value.split("\n");
			for (int i = 0; i < splitLines.length-1; i++) {
				lines.add(splitLines[i] + '\n');
			}
			if (splitLines.length > 0) {
				lines.add(splitLines[splitLines.length-1]);
			}
		} */

	protected void copyModelElement(@NonNull Element pivotElement, @NonNull org.eclipse.uml2.uml.Element umlElement) {
		converter.setOriginalMapping(pivotElement, umlElement);
	}

	protected void copyNamedElement(@NonNull NamedElement pivotElement, @NonNull org.eclipse.uml2.uml.NamedElement umlNamedElement) {
		copyModelElement(pivotElement, umlNamedElement);
		String name = umlNamedElement.getName();
		pivotElement.setName(name);
		copyAnnotatedElement(pivotElement, umlNamedElement, null);
		copyComments(pivotElement, umlNamedElement);
	}
	
	protected void copyNamespace(@NonNull Namespace pivotElement, @NonNull org.eclipse.uml2.uml.Namespace umlNamespace) {
		copyNamedElement(pivotElement, umlNamespace);
		converter.queueUse(umlNamespace);				// Defer for constraints
	}

	protected org.eclipse.uml2.uml.Profile getEcoreProfile(EObject eObject) {
		Resource eResource = eObject.eResource();

		if (eResource != null) {
			ResourceSet resourceSet = eResource.getResourceSet();

			if (resourceSet != null) {
				return UML2Util.load(resourceSet, URI
					.createURI(UMLResource.ECORE_PROFILE_URI),
					UMLPackage.Literals.PROFILE);
			}
		}

		return null;
	}

	protected org.eclipse.uml2.uml.Stereotype getEcoreStereotype(EObject eObject, String name) {
		org.eclipse.uml2.uml.Profile ecoreProfile = getEcoreProfile(eObject);

		return ecoreProfile != null
			? ecoreProfile.getOwnedStereotype(name)
			: null;
	}

	protected void copyPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pivotElement, @NonNull org.eclipse.uml2.uml.Package umlPackage) {
//		EAnnotation eAnnotation = umlPackage.getEAnnotation(EcorePackage.eNS_URI);
//		List<EAnnotation> exclusions = eAnnotation == null ? Collections.<EAnnotation>emptyList() : Collections.singletonList(eAnnotation);
		copyNamespace(pivotElement, umlPackage);
		Object nsPrefix = null;
		Object nsURI = umlPackage.getURI();
		org.eclipse.uml2.uml.Stereotype ecoreStereotype = getEcoreStereotype(umlPackage, UMLUtil.STEREOTYPE__E_PACKAGE);
		if ((ecoreStereotype != null) && umlPackage.isStereotypeApplied(ecoreStereotype)) {
			nsPrefix = umlPackage.getValue(ecoreStereotype, UMLUtil.TAG_DEFINITION__NS_PREFIX);
			if (nsURI == null) {
				nsURI = umlPackage.getValue(ecoreStereotype, UMLUtil.TAG_DEFINITION__NS_URI);
			}
		}
		pivotElement.setNsPrefix(nsPrefix != null ? nsPrefix.toString() : null);
		if (nsURI instanceof String) {
			String nsURI2 = (String)nsURI;
			if (!(umlPackage instanceof org.eclipse.uml2.uml.Profile) && nsURI2.startsWith("http://www.omg.org/spec/")) {
				String packageName = umlPackage.getName();
				if ("UML".equals(packageName)) {		// OMG's 
					for (org.eclipse.uml2.uml.Type umlType : umlPackage.getOwnedTypes()) {
						if ((umlType instanceof org.eclipse.uml2.uml.Class) && "Class".equals(umlType.getName())) {
							metaModelManager.getPackageManager().addPackageNsURISynonym(nsURI2, DomainConstants.UML_METAMODEL_NAME);;
							((PackageImpl)pivotElement).setIgnoreInvariants(true);
							break;
						}
					}
				}
				else if ("PrimitiveTypes".equals(packageName)) {
					for (org.eclipse.uml2.uml.Type umlType : umlPackage.getOwnedTypes()) {
						if ((umlType instanceof org.eclipse.uml2.uml.PrimitiveType) && "Boolean".equals(umlType.getName())) {
							metaModelManager.getPackageManager().addPackageNsURISynonym(nsURI2, DomainConstants.TYPES_METAMODEL_NAME);;
							break;
						}
					}
				}
			}
			String sharedURI = metaModelManager.getPackageManager().getSharedURI(nsURI2);
			if ((sharedURI != null) && !sharedURI.equals(nsURI)) {
				((PackageImpl)pivotElement).setPackageId(IdManager.getRootPackageId(sharedURI));
			}
		}
		pivotElement.setNsURI(nsURI != null ? nsURI.toString() : null);
		@Nullable List<org.eclipse.uml2.uml.Element> umlOtherElements = null;
		@Nullable List<org.eclipse.uml2.uml.Package> umlNestedPackages = null;
		@Nullable List<org.eclipse.uml2.uml.Package> umlImportedPackages = null;
		@Nullable List<org.eclipse.uml2.uml.ProfileApplication> umlProfileApplications = null;
		@Nullable List<org.eclipse.uml2.uml.Type> umlTypes = null;
		@Nullable List<org.eclipse.uml2.uml.Association> umlAssociations = null;
		for (org.eclipse.uml2.uml.Element ownedElement : umlPackage.getOwnedElements()) {
			if (ownedElement instanceof org.eclipse.uml2.uml.Package) {
				if (umlNestedPackages == null) {
					umlNestedPackages = new ArrayList<org.eclipse.uml2.uml.Package>();
				}
				umlNestedPackages.add((org.eclipse.uml2.uml.Package)ownedElement);
			}
			else if (ownedElement instanceof org.eclipse.uml2.uml.PackageImport) {
				if (umlImportedPackages == null) {
					umlImportedPackages = new ArrayList<org.eclipse.uml2.uml.Package>();
				}
				umlImportedPackages.add(((org.eclipse.uml2.uml.PackageImport)ownedElement).getImportedPackage());
			}
			else if (ownedElement instanceof org.eclipse.uml2.uml.Association) {
				if (umlAssociations == null) {
					umlAssociations = new ArrayList<org.eclipse.uml2.uml.Association>();
				}
				umlAssociations.add((org.eclipse.uml2.uml.Association)ownedElement);
			}
			else if (ownedElement instanceof org.eclipse.uml2.uml.Type) {
				if (umlTypes == null) {
					umlTypes = new ArrayList<org.eclipse.uml2.uml.Type>();
				}
				umlTypes.add((org.eclipse.uml2.uml.Type)ownedElement);
			}
			else if (ownedElement instanceof org.eclipse.uml2.uml.ProfileApplication) {
				if (umlProfileApplications == null) {
					umlProfileApplications = new ArrayList<org.eclipse.uml2.uml.ProfileApplication>();
				}
				umlProfileApplications.add((org.eclipse.uml2.uml.ProfileApplication)ownedElement);
			}
			else if (ownedElement instanceof org.eclipse.uml2.uml.Comment) {
//				umlComments.add((org.eclipse.uml2.uml.Comment)ownedElement);
			}
			else {
				if (umlOtherElements == null) {
					umlOtherElements = new ArrayList<org.eclipse.uml2.uml.Element>();
				}
				umlOtherElements.add(ownedElement);
			}
		}
		if (umlNestedPackages != null) {
			doSwitchAll(pivotElement.getNestedPackage(), umlNestedPackages, null);
		}
		else {
			pivotElement.getNestedPackage().clear();
		}
		if (umlProfileApplications != null) {
			doSwitchAll(pivotElement.getProfileApplication(), umlProfileApplications, null);
			for (org.eclipse.uml2.uml.ProfileApplication umlProfileApplication : umlProfileApplications) {
				if (umlProfileApplication != null) {
					org.eclipse.uml2.uml.Profile appliedProfile = umlProfileApplication.getAppliedProfile();
					if (appliedProfile != null) {
						if (umlImportedPackages == null) {
							umlImportedPackages = new ArrayList<org.eclipse.uml2.uml.Package>();
						}
						umlImportedPackages.add(appliedProfile);
					}
				}
			}
		}
		else {
			pivotElement.getProfileApplication().clear();
		}
		if (umlTypes != null) {
			doSwitchAll(pivotElement.getOwnedType(), umlTypes, null);
		}
		else {
			pivotElement.getOwnedType().clear();
		}
		if (umlAssociations != null) {
			for (org.eclipse.uml2.uml.Association umlAssociation : umlAssociations) {
				doSwitch(umlAssociation);
			}
		}
		if (umlOtherElements != null) {
			doSwitchAll(pivotElement.getOwnedAnnotation(), umlOtherElements, null);
		}
		else {
			pivotElement.getOwnedAnnotation().clear();
		}
		if (umlImportedPackages != null) {
			converter.addImportedPackages(umlImportedPackages);
			converter.queueUse(umlPackage);	// Defer
		}
		else {
			pivotElement.getImportedPackage().clear();
		}
	}


	protected void copyProperty(@NonNull Property pivotElement, @NonNull org.eclipse.uml2.uml.Property umlProperty, List<EAnnotation> excludedAnnotations) {
		copyTypedMultiplicityElement(pivotElement, umlProperty, excludedAnnotations);
//		converter.copyMultiplicityElement(pivotElement, umlProperty);
		pivotElement.setIsReadOnly(umlProperty.isReadOnly());			
		pivotElement.setIsDerived(umlProperty.isDerived());			
//		pivotElement.setIsTransient(umlProperty.isTransient());			
//		pivotElement.setIsUnsettable(umlProperty.isUnsettable());			
//		pivotElement.setIsVolatile(umlProperty.isVolatile());			
//		if (umlProperty.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL)) {
//			pivotElement.setDefault(eObject.getDefaultValueLiteral());
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.PROPERTY__DEFAULT);
//		}
	}

	protected void copyState(@NonNull State pivotElement, @NonNull org.eclipse.uml2.uml.State umlState) {
		copyNamespace(pivotElement, umlState);
		doSwitchAll(pivotElement.getRegion(), umlState.getRegions(), null);
	}

	protected void copyTemplateSignature(TemplateableElement pivotElement, org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature) {
		if (umlTemplateSignature != null) {
			List<org.eclipse.uml2.uml.TemplateParameter> umlTemplateParameters = umlTemplateSignature.getOwnedParameters();
			if (!umlTemplateParameters.isEmpty()) {
				TemplateSignature pivotTemplateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
				pivotElement.setOwnedTemplateSignature(pivotTemplateSignature);
				doSwitchAll(pivotTemplateSignature.getOwnedParameter(), umlTemplateParameters, null);
			}
		}
	}

	protected void copyTypedMultiplicityElement(@NonNull TypedMultiplicityElement pivotElement, @NonNull org.eclipse.uml2.uml.TypedElement umlTypedElement, List<EAnnotation> excludedAnnotations) {
		copyNamedElement(pivotElement, umlTypedElement);
		int lower = ((org.eclipse.uml2.uml.MultiplicityElement)umlTypedElement).getLower();
		int upper = ((org.eclipse.uml2.uml.MultiplicityElement)umlTypedElement).getUpper();
		pivotElement.setIsRequired((upper == 1) && (lower == 1));
		org.eclipse.uml2.uml.Type umlType = umlTypedElement.getType();
		if (umlType != null) {
			converter.queueReference(umlTypedElement);
			Resource umlResource = umlType.eResource();
			if (umlResource != null) {
				converter.addImportedResource(umlResource);
			}
		}
	}

	@Override
	public Element defaultCase(EObject umlObject) {
		DynamicElement pivotElement;
		if (umlObject instanceof org.eclipse.uml2.uml.Type) {
			pivotElement = converter.refreshElement(DynamicType.class, PivotPackage.Literals.DYNAMIC_TYPE, umlObject);
			((DynamicType)pivotElement).setName(((org.eclipse.uml2.uml.Type)umlObject).getName());
		}
		else if (umlObject instanceof org.eclipse.uml2.uml.Element) {
			pivotElement = converter.refreshElement(DynamicElement.class, PivotPackage.Literals.DYNAMIC_ELEMENT, umlObject);
		}
		else {
			converter.error("Unsupported " + umlObject.eClass().getName() + " for UML2PivotDeclarationSwitch");
			return null;
		}
		doSwitchAll(pivotElement.getOwnedAnnotation(), ((org.eclipse.uml2.uml.Element)umlObject).getOwnedElements(), null);
		EClass umlMetaClass = umlObject.eClass();
		Type metaType = metaModelManager.getPivotOfEcore(Type.class, umlMetaClass);
		pivotElement.setMetaType(metaType);
		return pivotElement;
	}

	public Object doInPackageSwitch(@NonNull EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	@Override
	public Object doSwitch(EObject eObject) {
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == UMLPackage.eINSTANCE) {
			return doInPackageSwitch(eObject);
		}
		else if (ePackage == EcorePackage.eINSTANCE) {
			if (eObject.eContainer() instanceof org.eclipse.uml2.uml.Profile) {
				return null;
			}
			return ecoreSwitch.doInPackageSwitch(eObject);
		}
		else if (ePackage.getNsURI().startsWith("http://www.omg.org/spec/MOF")) {		// Should never happen (removed by CMOF2UMLResourceHandler
			if ((eObject instanceof org.eclipse.emf.ecore.xml.type.AnyType) && "Tag".equals(eClass.getName())) {
				FeatureMap anyAttribute = ((org.eclipse.emf.ecore.xml.type.AnyType)eObject).getAnyAttribute();
				Object name = null;
				Object value = null;
				Object element = null;
				for (Entry entry : anyAttribute) {
					EStructuralFeature eFeature = entry.getEStructuralFeature();
					if ("name".equals(eFeature.getName())) {
						name = anyAttribute.get(eFeature, false);
					}
					else if ("value".equals(eFeature.getName())) {
						value = anyAttribute.get(eFeature, false);
					}
					else if ("element".equals(eFeature.getName())) {
						element = anyAttribute.get(eFeature, false);
					}
				}
				boolean gotIt = false;
				EObject taggedObject = eObject.eResource().getEObject(String.valueOf(element));
				if ("org.omg.xmi.nsPrefix".equals(name) && (taggedObject instanceof org.eclipse.uml2.uml.Package)) {
					org.eclipse.ocl.examples.pivot.Package asPackage = converter.getCreated(org.eclipse.ocl.examples.pivot.Package.class, taggedObject);
					if (asPackage != null) {
						asPackage.setNsPrefix(String.valueOf(value));
						gotIt = true;
					}
				}
				else if ("org.omg.xmi.nsURI".equals(name) && (taggedObject instanceof org.eclipse.uml2.uml.Package)) {
					org.eclipse.ocl.examples.pivot.Package asPackage = converter.getCreated(org.eclipse.ocl.examples.pivot.Package.class, taggedObject);
					if (asPackage != null) {
						asPackage.setNsURI(String.valueOf(value));
						gotIt = true;
					}
				}
				else if ("org.omg.xmi.schemaType".equals(name) && (taggedObject instanceof org.eclipse.uml2.uml.DataType)) {
					DataType asPackage = converter.getCreated(DataType.class, taggedObject);
					if (asPackage != null) {
// FIXME						asPackage.setNsURI(String.valueOf(value));
						System.out.println("Unknown " + ePackage.getNsURI() + "::" + eObject.eClass().getName() + "::" + name + " ignored");
						gotIt = true;
					}
				}
				if (!gotIt) {
					logger.warn("Unknown " + ePackage.getNsURI() + "::" + eObject.eClass().getName() + "::" + name + " ignored");
				}
			}
			return null;
		}
		else if (ePackage.getNsURI().startsWith("http://www.eclipse.org/uml2/schemas/Ecore")) {
			// FIXME
			return null;
		}
		else {
			converter.addStereotypeApplication(eObject);
			return null;
		}
	}

	public <T extends Element, V extends EObject> void doSwitchAll(/*@NonNull*/ Collection<T> pivotObjects, /*@NonNull*/ List<V> eObjects, @Nullable UML2Pivot.Predicate<V> predicate) {
		assert pivotObjects != null;
		assert eObjects != null;
		eObjects.size();
		for (V eObject : eObjects) {
			if ((eObject != null) && ((predicate == null) || predicate.filter(eObject))) {
				@SuppressWarnings("unchecked")
				T pivotObject = (T) doSwitch(eObject);
				if (pivotObject != null) {
					pivotObjects.add(pivotObject);
				}
			}
		}
	}

	public <T extends Element> void doSwitchAll(@NonNull List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			doSwitch(eObject);
		}
	}
}

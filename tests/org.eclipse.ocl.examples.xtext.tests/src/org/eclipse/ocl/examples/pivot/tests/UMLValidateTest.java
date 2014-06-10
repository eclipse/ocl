/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 	E.D.Willink - Bug 306079, 322159, 353171
 *  K.Hussey - Bug 331143
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings("nls")
public class UMLValidateTest extends AbstractValidateTests
{
	public static final @NonNull String VIOLATED_TEMPLATE = "The ''{0}'' constraint is violated on ''{1}''";

	public @Nullable EObject getStereotypeApplication(@NonNull org.eclipse.uml2.uml.Element umlElement, @NonNull org.eclipse.uml2.uml.Stereotype umlStereotype) {
		for (EObject eObject : umlElement.eResource().getContents()) {
			if (DomainUtil.safeEquals(eObject.eClass().getName(), umlStereotype.getName())) {
				for (EStructuralFeature eFeature : eObject.eClass().getEAllStructuralFeatures()) {
					if ((eFeature instanceof EReference) && !eFeature.isMany()) {
						Object object = eObject.eGet(eFeature);
						if (object == umlElement) {
							return eObject;
						}
					}
				}
			}
		}
		return null;
	}
	//
	// Test framework
	//
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EValidator.Registry.INSTANCE.put(null, new OCLinEcoreEObjectValidator());

//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//			"xmi", new EcoreResourceFactoryImpl());		
	}

	@Override
	protected void tearDown() throws Exception {
		EValidator.Registry.INSTANCE.remove(null);
		PivotEnvironmentFactory.disposeGlobalRegistryInstance();
		super.tearDown();
	}

	public void testValidate_Bug417062_uml() throws IOException, InterruptedException, ParserException {
//		EcorePlugin.ExtensionProcessor.process(getClass().getClassLoader());
//		UMLPlugin.ExtensionProcessor.process(getClass().getClassLoader());
//		new UMLPlugin.BodySupportRegistryReader().readRegistry();
		//
		//	Create model
		//
		OCL ocl = OCL.newInstance();
		Resource umlResource = doLoadUML(ocl, "Bug417062");
		org.eclipse.uml2.uml.Model model = (org.eclipse.uml2.uml.Model) umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Class book = (org.eclipse.uml2.uml.Class) model.getOwnedType("Book");
		org.eclipse.uml2.uml.Property price = book.getOwnedAttribute("price", null);
		org.eclipse.uml2.uml.Constraint constraint = book.getOwnedRules().get(0);
//		org.eclipse.uml2.uml.InstanceSpecification validBook = (org.eclipse.uml2.uml.InstanceSpecification) model.getOwnedMember("1) Valid book");
		org.eclipse.uml2.uml.InstanceSpecification invalidBook = (org.eclipse.uml2.uml.InstanceSpecification) model.getOwnedMember("2) Invalid book");
		org.eclipse.uml2.uml.InstanceSpecification partialBook = (org.eclipse.uml2.uml.InstanceSpecification) model.getOwnedMember("3) Book with undefined price");
		org.eclipse.uml2.uml.InstanceSpecification confusingBook = (org.eclipse.uml2.uml.InstanceSpecification) model.getOwnedMember("4) Opaque expressions and other things");
		org.eclipse.uml2.uml.Slot slot = confusingBook.getSlots().get(0);
		org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression) slot.getOwnedElements().get(0);
		Property asPrice = ocl.getMetaModelManager().getPivotOf(Property.class, price);
		assertUMLOCLValidationDiagnostics(ocl, "UML Load", umlResource,
//			DomainUtil.bind(UMLMessages.BodyLanguageSupportError, IllegalStateException.class.getName() + ": " + NLS.bind(UMLMessages.MissingBodyLanguageSupport, "Natural language"), DomainUtil.getLabel(opaqueExpression)),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, book.getName(), constraint.getName(), DomainUtil.getLabel(invalidBook)),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, book.getName(), constraint.getName(), DomainUtil.getLabel(partialBook),
				DomainUtil.bind(EvaluatorMessages.TypedValueRequired, "Real", "OclVoid")),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, book.getName(), constraint.getName(), DomainUtil.getLabel(confusingBook),
				"Failed to evaluate " + asPrice),
			DomainUtil.bind(OCLMessages.ParsingError, DomainUtil.getLabel(opaqueExpression), "No containing resource for 3 + 0.4"));
		ocl.dispose();
	}

	public void test_tutorial_umlValidation_with_lpg_408990() {
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLConstants.OCL_DELEGATE_URI_LPG);
		ResourceSet resourceSet = createResourceSet();
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet));
		}
		URI uri = getProjectFileURI("Bug408990.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		String label = EcoreUtils.qualifiedNameFor(umlResource.getContents().get(1));
		assertValidationDiagnostics("Loading", umlResource, DomainUtil.bind(VIOLATED_TEMPLATE, "Stereotype1::IntegerConstraint", label));
		disposeResourceSet(resourceSet);
	}

	public void test_tutorial_umlValidation_with_pivot_408990() {
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet = createResourceSet();
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet));
		}
		URI uri = getProjectFileURI("Bug408990.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Class umlClass1 = (org.eclipse.uml2.uml.Class)umlModel.getOwnedType("Class1");
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlStereotype1 = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("Stereotype1");
		assert (umlClass1 != null) && (umlStereotype1 != null);
		String label = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlClass1, umlStereotype1));
		assertValidationDiagnostics("Loading", umlResource, DomainUtil.bind(VIOLATED_TEMPLATE, "Stereotype1::IntegerConstraint", label));
		disposeResourceSet(resourceSet);
	}

	public void test_umlValidation_432920() {
		resetRegistries();
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet = createResourceSet();
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet));
		}
		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet);
		URI uri = getProjectFileURI("bug432920.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(validationContext);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Class umlClass1 = (org.eclipse.uml2.uml.Class)umlModel.getOwnedType("Class1");
		org.eclipse.uml2.uml.Property umlAttribute1 = umlClass1.getOwnedAttribute("Attribute1", null);
		org.eclipse.uml2.uml.ValueSpecification lowerValue = umlAttribute1.getLowerValue();
		org.eclipse.uml2.uml.ValueSpecification upperValue = umlAttribute1.getUpperValue();
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlMyClassExtension = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("MyClassExtension");
		org.eclipse.uml2.uml.Stereotype umlMyPropertyExtension = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("MyPropertyExtension");
		assert (lowerValue != null) && (upperValue != null) && (umlMyClassExtension != null) && (umlMyPropertyExtension != null);
		String string1 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(upperValue, umlMyClassExtension));
		String string2 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(upperValue, umlMyPropertyExtension));
		String string3 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(lowerValue, umlMyClassExtension));
		String string4 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(lowerValue, umlMyPropertyExtension));
		String string5 = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlAttribute1, umlMyPropertyExtension));
		assertValidationDiagnostics("Loading", umlResource, validationContext,
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyClassExtension", "ClassConstraint1", string1,
				  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralUnlimitedNatural", "Class")),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyPropertyExtension", "Constraint1", string2,
				  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralUnlimitedNatural", "Property")),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyClassExtension", "ClassConstraint1", string3,
				  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralInteger", "Class")),
			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, "MyPropertyExtension", "Constraint1", string4,
			  DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType, "UML::LiteralInteger", "Property")),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "MyPropertyExtension", "Constraint1", string5),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "MyPropertyExtension", "Constraint2", string2),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "MyPropertyExtension", "Constraint2", string4));
		disposeResourceSet(resourceSet);
	}
	
	public void test_umlValidation_434433() {
		resetRegistries();
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet = createResourceSet();
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet));
		}
		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet);
		URI uri = getProjectFileURI("Bug434433.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(validationContext);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Class umlClass1 = (org.eclipse.uml2.uml.Class)umlModel.getOwnedType("Class1");
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlStereotype1 = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("Stereotype1");
		assert (umlClass1 != null) && (umlStereotype1 != null);
		String label = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlClass1, umlStereotype1));
		assertValidationDiagnostics("Loading", umlResource, validationContext,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Stereotype1", "Constraint3", label));
		disposeResourceSet(resourceSet);
	}
	
	public void test_umlValidation_Bug434356() {
//		UML2Pivot.TYPE_EXTENSIONS.setState(true);
		resetRegistries();
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet = createResourceSet();
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			assertNull(UML2Pivot.initialize(resourceSet));
		}
		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet);
		URI uri = getProjectFileURI("Bug434356.uml");
		Resource umlResource = DomainUtil.nonNullState(resourceSet.getResource(uri, true));
		assertNoResourceErrors("Loading", umlResource);
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(validationContext);
		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		org.eclipse.uml2.uml.Realization umlRealization1 = (org.eclipse.uml2.uml.Realization)umlModel.getPackagedElement("Realization1");
		org.eclipse.uml2.uml.Profile umlProfile = umlModel.getProfileApplications().get(0).getAppliedProfile();
		org.eclipse.uml2.uml.Stereotype umlStereotype1 = (org.eclipse.uml2.uml.Stereotype)umlProfile.getOwnedType("ParentRealization");
		assert (umlRealization1 != null) && (umlStereotype1 != null);
		String label = EcoreUtils.qualifiedNameFor(getStereotypeApplication(umlRealization1, umlStereotype1));
		assertValidationDiagnostics("Loading", umlResource, validationContext,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "ParentRealization", "In case of a ParentRealization relationship, the supplier should be a child of the client", label));
		disposeResourceSet(resourceSet);
	}
	
	public void test_umlValidation_Bug436945() throws IOException {   // This is org.eclipse.ocl.doc/doc/models/1710-m1.uml
//		UML2Pivot.TYPE_EXTENSIONS.setState(true);
//		resetRegistries();
//		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
//		ResourceSet resourceSet = createResourceSet();
//		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
//		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
//		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
//			assertNull(UML2Pivot.initialize(resourceSet));
//		}
//		OCLDelegateDomain.initializePivotOnlyDiagnosticianResourceSet(resourceSet);
//		URI uri = getProjectFileURI("Bug436945.uml");
//		Resource umlResource = DomainUtil.nonNullState(resourceSet.getResource(uri, true));
		OCL ocl = OCL.newInstance();
		@SuppressWarnings("null")@NonNull Resource umlResource = doLoadUML(ocl, "Bug436945");
		assertNoResourceErrors("Loading", umlResource);
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		OCLDelegateDomain.initializePivotOnlyDiagnosticianContext(validationContext);
//		org.eclipse.uml2.uml.Model umlModel = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
		assertValidationDiagnostics("Loading", umlResource, validationContext); //,
//			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "ParentRealization", "In case of a ParentRealization relationship, the supplier should be a child of the client", label));
		assertUMLOCLValidationDiagnostics(ocl, "UML Load", umlResource); //,
//			DomainUtil.bind(UMLMessages.BodyLanguageSupportError, IllegalStateException.class.getName() + ": " + NLS.bind(UMLMessages.MissingBodyLanguageSupport, "Natural language"), DomainUtil.getLabel(opaqueExpression)),
//			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, book.getName(), constraint.getName(), DomainUtil.getLabel(invalidBook)),
//			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, book.getName(), constraint.getName(), DomainUtil.getLabel(partialBook),
//				DomainUtil.bind(EvaluatorMessages.TypedValueRequired, "Real", "OclVoid")),
//			DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, book.getName(), constraint.getName(), DomainUtil.getLabel(confusingBook),
//				"Failed to evaluate " + asPrice),
//			DomainUtil.bind(OCLMessages.ParsingError, DomainUtil.getLabel(opaqueExpression), "No containing namespace for 3 + 0.4"));
		ocl.dispose();
	}
}

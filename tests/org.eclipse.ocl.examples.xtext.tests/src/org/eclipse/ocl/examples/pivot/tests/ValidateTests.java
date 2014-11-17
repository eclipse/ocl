/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.delegate.InvocationBehavior;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.delegate.SettingBehavior;
import org.eclipse.ocl.examples.pivot.delegate.ValidationBehavior;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;
import org.eclipse.ocl.examples.pivot.validation.EcoreOCLEValidator;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLLoader;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.ocl.examples.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Tests that OCL for model validation works.
 */
public class ValidateTests extends AbstractValidateTests
{	
	public static @NonNull List<Diagnostic> assertEcoreOCLValidationDiagnostics(@Nullable OCL ocl, @NonNull String prefix, @NonNull Resource resource, String... messages) {
		Map<Object, Object> validationContext = DomainSubstitutionLabelProvider.createDefaultContext(Diagnostician.INSTANCE);
		if (ocl != null) {
			validationContext.put(OCL.class,  ocl);
		}
		List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
		for (EObject eObject : resource.getContents()) {
			EValidatorRegistryImpl registry = new EValidatorRegistryImpl();
			registry.put(EcorePackage.eINSTANCE, EcoreOCLEValidator.INSTANCE);
			Diagnostician dignostician = new Diagnostician(registry);
			Diagnostic diagnostic = dignostician.validate(eObject, validationContext);
			diagnostics.addAll(diagnostic.getChildren());
		}
		return assertDiagnostics(prefix, diagnostics, messages);
	}

	public Resource doLoadEcore(OCL ocl, String stem) throws IOException {
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		String ecoreName = stem + ".ecore";
		URI ecoreURI = getProjectFileURI(ecoreName);
		Resource ecoreResource = metaModelManager.getExternalResourceSet().getResource(ecoreURI, true);
		return ecoreResource;
	}

	public void testValidate_Bug366229_oclinecore() throws IOException, InterruptedException {
		//
		//	Create model
		//
		OCL ocl1 = OCL.newInstance();
		OCL ocl2 = OCL.newInstance();
		MetaModelManager metaModelManager2 = ocl2.getMetaModelManager();
		Resource ecoreResource = doLoadOCLinEcore(ocl1, "Bug366229");
		metaModelManager2.getExternalResourceSet().getResources().add(ecoreResource);
		ocl1.dispose();
		EPackage overloadsPackage = (EPackage) ecoreResource.getContents().get(0);
		EObject testInstance = eCreate(overloadsPackage, "SubClass");
		//
		//	Check EObjectValidator errors
		//
		EValidator.Registry.INSTANCE.put(overloadsPackage, EObjectValidator.INSTANCE);
		checkValidationDiagnostics(testInstance, Diagnostic.ERROR);
		ocl2.dispose();
	}

	public void testValidate_Bug418551_ecore() throws IOException, InterruptedException {
		//
		//	Create model
		//
		OCL ocl = OCL.newInstance();
		Resource ecoreResource = doLoadEcore(ocl, "Bug418551");
		EPackage temp = (EPackage) ecoreResource.getContents().get(0);
		EClass tester = (EClass) temp.getEClassifier("Tester");
		EOperation badOp = EcoreUtils.getNamedElement(tester.getEOperations(), "badOp");
		//
		//	Check EObjectValidator errors
		//
		checkValidationDiagnostics(temp, Diagnostic.ERROR);
		assertEcoreOCLValidationDiagnostics(ocl, "Ecore Load", ecoreResource,
			DomainUtil.bind(EcoreOCLEValidator.MISSING_DELEGATE, InvocationBehavior.NAME, DomainUtil.getLabel(temp)),
			DomainUtil.bind(EcoreOCLEValidator.MISSING_DELEGATE, SettingBehavior.NAME, DomainUtil.getLabel(temp)),
			DomainUtil.bind(EcoreOCLEValidator.MISSING_DELEGATE, ValidationBehavior.NAME, DomainUtil.getLabel(temp)),
			DomainUtil.bind(EcoreOCLEValidator.MISSING_CONSTRAINTS_ANNOTATION_ENTRY, "extraInvariant", DomainUtil.getLabel(tester)),
			DomainUtil.bind(EcoreOCLEValidator.EXTRA_CONSTRAINTS_ANNOTATION_ENTRY, "missingInvariant", DomainUtil.getLabel(tester)),
			DomainUtil.bind(EcoreOCLEValidator.INCOMPATIBLE_TYPE_2, "String", DomainUtil.getLabel(badOp), "body"),
			DomainUtil.bind(EcoreOCLEValidator.INCOMPATIBLE_TYPE_2, "UnlimitedNatural", DomainUtil.getLabel(badOp), "pre"),
			DomainUtil.bind(EcoreOCLEValidator.INCOMPATIBLE_TYPE_2, "UnlimitedNatural", DomainUtil.getLabel(badOp), "post"),
			DomainUtil.bind(EcoreOCLEValidator.INCOMPATIBLE_TYPE_1, "Boolean", DomainUtil.getLabel(tester.getEStructuralFeature("badType"))),
			DomainUtil.bind(EcoreOCLEValidator.MISSING_PROPERTY_KEY, DomainUtil.getLabel(tester.getEStructuralFeature("badDetailName"))),
			DomainUtil.bind(EcoreOCLEValidator.DOUBLE_PROPERTY_KEY, DomainUtil.getLabel(tester.getEStructuralFeature("derivationAndInitial"))));
		//
		ocl.dispose();
	}

	public void testValidate_Bug418552_oclinecore() throws IOException, InterruptedException {
		String testDocument = 
				"import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';\n" +
				"\n" +
				"package temp : Test = 'http://www.eclipse.org/mdt/ocl/oclinecore/tutorial'\n" +
				"{\n" +
				"	class Tester\n" +
				"	{\n" +
				"		attribute total : ecore::EDoubleObject { derived volatile }\n" +
				"		{\n" +
				"			derivation: true;\n" +
				"		}\n" +
				"	}\n" +
				"}\n";
		createOCLinEcoreFile("Bug418552.oclinecore", testDocument);
		OCL ocl1 = OCL.newInstance();
		MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
		@NonNull List<Diagnostic> diagnostics = doValidateOCLinEcore(ocl1, "Bug418552",
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Property", "CompatibleDefaultExpression", "temp::Tester::total"));
		Object property = diagnostics.get(0).getData().get(0);
		assertEquals(PivotPackage.Literals.PROPERTY, ((EObject)property).eClass());
		ModelElementCS csElement = ElementUtil.getCsElement((Element) property);
		ICompositeNode node = NodeModelUtils.getNode(csElement);
		assert node != null;
		assertEquals(7, node.getStartLine());
		assertEquals(10, node.getEndLine());
		metaModelManager1.dispose();
	}

	public void testValidate_Pivot_ecore() throws IOException, InterruptedException {
		//
		//	Create model
		//
		OCL ocl = OCL.newInstance();
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		URI ecoreURI = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.pivot/model/Pivot.ecore", true);
		Resource ecoreResource = metaModelManager.getExternalResourceSet().getResource(ecoreURI, true);
		//
		//	Check EObjectValidator errors
		//
		EPackage pkg = (EPackage) ecoreResource.getContents().get(0);
		EClass cls = (EClass) pkg.getEClassifier("Element");
		EOperation op = EcoreUtils.getNamedElement(cls.getEOperations(), "allOwnedElements");
		assertEcoreOCLValidationDiagnostics(ocl, "Ecore Load", ecoreResource,
			DomainUtil.bind(EcoreOCLEValidator.INCOMPATIBLE_TYPE_2, "Set(OclElement)", DomainUtil.getLabel(op), "body")); // FIXME BUG 437616 resolve Element/OclElement conflict
		//
		ocl.dispose();
	}

	public void testValidate_OCL_2_5_oclas() throws IOException, InterruptedException {
		ResourceSet resourceSet = new ResourceSetImpl();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {			
			getProjectMap().initializeResourceSet(resourceSet);
		}
		Resource resource = resourceSet.getResource(URI.createPlatformResourceURI("org.eclipse.ocl.examples.library/model-gen/OCL-2.5.oclas", true), true);
		assertNoValidationErrors("Validating", DomainUtil.nonNullState(resource));
	}

	public void testValidate_Pivot_oclas() throws IOException, InterruptedException {
		ResourceSet resourceSet = new ResourceSetImpl();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {			
			getProjectMap().initializeResourceSet(resourceSet);
			OCLASResourceFactory.INSTANCE.configure(resourceSet);
		}
		Resource resource = resourceSet.getResource(URI.createPlatformResourceURI("org.eclipse.ocl.examples.pivot/model-gen/Pivot.oclas", true), true);
		assertNoValidationErrors("Validating", DomainUtil.nonNullState(resource));
	}

	public void testValidate_Validate_completeocl() throws IOException, InterruptedException {
		//
		//	Create model
		//
		//	0 - the complementing type system for the validator
		//	1 - the evolving complemented type system under test
		//	2 - the stable complemented type system under test
		//
		OCL ocl0 = OCL.newInstance();
		OCL ocl1 = OCL.newInstance();
		OCL ocl2 = OCL.newInstance();
		MetaModelManager metaModelManager0 = ocl0.getMetaModelManager();
		MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
		MetaModelManager metaModelManager2 = ocl2.getMetaModelManager();
		Resource ecoreResource1 = doLoadOCLinEcore(ocl1, "Validate");
		Resource ecoreResource2 = doLoadOCLinEcore(ocl2, "Validate");
		EPackage validatePackage1 = DomainUtil.nonNullState((EPackage) ecoreResource1.getContents().get(0));
		EPackage validatePackage2 = DomainUtil.nonNullState((EPackage) ecoreResource2.getContents().get(0));
		URI oclURI = getProjectFileURI("Validate.ocl");
		CompleteOCLEObjectValidator completeOCLEObjectValidator = new CompleteOCLEObjectValidator(validatePackage1, oclURI, metaModelManager0);
		EValidator.Registry.INSTANCE.put(validatePackage1, completeOCLEObjectValidator);
		try {
			EObject testInstance1 = eCreate(validatePackage1, "Level3");
			EObject testInstance2 = eCreate(validatePackage2, "Level3");
			String template = EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_;
			String objectLabel;
			//
			//	No errors
			//
			eSet(testInstance1, "ref", "xx");
			eSet(testInstance1, "l1", "xx");
			eSet(testInstance1, "l2a", "xx");
			eSet(testInstance1, "l2b", "xx");
			eSet(testInstance1, "l3", "xx");
			eSet(testInstance2, "ref", "yy");
			eSet(testInstance2, "l1", "yy");
			eSet(testInstance2, "l2a", "yy");
			eSet(testInstance2, "l2b", "yy");
			eSet(testInstance2, "l3", "yy");
			checkValidationDiagnostics(testInstance1, Diagnostic.WARNING);
			checkValidationDiagnostics(testInstance2, Diagnostic.WARNING);
			//
			//	CompleteOCL errors all round
			//
			eSet(testInstance1, "ref", "xxx");
			eSet(testInstance1, "l1", "xxx");
			eSet(testInstance1, "l2a", "xxx");
			eSet(testInstance1, "l2b", "xxx");
			eSet(testInstance1, "l3", "xxx");
			eSet(testInstance2, "ref", "yyy");
			eSet(testInstance2, "l1", "yyy");
			eSet(testInstance2, "l2a", "yyy");
			eSet(testInstance2, "l2b", "yyy");
			eSet(testInstance2, "l3", "yyy");
			objectLabel = DomainUtil.getLabel(testInstance1);
			checkValidationDiagnostics(testInstance1, Diagnostic.WARNING,
				DomainUtil.bind(template,  "Level1", "V1", objectLabel),
				DomainUtil.bind(template,  "Level2a", "V2a", objectLabel),
				DomainUtil.bind(template,  "Level2b", "V2b", objectLabel),
				DomainUtil.bind(template,  "Level3", "V3", objectLabel));
			checkValidationDiagnostics(testInstance2, Diagnostic.WARNING);
			//
			//	One CompleteOCl and one OCLinEcore
			//
			eSet(testInstance1, "ref", "ok");
			eSet(testInstance1, "l1", "ok");
			eSet(testInstance1, "l2a", "bad");
			eSet(testInstance1, "l2b", "ok");
			eSet(testInstance1, "l3", "ok");
			eSet(testInstance2, "ref", "ok");
			eSet(testInstance2, "l1", "ok");
			eSet(testInstance2, "l2a", "bad");
			eSet(testInstance2, "l2b", "ok");
			eSet(testInstance2, "l3", "ok");
			objectLabel = DomainUtil.getLabel(testInstance1);
			checkValidationDiagnostics(testInstance1, Diagnostic.WARNING,
				DomainUtil.bind(template,  "Level2a", "L2a", objectLabel),
				DomainUtil.bind(template,  "Level2a", "V2a", objectLabel));
			objectLabel = DomainUtil.getLabel(testInstance2);
			checkValidationDiagnostics(testInstance2, Diagnostic.ERROR,
				DomainUtil.bind("The ''{0}'' constraint is violated on ''{1}''", "L2a", "Level3 ok", objectLabel));
		}
		finally {
			metaModelManager0.dispose();
			metaModelManager1.dispose();
			metaModelManager2.dispose();
			EValidator.Registry.INSTANCE.remove(validatePackage1);			
		}
	}

	public void testValidate_Validate_completeocl_loadresource() throws IOException, InterruptedException {		
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet = createResourceSet();
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, null);
		//
		URI ecoreURI = getTestModelURI("model/OCLinEcoreTutorial.ecore");
		URI xmiURI = getTestModelURI("model/OCLinEcoreTutorial.xmi");
		URI oclURI = getProjectFileURI("ExtraOCLinEcoreTutorial.ocl");
		String testDocument = 
				"import '" + ecoreURI.toString() + "'\n" +
				"package tutorial\n" +
				"context Book\n" +
				"inv ExactlyOneCopy: copies=1\n" +
				"endpackage\n";
		createOCLinEcoreFile("ExtraOCLinEcoreTutorial.ocl", testDocument);
		//
		Resource resource = DomainUtil.nonNullState(resourceSet.getResource(xmiURI, true));
		assertValidationDiagnostics("Without Complete OCL", resource, 
			"The 'SufficientCopies' constraint is violated on 'Library lib::Book b2'",
			"The 'AtMostTwoLoans' constraint is violated on 'Library lib::Member m3'",
			"The 'UniqueLoans' constraint is violated on 'Library lib::Member m3'");
		//
		CompleteOCLLoader helper = new CompleteOCLLoader(resourceSet) {
			@Override
			protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
				TestCase.fail(primaryMessage + "\n\t" + detailMessage);
				return false;
			}
		};
		assertTrue(helper.loadMetaModels());
		assertTrue(helper.loadDocument(oclURI));
		helper.installPackages();
		
		assertValidationDiagnostics("Without Complete OCL", resource, 
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Book", "SufficientCopies", "Library lib::Book b2"),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Member", "AtMostTwoLoans", "Library lib::Member m3"),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Member", "UniqueLoans", "Library lib::Member m3"),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Book", "ExactlyOneCopy", "Library lib::Book b2"));
		adapter.getMetaModelManager().dispose();
		disposeResourceSet(resourceSet);
	}

	public void testValidate_Validate_completeocl_Bug422583() throws IOException, InterruptedException {
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet = createResourceSet();
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet);			
		OCLDelegateDomain.initialize(resourceSet, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, null);
		//
		URI umlURI = getProjectFileURI("Names.uml");
		URI oclURI = getProjectFileURI("Bug422583.ocl");
		String testDocument = 
//				"import uml : '" + UMLResource.UML_METAMODEL_URI + "#/'\n" +
//				"import uml : '" + XMI2UMLResource.UML_METAMODEL_NS_URI + "'\n" +
				"import uml : 'http://www.eclipse.org/uml2/5.0.0/UML#/'\n" +
				"package uml\n" +
				"  context Element\n" +
				"  def: alwaysTrue() : Boolean = true\n" +
				"  def: rootFalse() : Boolean = false\n" +
				"  inv IsElement: self.alwaysTrue()\n" +
				"  context Classifier\n" +
				"  def: rootFalse() : Boolean = true\n" +
				"  def: leafFalse() : Boolean = true\n" +
				"  inv IsClassifier: self.alwaysTrue()\n" +
				"  inv IsClassifierWrtLeaf: self.leafFalse()\n" +
				"  context Class\n" +
				"  def: leafFalse() : Boolean = false\n" +
				"  inv IsClass: self.alwaysTrue()\n" +
				"  inv IsClassWrtRoot: self.rootFalse()\n" +
				"  inv IsClassWrtLeaf: self.leafFalse()\n" +
				"endpackage\n";
		createOCLinEcoreFile("Bug422583.ocl", testDocument);
		//
		Resource resource = DomainUtil.nonNullState(resourceSet.getResource(umlURI, true));
		org.eclipse.uml2.uml.Class uNamed = null;
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.uml2.uml.Class) {
				if ("UNamed".equals(((org.eclipse.uml2.uml.Class)eObject).getName())) {
					uNamed = (org.eclipse.uml2.uml.Class)eObject;
					break;
				}
			}
		}
		assert uNamed != null;
		assertValidationDiagnostics("Without Complete OCL", resource);
		//
		CompleteOCLLoader helper = new CompleteOCLLoader(resourceSet) {
			@Override
			protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
				TestCase.fail(primaryMessage + "\n\t" + detailMessage);
				return false;
			}
		};
		assertTrue(helper.loadMetaModels());
		assertTrue(helper.loadDocument(oclURI));
		helper.installPackages();
		String objectLabel1 = DomainUtil.getLabel(uNamed);
//		String objectLabel3 = DomainUtil.getLabel(uNamed.getOwnedAttribute("r", null).getLowerValue());
//		String objectLabel4 = DomainUtil.getLabel(uNamed.getOwnedAttribute("s", null).getLowerValue());
		assertValidationDiagnostics("Without Complete OCL", resource,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Classifier", "IsClassifierWrtLeaf", objectLabel1),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Class", "IsClassWrtLeaf", objectLabel1)/*,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "NamedElement", "visibility_needs_ownership", objectLabel3),	// FIXME BUG 437450
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "NamedElement", "visibility_needs_ownership", objectLabel4)*/);	// FIXME BUG 437450
		adapter.getMetaModelManager().dispose();
		disposeResourceSet(resourceSet);
	}

	@SuppressWarnings("null")
	public void testValidate_Validate_oclinecore() throws IOException, InterruptedException {
		//
		//	Create model
		//
		OCL ocl1 = OCL.newInstance();
		MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
		Resource ecoreResource = doLoadOCLinEcore(ocl1, "Validate");
		MetaModelManagerResourceSetAdapter.getAdapter(ecoreResource.getResourceSet(), metaModelManager1);
		EPackage validatePackage = (EPackage) ecoreResource.getContents().get(0);
		EObject testInstance = eCreate(validatePackage, "Level3");
		eSet(testInstance, "ref", "ref");
		eSet(testInstance, "l1", "l1");
		eSet(testInstance, "l2a", "l2a");
		eSet(testInstance, "l2b", "l2b");
		eSet(testInstance, "l3", "l3");
		String objectLabel = DomainUtil.getLabel(testInstance);
		//
		//	Check EObjectValidator errors
		//
		EValidator.Registry.INSTANCE.put(validatePackage, EObjectValidator.INSTANCE);
		try {
			String template = EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic");
			checkValidationDiagnostics(testInstance, Diagnostic.ERROR,
				DomainUtil.bind(template,  "L1", objectLabel),
				DomainUtil.bind(template,  "L2a", objectLabel),
	//BUG355184		DomainUtil.bind(template,  "L2b", objectLabel),
				DomainUtil.bind(template,  "L3", objectLabel));
			//
			//	Check OCLinEcoreEObjectValidator warnings and distinct message
			//
			EValidator.Registry.INSTANCE.put(validatePackage, new OCLinEcoreEObjectValidator());
			template = EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_;
			checkValidationDiagnostics(testInstance, Diagnostic.WARNING,
				DomainUtil.bind(template, "Level1", "L1", objectLabel),
				DomainUtil.bind(template, "Level2a", "L2a", objectLabel),
	//BUG355184		DomainUtil.bind(template,  "L2b", objectLabel),
				DomainUtil.bind(template, "Level3", "L3", objectLabel));
			//
			//	No errors
			//
			eSet(testInstance, "ref", "ok");
			eSet(testInstance, "l1", "ok");
			eSet(testInstance, "l2a", "ok");
			eSet(testInstance, "l2b", "ok");
			eSet(testInstance, "l3", "ok");
			objectLabel = DomainUtil.getLabel(testInstance);
			checkValidationDiagnostics(testInstance, Diagnostic.WARNING);
			//
			//	Just one error
			//
			eSet(testInstance, "ref", "ok");
			eSet(testInstance, "l1", "bad");
			eSet(testInstance, "l2a", "ok");
			eSet(testInstance, "l2b", "ok");
			eSet(testInstance, "l3", "ok");
			objectLabel = DomainUtil.getLabel(testInstance);
			checkValidationDiagnostics(testInstance, Diagnostic.WARNING,
				DomainUtil.bind(template, "Level1", "L1", objectLabel));
		} finally {
			metaModelManager1.dispose();
			EValidator.Registry.INSTANCE.remove(validatePackage);
		}
	}
}

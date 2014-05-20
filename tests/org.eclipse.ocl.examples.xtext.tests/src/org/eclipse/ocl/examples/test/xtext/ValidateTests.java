/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.completeocl.utilities.CompleteOCLLoader;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.ocl.examples.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Tests that OCL for model validation works.
 */
public class ValidateTests extends AbstractValidateTests
{	
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
			DomainUtil.bind(OCLMessages.ParsingError, DomainUtil.getLabel(opaqueExpression), "No containing namespace for 3 + 0.4"));
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
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet2, null);
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
		Resource resource = DomainUtil.nonNullState(resourceSet2.getResource(xmiURI, true));
		assertValidationDiagnostics("Without Complete OCL", resource, 
			"The 'SufficientCopies' constraint is violated on 'Library lib::Book b2'",
			"The 'AtMostTwoLoans' constraint is violated on 'Library lib::Member m3'",
			"The 'UniqueLoans' constraint is violated on 'Library lib::Member m3'");
		//
		CompleteOCLLoader helper = new CompleteOCLLoader(resourceSet2) {
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
	}

	public void testValidate_Validate_completeocl_Bug422583() throws IOException, InterruptedException {
		CommonOptions.DEFAULT_DELEGATION_MODE.setDefaultValue(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		ResourceSet resourceSet2 = DomainUtil.nonNullState(resourceSet);
		org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(resourceSet2);			
		OCLDelegateDomain.initialize(resourceSet2, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);			
		MetaModelManagerResourceSetAdapter adapter = MetaModelManagerResourceSetAdapter.getAdapter(resourceSet2, null);
		//
		URI umlURI = getProjectFileURI("Names.uml");
		URI oclURI = getProjectFileURI("Bug422583.ocl");
		String testDocument = 
				"import uml : '" + UMLResource.UML_METAMODEL_URI + "#/'\n" +
//				"import '" + XMI2UMLResource.UML_METAMODEL_NS_URI + "'\n" +
//				"import uml : 'http://www.eclipse.org/uml2/4.0.0/UML#/'\n" +
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
		Resource resource = DomainUtil.nonNullState(resourceSet2.getResource(umlURI, true));
		org.eclipse.uml2.uml.NamedElement uNamed = null;
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.uml2.uml.Class) {
				if ("UNamed".equals(((org.eclipse.uml2.uml.Class)eObject).getName())) {
					uNamed = (org.eclipse.uml2.uml.NamedElement)eObject;
					break;
				}
			}
		}
		assertValidationDiagnostics("Without Complete OCL", resource);
		//
		CompleteOCLLoader helper = new CompleteOCLLoader(resourceSet2) {
			@Override
			protected boolean error(@NonNull String primaryMessage, @Nullable String detailMessage) {
				TestCase.fail(primaryMessage + "\n\t" + detailMessage);
				return false;
			}
		};
		assertTrue(helper.loadMetaModels());
		assertTrue(helper.loadDocument(oclURI));
		helper.installPackages();
		String objectLabel = DomainUtil.getLabel(uNamed);
		assertValidationDiagnostics("Without Complete OCL", resource,
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Classifier", "IsClassifierWrtLeaf", objectLabel),
			DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_, "Class", "IsClassWrtLeaf", objectLabel));
		adapter.getMetaModelManager().dispose();
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

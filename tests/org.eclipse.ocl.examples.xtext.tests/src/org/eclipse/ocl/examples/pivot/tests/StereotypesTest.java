/*******************************************************************************
 * Copyright (c) 2012,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.uml.UMLElementExtension;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Tests for stereotype expressions.
 */
@SuppressWarnings({"nls","null"})
public class StereotypesTest extends PivotTestSuite
{
	public class InternationalizedMetamodel
	{
		Resource umlResource;
		org.eclipse.uml2.uml.Package umlRoot;
		Element umlMMM;
		ASResource asResource;
	    Type englishClass;
	    Type frenchClass;
	    Type germanClass;
	    Type languageClass;
	    Type plainClass;
	    Type string;
	    ElementExtension englishClassInEnglish;
	    ElementExtension frenchClassInEnglish;
	    ElementExtension germanClassInEnglish;
	    Stereotype inEnglishStereotype;
	    Stereotype inFrenchStereotype;
	    Stereotype inGermanStereotype;
	    Enumeration face;
	    
	    public InternationalizedMetamodel() throws ParserException {
			URI testModelURI = getTestModelURI("model/InternationalizedClasses.uml");
	        umlResource = resourceSet.getResource(testModelURI, true);
	        umlRoot = (org.eclipse.uml2.uml.Package) umlResource.getContents().get(0);
//	        umlMMM = metaModelManager.getPivotOf(Element.class, umlRoot.eClass());
	        asResource = ocl.uml2pivot(umlResource);
	        umlMMM = metaModelManager.getPivotOf(Element.class, umlRoot.eClass());
	        Root root = (Root) asResource.getContents().get(0);
	        assertNoResourceErrors("Loading model/InternationalizedClasses.uml", asResource);
	        org.eclipse.ocl.examples.pivot.Package modelPackage = DomainUtil.getNamedElement(root.getNestedPackage(), "Model");
	        englishClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "EnglishClass");
	        frenchClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "FrenchClass");
	        germanClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "GermanClass");
	        languageClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "LanguageClass");
	        plainClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "PlainClass");
	        string = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "String");
	        PackageServer profile = metaModelManager.getPackageManager().getPackageByURI("http://www.eclipse.org/ocl/examples/Internationalized");
	        inEnglishStereotype = (Stereotype) profile.getMemberType("InEnglish");
	        inFrenchStereotype = (Stereotype) profile.getMemberType("InFrench");
	        inGermanStereotype = (Stereotype) profile.getMemberType("InGerman");
	        face = (Enumeration) profile.getMemberType("Face");
	        englishClassInEnglish = DomainUtil.getNamedElement(englishClass.getExtension(), "EnglishClass$InEnglish");
	        frenchClassInEnglish = DomainUtil.getNamedElement(frenchClass.getExtension(), "FrenchClass$InFrench");
	        germanClassInEnglish = DomainUtil.getNamedElement(germanClass.getExtension(), "GermanClass$InGerman");
	    }
	}
	
	public class InternationalizedModel
	{
		EClass englishClass;
		EClass frenchClass;
		EClass germanClass;
		EObject englishObject;
		EObject frenchObject;
		EObject germanObject;
	    
	    public InternationalizedModel(InternationalizedMetamodel mm, Resource ecoreModel, Resource model) throws ParserException {
	    	Collection<EPackage> ecorePackages = UMLUtil.convertToEcore(mm.umlRoot, null);
	    	ecoreModel.getContents().addAll(ecorePackages);
	    	for (EPackage ePackage : ecorePackages) {
		    	for (EClassifier eClassifier : ePackage.getEClassifiers()) {
		    		String name = eClassifier.getName();
		    		if ("EnglishClass".equals(name)) {
		    			englishClass = (EClass)eClassifier;
		    		}
		    		else if ("FrenchClass".equals(name)) {
		    			frenchClass = (EClass)eClassifier;
		    		}
		    		else if ("GermanClass".equals(name)) {
		    			germanClass = (EClass)eClassifier;
		    		}
		    	}
	    	}
	    	EFactory eFactoryInstance = englishClass.getEPackage().getEFactoryInstance();
	    	englishObject = eFactoryInstance.create(englishClass);
	    	model.getContents().add(englishObject);
	    	frenchObject = eFactoryInstance.create(frenchClass);
	    	model.getContents().add(frenchObject);
	    	germanObject = eFactoryInstance.create(germanClass);
	    	model.getContents().add(germanObject);
	    }
	}

	InternationalizedMetamodel mm = null;
	InternationalizedModel m = null;
	
    @Override
    protected void setUp() throws Exception {
//		UML2Pivot.ADD_ELEMENT_EXTENSION.setState(true);
//		UML2Pivot.ADD_IMPORTED_RESOURCE.setState(true);
//		UML2Pivot.ADD_PROFILE_APPLICATION.setState(true);
//		UML2Pivot.ADD_TYPE_EXTENSION.setState(true);
//		UML2Pivot.APPLICABLE_STEREOTYPES.setState(true);
//		UML2Pivot.CONVERT_RESOURCE.setState(true);
//		UML2Pivot.TYPE_EXTENSIONS.setState(true);
//		AbstractTypeServer.ADD_BASE_PROPERTY.setState(true);
//		AbstractTypeServer.ADD_EXTENSION_PROPERTY.setState(true);
//		AbstractTypeServer.INIT_MEMBER_PROPERTIES.setState(true);
//    	MetaModelManager.CREATE_MUTABLE_CLONE.setState(true);
        super.setUp();
		ProjectMap.getAdapter(resourceSet);
		OCL.initialize(resourceSet);
		String problem = UML2Pivot.initialize(resourceSet);
		assertNull(problem);
		mm = new InternationalizedMetamodel();
		URI ecoreURI = getTestModelURI("Languages.ecore");
		URI modelURI = getTestModelURI("Languages.xmi");
		Resource ecoreModel = resourceSet.createResource(ecoreURI);
		Resource model = resourceSet.createResource(modelURI);
		m = new InternationalizedModel(mm, ecoreModel, model);
    }

    @Override
	protected void tearDown() throws Exception {
		mm = null;
        super.tearDown();
	}

	/**
     * Tests M1 parsing using base_XXX and extension_YYY.
     */
    public void test_stereotypeM1Navigation() throws Exception {
//		assertValidQuery(mm.englishClass, "self.oclType().extension_Internationalized");
//		assertValidQuery(mm.englishClass, "self.extension_Internationalized");
    	assertSemanticErrorQuery2(mm.englishClass, "self.extension_InEnglish", OCLMessages.UnresolvedProperty_ERROR_, "extension_InEnglish", "Model::EnglishClass");
		assertValidQuery(mm.englishClass, "self.oclType().extension_Internationalized");
//		assertValidQuery(mm.englishClass, "self.oclType().extension_InEnglish");
		assertValidQuery(mm.englishClass, "self.extension_Internationalized.base_Class");
    	assertSemanticErrorQuery2(mm.englishClass, "self.extension_InGerman", OCLMessages.UnresolvedProperty_ERROR_, "extension_InGerman", "Model::EnglishClass");
//xx		assertValidQuery(mm.englishClassInEnglish, "self.base_Class");
//xx		assertValidQuery(mm.englishClassInEnglish, "self.base_Class.extension_InEnglish");
		assertSemanticErrorQuery2(mm.englishClass, "self.getAllAppliedStereotypes()", OCLMessages.UnresolvedOperation_ERROR_, "getAllAppliedStereotypes", "Model::EnglishClass");
		assertSemanticErrorQuery2(mm.englishClass, "self.getAppliedStereotypes()", OCLMessages.UnresolvedOperation_ERROR_, "getAppliedStereotypes", "Model::EnglishClass");
		assertValidQuery(mm.englishClass, "self.oclType().getAppliedStereotypes()");
    }

	/**
     * Tests M2 navigations using base_XXX and extension_YYY.
     */
    public void test_stereotypeM2Navigation() throws Exception {
    	assertQueryEquals(mm.englishClass, "EnglishClass", "self.NamedElement::name");
//    	assertQueryEquals(mm.englishClass, "EnglishClass", "self.name");
    	assertSemanticErrorQuery2(mm.englishClass, "self.extension_InEnglish", OCLMessages.UnresolvedProperty_ERROR_, "extension_InEnglish", "Model::EnglishClass");
    	assertQueryEquals(mm.englishClass, mm.englishClassInEnglish, "self.extension_Internationalized");
    	assertQueryEquals(mm.englishClass, mm.face.getEnumerationLiteral("NORMAL"), "self.extension_Internationalized.face");
    	assertQueryEquals(mm.germanClass, mm.face.getEnumerationLiteral("BOLD"), "self.extension_Internationalized.face");
    	assertQueryEquals(mm.englishClassInEnglish, mm.englishClass, "self.base_Class");
//    	assertQueryEquals(mm.englishClass, "EnglishClass$InEnglish", "self.extension_InEnglish.oclType().instanceType.name");
//    	assertQueryEquals(mm.englishClass, "EnglishClass$InEnglish", "self.extension_Internationalized.oclType().instanceType.name");
//    	assertQueryEquals(mm.englishClass, "EnglishClass$InEnglish", "self.extension_Internationalized.oclType().name");
    	assertSemanticErrorQuery2(mm.englishClass, "self.extension_InGerman", OCLMessages.UnresolvedProperty_ERROR_, "extension_InGerman", "Model::EnglishClass");
    	assertSemanticErrorQuery2(mm.englishClass, "self.extension_Internationalized.extension_InEnglish", OCLMessages.UnresolvedProperty_ERROR_, "extension_InEnglish", "InternationalizedProfile::Internationalized");
    	assertQueryEquals(mm.englishClass, mm.englishClass, "self.extension_Internationalized.base_Class");
    	assertQueryEquals(mm.englishClassInEnglish, mm.englishClassInEnglish, "self.base_Class.extension_Internationalized");
    	assertQueryTrue(mm.englishClass, "extension_Internationalized.base_Class = self");
    	assertQueryTrue(mm.englishClassInEnglish,  "base_Class.extension_Internationalized = self");
    	assertSemanticErrorQuery2(mm.frenchClass, "self.text", OCLMessages.UnresolvedProperty_ERROR_, "text", "Model::FrenchClass");
//    	assertQueryEquals(mm.frenchClass, "Merci", "extension_InFrench.oclType().instanceType.ownedAttribute->any(name='text').default");
//    	assertQueryTrue(mm.frenchClass, "extension_InFrench.oclType().instanceType.ownedAttribute->any(name='text').default = 'Merci'");
    }

    /**
     * Tests allInstances in a stereotyped context.
     */
    public void test_stereotyped_allInstances_382981() {
    	assertQueryEquals(mm.englishClass, idResolver.createSetOfEach(null), "Model::EnglishClass.allInstances()");
//M0
    	assertQueryEquals(m.englishObject, idResolver.createSetOfEach(null, m.englishObject), "EnglishClass.allInstances()");
    	assertQueryEquals(m.englishObject, idResolver.createSetOfEach(null, m.germanObject), "GermanClass.allInstances()");
//M1
    	assertQueryEquals(mm.englishClass, idResolver.createSetOfEach(null), "Model::EnglishClass.allInstances()");
    	assertQueryEquals(mm.englishClass, idResolver.createSetOfEach(null, mm.string, mm.plainClass, mm.englishClass, mm.languageClass, mm.frenchClass, mm.germanClass), "ocl::Class.allInstances()");
    	assertQueryEquals(mm.englishClass, idResolver.createSetOfEach(null, mm.englishClassInEnglish, mm.frenchClassInEnglish, mm.germanClassInEnglish), "ocl::ElementExtension.allInstances()");
    	//
//    	assertQueryEquals(mm.umlMMM, metaModelManager.createSetValueOf(null, mm.string, mm.plainClass, mm.englishClass, mm.languageClass, mm.frenchClass, mm.germanClass), "uml::Stereotype.allInstances()");
//    	assertQueryEquals(metaModelManager.getOclAnyType(), metaModelManager.createSetValueOf(null, mm.string, mm.plainClass, mm.englishClass, mm.languageClass, mm.frenchClass, mm.germanClass), "ocl::Stereotype.allInstances()");
//    	assertQueryEquals(mm.englishClass, getEmptySetValue(), "InEnglish.allInstances()");
    }

    /**
     * Tests getAppliedStereotypes.
     */
    public void test_MDT_UML2_operations_382978() {
    	org.eclipse.uml2.uml.Element uml_EnglishClass = (org.eclipse.uml2.uml.Element)((PivotObjectImpl)mm.englishClass).getETarget();
    	UMLElementExtension uml_EnglishClass_InEnglish = (UMLElementExtension) UMLElementExtension.getUMLElementExtension(mm.inEnglishStereotype, uml_EnglishClass);
    	assertQueryEquals(uml_EnglishClass, uml_EnglishClass_InEnglish, "self.extension_Internationalized");
//M0
    	assertSemanticErrorQuery2(mm.englishClass, "self.getAppliedStereotypes()", OCLMessages.UnresolvedOperation_ERROR_, "getAppliedStereotypes", "Model::EnglishClass");
//    	assertQueryEquals(m.englishObject, idResolver.createSetOfEach(null, ((PivotObjectImpl)mm.inEnglishStereotype).getETarget()), "self.oclType().getAppliedStereotypes()");
//    	assertQueryEquals(m.englishObject, idResolver.createSetOfEach(null, ((PivotObjectImpl)mm.inEnglishStereotype).getETarget()), "self.getAppliedStereotypes()");
//M1
    	assertQueryEquals(uml_EnglishClass, idResolver.createSetOfEach(null, ((PivotObjectImpl)mm.inEnglishStereotype).getETarget()), "self.getAppliedStereotypes()");
    	assertQueryEquals(uml_EnglishClass, ((PivotObjectImpl)mm.inEnglishStereotype).getETarget(), "self.getAppliedStereotype('InternationalizedProfile::InEnglish')");
    	assertQueryEquals(mm.englishClass, mm.englishClassInEnglish, "self.extension_Internationalized");
    	assertQueryEquals(mm.englishClass, mm.englishClassInEnglish, "self.extension_Internationalized.oclAsType(InternationalizedProfile::InEnglish)");
    	assertQueryInvalid(mm.englishClass, "self.extension_Internationalized.oclAsType(InternationalizedProfile::InGerman)", DomainUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType,
    		metaModelManager.getMetaclass(mm.englishClassInEnglish), "InternationalizedProfile::InGerman"), InvalidValueException.class);
    }

	/**
     * Tests M2 parsing and M1 evaluation using enumeration.
     */
    public void test_uml_enums_412685() throws Exception {
    	DomainEnumerationLiteral bold = mm.face.getEnumerationLiteral("BOLD");
		assertQueryTrue(mm.frenchClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::ITALIC)");
		assertQueryTrue(mm.englishClass, "self.extension_Internationalized.face() = InternationalizedProfile::Face::NORMAL");
		assertQueryTrue(mm.englishClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::NORMAL)");
		assertQueryFalse(mm.englishClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::BOLD)");
		assertQueryTrue(mm.englishClass, "self.extension_Internationalized.face = InternationalizedProfile::Face::NORMAL");
		assertQueryFalse(mm.frenchClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::BOLD)");
		assertQueryEquals(mm.germanClass, bold, "self.extension_Internationalized.face");
		assertQueryEquals(mm.germanClass, bold, "self.extension_Internationalized.face()");
    }
}

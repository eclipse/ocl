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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.uml.UMLOCL;
import org.eclipse.ocl.pivot.uml.UMLStandaloneSetup;
import org.eclipse.ocl.pivot.uml.internal.es2as.UML2AS;
import org.eclipse.ocl.pivot.uml.internal.library.UMLElementExtension;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Tests for stereotype expressions.
 */
@SuppressWarnings({"nls","null"})
public class StereotypesTest extends PivotTestSuite
{
	public class InternationalizedProfile
	{
		org.eclipse.uml2.uml.Profile umlProfile;
		org.eclipse.uml2.uml.Stereotype umlInEnglishStereotype;
		org.eclipse.uml2.uml.Stereotype umlInFrenchStereotype;
		org.eclipse.uml2.uml.Stereotype umlInGermanStereotype;
		org.eclipse.uml2.uml.Enumeration umlFace;
        Profile asProfile;
	    Stereotype asInEnglishStereotype;
	    Stereotype asInFrenchStereotype;
	    Stereotype asInGermanStereotype;
	    Enumeration asFace;
	    
	    public InternationalizedProfile(org.eclipse.uml2.uml.Profile umlProfile) throws ParserException {
	    	this.umlProfile = umlProfile;
	        umlInEnglishStereotype = umlProfile.getOwnedStereotype("InEnglish");
	        umlInFrenchStereotype = umlProfile.getOwnedStereotype("InFrench");
	        umlInGermanStereotype = umlProfile.getOwnedStereotype("InGerman");
	        umlFace = (org.eclipse.uml2.uml.Enumeration) umlProfile.getOwnedType("Face");
			MetamodelManager metamodelManager = ocl.getMetamodelManager();
	        asProfile = metamodelManager.getPivotOf(Profile.class, umlProfile);
	        asInEnglishStereotype = metamodelManager.getPivotOf(Stereotype.class, umlInEnglishStereotype);
	        asInFrenchStereotype = metamodelManager.getPivotOf(Stereotype.class, umlInFrenchStereotype);
	        asInGermanStereotype = metamodelManager.getPivotOf(Stereotype.class, umlInGermanStereotype);
	        asFace = metamodelManager.getPivotOf(Enumeration.class, umlFace);
	    }
	}
	
	public class InternationalizedMetamodel
	{
		org.eclipse.uml2.uml.Package umlPackage;
//		ASResource asResource;
		org.eclipse.uml2.uml.Type umlEnglishClass;
		org.eclipse.uml2.uml.Type umlFrenchClass;
		org.eclipse.uml2.uml.Type umlGermanClass;
		org.eclipse.uml2.uml.Type umlLanguageClass;
		org.eclipse.uml2.uml.Type umlPlainClass;
		org.eclipse.uml2.uml.Type umlString;
    	UMLElementExtension umlEnglishClassInEnglish;
    	org.eclipse.ocl.pivot.Class asEnglishClass;
    	org.eclipse.ocl.pivot.Class asFrenchClass;
    	org.eclipse.ocl.pivot.Class asGermanClass;
	    ElementExtension asEnglishClassInEnglish;
	    ElementExtension asFrenchClassInEnglish;
	    ElementExtension asGermanClassInEnglish;
	    
	    public InternationalizedMetamodel(@NonNull InternationalizedProfile mmm, org.eclipse.uml2.uml.Package umlPackage) throws ParserException {
			MetamodelManager metamodelManager = ocl.getMetamodelManager();
	    	this.umlPackage = umlPackage;
//	        umlMMM = metamodelManager.getPivotOf(Element.class, umlRoot.eClass());
//	        asResource = ocl.uml2as(umlResource);
//	        umlMMM = metamodelManager.getPivotOf(Element.class, umlPackage.eClass());
//	        Root root = (Root) asResource.getContents().get(0);
//	        assertNoResourceErrors("Loading model/InternationalizedClasses.uml", asResource);
//	        org.eclipse.ocl.pivot.Package modelPackage = ClassUtil.getNamedElement(root.getNestedPackage(), "Model");
	        umlEnglishClass = umlPackage.getOwnedType("EnglishClass");
	        umlFrenchClass = umlPackage.getOwnedType("FrenchClass");
	        umlGermanClass = umlPackage.getOwnedType("GermanClass");
	        umlLanguageClass = umlPackage.getOwnedType("LanguageClass");
	        umlPlainClass = umlPackage.getOwnedType("PlainClass");
	        umlString = umlPackage.getOwnedType("String");
	        asEnglishClass = metamodelManager.getPivotOf(org.eclipse.ocl.pivot.Class.class, umlEnglishClass);
	        asFrenchClass = metamodelManager.getPivotOf(org.eclipse.ocl.pivot.Class.class, umlFrenchClass);
	        asGermanClass = metamodelManager.getPivotOf(org.eclipse.ocl.pivot.Class.class, umlGermanClass);
	        //
	    	umlEnglishClassInEnglish = (UMLElementExtension) UMLElementExtension.getUMLElementExtension(mmm.asInEnglishStereotype, umlEnglishClass);
	        asEnglishClassInEnglish = NameUtil.getNameable(asEnglishClass.getOwnedExtensions(), "EnglishClass$InEnglish");
	        asFrenchClassInEnglish = NameUtil.getNameable(asFrenchClass.getOwnedExtensions(), "FrenchClass$InFrench");
	        asGermanClassInEnglish = NameUtil.getNameable(asGermanClass.getOwnedExtensions(), "GermanClass$InGerman");
	    }
	}
	
	public class InternationalizedModel
	{
		EClass eEnglishClass;
		EClass eFrenchClass;
		EClass eGermanClass;
		EObject eEnglishObject;
		EObject eFrenchObject;
		EObject eGermanObject;
	    
	    public InternationalizedModel(InternationalizedMetamodel mm, Resource ecoreModel, Resource model) throws ParserException {
	    	Collection<EPackage> ecorePackages = UMLUtil.convertToEcore(mm.umlPackage, null);
	    	ecoreModel.getContents().addAll(ecorePackages);
	    	for (EPackage ePackage : ecorePackages) {
		    	for (EClassifier eClassifier : ePackage.getEClassifiers()) {
		    		String name = eClassifier.getName();
		    		if ("EnglishClass".equals(name)) {
		    			eEnglishClass = (EClass)eClassifier;
		    		}
		    		else if ("FrenchClass".equals(name)) {
		    			eFrenchClass = (EClass)eClassifier;
		    		}
		    		else if ("GermanClass".equals(name)) {
		    			eGermanClass = (EClass)eClassifier;
		    		}
		    	}
	    	}
	    	EFactory eFactoryInstance = eEnglishClass.getEPackage().getEFactoryInstance();
	    	eEnglishObject = eFactoryInstance.create(eEnglishClass);
	    	model.getContents().add(eEnglishObject);
	    	eFrenchObject = eFactoryInstance.create(eFrenchClass);
	    	model.getContents().add(eFrenchObject);
	    	eGermanObject = eFactoryInstance.create(eGermanClass);
	    	model.getContents().add(eGermanObject);
	    }
	}

	InternationalizedProfile mmm = null;
	InternationalizedMetamodel mm = null;
	InternationalizedModel m = null;

	@Override
	protected @NonNull OCL createOCL() {
		return UMLOCL.newInstance();
	}
	
	@Override
	protected MetamodelManager createMetamodelManager() {
		UMLStandaloneSetup.init();
		MetamodelManager metamodelManager = OCL.createEnvironmentFactory(getProjectMap()).getMetamodelManager();
//		XMI252UMLResourceFactoryImpl.install(metamodelManager.getExternalResourceSet(), URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/", true));
		return metamodelManager;
	}
	
    @Override
    protected void setUp() throws Exception {
//		UML2AS.ADD_ELEMENT_EXTENSION.setState(true);
//		UML2AS.ADD_IMPORTED_RESOURCE.setState(true);
//		UML2AS.ADD_PROFILE_APPLICATION.setState(true);
//		UML2AS.ADD_TYPE_EXTENSION.setState(true);
//		UML2AS.APPLICABLE_STEREOTYPES.setState(true);
//		UML2AS.CONVERT_RESOURCE.setState(true);
//		UML2AS.TYPE_EXTENSIONS.setState(true);
//		AbstractTypeServer.ADD_BASE_PROPERTY.setState(true);
//		AbstractTypeServer.ADD_EXTENSION_PROPERTY.setState(true);
//		AbstractTypeServer.INIT_MEMBER_PROPERTIES.setState(true);
//    	MetamodelManager.CREATE_MUTABLE_CLONE.setState(true);
        super.setUp();
		ProjectMap.getAdapter(resourceSet);
		OCL.initialize(resourceSet);
		String problem = UML2AS.initialize(resourceSet);
		assertNull(problem);
		URI testModelURI = getTestModelURI("model/InternationalizedClasses.uml");
        Resource umlResource = resourceSet.getResource(testModelURI, true);
        org.eclipse.uml2.uml.Package umlPackage = (org.eclipse.uml2.uml.Package) umlResource.getContents().get(0);
		URI testProfileURI = getTestModelURI("model/Internationalized.profile.uml");
		org.eclipse.uml2.uml.Profile umlProfile = (org.eclipse.uml2.uml.Profile) resourceSet.getResource(testProfileURI, true).getContents().get(0);
		((UMLOCL)ocl).uml2as(umlResource);				// FIXME BUG 437826 must do full model conversion
		mmm = new InternationalizedProfile(umlProfile);
		mm = new InternationalizedMetamodel(mmm, umlPackage);
		URI ecoreURI = getTestModelURI("Languages.ecore");
		URI modelURI = getTestModelURI("Languages.xmi");
		Resource ecoreModel = resourceSet.createResource(ecoreURI);
		Resource model = resourceSet.createResource(modelURI);
		m = new InternationalizedModel(mm, ecoreModel, model);
    }

    @Override
	protected void tearDown() throws Exception {
		mmm = null;
		mm = null;
		m = null;
        super.tearDown();
	}

	/**
     * Tests M1 parsing using base_XXX and extension_YYY.
     */
    public void test_stereotypeM1Navigation() throws Exception {
//		assertValidQuery(mm.englishClass, "self.oclType().extension_Internationalized");
//		assertValidQuery(mm.englishClass, "self.extension_Internationalized");
    	assertSemanticErrorQuery(mm.asEnglishClass, "self.extension_InEnglish", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Model::EnglishClass", "extension_InEnglish");
		assertValidQuery(mm.asEnglishClass, "self.oclType().extension_Internationalized");
//		assertValidQuery(mm.englishClass, "self.oclType().extension_InEnglish");
		assertValidQuery(mm.asEnglishClass, "self.extension_Internationalized.base_Class");
    	assertSemanticErrorQuery(mm.asEnglishClass, "self.extension_InGerman", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Model::EnglishClass", "extension_InGerman");
//xx		assertValidQuery(mm.englishClassInEnglish, "self.base_Class");
//xx		assertValidQuery(mm.englishClassInEnglish, "self.base_Class.extension_InEnglish");
		assertSemanticErrorQuery(mm.asEnglishClass, "self.getAllAppliedStereotypes()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Model::EnglishClass", "getAllAppliedStereotypes");
		assertSemanticErrorQuery(mm.asEnglishClass, "self.getAppliedStereotypes()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Model::EnglishClass", "getAppliedStereotypes");
//xx		assertValidQuery(mm.asEnglishClass, "self.oclType().getAppliedStereotypes()");
    }

	/**
     * Tests M2 navigations using base_XXX and extension_YYY.
     */
    public void test_stereotypeM2Navigation() throws Exception {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
    	assertQueryEquals(mm.umlEnglishClass, "EnglishClass", "self.NamedElement::name");
    	assertQueryEquals(mm.umlEnglishClass, "EnglishClass", "self.name");
//    	assertQueryEquals(mm.asEnglishClass, "EnglishClass", "self.NamedElement::name");	// FIXME fails because wrong NamedElement::name chosen
//    	assertQueryEquals(mm.asEnglishClass, "EnglishClass", "self.name");
    	assertSemanticErrorQuery(mm.asEnglishClass, "self.extension_InEnglish", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Model::EnglishClass", "extension_InEnglish");
    	assertQueryEquals(mm.umlEnglishClass, mm.umlEnglishClassInEnglish, "self.extension_Internationalized");
    	assertQueryEquals(mm.umlEnglishClass, mmm.umlFace.getOwnedLiteral("NORMAL"), "self.extension_Internationalized.face");
    	assertQueryEquals(mm.umlGermanClass, mmm.umlFace.getOwnedLiteral("BOLD"), "self.extension_Internationalized.face");
    	assertQueryEquals(mm.umlEnglishClassInEnglish, mm.umlEnglishClass, "self.base_Class");
    	assertQueryEquals(mm.asEnglishClassInEnglish, mm.asEnglishClass, "self.base_Class");
    	assertQueryEquals(mm.umlEnglishClass, "InEnglish", "self.extension_Internationalized.oclType().name");
//    	assertQueryEquals(mm.asEnglishClass, "InEnglish", "self.extension_Internationalized.oclType().name");
//    	assertQueryEquals(mm.englishClass, "EnglishClass$InEnglish", "self.extension_Internationalized.oclType().instanceType.name");
//    	assertQueryEquals(mm.englishClass, "EnglishClass$InEnglish", "self.extension_Internationalized.oclType().name");
    	assertSemanticErrorQuery(mm.asEnglishClass, "self.extension_InGerman", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Model::EnglishClass", "extension_InGerman");
    	assertSemanticErrorQuery(metamodelManager.getIdResolver().getStaticTypeOf(mm.umlEnglishClass), "self.extension_Internationalized.extension_InEnglish", PivotMessagesInternal.UnresolvedProperty_ERROR_, "InternationalizedProfile::Internationalized", "extension_InEnglish");
    	assertSemanticErrorQuery(/*metamodelManager.getMetaclass(*/mm.asEnglishClass/*)*/, "self.extension_Internationalized.extension_InEnglish", PivotMessagesInternal.UnresolvedProperty_ERROR_, "InternationalizedProfile::Internationalized", "extension_InEnglish");
    	assertQueryEquals(mm.umlEnglishClass, mm.umlEnglishClassInEnglish, "self.extension_Internationalized");
    	assertQueryEquals(mm.asEnglishClass, mm.asEnglishClassInEnglish, "self.extension_Internationalized");
    	assertQueryEquals(mm.umlEnglishClass, mm.umlEnglishClass, "self.extension_Internationalized.base_Class");
    	assertQueryEquals(mm.asEnglishClass, mm.asEnglishClass, "self.extension_Internationalized.base_Class");
    	assertQueryEquals(mm.umlEnglishClassInEnglish, mm.umlEnglishClassInEnglish, "self.base_Class.extension_Internationalized");
    	assertQueryEquals(mm.asEnglishClassInEnglish, mm.asEnglishClassInEnglish, "self.base_Class.extension_Internationalized");
    	assertQueryTrue(mm.umlEnglishClass, "extension_Internationalized.base_Class = self");
    	assertQueryTrue(mm.asEnglishClassInEnglish,  "base_Class.extension_Internationalized = self");
    	assertSemanticErrorQuery(mm.asFrenchClass, "self.text", PivotMessagesInternal.UnresolvedProperty_ERROR_, "Model::FrenchClass", "text");
//    	assertQueryEquals(mm.frenchClass, "Merci", "extension_InFrench.oclType().instanceType.ownedAttribute->any(name='text').default");
//    	assertQueryTrue(mm.frenchClass, "extension_InFrench.oclType().instanceType.ownedAttribute->any(name='text').default = 'Merci'");
    }

    /**
     * Tests allInstances in a stereotyped context.
     */
    public void test_stereotyped_allInstances_382981() {
		IdResolver idResolver = ocl.getIdResolver();
//M0
    	assertQueryEquals(m.eEnglishObject, idResolver.createSetOfEach(null, m.eEnglishObject), "EnglishClass.allInstances()");
    	assertQueryEquals(m.eEnglishObject, idResolver.createSetOfEach(null, m.eGermanObject), "GermanClass.allInstances()");
//M1
    	assertQueryEquals(mm.umlEnglishClass, idResolver.createSetOfEach(null), "Model::EnglishClass.allInstances()");
    	assertQueryEquals(mm.umlEnglishClass, idResolver.createSetOfEach(null, mm.umlPlainClass, mm.umlEnglishClass, mm.umlLanguageClass, mm.umlFrenchClass, mm.umlGermanClass), "Class.allInstances()");
    	assertQueryEquals(mm.asEnglishClass, idResolver.createSetOfEach(null, mm.asEnglishClassInEnglish, mm.asFrenchClassInEnglish, mm.asGermanClassInEnglish), "ocl::ElementExtension.allInstances()");
    	//
//    	assertQueryEquals(mm.umlMMM, metamodelManager.createSetValueOf(null, mm.string, mm.plainClass, mm.englishClass, mm.languageClass, mm.frenchClass, mm.germanClass), "uml::Stereotype.allInstances()");
//    	assertQueryEquals(metamodelManager.getOclAnyType(), metamodelManager.createSetValueOf(null, mm.string, mm.plainClass, mm.englishClass, mm.languageClass, mm.frenchClass, mm.germanClass), "ocl::Stereotype.allInstances()");
//    	assertQueryEquals(mm.englishClass, getEmptySetValue(), "InEnglish.allInstances()");
    }

    /**
     * Tests getAppliedStereotypes.
     */
    public void test_MDT_UML2_operations_382978() {
		IdResolver idResolver = ocl.getIdResolver();
//    	assertQueryEquals(mm.asEnglishClass, mm.asEnglishClassInEnglish, "self.extension_Internationalized");
//    	org.eclipse.uml2.uml.Element uml_EnglishClass = (org.eclipse.uml2.uml.Element)((PivotObjectImpl)mm.umlEnglishClass).getETarget();
//M0
    	assertSemanticErrorQuery(mm.asEnglishClass, "self.getAppliedStereotypes()", PivotMessagesInternal.UnresolvedOperation_ERROR_, "Model::EnglishClass", "getAppliedStereotypes");
//    	assertQueryEquals(m.englishObject, idResolver.createSetOfEach(null, ((PivotObjectImpl)mm.inEnglishStereotype).getETarget()), "self.oclType().getAppliedStereotypes()");
//    	assertQueryEquals(m.englishObject, idResolver.createSetOfEach(null, ((PivotObjectImpl)mm.inEnglishStereotype).getETarget()), "self.getAppliedStereotypes()");
//M1
    	assertQueryEquals(mm.umlEnglishClass, idResolver.createSetOfEach(null, ((PivotObjectImpl)mmm.asInEnglishStereotype).getETarget()), "self.getAppliedStereotypes()");
    	assertQueryEquals(mm.umlEnglishClass, ((PivotObjectImpl)mmm.asInEnglishStereotype).getETarget(), "self.getAppliedStereotype('InternationalizedProfile::InEnglish')");
    	assertQueryEquals(mm.asEnglishClass, mm.asEnglishClassInEnglish, "self.extension_Internationalized");
    	assertQueryEquals(mm.umlEnglishClass, mm.umlEnglishClassInEnglish, "self.extension_Internationalized");
    	assertQueryEquals(mm.umlEnglishClass, mm.umlEnglishClassInEnglish, "self.extension_Internationalized.oclAsType(InternationalizedProfile::InEnglish)");
//    	assertQueryInvalid(mm.umlEnglishClass, "self.extension_Internationalized.oclAsType(InternationalizedProfile::InGerman)", ClassUtil.bind(EvaluatorMessages.IncompatibleOclAsTypeSourceType,
//    		metamodelManager.getMetaclass(mm.asEnglishClassInEnglish), "InternationalizedProfile::InGerman"), InvalidValueException.class);
    	assertQueryInvalid(mm.umlEnglishClass, "self.extension_Internationalized.oclAsType(InternationalizedProfile::InGerman)", StringUtil.bind(PivotMessages.IncompatibleOclAsTypeSourceType,
    		mmm.asInEnglishStereotype, "InternationalizedProfile::InGerman"), InvalidValueException.class);
    }

	/**
     * Tests M2 parsing and M1 evaluation using enumeration.
     */
    public void test_uml_enums_412685() throws Exception {
    	EnumerationLiteral asBold = mmm.asFace.getEnumerationLiteral("BOLD");
    	org.eclipse.uml2.uml.EnumerationLiteral umlBold = mmm.umlFace.getOwnedLiteral("BOLD");
//
		assertQueryEquals(mm.asGermanClass, asBold, "InternationalizedProfile::Face::BOLD");
		assertQueryEquals(mm.umlGermanClass, umlBold, "InternationalizedProfile::Face::BOLD");
		assertQueryEquals(mm.asGermanClass, asBold, "self.extension_Internationalized.face");
		assertQueryEquals(mm.umlGermanClass, umlBold, "self.extension_Internationalized.face");
		assertQueryTrue(mm.asFrenchClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::ITALIC)");
		assertQueryTrue(mm.umlFrenchClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::ITALIC)");
		assertQueryTrue(mm.asEnglishClass, "self.extension_Internationalized.face() = InternationalizedProfile::Face::NORMAL");
		assertQueryTrue(mm.umlEnglishClass, "self.extension_Internationalized.face() = InternationalizedProfile::Face::NORMAL");
		assertQueryTrue(mm.asEnglishClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::NORMAL)");
		assertQueryTrue(mm.umlEnglishClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::NORMAL)");
		assertQueryFalse(mm.asEnglishClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::BOLD)");
		assertQueryFalse(mm.umlEnglishClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::BOLD)");
		assertQueryTrue(mm.asEnglishClass, "self.extension_Internationalized.face = InternationalizedProfile::Face::NORMAL");
		assertQueryTrue(mm.umlEnglishClass, "self.extension_Internationalized.face = InternationalizedProfile::Face::NORMAL");
		assertQueryFalse(mm.asFrenchClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::BOLD)");
		assertQueryFalse(mm.umlFrenchClass, "self.extension_Internationalized.isFace(InternationalizedProfile::Face::BOLD)");
		assertQueryEquals(mm.asGermanClass, asBold/*umlBold*/, "self.extension_Internationalized.face");
		assertQueryEquals(mm.umlGermanClass, umlBold, "self.extension_Internationalized.face");
		assertQueryEquals(mm.asGermanClass, asBold/*umlBold*/, "self.extension_Internationalized.face()");
		assertQueryEquals(mm.umlGermanClass, umlBold, "self.extension_Internationalized.face()");
    }
}

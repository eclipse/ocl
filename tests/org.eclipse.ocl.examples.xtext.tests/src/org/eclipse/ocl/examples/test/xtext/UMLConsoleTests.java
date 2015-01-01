/*******************************************************************************
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 382981
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.uml.internal.utilities.UMLEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * Tests that exercise the Xtext OCL Console using a UML model.
 */
public class UMLConsoleTests extends AbstractConsoleTests
{	
	public void testConsole_Bug419556() throws Exception {
		OCL ocl = OCL.newInstance(new UMLEnvironmentFactory(null, null));
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		ResourceSet resourceSet = metamodelManager.getExternalResourceSet();

		URI testModelURI = getProjectFileURI("Bug419556.uml");
        Resource umlResource = resourceSet.getResource(testModelURI, true);
        org.eclipse.uml2.uml.Model model = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
        org.eclipse.uml2.uml.Class class1 = (org.eclipse.uml2.uml.Class)model.getOwnedType("Class1");
        org.eclipse.uml2.uml.Property attribute1 = class1.getOwnedAttribute("Attribute1", null);
        //
		assertConsoleResult(consolePage, class1, "self.extension_Stereotype3", "Class1$Stereotype3\n");
		//
		assertConsoleResult(consolePage, attribute1, "self.extension_Stereotype1", "Attribute1$Stereotype1\n");		// Bug 419557
		assertConsoleResult(consolePage, attribute1, "self.extension_Stereotype2", "<error>null\n</error>");
		//
		consolePage.cancelValidation();
		ocl.dispose();
	}

	public void testConsole_Bug437715() throws Exception {
		OCL ocl = OCL.newInstance(new UMLEnvironmentFactory(null, null));
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		ResourceSet resourceSet = metamodelManager.getExternalResourceSet();

		URI testModelURI = getProjectFileURI("Bug437715.uml");
        Resource umlResource = resourceSet.getResource(testModelURI, true);
        org.eclipse.uml2.uml.Model model = (org.eclipse.uml2.uml.Model)umlResource.getContents().get(0);
        org.eclipse.uml2.uml.Class class1 = (org.eclipse.uml2.uml.Class)model.getOwnedType("Class1");
        org.eclipse.uml2.uml.Class class2 = (org.eclipse.uml2.uml.Class)model.getOwnedType("Class2");
//        org.eclipse.uml2.uml.Property attribute1 = class1.getOwnedAttribute("Attribute1", null);
        //
		assertConsoleResult(consolePage, class1, "self.extension_Stereotype1.stereotype2", "«Stereotype2»model::Class2\n");
		assertConsoleResult(consolePage, class2, "self.extension_Stereotype2.stereotype1", "«Stereotype1»model::Class1\n");
		//
//		assertConsoleResult(consolePage, attribute1, "self.extension_Stereotype1", "Attribute1$Stereotype1\n");		// Bug 419557
//		assertConsoleResult(consolePage, attribute1, "self.extension_Stereotype2", "<error>null\n</error>");
		//
		consolePage.cancelValidation();
		ocl.dispose();
	}

	@SuppressWarnings({"unused"})
	public void testConsole_UML() throws Exception {
		OCL ocl = OCL.newInstance(new UMLEnvironmentFactory(null, null));
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		ResourceSet resourceSet = metamodelManager.getExternalResourceSet();

        Resource umlResource = resourceSet.getResource(getTestModelURI("model/InternationalizedClasses.uml"), true);
        Resource umlProfileResource = resourceSet.getResource(getTestModelURI("model/Internationalized.profile.uml"), true);
//        ASResource asResource = ocl.uml2as(umlResource);
//        Root root = (Root) asResource.getContents().get(0);
//        org.eclipse.ocl.pivot.Package modelPackage = ClassUtil.getNamedElement(root.getNestedPackage(), "Model");
        org.eclipse.uml2.uml.Package umlPackage = (org.eclipse.uml2.uml.Package) umlResource.getContents().get(0);
        org.eclipse.uml2.uml.Type umlEnglishClass = umlPackage.getOwnedType("EnglishClass");
        org.eclipse.uml2.uml.Profile umlProfile = (org.eclipse.uml2.uml.Profile) umlProfileResource.getContents().get(0);
        org.eclipse.uml2.uml.Stereotype umlInEnglishStereotype = umlProfile.getOwnedStereotype("InEnglish");
        org.eclipse.uml2.uml.Stereotype umlInFrenchStereotype = umlProfile.getOwnedStereotype("InFrench");
        org.eclipse.uml2.uml.Stereotype umlInGermanStereotype = umlProfile.getOwnedStereotype("InGerman");
        Type asEnglishClass = metamodelManager.getPivotOf(Type.class, umlEnglishClass);
//        Type englishClass = ClassUtil.getNamedElement(modelPackage.getOwnedType(), "EnglishClass");
//        Type frenchClass = ClassUtil.getNamedElement(modelPackage.getOwnedType(), "FrenchClass");
//        Type germanClass = ClassUtil.getNamedElement(modelPackage.getOwnedType(), "GermanClass");
//        Type plainClass = ClassUtil.getNamedElement(modelPackage.getOwnedType(), "PlainClass");
//        PackageServer profile = metamodelManager.getPackageManager().getPackageByURI("http://www.eclipse.org/ocl/examples/Internationalized");
//        Type inEnglishStereotype = profile.getMemberType("InEnglish");
//        Type inFrenchStereotype = profile.getMemberType("InFrench");
//        Type inGermanStereotype = profile.getMemberType("InGerman");
//        ElementExtension englishClassInEnglish = ClassUtil.getNamedElement(englishClass.getExtension(), "EnglishClass$InEnglish");
        //
		assertConsoleResult(consolePage, umlEnglishClass, "self.name", "'EnglishClass'\n");
		// allInstances
		assertConsoleResult(consolePage, umlEnglishClass, "Stereotype.allInstances()->sortedBy(name)", "");		// Tests Bug 382981
		assertConsoleResult(consolePage, umlInEnglishStereotype, "Stereotype.allInstances()->sortedBy(name)", "InternationalizedProfile::InEnglish\nInternationalizedProfile::InFrench\nInternationalizedProfile::InGerman\nInternationalizedProfile::Internationalized\n");
		assertConsoleResult(consolePage, umlEnglishClass, "Class.allInstances()->sortedBy(name)", "Model::EnglishClass\nModel::FrenchClass\nModel::GermanClass\nModel::LanguageClass\nModel::PlainClass\n");
		assertConsoleResult(consolePage, asEnglishClass, "ocl::Class.allInstances()->sortedBy(name)", "Model::EnglishClass\nEnglishClass$InEnglish\nModel::FrenchClass\nFrenchClass$InFrench\nModel::GermanClass\nGermanClass$InGerman\nModel::LanguageClass\nModel::PlainClass\nString\n");
		//
		consolePage.cancelValidation();
		ocl.dispose();
	}
}

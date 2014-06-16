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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.resource.ASResource;

/**
 * Tests that exercise the Xtext OCL Console using a UML model.
 */
public class UMLConsoleTests extends AbstractConsoleTests
{	
	public void testConsole_Bug419556() throws Exception {
		OCL ocl = OCL.newInstance();
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();

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
		ocl.dispose();
	}

	@SuppressWarnings({"null", "unused"})
	public void testConsole_UML() throws Exception {
		OCL ocl = OCL.newInstance();
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();

		URI testModelURI = getTestModelURI("model/InternationalizedClasses.uml");
        Resource umlResource = resourceSet.getResource(testModelURI, true);
        ASResource asResource = ocl.uml2pivot(umlResource);
        Root root = (Root) asResource.getContents().get(0);
        org.eclipse.ocl.examples.pivot.Package modelPackage = DomainUtil.getNamedElement(root.getNestedPackage(), "Model");
        Type englishClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "EnglishClass");
        Type frenchClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "FrenchClass");
        Type germanClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "GermanClass");
        Type plainClass = DomainUtil.getNamedElement(modelPackage.getOwnedType(), "PlainClass");
        PackageServer profile = metaModelManager.getPackageManager().getPackageByURI("http://www.eclipse.org/ocl/examples/Internationalized");
        Type inEnglishStereotype = profile.getMemberType("InEnglish");
        Type inFrenchStereotype = profile.getMemberType("InFrench");
        Type inGermanStereotype = profile.getMemberType("InGerman");
        ElementExtension englishClassInEnglish = DomainUtil.getNamedElement(englishClass.getExtension(), "EnglishClass$InEnglish");
        //
		assertConsoleResult(consolePage, englishClass, "self.name", "'EnglishClass'\n");
		// allInstances
		assertConsoleResult(consolePage, englishClass.getETarget(), "Stereotype.allInstances()->sortedBy(name)", "");		// Tests Bug 392981
		assertConsoleResult(consolePage, englishClass, "Stereotype.allInstances()->sortedBy(name)", "");
		assertConsoleResult(consolePage, inEnglishStereotype, "Stereotype.allInstances()->sortedBy(name)", "InternationalizedProfile::InEnglish\nInternationalizedProfile::InFrench\nInternationalizedProfile::InGerman\nInternationalizedProfile::Internationalized\n");
		assertConsoleResult(consolePage, englishClass, "Class.allInstances()->sortedBy(name)", "Model::EnglishClass\nModel::FrenchClass\nModel::GermanClass\nModel::LanguageClass\nModel::PlainClass\nString\n");
		//
		ocl.dispose();
	}
}

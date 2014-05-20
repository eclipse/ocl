/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.uml25.XMI252UMLResourceFactoryImpl;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
@SuppressWarnings("null")
public class UML25LoadTests extends LoadTests
{		
//	public void testLoad_UML_ecore() throws IOException, InterruptedException {
//		doLoadEcore(URI.createPlatformResourceURI("/org.eclipse.uml2.uml/model/UML.ecore", true));
//	}
	
//	public void testLoad_UML_2_5() throws IOException, InterruptedException, ParserException {
//		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-12-Jun-2012/UMLDI.xmi", true);
//		doLoadUML(uml_2_5);
//	}
	
	public void testLoad_UML_2_5_Beta_PrimitiveTypes() throws IOException, InterruptedException, ParserException {
		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-2.5-Beta/PrimitiveTypes.xmi", true);
		doLoadUML(uml_2_5, true, true, true);
	}
	
/*	public void testLoad_UML_2_5_Beta_UML() throws IOException, InterruptedException, ParserException {
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/MOF/20110701", UMLPackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-2.5-Beta-Edited/UML.uml", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
/*	public void testLoad_UML_2_5_Beta_XMI() throws IOException, InterruptedException, ParserException {
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/MOF/20110701", UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-2.5-Beta/UML.xmi", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
/*	public void testLoad_UML_2_5_22Sep2013_PrimitiveTypes() throws IOException, InterruptedException, ParserException {
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-22-Sep-2013-Edited/PrimitiveTypes.uml", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
/*	public void testLoad_UML_2_5_22Sep2013_DC() throws IOException, InterruptedException, ParserException {
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-22-Sep-2013-Edited/DC.uml", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
/*	public void testLoad_UML_2_5_22Sep2013_DI() throws IOException, InterruptedException, ParserException {
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-22-Sep-2013-Edited/DI.uml", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
/*	public void testLoad_UML_2_5_22Sep2013_UML() throws IOException, InterruptedException, ParserException {
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/MOF/20110701", UMLPackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-22-Sep-2013-Edited/UML.uml", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
/*	public void testLoad_UML_2_5_22Sep2013_UMLDI() throws IOException, InterruptedException, ParserException {
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/MOF/20110701", UMLPackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-22-Sep-2013-Edited/UMLDI.uml", true);
		doLoadUML(uml_2_5, true, true);
	} */

	// DI.xmi is missing
/*	public void testLoad_UML_2_5_Beta_UMLDI() throws IOException, InterruptedException, ParserException {
		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20120801", UMLPackage.eINSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-2.5-Beta/UMLDI.xmi", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
/*	public void testLoad_UML_2_5_Final_PrimitiveTypes2() throws IOException, InterruptedException, ParserException {
		URIConverter.URI_MAP.put(URI.createURI("http://www.omg.org/spec/UML/20131001/PrimitiveTypes.xmi"), URI.createPlatformResourceURI("/UML-2.5/XMI-2.5-Final/PrimitiveTypes.xmi", true));
		URIConverter.URI_MAP.put(URI.createURI("http://www.omg.org/spec/UML/20131001/PrimitiveTypes.xmi"), URI.createPlatformResourceURI("/UML-2.5/XMI-2.5-Final/PrimitiveTypes.xmi", true));
//		EPackage.Registry.INSTANCE.put("http://www.omg.org/spec/UML/20131001", UMLPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
		URI uml_2_5 = URI.createPlatformResourceURI("/UML-2.5/XMI-2.5-Final/PrimitiveTypes.xmi", true);
		doLoadUML(uml_2_5, true, true);
	} */
	
	@Override
	protected MetaModelManager createMetaModelManager() {
		MetaModelManager metaModelManager = super.createMetaModelManager();
		XMI252UMLResourceFactoryImpl.install(metaModelManager.getExternalResourceSet(), URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/", true));
		return metaModelManager;
	}
	
	@Override
	protected ResourceSet createResourceSet() {
		ResourceSet resourceSet = super.createResourceSet();
		XMI252UMLResourceFactoryImpl.install(resourceSet, URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/", true));
		return resourceSet;
	}

	public void testLoad_UML_2_5_Final_PrimitiveTypes() throws IOException, InterruptedException, ParserException {
		URI uml_2_5 = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/PrimitiveTypes.xmi", true);
		doLoadUML(uml_2_5, true, true, true);
	}

/* FIXME passes by itself but corrupts later tests
	public void testLoad_UML_2_5_Final_UML() throws IOException, InterruptedException, ParserException {
		if (metaModelManager == null) {
			metaModelManager = new MetaModelManager();
		}
		final MetaModelManager metaModelManager = this.metaModelManager;
		metaModelManager.setAutoLoadASMetamodel(false);
		StandardLibraryContribution.REGISTRY.put(XMI2UMLResource.UML_METAMODEL_NS_URI, new OCLstdlib.Loader());
		URI uml_2_5 = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/UML.xmi", true);
		doLoadUML(uml_2_5, true, true, true);
		StandardLibraryContribution.REGISTRY.put(XMI2UMLResource.UML_METAMODEL_NS_URI, new OCLstdlib.RenamingLoader(XMI2UMLResource.UML_METAMODEL_NS_URI));
		this.metaModelManager.dispose();
		this.metaModelManager = null;
	} */

/* FIXME 2 OperationReturnCompatibility warnings
	public void testLoad_Eclipse_UML_2_5() throws IOException, InterruptedException, ParserException {
		if (metaModelManager == null) {
			metaModelManager = new MetaModelManager();
		}
		final MetaModelManager metaModelManager = this.metaModelManager;
		metaModelManager.setAutoLoadASMetamodel(false);
		StandardLibraryContribution.REGISTRY.put(XMI2UMLResource.UML_METAMODEL_NS_URI, new OCLstdlib.Loader());
		URI uml_2_5 = URI.createURI(UMLResource.UML_METAMODEL_URI, true);
		doLoadUML(uml_2_5, true, true, true);
		StandardLibraryContribution.REGISTRY.put(XMI2UMLResource.UML_METAMODEL_NS_URI, new OCLstdlib.RenamingLoader(XMI2UMLResource.UML_METAMODEL_NS_URI));
		this.metaModelManager.dispose();
		this.metaModelManager = null;
	} */
	
	public void testLoad_UML_2_5_Final_DC() throws IOException, InterruptedException, ParserException {
		URI uml_2_5 = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/DC.xmi", true);
		doLoadUML(uml_2_5, true, true, true);
	}
	
	public void testLoad_UML_2_5_Final_DI() throws IOException, InterruptedException, ParserException {
		URI uml_2_5 = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/DI.xmi", true);
		doLoadUML(uml_2_5, true, true, true);
	}
	
	public void testLoad_UML_2_5_Final_DG() throws IOException, InterruptedException, ParserException {
		URI uml_2_5 = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/DG.xmi", true);
		doLoadUML(uml_2_5, true, true, true);
	}
	
	public void testLoad_UML_2_5_Final_UMLDI() throws IOException, InterruptedException, ParserException {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		URI uml_2_5 = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/UMLDI.xmi", true);
		doLoadUML(uml_2_5, true, true, false);		// FIXME BUG 419132 eliminate last argument; always true
	}
	
	public void testLoad_UML_2_5_Final_StandardProfile() throws IOException, InterruptedException, ParserException {
		URI uml_2_5 = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/StandardProfile.xmi", true);
		doLoadUML(uml_2_5, true, true, true);
	}
}

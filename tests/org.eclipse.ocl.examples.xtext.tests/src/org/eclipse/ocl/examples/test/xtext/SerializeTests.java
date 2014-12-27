/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCL;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.manager.MetaModelManagerResourceAdapter;
import org.eclipse.ocl.pivot.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.uml.UML2AS;
import org.eclipse.ocl.pivot.utilities.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.StandaloneProjectMap.IPackageDescriptor;
import org.eclipse.ocl.pivot.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class SerializeTests extends XtextTestCase
{
	protected interface ResourceSetInitializer
	{
		void initializeResourceSet(@NonNull ResourceSet resourceSet);
	}

	protected Map<Object, Object> createLoadedEcoreOptions() {
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(ResourceSetInitializer.class, new ResourceSetInitializer()
		{
			public void initializeResourceSet(@NonNull ResourceSet resourceSet) {
				IProjectDescriptor projectDescriptor = getProjectMap().getProjectDescriptor("org.eclipse.emf.ecore");
				if (projectDescriptor != null) {
					@SuppressWarnings("null")@NonNull URI ecoreURI = URI.createURI(EcorePackage.eNS_URI);
					IPackageDescriptor packageDescriptor = projectDescriptor.getPackageDescriptor(ecoreURI);
					if (packageDescriptor != null) {
						packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadGeneratedPackageStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
					}
				}
			}
		});
		return options;
	}

	public XtextResource doSerialize(@NonNull String stem) throws Exception {
		return doSerialize(stem, stem, null, true, true);
	}
	public XtextResource doSerialize(@NonNull String stem, @NonNull String referenceStem, @Nullable Map<Object, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		String inputName = stem + ".ecore";
		URI inputURI = getProjectFileURI(inputName);
		String referenceName = referenceStem + ".ecore";
		URI referenceURI = getProjectFileURI(referenceName);
		return doSerialize(inputURI, stem, referenceURI, options, doCompare, validateSaved);
	}
	@SuppressWarnings("null")
	public XtextResource doSerialize(@NonNull URI inputURI, @NonNull String stem, @NonNull URI referenceURI, @Nullable Map<Object, Object> options, boolean doCompare, boolean validateSaved) throws Exception {
		ResourceSetInitializer resourceSetInitializer = options != null ? (ResourceSetInitializer)options.get(ResourceSetInitializer.class) : null;
		ResourceSet resourceSet = new ResourceSetImpl();
		getProjectMap().initializeResourceSet(resourceSet);
		String outputName = stem + ".serialized.oclinecore";
		URI outputURI = getProjectFileURI(outputName);
		//
		//	Load as Ecore
		//
		Resource ecoreResource = loadEcore(inputURI);
		//
		//	Ecore to Pivot
		//		
		OCL ocl1 = OCL.newInstance();
		XtextResource xtextResource1 = null;
		try {
			MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
			if (resourceSetInitializer != null) {
				resourceSetInitializer.initializeResourceSet(metaModelManager1.getExternalResourceSet());
			}
			ASResource asResource = ocl1.ecore2as(ecoreResource);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//		
			xtextResource1 = as2cs(ocl1, resourceSet, asResource, outputURI);
			resourceSet.getResources().clear();
		}
		finally {
			ocl1.dispose();
			ocl1 = null;
		}
		OCL ocl2 = OCL.newInstance();
		try {
			MetaModelManager metaModelManager2 = ocl2.getMetaModelManager();
			if (resourceSetInitializer != null) {
				resourceSetInitializer.initializeResourceSet(metaModelManager2.getExternalResourceSet());
			}
			BaseCSResource xtextResource2 = (BaseCSResource) resourceSet.createResource(outputURI);
			MetaModelManagerResourceAdapter.getAdapter(xtextResource2, metaModelManager2);
			xtextResource2.load(null);
			Object cs2asErrors = options != null ? options.get("cs2asErrors") : null;
			if (cs2asErrors != null) {
				assertResourceErrors("Reload failed", xtextResource2, cs2asErrors.toString());
			}
			else {
				assertNoResourceErrors("Reload failed", xtextResource2);
				assertNoUnresolvedProxies("unresolved reload proxies", xtextResource2);
			}
			//
			//	CS to Pivot
			//	
			String pivotName2 = stem + "2.ecore.oclas";
			URI pivotURI2 = getProjectFileURI(pivotName2);
			Resource pivotResource2 = cs2as(ocl2, xtextResource2, pivotURI2);
			//
			//	Pivot to Ecore
			//		
			String inputName2 = stem + "2.ecore";
			URI ecoreURI2 = getProjectFileURI(inputName2);
			Resource ecoreResource2 = as2ecore(ocl2, pivotResource2, ecoreURI2, validateSaved);
			//
			//
			//
	//		assertSameModel(asResource, pivotResource2);
			Resource referenceResource = loadEcore(referenceURI);
			if (doCompare) {	// Workaround for Bug 354621
				assertSameModel(referenceResource, ecoreResource2);		
			}
			return xtextResource1;
		}
		finally {
			ocl2.dispose();
			ocl2 = null;
		}
	}
	
	@SuppressWarnings("null")
	public XtextResource doSerializeUML(String stem) throws Exception {
		UML2AS.initialize(resourceSet);
		UMLPackage.eINSTANCE.getClass();
		//
		//	Load as Ecore
		//
		String inputName = stem + ".uml";
		URI inputURI = getProjectFileURI(inputName);
		Resource umlResource = loadUML(inputURI);
		//
		//	Ecore to Pivot
		//
		OCL ocl1 = OCL.newInstance(EPackage.Registry.INSTANCE);
		XtextResource xtextResource = null;
		try {
			MetaModelManager metaModelManager1 = ocl1.getMetaModelManager();
			@SuppressWarnings("unused")
			Resource asResource = getPivotFromUML(metaModelManager1, umlResource);
			//
			//	Pivot to CS
			/*		
			String outputName = stem + ".serialized.oclinecore";
			URI outputURI = getProjectFileURI(outputName);
			xtextResource = as2cs(ocl1, resourceSet, asResource, outputURI);
			resourceSet.getResources().clear();
			BaseCSResource xtextResource2 = (BaseCSResource) resourceSet.getResource(outputURI, true);
			assertNoResourceErrors("Reload failed", xtextResource2);
			assertNoUnresolvedProxies("unresolved reload proxies", xtextResource2); */
		}
		finally {
			ocl1.dispose();
			ocl1 = null;
		}
/*		//
		//	CS to Pivot
		//	
		String pivotName2 = stem + "2.ecore.oclas";
		URI pivotURI2 = getProjectFileURI(pivotName2);
		Resource pivotResource2 = cs2as(ocl, xtextResource2, pivotURI2);
		//
		//	Pivot to Ecore
		//
		Resource ecoreResource2;
		{
			String inputName2 = stem + "2.ecore";
			URI ecoreURI2 = getProjectFileURI(inputName2);
			ecoreResource2 = as2ecore(ocl, pivotResource2, ecoreURI2, true);
		}
		//
		//
		//
		assertSameModel(asResource, pivotResource2);
		UML2Ecore2AS uml2ecore2as = UML2Ecore2Pivot.getAdapter(umlResource, metaModelManager);	// FIXME Use UML2AS
		Resource ecoreResource = uml2ecore2as.getEcoreResource();
		assertSameModel(ecoreResource, ecoreResource2);		*/
		return xtextResource;
	}

	@SuppressWarnings("null")
	protected Resource getPivotFromUML(MetaModelManager metaModelManager, Resource umlResource) throws ParserException {
//		String problem = UML2AS.initialize(metaModelManager.getExternalResourceSet());
//		assertNull(problem);
		UML2AS uml2as = UML2AS.getAdapter(umlResource, metaModelManager);
		Model pivotModel = uml2as.getPivotModel();
		Resource asResource = pivotModel.eResource();
		assertNoResourceErrors("Normalisation failed", asResource);
		assertNoValidationErrors("Normalisation invalid", asResource);
		return asResource;
	}

	@SuppressWarnings("null")
	protected Resource loadUML(URI inputURI) {
//		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
		assertNull(OCL.initialize(resourceSet));
		Resource umlResource = resourceSet.getResource(inputURI, true);
		mapOwnURI(umlResource);
//		List<String> conversionErrors = new ArrayList<String>();
//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", umlResource);
//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
//		xtextResource.getContents().add(documentCS);
		return umlResource;
	}
	
	public void testSerialize_Bug320689() throws Exception {
		doSerialize("Bug320689");
	}
	
	public void testSerialize_Bug323741() throws Exception {
		doSerialize("Bug323741");
	}
	
	public void testSerialize_Bug354336() throws Exception {
		doSerialize("Bug354336", "Bug354336", null, false, true);		// FIXME Model check suppressed because of Bug 354621
	}
	
	public void testSerialize_Bug362620() throws Exception {
		doSerialize("Bug362620");
	}
	
	public void testSerialize_Bug376488() throws Exception {
		doSerialize("Bug376488", "Bug376488", null, true, false);
	}

	public void testSerialize_Bug388282() throws Exception {
		String testFile = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
			"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"rootPackage\" nsURI=\"http://www.example.com/rootPackage/1.0\"\n" +
			"    nsPrefix=\"rootPackage\">\n" +
			"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"Element\" abstract=\"true\">\n" +
			"    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"name\" lowerBound=\"1\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString\"\n" +
			"        defaultValueLiteral=\"\"/>\n" +
			"  </eClassifiers>\n" +
			"  <eSubpackages name=\"subPackage\" nsURI=\"http://www.example.com/subPackage/1.0\" nsPrefix=\"subPackage\">\n" +
			"    <eClassifiers xsi:type=\"ecore:EClass\" name=\"Element\" abstract=\"true\" eSuperTypes=\"#//Element\"/>\n" +
			"  </eSubpackages>\n" +
			"</ecore:EPackage>\n" +
			"\n";
		createOCLinEcoreFile("Bug388282.ecore", testFile);		// FIXME rename as createTextFile
		doSerialize("Bug388282");
	}

	public void testSerialize_Bug397917() throws Exception {
		String testFile = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
			"   xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"test1\" nsURI=\"http://test1/1.0\" nsPrefix=\"test1\">\n" +
			" <eClassifiers xsi:type=\"ecore:EClass\" name=\"Model\">\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"node\" upperBound=\"-1\" eType=\"#//Node\" containment=\"true\"/>\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"link\" upperBound=\"-1\" eType=\"#//Link\" containment=\"true\"/>\n" +
			" </eClassifiers>\n" +
			" <eClassifiers xsi:type=\"ecore:EClass\" name=\"Node\">\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"uuid\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString\" iD=\"true\"/>\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"outgoing\" eType=\"#//Link\" eOpposite=\"#//Link/from\" eKeys=\"#//Link/uuid\"/>\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"incoming\" eType=\"#//Link\" eOpposite=\"#//Link/to\" eKeys=\"#//Link/uuid\"/>\n" +
			" </eClassifiers>\n" +
			" <eClassifiers xsi:type=\"ecore:EClass\" name=\"Link\">\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"uuid\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString\" defaultValueLiteral=\"\" iD=\"true\"/>\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"from\" lowerBound=\"1\" eType=\"#//Node\" eOpposite=\"#//Node/outgoing\" eKeys=\"#//Node/uuid\"/>\n" +
			"   <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"to\" lowerBound=\"1\" eType=\"#//Node\" eOpposite=\"#//Node/incoming\" eKeys=\"#//Node/uuid\"/>\n" +
			" </eClassifiers>\n" +
			"</ecore:EPackage>";
		createOCLinEcoreFile("Bug397917.ecore", testFile);		// FIXME rename as createTextFile
		doSerialize("Bug397917");
	}


	public void testSerialize_Bug404493() throws Exception {
		String testFile = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
			"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"company\" nsURI=\"http://www.eclipse.org/ocl/test/Pivot/Company.ecore\"\n" +
			"    nsPrefix=\"co\">\n" +
			"  <eAnnotations source=\"http://www.eclipse.org/emf/2002/Ecore\">\n" +
			"    <details key=\"invocationDelegates\" value=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\"/>\n" +
			"    <details key=\"settingDelegates\" value=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\"/>\n" +
			"    <details key=\"validationDelegates\" value=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\"/>\n" +
			"  </eAnnotations>\n" +
			"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"Employee\">\n" +
			"    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"name\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EString\"/>\n" +
			"    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"hasNameAsAttribute\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EBoolean\"\n" +
			"        changeable=\"false\" volatile=\"true\" transient=\"true\" derived=\"true\">\n" +
			"      <eAnnotations source=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\">\n" +
			"        <details key=\"derivation\" value=\"name &lt;> null -- trailing comment\"/>\n" +
			"      </eAnnotations>\n" +
			"    </eStructuralFeatures>\n" +
			"  </eClassifiers>\n" +
			"</ecore:EPackage>\n";
		createOCLinEcoreFile("Bug404493.ecore", testFile);
		doSerialize("Bug404493", "Bug404493", null, false, true);
	}

	public void testSerialize_Bug425506() throws Exception {
		String testFile = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
			"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" + 
			"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"p\" nsURI=\"p\" nsPrefix=\"p\">\n" + 
			"  <eAnnotations source=\"http://www.eclipse.org/emf/2002/Ecore\">\n" + 
			"    <details key=\"invocationDelegates\" value=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\"/>\n" + 
			"    <details key=\"settingDelegates\" value=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\"/>\n" + 
			"    <details key=\"validationDelegates\" value=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\"/>\n" + 
			"  </eAnnotations>\n" + 
			"  <eAnnotations source=\"http://www.eclipse.org/OCL/Import\">\n" + 
			"    <details key=\"ecore\" value=\"http://www.eclipse.org/emf/2002/Ecore\"/>\n" + 
			"  </eAnnotations>\n" + 
			"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"A\">\n" + 
			"    <eAnnotations source=\"http://www.eclipse.org/emf/2002/Ecore\">\n" + 
			"      <details key=\"constraints\" value=\"inv2\"/>\n" + 
			"    </eAnnotations>\n" + 
			"    <eAnnotations source=\"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot\">\n" + 
			"      <details key=\"inv2\" value=\"true\"/>\n" + 
			"    </eAnnotations>\n" + 
			"    <eOperations name=\"f\">\n" + 
			"      <eAnnotations source=\"http://www.eclipse.org/emf/2002/GenModel\">\n" + 
			"        <details key=\"documentation\" value=\"function doc\"/>\n" + 
			"        <details key=\"body\" value=\"return 1;\"/>\n" + 
			"      </eAnnotations>\n" + 
			"    </eOperations>\n" + 
			"    <eOperations name=\"inv\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EBoolean\">\n" + 
			"      <eAnnotations source=\"http://www.eclipse.org/emf/2002/GenModel\">\n" + 
			"        <details key=\"documentation\" value=\"invariant doc\"/>\n" + 
			"        <details key=\"body\" value=\"return 1;\"/>\n" + 
			"      </eAnnotations>\n" + 
			"      <eParameters name=\"diagnostics\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EDiagnosticChain\"/>\n" + 
			"      <eParameters name=\"context\">\n" + 
			"        <eGenericType eClassifier=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EMap\">\n" + 
			"          <eTypeArguments eClassifier=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EJavaObject\"/>\n" + 
			"          <eTypeArguments eClassifier=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EJavaObject\"/>\n" + 
			"        </eGenericType>\n" + 
			"      </eParameters>\n" + 
			"    </eOperations>\n" + 
			"  </eClassifiers>\n" + 
			"</ecore:EPackage>\n" ;
		createOCLinEcoreFile("Bug425506.ecore", testFile);
		doSerialize("Bug425506", "Bug425506", null, true, true);
	}

	public void testSerialize_Company() throws Exception {
//		Logger logger = Logger.getLogger(AbstractParseTreeConstructor.class);
//		logger.setLevel(Level.TRACE);
//		logger.addAppender(new ConsoleAppender(new SimpleLayout()));
//		BaseScopeProvider.LOOKUP.setState(true);
//		DocumentAttribution.WORK.setState(true);
//		CS2ASConversion.CONTINUATION.setState(true);
//		Abstract2Moniker.TRACE_MONIKERS.setState(true);
		doSerialize("Company", "Company.reference", null, true, true);
	}

	public void testSerialize_ConstraintMessages() throws Exception {
		doSerialize("ConstraintMessages", "ConstraintMessages.reference", null, true, true);
	}

	public void testSerialize_Ecore() throws Exception {
		doSerialize("Ecore");
	}

	public void testSerialize_Imports() throws Exception {
		XtextResource xtextResource = doSerialize("Imports");
		RootPackageCS documentCS = (RootPackageCS) xtextResource.getContents().get(0);
		List<ImportCS> imports = documentCS.getOwnedImports();
		assertEquals("One import", 1, imports.size());
	}

	public void testSerialize_Keys() throws Exception {
		doSerialize("Keys");
	}

	public void testSerialize_Names() throws Exception {
		doSerialize("Names");
	}

/*	
 * Requires support for lower bounds on generic types
 * and better resolution of EAnnotation.references
	public void testSerialize_OCL() throws Exception {
		doSerialize("OCL");
	} */

	public void testSerialize_BaseCST() throws Exception {
		URI uri = URI.createPlatformResourceURI("/org.eclipse.ocl.xtext.base/model/BaseCS.ecore", true);
		@SuppressWarnings("null")@NonNull String stem = uri.trimFileExtension().lastSegment();
		doSerialize(uri, stem, uri, null, false, true);		// FIXME URIs don't quite compare
	}

	public void testSerialize_EssentialOCLCST() throws Exception {
		URI uri = URI.createPlatformResourceURI("/org.eclipse.ocl.xtext.essentialocl/model/EssentialOCLCS.ecore", true);
		@SuppressWarnings("null")@NonNull String stem = uri.trimFileExtension().lastSegment();
		Map<Object, Object> options = createLoadedEcoreOptions();
		doSerialize(uri, stem, uri, options, false, true);		// FIXME URIs don't quite compare
	}

	public void testSerialize_OCLinEcoreCST() throws Exception {
		URI uri = URI.createPlatformResourceURI("/org.eclipse.ocl.xtext.oclinecore/model/OCLinEcoreCS.ecore", true);
		@SuppressWarnings("null")@NonNull String stem = uri.trimFileExtension().lastSegment();
		Map<Object, Object> options = createLoadedEcoreOptions();
		doSerialize(uri, stem, uri, options, false, true);		// FIXME URIs don't quite compare
//		doSerialize("OCLinEcoreCST");
	}

	public void testSerialize_OCLstdlib() throws Exception {
		doSerialize("OCLstdlib");
	}

	public void testSerialize_OCLCST() throws Exception {
		doSerialize("OCLCST");
	}

	/* BUG 377626
	public void testSerialize_QVT() throws Exception {
		doSerialize("QVT");
	} */

	public void testSerialize_RoyalAndLoyal() throws Exception {
		doSerialize("RoyalAndLoyal");
	}	
	
	public void testSerialize_States() throws Exception {
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put("cs2asErrors", 
			StringUtil.bind(PivotMessagesInternal.UnresolvedOperationCall_ERROR_, "OclInvalid", "substring", "1, 1"));
		doSerialize("States", "States", options, true, true);
	}	

	public void testSerialize_XMLNamespace() throws Exception {
		doSerialize("XMLNamespace");
	}	

	public void test_StateMachines_uml_Serialize() throws Exception {
		doSerializeUML("StateMachines");
	}
}

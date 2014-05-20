/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.domain.utilities.ProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap;
import org.eclipse.ocl.examples.domain.utilities.StandaloneProjectMap.IProjectDescriptor;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.delegate.DelegateInstaller;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.pivot.uml.Pivot2UML;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot.MessageBinder;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.pivot2cs.CompleteOCLSplitter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UML402UMLExtendedMetaData;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.EmfFormatter;

/**
 * Test that an Ecore file can be loaded as OCLinEcore then saved back as Ecore.
 */
@SuppressWarnings("null")
public class RoundTripTests extends XtextTestCase
{
	public Resource createEcoreFromPivot(MetaModelManager metaModelManager, ASResource asResource, URI ecoreURI) throws IOException {
		Resource ecoreResource = Pivot2Ecore.createResource(metaModelManager, asResource, ecoreURI, null);
		assertNoResourceErrors("To Ecore errors", ecoreResource);
		if (ecoreURI != null) {
			ecoreResource.save(null);
		}
		return ecoreResource;
	}
	public ASResource createPivotFromEcore(MetaModelManager metaModelManager, Resource ecoreResource) throws IOException {
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, metaModelManager);
		Root pivotRoot = ecore2Pivot.getPivotRoot();
		ASResource asResource = (ASResource) pivotRoot.eResource();
		assertNoResourceErrors("Ecore2Pivot failed", asResource);
		assertNoValidationErrors("Ecore2Pivot invalid", asResource);
		return asResource;
	}
	public ASResource createPivotFromXtext(MetaModelManager metaModelManager, BaseCSResource xtextResource, int expectedContentCount) throws IOException {
		CS2PivotResourceAdapter adapter = null;
		try {
			adapter = xtextResource.getCS2ASAdapter(null);
			ASResource asResource = adapter.getASResource(xtextResource);
			assertNoResourceErrors("To Pivot errors", xtextResource);
			assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
			List<EObject> pivotContents = asResource.getContents();
			assertEquals(expectedContentCount, pivotContents.size());
			assertNoValidationErrors("Pivot validation errors", pivotContents.get(0));
			return asResource;
		}
		finally {
			if (adapter != null) {
				adapter.dispose();
			}
		}
	}
	public BaseCSResource createXtextFromPivot(MetaModelManager metaModelManager, ASResource asResource, URI xtextURI) throws IOException {
		XtextResource xtextResource = (XtextResource) resourceSet.createResource(xtextURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
		((BaseCSResource) xtextResource).updateFrom(asResource, metaModelManager);
		xtextResource.save(null);
		assertNoResourceErrors("Conversion failed", xtextResource);
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		return (BaseCSResource) xtextResource;
	}
	public BaseCSResource createXtextFromURI(MetaModelManager metaModelManager, URI xtextURI) throws IOException {
		ResourceSet resourceSet2 = metaModelManager.getExternalResourceSet();
//		ProjectMap.initializeURIResourceMap(resourceSet2);
		ProjectMap.initializeURIResourceMap(null);
//		UMLUtils.initializeContents(resourceSet2);
		BaseCSResource xtextResource = (BaseCSResource) resourceSet2.getResource(xtextURI, true);
		assertNoResourceErrors("Load failed", xtextResource);
		return xtextResource;
	}
	
	public BaseResource createCompleteOCLXtextFromPivot(MetaModelManager metaModelManager, ASResource asResource, URI xtextURI) throws IOException {
		BaseResource xtextResource = (BaseResource) resourceSet.createResource(xtextURI, OCLinEcoreCSPackage.eCONTENT_TYPE);
		xtextResource.updateFrom(asResource, metaModelManager);
		xtextResource.save(null);
		assertNoResourceErrors("Conversion failed", xtextResource);
		assertNoDiagnosticErrors("Concrete Syntax validation failed", (XtextResource) xtextResource);
		return xtextResource;
	}
	
	public void doRoundTripFromCompleteOCL(URI inputURI) throws IOException, InterruptedException {
		MessageBinder savedMessageBinder = CS2Pivot.setMessageBinder(CS2Pivot.MessageBinderWithLineContext.INSTANCE);
		StandaloneProjectMap projectMap = ProjectMap.getAdapter(resourceSet);
		try {
			projectMap.initializeResourceSet(resourceSet);			
			if (!resourceSet.getURIConverter().exists(inputURI, null)) {
				return;
			}			
			if (!EMFPlugin.IS_ECLIPSE_RUNNING) {			
				IProjectDescriptor projectDescriptor = projectMap.getProjectDescriptor("org.eclipse.uml2.uml");
				projectDescriptor.initializeURIMap(URIConverter.URI_MAP);		// *.ecore2xml must be global
			}
//			UMLUtils.initializeContentHandlers(resourceSet);
//			UMLUtils.initializeContents(resourceSet);
//			String inputName = stem + ".ocl";
//			String outputName = stem + ".regenerated.ocl";
			URI outputURI = inputURI.trimFileExtension().appendFileExtension("regenerated.ocl");
			MetaModelManager metaModelManager1 = new MetaModelManager(projectMap);
			MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager1);
			BaseCSResource xtextResource1 = createXtextFromURI(metaModelManager1, inputURI);
			ASResource pivotResource1 = createPivotFromXtext(metaModelManager1, xtextResource1, 1);
			ASResource pivotResource2 = CompleteOCLSplitter.separate(metaModelManager1, pivotResource1);
			@SuppressWarnings("unused")
			BaseResource xtextResource2 = createCompleteOCLXtextFromPivot(metaModelManager1, pivotResource2, outputURI);
			metaModelManager1.dispose();
			metaModelManager1 = null;
			//
			MetaModelManager metaModelManager3 = new MetaModelManager(projectMap);
			BaseCSResource xtextResource3 = createXtextFromURI(metaModelManager3, outputURI);
			@SuppressWarnings("unused")
			ASResource pivotResource3 = createPivotFromXtext(metaModelManager3, xtextResource3, 1);
//			Map<String,Object> options = new HashMap<String,Object>();
//			options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
//			options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
//			((NamedElement)pivotResource3.getContents().get(0)).setName(((NamedElement)pivotResource1.getContents().get(0)).getName());
//	    	assertSameModel(pivotResource1, pivotResource3, options);
			metaModelManager3.dispose();
		}
		finally {
			projectMap.dispose();
			CS2Pivot.setMessageBinder(savedMessageBinder);
		}
	}
	
	public void doRoundTripFromEcore(String stem) throws IOException, InterruptedException {
		doRoundTripFromEcore(stem, stem, null);
	}
	public void doRoundTripFromEcore(String stem, String reference, Map<String,Object> saveOptions) throws IOException, InterruptedException {
		String inputName = stem + ".ecore";
		URI inputURI = getProjectFileURI(inputName);
		String referenceName = reference + ".ecore";
		URI referenceURI = getProjectFileURI(referenceName);
		doRoundTripFromEcore(inputURI, referenceURI, saveOptions);
	}
	protected void doRoundTripFromEcore(URI inputURI, URI referenceURI, Map<String,Object> saveOptions) throws IOException, InterruptedException {
		String stem = inputURI.trimFileExtension().lastSegment();
		String pivotName = stem + ".ecore.oclas";
		String outputName = stem + ".regenerated.ecore";
		URI pivotURI = getProjectFileURI(pivotName);
		URI outputURI = getProjectFileURI(outputName);
		MetaModelManager metaModelManager = new MetaModelManager();
		ResourceSet resourceSet = metaModelManager.getExternalResourceSet();
		Resource inputResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("Ecore load", inputResource);
		assertNoValidationErrors("Ecore load", inputResource);
		
		try {
			Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(inputResource, metaModelManager);
			Root pivotRoot = ecore2Pivot.getPivotRoot();
			Resource asResource = pivotRoot.eResource();
			asResource.setURI(pivotURI);
			assertNoResourceErrors("Ecore2Pivot failed", asResource);
			asResource.save(null);
			assertNoValidationErrors("Ecore2Pivot invalid", asResource);
//			int i = 0;
			for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof OpaqueExpression) {
//					System.out.println(++i + ": " + eObject);
					((OpaqueExpression) eObject).getExpressionInOCL();
					tit.prune();
				}
			}
			
			
			Resource outputResource = Pivot2Ecore.createResource(metaModelManager, asResource, inputURI, saveOptions);
			assertNoResourceErrors("Ecore2Pivot failed", outputResource);
			OutputStream outputStream = resourceSet.getURIConverter().createOutputStream(outputURI);
			outputResource.save(outputStream, null);
			outputStream.close();
			assertNoValidationErrors("Ecore2Pivot invalid", outputResource);
			
	//		RootPackageCS csDocument = null; // FIXME Ecore2OCLinEcore.importFromEcore(resourceSet, null, leftResource);
	//		assertNoResourceErrors("From Ecore errors", csDocument.eResource());
	//		List<PackageCS> csObjects = new ArrayList<PackageCS>();
	//		csObjects.addAll(csDocument.getPackages());
	//		Resource middleResource = resourceSet.createResource(middleURI);
	//		middleResource.getContents().addAll(csObjects);
	//		middleResource.getContents().add(csDocument);
	//		middleResource.save(null);
	//		OCLinEcore2Ecore cs2e = new OCLinEcore2Ecore(resourceSet, middleResource, outputURI);
	//		Resource rightResource = cs2e.exportToEcore();
	//		assertNoResourceErrors("To Ecore errors", rightResource);
	//		rightResource.save(null);
	//		resourceSet.getResources().add(rightResource);
			if (referenceURI != null) {
				ResourceSetImpl resourceSet2 = new ResourceSetImpl();
				StandaloneProjectMap.getAdapter(resourceSet).initializeResourceSet(resourceSet2);
				Resource referenceResource = resourceSet2.getResource(referenceURI, true);
				assertSameModel(referenceResource, outputResource);
			}
		} finally {
			metaModelManager.dispose();
		}
	}
	
	public void doRoundTripFromOCLinEcore(MetaModelManager metaModelManager1, String stem) throws IOException, InterruptedException {
		String inputName = stem + ".oclinecore";
		String ecoreName = stem + ".ecore";
		String outputName = stem + ".regenerated.oclinecore";
		URI inputURI = getProjectFileURI(inputName);
		URI ecoreURI = getProjectFileURI(ecoreName);
		URI outputURI = getProjectFileURI(outputName);

		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager1);
		BaseCSResource xtextResource1 = createXtextFromURI(metaModelManager1, inputURI);
		ASResource pivotResource1 = createPivotFromXtext(metaModelManager1, xtextResource1, 1);
		Resource ecoreResource = createEcoreFromPivot(metaModelManager1, pivotResource1, ecoreURI);
		MetaModelManager metaModelManager2 = new MetaModelManager();
		ASResource pivotResource2 = createPivotFromEcore(metaModelManager2, ecoreResource);
		@SuppressWarnings("unused")
		BaseCSResource xtextResource2 = createXtextFromPivot(metaModelManager2, pivotResource2, outputURI);
		metaModelManager2.dispose();
		metaModelManager2 = null;
		//
		MetaModelManager metaModelManager3 = new MetaModelManager();
		BaseCSResource xtextResource3 = createXtextFromURI(metaModelManager3, outputURI);
		ASResource pivotResource3 = createPivotFromXtext(metaModelManager3, xtextResource3, 1);
		String expected = EmfFormatter.listToStr(pivotResource1.getContents());
		String actual = EmfFormatter.listToStr(pivotResource3.getContents()).replace(".regenerated.oclinecore", ".oclinecore");
		assertEquals(expected, actual);
		metaModelManager3.dispose();
	}
	
	public void doRoundTripFromUml(String stem) throws IOException, InterruptedException, ParserException {
//		Environment.Registry.INSTANCE.registerEnvironment(
//			new UMLEnvironmentFactory().createEnvironment());
		ResourceSet resourceSet = new ResourceSetImpl();
		assertNull(OCL.initialize(resourceSet));
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
//		assertNull(org.eclipse.ocl.uml.OCL.initialize(null));		
//		org.eclipse.uml2.uml.Package umlMetamodel = (org.eclipse.uml2.uml.Package) resourceSet.getResource(
//			URI.createURI(UMLResource.UML_METAMODEL_URI),
//			true).getContents().get(0);
//		org.eclipse.uml2.uml.Package umlPrimitiveTypes = (org.eclipse.uml2.uml.Package) resourceSet.getResource(
//			URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI),
//			true).getContents().get(0);
//		org.eclipse.uml2.uml.Package ecorePrimitiveTypes = (org.eclipse.uml2.uml.Package) resourceSet.getResource(
//			URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI),
//			true).getContents().get(0);
		String inputName = stem + ".uml";
		String pivotName = stem + PivotConstants.DOT_OCL_AS_FILE_EXTENSION;
		String outputName = stem + ".regenerated.uml";
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = getProjectFileURI(pivotName);
		URI outputURI = getProjectFileURI(outputName);
		Resource inputResource = resourceSet.getResource(inputURI, true);
		assertNoResourceErrors("UML load", inputResource);
		assertNoValidationErrors("UML load", inputResource);
		
		MetaModelManager pivotManager = new MetaModelManager();
		UML2Pivot uml2Pivot = UML2Pivot.getAdapter(inputResource, pivotManager);
		Root pivotRoot = uml2Pivot.getPivotRoot();
		Resource asResource = pivotRoot.eResource();
		asResource.setURI(pivotURI);
		assertNoResourceErrors("UML2Pivot failed", asResource);
		asResource.save(null);
		assertNoValidationErrors("UML2Pivot invalid", asResource);
		
		List<? extends EObject> outputObjects = new ArrayList<EObject>(Pivot2UML.createResource(pivotManager, asResource));
		@SuppressWarnings("unchecked")
		List<? extends org.eclipse.uml2.uml.NamedElement> castOutputObjects = (List<? extends org.eclipse.uml2.uml.NamedElement>)outputObjects;
		outputObjects.remove(getNamedElement(castOutputObjects, "orphanage"));
		if (outputObjects.size() == 1) {
			outputObjects = ((org.eclipse.uml2.uml.Package)outputObjects.get(0)).getNestedPackages();
		}
		Resource outputResource = resourceSet.createResource(outputURI);
		outputResource.getContents().addAll(outputObjects);
		assertNoResourceErrors("UML2Pivot failed", outputResource);
		outputResource.save(null);
		assertNoValidationErrors("UML2Pivot invalid", outputResource);
		assertSameModel(inputResource, outputResource);
	}

	public static <T extends org.eclipse.uml2.uml.NamedElement> T getNamedElement(Collection<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}

	public void testBug350894RoundTrip() throws IOException, InterruptedException {
		String testFileA = 
				"package a : aa = 'aaa'\n" +
				"{\n" +
				"class A;\n" +
				"}\n";
		MetaModelManager metaModelManager1 = new MetaModelManager();
		createEcoreFile(metaModelManager1, "Bug350894A", testFileA);
		metaModelManager1.dispose();
		String testFileB = 
				"import aa : 'Bug350894A.ecore#/';\n" +
				"package b : bb = 'bbb'\n" +
				"{\n" +
				"class B\n" +
				"{\n" +
				"invariant alias: not oclIsKindOf(aa::A);\n" +
				"invariant nsURI: not oclIsKindOf(aaa::A);\n" +
				"invariant file: not oclIsKindOf(_'Bug350894A.ecore#/'::A);\n" +
				"}\n" +
				"}\n";
		createOCLinEcoreFile("Bug350894B.oclinecore", testFileB);
		MetaModelManager metaModelManager2 = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager2, "Bug350894B");
		metaModelManager2.dispose();
	}

	public void testBug356243_oclinecore() throws IOException, InterruptedException {
		String testFile = 
			"package any : any = 'http:/any'\n" +
			"{\n" +
			"	class Bug356243\n" +
			"	{\n" +
			"		property is_always_typed : OclAny { ordered };\n" +
			"	}\n" +
			"}\n";
		createOCLinEcoreFile("Bug356243.oclinecore", testFile);
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "Bug356243");
		metaModelManager.dispose();
	}

	public void testBug426927_oclinecore() throws IOException, InterruptedException {
		String testFile = 
			"package any : any = 'http:/any'\n" +
			"{\n" +
			"	enum Enums\n" +
			"	{\n" +
			"		literal ONE = 1;\n" +
			"		literal MINUS_ONE = -1;\n" +
			"	}\n" +
			"	class Bug426927\n" +
			"	{\n" +
			"		annotation {\n" +
			"			reference Enums::MINUS_ONE;\n" +
			"		}\n" +
			"	}\n" +
			"}\n";
		createOCLinEcoreFile("Bug426927.oclinecore", testFile);
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "Bug426927");
		metaModelManager.dispose();
	}

	public void testAggregatesRoundTrip() throws IOException, InterruptedException {
		String testFile = 
				"package b : bb = 'bbb'\n" +
				"{\n" +
				"class B\n" +
				"{\n" +
				"property bag1 : B[*] {!unique};\n" +
				"property bag2 : Bag(B);\n" +
				"property bag3 : B[3..5] {!unique};\n" +
//				"property bag4 : Bag(B)[4..6];\n" +
				"property setCollection : Set(Collection(B));\n" +
				"property collection2 : Collection(B);\n" +
				"property orderedset1 : B[*] {ordered};\n" +
				"property orderedset2 : OrderedSet(B);\n" +
				"property sequence1 : B[*] {ordered, !unique};\n" +
				"property sequence2 : Sequence(B);\n" +
				"property set1 : B[*];\n" +
				"property set2 : Set(B);\n" +
//				"property tuple : Tuple(b : B);\n" +		// Bug 401938
				"}\n" +
				"}\n";
		createOCLinEcoreFile("Aggregates.oclinecore", testFile);
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "Aggregates");
		metaModelManager.dispose();
	}

	public void testCardinalityRoundTrip_402767() throws IOException, InterruptedException {
		String testFile = 
				"package b : bb = 'bbb'\n" +
				"{\n" +
				"class B\n" +
				"{\n" +
				"property vBlank : Real;\n" +
				"property vQuery : Real[?];\n" +
				"property vPlus : Real[+];\n" +
				"property vStar : Real[*];\n" +
				"property vOne : Real[1];\n" +
				"property vThree : Real[3];\n" +
				"property vOne2Three : Real[1..3];\n" +
				"property vThree2Three : Real[3..3];\n" +
				"property vThree2Star : Real[3..*];\n" +
				"}\n" +
				"}\n";
		createOCLinEcoreFile("Cardinality.oclinecore", testFile);
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "Cardinality");
		metaModelManager.dispose();
	}

	public void testCommentsRoundTrip_405145() throws IOException, InterruptedException {
		String testFile = 
				"package b : bb = 'bbb'\n" +
				"{\n" +
				"/* a simple comment */\n" +
				"class B\n" +
				"{\n" +
				"/*\n" +
				" * a multi line comment\n" +
				" */\n" +
				"property c1 : Real;\n" +
				"/* another \n" +
				" * multi line comment\n" +
				" */\n" +
				"property c2 : Real;\n" +
				"/* an unformatted \n" +
				" multi line comment\n" +
				" */\n" +
				"property c3 : Real;\n" +
				"}\n" +
				"}\n";
		createOCLinEcoreFile("Comments.oclinecore", testFile);
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "Comments");
		metaModelManager.dispose();
	}

	public void testInvariantCommentsRoundTrip_410682() throws IOException, InterruptedException {
		String testFile = 
				"package b : bb = 'bbb'\n" +
				"{\n" +
				"class B\n" +
				"{\n" +
				"/* an invariant comment */\n" +
				"invariant t : true;\n" +
				"/* an operation comment */\n" +
				"operation op(/* a parameter comment */p : Boolean, /* another parameter comment */q : Boolean) : Boolean\n" +
				"{\n" +
				"/* a precondition comment */\n" +
				"precondition: p;\n" +
				"/* another precondition comment */\n" +
				"precondition too: p;\n" +
//Not supported				"/* a body comment */\n" +
				"body: p or q;\n" +
				"/* a postcondition comment */\n" +
				"postcondition: result = p;\n" +
				"/* another postcondition comment */\n" +
				"postcondition too: result = q;\n" +
				"}\n" +
				"}\n" +
				"}\n";
		createOCLinEcoreFile("InvariantComments.oclinecore", testFile);
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "InvariantComments");
		metaModelManager.dispose();
	}

	public void testCompanyRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Company", "Company.reference", null);
	}

	public void testEcoreRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Ecore");
	}

	public void testEmptyRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Empty");
	}

	public void testImportsRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Imports");
	}

	public void testKeysRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("Keys");
	}

	public void testCompleteOCLRoundTrip_Fruit() throws IOException, InterruptedException {
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
		uriMap.putAll(UML402UMLExtendedMetaData.getURIMap());
//		EssentialOCLLinkingService.DEBUG_RETRY = true;
		doRoundTripFromCompleteOCL(getProjectFileURI("Fruit.ocl"));
	}

//	public void testCompleteOCLRoundTrip_Infrastructure() throws IOException, InterruptedException {
//		doRoundTripFromCompleteOCL("Infrastructure");
//	}

	public void testCompleteOCLRoundTrip_Names() throws IOException, InterruptedException {
		doRoundTripFromCompleteOCL(getProjectFileURI("Names.ocl"));
	}

	public void testCompleteOCLRoundTrip_UML() throws IOException, InterruptedException {
		URI uml_2_5 = URI.createPlatformResourceURI("UML-2.5/XMI-5-Jan-2012/Semanticed UML.ocl", false);
		doRoundTripFromCompleteOCL(uml_2_5);
	}

	public void testOCLinEcoreCSTRoundTrip() throws IOException, InterruptedException {
		URI uri = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.xtext.oclinecore/model/OCLinEcoreCS.ecore", true);
//		String stem = uri.trimFileExtension().lastSegment();
		doRoundTripFromEcore(uri, uri, null); //null);				// FIXME Compare is not quite right
	}

	public void testPivotRoundTrip() throws IOException, InterruptedException {
		URI uri = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.pivot/model/Pivot.ecore", true);
		doRoundTripFromEcore(uri, uri, null);
	}

//	public void testEssentialOCLCSTRoundTrip() throws IOException, InterruptedException {
//		ProjectMap.getAdapter(resourceSet);
//		URI uri = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCST.ecore", true);
//		doRoundTripFromEcore(uri, "EssentialOCLCST");
//	}

	public void testOCLstdlibRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("OCLstdlib");
	}

	public void testOCLRoundTrip() throws IOException, InterruptedException {
		Map<String,Object> options = new HashMap<String, Object>();
		options.put(Pivot2Ecore.OPTION_ADD_INVARIANT_COMMENTS, true);
		doRoundTripFromEcore("OCL", "OCL", options); // "OCL.reference"); 
	}

	public void testOCLCSTRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("OCLCST");
	}

	public void testOCLEcoreRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("OCLEcore");
	}

	/* BUG 377626
	public void testQVTRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("QVT");
	} */

	public void testUML25RoundTrip() throws IOException, InterruptedException {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		URI uri = URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/model/UML.ecore", true);
		Map<String,Object> options = new HashMap<String, Object>();
		options.put(Pivot2Ecore.OPTION_ADD_INVARIANT_COMMENTS, true);
		options.put(DelegateInstaller.OPTION_BOOLEAN_INVARIANTS, true);
		options.put(OCLConstants.OCL_DELEGATE_URI, OCLConstants.OCL_DELEGATE_URI);
		options.put(DelegateInstaller.OPTION_OMIT_SETTING_DELEGATES, true);
		doRoundTripFromEcore(uri, uri, options);
	}

	public void testSysMLRoundTrip() throws IOException, InterruptedException {
		String testFile = 
				"package b : bb = 'bbb'\n" +
				"{\n" +
				"class B\n" +
				"{\n" +
				"sysml { stereotype = 'SysML::Block'; }\n" +
				"}\n" +
				"}\n";
		createOCLinEcoreFile("SysML.oclinecore", testFile);
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "SysML");
		metaModelManager.dispose();
	}

	public void testTypes_ecore() throws IOException, InterruptedException {
		doRoundTripFromEcore("Types");
	}

	public void testTypes_oclinecore() throws IOException, InterruptedException {
//		BaseScopeProvider.LOOKUP.setState(true);
//		EssentialOCLLinkingService.DEBUG_RETRY = true;
		MetaModelManager metaModelManager = new MetaModelManager();
		doRoundTripFromOCLinEcore(metaModelManager, "Types");
		metaModelManager.dispose();
	}

	public void testXMLNamespaceRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("XMLNamespace");
	}	

	public void testXMLTypeRoundTrip() throws IOException, InterruptedException {
		doRoundTripFromEcore("XMLType");
	}

//	public void testMy_uml() throws IOException, InterruptedException {
//		doRoundTripFromUml("My");
//	}

//	public void testTriangle_uml() throws IOException, InterruptedException {
//		doRoundTripFromUml("Triangle");
//	}

//	public void testProfile_less_Ecore_metamodel_uml() throws IOException, InterruptedException {
//		doRoundTripFromUml("Profile-less-Ecore.metamodel");
//	}
}

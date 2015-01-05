/*******************************************************************************
 * Copyright (c) 2011, 2014 E.D.Willink and others.
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

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestCaseAppender;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerResourceAdapter;
import org.eclipse.ocl.pivot.internal.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.pivot.internal.values.BagImpl;
import org.eclipse.ocl.pivot.resource.ProjectMap;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.uml.internal.validation.UMLOCLEValidator;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Tests that OCL for model validation works.
 */
public abstract class AbstractValidateTests extends PivotTestCase
{	
	public static @NonNull List<Diagnostic> assertUMLOCLValidationDiagnostics(@Nullable OCL ocl, @NonNull String prefix, @NonNull Resource resource, String... messages) {
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		if (ocl != null) {
			UMLOCLEValidator.setOCL(validationContext, ocl);
		}
		List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
		for (EObject eObject : resource.getContents()) {
			EValidatorRegistryImpl registry = new EValidatorRegistryImpl();
			registry.put(UMLPackage.eINSTANCE, UMLOCLEValidator.INSTANCE);
			Diagnostician dignostician = new Diagnostician(registry);
			Diagnostic diagnostic = dignostician.validate(eObject, validationContext);
			diagnostics.addAll(diagnostic.getChildren());
		}
		return assertDiagnostics(prefix, diagnostics, messages);
	}

	public static void checkValidationDiagnostics(EObject testInstance, int severity, String... expectedMessage) {
		Bag<String> expectedMessages = new BagImpl<String>();
		for (String message : expectedMessage) {
			expectedMessages.add(message);
		}
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(testInstance, validationContext);
		Bag<String> actualMessages = new BagImpl<String>();
		for (Diagnostic diagnostic : diagnostics.getChildren()) {
			assertEquals(severity, diagnostic.getSeverity());
			actualMessages.add(diagnostic.getMessage());
		}
		String s = formatMessageDifferences(expectedMessages, actualMessages);
		if (s != null) {
			fail("Inconsistent validation: (expected/actual) message" + s);
		}
	}	

	@SuppressWarnings("deprecation")
	protected @NonNull ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		ProjectMap.initializeURIResourceMap(resourceSet);
		Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
    	if (EMFPlugin.IS_ECLIPSE_RUNNING) {
    		uriMap.putAll(EcorePlugin.computePlatformURIMap());
    	}
    	return resourceSet;
	}

	protected void disposeResourceSet(@NonNull ResourceSet resourceSet) {
		StandaloneProjectMap.dispose(resourceSet);
		for (Resource aResource : resourceSet.getResources()) {
			aResource.unload();
		}
		resourceSet.getResources().clear();
	}

	@SuppressWarnings("null")
	public Resource doLoadOCLinEcore(OCL ocl, String stem) throws IOException {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		String inputName = stem + ".oclinecore";
		String ecoreName = stem + ".ecore";
		URI inputURI = getProjectFileURI(inputName);
		URI ecoreURI = getProjectFileURI(ecoreName);
		BaseCSResource xtextResource = (BaseCSResource) metamodelManager.getExternalResourceSet().createResource(inputURI);
		MetamodelManagerResourceAdapter.getAdapter(xtextResource, metamodelManager);
		xtextResource.load(null);
		assertNoResourceErrors("Load failed", xtextResource);
		Resource asResource = ocl.cs2as(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
		assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
		Resource ecoreResource = as2ecore(ocl, asResource, ecoreURI, true);
		return ecoreResource;
	}

	public Resource doLoadUML(OCL ocl, String stem) throws IOException {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		String umlName = stem + ".uml";
		URI umlURI = getProjectFileURI(umlName);
		return metamodelManager.getExternalResourceSet().getResource(umlURI, true);
	}

	@SuppressWarnings("null")
	public @NonNull List<Diagnostic> doValidateOCLinEcore(OCL ocl, String stem, String... validationDiagnostics) throws IOException {
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		String inputName = stem + ".oclinecore";
		URI inputURI = getProjectFileURI(inputName);
		BaseCSResource xtextResource = (BaseCSResource) metamodelManager.getExternalResourceSet().createResource(inputURI);
		MetamodelManagerResourceAdapter.getAdapter(xtextResource, metamodelManager);
		xtextResource.load(null);
		assertNoResourceErrors("Load failed", xtextResource);
		Resource asResource = ocl.cs2as(xtextResource);
		assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
		return assertValidationDiagnostics("Pivot validation errors", asResource, validationDiagnostics);
	}

	protected EObject eCreate(EPackage ePackage, String className) {
		EClass eClass = (EClass) ePackage.getEClassifier(className);
		EFactory eFactoryInstance = ePackage.getEFactoryInstance();
		return eFactoryInstance.create(eClass);
	}

	protected void eSet(EObject eObject, String eFeatureName, Object value) {
		EClass eClass = eObject.eClass();
		EStructuralFeature eFeature = eClass.getEStructuralFeature(eFeatureName);
		assert eFeature != null;
		eObject.eSet(eFeature, value);
	}

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
    	TestCaseAppender.INSTANCE.install();
    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
    		OCL.initialize(null);
    	}
		doCompleteOCLSetup();
		doOCLinEcoreSetup();
		doOCLstdlibSetup();
//		OCLstdlib.install();
//        OCLDelegateDomain.initialize(null);
	}

	@Override
	protected void tearDown() throws Exception {
		PivotEnvironmentFactory.disposeGlobalRegistryInstance();
		super.tearDown();
	}
}

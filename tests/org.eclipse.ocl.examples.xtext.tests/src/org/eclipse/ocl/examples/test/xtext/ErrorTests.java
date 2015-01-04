/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.xtext.tests.TestCaseAppender;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerResourceAdapter;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.values.BagImpl;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class ErrorTests extends XtextTestCase
{
	/**
	 * Test a bad operation for bad iterate arguments. Inspired by Bug 352386.
	 */
	public void test_BadIterate() throws IOException {
		MetamodelManager metamodelManager = OCL.createEnvironmentFactory(null).getMetamodelManager();
		String metamodelText =
			"package test : tst = 'http://test'\n" +
			"{\n" +
			"	class Test\n" +
			"	{\n" +
			"		invariant set: Set{1, 2, 3}->size() = 3;\n" +
			"		invariant loop: Test.allInstances()->iterate(w, h; acc : String = '' | true);\n" +
			"	}\n" +
			"}\n";
		InputStream inputStream = new URIConverter.ReadableInputStream(metamodelText, "UTF-8");
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = ClassUtil.nonNullState((EssentialOCLCSResource) resourceSet.createResource(xtextURI, null));
		MetamodelManagerResourceAdapter.getAdapter(xtextResource, metamodelManager);
		xtextResource.load(inputStream, null);
		assertResourceErrors("Loading Xtext", xtextResource,
			StringUtil.bind(PivotMessagesInternal.UnresolvedIterationCall_ERROR_, "Set(test::Test)", "iterate", "w, h; acc : String = ''| true"));
        //
		metamodelManager.dispose();
	}
	
	/**
	 * Test a bad operation for bad iterate arguments. Inspired by Bug 352386.
	 */
	public void test_BadProperty() throws IOException {
		MetamodelManager metamodelManager = OCL.createEnvironmentFactory(null).getMetamodelManager();
		String metamodelText =
			"package test : tst = 'http://test'\n" +
			"{\n" +
			"	class Test\n" +
			"	{\n" +
			"		invariant loop: Test.allInstances->iterate(w, h; acc : String = '' | true);\n" +
			"	}\n" +
			"}\n";
		InputStream inputStream = new URIConverter.ReadableInputStream(metamodelText, "UTF-8");
		URI xtextURI = URI.createURI("test.oclinecore");
		ResourceSet resourceSet = new ResourceSetImpl();
		EssentialOCLCSResource xtextResource = ClassUtil.nonNullState((EssentialOCLCSResource) resourceSet.createResource(xtextURI, null));
		MetamodelManagerResourceAdapter.getAdapter(xtextResource, metamodelManager);
		xtextResource.load(inputStream, null);
		assertResourceErrors("Loading Xtext", xtextResource,
			StringUtil.bind(PivotMessagesInternal.UnresolvedStaticProperty_ERROR_, "test::Test", "allInstances"));
        //
		metamodelManager.dispose();
	}
	
	public void testBadEOF_419683() throws Exception {
		TestCaseAppender.INSTANCE.uninstall();
		String testFile =
			"import 'platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore'\n" +
			"package ecore\n" +
			"context EPackage\n" +
			"inv test:\n" +
			"	let classifiers:Set(EClassifier) = self.eClassifiers in let filtered";
		Bag<String> bag = new BagImpl<String>();
		bag.add("mismatched input 'inv' expecting '('");
		bag.add("mismatched input '<EOF>' expecting 'endpackage'");
		doBadLoadFromString("string.ocl", testFile, bag);
	}
}

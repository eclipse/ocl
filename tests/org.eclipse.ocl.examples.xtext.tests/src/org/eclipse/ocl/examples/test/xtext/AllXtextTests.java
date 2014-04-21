/**
 * <copyright>
 * 
 * Copyright (c) 2002, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *
 * </copyright>
 *
 * $Id: AllXtextTests.java,v 1.10 2011/05/20 15:27:16 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.xtext;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.pivot.tests.DelegatesTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateBooleanOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateClassifierOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateCollectionOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateConstructsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateModelOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateNameVisibilityTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateNumericOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateOclAnyOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateStringOperationsTest;
import org.eclipse.ocl.examples.pivot.tests.EvaluateUMLTest;
import org.eclipse.ocl.examples.pivot.tests.InheritanceTests;
import org.eclipse.ocl.examples.pivot.tests.IteratorsTest;
import org.eclipse.ocl.examples.pivot.tests.PrettyPrinterTest;
import org.eclipse.ocl.examples.pivot.tests.StereotypesTest;
import org.eclipse.ocl.examples.test.ecore.ProjectMapTest;
import org.eclipse.ocl.examples.test.standalone.StandaloneExecutionTests;
import org.eclipse.ocl.examples.test.standalone.StandaloneParserTests;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

/**
 * Tests for the Xtext editor support.
 */
@SuppressWarnings("nls")
public class AllXtextTests
	extends TestCase {

	public AllXtextTests() {
		super("");
	}

	public static Test suite() {
//		if (System.getProperty("standalone") != null) {
			// running tests stand-alone:  must set up the environment registry
//			Environment.Registry.INSTANCE.registerEnvironment(
//					EcoreEnvironmentFactory.INSTANCE.createEnvironment());
//		}

    	String testSuiteName = System.getProperty("testSuiteName", "Xtext Editor Support");
		TestSuite result = new TestSuite(testSuiteName);			
		result.addTestSuite(MonikerTests.class);
		result.addTestSuite(PivotTests.class);
		result.addTestSuite(OCLstdlibTests.class);
		result.addTestSuite(PrecedenceTests.class);
		result.addTestSuite(EvaluateBooleanOperationsTest.class);
		result.addTestSuite(EvaluateClassifierOperationsTest.class);
		result.addTestSuite(EvaluateCollectionOperationsTest.class);
		result.addTestSuite(EvaluateConstructsTest.class);
		result.addTestSuite(EvaluateModelOperationsTest.class);
		result.addTestSuite(EvaluateNameVisibilityTest.class);
		result.addTestSuite(EvaluateNumericOperationsTest.class);
		result.addTestSuite(EvaluateOclAnyOperationsTest.class);
		result.addTestSuite(EvaluateStringOperationsTest.class);
		result.addTestSuite(EvaluateUMLTest.class);
		result.addTestSuite(IteratorsTest.class);
		result.addTestSuite(DelegatesTest.class);
		result.addTestSuite(ErrorTests.class);
		result.addTestSuite(ImportTests.class);
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
		LoadTests.getProjectMap().initializeResourceSet(resourceSet);
		if (resourceSet.getURIConverter().exists(URI.createPlatformResourceURI("/org.eclipse.ocl.examples.uml25/", true), null)) {
			result.addTestSuite(UML25LoadTests.class);
		}
		else {
			result.addTestSuite(LoadTests.class);
		}
		result.addTestSuite(PrettyPrinterTest.class);
		result.addTestSuite(ProjectMapTest.class);
		result.addTestSuite(RegistryTests.class);
		result.addTestSuite(SerializeTests.class);
		result.addTestSuite(RoundTripTests.class);
		result.addTestSuite(StereotypesTest.class);
		result.addTestSuite(EditTests.class);
		result.addTestSuite(InheritanceTests.class);
		result.addTestSuite(MarkupTests.class);
		result.addTestSuite(ValidateTests.class);
		result.addTestSuite(PivotDocumentationExamples.class);
		result.addTestSuite(OCLinEcoreTutorialExamples.class);
		result.addTestSuite(UsageTests.class);
		result.addTestSuite(StandaloneExecutionTests.class);
		result.addTestSuite(StandaloneParserTests.class);
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			result.addTestSuite(CompletionProposalTests.class);
			result.addTestSuite(ConsoleTests.class);
			result.addTestSuite(EditorTests.class);
			result.addTestSuite(FileNewWizardTest.class);
		}
		return result;
	}

	public Object run(Object args)
		throws Exception {

		TestRunner.run(suite());
		return Arrays
			.asList(new String[] {"Please see raw test suite output for details."});
	}
}

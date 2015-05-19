/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl;

/**
 * Tests.
 */
public abstract class AbstractGrammarTests extends XtextTestCase
{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	protected void doTestGrammar(URL binaryURL, @NonNull Resource javaResource) throws IOException, InterruptedException {
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		//
		//	Load binary grammar
		//
		ResourceSet resourceSet = ocl.getResourceSet();
		File binaryFile = new File(binaryURL.getFile());
		URI binaryURI = URI.createFileURI(binaryFile.toString());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xtextbin", new BinaryGrammarResourceFactoryImpl());
		Resource binaryResource = resourceSet.getResource(binaryURI, true);
		assert binaryResource != null;
		assertNoResourceErrors("Load failed", binaryResource);
		assertNoUnresolvedProxies("Java Model", binaryResource);
		assertNoValidationErrors("File Model", binaryResource);
		//
		//	Load Java grammar.
		//
		assertNoResourceErrors("Java Model", javaResource);
		assertNoUnresolvedProxies("Java Model", javaResource);
		assertNoValidationErrors("Java Model", javaResource);
		//
		//	Check similar content
		//
		TestUtil.assertSameModel(binaryResource, javaResource);
		ocl.dispose();
	}
}

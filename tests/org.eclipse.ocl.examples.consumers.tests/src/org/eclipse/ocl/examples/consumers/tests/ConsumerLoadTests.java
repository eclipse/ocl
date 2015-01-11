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
package org.eclipse.ocl.examples.consumers.tests;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.test.xtext.LoadTests;
import org.eclipse.ocl.pivot.uml.UMLStandaloneSetup;
import org.eclipse.ocl.pivot.uml.internal.utilities.UMLEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
@SuppressWarnings("null")
public class ConsumerLoadTests extends LoadTests
{

	public void testLoad_Bug457203_ocl() throws IOException, InterruptedException {
		UMLStandaloneSetup.init();
		OCL ocl = OCL.newInstance(new UMLEnvironmentFactory(null, null));
		metamodelManager = ocl.getMetamodelManager();
		String bug457203 = 
				"import marte: _'http://www.eclipse.org/papyrus/MARTE/1'\n" + 
				"import sysml: _'http://www.eclipse.org/papyrus/0.7.0/SysML'\n" + 
				"\n";
		createOCLinEcoreFile("Bug457203.ocl", bug457203);
		Resource asResource = doLoad_Concrete("Bug457203", "ocl");
		assertNoResourceErrors("Save", asResource);
	}
}

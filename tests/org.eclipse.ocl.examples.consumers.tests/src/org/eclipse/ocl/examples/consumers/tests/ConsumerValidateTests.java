/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.consumers.tests;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.tests.AbstractValidateTests;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.StringUtil;

/**
 * Tests that OCL validation works on consumer models such as SysML.
 */
public class ConsumerValidateTests extends AbstractValidateTests
{	
	public void testValidate_umlrt_profile_uml() throws IOException, InterruptedException {
		//
		//	Create model
		//
		OCL ocl = OCL.newInstance();
		Resource umlResource = doLoadUML(ocl, "umlrt.profile");
		assertNotNull(umlResource);
		assert umlResource != null;
		assertUMLOCLValidationDiagnostics(ocl, "UML Load", umlResource,
			StringUtil.bind(PivotMessagesInternal.ParsingError, "UMLRealTime::Capsule::A deliberately bad constraint::This is not OCL",
				"The 'UMLRealTime::Capsule' constraint is invalid: 'This is not OCL'\n1: no viable alternative at input 'is'")
			);
		ocl.dispose();
	}
}

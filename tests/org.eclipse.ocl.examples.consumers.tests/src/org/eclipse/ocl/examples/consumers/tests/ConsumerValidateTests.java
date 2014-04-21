/**
 * <copyright>
 *
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.consumers.tests;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.test.xtext.AbstractValidateTests;

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
			DomainUtil.bind(OCLMessages.ParsingError, "Opaque Expression", "Errors in 'This is not OCL'\n1: no viable alternative at input 'is'")
			);
		ocl.dispose();
	}
}

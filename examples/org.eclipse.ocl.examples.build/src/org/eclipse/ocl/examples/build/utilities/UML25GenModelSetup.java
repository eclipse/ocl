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
package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;

/**
 * Initializes UML 2.5 genmodel support.
 */
public class UML25GenModelSetup extends UMLGenModelSetup
{
	public UML25GenModelSetup() {
		EssentialOCLLinkingService.DEBUG_RETRY = true;
	}
	
	@Override
	public void setResourceSet(ResourceSet resourceSet) {
		EssentialOCLStandaloneSetup.doSetup();
		super.setResourceSet(resourceSet);
		if (resourceSet != null) {
			ASResourceFactoryRegistry.INSTANCE.configureResourceSet(resourceSet);
		}
	}
}

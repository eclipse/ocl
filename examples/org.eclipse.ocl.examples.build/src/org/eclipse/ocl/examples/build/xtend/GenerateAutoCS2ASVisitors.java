/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.xtend;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.build.xtend.GenerateCSVisitors;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;

public class GenerateAutoCS2ASVisitors extends GenerateCSVisitors
{
	
	@Override
	protected void doSetup() {
		EssentialOCLStandaloneSetup.doSetup();
		OCLstdlib.install();
	}
	
	@SuppressWarnings("null")
	@Override
	public void generateVisitors(@NonNull GenPackage genPackage) {
		if (isDerived()) {
			AutoCodeGenerator.generate(genPackage, projectPrefix, projectName, visitorPackageName, visitorClassName,
				superProjectPrefix, superProjectName, superVisitorClassName);
		} else {
			AutoCodeGenerator.generate(genPackage, projectPrefix, projectName, visitorPackageName, visitorClassName,
				null, null, null);
		}
	}
}

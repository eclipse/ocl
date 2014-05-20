/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.examples.pivot.scoping.Attribution;
import org.eclipse.ocl.examples.xtext.base.attributes.ConstraintCSAttribution;
import org.eclipse.ocl.examples.xtext.oclstdlib.attributes.LibOperationCSAttribution;
import org.eclipse.ocl.examples.xtext.oclstdlib.attributes.LibPackageCSAttribution;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage;

public class OCLstdlibScoping
{	
	public static void init() {
		Map<EClassifier, Attribution> registry = Attribution.REGISTRY;
		registry.put(OCLstdlibCSPackage.Literals.LIB_CONSTRAINT_CS, ConstraintCSAttribution.INSTANCE);
		registry.put(OCLstdlibCSPackage.Literals.LIB_ITERATION_CS, LibOperationCSAttribution.INSTANCE);
		registry.put(OCLstdlibCSPackage.Literals.LIB_OPERATION_CS, LibOperationCSAttribution.INSTANCE);
		registry.put(OCLstdlibCSPackage.Literals.LIB_PACKAGE_CS, LibPackageCSAttribution.INSTANCE);
	}
}

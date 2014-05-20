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
package org.eclipse.ocl.examples.build.xtend

import org.eclipse.emf.ecore.EPackage
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

public class GenerateCGVisitors extends GenerateVisitors
{
	override void generateVisitors(@NonNull GenPackage genPackage) {
		var EPackage ePackage = genPackage.getEcorePackage();
		ePackage.generateAbstractExtendingVisitor();
		ePackage.generateAbstractNonNullExtendingVisitor();
		ePackage.generateVisitorInterface();
		/* ePackage.generateDecorableVisitorInterface("org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor"); */
		ePackage.generateAbstractVisitor();
		ePackage.generateAbstractNullVisitor();
	}
}

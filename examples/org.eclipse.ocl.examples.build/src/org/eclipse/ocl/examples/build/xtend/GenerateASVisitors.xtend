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
import org.eclipse.ocl.pivot.utilities.AS2Moniker
import org.eclipse.ocl.pivot.utilities.AS2XMIid
import org.eclipse.ocl.pivot.utilities.ASSaver
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

public class GenerateASVisitors extends GenerateVisitors
{
	override void generateVisitors(@NonNull GenPackage genPackage) {
		var EPackage ePackage = genPackage.getEcorePackage();
		if (!isDerived()) {
			ePackage.generateVisitableInterface();
		}
		ePackage.generateVisitorInterface();
		ePackage.generateAbstractVisitor();
		ePackage.generateAbstractNullVisitor();
		ePackage.generateAbstractDelegatingVisitor();
		ePackage.generateAbstractExtendingVisitor();
		ePackage.generateAbstractWrappingVisitor();
		if (isDerived()) {
			ePackage.generateAbstractGenericVisitor("AS2XMIid", typeof(Boolean), typeof(AS2XMIid));
			ePackage.generateAbstractGenericVisitor("AS2Moniker", typeof(Object), typeof(AS2Moniker));
			ePackage.generateAbstractGenericVisitor("ASSaverLocate", typeof(Object), typeof(ASSaver));
			ePackage.generateAbstractGenericVisitor("ASSaverNormalize", typeof(Object), typeof(ASSaver));
			ePackage.generateAbstractGenericVisitor("ASSaverResolve", typeof(Object), typeof(ASSaver));
//			ePackage.generateAbstractGenericVisitor("Stepper", typeof(IStepper), typeof(Object));
		}
		/* ePackage.generateDecorableVisitorInterface("org.eclipse.ocl.pivot.util.Visitor"); */
	}
}

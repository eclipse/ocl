/*******************************************************************************
 * Copyright (c) 2009, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.tests;

import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;

/**
 * Test suite with a simple model.
 */
@SuppressWarnings("nls")
public abstract class PivotSimpleTestSuite extends PivotTestSuite
{
    Model root;
	org.eclipse.ocl.pivot.Package pkg1;
	org.eclipse.ocl.pivot.Package pkg2;
	org.eclipse.ocl.pivot.Package pkg3;
	org.eclipse.ocl.pivot.Package pkg4;
	org.eclipse.ocl.pivot.Package pkg5;
	org.eclipse.ocl.pivot.Package jim;
	org.eclipse.ocl.pivot.Package bob;
	org.eclipse.ocl.pivot.Package george;

	protected PivotSimpleTestSuite(boolean useCodeGen) {
		super(useCodeGen);
	}

    @SuppressWarnings("null")
	@Override
    protected void setUp() throws Exception {
        super.setUp();
		MetamodelManager metamodelManager = ocl.getMetamodelManager();
		metamodelManager.addGlobalNamespace(PivotConstantsInternal.OCL_NAME, metamodelManager.getASmetamodel());

        // need a metamodel that has a reflexive EReference.
        // Ecore will do nicely. Create the following structure:
        // pkg1
        //  pkg2
        //   jim
        //  bob
        //  pkg3
        //   pkg4
        //   pkg5
        //    george

        root = createModel();
        pkg1 = createPackage(root, "pkg1");
        pkg2 = createPackage(pkg1, "pkg2");
        jim = createPackage(pkg2, "jim");
        bob = createPackage(pkg1, "bob");
        pkg3 = createPackage(pkg1, "pkg3");
        pkg4 = createPackage(pkg3, "pkg4");
        pkg5 = createPackage(pkg3, "pkg5");
        george = createPackage(pkg5, "george");
    }
}

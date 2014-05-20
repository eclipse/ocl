/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;

public class TestPrettyPrinter extends XtextTestCase
{
	public void testDeclarations() throws Exception {
		URI libraryURI = getProjectFileURI("OCL-2.3.oclstdlib");
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(libraryURI, true);
		Resource asResource = xtextResource.getASResource(null);
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof NamedElement) {
				String s = PrettyPrinter.printName((Element) eObject);
				System.out.println(eObject.eClass().getName() + " : " + s);
			}
		}
	}
	
	public void testSignatures() throws Exception {
		URI libraryURI = getProjectFileURI("OCL-2.3.oclstdlib");
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(libraryURI, true);
		Resource asResource = xtextResource.getASResource(null);
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof NamedElement) {
				String s = PrettyPrinter.printType((Element) eObject);
				System.out.println(eObject.eClass().getName() + " : " + s);
			}
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.latex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;

public abstract class GenerateLaTeXForModelUtils extends GenerateLaTeXForModel
{
	protected final @NonNull Comparator<ENamedElement> namedComparator = new Comparator<ENamedElement>()
	{
		public int compare(ENamedElement o1, ENamedElement o2) {
			String m1 = o1.getName(); 
			String m2 = o2.getName();
			if (m1 == null) m1 = "";
			if (m2 == null) m2 = "";
			return m1.compareTo(m2);
		}
	};

	protected @NonNull List<EClass> getSortedEClasses(@NonNull EPackage ePackage) {
		Set<EClass> allElements = new HashSet<EClass>();
		TreeIterator<EObject> tit = ePackage.eAllContents();
		while (tit.hasNext()) {
			EObject eObject = tit.next();
			if (eObject instanceof EClass) {
				allElements.add((EClass)eObject);
			}
		}
		List<EClass> sortedElements = new ArrayList<EClass>(allElements);
		Collections.sort(sortedElements, namedComparator);
		return sortedElements;
	}
}

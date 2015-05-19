/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.attributes;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;

public class PathElementCSAttribution extends AbstractAttribution
{
	public static final @NonNull PathElementCSAttribution INSTANCE = new PathElementCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		PathElementCS csPathElement = (PathElementCS)target;
		EClassifier eClassifier = csPathElement.getElementType();
		if (eClassifier == null) {									// If this is actually a definition
			Element element = csPathElement.basicGetReferredElement();
			if (!element.eIsProxy()) {
				environmentView.addNamedElement((NamedElement)element);
			}
			return null;
		}
		EClassifier savedRequiredType = environmentView.getRequiredType();
		boolean savedIsQualifier = environmentView.isQualifier();
		ScopeFilter scopeFilter = null;
		try {
			environmentView.setRequiredType(eClassifier);
			PathNameCS csPathName = csPathElement.getOwningPathName();
			List<PathElementCS> path = csPathName.getOwnedPathElements();
			int index = path.indexOf(csPathElement);
			boolean lastElement = index >= path.size()-1;
			environmentView.setIsQualifier(!lastElement);
			if (lastElement) {			// Last element may have a scope filter
				scopeFilter = csPathName.getScopeFilter();
				if (scopeFilter != null) {
					environmentView.addFilter(scopeFilter);
				}
			}
			if (index <= 0) {						// First path element is resolved in parent's parent scope
				environmentView.computeLookups(scopeView.getParent().getParent());
			}
			else {									// Subsequent elements in previous scope
				Element parent = path.get(index-1).getReferredElement();
				if ((parent != null) && !parent.eIsProxy()) {
//					environmentView.computeLookups(parent, null);
					environmentView.computeQualifiedLookups(parent);
				}
			}
			return null;
		}
		finally {
			if (scopeFilter != null) {
				environmentView.removeFilter(scopeFilter);
			}
			environmentView.setRequiredType(savedRequiredType);
			environmentView.setIsQualifier(savedIsQualifier);
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationOperatorCS;

public class InvocationExpCSAttribution extends AbstractAttribution
{
	public static final @NonNull InvocationExpCSAttribution INSTANCE = new InvocationExpCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		if (isRequiredType(environmentView)) {
			InvocationExpCS targetElement = (InvocationExpCS)target;
			NavigationOperatorCS csNavigationOperator = NavigationUtil.getNavigationOperator(targetElement);
			if (csNavigationOperator != null) {											// For a->X(); X must be resolved in the navigation source type
				Type explicitSourceType = targetElement.getSourceType();
				if (explicitSourceType != null) {
					ScopeFilter filter = createInvocationFilter(targetElement, explicitSourceType);
					try {
						environmentView.addFilter(filter);
						environmentView.addElementsOfScope(explicitSourceType, scopeView);
					}
					finally {
						environmentView.removeFilter(filter);
					}
				}
				return null;
			}
			else {																		// For X(); X is resolved in the ancestors
				ScopeFilter filter = createInvocationFilter(targetElement, null);
				try {
					environmentView.addFilter(filter);
					environmentView.computeLookups(scopeView.getParent());
					return null;
				}
				finally {
					environmentView.removeFilter(filter);
				}
			}
		}
		return scopeView.getParent();
	}

	// QVTd variation point
	protected @NonNull ScopeFilter createInvocationFilter(@NonNull InvocationExpCS targetElement, @Nullable Type type) {
		return new OperationFilter(type, targetElement);
	}

	// QVTd variation point
	protected boolean isRequiredType(@NonNull EnvironmentView environmentView) {
		return environmentView.accepts(PivotPackage.Literals.OPERATION);
	}
}

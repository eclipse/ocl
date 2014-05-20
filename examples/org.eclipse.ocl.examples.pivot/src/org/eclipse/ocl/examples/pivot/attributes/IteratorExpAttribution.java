/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;

public class IteratorExpAttribution extends AbstractAttribution
{
	public static final IteratorExpAttribution INSTANCE = new IteratorExpAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		IteratorExp targetExpression = (IteratorExp)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == PivotPackage.Literals.LOOP_EXP__BODY) {
			OCLExpression source = targetExpression.getSource();
			environmentView.addElementsOfScope(source.getType(), scopeView);
			environmentView.addElements(targetExpression.getIterator());
		}
		else if (containmentFeature == PivotPackage.Literals.LOOP_EXP__ITERATOR) {
			OCLExpression source = targetExpression.getSource();
			environmentView.addElementsOfScope(source.getType(), scopeView);
			EObject child = scopeView.getChild();
			for (Variable iterator : targetExpression.getIterator()) {
				if (iterator != null) {
					environmentView.addNamedElement(iterator);
					if (iterator == child) {
						break;
					}
				}
			}
		}
		return scopeView.getParent();
	}
}

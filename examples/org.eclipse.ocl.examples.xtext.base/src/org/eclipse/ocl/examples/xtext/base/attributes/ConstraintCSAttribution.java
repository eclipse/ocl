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
package org.eclipse.ocl.examples.xtext.base.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;

public class ConstraintCSAttribution extends AbstractAttribution
{
	public static final ConstraintCSAttribution INSTANCE = new ConstraintCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ConstraintCS targetElement = (ConstraintCS)target;
		Constraint pivot = PivotUtil.getPivot(Constraint.class, targetElement);
		if (pivot != null) {
			OpaqueExpression specification = pivot.getSpecification();
			if (specification instanceof ExpressionInOCL) {
				Variable contextVariable = ((ExpressionInOCL)specification).getContextVariable();
				if (contextVariable != null) {
					environmentView.addNamedElement(contextVariable);
					Type type = contextVariable.getType();
					environmentView.addElementsOfScope(type, scopeView);
				}
				Variable resultVariable = ((ExpressionInOCL)specification).getResultVariable();
				if (resultVariable != null) {
					environmentView.addNamedElement(resultVariable);
				}
			}
		}
		return scopeView.getParent();
	}
}

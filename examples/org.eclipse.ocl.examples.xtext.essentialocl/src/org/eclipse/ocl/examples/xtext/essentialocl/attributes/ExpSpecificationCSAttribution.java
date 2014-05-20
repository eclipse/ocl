/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;

public class ExpSpecificationCSAttribution extends AbstractAttribution
{
	public static final @NonNull ExpSpecificationCSAttribution INSTANCE = new ExpSpecificationCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ExpSpecificationCS targetElement = (ExpSpecificationCS)target;
		ExpressionInOCL asExpression = PivotUtil.getContainingExpressionInOCL(targetElement.getPivot());
		if (asExpression != null) {
			Variable resultVariable = asExpression.getResultVariable();
			if (resultVariable != null) {
				environmentView.addNamedElement(resultVariable);
			}
			for (Variable parameterVariable : asExpression.getParameterVariable()) {
				assert parameterVariable != null;
				environmentView.addNamedElement(parameterVariable);
			}
			Variable contextVariable = asExpression.getContextVariable();
			if (contextVariable != null) {
				environmentView.addNamedElement(contextVariable);
				if (!environmentView.hasFinalResult()) {
					Type type = contextVariable.getType();
					if (type != null)
					{
						environmentView.addElementsOfScope(type, scopeView);
						environmentView.addElementsOfScope(type.getPackage(), scopeView);
					}
				}
			}
		}
		return scopeView.getParent();
	}
}

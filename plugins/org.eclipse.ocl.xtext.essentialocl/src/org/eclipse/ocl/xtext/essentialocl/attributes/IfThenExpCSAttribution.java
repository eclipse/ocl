/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.IfPatternExp;
import org.eclipse.ocl.pivot.PatternExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;

public class IfThenExpCSAttribution extends AbstractAttribution
{
	public static final IfThenExpCSAttribution INSTANCE = new IfThenExpCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		if (environmentView.accepts(PivotPackage.Literals.VARIABLE)) {
			IfPatternExp asTarget = PivotUtil.getPivot(IfPatternExp.class, (IfThenExpCS)target);
			if (asTarget != null) {
				PatternExp asPattern = asTarget.getOwnedPattern();
				if (asPattern != null) {
					environmentView.addNamedElements(asPattern.getOwnedVariables());
					if (environmentView.hasFinalResult()) {
						return null;							// Let variables occlude outer scopes
					}
				}
			}
		}
		return scopeView.getParent();
	}
}

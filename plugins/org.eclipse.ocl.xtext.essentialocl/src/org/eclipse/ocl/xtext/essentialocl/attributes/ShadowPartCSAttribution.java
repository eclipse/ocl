/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;

public class ShadowPartCSAttribution extends AbstractAttribution
{
	public static final @NonNull ShadowPartCSAttribution INSTANCE = new ShadowPartCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSPackage.Literals.SHADOW_PART_CS__REFERRED_PROPERTY) {
			ShadowPartCS targetElement = (ShadowPartCS)target;
			CurlyBracketedClauseCS csCurlyBracketClause = targetElement.getOwningCurlyBracketClause();
			AbstractNameExpCS csNameExp = csCurlyBracketClause.getOwningNameExp();
			ShadowExp pivot = PivotUtil.getPivot(ShadowExp.class, csNameExp);
			if (pivot != null) {
				Type type = pivot.getType();
				if (type instanceof org.eclipse.ocl.pivot.Class) {
					environmentView.addAllProperties((org.eclipse.ocl.pivot.Class)type, FeatureFilter.SELECT_NON_STATIC);
				}
			}
			return null;
		}
		return scopeView.getParent();
	}
}

/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
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
import org.eclipse.ocl.pivot.ConstructorExp;
import org.eclipse.ocl.pivot.FeatureFilter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtilInternal;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;

public class ConstructorPartCSAttribution extends AbstractAttribution
{
	public static final @NonNull ConstructorPartCSAttribution INSTANCE = new ConstructorPartCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSPackage.Literals.CONSTRUCTOR_PART_CS__REFERRED_PROPERTY) {
			ConstructorPartCS targetElement = (ConstructorPartCS)target;
			CurlyBracketedClauseCS csCurlyBracketClause = targetElement.getOwningCurlyBracketClause();
			AbstractNameExpCS csNameExp = csCurlyBracketClause.getOwningNameExp();
			ConstructorExp pivot = PivotUtilInternal.getPivot(ConstructorExp.class, csNameExp);
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

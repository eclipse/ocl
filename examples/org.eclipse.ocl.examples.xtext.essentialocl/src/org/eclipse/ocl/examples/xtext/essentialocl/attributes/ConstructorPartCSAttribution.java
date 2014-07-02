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
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;

public class ConstructorPartCSAttribution extends AbstractAttribution
{
	public static final @NonNull ConstructorPartCSAttribution INSTANCE = new ConstructorPartCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSPackage.Literals.CONSTRUCTOR_PART_CS__PROPERTY) {
			ConstructorPartCS targetElement = (ConstructorPartCS)target;
			CurlyBracketedClauseCS csCurlyBracketClause = targetElement.getCurlyBracketClause();
			NameExpCS csNameExp = csCurlyBracketClause.getNameExp();
			ConstructorExp pivot = PivotUtil.getPivot(ConstructorExp.class, csNameExp);
			if (pivot != null) {
				Type type = pivot.getType();
				if (type != null) {
					environmentView.addAllProperties(type, FeatureFilter.SELECT_NON_STATIC);
				}
			}
			return null;
		}
		return scopeView.getParent();
	}
}

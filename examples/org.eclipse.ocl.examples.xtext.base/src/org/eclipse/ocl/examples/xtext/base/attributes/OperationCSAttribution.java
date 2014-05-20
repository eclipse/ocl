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
package org.eclipse.ocl.examples.xtext.base.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;

public class OperationCSAttribution extends AbstractAttribution
{
	public static final OperationCSAttribution INSTANCE = new OperationCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		OperationCS targetElement = (OperationCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		Operation pivot = PivotUtil.getPivot(Operation.class, targetElement);
		if (pivot != null) {
			if (containmentFeature == BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETER) {
			}
			else {
				environmentView.addAllParameters(pivot);
			}
			environmentView.addAllTemplateParameters(pivot);
		}
		return scopeView.getParent();
	}
}

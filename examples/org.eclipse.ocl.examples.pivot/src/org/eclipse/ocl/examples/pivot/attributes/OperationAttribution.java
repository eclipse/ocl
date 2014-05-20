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
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class OperationAttribution extends AbstractAttribution
{
	public static final OperationAttribution INSTANCE = new OperationAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Operation targetOperation = (Operation)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
//		TypeBindingsCS bindings = scopeView.getBindings();
//		Operation target = getTarget();
		if (containmentFeature == PivotPackage.Literals.OPERATION__OWNED_PARAMETER) {
		}
		else {
			environmentView.addAllParameters(targetOperation);
		}
		environmentView.addElements(PivotUtil.getTypeTemplateParameterables(targetOperation));
		return scopeView.getParent();
	}
}

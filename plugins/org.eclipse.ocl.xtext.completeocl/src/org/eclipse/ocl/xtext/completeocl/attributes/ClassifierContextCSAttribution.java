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
package org.eclipse.ocl.xtext.completeocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;

public class ClassifierContextCSAttribution extends AbstractAttribution
{
	public static final @NonNull ClassifierContextCSAttribution INSTANCE = new ClassifierContextCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ClassifierContextDeclCS targetElement = (ClassifierContextDeclCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS__OWNED_INVARIANTS) {
			org.eclipse.ocl.examples.pivot.Class type = targetElement.getReferredClass();
			if (type != null) {
				environmentView.addAllOperations(type, FeatureFilter.SELECT_NON_STATIC);
				environmentView.addAllProperties(type, FeatureFilter.SELECT_NON_STATIC);
			}
		}
		return scopeView.getParent();
	}
}

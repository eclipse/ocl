/**
 * <copyright>
 *
 * Copyright (c) 2012,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;

public class ExtensionTypeAttribution extends ClassAttribution
{
	public static final @NonNull ExtensionTypeAttribution INSTANCE = new ExtensionTypeAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		// An ElementExtension is a static object so static and non-static features can be used equally
		ElementExtension targetClass = (ElementExtension) target;
		Type stereotype = targetClass.getStereotype();
		if (stereotype != null) {
			environmentView.addAllOperations(stereotype, FeatureFilter.SELECT_NON_STATIC);	// Operations are in the stereotype
		}
		environmentView.addAllProperties(targetClass, FeatureFilter.SELECT_NON_STATIC);		// AbstractTypeServer.initStereotypePropertiesFrom creates local properties
		if (!environmentView.hasFinalResult()) {
//			Metaclass<?> metaclass = environmentView.getMetaModelManager().getMetaclass(targetClass);
//			environmentView.addAllProperties(metaclass, false);
			if (stereotype != null) {
				environmentView.addAllOperations(stereotype, FeatureFilter.SELECT_STATIC);
			}
			environmentView.addAllProperties(targetClass, FeatureFilter.SELECT_STATIC);
		}
		return scopeView.getParent();
	}
}

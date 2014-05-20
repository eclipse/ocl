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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedTypeRefCS;

public class ReferenceCSAttribution extends AbstractAttribution
{
	public static final ReferenceCSAttribution INSTANCE = new ReferenceCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ReferenceCS targetElement = (ReferenceCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if ((containmentFeature == BaseCSPackage.Literals.REFERENCE_CS__OPPOSITE) 
		 || (containmentFeature == BaseCSPackage.Literals.REFERENCE_CS__KEYS)) {
			TypedRefCS typeRef = targetElement.getOwnedType();
			if (typeRef instanceof TypedTypeRefCS) {
				Element type = ((TypedTypeRefCS)typeRef).getPivot();
				if (type instanceof CollectionType) {
					type = ((CollectionType)type).getElementType();
				}
				if (type instanceof Type) {
					environmentView.computeLookups(type, null);
				}
			}
			return null;
		}
		else {
			return scopeView.getParent();
		}
	}
}

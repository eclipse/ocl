/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.AssociationClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;

/**
 * @since 1.1
 */
public class AssociationClassAttribution extends ClassAttribution
{
	public static final AssociationClassAttribution INSTANCE = new AssociationClassAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		AssociationClass targetClass = (AssociationClass) target;
		String name = environmentView.getName();
		if (name == null) {
			environmentView.addNamedElements(targetClass.getUnownedAttributes());
		}
		else {
			for (Property property : targetClass.getUnownedAttributes()) {
				if (name.equals(property.getName())) {
					environmentView.addNamedElement(property);
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}

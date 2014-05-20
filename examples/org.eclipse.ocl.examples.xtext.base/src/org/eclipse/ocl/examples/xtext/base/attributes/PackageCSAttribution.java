/**
 * <copyright>
 *
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;

public class PackageCSAttribution extends AbstractAttribution
{
	public static final PackageCSAttribution INSTANCE = new PackageCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		PackageCS targetElement = (PackageCS)target;
		org.eclipse.ocl.examples.pivot.Package pivot = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, targetElement);
		if (pivot != null) {
			environmentView.addAllPackages(pivot);
			environmentView.addAllTypes(pivot);
		}
		return scopeView.getParent();
	}
}

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
package org.eclipse.ocl.examples.xtext.completeocl.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;

public class PackageDeclarationCSAttribution extends AbstractAttribution
{
	public static final @NonNull PackageDeclarationCSAttribution INSTANCE = new PackageDeclarationCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		PackageDeclarationCS targetElement = (PackageDeclarationCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSPackage.Literals.PACKAGE_DECLARATION_CS__CONTEXTS) {
			org.eclipse.ocl.examples.pivot.Package pkg = targetElement.getPackage();
			if (pkg != null) {
				environmentView.addAllPackages(pkg);
				environmentView.addAllTypes(pkg);
			}
		}
		return scopeView.getParent();
	}
}

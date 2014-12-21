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
package org.eclipse.ocl.pivot.attributes;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;

public class PackageAttribution extends AbstractAttribution
{
	public static final PackageAttribution INSTANCE = new PackageAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.pivot.Package targetPackage = (org.eclipse.ocl.pivot.Package)target;
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
//		if (targetPackage.getImportedPackage().size() > 0) {
			Set<org.eclipse.ocl.pivot.Package> allPackages = new HashSet<org.eclipse.ocl.pivot.Package>();
			gatherAllPackages(metaModelManager, allPackages, targetPackage);
			for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Package aPackage : allPackages) {
				environmentView.addAllPackages(aPackage);
				environmentView.addAllTypes(aPackage);
			}
//		}
//		else {
//			environmentView.addAllPackages(targetPackage);
//			environmentView.addAllTypes(targetPackage);
//		}
		return scopeView.getParent();
	}

	private void gatherAllPackages(@NonNull MetaModelManager metaModelManager, @NonNull Set<org.eclipse.ocl.pivot.Package> allPackages,
			@NonNull org.eclipse.ocl.pivot.Package targetPackage) {
		org.eclipse.ocl.pivot.Package primaryPackage = metaModelManager.getPrimaryElement(targetPackage);
		if (allPackages.add(primaryPackage)) {
			for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Package partialPackage : metaModelManager.getPartialPackages(primaryPackage, false)) {
				for (@SuppressWarnings("null")@NonNull org.eclipse.ocl.pivot.Package importedPackage : partialPackage.getImportedPackages()) {
					gatherAllPackages(metaModelManager, allPackages, importedPackage);
				}
			}
		}
	}
}

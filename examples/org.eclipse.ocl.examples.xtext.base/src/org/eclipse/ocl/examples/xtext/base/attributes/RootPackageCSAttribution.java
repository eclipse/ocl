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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.scoping.AbstractRootCSAttribution;

public class RootPackageCSAttribution extends AbstractRootCSAttribution
{
	public static final RootPackageCSAttribution INSTANCE = new RootPackageCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		RootPackageCS targetElement = (RootPackageCS)target;
		Model pivotPackage = PivotUtil.getPivot(Model.class, targetElement);
		if (pivotPackage != null) {
			environmentView.addAllPackages(pivotPackage);
		}
		if (environmentView.accepts(PivotPackage.Literals.NAMESPACE)) {
			for (ImportCS anImport : targetElement.getOwnedImport()) {
				Namespace namespace = anImport.getNamespace();
				if ((namespace != null) && !namespace.eIsProxy()) {
					String importName = anImport.getName();
					if (importName == null) {
						if (namespace instanceof org.eclipse.ocl.examples.pivot.Package) {
							environmentView.addAllPackages((org.eclipse.ocl.examples.pivot.Package)namespace);
						}
					}
					else {
						environmentView.addElement(importName, namespace);
					}
				}
			}
			if (!environmentView.hasFinalResult()) {
				environmentView.addRootPackages();
			}
			if ((pivotPackage != null) && !environmentView.hasFinalResult()) {
				Resource eResource = pivotPackage.eResource();
				if (eResource != null) {
					URI baseURI = eResource.getURI();
		           	if (baseURI != null) {
		           		environmentView.addImportedElement(baseURI);
		           	}
				}
			}
		}
		return null;
	}
}

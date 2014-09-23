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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Model;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.base.basecs.ImportCS;
import org.eclipse.ocl.examples.xtext.base.scoping.AbstractRootCSAttribution;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;

public class CompleteOCLDocumentCSAttribution extends AbstractRootCSAttribution
{
	public static final @NonNull CompleteOCLDocumentCSAttribution INSTANCE = new CompleteOCLDocumentCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		CompleteOCLDocumentCS targetElement = (CompleteOCLDocumentCS)target;
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		for (ImportCS anImport : targetElement.getOwnedImport()) {
			Namespace namespace = anImport.getNamespace();
			if ((namespace != null) && !namespace.eIsProxy()) {
				String importName = anImport.getName();
				if (importName != null) {
					environmentView.addElement(importName, namespace);
					environmentView.addNamedElement(namespace);
					if (namespace instanceof Model) {
						environmentView.addAllPackages((Model)namespace);
					} else if (namespace instanceof org.eclipse.ocl.examples.pivot.Package) {		// FIXME This legacy behaviour needs cleaning up
						if (anImport.isAll()) {
							org.eclipse.ocl.examples.pivot.Package rootPackage = (org.eclipse.ocl.examples.pivot.Package)namespace;
							environmentView.addAllPackages(rootPackage);
							environmentView.addAllTypes(rootPackage);
						}
					}
				} else {
					environmentView.addNamedElement(namespace);
					if (namespace instanceof Model) {
						environmentView.addAllPackages((Model)namespace);
					} else if (namespace instanceof org.eclipse.ocl.examples.pivot.Package) {		// FIXME This legacy behaviour needs cleaning up
						for (org.eclipse.ocl.examples.pivot.Package rootPackage : ((org.eclipse.ocl.examples.pivot.Package)namespace).getOwnedPackages()) {
							assert rootPackage != null;
							environmentView.addNamedElement(rootPackage);		// FIXME Rationalize root of pivot model
							environmentView.addAllPackages(rootPackage);
							environmentView.addAllTypes(rootPackage);
						}
					}
				}
			}
		}
		if (!environmentView.hasFinalResult()) {
			metaModelManager.getStandardLibrary().getOclAnyType();
			for (Library library : metaModelManager.getLibraries()) {
				assert library != null;
				environmentView.addNamedElement(library);
			}
		}
		return null;
	}
}

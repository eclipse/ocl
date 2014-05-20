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
package org.eclipse.ocl.examples.xtext.oclstdlib.attributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.attributes.PackageCSAttribution;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaTypeName;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSFactory;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage;

public class LibPackageCSAttribution extends PackageCSAttribution
{
	public static final @NonNull LibPackageCSAttribution INSTANCE = new LibPackageCSAttribution();

	private static Map<String, MetaTypeName> metaTypeNames = null;

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		LibPackageCS targetElement = (LibPackageCS)target;
		if (environmentView.getReference() == OCLstdlibCSPackage.Literals.LIB_CLASS_CS__META_TYPE_NAME) {
			Map<String, MetaTypeName> metaTypeNames2 = metaTypeNames;
			if (metaTypeNames2 == null) {
				Resource metaTypeResource = new ResourceImpl(URI.createURI("internal_list;;//of_meta-type_names"));
				List<EObject> metaTypes = metaTypeResource.getContents();
				metaTypeNames2 = metaTypeNames = new HashMap<String, MetaTypeName>();
				for (EClassifier eClassifier : PivotPackage.eINSTANCE.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						if (PivotPackage.Literals.CLASS.isSuperTypeOf((EClass) eClassifier)) {
							MetaTypeName metaTypeName = OCLstdlibCSFactory.eINSTANCE.createMetaTypeName();
							String name = eClassifier.getName();
							metaTypeName.setName(name);
							metaTypeNames2.put(name, metaTypeName);
							metaTypes.add(metaTypeName);			// Avoid detection of orphans by EnvironmentView.addElement()
						}
					}
				}
			}
			environmentView.addElements(metaTypeNames2);
			return null;
		}
		else {
			Library pivot = PivotUtil.getPivot(Library.class, targetElement);
			if (pivot != null) {
				environmentView.addAllPrecedences(pivot);
			}
			return super.computeLookup(targetElement, environmentView, scopeView);
		}
	}
}

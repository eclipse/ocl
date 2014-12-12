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
package org.eclipse.ocl.xtext.base.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.scoping.ScopeView;
import org.eclipse.ocl.xtext.base.attributes.RootCSAttribution;

public abstract class AbstractRootCSAttribution extends AbstractAttribution implements RootCSAttribution
{
	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		if (environmentView.accepts(PivotPackage.Literals.TYPE)) {
			for (Type type : metaModelManager.getGlobalTypes()) {
				if (type != null) {
					environmentView.addNamedElement(type);
				}
			}
		}
		if (environmentView.accepts(PivotPackage.Literals.NAMESPACE)) {
			for (Map.Entry<String, Namespace> entry : metaModelManager.getGlobalNamespaces()) {
				String key = entry.getKey();
				Namespace value = entry.getValue();
				if ((key != null) && (value != null)) {
					environmentView.addElement(key, value);
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}

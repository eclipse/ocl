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
package org.eclipse.ocl.examples.xtext.base.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainNamespace;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.base.attributes.RootCSAttribution;

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
			for (Map.Entry<String, DomainNamespace> entry : metaModelManager.getGlobalNamespaces()) {
				String key = entry.getKey();
				DomainNamespace value = entry.getValue();
				if ((key != null) && (value != null)) {
					environmentView.addElement(key, value);
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}

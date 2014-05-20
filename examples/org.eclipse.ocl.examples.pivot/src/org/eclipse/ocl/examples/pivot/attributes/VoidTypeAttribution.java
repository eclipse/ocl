/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;

public class VoidTypeAttribution extends ClassAttribution
{
	public static final VoidTypeAttribution INSTANCE = new VoidTypeAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		super.computeLookup(target, environmentView, scopeView);
/*		if (!environmentView.hasFinalResult()) {
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			for (PackageServer packageServer : Lists.newArrayList(metaModelManager.getAllPackages())) {		// Avoid CME risk
				for (TypeServer typeServer : packageServer.getMemberTypes()) {
					Type primaryType = typeServer.getPivotType();
					environmentView.addAllOperations(primaryType, false);
					environmentView.addAllProperties(primaryType, false);
				}
			}
		} */
		return scopeView.getParent();
	}
}

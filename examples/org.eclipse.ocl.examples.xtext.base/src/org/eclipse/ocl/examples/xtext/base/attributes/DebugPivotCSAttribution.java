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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS;

public class DebugPivotCSAttribution extends AbstractAttribution
{
	public static final DebugPivotCSAttribution INSTANCE = new DebugPivotCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		if (target instanceof PivotableElementCS) {
			Element pivot = PivotUtil.getPivot(Element.class, (PivotableElementCS)target);
			if ((pivot != null) && (pivot.eResource() != null)) {
				environmentView.computeLookups(pivot, null); //PivotUtil.getPivot(Element.class, scopeView.getChild());	
			}
		}
		return scopeView.getParent();
	}
}

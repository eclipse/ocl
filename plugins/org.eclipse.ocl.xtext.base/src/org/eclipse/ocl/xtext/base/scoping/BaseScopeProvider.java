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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.base.utilities.CS2ASResourceAdapter;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
public class BaseScopeProvider extends AbstractDeclarativeScopeProvider
{
	public static final @NonNull TracingOption LOOKUP = new TracingOption(
		"org.eclipse.ocl.xtext.base", "lookup"); //$NON-NLS-1$//$NON-NLS-2$

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (context == null) {
			return IScope.NULLSCOPE;
		}
		if (reference == null) {
			return IScope.NULLSCOPE;
		}
		Resource csResource = context.eResource();
		if (csResource == null) {
			return IScope.NULLSCOPE;
		}
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(csResource);
		if (metaModelManager == null) {
			return IScope.NULLSCOPE;
		}
		ElementCS csElement = (ElementCS) context;
		@SuppressWarnings("unused")
		CS2ASResourceAdapter resourceAdapter = ((BaseCSResource)csResource).getCS2ASAdapter(null);
		return BaseScopeView.getScopeView(metaModelManager, csElement, reference);
	}
}

/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;

public class TemplateParameterAttribution extends AbstractAttribution
{
	public static final TemplateParameterAttribution INSTANCE = new TemplateParameterAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
//		TemplateParameter targetClass = (TemplateParameter) target;
		StandardLibraryInternal standardLibrary = environmentView.getStandardLibrary();
		org.eclipse.ocl.pivot.Class type = standardLibrary.getOclAnyType(); // WIP use lowerbound
		environmentView.addAllOperations(type, null);
		environmentView.addAllProperties(type, null);
		environmentView.addAllStates(type);
		return null;
	}
}

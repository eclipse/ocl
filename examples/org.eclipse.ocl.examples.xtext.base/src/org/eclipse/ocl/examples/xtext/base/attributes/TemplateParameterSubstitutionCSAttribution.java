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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;

public class TemplateParameterSubstitutionCSAttribution extends AbstractAttribution
{
	public static final TemplateParameterSubstitutionCSAttribution INSTANCE = new TemplateParameterSubstitutionCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
//		TemplateParameterSubstitutionCS targetElement = (TemplateParameterSubstitutionCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		/*if (containmentFeature == BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__FORMAL_TEMPLATE_PARAMETER) {
			TemplateBindingCS templateBinding = getTarget().getOwningTemplateBinding();
			TemplateBindableElementCS templateBindableElement = templateBinding.getOwningTemplateBindableElement();
			if (!(templateBindableElement instanceof TypedTypeRefCS)) {
				return null;
			}
			TypeCS type = ((TypedTypeRefCS)templateBindableElement).getType();
			if (!(type instanceof ClassifierCS)) {
				return null;
			}
			TemplateSignatureCS templateSignature = ((ClassifierCS)type).getOwnedTemplateSignature();
			if (templateSignature == null) {
				return null;
			}
			environmentView.addNamedElements(BaseCSPackage.Literals.TEMPLATE_PARAMETER_CS, templateSignature.getOwnedTemplateParameter());
			return null;
		}
		else*/ if (containmentFeature == BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER) {
			return scopeView.getParent().getParent();
		}
		else {
//			TypeCS type = getTarget().getType();
//			environmentView.addElementsOfScope(type, scopeView);
			return scopeView.getParent();
		}
	}
}

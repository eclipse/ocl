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
package org.eclipse.ocl.examples.xtext.oclstdlib.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainNamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateSignatureCS;

public class LibOperationCSAttribution extends AbstractAttribution
{
	public static final @NonNull LibOperationCSAttribution INSTANCE = new LibOperationCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		OperationCS targetElement = (OperationCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
//		TypeBindingsCS bindings = scopeView.getBindings();
		Operation pivot = PivotUtil.getPivot(Operation.class, targetElement);
		if (pivot != null) {
			if (containmentFeature == BaseCSPackage.Literals.OPERATION_CS__OWNED_PARAMETER) {
			}
			else {
				environmentView.addAllParameters(pivot);
			}
			environmentView.addElements(PivotUtil.getTypeTemplateParameterables(pivot));
		}
		else {
			TemplateSignatureCS csTemplateSignature = targetElement.getOwnedTemplateSignature();
			if (csTemplateSignature != null) {
				for (TemplateParameterCS csTemplateParameter : csTemplateSignature.getOwnedTemplateParameter()) {
					TemplateParameter templateParameter = (TemplateParameter) csTemplateParameter.getPivot();
					if (templateParameter != null) {
						ParameterableElement parameteredElement = templateParameter.getParameteredElement();
						if (parameteredElement instanceof DomainNamedElement) {
							environmentView.addNamedElement((DomainNamedElement)parameteredElement);
						}
					}
					else {
//						environmentView.addNamedElement((INamedElement) csTemplateParameter.getParameteredElement());
					}
				}
			}
		}
		return scopeView.getParent();
	}
}

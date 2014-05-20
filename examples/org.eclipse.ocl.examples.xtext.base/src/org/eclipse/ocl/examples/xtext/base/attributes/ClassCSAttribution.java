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
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;

public class ClassCSAttribution extends AbstractAttribution
{
	public static final ClassCSAttribution INSTANCE = new ClassCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ClassCS targetElement = (ClassCS)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
//		TypeBindingsCS bindings = scopeView.getBindings();
		org.eclipse.ocl.examples.pivot.Class pivot = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Class.class, targetElement);
		if (pivot != null) {
			if (containmentFeature == BaseCSPackage.Literals.CLASS_CS__OWNED_SUPER_TYPE) {
				environmentView.addElements(PivotUtil.getTypeTemplateParameterables(pivot));
			}
			else if (containmentFeature == BaseCSPackage.Literals.CLASS_CS__OWNED_META_TYPE) {
//				environmentView.addNamedElement(metaModelManager.getBagTypeType());				
//				environmentView.addNamedElement(metaModelManager.getCollectionTypeType());
//				environmentView.addNamedElement(metaModelManager.getOrderedSetTypeType());
//				environmentView.addNamedElement(metaModelManager.getSequenceTypeType());
//				environmentView.addNamedElement(metaModelManager.getSetTypeType());
//				environmentView.addNamedElement(metaModelManager.getPrimitiveTypeType());
				//				environmentView.addElements(PivotPackage.Literals.TYPE, PivotUtil.getTypeTemplateParameterables(pivot));
			}
			else {
				if (pivot instanceof Metaclass<?>) {
					Type instanceType = ((Metaclass<?>)pivot).getInstanceType();
					if (instanceType != null) {
						environmentView.addAllOperations(instanceType, FeatureFilter.SELECT_STATIC);
						environmentView.addAllProperties(instanceType, FeatureFilter.SELECT_STATIC);
					}
				}
				environmentView.addAllOperations(pivot, FeatureFilter.SELECT_NON_STATIC);
				environmentView.addAllProperties(pivot, FeatureFilter.SELECT_NON_STATIC);
				environmentView.addAllTypeTemplateParameterables(pivot);
			}
		}
		return scopeView.getParent();
	}
}

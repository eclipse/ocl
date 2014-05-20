/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.FeatureFilter;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;

public class MetaclassAttribution extends AbstractAttribution
{
	public static final MetaclassAttribution INSTANCE = new MetaclassAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Metaclass<?> targetClass = (Metaclass<?>) target;
		Type instanceType = targetClass.getInstanceType();
		if (instanceType != null) {
			environmentView.addAllOperations(instanceType, null);
			environmentView.addAllProperties(instanceType, null);
//			Type metatype = environmentView.getMetaModelManager().getPivotType(instanceType.eClass().getName());	// FIXME getMetaType
//			if (metatype != null) {
//				environmentView.addAllOperations(metatype, FeatureFilter.SELECT_STATIC);
//				environmentView.addAllProperties(metatype, FeatureFilter.SELECT_STATIC);
//			}
		}
		if (!environmentView.hasFinalResult()) {
			environmentView.addAllOperations(targetClass, FeatureFilter.SELECT_NON_STATIC);
			environmentView.addAllProperties(targetClass, FeatureFilter.SELECT_NON_STATIC);
//			environmentView.addAllOperations(targetClass, FeatureFilter.SELECT_STATIC);
//			environmentView.addAllProperties(targetClass, FeatureFilter.SELECT_STATIC);
//			if (!environmentView.hasFinalResult()) {
//				environmentView.addAllOperations(targetClass, true);
//				environmentView.addAllProperties(targetClass, true);
//			}
		}
//		if ((instanceType != null) && !environmentView.hasFinalResult()) {
//			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
//			Type metatype = metaModelManager.getPivotType(instanceType.eClass().getName());		// FIXME getMetaType
//			if (metatype != null) {
//				environmentView.addAllOperations(metatype, FeatureFilter.SELECT_STATIC);
//				environmentView.addAllProperties(metatype, FeatureFilter.SELECT_STATIC);
//			}
/*			EObject eTarget = instanceType.getETarget();
			if (eTarget != null) {
				try {
					Element element = environmentView.getMetaModelManager().getPivotOf(Element.class, eTarget.eClass());
					environmentView.addElementsOfScope(element, scopeView);
				} catch (ParserException e) {
					// Ignore parse failure; could be systemic and prolific
				}
			} */
//		}
//		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
/*		if (targetClass.getOwningTemplateParameter() != null) {
			org.eclipse.ocl.examples.pivot.Class type = metaModelManager.getOclAnyType(); // WIP use lowerbound
			environmentView.addAllOperations(type, false);
			environmentView.addAllProperties(type, false);
			environmentView.addAllStates(type);
			return null;
		}
		if (targetClass.getTemplateBinding().size() == 0) {
			EObject scopeTarget = scopeView.getTarget();
			if (scopeTarget instanceof Pivotable) {
				Element pivot = ((Pivotable)scopeTarget).getPivot();
				if (pivot == target) {		// Inherited template parameters are invisible.
					environmentView.addAllTypeTemplateParameterables(targetClass);
				}
			}
		}
		environmentView.addAllOperations(targetClass, false);
		environmentView.addAllProperties(targetClass, false);
		environmentView.addAllStates(targetClass);
		if (!environmentView.hasFinalResult()) {
			if (!(target instanceof Metaclass<?>)) {
				environmentView.addAllOperations(targetClass, true);
				environmentView.addAllProperties(targetClass, true);
			}
			if (target instanceof Metaclass<?>) {	// FIXME MetaclassAttribution
				environmentView.addAllProperties(targetClass, true);
				Type instanceType = ((Metaclass<?>)target).getInstanceType();
				if ((instanceType != null) && (instanceType.getOwningTemplateParameter() == null)) {		// Maybe null
					environmentView.addAllOperations(instanceType, true);
					environmentView.addAllProperties(instanceType, true);
					if (!environmentView.hasFinalResult()) {
						EObject eTarget = instanceType.getETarget();
						if (eTarget != null) {
							try {
								Element element = environmentView.getMetaModelManager().getPivotOf(Element.class, eTarget.eClass());
								environmentView.addElementsOfScope(element, scopeView);
							} catch (ParserException e) {
								// Ignore parse failure; could be systemic and prolific
							}
						}
					}
				}
			}
		} */
		return scopeView.getParent();
	}
}

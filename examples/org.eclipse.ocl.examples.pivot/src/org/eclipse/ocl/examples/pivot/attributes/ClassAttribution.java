/*******************************************************************************
 * Copyright (c) 2010,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

public class ClassAttribution extends AbstractAttribution
{
	public static final ClassAttribution INSTANCE = new ClassAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		org.eclipse.ocl.examples.pivot.Class targetClass = (org.eclipse.ocl.examples.pivot.Class) target;
		assert !(target instanceof Metaclass<?>);
		if (targetClass.getOwningTemplateParameter() != null) {
			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
			org.eclipse.ocl.examples.pivot.Class type = metaModelManager.getOclAnyType(); // WIP use lowerbound
			environmentView.addAllOperations(type, null);
			environmentView.addAllProperties(type, null);
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
		environmentView.addAllOperations(targetClass, null);
		environmentView.addAllProperties(targetClass, null);
		environmentView.addAllStates(targetClass);
//		if (!environmentView.hasFinalResult()) {
//			MetaModelManager metaModelManager = environmentView.getMetaModelManager();
//			Type metatype = metaModelManager.getPivotType(targetClass.eClass().getName());		// FIXME getMetaType
//			if (metatype != null) {
//				environmentView.addAllOperations(metatype, FeatureFilter.SELECT_STATIC);
//				environmentView.addAllProperties(metatype, FeatureFilter.SELECT_STATIC);
//			}
//		}
		return scopeView.getParent();
	}
}

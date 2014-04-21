/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ExplicitNavigationProperty.java,v 1.2 2011/05/07 16:41:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.pivot.ElementExtension;

/**
 * The static instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class BaseProperty extends AbstractProperty
{
	protected @NonNull DomainProperty property;
	
	public BaseProperty(@NonNull DomainProperty property) {
		this.property = property;
	}
	
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
//		return property.getType(); 
		if (sourceValue instanceof ElementExtension) {
			return ((ElementExtension)sourceValue).eContainer(); 
		}
		else if (sourceValue instanceof EObject) {
			EObject eObject = (EObject)sourceValue;
			EClass eClass = eObject.eClass();
			EStructuralFeature eFeature = EcoreUtils.getNamedElement(eClass.getEAllStructuralFeatures(), property.getName());
			return eObject.eGet(eFeature);
		}
		else {
			return null;
		}
	}
}
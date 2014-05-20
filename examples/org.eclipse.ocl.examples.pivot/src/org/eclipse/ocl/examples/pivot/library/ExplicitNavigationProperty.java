/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * An instance of ExplicitNavigationProperty supports evaluation of
 * a property call that navigates a relationship.
 */
public class ExplicitNavigationProperty extends AbstractProperty
{
	protected @NonNull Property property;
	protected @NonNull PropertyId propertyId;
//	protected @NonNull DomainProperty property;
	private EStructuralFeature eFeature = null;
	
	public ExplicitNavigationProperty(@NonNull Property property) {
		this.property = property;
		this.propertyId = property.getPropertyId();
	}
	
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject eObject = asNavigableObject(sourceValue, propertyId); 
		EStructuralFeature eFeature2 = eFeature;
		if (eFeature2 == null) {
			EClass eClass = eObject.eClass();
			eFeature = eFeature2 = eClass.getEStructuralFeature(propertyId.getName());
		}
		// A specialized property such as CollectionType.elementType is returned from the specialized type
		// An unspecialized property such as CollectionType.ownedOperation is returned from the unspecialized type
		if ((eObject instanceof Type) && !eObject.eIsSet(eFeature2)) {
			TemplateableElement rawType = ((Type)eObject).getUnspecializedElement();
			if (rawType != null) {
				eObject = rawType;
			}
		}
		if (eFeature2 != null) {
			Object eValue = eObject.eGet(eFeature2, true);
			if (eValue != null) {
				return evaluator.getIdResolver().boxedValueOf(eValue, eFeature2, returnTypeId);
			}
			
		}
		return null;
	}
}
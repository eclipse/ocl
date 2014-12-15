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
package org.eclipse.ocl.pivot.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.AbstractProperty;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.InvalidValueException;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.PivotConstants;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;

/**
 * The static instance of ImplicitNonCompositionProperty supports evaluation of
 * implicit properties for opposites of non-composition relationships.
 */
public class ImplicitNonCompositionProperty extends AbstractProperty
{
	protected @NonNull Property property;
	
	public ImplicitNonCompositionProperty(@NonNull Property property) {
		this.property = property;
	}
	
	@Override
	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		DomainModelManager modelManager = evaluator.getModelManager();
		Property thatProperty = property.getOpposite();
		Type thatType = DomainUtil.nonNullModel(property.getType());
		boolean isMany = thatType instanceof CollectionType;
		if (isMany) {
			thatType = ((CollectionType)thatType).getElementType();
		}
		List<Object> results = new ArrayList<Object>();
		if (thatType instanceof org.eclipse.ocl.pivot.Class) {
			for (EObject eObject : modelManager.get((org.eclipse.ocl.pivot.Class)thatType)) {
				EClass eClass = eObject.eClass();
				EStructuralFeature eFeature = eClass.getEStructuralFeature(thatProperty.getName());
				Object eGet = eObject.eGet(eFeature);
				if (eFeature.isMany()) {
					for (Object eReference : (List<?>)eGet) {
						if (eReference == sourceValue) {
							results.add(eObject);
						}
					}
				}
				else {
					if (eGet == sourceValue) {
						results.add(eObject);
					}
				}
			}
		}
		if (isMany) {
			return evaluator.getIdResolver().createCollectionOfAll(PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_ORDERED,
				PivotConstants.DEFAULT_IMPLICIT_OPPOSITE_UNIQUE, returnTypeId, results);
		}
		else if (results.size() == 0) {
			return null;
		}
		else if (results.size() == 1) {
			return results.get(0);
		}
		else {
			throw new InvalidValueException("Multiple opposites for " + property);
		}
	}
}
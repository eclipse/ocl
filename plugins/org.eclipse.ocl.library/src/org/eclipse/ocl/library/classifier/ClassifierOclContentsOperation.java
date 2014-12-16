/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.classifier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.DomainEvaluator;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;

/**
 * ClassifierOclContentsOperation realises the Classifier::oclContents() library operation.
 */
public class ClassifierOclContentsOperation extends AbstractUnaryOperation
{
	public static final @NonNull ClassifierOclContentsOperation INSTANCE = new ClassifierOclContentsOperation();

	@Override
	public @NonNull Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject object = asNavigableObject(sourceValue, "oclContents()"); //$NON-NLS-1$
    	Set<Object> collection = new HashSet<Object>();
		for (Object eContent : object.eContents()) {
			if (eContent != null) {
				collection.add(evaluator.getIdResolver().boxedValueOf(eContent));
			}
    	}
    	return createSetValue((CollectionTypeId)returnTypeId, collection);
	}
}

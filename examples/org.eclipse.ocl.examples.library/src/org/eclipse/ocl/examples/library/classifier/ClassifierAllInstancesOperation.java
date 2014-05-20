/*******************************************************************************
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.classifier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.domain.values.SetValue;

/**
 * ClassifierAllInstancesOperation realises the Classifier::allInstances() library operation.
 */
public class ClassifierAllInstancesOperation extends AbstractUnaryOperation
{
	public static final @NonNull ClassifierAllInstancesOperation INSTANCE = new ClassifierAllInstancesOperation();

	@Override
	public @NonNull SetValue evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		DomainType type = asType(sourceVal);
//		if (type instanceof DomainMetaclass) {
//			type = ((DomainMetaclass)type).getInstanceType();
//		}
		DomainModelManager modelManager = evaluator.getModelManager();
		Set<Object> results = new HashSet<Object>();
		Set<?> instances = modelManager.get(type);
		for (Object instance : instances) {
			if (instance != null){
				results.add(evaluator.getIdResolver().boxedValueOf(instance));	// FIXME Move to model manager
			}
		}
		return createSetValue((CollectionTypeId)returnTypeId, results);
	}
}

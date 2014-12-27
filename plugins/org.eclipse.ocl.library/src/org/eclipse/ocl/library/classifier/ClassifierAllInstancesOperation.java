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
package org.eclipse.ocl.library.classifier;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * ClassifierAllInstancesOperation realises the Classifier::allInstances() library operation.
 */
public class ClassifierAllInstancesOperation extends AbstractUnaryOperation
{
	public static final @NonNull ClassifierAllInstancesOperation INSTANCE = new ClassifierAllInstancesOperation();

	@Override
	public @NonNull SetValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		org.eclipse.ocl.pivot.Class type = asClass(sourceVal);
//		if (type instanceof DomainMetaclass) {
//			type = ((DomainMetaclass)type).getInstanceType();
//		}
		ModelManager modelManager = evaluator.getModelManager();
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

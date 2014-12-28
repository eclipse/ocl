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
package org.eclipse.ocl.pivot.library.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

public class EcoreExecutorProperty extends ExecutorProperty implements LibraryProperty
{			// FIXME Eliminate spurious ExecutorProperty rather than AbstractExecutorProperty once API has evolved publicly
	
	protected final @NonNull EStructuralFeature eFeature;
	
	public EcoreExecutorProperty(/*@NonNull*/ EStructuralFeature eFeature, @NonNull Type executorType, int propertyIndex) {
		super(ClassUtil.nonNullModel(eFeature.getName()), executorType, propertyIndex);
		this.eFeature = eFeature;
	}

	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject eObject = ValueUtil.asNavigableObject(sourceValue, eFeature, evaluator);
		Object eValue = eObject.eGet(eFeature);
		return eValue != null ? evaluator.getIdResolver().boxedValueOf(eValue, eFeature, returnTypeId) : null;
	}
	
	public @NonNull EStructuralFeature getEFeature() {
		return eFeature;
	}

	@Override
	public @NonNull LibraryProperty getImplementation() {
		return this;
	}

	@Override
	public void initValue(@NonNull EObject objectValue, @Nullable Object propertyValue) {
		objectValue.eSet(eFeature, propertyValue);
	}
}
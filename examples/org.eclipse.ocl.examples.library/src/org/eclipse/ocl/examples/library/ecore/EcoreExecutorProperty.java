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
package org.eclipse.ocl.examples.library.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorProperty;

public class EcoreExecutorProperty extends ExecutorProperty implements LibraryProperty
{			// FIXME Eliminate spurious ExecutorProperty rather than AbstractExecutorProperty once API has evolved publicly
	
	protected final @NonNull EStructuralFeature eFeature;
	
	public EcoreExecutorProperty(/*@NonNull*/ EStructuralFeature eFeature, @NonNull DomainInheritance executorType, int propertyIndex) {
		super(DomainUtil.nonNullModel(eFeature.getName()), executorType, propertyIndex);
		this.eFeature = eFeature;
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		EObject eObject = ValuesUtil.asNavigableObject(sourceValue, eFeature);
		Object eValue = eObject.eGet(eFeature);
		return eValue != null ? evaluator.getIdResolver().boxedValueOf(eValue, eFeature, returnTypeId) : null;
	}
	
	public @NonNull EStructuralFeature getEFeature() {
		return eFeature;
	}

	public @NonNull LibraryProperty getImplementation() {
		return this;
	}

	@Override
	public void initValue(@NonNull Object objectValue, @Nullable Object propertyValue) {
		((EObject)objectValue).eSet(eFeature, propertyValue);
	}
}
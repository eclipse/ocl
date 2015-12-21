/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation.tx;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.evaluation.tx.LazyObjectManager;

/**
 * A SlotState identifies the assigned/not assigned state of a n Object slot.
 * 
 * @since 1.1
 * @noimplement clients should derive from AbstractSlotState
 */
public interface SlotState
{
	/**
	 * Update the SlotState as a result of an assignment of ecoreValue to the eFeature of eObject.
	 */
	void assigned(@NonNull LazyObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature, @Nullable Object ecoreValue);

	void block(@NonNull Invocation invocation);

	/**
	 * Throw an InvocationFailedException if the eFeature of eObject has not been assigned.
	 */
	void getting(@NonNull LazyObjectManager objectManager, @NonNull EObject eObject, @NonNull EStructuralFeature eFeature) throws InvocationFailedException;
}

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

/**
 * An ObjectManager supervises the state of relevant properties in objects used by a mapping invocation.
 * 
 * getting should be invoked as a pre-access guard to cause the invocation to fail if a not-ready property is accessed.
 * 
 * assigned should be invoked to invocation that a property whose access is guarded is now assigned.
 * 
 * @since 1.1
 * @noimplement clients should derive from AbstractObjectManager
 */
public interface ObjectManager
{
	/**
	 * Mark the eFeature of eObject as assigned with an ecoreValue.
	 */
	void assigned(@NonNull EObject eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue);
	
	/**
	 * Throw an InvocationFailedException if the eFeature of eObject has not yet been assigned.
	 */
	void getting(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature) throws InvocationFailedException;
}

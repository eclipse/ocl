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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.IdResolver;

/** 
 * An Invocation identifies a unique invocation of a Mapping and the objects/values bound to its guard variables.
 * 
 * @noimplement clients should derive from AbstractInvocation
 * @since 1.1
 */
public interface Invocation
{
	/**
	 * Execute the mapping invocation.
	 */
	boolean execute() throws InvocationFailedException, ReflectiveOperationException;

	/**
	 * Insert this Invocation following predecessor, which may be in the blocked or waiting invocations linked list.
	 */
	void insertAfter(@NonNull Invocation predecessor);
	
	/**
	 * Return true if a mapping invocation with thoseValues would be a re-invocation of this invocation.
	 */
	boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues);

	/**
	 * Remove this Invocation from the blocked or waiting invocations linked list.
	 */
	void remove();
}
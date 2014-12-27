/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BasicEnvironment;
import org.eclipse.ocl.pivot.TypedElement;

/**
 * The evaluation environment keeps track of the current values of variables
 * in the evaluation of an OCL expression.
 */
public interface EvaluationEnvironment extends BasicEnvironment
{
	/**
	 * Adds the supplied variable declaration and value binding to the
	 * environment. The variable declaration must not already be bound.
	 * 
	 * @param referredVariable
	 *            the variable declaration to add
	 * @param value
	 *            the associated binding
	 * 
	 * @see #replace(TypedElement, Object)
	 */
	void add(@NonNull TypedElement referredVariable, @Nullable Object value);

	/**
	 * Clears the environment of variables.
	 */
	void clear();

	/**
	 * Returns the value associated with the supplied variable declaration
	 * 
	 * @param referredVariable
	 *            the name whose value is to be returned
	 * @return the value associated with the name
	 */
	@Nullable Object getValueOf(@NonNull TypedElement referredVariable);

	/**
	 * Return the set of all locally registered variables.
	 */
	@NonNull Set<TypedElement> getVariables();

	/**
	 * Removes the supplied variable declaration and binding from the
	 * environment (if it exists) and returns it.
	 * 
	 * @param referredVariable
	 *            the variable declaration to remove
	 * @return the value associated with the removed variable declaration
	 */
	@Nullable Object remove(@NonNull TypedElement referredVariable);

	/**
	 * Replaces the current value of the supplied variable declaration with the
	 * supplied value.
	 * 
	 * @param referredVariable
	 *            the variable declaration
	 * @param value
	 *            the new value
	 */
	void replace(@NonNull TypedElement referredVariable, @Nullable Object value);
}

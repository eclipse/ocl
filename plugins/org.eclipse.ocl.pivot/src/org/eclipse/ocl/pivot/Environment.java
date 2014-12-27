/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *******************************************************************************/

package org.eclipse.ocl.pivot;


/**
 * An Environment stores the variables created while evaluating an OCL expression,
 * including <tt>self</tt>.  It also maintains the context classifier and,
 * if appropriate, operation or property.  This interface is not typically
 * used by clients of the parser API, but by providers of bindings for particular
 * UML-like metamodels.
 * <p>
 * The generic type parameters of this interface represent the UML concepts that
 * the OCL parser and evaluation engine require.  A binding for a particular
 * metamodel (e.g., Ecore or UML) is implemented as a concrete <code>Environment</code>
 * with appropriate metaclasses substituting for these type parameters.
 * </p>
 * <p>
 * This interface is <b>not</b> intended to be implemented "directly" by
 * providers of metamodel bindings.
 * It is highly recommended to extend the {@link AbstractEnvironment} class,
 * instead.
 * </p><p>
 * Since 1.2, the default abstract implementation of this interface
 * ({@link AbstractEnvironment}) implements the {@link Adaptable} protocol to
 * provide dynamic interface adapters.  Use the
 * {@link OCLUtil#getAdapter(Environment, Class)} method to obtain
 * adapters for any environment instance.
 * </p>
 * 
 * @see AbstractEnvironment
 * @see EnvironmentFactoryInternal
 */
public interface Environment extends BasicEnvironment {
}

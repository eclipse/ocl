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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;

/**
 * A factory for creating OCL parser {@link Environment}s.  Clients of the OCL
 * parser that wish to use OCL with their metamodels can provide the parser
 * a factory that creates the suitable environments.  The environment provides
 * mappings from the client's metamodel to the UML concepts required by the
 * parser (corresponding to the generic type parameters, below).  Many of these
 * mappings are optional (e.g., state machines, signals, and association
 * classes aren't supported by all metamodels).
 * <p>
 * This interface is <b>not</b> intended to be implemented to be implemented
 * "directly" by providers of metamodel bindings.
 * It is highly recommended to extend the {@link AbstractEnvironmentFactory}
 * class, instead.
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public interface EnvironmentFactory
{
	
	/**
	 * Creates a root environment, in which package contexts and/or classifier
     * contexts will be created as nested environments.  All operation body
     * constraints, attribute initial/derived value constraints, and definitions
     * of additional attributes and operations should be maintained by the root
     * environment, so that they will be accessible from constraints parsed in
     * any nested environment.
	 * 
	 * @return a new root environment
	 */
	@NonNull Environment createEnvironment();
	
	/**
	 * Creates a child environment of a specified <code>parent</code>, for
	 * definition of nested scopes.
	 * 
	 * @param parent the parent environment
	 * @return the child environment
	 */
	@NonNull Environment createEnvironment(@NonNull Environment parent);

	/**
	 * Creates a new evaluation environment to track the values of variables in
	 * an OCL expression as it is evaluated.
	 * 
	 * @return a new evaluation environment
	 */
	@NonNull EvaluationEnvironment createEvaluationEnvironment();
	
	/**
	 * Creates a new evaluation environment as a nested environment of the
	 * specified <tt>parent</tt>.
	 * 
	 * @param parent a nesting evaluation environment
	 * @return a new nested evaluation environment
	 */
	@NonNull EvaluationEnvironment createEvaluationEnvironment(@NonNull EvaluationEnvironment parent);

	/**
	 * Creates an extent map for invocation of <tt>OclType.allInstances()</tt>
	 * using the specified <code>object</code> as a context from which to find
	 * the scope in which OCL classifier extents are defined.  This scope may
	 * be a resource, resource set, or some metamodel-specific scope.  Note that
	 * in the case that the <code>object</code> is not an
	 * {@link org.eclipse.emf.ecore.EObject} but is, instead, some primitive
	 * type, then this may be difficult to determine.
	 * <p>
	 * Clients are encouraged to do what they can to optimize this mapping, by
	 * lazy initialization of key-value pairs, workspace indices, or whatever
	 * means is available.  Note that the map will only ever be accessed by
	 * key ({@link Map#get(java.lang.Object)}); it will never be queried for
	 * all entries, all keys, all values, etc.  This knowledge could help
	 * optimization.
	 * </p>
	 * 
	 * @param object a context object in the scope that covers the OCL
	 *     classifier extents
	 * @return the extent map
	 */
	@NonNull ModelManager createModelManager(@Nullable Object object);
}

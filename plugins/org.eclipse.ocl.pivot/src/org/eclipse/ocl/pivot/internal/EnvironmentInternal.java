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

package org.eclipse.ocl.pivot.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Adaptable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Environment;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;

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
 * {@link OCLUtil#getAdapter(EnvironmentInternal, Class)} method to obtain
 * adapters for any environment instance.
 * </p>
 * 
 * @see AbstractEnvironment
 * @see EnvironmentFactoryInternal
 */
public interface EnvironmentInternal extends Environment
{
    /**
	 * Obtains the factory that created me, or an appropriate default factory
	 * if I was not created using a factory.  This factory can be used to create
	 * nested environments within me.
	 * 
	 * @return my originating factory
	 * 
	 * @see EnvironmentFactoryInternal#createEnvironment(EnvironmentInternal)
	 */
    @Override
	@NonNull EnvironmentFactoryInternal getEnvironmentFactory();
    
    /**
     * Obtains my parent environment, if I have one.  My parent environment
     * implements a nesting scope of variable names, some of which names
     * may be shadowed by variables in my scope.
     * 
     * @return my parent, or <code>null</code> if I am a root environment
    */
    @Nullable EnvironmentInternal getParent();
	
    /**
     * Obtains my context package, if any.  The constraints in an OCL document
     * need not declare a package context, but it is at least implicit as the
     * nearest package containing the context classifier.
     * 
     * @return my context package
     * 
     * @see #getContextClassifier()
     */
	@Nullable org.eclipse.ocl.pivot.Package getContextPackage();
	
	/**
	 * Obtains the context classifier of this environment.  This is the type
     * of the <tt>self</tt> context variable.
	 * 
	 * @return the context classifier
	 */
	@Nullable org.eclipse.ocl.pivot.Class getContextClassifier();
	
	/**
	 * Obtains the context operation of this environment, if it is an operation
	 * context.
	 * 
	 * @return the context operation, or <code>null</code> if this is not an
	 *     operation environment
	 */
	@Nullable Operation getContextOperation();
	
	/**
	 * Obtains the context property of this environment, if it is a property
	 * context.
	 * 
	 * @return the context property, or <code>null</code> if this is not a
	 *     property environment
	 */
	@Nullable Property getContextProperty();

	@NonNull MetamodelManager getMetamodelManager();

    /**
     * Obtains the collection of core types representing the OCL Standard
     * Library.  These are the singleton or generic instances of the OCL-defined
     * classifiers such as <tt>OclAny</tt>, <tt>Collection(T)</tt>, etc.
     * Implementers of OCL metamodel bindings are encouraged to share a single
     * instance of the standard library amonst all of the <tt>Environment</tt>s
     * constructed by a particular {@link EnvironmentFactoryInternal}.
     * 
     * @return the OCL Standard Library implementation for this environment
     */
	@NonNull StandardLibraryInternal getStandardLibrary();
		
	/**
	 * Sets the "self" variable that is the implicit source of any property,
	 * operation, or association class call.
	 * 
	 * @param var the "self" variable
	 */
	public void setSelfVariable(@NonNull Variable var);
	
	/**
	 * Gets the self variable, looking it up in a parent environment if necessary.
	 * 
	 * @return the self variable, or <code>null</code> if none (which should
     *    only be the case in a root environment having only a package context,
     *    if even that)
	 */
	public @Nullable Variable getSelfVariable();
}

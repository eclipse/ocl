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

package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.EnvironmentRegistryImpl;

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
 * @see EnvironmentFactory
 */
public interface Environment extends BasicEnvironment {
	/**
	 * Namespace URI of the OCL core metamodel, used for example as the
	 * source of certain Ecore annotations.
	 */
	@NonNull String OCL_NAMESPACE_URI = "http://www.eclipse.org/ocl/1.1.0/OCL"; //$NON-NLS-1$
	
    /**
     * The name of the context variable 'self'.
     */
    @NonNull String SELF_VARIABLE_NAME = "self"; //$NON-NLS-1$
    
    /**
     * The name of the operation result variable 'result'.
     */
    @NonNull String RESULT_VARIABLE_NAME = "result"; //$NON-NLS-1$
    
    /**
     * Disposes of any objects that I have created that should be cleaned
     * up.
     */
    void dispose();
   
	/**
	 * Obtains the factory that created me, or an appropriate default factory
	 * if I was not created using a factory.  This factory can be used to create
	 * nested environments within me.
	 * 
	 * @return my originating factory
	 * 
	 * @see EnvironmentFactory#createEnvironment(Environment)
	 */
    @NonNull EnvironmentFactory getFactory();
    
    /**
     * Obtains my parent environment, if I have one.  My parent environment
     * implements a nesting scope of variable names, some of which names
     * may be shadowed by variables in my scope.
     * 
     * @return my parent, or <code>null</code> if I am a root environment
    */
    @Nullable Environment getParent();
	
    /**
     * Obtains my context package, if any.  The constraints in an OCL document
     * need not declare a package context, but it is at least implicit as the
     * nearest package containing the context classifier.
     * 
     * @return my context package
     * 
     * @see #getContextClassifier()
     */
	@Nullable org.eclipse.ocl.examples.pivot.Package getContextPackage();
	
	/**
	 * Obtains the context classifier of this environment.  This is the type
     * of the <tt>self</tt> context variable.
	 * 
	 * @return the context classifier
	 */
	@Nullable Type getContextClassifier();
	
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
	
    /**
     * Obtains the collection of core types representing the OCL Standard
     * Library.  These are the singleton or generic instances of the OCL-defined
     * classifiers such as <tt>OclAny</tt>, <tt>Collection(T)</tt>, etc.
     * Implementers of OCL metamodel bindings are encouraged to share a single
     * instance of the standard library amonst all of the <tt>Environment</tt>s
     * constructed by a particular {@link EnvironmentFactory}.
     * 
     * @return the OCL Standard Library implementation for this environment
     */
	@NonNull DomainStandardLibrary getOCLStandardLibrary();

	@NonNull MetaModelManager getMetaModelManager();
	
	/**
	 * Retrieves a list of all possible states of the specified <code>owner</code>
	 * whose paths are prefixed by the specified partial name.  If the
	 * owner is <code>null</code>, then the target of the <code>oclIsInState()</code>
	 * operation call is implicit and must be looked up in the usual way for
	 * implicit operation call targets.  This method is used for content-assist.
	 * 
	 * @param owner the classifier for which states are being sought.  Can be
	 *    <code>null</code> in the case of an <tt>oclIsInState()</tt> call on an
	 *    implicit target
	 * @param pathPrefix partial path name of the states being sought.  This
	 *    can be empty to find the first level of state names
	 * 
	 * @return the list of all possible states directly contained in the
	 *    namespace indicated by the path prefix (i.e., only one level of
	 *    state nesting)
	 */
	@NonNull List<State> getStates(@NonNull Type owner, @NonNull List<String> pathPrefix);

	/**
	 * Adds a variable declaration to the environment.
	 * If the name is null, then a new unique temporary name is generated (this
     * is useful for implicit variables).
     * 
	 * @param name the name of the variable, or <code>null</code>
	 * @param elem a variable declaration
	 * @param explicit whether this is an explicitly declared variable
     * 
	 * @return <code>true</code> if the variable was successfully added because
     *    it wasn't already declared locally in this environment;
     *    <code>false</code>, otherwise
	 */	
	public boolean addElement(@NonNull String name, @NonNull Variable elem, boolean explicit);
		
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
    
    /**
     * Obtains the definition constraint of the specified feature, if it is an
     * additional attribute or operation defined via an OCL constraint.
     * 
     * @param feature a property or operation
     * @return the definition constraint that defines it, or <code>null</code>
     *    if this feature is not defined by OCL
     */
	Constraint getDefinition(@NonNull Object feature);
    
    /**
     * Obtains a factory for the creation of types that are parameterized
     * by model elements.  This type factory must create types that are
     * instances of the metaclass describing classifiers in the client
     * metamodel.
     * 
     * @return the appropriate type factory
     */
	@NonNull PivotFactory getOCLFactory();
	
    /**
     * A registry of environments.  The registry may be consulted to find a
     * default environment suitable for the introspection of a model element.
     * These environments will never be used for the definition of constraints
     * or variables.
     * <p>
     * This registry may be populated at run-time or, in an Eclipse environment,
     * statically on the <tt>org.eclipse.ocl.environments</tt> extension point.
     * </p>
     * 
     * @author Christian W. Damus (cdamus)
     */
	interface Registry {
        /**
         * The shared registry instance.
         */
		@NonNull Registry INSTANCE = new EnvironmentRegistryImpl();
		
        /**
         * Obtains a suitable environment for introspection of the specified
         * expression.
         * 
         * @param expression a parsed OCL expression
         * @return the matching registered environment, or <code>null</code> if
         *     none is available
         */
		Environment getEnvironmentFor(@NonNull OCLExpression expression);
		
        /**
         * Obtains a suitable environment for introspection of the specified
         * model element, type (such as a collection type), or other abstract
         * syntax element (e.g., a variable).
         * 
         * @param abstractSyntaxElement an element in or referenced by the
         *     AST of of an OCL constraint
         * @return the matching registered environment, or <code>null</code> if
         *     none is available
         */
		Environment getEnvironmentFor(@NonNull Object abstractSyntaxElement);
		
        /**
         * Adds the specified environment to the registry.
         * 
         * @param environment an environment to register
         */
		void registerEnvironment(@NonNull Environment environment);
        
        /**
         * Removes the specified environment from the registry.
         * 
         * @param environment the environment to deregister
         */
        void deregisterEnvironment(@NonNull Environment environment);
	}
}

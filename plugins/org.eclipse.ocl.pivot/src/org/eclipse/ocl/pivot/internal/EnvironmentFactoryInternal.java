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
import org.eclipse.ocl.pivot.Environment;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;

/**
 * A factory for creating OCL parser {@link EnvironmentInternal}s.  Clients of the OCL
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
public interface EnvironmentFactoryInternal extends EnvironmentFactory {
	
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
	@Override
	@NonNull EnvironmentInternal createEnvironment();
	
	/**
	 * Creates a child environment of a specified <code>parent</code>, for
	 * definition of nested scopes.
	 * 
	 * @param parent the parent environment
	 * @return the child environment
	 */
	@Override
	@NonNull EnvironmentInternal createEnvironment(@NonNull Environment parent);
	
	/**
	 * Creates an environment suitable for parsing OCL expressions in the
	 * specified <code>context</code>, which is some classifier
	 * in the client's model.
	 * 
	 * @param context the context classifier
	 * @return the environment
	 * 
	 * @see #createOperationContext(EnvironmentInternal, Operation)
     * @see #createPropertyContext(EnvironmentInternal, Property)
     * @see #createInstanceContext(EnvironmentInternal, Object)
	 */
	@NonNull EnvironmentInternal createClassifierContext(@NonNull EnvironmentInternal parent, @NonNull org.eclipse.ocl.pivot.Class context);
	
    /**
     * Creates an environment suitable for parsing OCL expressions on the
     * specified <code>context</code> object, which is an instance of some
     * classifier in the client's model.
     * <p>
     * The context may be an instance of a model class or a data type value
     * on which an OCL expression would be evaluated.  Note that the actual OCL
     * context classifier (as an OCL type or classifier) will be
     * inferred from the context instance according to the metamodel that the
     * environment factory supports, if possible.  If not possible, then the
     * {@link StandardLibrary#getOclAnyType() OclAny} type is assumed.
     * </p>
     * 
     * @param context the context object or value
     * @return the environment
     * 
     * @see #createClassifierContext(EnvironmentInternal, Type)
     * @see StandardLibrary#getOclAnyType()
     */
	@NonNull EnvironmentInternal createInstanceContext(@NonNull EnvironmentInternal parent, @NonNull Object context);
    
	/**
	 * Creates an environment suitable for parsing OCL expressions on the
	 * specified <code>operation</code>, which is some operation
	 * in the client's metamodel.  Note that operation contexts can be defined
	 * in the context of any classifier to which that operation is applicable.
	 * 
	 * @param parent the parent environment, defining the classifier context
	 * @param operation an operation in the client's metamodel
	 * @return the environment
	 * 
	 * @see #createClassifierContext(EnvironmentInternal, Type)
	 */
	@NonNull EnvironmentInternal createOperationContext(@NonNull EnvironmentInternal parent, @NonNull Operation operation);
	
	/**
	 * Creates an environment suitable for parsing OCL expressions on the
	 * specified <code>property</code>, which is some attribute
	 * in the client's metamodel.  Note that attribute contexts can be defined
	 * in the context of any classifier in which that attribute is available.
	 * 
     * @param parent the parent environment, defining the classifier context
	 * @param property an attribute in the client's metamodel
	 * @return the environment
	 * 
	 * @see #createClassifierContext(EnvironmentInternal, Type)
	 */
	@NonNull EnvironmentInternal createPropertyContext(@NonNull EnvironmentInternal parent, @NonNull Property property);

    /**
     * Creates a new evaluation visitor, for the evaluation of an OCL expression on a context using an environment and a modelManager.
     * If environment is null, a root environment is created and used.
     * If context is null and the expression uses self subsequent evaluations will give invalid as the result.
     * If modelManager is null, the context object's ResoutceSet is analyzed to create one.
     */
	@NonNull EvaluationVisitor createEvaluationVisitor(@Nullable EnvironmentInternal environment, @Nullable Object context, @NonNull ExpressionInOCL expression, @Nullable ModelManager modelManager);
	
    /**
     * Creates a new evaluation visitor, for the evaluation of OCL expressions.
     * 
     * @param env the environment in which the expression was originally parsed
     *    (or some compatible environment)
     * @param evalEnv the evaluation environment that the visitor is to use
     *    for tracking variables, navigating properties, etc.
     * @param modelManager the map of <tt>Class</tt>es to their extends
     * @return the new evaluation visitor
     */
	@NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EnvironmentInternal env, @NonNull EvaluationEnvironment evalEnv, @NonNull ModelManager modelManager);

	@NonNull MetaModelManager getMetaModelManager();
}

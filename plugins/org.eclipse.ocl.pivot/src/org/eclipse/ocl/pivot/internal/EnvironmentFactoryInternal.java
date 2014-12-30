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

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.resource.StandaloneProjectMap;

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
public interface EnvironmentFactoryInternal extends EnvironmentFactory
{
	/**
	 * Create and initialize the AS ResourceSet used by metamodelManager to contain the AS forms of CS and Ecore/UML resources.
	 */
	@NonNull ResourceSetImpl createASResourceSet(@NonNull MetamodelManager metamodelManager);
	@NonNull CompleteEnvironmentInternal createCompleteEnvironment(@NonNull MetamodelManager metamodelManager);

	/**
	 * Create and initialize the IdResolver used by metamodelManager to convert Ids to Elements.
	 */
	@NonNull IdResolver createIdResolver(@NonNull MetamodelManager metamodelManager);
	
	
	@NonNull MetamodelManager createMetamodelManager();

    /**
     * Creates a new evaluation visitor, for the evaluation of an OCL expression on a context using an environment and a modelManager.
     * If environment is null, a root environment is created and used.
     * If context is null and the expression uses self subsequent evaluations will give invalid as the result.
     * If modelManager is null, the context object's ResoutceSet is analyzed to create one.
     */
	@NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Object context, @NonNull ExpressionInOCL expression, @Nullable ModelManager modelManager);
	
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
	@NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv, @NonNull ModelManager modelManager);

	@NonNull MetamodelManager getMetamodelManager();

	@Nullable StandaloneProjectMap getProjectMap();

	void dispose();
}

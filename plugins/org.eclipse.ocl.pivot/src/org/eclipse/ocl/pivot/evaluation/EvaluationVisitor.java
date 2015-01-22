/*******************************************************************************
 * Copyright (c) 2007, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.evaluation;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractEvaluationVisitor;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;

/**
 * A specialized visitor that is used for evaluation an
 * {@linkplain OCLExpression OCL expression} by walking its AST.
 * <p>
 * See the {@link EnvironmentInternal} class for a description of the
 * generic type parameters of this class. 
 * </p>
 */
public interface EvaluationVisitor extends Visitor<Object>, Evaluator
{
	@Override
	@NonNull EvaluationVisitor createNestedEvaluator();

	@Override
	@Nullable Object evaluate(@NonNull OCLExpression body);
	
	/**
     * Obtains the environment factory that created me.
     *  
	 * @return the environment factory
	 */
	@NonNull EnvironmentFactory getEnvironmentFactory();

	/**
     * Obtains the evaluation environment that keeps track of variable values
     * and knows how to call operations, navigate properties, etc.
     * 
	 * @return the evaluation environment
	 */
	@Override
	@NonNull EvaluationEnvironment getEvaluationEnvironment();

	@NonNull EvaluationVisitor getEvaluator();
	
	/**
     * Obtains the mapping of model classes to their extents.
     * 
	 * @return the model manager
	 */
	@Override
	@NonNull ModelManager getModelManager();

	@NonNull MetamodelManager getMetamodelManager();

	@Nullable Monitor getMonitor();

	@Override
	@NonNull StandardLibrary getStandardLibrary();

	@Override
	boolean isCanceled();
	
	@Override
	void setCanceled(boolean isCanceled);

	void setMonitor(@Nullable Monitor monitor);
    
    /**
     * Configures the specified decorated visitor to correctly handle the
     * invocation of recursive <code>visitXxx(...)</code> calls.  In particular,
     * the tail of a chain of decorators is informed (if it is an
     * {@link AbstractEvaluationVisitor} of the head decorator of the chain,
     * so that recursive visitation follows the entire decorator chain at
     * every step.
     * 
     * @param evaluationVisitor the evaluationVisitor that is not decorated/
     */
	void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor);
}

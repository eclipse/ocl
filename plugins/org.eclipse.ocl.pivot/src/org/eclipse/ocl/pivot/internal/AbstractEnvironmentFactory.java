/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation, Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *   Borland - Bug 265066
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Adaptable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.pivot.internal.evaluation.TracingEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.manager.PivotIdResolver;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * Partial implementation of the {@link EnvironmentFactoryInternal} interface, useful
 * for subclassing to define the Pivot binding for a metamodel.
 */
public abstract class AbstractEnvironmentFactory implements EnvironmentFactoryInternal, Adaptable {

    private boolean traceEvaluation;
    
	/**
	 * Initializes me.
	 */
	protected AbstractEnvironmentFactory() {
		super();
	}
	
    /**
     * Creates an environment for the specified package context.
     * 
     * @param parent the parent environment of the environment to be created
     * @param context the package context (must not be <code>null</code>)
     * @return the new nested environment
     */
	protected EnvironmentInternal createPackageContext(@NonNull EnvironmentInternal parent,
			@NonNull org.eclipse.ocl.pivot.Package context) {
		
		EnvironmentInternal result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result)
				.setContextPackage(context);
		}
		
		return result;
	}
	
    // implements the interface method
	@Override
	public @NonNull EnvironmentInternal createClassifierContext(@NonNull EnvironmentInternal parent, @NonNull org.eclipse.ocl.pivot.Class context) {
        
        EnvironmentInternal result =
            createEnvironment(parent);
        
        Variable self = PivotFactory.eINSTANCE.createVariable();
        self.setName(PivotConstants.SELF_NAME);
        self.setType(context);
        
//        result.addElement(self.getName(), self, true);
        result.setSelfVariable(self);
        
        return result;
	}
    
    // implements the interface method
    @Override
	public @NonNull EnvironmentInternal createInstanceContext(@NonNull EnvironmentInternal parent, @NonNull Object context) {       
        return createClassifierContext(parent, getClassifier(context));
    }
	
    // implements the interface method
	@Override
	public @NonNull EnvironmentInternal createOperationContext(@NonNull EnvironmentInternal parent, @NonNull Operation operation) {		
		EnvironmentInternal result = createEnvironment(parent);		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result).setContextOperation(operation);
		}
        for (Parameter next : operation.getOwnedParameters()) {
			// ensure that we use the OCL primitive types wherever possible
			Variable var = PivotFactory.eINSTANCE.createVariable();
			var.setName(next.getName());
			var.setType(next.getType());
			var.setRepresentedParameter(next);		
//			result.addElement(var.getName(), var, true);
		}	
		return result;
	}
	
    // implements the interface method
	@Override
	public @NonNull EnvironmentInternal createPropertyContext(@NonNull EnvironmentInternal parent, @NonNull Property property) {
		
		EnvironmentInternal result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result)
				.setContextProperty(property);
		}
		
		return result;
	}

	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable EnvironmentInternal environment, @Nullable Object context, @NonNull ExpressionInOCL expression, @Nullable ModelManager modelManager) {
		if (environment == null) {
			environment = createEnvironment();
		}
		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
//		context = HelperUtil.getConstraintContext(rootEnvironment, context, expression);
		EvaluationEnvironment evaluationEnvironment = createEvaluationEnvironment();
		Variable contextVariable = expression.getOwnedContext();
		if (contextVariable != null) {
			PivotIdResolver idResolver = getMetamodelManager().getIdResolver();
			Object value = idResolver.boxedValueOf(context);
			evaluationEnvironment.add(contextVariable, value);
		}
		for (Variable parameterVariable : expression.getOwnedParameters()) {
			if (parameterVariable != null) {
				evaluationEnvironment.add(parameterVariable, null);
			}
		}
		ModelManager extents = modelManager;
		if (extents == null) {
			// let the evaluation environment create one
			extents = createModelManager(context);
		}
		return createEvaluationVisitor(environment, evaluationEnvironment, extents);
	}
	
    // implements the interface method
	@Override
	public @NonNull EvaluationVisitor createEvaluationVisitor(@NonNull EnvironmentInternal env, @NonNull EvaluationEnvironment evalEnv,
			@NonNull ModelManager modelManager) {
        EvaluationVisitor result = new EvaluationVisitorImpl(env, evalEnv, modelManager);
        
        if (isEvaluationTracingEnabled()) {
            // decorate the evaluation visitor with tracing support
            result = new TracingEvaluationVisitor(result);
        }
        
        return result;
	}

    /**
     * Obtains client metamodel's classifier for the specified
     * <code>context</code> object, which may be an instance of a classifier
     * in the user model or may actually be a classifier in the user model.
     * 
     * @param context a context object or classifier
     * @return the user model's classifier for this context object, or the
     *     context itself if it is a classifier
     */
    protected abstract @NonNull org.eclipse.ocl.pivot.Class getClassifier(@NonNull Object context);
    
    /**
     * Queries whether tracing of evaluation is enabled.  Tracing
     * logs the progress of evaluation to the console, which may
     * be of use in diagnosing problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * @return whether evaluation tracing is enabled
     * 
     * @see #setEvaluationTracingEnabled(boolean)
     */
    protected boolean isEvaluationTracingEnabled() {
        return traceEvaluation;
    }
    
    /**
     * Sets whether tracing of evaluation is enabled.  Tracing logs
     * the progress of parsing to the console, which may be of use in diagnosing
     * problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * param b whether evaluation tracing is enabled
     * 
     * @see #isEvaluationTracingEnabled()
     */
    public void setEvaluationTracingEnabled(boolean b) {
        traceEvaluation = b;
    }

	/**
	 * The abstract environment factory implementation is adaptable.  The
	 * default implementation adapts to and interface actually implemented by
	 * the receiver.
	 * <p>
	 * Subclasses may override or extend this implementation.
	 * </p>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(java.lang.Class<T> adapterType) {
		T result;
		
		if (adapterType.isAssignableFrom(getClass())) {
			result = (T) this;
		} else {
			result = null;
		}
		
		return result;
	}
}

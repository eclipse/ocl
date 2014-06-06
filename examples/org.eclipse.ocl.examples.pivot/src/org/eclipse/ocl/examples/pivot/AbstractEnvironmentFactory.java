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
package org.eclipse.ocl.examples.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.evaluation.TracingEvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.PivotIdResolver;

/**
 * Partial implementation of the {@link EnvironmentFactory} interface, useful
 * for subclassing to define the Pivot binding for a metamodel.
 */
public abstract class AbstractEnvironmentFactory implements EnvironmentFactory, Adaptable {

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
	protected Environment createPackageContext(@NonNull Environment parent,
			@NonNull org.eclipse.ocl.examples.pivot.Package context) {
		
		Environment result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result)
				.setContextPackage(context);
		}
		
		return result;
	}

    // implements the interface method
/*    public Environment
    createPackageContext(
            Environment parent,
            List<String> pathname) {
		org.eclipse.ocl.examples.pivot.Package contextPackage = lookupPackage(pathname);        
        return (contextPackage == null)? null : createPackageContext(parent, contextPackage);
    } */
	
    // implements the interface method
	public @NonNull Environment createClassifierContext(@NonNull Environment parent, @NonNull Type context) {
        
        Environment result =
            createEnvironment(parent);
        
        Variable self = parent.getOCLFactory().createVariable();
        self.setName(Environment.SELF_VARIABLE_NAME);
        self.setType(context);
        
//        result.addElement(self.getName(), self, true);
        result.setSelfVariable(self);
        
        return result;
	}
    
    // implements the interface method
    public @NonNull Environment createInstanceContext(@NonNull Environment parent, @NonNull Object context) {       
        return createClassifierContext(parent, getClassifier(context));
    }
	
    // implements the interface method
	public @NonNull Environment createOperationContext(@NonNull Environment parent, @NonNull Operation operation) {		
		Environment result = createEnvironment(parent);		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result).setContextOperation(operation);
		}
		PivotFactory oclFactory = parent.getOCLFactory();		
        for (Parameter next : operation.getOwnedParameter()) {
			// ensure that we use the OCL primitive types wherever possible
			Variable var = oclFactory.createVariable();
			var.setName(next.getName());
			var.setType(next.getType());
			var.setRepresentedParameter(next);		
//			result.addElement(var.getName(), var, true);
		}	
		return result;
	}
	
    // implements the interface method
	public @NonNull Environment createPropertyContext(@NonNull Environment parent, @NonNull Property property) {
		
		Environment result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result)
				.setContextProperty(property);
		}
		
		return result;
	}

	public @NonNull EvaluationVisitor createEvaluationVisitor(@Nullable Environment environment, @Nullable Object context, @NonNull ExpressionInOCL expression, @Nullable DomainModelManager modelManager) {
		if (environment == null) {
			environment = createEnvironment();
		}
		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
//		context = HelperUtil.getConstraintContext(rootEnvironment, context, expression);
		EvaluationEnvironment evaluationEnvironment = createEvaluationEnvironment();
		Variable contextVariable = expression.getContextVariable();
		if (contextVariable != null) {
			PivotIdResolver idResolver = evaluationEnvironment.getMetaModelManager().getIdResolver();
			Object value = idResolver.boxedValueOf(context);
			evaluationEnvironment.add(contextVariable, value);
		}
		for (Variable parameterVariable : expression.getParameterVariable()) {
			if (parameterVariable != null) {
				evaluationEnvironment.add(parameterVariable, null);
			}
		}
		DomainModelManager extents = modelManager;
		if (extents == null) {
			// let the evaluation environment create one
			extents = evaluationEnvironment.createModelManager(context);
		}
		return createEvaluationVisitor(environment, evaluationEnvironment, extents);
	}
	
    // implements the interface method
	public @NonNull EvaluationVisitor createEvaluationVisitor(@NonNull Environment env, @NonNull EvaluationEnvironment evalEnv,
			@NonNull DomainModelManager modelManager) {
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
    protected abstract @NonNull Type getClassifier(@NonNull Object context);
    
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

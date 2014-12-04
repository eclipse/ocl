/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.examples.pivot.helper;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.context.ClassContext;
import org.eclipse.ocl.examples.pivot.context.ModelContext;
import org.eclipse.ocl.examples.pivot.context.OperationContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.context.PropertyContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * Implementation of the {@link OCLHelper} convenience interface.
 */
public class OCLHelperImpl implements OCLHelper
{
    private final @NonNull OCL ocl;
	protected final @NonNull Environment rootEnvironment;
	protected final @NonNull MetaModelManager metaModelManager;

	protected final @NonNull EnvironmentFactory environmentFactory;
	private Environment env;

	private boolean validating = true;
    
    private Diagnostic problems;
    
	/**
	 * Initializes me with my environment.
	 * 
	 * @param ocl the OCL environment
	 */
    public OCLHelperImpl(@NonNull OCL ocl) {
        this.ocl = ocl;
		this.rootEnvironment = ocl.getEnvironment();
		this.metaModelManager = rootEnvironment.getMetaModelManager();
		this.environmentFactory = rootEnvironment.getFactory();
	}

	@Override
	public @NonNull ExpressionInOCL createBodyCondition(@NonNull String expression) throws ParserException {
		Operation contextOperation = getEnvironment().getContextOperation();
		if (contextOperation == null) {
			throw new IllegalStateException("Undefined contextOperation");
		}
		ParserContext parserContext = new OperationContext(metaModelManager, null, contextOperation, null);
		return parserContext.parse(contextOperation, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createDerivedValueExpression(@NonNull String expression) throws ParserException {
		Property contextProperty = getEnvironment().getContextProperty();
		if (contextProperty == null) {
			throw new IllegalStateException("Undefined contextProperty");
		}
		ParserContext parserContext = new PropertyContext(metaModelManager, null, contextProperty);
		return parserContext.parse(contextProperty, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createInvariant(@NonNull String expression) throws ParserException {
		org.eclipse.ocl.examples.pivot.Class contextClassifier = getEnvironment().getContextClassifier();
		if (contextClassifier == null) {
			throw new IllegalStateException("Undefined contextClassifier");
		}
		ParserContext parserContext = new ClassContext(metaModelManager, null, contextClassifier, null);
		return parserContext.parse(contextClassifier, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createPostcondition(@NonNull String expression) throws ParserException {
		Operation contextOperation = getEnvironment().getContextOperation();  // FIXME need contextConstraint
		if (contextOperation == null) {
			throw new IllegalStateException("Undefined contextOperation");
		}
		ParserContext parserContext = new OperationContext(metaModelManager, null, contextOperation, Environment.RESULT_VARIABLE_NAME);
		return parserContext.parse(contextOperation, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createPrecondition(@NonNull String expression) throws ParserException {
		Operation contextOperation = getEnvironment().getContextOperation();  // FIXME need contextConstraint
		if (contextOperation == null) {
			throw new IllegalStateException("Undefined contextOperation");
		}
		ParserContext parserContext = new OperationContext(metaModelManager, null, contextOperation, null);
		return parserContext.parse(contextOperation, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createQuery(@NonNull String expression) throws ParserException {
		org.eclipse.ocl.examples.pivot.Class contextClassifier = getEnvironment().getContextClassifier();
		ParserContext parserContext;
		if (contextClassifier != null) {
			parserContext = new ClassContext(metaModelManager, null, contextClassifier, null);
		}
		else {
			parserContext = new ModelContext(metaModelManager, null);
		}
		return parserContext.parse(contextClassifier, expression);
	}

	protected @NonNull ExpressionInOCL createSpecification(@NonNull String expression) throws ParserException {
		org.eclipse.ocl.examples.pivot.Class contextClassifier = getEnvironment().getContextClassifier();
		if (contextClassifier == null) {
			throw new IllegalStateException("Undefined contextClassifier");
		}
		ParserContext parserContext = new ClassContext(metaModelManager, null, contextClassifier, null);
		return parserContext.parse(contextClassifier, expression);
	}
	
	@Override
	public @Nullable Property getContextProperty() {
		return getEnvironment().getContextProperty();
	}
	
	@Override
	public @Nullable org.eclipse.ocl.examples.pivot.Class getContextClassifier() {
		return getEnvironment().getContextClassifier();
	}
	
	@Override
	public @Nullable Operation getContextOperation() {
		return getEnvironment().getContextOperation();
	}
	
	@Override
	@SuppressWarnings("null")
	public @NonNull Environment getEnvironment() {
		return env == null ? rootEnvironment : env;
	}
	
	public final @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}
	
	@Override
	public @NonNull OCL getOCL() {
        return ocl;
    }
	
	@Override
	public Diagnostic getProblems() {
		return problems;
	}
    
	@Override
	public boolean isValidating() {
		return validating;
	}

	@Override
	public void setContext(@NonNull EClassifier context) {
		org.eclipse.ocl.examples.pivot.Class pContext = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Class.class, context);
		if (pContext != null) {
			setContext(pContext);
		}
	}
	
	@Override
	public void setContext(@NonNull org.eclipse.ocl.examples.pivot.Class context) {
		setEnvironment(environmentFactory.createClassifierContext(getEnvironment(), context));
	}
	
	private void setEnvironment(@NonNull Environment env) {
		this.env = env;
	}
    
    @Override
	public void setInstancePropertyContext(@NonNull Object instance, @NonNull Property property) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createPropertyContext(getEnvironment(), property));
    }
    
    @Override
	public void setInstanceContext(@NonNull Object instance) {
        setEnvironment(environmentFactory.createInstanceContext(getEnvironment(), instance));
    }
    
    @Override
	public void setInstanceOperationContext(@NonNull Object instance, @NonNull Operation operation) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createOperationContext(getEnvironment(), operation));
    }

	@Override
	public void setOperationContext(@NonNull EClassifier context, @NonNull EOperation operation) {
		org.eclipse.ocl.examples.pivot.Class pContext = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Class.class, context);
		Operation pOperation = metaModelManager.getPivotOfEcore(Operation.class, operation);
		if ((pContext != null) && (pOperation != null)) {
			setOperationContext(pContext, pOperation);
		}
	}
	
	@Override
	public void setOperationContext(@NonNull org.eclipse.ocl.examples.pivot.Class context, @NonNull Operation operation) {
        setContext(context);
		setEnvironment(environmentFactory.createOperationContext(getEnvironment(), operation));
	}
	
	@Override
	public void setPropertyContext(@NonNull EClassifier context, @NonNull EStructuralFeature property) {
		org.eclipse.ocl.examples.pivot.Class pContext = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Class.class, context);
		Property pProperty = metaModelManager.getPivotOfEcore(Property.class, property);
		if ((pContext != null) && (pProperty != null)) {
			setPropertyContext(pContext, pProperty);
		}
	}
	
	@Override
	public void setPropertyContext(@NonNull org.eclipse.ocl.examples.pivot.Class context, @NonNull Property property) {
        setContext(context);
		setEnvironment(environmentFactory.createPropertyContext(getEnvironment(), property));
	}
	
	void setProblems(Diagnostic problems) {
		this.problems = problems;
	}
	
	@Override
	public void setValidating(boolean validating) {
		this.validating = validating;
	}
}

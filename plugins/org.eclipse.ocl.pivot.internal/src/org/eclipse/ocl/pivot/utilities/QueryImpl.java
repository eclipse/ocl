/*******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Radek Dvorak - Bug 261128
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.EnvironmentInternal;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.ProblemAware;
import org.eclipse.ocl.pivot.Query;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.helper.HelperUtil;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.eclipse.ocl.pivot.util.PivotInternalPlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.utilities.QueryImpl#getModelManager <em>Extent Map</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.utilities.QueryImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl implements Query, ProblemAware
{
	private final OCL ocl;
	private final EnvironmentInternal environment;
	private final ExpressionInOCL query;
	private final OCLExpression expression;
	private ModelManager modelManager = null;
	private EvaluationEnvironment evalEnv;
	private Diagnostic evalProblems;
	private BasicDiagnostic batchEvalProblems;
	
	public QueryImpl(@NonNull OCL ocl, @NonNull ExpressionInOCL query) {		
		this.ocl = ocl;
		this.environment = ocl.getEnvironment();
		this.query = query;
		this.expression = query.getOwnedBody();
		this.modelManager = ocl.getModelManager();
	}

	@Override
	public boolean check(Object obj) {
		if (resultType() != environment.getStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			PivotInternalPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		Object result;
		
		if (obj == null) {
			result = evaluate();
		} else {
			result = evaluate(obj);
		}
		
		return result == ValueUtil.TRUE_VALUE;
	}
	
	@Override
	public boolean check(List<?> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotInternalPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		if (resultType() != environment.getStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			PivotInternalPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		Iterator <?>iter = objList.iterator();
		while (iter.hasNext()) {
			if (!check(iter.next())) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Assigns collected interim diagnostics of batch evaluation to the
	 * resulting evaluation problems.
	 */
	private void commitBatchEvaluateProblems() {
		evalProblems = batchEvalProblems;
		batchEvalProblems = null;
	}

	@Override
	public Object evaluate() throws EvaluationException {
		evalProblems = null;
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  There is no "self" context variable
		@SuppressWarnings("null")
		@NonNull EnvironmentInternal nonNullEnvironment = environment;
		EvaluationVisitor ev =
			nonNullEnvironment.getEnvironmentFactory().createEvaluationVisitor(
					nonNullEnvironment, getEvaluationEnvironment(), getModelManager());
		
		Object result;
		
		try {
			result = expression.accept(ev);
		} catch (EvaluationHaltedException e) {
			evalProblems = e.getDiagnostic();
//			result = environment.getMetaModelManager().getValueFactory().createInvalidValue(null, null, evalProblems.toString(), e);
			throw e;
		}
		
		return result;
	}

	@Override
	public Object evaluate(Object obj) throws EvaluationException {
		evalProblems = null;
		
		if (obj == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				OCLMessages.NullArgExpectEObj_ERROR_);
			PivotInternalPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}

		// can determine a more appropriate context from the context
		//   variable of the expression, to account for stereotype constraints
		obj = HelperUtil.getConstraintContext(environment, obj, expression);
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  Initialize it with the "self" context variable
		EvaluationEnvironment myEnv = getEvaluationEnvironment();
		MetaModelManager metaModelManager = environment.getEnvironmentFactory().getMetaModelManager();
		Variable contextVariable = ClassUtil.nonNullState(query.getOwnedContext());
		myEnv.add(contextVariable, metaModelManager.getIdResolver().boxedValueOf(obj));
//		Variable resultVariable = specification.getResultVariable();
//		if (resultVariable != null) {
//			myEnv.add(resultVariable, null);
//		}
		
		@SuppressWarnings("null")
		@NonNull EnvironmentInternal nonNullEnvironment = environment;
		EvaluationVisitor ev = nonNullEnvironment.getEnvironmentFactory().createEvaluationVisitor(
					nonNullEnvironment, myEnv, getModelManager());
		
		Object result;
		
		try {
			result = expression.accept(ev);
		} catch (EvaluationHaltedException e) {
			evalProblems = e.getDiagnostic();
//			result = valueFactory.createInvalidValue(obj, null, evalProblems.toString(), e);
			throw e;
//		} finally {
//			myEnv.remove(specification.getContextVariable());
//			if (resultVariable != null) {
//				myEnv.add(resultVariable, null);
//			}
		}
		
		return result;
	}

	@Override
	public List<?> evaluate(List<?> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotInternalPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}
		
		List<Object> result = new BasicEList<Object>();
		Iterator<?> iter = objList.iterator();
		try {
			while (iter.hasNext()) {
				result.add(evaluate(iter.next()));
				
				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
		}

		return result;
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		if (evalEnv == null) {
			evalEnv = environment.getEnvironmentFactory().createEvaluationEnvironment();
		}
		
		return evalEnv;
	}

	@Override
	public OCLExpression getExpression() {
		return expression;
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull ModelManager getModelManager() {
		if (modelManager == null) {
			EvaluationEnvironment myEnv = getEvaluationEnvironment();
			
			Object context = myEnv.getValueOf(query.getOwnedContext());
			
			modelManager = environment.getEnvironmentFactory().createModelManager(context);
		}
		
		return modelManager;
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull OCL getOCL() {
		return ocl;
	}

	@Override
	public Diagnostic getProblems() {
		return evalProblems;
	}

	/**
	 * Handles problems of single evaluation performed on behalf of batch
	 * evaluate invocation.
	 */
	private void handleNextEvaluateProblems() {
		Diagnostic nextEvalProblems = getProblems();
		if (nextEvalProblems != null) {
			if (batchEvalProblems == null) {
				BasicDiagnostic rootDiagnostic = new BasicDiagnostic(
					nextEvalProblems.getSeverity(), PivotInternalPlugin.getPluginId(),
					nextEvalProblems.getCode(), nextEvalProblems.getMessage(),
					null);

				batchEvalProblems = rootDiagnostic;
			}
			
			batchEvalProblems.add(nextEvalProblems);
		}
	}		

	@Override
	public String queryText() {
		return expression.toString();
	}

	@Override
	public <T> List<T> reject(List<T> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotInternalPlugin.throwing(getClass(), "reject", error);//$NON-NLS-1$
			throw error;
		}
		
		List<T> result = new BasicEList<T>();
		try {
			for (T obj : objList) {
				if (!check(obj)) {
					result.add(obj);
				}

				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
		}

		return result;
	}

	@Override
	public Type resultType() {
		return expression.getType();
	}

	@Override
	public <T> List<T> select(List<T> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotInternalPlugin.throwing(getClass(), "select", error);//$NON-NLS-1$
			throw error;
		}
		
		List<T> result = new BasicEList<T>();
		try {
			for (T obj : objList) {
				if (check(obj)) {
					result.add(obj);
				}

				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
		}

		return result;
	}
	
	@Override
    public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Query["); //$NON-NLS-1$
		result.append(queryText());
		result.append(']');
		
		return result.toString();
	}
}

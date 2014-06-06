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

package org.eclipse.ocl.examples.pivot.utilities;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.evaluation.DomainException;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.ProblemAware;
import org.eclipse.ocl.examples.pivot.Query;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.helper.HelperUtil;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.utilities.QueryImpl#getModelManager <em>Extent Map</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.utilities.QueryImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl implements Query, ProblemAware
{
	private final OCL ocl;
	private final Environment environment;
	private final ExpressionInOCL specification;
	private final OCLExpression expression;
	private DomainModelManager modelManager = null;
	private EvaluationEnvironment evalEnv;
	private Diagnostic evalProblems;
	private BasicDiagnostic batchEvalProblems;
	
	public QueryImpl(@NonNull OCL ocl, @NonNull ExpressionInOCL specification) {		
		this.ocl = ocl;
		this.environment = ocl.getEnvironment();
		this.specification = specification;
		this.expression = specification.getBodyExpression();
		this.modelManager = ocl.getModelManager();
	}

	public boolean check(Object obj) {
		if (resultType() != environment.getOCLStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			PivotPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		Object result;
		
		if (obj == null) {
			result = evaluate();
		} else {
			result = evaluate(obj);
		}
		
		return result == ValuesUtil.TRUE_VALUE;
	}
	
	public boolean check(List<?> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		if (resultType() != environment.getOCLStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			PivotPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
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

	public Object evaluate() throws DomainException {
		evalProblems = null;
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  There is no "self" context variable
		@SuppressWarnings("null")
		@NonNull Environment nonNullEnvironment = environment;
		EvaluationVisitor ev =
			nonNullEnvironment.getFactory().createEvaluationVisitor(
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

	public Object evaluate(Object obj) throws DomainException {
		evalProblems = null;
		
		if (obj == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				OCLMessages.NullArgExpectEObj_ERROR_);
			PivotPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}

		// can determine a more appropriate context from the context
		//   variable of the expression, to account for stereotype constraints
		obj = HelperUtil.getConstraintContext(environment, obj, expression);
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  Initialize it with the "self" context variable
		EvaluationEnvironment myEnv = getEvaluationEnvironment();
		Variable contextVariable = DomainUtil.nonNullState(specification.getContextVariable());
		myEnv.add(contextVariable, myEnv.getMetaModelManager().getIdResolver().boxedValueOf(obj));
//		Variable resultVariable = specification.getResultVariable();
//		if (resultVariable != null) {
//			myEnv.add(resultVariable, null);
//		}
		
		@SuppressWarnings("null")
		@NonNull Environment nonNullEnvironment = environment;
		EvaluationVisitor ev =
				nonNullEnvironment.getFactory().createEvaluationVisitor(
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

	public List<?> evaluate(List<?> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
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

	@SuppressWarnings("null")
	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		if (evalEnv == null) {
			evalEnv = environment.getFactory().createEvaluationEnvironment();
		}
		
		return evalEnv;
	}

	public OCLExpression getExpression() {
		return expression;
	}

	@SuppressWarnings("null")
	public @NonNull DomainModelManager getModelManager() {
		if (modelManager == null) {
			EvaluationEnvironment myEnv = getEvaluationEnvironment();
			
			Object context = myEnv.getValueOf(specification.getContextVariable());
			
			modelManager = myEnv.createModelManager(context);
		}
		
		return modelManager;
	}

	@SuppressWarnings("null")
	public @NonNull OCL getOCL() {
		return ocl;
	}

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
					nextEvalProblems.getSeverity(), PivotPlugin.getPluginId(),
					nextEvalProblems.getCode(), nextEvalProblems.getMessage(),
					null);

				batchEvalProblems = rootDiagnostic;
			}
			
			batchEvalProblems.add(nextEvalProblems);
		}
	}		

	public String queryText() {
		return expression.toString();
	}

	public <T> List<T> reject(List<T> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotPlugin.throwing(getClass(), "reject", error);//$NON-NLS-1$
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

	public Type resultType() {
		return expression.getType();
	}

	public <T> List<T> select(List<T> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			PivotPlugin.throwing(getClass(), "select", error);//$NON-NLS-1$
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

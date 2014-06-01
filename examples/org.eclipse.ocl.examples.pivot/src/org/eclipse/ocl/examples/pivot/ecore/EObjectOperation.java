/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.context.OperationContext;
import org.eclipse.ocl.examples.pivot.context.ParserContext;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/** 
 * An EObjectOperation provides the standard LibraryOperation to implement an
 * OperationCallExp. When constructed with a null specification, the call returns
 * an invalid. When constructed with a non-null specification,
 * the specification defines the operation body, which if provided as an OpaqueExpression
 * is lazily compiled from OCL source text.
 */
public class EObjectOperation extends AbstractOperation
{
	protected final @NonNull Operation operation;
	protected final @NonNull EOperation eFeature;
	protected @NonNull OpaqueExpression specification;
	private ExpressionInOCL expressionInOCL = null;

	public EObjectOperation(@NonNull Operation operation, @NonNull EOperation eFeature, @NonNull OpaqueExpression specification) {
		this.operation = operation;
		this.eFeature = eFeature;
		this.specification = specification;
	}

	public @Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		List<? extends DomainExpression> arguments = callExp.getArgument();
		Object[] argumentValues = new Object[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			DomainExpression argument = arguments.get(i);
			assert argument != null;
			argumentValues[i] = evaluator.evaluate(argument);
		}
		return evaluate(evaluator, callExp, sourceValue, argumentValues);
	}

	private @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, @NonNull Object... argumentValues) {
		if (expressionInOCL == null) {		
			resolveExpressionInOCL(evaluator, callExp, sourceValue);
		}
		ExpressionInOCL expressionInOCL2 = expressionInOCL;
		assert expressionInOCL2 != null;
		DomainEvaluator nestedEvaluator;
		if (evaluator instanceof EvaluationVisitorImpl) {
			nestedEvaluator = ((EvaluationVisitorImpl)evaluator).createNestedUndecoratedEvaluator(expressionInOCL2);
		}
		else {
			nestedEvaluator = evaluator.createNestedEvaluator();
		}
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(expressionInOCL2.getContextVariable()), sourceValue);
		List<Variable> parameterVariables = expressionInOCL2.getParameterVariable();
		int iMax = Math.min(parameterVariables.size(), argumentValues.length);
		for (int i = 0; i < iMax; i++) {
			nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(parameterVariables.get(i)), argumentValues[i]);
		}
		try{
			return nestedEvaluator.evaluate(DomainUtil.nonNullPivot(expressionInOCL2.getBodyExpression()));
		}
		finally {
			nestedEvaluator.dispose();
		}
	}

	protected void resolveExpressionInOCL(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		if (specification instanceof ExpressionInOCL) {
			expressionInOCL = (ExpressionInOCL) specification;
		}
		else {
			String string = PivotUtil.getBody(specification);
			if (string != null) {
				try {
					EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
					MetaModelManager metaModelManager = evaluationVisitor.getMetaModelManager();
					ParserContext operationContext = new OperationContext(metaModelManager, null, operation, null);
					expressionInOCL = operationContext.parse(operation, string);
				} catch (ParserException e) {
					throw new InvalidValueException(e, "parse failure", evaluator.getEvaluationEnvironment(), sourceValue, callExp);
				}
			}
			if (expressionInOCL == null) {
				Operation operation = ((OperationCallExp)callExp).getReferredOperation();
				throw new InvalidValueException("No specification for '" + operation + "'", evaluator.getEvaluationEnvironment(), sourceValue, callExp);
			}
		}
	}
}
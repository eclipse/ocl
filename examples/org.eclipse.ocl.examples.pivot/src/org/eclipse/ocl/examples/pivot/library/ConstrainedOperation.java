/*******************************************************************************
 * Copyright (c) 2011, 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (CEA LIST) - Bug 425799 - validity view
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.library;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainCallExp;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.library.AbstractOperation;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An instance of ConstrainedOperation supports evaluation of
 * an operation defined by constraints.
 */
public class ConstrainedOperation extends AbstractOperation
{
	protected final @NonNull ExpressionInOCL expressionInOCL;
	
	public ConstrainedOperation(@NonNull ExpressionInOCL expressionInOCL) {
		this.expressionInOCL = expressionInOCL;
	}
	
	public @Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
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
		PivotUtil.checkExpression(expressionInOCL);
		EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
		EvaluationVisitor nestedVisitor;
		if (evaluationVisitor instanceof EvaluationVisitorImpl) {
			nestedVisitor = ((EvaluationVisitorImpl)evaluationVisitor).createNestedUndecoratedEvaluator(expressionInOCL);
		}
		else {
			nestedVisitor = evaluationVisitor.createNestedEvaluator();
		}
		EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(expressionInOCL.getContextVariable()), sourceValue);
		List<Variable> parameters = expressionInOCL.getParameterVariable();
		if (!parameters.isEmpty()) {
			for (int i = 0; i < parameters.size(); i++) {
				Object value = argumentValues[i];
				nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(parameters.get(i)), value);
			}
		}
		try {
			return nestedVisitor.evaluate(expressionInOCL);
		}
		finally {
			nestedVisitor.dispose();
		}
	}
}
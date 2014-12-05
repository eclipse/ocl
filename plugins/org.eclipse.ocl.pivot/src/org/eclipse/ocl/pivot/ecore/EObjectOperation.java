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
package org.eclipse.ocl.pivot.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainCallExp;
import org.eclipse.ocl.domain.elements.DomainExpression;
import org.eclipse.ocl.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.domain.library.AbstractOperation;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.pivot.manager.MetaModelManager;

/** 
 * An EObjectOperation provides the standard LibraryOperation to implement an EOperation defined by an OCL specification.
 * The specification is resolved lazily and so an invalid specification may throw an InvalidValueException at run-time.
 */
public class EObjectOperation extends AbstractOperation
{
	protected final @NonNull Operation operation;
	protected final @NonNull EOperation eFeature;
	protected final @NonNull ExpressionInOCL specification;

	public EObjectOperation(@NonNull Operation operation, @NonNull EOperation eFeature, @NonNull ExpressionInOCL specification) {
		this.operation = operation;
		this.eFeature = eFeature;
		this.specification = specification;
	}

	@Override
	public @Nullable Object dispatch(@NonNull DomainEvaluator evaluator, @NonNull DomainCallExp callExp, @Nullable Object sourceValue) {
		if (specification.getBodyExpression() == null) {		
			try {
				EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
				MetaModelManager metaModelManager = evaluationVisitor.getMetaModelManager();
				metaModelManager.getQueryOrThrow(specification);
			} catch (ParserException e) {
				throw new InvalidValueException(e, "parse failure", evaluator.getEvaluationEnvironment(), sourceValue, callExp);
			}
		}
		ExpressionInOCL query = specification;
		List<? extends DomainExpression> arguments = callExp.getArgument();
		Object[] argumentValues = new Object[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			DomainExpression argument = arguments.get(i);
			assert argument != null;
			argumentValues[i] = evaluator.evaluate(argument);
		}
		DomainEvaluator nestedEvaluator;
		if (evaluator instanceof EvaluationVisitorImpl) {
			nestedEvaluator = ((EvaluationVisitorImpl)evaluator).createNestedUndecoratedEvaluator(query);
		}
		else {
			nestedEvaluator = evaluator.createNestedEvaluator();
		}
		DomainEvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(query.getContextVariable()), sourceValue);
		List<Variable> parameterVariables = query.getParameterVariable();
		int iMax = Math.min(parameterVariables.size(), argumentValues.length);
		for (int i = 0; i < iMax; i++) {
			nestedEvaluationEnvironment.add(DomainUtil.nonNullModel(parameterVariables.get(i)), argumentValues[i]);
		}
		try {
			return nestedEvaluator.evaluate(DomainUtil.nonNullPivot(query.getBodyExpression()));
		}
		finally {
			nestedEvaluator.dispose();
		}
	}
}
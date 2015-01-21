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
package org.eclipse.ocl.pivot.internal.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.values.InvalidValueException;

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
	public @Nullable Object dispatch(@NonNull Evaluator evaluator, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		if (specification.getOwnedBody() == null) {		
			try {
				EvaluationVisitor evaluationVisitor = (EvaluationVisitor)evaluator;
				MetamodelManager metamodelManager = evaluationVisitor.getMetamodelManager();
				metamodelManager.getQueryOrThrow(specification);
			} catch (ParserException e) {
				throw new InvalidValueException(e, "parse failure", evaluator.getEvaluationEnvironment(), sourceValue, callExp);
			}
		}
		ExpressionInOCL query = specification;
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		Object[] argumentValues = new Object[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			OCLExpression argument = arguments.get(i);
			assert argument != null;
			argumentValues[i] = evaluator.evaluate(argument);
		}
		Evaluator nestedEvaluator;
		if (evaluator instanceof OCLEvaluationVisitor) {
			nestedEvaluator = ((OCLEvaluationVisitor)evaluator).createNestedUndecoratedEvaluator(query);
		}
		else {
			nestedEvaluator = evaluator.createNestedEvaluator();
		}
		EvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluator.getEvaluationEnvironment();
		nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(query.getOwnedContext()), sourceValue);
		List<Variable> parameterVariables = query.getOwnedParameters();
		int iMax = Math.min(parameterVariables.size(), argumentValues.length);
		for (int i = 0; i < iMax; i++) {
			nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(parameterVariables.get(i)), argumentValues[i]);
		}
		try {
			return nestedEvaluator.evaluate(ClassUtil.nonNullPivot(query.getOwnedBody()));
		}
		finally {
			nestedEvaluator.dispose();
		}
	}
}
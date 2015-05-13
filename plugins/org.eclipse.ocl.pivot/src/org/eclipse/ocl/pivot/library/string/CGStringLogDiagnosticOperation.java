/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.string;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * CGStringLogDiagnosticOperation realises the String::logDiagnostic(severity, status) library operation.
 */
public class CGStringLogDiagnosticOperation extends AbstractOperation
{
	public static final @NonNull CGStringLogDiagnosticOperation INSTANCE = new CGStringLogDiagnosticOperation();

	@Override
	public @Nullable Object dispatch(@NonNull Evaluator evaluator, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		OCLExpression argument0 = arguments.get(0);
		OCLExpression argument1 = arguments.get(1);
		OCLExpression argument2 = arguments.get(2);
		OCLExpression argument3 = arguments.get(3);
		OCLExpression argument4 = arguments.get(4);
		OCLExpression argument5 = arguments.get(5);
		assert argument0 != null;
		assert argument1 != null;
		assert argument2 != null;
		assert argument3 != null;
		assert argument4 != null;
		assert argument5 != null;
		Object firstArgument = evaluator.evaluate(argument0);
		Object secondArgument = evaluator.evaluate(argument1);
		Object thirdArgument = evaluator.evaluate(argument2);
		Object fourthArgument = evaluator.evaluate(argument3);
		Object fifthArgument = evaluator.evaluate(argument4);
		Object sixthArgument = evaluator.evaluate(argument5);
		return evaluate(evaluator, callExp.getTypeId(), sourceValue, firstArgument, secondArgument, thirdArgument, fourthArgument, fifthArgument, sixthArgument);
	}

	public @NonNull /*@Thrown*/ Boolean evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object constraintName,
			@Nullable Object object, @Nullable Object diagnostics, @Nullable Object context,
			@Nullable Object severity, @Nullable Object status, @Nullable Object code) {
		if (status == Boolean.TRUE) {
		    return ValueUtil.TRUE_VALUE;
		}
		if (diagnostics instanceof DiagnosticChain) {
			String constrainedClassName;
			Object objectLabel;
			if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				constrainedClassName = eObject.eClass().getName();
				if (context instanceof Map<?,?>) {
				    @SuppressWarnings("unchecked") Map<Object, Object> castContext = (Map<Object, Object>) context;
					objectLabel = EObjectValidator.getObjectLabel(eObject, castContext);
				}
				else {
					objectLabel = EObjectValidator.getObjectLabel(eObject, null);
				}
			}
			else {
				constrainedClassName = "<<unknown>>";
				objectLabel = "<<unknown>>";
			}
			String message = StringUtil.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{constrainedClassName, constraintName, objectLabel});
		    int intSeverity = ValueUtil.asIntegerValue(severity).intValue();
		    int intCode = ValueUtil.asIntegerValue(code).intValue();
			((DiagnosticChain)diagnostics).add(new BasicDiagnostic(intSeverity, PivotValidator.DIAGNOSTIC_SOURCE, intCode, message, new Object [] { object }));
		}
		return ValueUtil.FALSE_VALUE;
	}

	@Deprecated
	public @NonNull /*@Thrown*/ Boolean evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId,
			String strValidateorderedsetki, DiagnosticChain diagnostics,
			Object cAUGHT_getSeverity, Object cAUGHT_implies) {
	    return ValueUtil.TRUE_VALUE;
	}
}

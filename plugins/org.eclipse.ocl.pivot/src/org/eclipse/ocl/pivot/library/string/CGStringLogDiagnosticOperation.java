/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.evaluation.Executor;
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

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
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
		Object firstArgument = executor.evaluate(argument0);
		Object secondArgument = executor.evaluate(argument1);
		Object thirdArgument = executor.evaluate(argument2);
		Object fourthArgument = executor.evaluate(argument3);
		Object fifthArgument = executor.evaluate(argument4);
		Object sixthArgument = executor.evaluate(argument5);
		return evaluate(executor, callExp.getTypeId(), sourceValue, firstArgument, secondArgument, thirdArgument, fourthArgument, fifthArgument, sixthArgument);
	}
	
	/** @deprecated use Executor */
	@Deprecated
	public @NonNull Boolean evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object constraintName,
			@Nullable Object object, @Nullable Object diagnostics, @Nullable Object context,
			@Nullable Object severity, @Nullable Object status, @Nullable Object code) {
		return evaluate(getExecutor(evaluator), returnTypeId, constraintName, object, diagnostics, context, severity, status, code); 
	}

	/**
	 * @since 1.1
	 */
	public @NonNull /*@Thrown*/ Boolean evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object constraintName,
			@Nullable Object object, @Nullable Object diagnostics, @Nullable Object context,
			@Nullable Object severity, @Nullable Object status, @Nullable Object code) {
		if (status == Boolean.TRUE) {
		    return ValueUtil.TRUE_VALUE;
		}
		if (diagnostics instanceof DiagnosticChain) {
			Object objectLabel;
			if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				if (context instanceof Map<?,?>) {
				    @SuppressWarnings("unchecked") Map<Object, Object> castContext = (Map<Object, Object>) context;
					objectLabel = EObjectValidator.getObjectLabel(eObject, castContext);
				}
				else {
					objectLabel = EObjectValidator.getObjectLabel(eObject, null);
				}
			}
			else {
				objectLabel = "<<unknown>>";
			}
			String message = StringUtil.bind(PivotMessages.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{constraintName, objectLabel});
		    int intSeverity = ValueUtil.asIntegerValue(severity).intValue();
		    int intCode = ValueUtil.asIntegerValue(code).intValue();
			((DiagnosticChain)diagnostics).add(new BasicDiagnostic(intSeverity, PivotValidator.DIAGNOSTIC_SOURCE, intCode, message, new Object [] { object }));
		}
		return ValueUtil.FALSE_VALUE;
	}
	
	/** @deprecated use Executor */
	@Deprecated
	public @NonNull Boolean evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId,
			String constraintName, DiagnosticChain diagnostics, Object severity, Object object) {
		return evaluate(getExecutor(evaluator), returnTypeId, constraintName, diagnostics, severity, object); 
	}

	/**
	 * @since 1.1
	 */
	@Deprecated
	public @NonNull /*@Thrown*/ Boolean evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			String constraintName, DiagnosticChain diagnostics, Object severity, Object object) {
	    return ValueUtil.TRUE_VALUE;
	}
}

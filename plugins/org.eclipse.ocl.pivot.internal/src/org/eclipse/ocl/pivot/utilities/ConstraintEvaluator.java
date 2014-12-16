/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotConstants;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.TupleValue;

/**
 * ConstraintEvaluator provides an abstract framework for evaluation of a constraint with call backs to handle
 * the alternative success, failure, invalid and exception outcomes and return an appropriate value of T.
 *
 * @param <T> the result type
 */
public abstract class ConstraintEvaluator<T>
{
	/**
	 * Return the expression to be evaluated for a constraintSpecification, which is the constraintSpecification.bodyExpression
	 * unless that is a status TuplePart PropertyCallExp in which case it is the source of the TuplePart PropertyCallExp enabling the
	 * evaluation to compute the enriched Tuple of invariant results.
	 */
	private static @NonNull OCLExpression getConstraintExpression(@NonNull ExpressionInOCL query) {
		OCLExpression body = query.getBodyExpression();
		if (body instanceof PropertyCallExp) {
			PropertyCallExp propertyCallExp = (PropertyCallExp)body;
			Property referredProperty = propertyCallExp.getReferredProperty();
			if ((referredProperty != null) && (referredProperty.getOwningClass() instanceof TupleType) && PivotConstants.STATUS_PART_NAME.equals(referredProperty.getName())) {
				body = propertyCallExp.getSource();
			}
		}
		return ClassUtil.nonNullState(body);
	}

	protected final @NonNull ExpressionInOCL query;
	private final @NonNull OCLExpression body;
	
	/**
	 * Construct an helper for the evaluation of an expression
	 */
	public ConstraintEvaluator(@NonNull ExpressionInOCL query) {
		this.query = query;
		body = getConstraintExpression(query);
	}
	
	/**
	 * Use the evaluationVisitor to execute my expression on the objects within the evaluationVisitor's evaluationEnvironment,
	 * invoking one of handleSuccessResult, handleFailureResult, handleInvalidResult or handleExceptionResult to provide the return value.
	 */
	public T evaluate(@NonNull EvaluationVisitor evaluationVisitor) {
		if ((query.getContextVariable() == null) && (body instanceof StringLiteralExp)) {
			@SuppressWarnings("null")@NonNull String stringSymbol = ((StringLiteralExp)body).getStringSymbol();
			return handleInvalidExpression(stringSymbol);
		}
		Object result = null;
		boolean status = false;
		try {
			result = body.accept(evaluationVisitor);
			status = getConstraintResultStatus(result);
		} catch (InvalidValueException e) {
			return handleInvalidResult(e);
		} catch (Throwable e) {
			return handleExceptionResult(e);
		}
		if (status) {
			return handleSuccessResult();
		}
		return handleFailureResult(result);
	}

	protected String getConstraintName() {
		Constraint constraint = PivotUtil.getContainingConstraint(query);
		if (constraint != null) {
			return constraint.getName();
		}
		return "<<unknown>>";
	}

	/**
	 * Return the message of result, which is null
	 * unless result is a Tuple with a more informative severity part.
	 */
	protected @NonNull String getConstraintResultMessage(@Nullable Object result) {
		if (result instanceof TupleValue) {
			TupleValue tupleValue = (TupleValue)result;
			TupleTypeId tupleTypeId = tupleValue.getTypeId();
			TuplePartId messagePartId = tupleTypeId.getPartId(PivotConstants.MESSAGE_PART_NAME);
			if (messagePartId != null) {
				@SuppressWarnings("null")@NonNull String string = String.valueOf(tupleValue.getValue(messagePartId));
				return string;
			}
		}
		else if (result == null) {
			return ClassUtil.bind(OCLMessages.ValidationResultIsNull_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel());
			
		}
		return ClassUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel());
	}

	/**
	 * Return the org.eclipse.emf.common.util.Diagnostic severity of result, which is ERROR
	 * unless result is a Tuple with a more informative severity part.
	 */
	protected int getConstraintResultSeverity(@Nullable Object result) {
		if (result instanceof TupleValue) {
			TupleValue tupleValue = (TupleValue)result;
			TupleTypeId tupleTypeId = tupleValue.getTypeId();
			TuplePartId severityPartId = tupleTypeId.getPartId(PivotConstants.SEVERITY_PART_NAME);
			if (severityPartId != null) {
				IntegerValue value = ValueUtil.integerValueOf(tupleValue.getValue(severityPartId));
				int signum = value.signum();
				if (signum < 0) {
					return Diagnostic.ERROR;
				}
				else if (signum == 0) {
					return Diagnostic.INFO;
				}
				else {
					return Diagnostic.WARNING;
				}
			}
			else {
				TuplePartId statusPartId = tupleTypeId.getPartId(PivotConstants.STATUS_PART_NAME);
				if (statusPartId != null) {
					result = tupleValue.getValue(statusPartId);
				}
			}
		}
		return result == null ? Diagnostic.ERROR : Diagnostic.WARNING;
	}

	/**
	 * Return true if result represents a successful constraint evaluation result.
	 * Anything else leads to a false return (no null or exception).
	 */
	protected boolean getConstraintResultStatus(@Nullable Object result) {
		if (result == Boolean.TRUE) {
			return true;
		}
		if (result instanceof TupleValue) {
			TupleValue tupleValue = (TupleValue)result;
			TupleTypeId tupleTypeId = tupleValue.getTypeId();
			TuplePartId statusPartId = tupleTypeId.getPartId(PivotConstants.STATUS_PART_NAME);
			if (statusPartId == null) {
				return false;
			}
			Object value = tupleValue.getValue(statusPartId);
			if (value == Boolean.TRUE){
				return true;
			}
		}
		return false;
	}

	protected String getConstraintTypeName() {
		Type type = PivotUtil.getContainingType(query);
		if (type != null) {
			return type.getName();
		}
		return "<<unknown>>";
	}

	/**
	 * Call-back to provide a description of the context object for use in a diagnostic.
	 */
	protected abstract String getObjectLabel();

	/**
	 * Call-back to return the appropriate response for an evaluation that was terminated by an exception.
	 */
	protected abstract T handleExceptionResult(@NonNull Throwable e);

	/**
	 * Call-back to return the appropriate response for a failed evaluation.
	 */
	protected abstract T handleFailureResult(@Nullable Object result);

	/**
	 * Call-back to return the appropriate response for an unsuccessful parse of the expression.
	 */
	protected abstract T handleInvalidExpression(@NonNull String message);

	/**
	 * Call-back to return the appropriate response for an unsuccessful evaluation with an invalid result.
	 */
	protected abstract T handleInvalidResult(@NonNull InvalidValueException e);

	/**
	 * Call-back to return the appropriate response for a successful evaluation.
	 */
	protected abstract T handleSuccessResult();

	/**
	 * Return true if the constraint has a Boolean result type.
	 */
	protected boolean isBooleanConstraint() {
		TypeId typeId = query.getTypeId();
		return typeId == TypeId.BOOLEAN;
	}
}
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
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.IntegerValue;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.domain.values.util.ValuesUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;

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
	private static OCLExpression getConstraintExpression(@NonNull ExpressionInOCL constraintSpecification) {
		OCLExpression body = constraintSpecification.getBodyExpression();
		if (body instanceof PropertyCallExp) {
			PropertyCallExp propertyCallExp = (PropertyCallExp)body;
			Property referredProperty = propertyCallExp.getReferredProperty();
			if ((referredProperty != null) && (referredProperty.getOwningType() instanceof TupleType) && PivotConstants.STATUS_PART_NAME.equals(referredProperty.getName())) {
				return propertyCallExp.getSource();
			}
		}
		return body;
	}

	protected final @NonNull ExpressionInOCL expression;
	private OCLExpression body;
	
	/**
	 * Construct an helper for the evaluation of an expression
	 */
	public ConstraintEvaluator(@NonNull ExpressionInOCL expression) {
		this.expression = expression;
		body = getConstraintExpression(expression);
	}
	
	/**
	 * Use the evaluationVisitor to execute my expression on the objects within the evaluationVisitor's evaluationEnvironment,
	 * invoking one of handleSuccessResult, handleFailureResult, handleInvalidResult or handleExceptionResult to provide the return value.
	 */
	public T evaluate(@NonNull EvaluationVisitor evaluationVisitor) {
		if ((expression.getContextVariable() == null) && (body instanceof StringLiteralExp)) {
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
		Constraint constraint = PivotUtil.getContainingConstraint(expression);
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
			return DomainUtil.bind(OCLMessages.ValidationResultIsNull_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel());
			
		}
		return DomainUtil.bind(EvaluatorMessages.ValidationConstraintIsNotSatisfied_ERROR_,
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
				IntegerValue value = ValuesUtil.integerValueOf(tupleValue.getValue(severityPartId));
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
		Type type = PivotUtil.getContainingType(expression);
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
		TypeId typeId = expression.getTypeId();
		return typeId == TypeId.BOOLEAN;
	}
}
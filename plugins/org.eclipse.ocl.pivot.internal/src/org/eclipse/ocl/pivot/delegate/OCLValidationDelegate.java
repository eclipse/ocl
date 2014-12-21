/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.pivot.delegate;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.EvaluationException;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotConstants;
import org.eclipse.ocl.pivot.SemanticException;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.messages.OCLMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ConstraintEvaluator;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * An implementation of the dynamic validation delegate API, maintaining a cache
 * of compiled constraints and invariants.
 */
public class OCLValidationDelegate implements ValidationDelegate
{	
	protected static class CheckingConstraintEvaluator extends ConstraintEvaluator<Boolean>
	{
		protected final @NonNull EClassifier eClassifier;

		protected CheckingConstraintEvaluator(@NonNull EClassifier eClassifier, @NonNull ExpressionInOCL query) {
			super(query);
			this.eClassifier = eClassifier;
		}

		@Override
		public Boolean evaluate(@NonNull EvaluationVisitor evaluationVisitor) {
			if (!isBooleanConstraint()) {
				String objectLabel = ClassUtil.getLabel(query.getType());
//				String constraintTypeName = getConstraintTypeName(query);
				String checkMessage = ClassUtil.bind(OCLMessages.ValidationConstraintIsNotBooleanType_ERROR_, getConstraintTypeName(), getConstraintName(), objectLabel);
				throw new OCLDelegateException(new EvaluationException(checkMessage));
			}
			return super.evaluate(evaluationVisitor);
		}

		@Override
		protected String getObjectLabel() {
			return ClassUtil.getLabel(eClassifier, null, null);
		}

		@Override
		protected Boolean handleExceptionResult(@NonNull Throwable e) {
			String message = ClassUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel(), e.toString());
			throw new OCLDelegateException(new EvaluationException(message, e));
		}

		@Override
		protected Boolean handleFailureResult(@Nullable Object result) {
			if (result == null) {
				String message = getConstraintResultMessage(result);
				throw new OCLDelegateException(new EvaluationException(message));
			}
			else {
				return Boolean.FALSE;
			}
		}

		@Override
		protected Boolean handleInvalidExpression(@NonNull String message) {
			throw new OCLDelegateException(new EvaluationException(message));
		}

		@Override
		protected Boolean handleInvalidResult(@NonNull InvalidValueException e) {
			String message = ClassUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel(), e.getLocalizedMessage());
			throw new OCLDelegateException(new EvaluationException(message, e));
		}

		@Override
		protected Boolean handleSuccessResult() {
			return Boolean.TRUE;
		}
	}

	protected final @NonNull OCLDelegateDomain delegateDomain;
	protected final @NonNull EClassifier eClassifier;
	  
	/**
	 * Initializes me with the classifier whose DelegateEClassifierAdapter delegates to me.
	 * 
	 * @param classifier
	 *            my classifier
	 */
	public OCLValidationDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EClassifier classifier) {
		this.delegateDomain = delegateDomain;
		this.eClassifier = classifier;
	}

//	protected boolean check(@NonNull EvaluationVisitor evaluationVisitor, @NonNull String constraintName, @NonNull ExpressionInOCL query) {
//		ConstraintEvaluator<Boolean> constraintEvaluator = new CheckingConstraintEvaluator(eClassifier, query);
//		return constraintEvaluator.evaluate(evaluationVisitor);
//	}

/*	public @NonNull ExpressionInOCL getExpressionInOCL(@NonNull MetaModelManager metaModelManager, @NonNull Constraint constraint) {
		ExpressionInOCL query = null;
		ExpressionInOCL valueSpecification = constraint.getSpecification();
		if (valueSpecification instanceof ExpressionInOCL) {
			query = (ExpressionInOCL) valueSpecification;
		}
		else {
			Type contextType = (Type) constraint.getContext();
			if (contextType != null) {
				ClassContext classContext = new ClassContext(metaModelManager, null, contextType);
				query = ValidationBehavior.INSTANCE.getExpressionInOCL(classContext, constraint);
			}
		}
		if (query == null) {
			String message = ClassUtil.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, constraint.getContext());
			throw new OCLDelegateException(new SemanticException(message));
		}
		return query;
	} */

	@Override
	public String toString() {
		return "<" + delegateDomain.getURI() + ":validate> " + eClassifier.getEPackage().getName() + "::" + eClassifier.getName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		if (eClass == null) {
			throw new NullPointerException("Null EClass");
		}
		if (eObject == null) {
			throw new NullPointerException("Null EObject");
		}
		MetaModelManager metaModelManager = delegateDomain.getMetaModelManager();
		NamedElement namedElement = delegateDomain.getPivot(NamedElement.class, ClassUtil.nonNullEMF(invariant));
		if (namedElement instanceof Operation) {
			Operation operation = (Operation)namedElement;
			ExpressionInOCL query = InvocationBehavior.INSTANCE.getQueryOrThrow(metaModelManager, operation);
			InvocationBehavior.INSTANCE.validate(operation);
			return validateExpressionInOCL(eClass, eObject, null, context, invariant.getName(), null, 0, query);
		}
		else if (namedElement instanceof Constraint) {
			Constraint constraint = (Constraint)namedElement;
			ExpressionInOCL query = ValidationBehavior.INSTANCE.getQueryOrThrow(metaModelManager, constraint);
			ValidationBehavior.INSTANCE.validate(constraint);
			return validateExpressionInOCL(eClass, eObject, null, context,
				invariant.getName(), null, 0, query);
		}
		else if (namedElement != null) {
			throw new ClassCastException(namedElement.getClass().getName() + " does not provide a Constraint");
		}
		else {
			throw new ClassCastException(invariant.eClass().getName() + " does not provide a Constraint");
		}
	}

	@Override
	public boolean validate(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics,
			Map<Object, Object> context, @NonNull EOperation invariant, String expression, int severity, String source, int code) {
		MetaModelManager metaModelManager = delegateDomain.getMetaModelManager();
		NamedElement namedElement = delegateDomain.getPivot(NamedElement.class, ClassUtil.nonNullEMF(invariant));
		if (namedElement instanceof Operation) {
			Operation operation = (Operation)namedElement;
			ExpressionInOCL query = InvocationBehavior.INSTANCE.getQueryOrThrow(metaModelManager, operation);
			InvocationBehavior.INSTANCE.validate(operation);
			return validateExpressionInOCL(eClass, eObject, null, context, invariant.getName(), null, 0, query);
		}
		else if (namedElement instanceof Constraint) {
			Constraint constraint = (Constraint)namedElement;
			ExpressionInOCL query = ValidationBehavior.INSTANCE.getQueryOrThrow(metaModelManager, constraint);
			ValidationBehavior.INSTANCE.validate(constraint);
			return validateExpressionInOCL(eClass, eObject, diagnostics, context,
				invariant.getName(), source, code, query);
		}
		else if (namedElement != null) {
			throw new ClassCastException(namedElement.getClass().getName() + " does not provide a Constraint");
		}
		else {
			throw new ClassCastException(invariant.eClass().getName() + " does not provide a Constraint");
		}
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraintName, String expression) {
		if (eClass == null) {
			throw new NullPointerException("Null EClass");
		}
		if (eObject == null) {
			throw new NullPointerException("Null EObject");
		}
		if (constraintName == null) {
			throw new NullPointerException("Null constraint name");
		}
		return validatePivot(eClass, eObject, null, context, constraintName, null, 0);
	}

	@Override
	public boolean validate(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull String constraintName, String expression, int severity, String source, int code) {
		return validatePivot(eClass, eObject, diagnostics, context, constraintName, source, code);
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraintName, String expression) {
		if (eDataType == null) {
			throw new NullPointerException("Null EClass");
		}
		if (value == null) {
			throw new NullPointerException("Null EObject");
		}
		if (constraintName == null) {
			throw new NullPointerException("Null constraint name");
		}
		return validatePivot(eDataType, value, null, context, constraintName, null, 0);
	}

	@Override
	public boolean validate(@NonNull EDataType eDataType, @NonNull Object value, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull String constraintName, String expression, int severity, String source, int code) {
		return validatePivot(eDataType, value, diagnostics, context, constraintName, source, code);
	}

	protected boolean validateExpressionInOCL(final @NonNull EClassifier eClassifier, final @NonNull Object value, final @Nullable DiagnosticChain diagnostics,
			final Map<Object, Object> context, String constraintName, final String source, final int code, @NonNull ExpressionInOCL query) {
		ConstraintEvaluator<Boolean> constraintEvaluator = new CheckingConstraintEvaluator(eClassifier, query)
		{
			@Override
			protected String getObjectLabel() {
				return LabelUtil.qualifiedNameFor(value);
//				return ClassUtil.getLabel(eClassifier, value, context);
			}

			@Override
			protected Boolean handleFailureResult(@Nullable Object result) {
				if (result == null) {
					String message = getConstraintResultMessage(result);
					throw new OCLDelegateException(new EvaluationException(message));
				}
				if (diagnostics != null) {
					String message = getConstraintResultMessage(result);
					int severity = getConstraintResultSeverity(result);
					diagnostics.add(new BasicDiagnostic(severity, source, code, message, new Object [] { value }));
				}
				return Boolean.FALSE;
			}
		};
		OCL ocl = delegateDomain.getOCL();
		EvaluationVisitor evaluationVisitor = ocl.createEvaluationVisitor(value, query);
		return constraintEvaluator.evaluate(evaluationVisitor);
	}

	protected boolean validatePivot(@NonNull EClassifier eClassifier, @NonNull Object value, @Nullable DiagnosticChain diagnostics,
			Map<Object, Object> context, @NonNull String constraintName, String source, int code) {
		MetaModelManager metaModelManager = delegateDomain.getMetaModelManager();
		Type type = delegateDomain.getPivot(Type.class, eClassifier);
		Constraint constraint = ValidationBehavior.INSTANCE.getConstraint(metaModelManager, eClassifier, constraintName);
		if (constraint == null) {
			throw new OCLDelegateException(new SemanticException(OCLMessages.MissingSpecificationBody_ERROR_, type, PivotConstants.OWNED_CONSTRAINT_ROLE));
		}
		ExpressionInOCL query = null;
		if (type != null) {
			query = ValidationBehavior.INSTANCE.getQueryOrThrow(metaModelManager, constraint);
		}
		if (query == null) {
			throw new OCLDelegateException(new SemanticException(OCLMessages.MissingSpecificationBody_ERROR_, type, PivotConstants.OWNED_CONSTRAINT_ROLE));
		}
		return validateExpressionInOCL(eClassifier, value, diagnostics, context,
			constraintName, source, code, query);
	}
}

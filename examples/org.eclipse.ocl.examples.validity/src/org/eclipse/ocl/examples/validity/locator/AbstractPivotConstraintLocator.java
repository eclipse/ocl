/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.validity.locator;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.emf.validation.validity.locator.AbstractConstraintLocator;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LanguageExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.ConstraintEvaluator;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;

public abstract class AbstractPivotConstraintLocator extends AbstractConstraintLocator
{
	protected static abstract class AbstractConstraintLocator extends ConstraintEvaluator<Diagnostic>
	{
		protected final @NonNull MetaModelManager metaModelManager;
		protected final @Nullable Object object;

		protected AbstractConstraintLocator(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL expression, @Nullable Object object) {
			super(expression);
			this.metaModelManager = metaModelManager;
			this.object = object;
		}

		@Override
		protected Diagnostic handleExceptionResult(@NonNull Throwable e) {
			String message = DomainUtil.bind(OCLMessages.ValidationConstraintException_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel(), e);
			return new BasicDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE, 0, message, new Object [] { object });
		}

		@Override
		protected Diagnostic handleFailureResult(@Nullable Object result) {
			String message = getConstraintResultMessage(result);
			int severity = getConstraintResultSeverity(result);
			return new BasicDiagnostic(severity, EObjectValidator.DIAGNOSTIC_SOURCE, 0, message, new Object [] { object });
		}

		@Override
		protected Diagnostic handleInvalidExpression(@NonNull String message) {
			return new BasicDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE, 0, message, new Object [] { object });
		}

		@Override
		protected Diagnostic handleInvalidResult(@NonNull InvalidValueException e) {
			String message = DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel(), e.getLocalizedMessage());
			return new BasicDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE, 0, message, new Object [] { object });
		}

		@Override
		protected Diagnostic handleSuccessResult() {
			return null;
		}
	}

	protected @NonNull EvaluationVisitor createEvaluationVisitor(@NonNull MetaModelManager metaModelManager,
			@NonNull ExpressionInOCL query, @Nullable Object contextObject, @Nullable Monitor monitor) {
		PivotEnvironmentFactory environmentFactory = new PivotEnvironmentFactory(null, metaModelManager);
		Environment rootEnvironment = environmentFactory.createEnvironment();
		EvaluationVisitor evaluationVisitor = environmentFactory.createEvaluationVisitor(rootEnvironment, contextObject, query, null);
		evaluationVisitor.setMonitor(monitor);
		return evaluationVisitor;
	}

	protected @NonNull ExpressionInOCL getQuery(@NonNull MetaModelManager metaModelManager, @NonNull Constraint constraint) throws ParserException {
		LanguageExpression specification = constraint.getSpecification();
		assert specification != null;
		return metaModelManager.getQueryOrThrow(specification);
	}
}
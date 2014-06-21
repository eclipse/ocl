/*******************************************************************************
 * Copyright (c) 2012, 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *   E.D.Willink. M. Rostren (Obeo) - Bug 425830 - single constraint API
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.validation;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.ComposedEValidator;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.ConstraintEvaluator;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * A PivotEObjectValidator augments EValidator.Registry.INSTANCE validation by validation of
 * additional Pivot-defined invariants.
 * 
 * Since there is no per-ResourceSet EValidator.Registry it is necessary for the additional
 * functionality for a particular EPackage to be provided by displacing the global entry into
 * PivotEObjectValidator.eValidators and installing PivotEObjectValidator.INSTANCE in its stead.
 * 
 * When validation occurs, the static INSTANCE first invokes the displaced functionality and
 * then looks for a ValidationAdapter in the ResourceSet for the object to be validated.
 * This ValidationAdapter is only available if the ResourceSet is for an application for which
 * Pivot invariants were defined. Other applications see only a small overhead in their
 * processing time.
 */
public class PivotEObjectValidator implements EValidator
{
	/**
	 * A ValidationAdapter is installed in the ResourceSet of applications that register for additional
	 * PIvot-defined constraints. The standard validation is performed by PivotEObjectValidator.INSTANCE
	 * before additional functionality is provided by the ValidationAdapter.
	 * 
	 * For non-Pivot applications the ValidationAdapter adapts the ResourceSet containing the validatable
	 * (Ecore) instances. Validation is invoked for validatable (Ecore) instances.
	 * 
	 * For Pivot applications the ValidationAdapter adapts the ResourceSet containing the validatable
	 * metamodel elements. Validation is invoked for validatable (Pivot) elements so a redirection via
	 * the MetaModelManager is needed to find the ValidationAdapter on the externalResourceSet.
	 */
	public static class ValidationAdapter extends AdapterImpl
	{
		public static ValidationAdapter findAdapter(@NonNull ResourceSet resourceSet) {
			for (Adapter adapter : resourceSet.eAdapters()) {
				if (adapter instanceof ValidationAdapter) {
					return (ValidationAdapter)adapter;
				}
			}
			MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(resourceSet);
			if (metaModelManager != null) {
				ResourceSet externalResourceSet = metaModelManager.getExternalResourceSet();
				for (Adapter adapter : externalResourceSet.eAdapters()) {
					if (adapter instanceof ValidationAdapter) {
						return (ValidationAdapter)adapter;
					}
				}
			}
			return null;
		}

		protected final @NonNull MetaModelManager metaModelManager;
		protected final @NonNull EnvironmentFactory environmentFactory;
		protected final @NonNull Environment rootEnvironment;
		
		public ValidationAdapter(@NonNull MetaModelManager metaModelManager) {
			this.metaModelManager = metaModelManager;
			this.environmentFactory = new PivotEnvironmentFactory(null, metaModelManager);
			this.rootEnvironment = environmentFactory.createEnvironment();
		}

		public @NonNull MetaModelManager getMetaModelManager() {
			return metaModelManager;
		}

		/**
		 * Validate all of eClassifier's constraints for object, appending warnings and at most one error to diagnostics
		 * using context to elaborate the validation context.
		 */
		public boolean validate(@NonNull EClassifier eClassifier, @Nullable Object object, @Nullable DiagnosticChain diagnostics, @Nullable Map<Object, Object> context) {
			boolean allOk = true;
			Type type = metaModelManager.getPivotOfEcore(Type.class, eClassifier);
			if (type != null) {
				for (Constraint constraint : metaModelManager.getAllInvariants(type)) {
					if (constraint !=  null) {
						Diagnostic diagnostic = validate(constraint, object, context);
						if (diagnostic != null) {
							if (diagnostics != null) {
								diagnostics.add(diagnostic);
							}
							allOk = false;
							if (diagnostic.getSeverity() == Diagnostic.ERROR) {
								return allOk;		// Generate many warnings but only one error
							}
						}
					}
				}
			}
			return allOk;
		}

		/**
		 * Validate constraint for object using context to elaborate the validation context.
		 * Returns null for no problem or a warning/error severity diagnostic for a problem.
		 */
		public @Nullable Diagnostic validate(final @NonNull Constraint constraint, final @Nullable Object object, final @Nullable Map<Object, Object> context) {
			OpaqueExpression specification = constraint.getSpecification();
			if (specification == null) {
				return null;
			}
			ExpressionInOCL query = specification.getExpressionInOCL();
			if (query == null) {
				return null;
			}
			Variable contextVariable = query.getContextVariable();
			if (contextVariable == null) {
				return null;
			}
			OCLExpression bodyExpression = query.getBodyExpression();
			if (bodyExpression == null) {	// May be null for declations of hand coded Java
				return null;
			}
			DomainModelManager oldModelManager = null;
			if (context != null) {
				oldModelManager = (DomainModelManager) context.get(DomainModelManager.class);
			}
			EvaluationVisitor evaluationVisitor = environmentFactory.createEvaluationVisitor(rootEnvironment, object, query, oldModelManager);
			if (context != null) {
				DomainModelManager newModelManager = evaluationVisitor.getModelManager();
				if (newModelManager != oldModelManager) {
					context.put(DomainModelManager.class, newModelManager);
				}
				Object monitor = context.get(Monitor.class);
				if (monitor instanceof Monitor) {
					evaluationVisitor.setMonitor((Monitor) monitor);
				}
			}
			ConstraintEvaluator<Diagnostic> constraintEvaluator = new ConstraintEvaluator<Diagnostic>(query)
			{
				@Override
				protected String getObjectLabel() {
					Type type = PivotUtil.getContainingType(constraint);
					Type primaryType = type != null ? metaModelManager.getPrimaryType(type) : null;
					EObject eTarget = primaryType != null ? primaryType.getETarget() : null;
					EClassifier eClassifier = eTarget instanceof EClassifier ?  (EClassifier)eTarget : null;
					return DomainUtil.getLabel(eClassifier, object, context);
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
			};
			Diagnostic diagnostic = constraintEvaluator.evaluate(evaluationVisitor);
			if (diagnostic != null) {			// FIXME Debugging
				constraintEvaluator.evaluate(evaluationVisitor);
			}
			return diagnostic;
		}
	}

	/**
	 * The static instance that is installed in the EValidator.Registry.INSTANCE to compose
	 * Pivot validation with whatever other validation was installed. 
	 */
	private static final @NonNull PivotEObjectValidator INSTANCE = new PivotEObjectValidator();

	/**
	 * Install Complete OCL validation support in resourceSet for metaModelManager.
	 */
	public static @NonNull ValidationAdapter install(@NonNull ResourceSet resourceSet, @NonNull MetaModelManager metaModelManager) {
		ValidationAdapter validationAdapter = ValidationAdapter.findAdapter(resourceSet);
		if (validationAdapter != null) {
			if (validationAdapter.getMetaModelManager() != metaModelManager) {
				throw new IllegalArgumentException("Inconsistent metaModelManager");
			}
		}
		else {
			validationAdapter = new ValidationAdapter(metaModelManager);
			resourceSet.eAdapters().add(validationAdapter);
		}
		return validationAdapter;
	}
	
	/**
	 * Install Pivot-defined validation support for ePackage.
	 */
	public static synchronized void install(@NonNull EPackage ePackage) {
		ComposedEValidator composedEValidator = ComposedEValidator.install(ePackage);
		composedEValidator.addChild(INSTANCE);
	}

	/**
	 * Return the user's ResourceSet, preferably as a data element of the diagnostics, corresponding to
	 * the original validation context, else from the object else from the eClassifier.
	 */
	public static ResourceSet getResourceSet(@NonNull EClassifier eClassifier, @Nullable Object object, @Nullable DiagnosticChain diagnostics) {
		ResourceSet resourceSet = null;
		if (diagnostics instanceof BasicDiagnostic) {
			for (Object dataObject : ((BasicDiagnostic)diagnostics).getData()) {
				if (dataObject instanceof EObject) {
					Resource resource = EcoreUtil.getRootContainer((EObject) dataObject).eResource();
					if (resource != null) {
						resourceSet = resource.getResourceSet();
						if (resourceSet != null) {
							break;
						}
					}
				}
			}
		}
		if (resourceSet == null) {
			if (object instanceof EObject) {
				Resource resource = EcoreUtil.getRootContainer((EObject) object).eResource();
				if (resource != null) {
					resourceSet = resource.getResourceSet();
				}
			}
			if (resourceSet == null) {
				Resource resource = EcoreUtil.getRootContainer(eClassifier).eResource();
				if (resource != null) {
					resourceSet = resource.getResourceSet();
				}
			}
		}
		return resourceSet;
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}

	/**
	 * Overriden to intercept the validation of an EObject to add the additional Pivot-defined validation.
	 */
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		if ((eClass != null) && !eObject.eIsProxy()) {
			allOk &= validatePivot(eClass, eObject, diagnostics, context);
		}
		return allOk;
	}

	/**
	 * Overriden to intercept the validation of an EDataType value to add the additional Pivot-defined validation.
	 */
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		if (eDataType != null) {
			allOk &= validatePivot(eDataType, value, diagnostics, context);
		}
		return allOk;
/*		assert value != null;
		boolean allOk = true;
		EPackage ePackage = eDataType.getEPackage();
		EValidator eValidator = eValidators.get(ePackage);
		if (eValidator != null) {
			allOk &= eValidator.validate(eDataType, value, diagnostics, context);
		}
		if ((allOk || (diagnostics != null)) && eDataType.isInstance(value)) {
			allOk &= validatePivot(eDataType, value, diagnostics, context);
		}
		return allOk; */
	}

	/**
	 * Perform the additional Pivot-defined validation.
	 */
	protected boolean validatePivot(@NonNull EClassifier eClassifier, @Nullable Object object, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context) {
		ResourceSet resourceSet = getResourceSet(eClassifier, object, diagnostics);
		if (resourceSet != null) {
			ValidationAdapter validationAdapter = ValidationAdapter.findAdapter(resourceSet);
			if (validationAdapter != null) {
				boolean allOk = validationAdapter.validate(eClassifier, object, diagnostics, context);
				return allOk || (diagnostics != null);
			}
		}
		return true;
	}
}

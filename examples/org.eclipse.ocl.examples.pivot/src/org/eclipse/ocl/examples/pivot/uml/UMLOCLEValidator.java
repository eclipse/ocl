/*
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.utilities.ConstraintEvaluator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLValidator;

/**
 * UMLOCLEValidator provides the validation support for UML elements that exploit OCL.
 * <p>
 * Typically used with a Diagnostician as:
 * <pre>
 *	EValidatorRegistryImpl registry = new EValidatorRegistryImpl();
 *	registry.put(UMLPackage.eINSTANCE, UMLOCLEValidator.INSTANCE);
 *	Diagnostician diagnostician = new Diagnostician(registry);
 *	Diagnostic diagnostic = dignostician.validate(eObject, validationContext);
 * </pre>
 */
public class UMLOCLEValidator implements EValidator
{
	/**
	 * ConstraintEvaluatorWithoutDiagnostics provides the minimal ConstraintEvaluator support for
	 * use when no diagnostics are required.
	 */
	public static class ConstraintEvaluatorWithoutDiagnostics extends ConstraintEvaluator<Boolean>
	{
		public ConstraintEvaluatorWithoutDiagnostics(@NonNull ExpressionInOCL expression) {
			super(expression);
		}

		@Override
		protected String getObjectLabel() {
			throw new UnsupportedOperationException(); // Cannot happen;
		}

		@Override
		protected Boolean handleExceptionResult(@NonNull Throwable e) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleFailureResult(@Nullable Object result) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidExpression(@NonNull String message) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidResult(@NonNull InvalidValueException e) {
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleSuccessResult() {
			return Boolean.TRUE;
		}
	}

	/**
	 * ConstraintEvaluatorWithoutDiagnostics provides the richer ConstraintEvaluator support for
	 * use when diagnostics are required.
	 */
	public static class ConstraintEvaluatorWithDiagnostics extends ConstraintEvaluator<Boolean>
	{
		protected final @NonNull EObject eObject;
		protected final @NonNull DiagnosticChain diagnostics;
		protected final @NonNull EObject diagnosticEObject;
		protected final boolean mayUseNewLines;

		public ConstraintEvaluatorWithDiagnostics(@NonNull ExpressionInOCL expression, @NonNull EObject eObject,
				@NonNull DiagnosticChain diagnostics, @NonNull EObject diagnosticEObject, boolean mayUseNewLines) {
			super(expression);
			this.diagnosticEObject = diagnosticEObject;
			this.eObject = eObject;
			this.diagnostics = diagnostics;
			this.mayUseNewLines = mayUseNewLines;
		}

		@Override
		protected String getObjectLabel() {
			return EcoreUtils.qualifiedNameFor(eObject);
		}

		@Override
		protected Boolean handleExceptionResult(@NonNull Throwable e) {
			String message = DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, getConstraintTypeName(), getConstraintName(), getObjectLabel(), e.toString());
			if (!mayUseNewLines) {
				message = message.replace("\n", "");
			}
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleFailureResult(@Nullable Object result) {
			int severity = getConstraintResultSeverity(result);
			String message = getConstraintResultMessage(result);
			diagnostics.add(new BasicDiagnostic(severity, UMLValidator.DIAGNOSTIC_SOURCE,
				0, message,  new Object[] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidExpression(@NonNull String message) {
			String message2 = message;
			if (!mayUseNewLines) {
				message2 = message.replace("\n", "");
			}
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EObjectValidator.DIAGNOSTIC_SOURCE,
				0, message2.replace("\n", " - "), new Object [] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleInvalidResult(@NonNull InvalidValueException e) {
			String message = DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_,
				getConstraintTypeName(), getConstraintName(), getObjectLabel(), e.getLocalizedMessage());
			if (!mayUseNewLines) {
				message = message.replace("\n", "");
			}
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
				0, message,  new Object[] { diagnosticEObject }));
			return Boolean.FALSE;
		}

		@Override
		protected Boolean handleSuccessResult() {
			return Boolean.TRUE;
		}
	}

	/**
	 * WeakOCLReference maintains the reference to the OCL context within the Diagnostician context and
	 * disposes of it once the Diagnostician is done.
	 */
	protected static final class WeakOCLReference extends WeakReference<OCL>
	{
		protected final @NonNull OCL ocl;
		
		protected WeakOCLReference(@NonNull OCL ocl) {
			super(ocl);
			this.ocl = ocl;
		}

		@Override
		public void finalize() {
			new Thread("OCL-Finalizer")
			{
				@Override
				public void run() {
					ocl.dispose();
				}
			}.start();
		}
	}

	public static final @NonNull UMLOCLEValidator INSTANCE = new UMLOCLEValidator(true);
	public static final @NonNull UMLOCLEValidator NO_NEW_LINES = new UMLOCLEValidator(false);
	public static final @NonNull TracingOption VALIDATE_INSTANCE = new TracingOption(PivotPlugin.PLUGIN_ID, "validate/instance");
	public static final @NonNull TracingOption VALIDATE_OPAQUE_ELEMENT = new TracingOption(PivotPlugin.PLUGIN_ID, "validate/opaqueElement");

	protected static void gatherClassifiers(@NonNull Set<Classifier> allClassifiers, @NonNull Set<Constraint> allConstraints, @NonNull Classifier newClassifier) {
		if (allClassifiers.add(newClassifier)) {
			allConstraints.addAll(newClassifier.getOwnedRules());
			if (newClassifier instanceof org.eclipse.uml2.uml.Class) {
				for (Classifier classifier : ((org.eclipse.uml2.uml.Class)newClassifier).getSuperClasses()) {
					if (classifier != null) {
						gatherClassifiers(allClassifiers, allConstraints, classifier);
					}
				}
			}
		}
	}

	protected static void gatherTypes(@NonNull Set<Type> allTypes, @NonNull Set<DomainConstraint> allConstraints, @NonNull Type newType) {
		if (allTypes.add(newType)) {
			allConstraints.addAll(newType.getOwnedInvariant());
			for (Type superType : newType.getSuperClass()) {
				if (superType != null) {
					gatherTypes(allTypes, allConstraints, superType);
				}
			}
		}
	}
	
	protected final boolean mayUseNewLines;

	public UMLOCLEValidator(boolean mayUseNewLines) {
		this.mayUseNewLines = mayUseNewLines;
	}

	/**
	 * Return the OCL context for the validation, caching the created value in the validation context for re-use by
	 * further validations. The cached reference is weak to ensure that the OCL context is disposed once no longer in use.
	 */
	protected OCL getOCL(@NonNull Map<Object, Object> context) {
		OCL ocl = null;
		Object oclRef = context.get(WeakOCLReference.class);
		if (oclRef instanceof WeakOCLReference) {
			ocl = ((WeakOCLReference)oclRef).get();
		}
		if (ocl == null) {
			ocl = OCL.newInstance();
			context.put(WeakOCLReference.class, new WeakOCLReference(ocl));
		}
		return ocl;
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
	    return validate(eObject.eClass(), eObject, diagnostics, context); 
//		return true;
	}

	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert context != null;
		boolean allOk = true;
		if (eObject instanceof org.eclipse.uml2.uml.OpaqueExpression) {
			org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)eObject;
			@SuppressWarnings("null")@NonNull List<String> languages = opaqueExpression.getLanguages();
			@SuppressWarnings("null")@NonNull List<String> bodies = opaqueExpression.getBodies();
			allOk = validateOpaqueElement(languages, bodies, opaqueExpression, diagnostics, context);
		}
		else if (eObject instanceof InstanceSpecification) {
			allOk = validateInstanceSpecification((InstanceSpecification)eObject, diagnostics, context);
		}
		try {
			if (eObject instanceof org.eclipse.uml2.uml.Element) {
				List<EObject> umlStereotypeApplications = ((org.eclipse.uml2.uml.Element)eObject).getStereotypeApplications();
				if (umlStereotypeApplications.size() > 0) {
					Resource umlResource = umlStereotypeApplications.get(0).eClass().eResource();
					if (umlResource != null) {
						OCL ocl = getOCL(context);
						MetaModelManager metaModelManager = ocl.getMetaModelManager();
						UML2Pivot uml2pivot = UML2Pivot.getAdapter(umlResource, metaModelManager);
						uml2pivot.getPivotRoot();
						Map<EObject, List<org.eclipse.uml2.uml.Element>> umlStereotypeApplication2umlStereotypedElements = UML2PivotUtil.computeAppliedStereotypes(umlStereotypeApplications);
						for (@SuppressWarnings("null")@NonNull EObject umlStereotypeApplication : umlStereotypeApplications) {
							@SuppressWarnings("null")@NonNull List<Element> umlStereotypedElements = umlStereotypeApplication2umlStereotypedElements.get(umlStereotypeApplication);
							Stereotype stereotype = uml2pivot.resolveStereotype(umlStereotypeApplication, umlStereotypedElements);
							if (stereotype != null) {
								HashSet<Type> allClassifiers = new HashSet<Type>();
								HashSet<DomainConstraint> allConstraints = new HashSet<DomainConstraint>();
								gatherTypes(allClassifiers, allConstraints, stereotype);
								for (DomainConstraint constraint : allConstraints) {
									DomainExpression specification = constraint.getSpecification();
									if (specification instanceof org.eclipse.ocl.examples.pivot.OpaqueExpression) {
										ExpressionInOCL asExpression = ((org.eclipse.ocl.examples.pivot.OpaqueExpression)specification).getExpressionInOCL();						
										if (asExpression != null) {
											EvaluationVisitor evaluationVisitor = ocl.createEvaluationVisitor(umlStereotypeApplication, asExpression);
											ConstraintEvaluator<Boolean> constraintEvaluator;
											if (diagnostics != null) {
												constraintEvaluator = new ConstraintEvaluatorWithDiagnostics(asExpression, umlStereotypeApplication, diagnostics, eObject, mayUseNewLines);
											}
											else {
												constraintEvaluator = new ConstraintEvaluatorWithoutDiagnostics(asExpression);
											}
											if (!constraintEvaluator.evaluate(evaluationVisitor) && (diagnostics == null)) {
												allOk = false;
											}
										}
									}
								}
							}
						}
					}
				}
				return allOk;
			}
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Perform the validation of an instanceSpecification against the bodies defined in opaqueExpression.
	 */
	protected boolean validateInstance(@NonNull EObject instanceSpecification,
			@NonNull org.eclipse.uml2.uml.OpaqueExpression opaqueExpression, @Nullable DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		boolean allOk = true;
		if (context != null) {
			EList<String> bodies = opaqueExpression.getBodies();
			EList<String> languages = opaqueExpression.getLanguages();
			for (int i = 0; i < bodies.size(); i++) {
				try {
					String language = i < languages.size() ? languages.get(i) : PivotConstants.OCL_LANGUAGE;
					if ((i >= languages.size()) || PivotConstants.OCL_LANGUAGE.equals(languages.get(i))) {
						String body = bodies.get(i);
						if (body != null) {
							if (VALIDATE_INSTANCE.isActive()) {
								VALIDATE_INSTANCE.println(language + ": " + body);
							}
							if (!validateSyntax(instanceSpecification, body, opaqueExpression, diagnostics, context) && (diagnostics == null)) {
								allOk = false;
								break;
							}
						}
					}
				} catch (Throwable e) {
					if (diagnostics != null) {
						String objectLabel = EObjectValidator.getObjectLabel(opaqueExpression, context);
						String message = NLS.bind("Body processing error {0} on {1}", e, objectLabel);
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
							0, message,  new Object[] { opaqueExpression }));
					}
					else {
						allOk = false;
					}
				}
			}
		}
		return allOk;
	}

	/**
	 * Validate the OCL aspects of a UML InstanceSpecification, by evaluating all OCL Constraints
	 * defined by any of the InstanceSpecification's classifiers on the InstanceSpecification.
	 * <p>
	 * Returns true if all OCL constraints pass.
	 */
	public boolean validateInstanceSpecification(@NonNull InstanceSpecification instanceSpecification,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		HashSet<Classifier> allClassifiers = new HashSet<Classifier>();
		HashSet<Constraint> allConstraints = new HashSet<Constraint>();
		for (Classifier classifier : instanceSpecification.getClassifiers()) {
			if (classifier != null) {
				gatherClassifiers(allClassifiers, allConstraints, classifier);
			}
		}
		boolean allOk = true;
		for (Constraint constraint : allConstraints) {
			ValueSpecification specification = constraint.getSpecification();
			if (specification instanceof org.eclipse.uml2.uml.OpaqueExpression) {
				org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)specification;
				if (!validateInstance(instanceSpecification, opaqueExpression, diagnostics, context) && (diagnostics == null))
					allOk = false;
			}
		}
		return allOk;
	}

	/**
	 * Validate the syntax and semantics of any OCL body.
	 * <p>
	 * Returns true if all OCL bodies are valid.
	 */
	public boolean validateOpaqueAction(@NonNull OpaqueAction opaqueAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return UMLOCLEValidator.INSTANCE.validateOpaqueElement(opaqueAction.getLanguages(),
				opaqueAction.getBodies(), opaqueAction, diagnostics, context);
	}

	/**
	 * Validate the syntax and semantics of any OCL body.
	 * <p>
	 * Returns true if all OCL bodies are valid.
	 */
	public boolean validateOpaqueBehavior(@NonNull OpaqueBehavior opaqueBehavior, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return UMLOCLEValidator.INSTANCE.validateOpaqueElement(opaqueBehavior.getLanguages(),
				opaqueBehavior.getBodies(), opaqueBehavior, diagnostics, context);
	}
	
	/**
	 * Validate the syntax and semantics of any OCL bofy.
	 * <p>
	 * Returns true if all OCL bodies are valid.
	 */
	public boolean validateOpaqueExpression(@NonNull OpaqueExpression opaqueExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return UMLOCLEValidator.INSTANCE.validateOpaqueElement(opaqueExpression.getLanguages(),
				opaqueExpression.getBodies(), opaqueExpression, diagnostics, context);
	}

	/**
	 * Perform the semantic validation of the bodies of an opaqueElement using the corresponding languages support.
	 */
	protected boolean validateOpaqueElement(/*@NonNull*/ List<String> languages, /*@NonNull*/ List<String> bodies,
			@NonNull Element opaqueElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		if (context != null) {
			for (int i = 0; i < bodies.size(); i++) {
				if ((i >= languages.size()) || PivotConstants.OCL_LANGUAGE.equals(languages.get(i))) {
					try {
						String body = bodies.get(i);
						if (body != null) {
							if (VALIDATE_OPAQUE_ELEMENT.isActive()) {
								VALIDATE_OPAQUE_ELEMENT.println(PivotConstants.OCL_LANGUAGE + ": " + body);
							}
							if (!validateSyntax(null, body, opaqueElement, diagnostics, context) && (diagnostics == null)) {
								allOk = false;
								break;
							}
						}
					} catch (Throwable e) {
						if (diagnostics != null) {
							String objectLabel = EObjectValidator.getObjectLabel(opaqueElement, context);
							String message = NLS.bind("Body language processing error {0} on {1}", e, objectLabel);
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
								0, message,  new Object[] { opaqueElement }));
						}
						else {
							allOk = false;
						}
					}
				}
			}
		}
		return allOk;
	}

	/**
	 * Perform the validation of the body text for an opaqueElement and if instance is non-null use the body to validate
	 * the instance. If diagnostics is non-null, problems should be identified by Diagnostic instances added to diagnostics.
	 * context may be used to pass additional options from a calling context to the validation, and may be used to pass
	 * cached results between successive validations. Returns true if successful, false otherwise.
	 */
	protected boolean validateSyntax(final @Nullable EObject instance, @NonNull String body, @NonNull org.eclipse.uml2.uml.Element opaqueElement, final @Nullable DiagnosticChain diagnostics, @NonNull Map<Object, Object> context) {
		OCL ocl = getOCL(context);
		ExpressionInOCL asExpression = null;
		try {
			MetaModelManager metaModelManager = ocl.getMetaModelManager();
			org.eclipse.ocl.examples.pivot.OpaqueExpression asElement = metaModelManager.getPivotOf(org.eclipse.ocl.examples.pivot.OpaqueExpression.class, opaqueElement);
			if (asElement == null) {
				if (diagnostics != null) {
					String objectLabel = DomainUtil.getLabel(opaqueElement);
					String message = DomainUtil.bind("No pivot for {0}", objectLabel);
					if (!mayUseNewLines) {
						message = message.replace("\n", " ");
					}
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
						0, message,  new Object[] { opaqueElement }));
				}
				return false;
			}
			asExpression = asElement.getValidExpressionInOCL();
		} catch (ParserException e) {
			if (diagnostics != null) {
				String objectLabel = DomainUtil.getLabel(opaqueElement);
				String message = DomainUtil.bind(OCLMessages.ParsingError, objectLabel, e.getMessage());
				if (!mayUseNewLines) {
					message = message.replace("\n", " ");
				}
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { opaqueElement }));
			}
			return false;
		}
		if (instance != null) {
			EvaluationVisitor evaluationVisitor = ocl.createEvaluationVisitor(instance, asExpression);
			ConstraintEvaluator<Boolean> constraintEvaluator;
			if (diagnostics != null) {
				constraintEvaluator = new ConstraintEvaluatorWithDiagnostics(asExpression, instance, diagnostics, instance, mayUseNewLines);
			}
			else {
				constraintEvaluator = new ConstraintEvaluatorWithoutDiagnostics(asExpression);
			}
			return constraintEvaluator.evaluate(evaluationVisitor);
		}
		else {
			return true;
		}
	}
}

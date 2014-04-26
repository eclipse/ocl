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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.domain.elements.DomainConstraint;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.ElementExtension;
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
	public static final @NonNull UMLOCLEValidator INSTANCE = new UMLOCLEValidator();
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

	protected OCL getOCL(Map<Object, Object> context) {
		OCL ocl = (OCL) context.get(OCL.class);
		if (ocl == null) {
			ocl = OCL.newInstance();
			context.put(OCL.class, ocl);
		}
		return ocl;
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	public boolean validate(EClass eClass, final EObject eObject, final DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (eObject instanceof org.eclipse.uml2.uml.OpaqueExpression) {
			org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)eObject;
			@SuppressWarnings("null")@NonNull List<String> languages = opaqueExpression.getLanguages();
			@SuppressWarnings("null")@NonNull List<String> bodies = opaqueExpression.getBodies();
			return validateOpaqueElement(languages, bodies, opaqueExpression, diagnostics, context);
		}
		else if (eObject instanceof InstanceSpecification) {
			return validateInstanceSpecification((InstanceSpecification)eObject, diagnostics, context);
		}
		OCL ocl = getOCL(context);
		MetaModelManager metaModelManager = ocl.getMetaModelManager();
		try {
			final org.eclipse.ocl.examples.pivot.Element asElement = metaModelManager.getPivotOf(org.eclipse.ocl.examples.pivot.Element.class, eObject);
			if (asElement != null) {
				List<ElementExtension> extensions = asElement.getExtension();
				for (final ElementExtension extension : extensions) {
//					org.eclipse.ocl.examples.pivot.Element base = extension.getBase();
					Stereotype stereotype = extension.getStereotype();
					if (stereotype != null) {
						HashSet<Type> allClassifiers = new HashSet<Type>();
						HashSet<DomainConstraint> allConstraints = new HashSet<DomainConstraint>();
						gatherTypes(allClassifiers, allConstraints, stereotype);
						boolean allOk = true;
						for (DomainConstraint constraint : allConstraints) {
							DomainExpression specification = constraint.getSpecification();
							if (specification instanceof org.eclipse.ocl.examples.pivot.OpaqueExpression) {
								ExpressionInOCL asExpression = ((org.eclipse.ocl.examples.pivot.OpaqueExpression)specification).getExpressionInOCL();						
								if (asExpression != null) {
									EvaluationVisitor evaluationVisitor = ocl.createEvaluationVisitor(extension, asExpression);
									ConstraintEvaluator<Boolean> constraintEvaluator = new ConstraintEvaluator<Boolean>(asExpression)
									{
	//									@Override
	//									protected String getObjectLabel() {
	//										Type type = PivotUtil.getContainingType(constraint);
	//										Type primaryType = type != null ? metaModelManager.getPrimaryType(type) : null;
	//										EClassifier eClassifier = primaryType != null ?  (EClassifier)primaryType.getETarget() : null;
	//										return DomainUtil.getLabel(eClassifier, object, context);
	//									}
	
										@Override
										protected String getObjectLabel() {
											return DomainUtil.getLabel(extension);
										}
	
										@Override
										protected Boolean handleExceptionResult(@NonNull Exception e) {
											if (diagnostics != null) {
												String message = DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, getConstraintTypeName(), getConstraintName(), getObjectLabel());
												diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
													0, message,  new Object[] { extension.eContainer() }));
											}
											return Boolean.FALSE;
										}
	
										@Override
										protected Boolean handleFailureResult(@Nullable Object result) {
											if (diagnostics != null) {
												int severity = getConstraintResultSeverity(result);
												String message = getConstraintResultMessage(result);
												diagnostics.add(new BasicDiagnostic(severity, UMLValidator.DIAGNOSTIC_SOURCE,
													0, message,  new Object[] { extension.eContainer() }));
											}
											return Boolean.FALSE;
										}
	
										@Override
										protected Boolean handleInvalidResult(@NonNull InvalidValueException e) {
											if (diagnostics != null) {
												String message = DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, getConstraintTypeName(), getConstraintName(), getObjectLabel());
												diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
													0, message,  new Object[] { extension.eContainer() }));
											}
											return Boolean.FALSE;
										}
	
										@Override
										protected Boolean handleSuccessResult() {
											return Boolean.TRUE;
										}
									};
									if (!constraintEvaluator.evaluate(evaluationVisitor)) {
										allOk = false;
									}
								}
							}
						}
						return allOk;
					}
				}
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
							if (!validateSyntax(instanceSpecification, body, opaqueExpression, diagnostics, context)) {
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
					allOk = false;
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
				if (!validateInstance(instanceSpecification, opaqueExpression, diagnostics, context))
					allOk = false;
			}
		}
		return allOk;
	}

	/**
	 * Validate the syntax and semantics of any OCL bofy.
	 * <p>
	 * Returns true if all OCL bodies are valid.
	 */
	public boolean validateOpaqueAction(@NonNull OpaqueAction opaqueAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return UMLOCLEValidator.INSTANCE.validateOpaqueElement(opaqueAction.getLanguages(),
				opaqueAction.getBodies(), opaqueAction, diagnostics, context);
	}

	/**
	 * Validate the syntax and semantics of any OCL bofy.
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
							if (!validateSyntax(null, body, opaqueElement, diagnostics, context)) {
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
						allOk = false;
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
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
					0, message,  new Object[] { opaqueElement }));
			}
			return false;
		}
		if (instance != null) {
			EvaluationVisitor evaluationVisitor = ocl.createEvaluationVisitor(instance, asExpression);
			ConstraintEvaluator<Boolean> constraintEvaluator = new ConstraintEvaluator<Boolean>(asExpression)
			{
//				@Override
//				protected String getObjectLabel() {
//					Type type = PivotUtil.getContainingType(constraint);
//					Type primaryType = type != null ? metaModelManager.getPrimaryType(type) : null;
//					EClassifier eClassifier = primaryType != null ?  (EClassifier)primaryType.getETarget() : null;
//					return DomainUtil.getLabel(eClassifier, object, context);
//				}

				@Override
				protected String getObjectLabel() {
					return DomainUtil.getLabel(instance);
				}

				@Override
				protected Boolean handleExceptionResult(@NonNull Exception e) {
					if (diagnostics != null) {
						String message = DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, getConstraintTypeName(), getConstraintName(), getObjectLabel());
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
							0, message,  new Object[] { instance }));
					}
					return Boolean.FALSE;
				}

				@Override
				protected Boolean handleFailureResult(@Nullable Object result) {
					if (diagnostics != null) {
						String message = getConstraintResultMessage(result);
						int severity = getConstraintResultSeverity(result);
						diagnostics.add(new BasicDiagnostic(severity, UMLValidator.DIAGNOSTIC_SOURCE,
							0, message,  new Object[] { instance }));
					}
					return Boolean.FALSE;
				}

				@Override
				protected Boolean handleInvalidResult(@NonNull InvalidValueException e) {
					if (diagnostics != null) {
						String message = DomainUtil.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, getConstraintTypeName(), getConstraintName(), getObjectLabel());
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, UMLValidator.DIAGNOSTIC_SOURCE,
							0, message,  new Object[] { instance }));
					}
					return Boolean.FALSE;
				}

				@Override
				protected Boolean handleSuccessResult() {
					return Boolean.TRUE;
				}
			};
			return constraintEvaluator.evaluate(evaluationVisitor);
		}
		else {
			return true;
		}
	}
}

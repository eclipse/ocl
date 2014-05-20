/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.validity.locator;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.locator.AbstractConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ConstrainingURI;
import org.eclipse.ocl.examples.emf.validation.validity.manager.TypeURI;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityModel;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.ConstraintEvaluator;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

public class UMLConstraintLocator extends AbstractConstraintLocator
{
	public static @NonNull UMLConstraintLocator INSTANCE = new UMLConstraintLocator();
	
	protected void appendPath(@NonNull StringBuilder s, @NonNull NamedElement eObject) {
		EObject eContainer = eObject.eContainer();
		if (eContainer instanceof NamedElement) {
			appendPath(s, (NamedElement)eContainer);
			s.append("::");
		}
		s.append(eObject.getName());
	}

	@Override
	public @NonNull Set<TypeURI> getAllTypes(@NonNull ValidityManager validityManager, @NonNull EObject constrainingType) {
		if (constrainingType instanceof org.eclipse.uml2.uml.Class) {
			Set<TypeURI> allTypes = new HashSet<TypeURI>();
			allTypes.add(validityManager.getTypeURI(constrainingType));
			if (constrainingType instanceof org.eclipse.uml2.uml.Class) {
				getAllTypes(allTypes, validityManager, ((org.eclipse.uml2.uml.Class)constrainingType).getSuperClasses());
			}
			return allTypes;
		}
		else {
			return super.getAllTypes(validityManager, constrainingType);
		}
	}

	private void getAllTypes(Set<TypeURI> knownTypes, @NonNull ValidityManager validityManager, Iterable<org.eclipse.uml2.uml.Class> moreTypes) {
		for (org.eclipse.uml2.uml.Class anotherType : moreTypes) {
			if ((anotherType != null) && knownTypes.add(validityManager.getTypeURI(anotherType))) {
				getAllTypes(knownTypes, validityManager, anotherType.getSuperClasses());
			}
		}
	}

	@Override
	public @Nullable Set<ConstrainingURI> getConstrainingURIs(@NonNull ValidityManager validityManager, @NonNull EObject validatableObject) {
		EClass eClass = validatableObject.eClass();
		if (eClass != null) {
			EAnnotation eAnnotation = eClass.getEAnnotation("http://www.eclipse.org/uml2/2.0.0/UML");
			if ((eAnnotation != null) && (eAnnotation.getReferences().size() > 0)) { // Stereotype application
				EObject umlClass = eAnnotation.getReferences().get(0);
				if (umlClass != null) {
					ConstrainingURI constrainingURI = validityManager.getConstrainingURI(umlClass);
					Set<ConstrainingURI> allConstrainingURIs = new HashSet<ConstrainingURI>();
					allConstrainingURIs.add(constrainingURI);
					return allConstrainingURIs;
				}
			}
		}
		Set<ConstrainingURI> allConstrainingURIs = null;
		if (validatableObject instanceof InstanceSpecification) {
			ValidityModel validityModel = validityManager.getModel();
			if (validityModel != null) {
				if (eClass != null) {
					TypeURI typeURI = validityManager.getTypeURI(eClass);
					allConstrainingURIs = validityModel.accumulateConstrainingURIs(allConstrainingURIs, typeURI);
				}
				for (Classifier classifier : ((InstanceSpecification)validatableObject).getClassifiers()) {
					if (classifier != null) {
						TypeURI typeURI = validityManager.getTypeURI(classifier);
						allConstrainingURIs = validityModel.accumulateConstrainingURIs(allConstrainingURIs, typeURI);
					}
				}
//				System.out.println("Got it");
			}
		}
		return allConstrainingURIs;
	}

	@Override
	public @Nullable Map<EObject, List<LeafConstrainingNode>> getConstraints(@NonNull ValidityModel validityModel,
		@NonNull EPackage ePackage, @NonNull Set<Resource> resources, @NonNull Monitor monitor) {
			Map<EObject, List<LeafConstrainingNode>> map = null;
			for (Resource resource : resources) {
				if (monitor.isCanceled()) {
					return null;
				}
				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					if (eObject instanceof Constraint) {
						Constraint umlConstraint = (Constraint)eObject;
						Element contextElement = umlConstraint.getContext();
						if (contextElement instanceof Type) {
							@SuppressWarnings("null")@NonNull String label = String.valueOf(umlConstraint.getName());
	/*					LeafConstrainingNode constraint = validityModel.createLeafConstrainingNode();
						constraint.setConstraintLocator(this);
						constraint.setConstrainingObject(umlConstraint);
						constraint.setLabel(label);
						ConstrainingNode constrainingNode = validityModel.getConstrainingNode(constrainedElement);
						constrainingNode.getChildren().add(constraint);
						if (map == null) {
							map = new HashMap<EModelElement, List<LeafConstrainingNode>>();
						}
						List<LeafConstrainingNode> constraints = map.get(constrainedElement);
						if (constraints == null) {
							constraints = new ArrayList<LeafConstrainingNode>();
							map.put(constrainedElement, constraints);
						}
						constraints.add(constraint); */
	//						EClass eC = constrainedElement.eClass();
							map = createLeafConstrainingNode(map, validityModel, contextElement, umlConstraint, label);
						}
					}
					if (monitor.isCanceled()) {
						return null;
					}
				}
			}
			return map;
		}

	@Override
	public @Nullable Collection<Resource> getImports(@NonNull EPackage ePackage, @NonNull Resource resource) {
		Set<Resource> imports = new HashSet<Resource>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			@SuppressWarnings("null")@NonNull EObject eObject = tit.next();
			if (eObject instanceof PackageImport) {
				PackageImport umlPackageImport = (PackageImport)eObject;
				Package importedPackage = umlPackageImport.getImportedPackage();
				if (importedPackage != null) {
					Resource eResource = importedPackage.eResource();
					if (eResource != null) {
						imports.add(eResource);
					}
				}
//				tit.prune();
			}
//			else if (eObject instanceof Type) {
//				tit.prune();
//			}
			Resource eResource = eObject.eClass().eResource();
			if (eResource != null) {
				imports.add(eResource);
			}
		}
		return imports;
	}

	@Override
	public @NonNull String getLabel(@NonNull EModelElement eObject) {
		if (eObject instanceof NamedElement) {			// FIXME debugging - remove UML dependency
			StringBuilder s = new StringBuilder();
			appendPath(s, (NamedElement)eObject);
			@SuppressWarnings("null") @NonNull String string = s.toString();
			return string;
		}
		else {
			return super.getLabel(eObject);
		}
	}

	@Override
	public @NonNull String getName() {
		return "UML Constraints";
	}

	@Override
	public @Nullable String getSourceExpression(@NonNull LeafConstrainingNode node) {
		Object constrainingObject = node.getConstrainingObject();
		if (!(constrainingObject instanceof Constraint)) {
			return null;
		}
		ValueSpecification specification = ((Constraint)constrainingObject).getSpecification();
		if (!(specification instanceof OpaqueExpression)) {
			return null;
		}
		List<String> bodies = ((OpaqueExpression)specification).getBodies();
		return bodies.size() > 0 ? bodies.get(0) : null;
	}

	@Override
	public @Nullable Resource getSourceResource(@NonNull LeafConstrainingNode node) {
		Object constrainingObject = node.getConstrainingObject();
		if (!(constrainingObject instanceof EObject)) {
			return null;
		}
		return ((EObject)constrainingObject).eResource();
	}

	@Override
	public @Nullable URI getURI(@NonNull EObject eObject) {
		EObject eContainer = eObject;
		for ( ; true; eContainer = eContainer.eContainer()) {
			if (eContainer == null) {
				return null;
			}
			if (eContainer instanceof Package) {
				break;
			}
		}
		String nsURI = null;
		Stereotype appliedStereotype = ((Package)eContainer).getAppliedStereotype("Ecore::EPackage");
		if (appliedStereotype != null) {
			Object value = ((Package)eContainer).getValue(appliedStereotype, "nsURI");
			if (value != null) {
				nsURI = value.toString();
			}
		}
		if (nsURI == null) {
			nsURI = ((Package)eContainer).getURI();
		}
		if (nsURI == null) {
			return null;
		}
		Resource resource = eObject.eResource();
		if (resource == null) {
			return null;
		}
		String uriFragment = resource.getURIFragment(eObject);
		if (!uriFragment.startsWith("//")) {
			uriFragment = "//" + uriFragment;		// FIXME regularize this ?? UML2Ecore
		}
		return URI.createURI(nsURI).appendFragment(uriFragment);
	}

	@Override
	public void validate(@NonNull Result result, @NonNull ValidityManager validityManager, @Nullable Monitor monitor) {
		ValidatableNode validatableNode = result.getValidatableNode();
		EObject constrainedObject = validatableNode.getConstrainedObject();
		LeafConstrainingNode leafConstrainingNode = result.getLeafConstrainingNode();
		org.eclipse.uml2.uml.Constraint umlConstraint = (org.eclipse.uml2.uml.Constraint)leafConstrainingNode.getConstrainingObject();
		if (umlConstraint == null) {
			return;
		}
		MetaModelManager metaModelManager = PivotUtil.findMetaModelManager(umlConstraint);
		if (metaModelManager == null) {
			Resource eResource = umlConstraint.eResource();
			if (eResource == null) {
				return;
			}
			metaModelManager = PivotUtil.getMetaModelManager(eResource);
		}
		Severity severity = Severity.UNKNOWN;
		org.eclipse.ocl.examples.pivot.Constraint pivotConstraint;
		try {
			pivotConstraint = metaModelManager.getPivotOf(org.eclipse.ocl.examples.pivot.Constraint.class, umlConstraint);
			if (pivotConstraint == null) {
				throw new ParserException("Failed to create pivot Constraint");
			}
			EObject eObject = result.getValidatableNode().getConstrainedObject();
			ResourceSet resourceSet = eObject.eResource().getResourceSet();
			if (resourceSet != null) {
				final @NonNull org.eclipse.ocl.examples.pivot.Constraint constraint = pivotConstraint;
				final @Nullable Object object = constrainedObject;
				final @NonNull PivotEnvironmentFactory environmentFactory = new PivotEnvironmentFactory(null, metaModelManager);
				final @NonNull Environment rootEnvironment = environmentFactory.createEnvironment();
				final org.eclipse.ocl.examples.pivot.OpaqueExpression specification = constraint.getSpecification();
				assert specification != null;
				ExpressionInOCL query = specification.getExpressionInOCL();
				if (query == null) {
					throw new ParserException("Missing constraint");
				}
				EvaluationVisitor evaluationVisitor = environmentFactory.createEvaluationVisitor(rootEnvironment, object, query, null);
				evaluationVisitor.setMonitor(monitor);
				ConstraintEvaluator<Diagnostic> constraintEvaluator = new ConstraintEvaluator<Diagnostic>(query)
				{
					@Override
					protected String getObjectLabel() {
						org.eclipse.ocl.examples.pivot.Type type = PivotUtil.getContainingType(constraint);
						org.eclipse.ocl.examples.pivot.Type primaryType = type != null ? environmentFactory.getMetaModelManager().getPrimaryType(type) : null;
						Classifier classifier = primaryType != null ?  (Classifier)primaryType.getETarget() : null;
						return classifier != null ? classifier.getName() : "??";
//						return DomainUtil.getLabel(classifier, object, context);
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
				@Nullable Diagnostic diagnostic =constraintEvaluator.evaluate(evaluationVisitor);
				result.setDiagnostic(diagnostic);
				severity = diagnostic != null ? getSeverity(diagnostic) : Severity.OK;
			}
		} catch (Throwable e) {
			result.setException(e);
			severity = Severity.FATAL;
		} finally {
			result.setSeverity(severity);
		}
	}
}
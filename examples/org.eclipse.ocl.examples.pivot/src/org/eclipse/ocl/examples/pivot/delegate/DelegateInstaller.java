/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.PackageServer;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;
import org.eclipse.ocl.examples.pivot.options.OCLinEcoreOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.uml2.codegen.ecore.genmodel.util.UML2GenModelUtil;

public class DelegateInstaller
{	
	/**
	 * True to apply result = () wrapper to invariant body.
	 */
	public static final @NonNull String OPTION_BOOLEAN_INVARIANTS = "booleanInvariants";

	/**
	 * True to omit the setting delegates declaration. Useful for matching UML2Ecore behaviour.
	 */
	public static final @NonNull String OPTION_OMIT_SETTING_DELEGATES = "omitSettingDelegates";

	public static @Nullable String getAnnotationKey(@NonNull Constraint pivotConstraint) {
		String name = pivotConstraint.getName();
		EStructuralFeature eContainingFeature = pivotConstraint.eContainingFeature();
		if (eContainingFeature == PivotPackage.Literals.TYPE__OWNED_INVARIANT) {
			if (pivotConstraint.isCallable()) {
				return "body";
			}
			else {
				return name;
			}
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__PRECONDITION) {
			return name != null ? "pre_" + name : "pre";
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__POSTCONDITION) {
			return name != null ? "post_" + name : "post";
		}
		else {
//			error("Unsupported " + pivotConstraint);
		}
		return null;
	}
	
	public static @Nullable String getDelegateURI(@NonNull List<EObject> contents) {
		for (EObject eObject : contents) {
			if (eObject instanceof EPackage) {
				String exportURI = getDelegateURI((EPackage)eObject);
				if (exportURI != null) {
					return exportURI;
				}
			}
		}
		return null;
	}

	public static @Nullable String getDelegateURI(@NonNull EPackage ePackage) {
		Set<String> allURIs = new HashSet<String>();
//		allURIs.addAll(EcoreUtil.getConversionDelegates(ePackage));
		allURIs.addAll(EcoreUtil.getInvocationDelegates(ePackage));
//		allURIs.addAll(EcoreUtil.getQueryDelegates(ePackage));
		allURIs.addAll(EcoreUtil.getSettingDelegates(ePackage));
		allURIs.addAll(EcoreUtil.getValidationDelegates(ePackage));
		String theURI = null;
		for (String uri : allURIs) {
			if (uri.startsWith(OCLConstants.OCL_DELEGATE_URI)) {
				if (theURI != null) {
					return OCLConstants.OCL_DELEGATE_URI;
				}
				theURI = uri;
			}
		}
		if (theURI != null) {
			return theURI;
		}
		for (@SuppressWarnings("null")@NonNull EPackage eSubpackage : ePackage.getESubpackages()) {
			String exportURI = getDelegateURI(eSubpackage);
			if (exportURI != null) {
				return exportURI;
			}
		}
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				return classifierAnnotation.getSource();
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = OCLCommon.getDelegateAnnotation(eFeature);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						return featureAnnotation.getSource();
					}
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = OCLCommon.getDelegateAnnotation(eOperation);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						return operationAnnotation.getSource();
					}
				}
			}
		}
		return null;
	}

	public static @Nullable String getExportDelegateURI(@NonNull Map<String, Object> options) {
		String exportDelegateURI = (String)options.get(OCLConstants.OCL_DELEGATE_URI);
		return exportDelegateURI != null ? exportDelegateURI : OCLinEcoreOptions.EXPORT_DELEGATION_URI.getPreferredValue();
	}

	public static boolean isBooleanInvariants(@NonNull Map<String,Object> options) {
		return Boolean.valueOf(String.valueOf(options.get(OPTION_BOOLEAN_INVARIANTS)));
	}

	public static boolean needsDelegates(@NonNull EPackage ePackage) {
		boolean needsDelegates = false;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = OCLCommon.getDelegateAnnotation(eClassifier);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				needsDelegates = true;
				break;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = OCLCommon.getDelegateAnnotation(eFeature);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = OCLCommon.getDelegateAnnotation(eOperation);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
			}
		}
		return needsDelegates;
	}

	protected final @NonNull MetaModelManager metaModelManager;
	protected final @NonNull Map<String, Object> options;
	protected final @Nullable String exportDelegateURI;

	public DelegateInstaller(@NonNull MetaModelManager metaModelManager, @Nullable Map<String, Object> options) {
		this.metaModelManager = metaModelManager;
		this.options = options != null ? options : new HashMap<String,Object>();
		this.exportDelegateURI = getExportDelegateURI(this.options);
	}

	protected @NonNull EAnnotation createAnnotation(@NonNull EModelElement eModelElement) {
		EAnnotation oclAnnotation = removeDelegateAnnotations(eModelElement, exportDelegateURI);
		if (oclAnnotation == null) {
			oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			oclAnnotation.setSource(exportDelegateURI);
			eModelElement.getEAnnotations().add(oclAnnotation);
		}
		return oclAnnotation;
	}
	
	public @Nullable EAnnotation createConstraintDelegate(@NonNull EModelElement eModelElement, @NonNull Constraint pivotConstraint, @Nullable URI ecoreURI) {
		OpaqueExpression specification = pivotConstraint.getSpecification();
		if (specification == null) {
			return null;
		}
		String exprString = createExpression(specification, ecoreURI);
		if (exprString == null) {
			return null;
		}
		EAnnotation oclAnnotation = createAnnotation(eModelElement);
		String key = getAnnotationKey(pivotConstraint);
		oclAnnotation.getDetails().put(key, exprString);
		return oclAnnotation;
	}

	protected @Nullable String createExpression(@NonNull OpaqueExpression bodyExpression, @Nullable URI ecoreURI) {
		String exprString = PivotUtil.getBody(bodyExpression);
		if ((exprString == null) && (bodyExpression instanceof ExpressionInOCL)) {
			OCLExpression bodyExpression2 = ((ExpressionInOCL)bodyExpression).getBodyExpression();
			if (bodyExpression2 != null) {
				exprString = createExpression(bodyExpression2, ecoreURI);
			}
		}
		return exprString;
	}

	protected @Nullable String createExpression(@NonNull OCLExpression bodyExpression, @Nullable URI ecoreURI) {
		Namespace namespace = PivotUtil.getNamespace(bodyExpression);
		PrettyPrintOptions.Global options = PrettyPrinter.createOptions(namespace);
		options.setBaseURI(ecoreURI);
		return PrettyPrinter.print(bodyExpression, options);
	}
	
	public @Nullable EAnnotation createOperationDelegate(@NonNull EOperation eOperation, @NonNull OpaqueExpression bodyExpression, @Nullable URI ecoreURI) {
		String exprString = createExpression(bodyExpression, ecoreURI);
		if (exprString == null) {
			return null;
		}
		if (isBooleanInvariants(options)) {
			exprString = "result = (" + exprString + ")";
		}
		EAnnotation oclAnnotation = createAnnotation(eOperation);
		oclAnnotation.getDetails().put(InvocationBehavior.BODY_CONSTRAINT_KEY, exprString);
		return oclAnnotation;
	}
	
	public @Nullable EAnnotation createPropertyDelegate(@NonNull EStructuralFeature eStructuralFeature, @NonNull OpaqueExpression defaultExpression, @Nullable URI ecoreURI) {
		String exprString = createExpression(defaultExpression, ecoreURI);
		if (exprString == null) {
			return null;
		}
		EAnnotation oclAnnotation = createAnnotation(eStructuralFeature);
		oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		return oclAnnotation;
	}

	public @Nullable String getExportDelegateURI() {
		return exportDelegateURI;
	}

	public @NonNull MetaModelManager getMetaModelManager() {
		return metaModelManager;
	}

	/**
	 * Install all Constraints from pivotPackage and its nestedPackages as OCL Delegates.
	 */
	public void installDelegates(@NonNull PackageServer packageServer) {
		boolean hasDelegates = false;
//		for (Type aType : metaModelManager.getLocalClasses(pivotPackage)) {
		for (TypeServer typeServer : packageServer.getMemberTypes()) {
			if (installDelegates(typeServer.getPivotType())) {
				hasDelegates = true;
			}
		}
//		PackageServer packageServer = metaModelManager.getPackageServer(pivotPackage);
		EPackage ePackage = packageServer.getEPackage();
		if ((ePackage != null) && hasDelegates) {
			installDelegates(ePackage);
		}
		for (PackageServer nestedPackage : packageServer.getMemberPackages()) {
			if (nestedPackage != null) {
				installDelegates(nestedPackage);
			}
		}
	}

	/**
	 * Install all Constraints from pivotType and its operations as OCL Delegates. Returning true if any OCL Delegate installed.
	 * 
	 * @param metaModelManager
	 * @param pivotPackage
	 */
	private boolean installDelegates(@NonNull Type pivotType) {
		boolean hasDelegates = false;
		Type primaryType = metaModelManager.getPrimaryType(pivotType);
		EObject eTarget = primaryType.getETarget();
		if (eTarget instanceof EClassifier) {
			@NonNull EClassifier eClassifier = (EClassifier)eTarget;
			removeDelegateAnnotations(eClassifier, null);
			for (Constraint constraint : metaModelManager.getLocalInvariants(pivotType)) {
				if (constraint.isCallable()) {
					EOperation eContext = null;
					String name = constraint.getName();
					for (EOperation candidate : ((EClass) eClassifier).getEOperations()) {
						if (name.equals(candidate.getName()) && EcoreUtil.isInvariant(candidate)) {
							eContext = candidate;
							break;
						}
					}
					if (eContext == null) {
						@NonNull EOperation eOperation = Pivot2Ecore.createConstraintEOperation(constraint, name, null);
						((EClass) eClassifier).getEOperations().add(eOperation);
						eContext = eOperation;
					}
					EAnnotation oclAnnotation = createConstraintDelegate(eContext, constraint, null);
					if (oclAnnotation == null) {
						return false;
					}
					eContext.getEAnnotations().add(oclAnnotation);
					hasDelegates = true;
				}
				else {
					EAnnotation oclAnnotation = createConstraintDelegate(eClassifier, constraint, null);
					if (oclAnnotation == null) {
						return false;
					}
					eClassifier.getEAnnotations().add(oclAnnotation);
					hasDelegates = true;
				}
			}
			for (Operation anOperation : metaModelManager.getMemberOperations(pivotType, false)) {
				EOperation eOperation = (EOperation)anOperation.getETarget();
				if (eOperation != null) {
					installDelegate(eOperation);
				}
			}
			for (Operation anOperation : metaModelManager.getMemberOperations(pivotType, true)) {
				EOperation eOperation = (EOperation)anOperation.getETarget();
				if (eOperation != null) {
					installDelegate(eOperation);
				}
			}
			for (Property aProperty : metaModelManager.getMemberProperties(pivotType, false)) {
				EStructuralFeature eFeature = (EStructuralFeature)aProperty.getETarget();
				if (eFeature != null) {
					installDelegate(eFeature);
				}
			}
			for (Property aProperty : metaModelManager.getMemberProperties(pivotType, true)) {
				EStructuralFeature eFeature = (EStructuralFeature)aProperty.getETarget();
				if (eFeature != null) {
					installDelegate(eFeature);
				}
			}
			for (EAnnotation eAnnotation : eClassifier.getEAnnotations()) {		// Fix redefines/duplicates
				for (TreeIterator<EObject> tit = eAnnotation.eAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					if (eObject instanceof EAnnotation) {
						EAnnotation nestedAnnotation = (EAnnotation) eObject;
						if (UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI.equals(nestedAnnotation.getSource())) {
							nestedAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
						}
					}
				}
			}
			if (hasDelegates) {
				installDelegates(eClassifier, pivotType);
			}
		}
		return hasDelegates;
	}
	
	@Deprecated // Since Kepler use createConstraint/OperationDelegate
	public boolean installDelegate(@NonNull EModelElement eModelElement, @NonNull Constraint pivotConstraint, @Nullable URI ecoreURI) {
		OpaqueExpression specification = pivotConstraint.getSpecification();
		if (specification == null) {
			return false;
		}
		String exprString = PivotUtil.getBody(specification);
		Namespace namespace = PivotUtil.getNamespace(specification);
		PrettyPrintOptions.Global options = PrettyPrinter.createOptions(namespace);
		options.setBaseURI(ecoreURI);
		if ((exprString == null) && (specification instanceof ExpressionInOCL)) {
			exprString = PrettyPrinter.print(DomainUtil.nonNullModel(((ExpressionInOCL)specification).getBodyExpression()), options);
		}
		if (exprString == null) {
			return false;
		}
		EAnnotation oclAnnotation = removeDelegateAnnotations(eModelElement, exportDelegateURI);
		if (oclAnnotation == null) {
			oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			oclAnnotation.setSource(exportDelegateURI);
			eModelElement.getEAnnotations().add(oclAnnotation);
		}
//		String stereotype = pivotConstraint.getStereotype();
		String name = pivotConstraint.getName();
		EStructuralFeature eContainingFeature = pivotConstraint.eContainingFeature();
		if (eContainingFeature == PivotPackage.Literals.TYPE__OWNED_INVARIANT) {
			if (eModelElement instanceof EOperation) {
				oclAnnotation.getDetails().put("body", exprString);
			}
			else {
				oclAnnotation.getDetails().put(name, exprString);
			}
		}
		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__DEFAULT_EXPRESSION) {
			oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		}
//		else if (eContainingFeature == PivotPackage.Literals.PROPERTY__DERIVATION_EXPRESSION) {
//			oclAnnotation.getDetails().put(SettingBehavior.INITIAL_CONSTRAINT_KEY, exprString);
//		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__BODY_EXPRESSION) {
			String key = name != null ? "body_" + name : InvocationBehavior.BODY_CONSTRAINT_KEY;
			oclAnnotation.getDetails().put(key, exprString);
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__PRECONDITION) {
			oclAnnotation.getDetails().put("pre_" + name, exprString);
		}
		else if (eContainingFeature == PivotPackage.Literals.OPERATION__POSTCONDITION) {
			oclAnnotation.getDetails().put("post_" + name, exprString);
		}
		else {
//			error("Unsupported " + pivotConstraint);
		}
		return true;
	}

	public void installDelegate(@NonNull EOperation eOperation) {
		List<EAnnotation> eAnnotations = eOperation.getEAnnotations();
		EAnnotation oclAnnotation = eOperation.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
			oclAnnotation.setSource(exportDelegateURI);
			eAnnotations.add(oclAnnotation);
		}
	}

	public void installDelegate(@NonNull EStructuralFeature eFeature) {
		List<EAnnotation> eAnnotations = eFeature.getEAnnotations();
		EAnnotation oclAnnotation = eFeature.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (oclAnnotation != null) {
			eAnnotations.remove(oclAnnotation);
			oclAnnotation.setSource(exportDelegateURI);
			eAnnotations.add(oclAnnotation);
		}
	}
	
	public void installDelegates(@NonNull EClassifier eClassifier, @NonNull Type pivotType) {
		StringBuilder s = null;
		for (Constraint pivotConstraint : metaModelManager.getLocalInvariants(pivotType)) {
			String constraintName = pivotConstraint.getName();
			if (!pivotConstraint.isCallable() && (constraintName != null)) {
				if (s == null) {
					s = new StringBuilder();
				}
				else {
					s.append(" ");
				}
				s.append(constraintName);
			}
		}
		EAnnotation eAnnotation = eClassifier.getEAnnotation(EcorePackage.eNS_URI);
		if (s != null) {
			if (eAnnotation == null) {
				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(EcorePackage.eNS_URI);
				eClassifier.getEAnnotations().add(/*0,*/ eAnnotation);
			}
			eAnnotation.getDetails().put("constraints", s.toString());
		}
		else {
			eClassifier.getEAnnotations().remove(eAnnotation);
		}
	}

	public void installDelegates(@NonNull EPackage ePackage) {
		EAnnotation packageAnnotation = DomainUtil.getEAnnotation(ePackage, EcorePackage.eNS_URI);
		EMap<String, String> details = packageAnnotation.getDetails();
		details.put(InvocationBehavior.NAME, exportDelegateURI);
		if (!Boolean.valueOf(String.valueOf(options.get(OPTION_OMIT_SETTING_DELEGATES)))) {
			details.put(SettingBehavior.NAME, exportDelegateURI);
		}
		details.put(ValidationBehavior.NAME, exportDelegateURI);
	}
	
	@Deprecated // Since Kepler use createOperationDelegate
	public boolean installOperationDelegate(@NonNull EOperation eOperation, @NonNull OpaqueExpression bodyExpression, @Nullable URI ecoreURI) {
		EAnnotation oclAnnotation = createOperationDelegate(eOperation, bodyExpression, ecoreURI);
		return oclAnnotation != null;
	}
	
	@Deprecated // Since Kepler use createPropertyDelegate
	public boolean installPropertyDelegate(@NonNull EStructuralFeature eStructuralFeature, @NonNull OpaqueExpression defaultExpression, @Nullable URI ecoreURI) {
		EAnnotation oclAnnotation = createPropertyDelegate(eStructuralFeature, defaultExpression, ecoreURI);
		return oclAnnotation != null;
	}

	/**
	 * Remove all OCL Delegate annotations except that corresponding to exportDelegateURI which is returned.
	 */
	protected @Nullable EAnnotation removeDelegateAnnotations(@NonNull EModelElement eModelElement, @Nullable String exportDelegateURI) {
		List<EAnnotation> eAnnotations = eModelElement.getEAnnotations();
		EAnnotation oclAnnotation = null;
		EAnnotation annotation1 = eModelElement.getEAnnotation(OCLConstants.OCL_DELEGATE_URI);
		if (annotation1 != null) {
			if (OCLConstants.OCL_DELEGATE_URI.equals(exportDelegateURI)) {
				oclAnnotation = annotation1;
			}
			else {
				eAnnotations.remove(annotation1);
			}
		}
		EAnnotation annotation2 = eModelElement.getEAnnotation(OCLConstants.OCL_DELEGATE_URI_LPG);
		if (annotation2 != null) {
			if (OCLConstants.OCL_DELEGATE_URI_LPG.equals(exportDelegateURI)) {
				oclAnnotation = annotation2;
			}
			else {
				eAnnotations.remove(annotation2);
			}
		}
		EAnnotation annotation3 = eModelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		if (annotation3 != null) {
			if (OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT.equals(exportDelegateURI)) {
				oclAnnotation = annotation3;
			}
			else {
				eAnnotations.remove(annotation3);
			}
		}
		EAnnotation annotation4 = eModelElement.getEAnnotation(UML2GenModelUtil.UML2_GEN_MODEL_PACKAGE_1_1_NS_URI);
		if (annotation4 != null) {
			eAnnotations.remove(annotation4);
		}
		return oclAnnotation;
	}
}

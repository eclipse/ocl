/*******************************************************************************
 * Copyright (c) 2010, 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 * 	 E.D.Willink (CEA LIST) - Bug 425799 - validity view
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.values.InvalidValueException;


public class PivotUtil
{
	/**
	 * 'Highest' precedence first
	 */
	public static class PrecedenceComparator implements Comparator<Precedence>
	{
		public static final PrecedenceComparator INSTANCE = new PrecedenceComparator();
	
		@Override
		public int compare(Precedence p1, Precedence p2) {
			int o1 = p1 != null ? p1.getOrder().intValue() : -1;
			int o2 = p2 != null ? p2.getOrder().intValue() : -1;
			return o1 - o2; // NB least positive is highest precedence
		}
	}

	/**
	 * In TemplateSignature order.
	 */
	public static class TemplateParameterSubstitutionComparator
		implements Comparator<TemplateParameterSubstitution>
	{
		public static Comparator<? super TemplateParameterSubstitution> INSTANCE =
			new TemplateParameterSubstitutionComparator();
	
		@Override
		public int compare(TemplateParameterSubstitution o1, TemplateParameterSubstitution o2) {
			TemplateParameter f1 = o1.getFormal();
			TemplateParameter f2 = o2.getFormal();
			int i1 = f1.getOwningSignature().getOwnedParameters().indexOf(f1);
			int i2 = f2.getOwningSignature().getOwnedParameters().indexOf(f2);
			return i1 - i2;
		}
	}

	/**
	 * Check that expressionInOCL was successfully compiled. Throws an InvalidValueException explaining the problem
	 * if expressionInOCL has no contextVariable and has a StringLiteralExp bodyExpression.
	 */
	public static void checkExpression(@NonNull ExpressionInOCL expressionInOCL) {
		Variable contextVariable = expressionInOCL.getOwnedContext();
		if (contextVariable == null) {
			OCLExpression bodyExpression = expressionInOCL.getOwnedBody();
			if (bodyExpression instanceof StringLiteralExp) {
				throw new InvalidValueException(((StringLiteralExp)bodyExpression).getStringSymbol());
			}
		}
	}

	public static boolean conformsTo(@Nullable EClassifier targetType, @NonNull EClassifier contentType) {
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return ((EClass) targetType).isSuperTypeOf((EClass) contentType);
	}

	public static boolean conformsTo(@Nullable EStructuralFeature eStructuralFeature, @NonNull EClassifier contentType) {
		if (eStructuralFeature == null) {			// Wildcard match all
			return true;
		}
		EClassifier targetType = eStructuralFeature.getEType();
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return conformsTo(targetType, contentType);
	}

	public static String formatDiagnostics(@NonNull Diagnostic diagnostic, @NonNull String newLine) {
		StringBuilder s = new StringBuilder();
		formatDiagnostic(s, diagnostic, newLine);
		return s.toString();
	}

	public static void formatDiagnostic(@NonNull StringBuilder s, @NonNull Diagnostic diagnostic, @NonNull String newLine) {
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				s.append(newLine);
				s.append(diagnostic.getSeverity() + " - ");
				String location = diagnostic.getSource();
				if (location != null) {
					s.append(location);
					s.append(": ");
				}
				s.append(diagnostic.getMessage());
				for (Object obj : diagnostic.getData()) {
					s.append(newLine);
					s.append("\t");
	//				if (obj instanceof Throwable) {
	//					s.append(((Throwable)obj).getMessage());
	//				}
	//				else {
						s.append(obj);
	//				}
				}
				for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
					if (childDiagnostic != null) {
						formatDiagnostic(s, childDiagnostic, newLine + "\t");
					}
				}
			}
		}

	public static String formatResourceDiagnostics(@NonNull List<Resource.Diagnostic> diagnostics, @NonNull String messagePrefix, @NonNull String newLine) {
		if (diagnostics.size() <= 0) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		s.append(messagePrefix);
		for (Resource.Diagnostic diagnostic : diagnostics) {
			s.append(newLine);
			String location = diagnostic.getLocation();
			if (location != null) {
				s.append(location);
				s.append(":");
			}
			s.append(diagnostic.getLine());
			try {
				int column = diagnostic.getColumn();
				if (column >= 0) {
					s.append(":");
					s.append(column);
				}
			} catch (Exception e) {}	// UnsupportedOperationException is normal for Bug 380232
			s.append(": ");
			s.append(diagnostic.getMessage());
		}
		return s.toString();
	}

	public static @Nullable Constraint getContainingConstraint(@Nullable Element element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Constraint) {
				return (Constraint)eObject;
			}
		}
		return null;
	}

	public static @Nullable ExpressionInOCL getContainingExpressionInOCL(@Nullable Element element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ExpressionInOCL) {
				return (ExpressionInOCL)eObject;
			}
		}
		return null;
	}

	public static @Nullable Namespace getContainingNamespace(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Namespace) {
				return (Namespace)eObject;
			}
		}
		return null;
	}

	public static @Nullable org.eclipse.ocl.pivot.Package getContainingPackage(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				return (org.eclipse.ocl.pivot.Package)eObject;
			}
		}
		return null;
	}

	public static @Nullable Model getContainingRoot(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Model) {
				return (Model)eObject;
			}
		}
		return null;
	}

	public static @Nullable Type getContainingType(@Nullable EObject element) {
		if (element != null) {
			EObject eObject = element;
			while (true) {
				if (eObject instanceof Type) {
					return (Type)eObject;
				}
				EObject eContainer = eObject.eContainer();
				if (eContainer == null) {
					if (eObject instanceof ExpressionInOCL) {
						return ((ExpressionInOCL)eObject).getOwnedContext().getType();
					}
					break;
				}
				eObject = eContainer;
			}
		}
		return null;
	}

	public static @Nullable Namespace getNamespace(@Nullable EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Model) {
				return null;
			}
			if (eObject instanceof Type) {
				return (Namespace) eObject;
			}
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				return (Namespace) eObject;
			}
		}
		return null;
	}

	public static @Nullable org.eclipse.ocl.pivot.Package getPackage(@NonNull EObject object) {
		for (EObject eObject = object; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				return (org.eclipse.ocl.pivot.Package)eObject;
			}
		}
		return null;
	}

	public static Feature getReferredFeature(CallExp callExp) {
		Feature feature = null;
		if (callExp instanceof LoopExp) {
			feature = ((LoopExp)callExp).getReferredIteration();
		}
		else if (callExp instanceof OperationCallExp) {
			feature = ((OperationCallExp)callExp).getReferredOperation();
		}
		else if (callExp instanceof OppositePropertyCallExp) {
			Property referredOppositeProperty = ((OppositePropertyCallExp)callExp).getReferredProperty();
			feature = referredOppositeProperty != null ? referredOppositeProperty.getOpposite() : null;
		}
		else if (callExp instanceof PropertyCallExp) {
			feature = ((PropertyCallExp)callExp).getReferredProperty();
		}
		return feature;
	}

	public static Operation getReferredOperation(CallExp callExp) {
		Operation operation = null;
		if (callExp instanceof LoopExp) {
			operation = ((LoopExp)callExp).getReferredIteration();
		}
		else if (callExp instanceof OperationCallExp) {
			operation = ((OperationCallExp)callExp).getReferredOperation();
		}
		return operation;
	}

	public static @NonNull <T extends TemplateableElement> T getUnspecializedTemplateableElement(@NonNull T templateableElement) {
	//		if (templateableElement == null) {
	//			return null;
	//		}
			TemplateableElement unspecializedElement = templateableElement.getUnspecializedElement();
			if (unspecializedElement == null) {
				return templateableElement;
			}
			@SuppressWarnings("unchecked")
			T castUnspecializedElement = (T) unspecializedElement;
			return castUnspecializedElement;
		}
}

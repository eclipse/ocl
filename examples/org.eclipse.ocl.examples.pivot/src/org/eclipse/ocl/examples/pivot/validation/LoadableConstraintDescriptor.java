/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.validation;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A LoadableConstraintDescriptor realizes both an IConstraintDescriptor and IModelConstraint
 * to support a Constraint derived from loading some model source. The resulting desciptor
 * is suitable for use with the EMF.Valitation framework.
 */
public abstract class LoadableConstraintDescriptor<T> extends AbstractConstraintDescriptor implements IModelConstraint
{
	public static class Ecore extends LoadableConstraintDescriptor<EClassifier>
	{
		public Ecore(@NonNull EClassifier targetType, @NonNull Constraint constraint, int code) {
			super(targetType, constraint, targetType.getEPackage().getNsURI(), targetType.getName(), code);
		}

		public boolean targetsTypeOf(EObject eObject) {
			return targetType.isInstance(eObject);
		}
	}
	
	public static class UML extends LoadableConstraintDescriptor<Stereotype>
	{
		public UML(@NonNull Stereotype targetType, @NonNull Constraint constraint, int code) {
			super(targetType, constraint, targetType.getNearestPackage().getURI(), targetType.getName(), code);
		}

		protected boolean isKindOf(@NonNull String nsURI, @NonNull String name, EClass eClass) {
			if (name.equals(eClass.getName())) {
				EPackage ePackage = eClass.getEPackage();
				if (nsURI.equals(ePackage.getNsURI())) {
					return true;
				}
			}
			for (EClass eSuperClass : eClass.getESuperTypes()) {
				if (isKindOf(nsURI, name, eSuperClass)) {
					return true;
				}
			}
			return false;
		}

		public boolean targetsTypeOf(EObject eObject) {
			EClass eClass = eObject.eClass();
			String nsURI = targetType.getProfile().getURI();
			if (nsURI == null) {
				return false;
			}
			String name = targetType.getName();
			if (name == null) {
				return false;
			}
			return isKindOf(nsURI, name, eClass);
		}
	}
	
	private static final Logger logger = Logger.getLogger(LoadableConstraintDescriptor.class);
	
	private final @NonNull Constraint constraint;
	protected final @NonNull T targetType;
	private final @NonNull String id;
	private final @NonNull String name;
	private final int code;
	private ExpressionInOCL query = null;
	
	public LoadableConstraintDescriptor(@NonNull T targetType, @NonNull Constraint constraint,
			String targetNamespace, String targetName, int code) {
		this.constraint = constraint;
		this.targetType = targetType;
		String name = constraint.getName();
		if (name == null) {
			name = Long.toHexString(System.identityHashCode(constraint));
		}
		
		id = "'" + targetNamespace + "'::" + targetName + "::" + name;
		this.name = targetName + "::" + name;
		this.code = code;
	}
	
	final Constraint getConstraint() {
		return constraint;
	}
	
	public String getBody() {
		return PrettyPrinter.print(constraint);
	}

	public String getDescription() {
		return getBody();
	}

	public EvaluationMode<?> getEvaluationMode() {
		return EvaluationMode.BATCH;
	}

	public String getId() {
		return id;
	}

	public String getMessagePattern() {
		return String.format("Constraint %s violated on {0}", getName()); //$NON-NLS-1$
	}

	public String getName() {
		return name;
	}

	public String getPluginId() {
		return PivotPlugin.getPluginId();
	}

	public ConstraintSeverity getSeverity() {
		return ConstraintSeverity.WARNING;
	}

	public int getStatusCode() {
		return code;
	}

	public boolean targetsEvent(Notification notification) {
		return false;
	}

	public IStatus validate(IValidationContext ctx) {
		EObject target = ctx.getTarget();
		if (target == null) {
			return ctx.createFailureStatus(target);
		}
		OCL ocl = LoadableConstraintProvider.getOCL();
		ExpressionInOCL query2 = query;
		if (query2 == null) {
			MetaModelManager metaModelManager = ocl.getMetaModelManager();
			EClass eClass = target.eClass();
			NamedElement contextElement = null;
			try {
				contextElement = metaModelManager.getPivotOf(NamedElement.class, eClass);
			} catch (ParserException e) {
				logger.error("Failed to convert " + eClass, e);
			}
			if (contextElement == null) {
				return ctx.createFailureStatus(target);
			}
			OpaqueExpression specification = constraint.getSpecification();
			if (specification == null) {
				return ctx.createFailureStatus(target);
			}
			query = query2 = specification.getExpressionInOCL();
			if (query2 == null) {
				return ctx.createFailureStatus(target);
			}
		}
		Object result = ocl.evaluate(target, query2);
		if (result != Boolean.TRUE) {
			return ctx.createFailureStatus(target);
		}
		return ctx.createSuccessStatus();
	}
}

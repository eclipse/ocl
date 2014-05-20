/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.osgi.util.NLS;

/**
 */
public class ValidationBehavior extends AbstractDelegatedBehavior<EClassifier, EValidator.ValidationDelegate.Registry, ValidationDelegate.Factory>
{
	public static final @NonNull ValidationBehavior INSTANCE = new ValidationBehavior();
	public static final @NonNull String NAME = "validationDelegates"; //$NON-NLS-1$
	
	public Constraint getConstraint(@NonNull MetaModelManager metaModelManager, @NonNull EClassifier eClassifier, @NonNull String constraintName) throws OCLDelegateException {
		Resource ecoreMetaModel = DomainUtil.nonNullEMF(eClassifier.eResource());
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreMetaModel, metaModelManager);
		Type type = ecore2Pivot.getCreated(Type.class, eClassifier);
		if (type != null) {
			Constraint constraint = DomainUtil.getNamedElement(metaModelManager.getAllInvariants(type), constraintName);
			if (constraint != null) {
				return constraint;
			}
		}
		String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
		throw new OCLDelegateException(new SemanticException(message));
	}

	public @Nullable ValidationDelegate.Factory getDefaultFactory() {
		return (ValidationDelegate.Factory) ValidationDelegate.Factory.Registry.INSTANCE.getValidationDelegate(getName());
	}

	public @NonNull EValidator.ValidationDelegate.Registry getDefaultRegistry() {
		return DomainUtil.nonNullEMF(ValidationDelegate.Factory.Registry.INSTANCE);
	}

	public @NonNull EPackage getEPackage(@NonNull EClassifier eClassifier) {
		return DomainUtil.nonNullEMF(eClassifier.getEPackage());
	}
	
/*	public ExpressionInOCL getExpressionInOCL(MetaModelManager metaModelManager, EClassifier eClassifier, String constraintName) throws OCLDelegateException {
		Resource ecoreMetaModel = eClassifier.eResource();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreMetaModel, metaModelManager);
		Type type = ecore2Pivot.getCreated(Type.class, eClassifier);
		Constraint constraint = PivotUtil.getNamedElement(type.getOwnedRule(), constraintName);
		if (constraint != null) {
			ExpressionInOCL expressionInOCL = getExpressionInOCL(metaModelManager, type, constraint);
			if (expressionInOCL != null) {
				return expressionInOCL;
			}
		}
		String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
		throw new OCLDelegateException(message);
	} */

	@Override
	public @Nullable ValidationDelegate.Factory getFactory(@NonNull DelegateDomain delegateDomain, @NonNull EClassifier eClassifier) {
		EValidator.ValidationDelegate.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eClassifier, ValidationDelegate.Registry.class, getDefaultRegistry());
		if (registry == null) {
			return null;
		}
	    String delegateURI = delegateDomain.getURI();
	    org.eclipse.emf.ecore.EValidator.ValidationDelegate validationDelegate = registry.getValidationDelegate(delegateURI);
		return (ValidationDelegate.Factory) validationDelegate;
	}

	public @NonNull Class<ValidationDelegate.Factory> getFactoryClass() {
		return ValidationDelegate.Factory.class;
	}

	public @NonNull String getName() {
		return NAME;
	}

	public @NonNull Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}
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
package org.eclipse.ocl.pivot.delegate;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.PivotConstantsInternal;
import org.eclipse.ocl.pivot.SemanticException;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ecore.Ecore2AS;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;

/**
 */
public class ValidationBehavior extends AbstractDelegatedBehavior<EClassifier, EValidator.ValidationDelegate.Registry, ValidationDelegate.Factory>
{
	public static final @NonNull ValidationBehavior INSTANCE = new ValidationBehavior();
	public static final @NonNull String NAME = "validationDelegates"; //$NON-NLS-1$
	
	public Constraint getConstraint(@NonNull MetaModelManager metaModelManager, @NonNull EClassifier eClassifier, @NonNull String constraintName) throws OCLDelegateException {
		Resource ecoreMetaModel = ClassUtil.nonNullEMF(eClassifier.eResource());
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreMetaModel, metaModelManager);
		Type type = ecore2as.getCreated(Type.class, eClassifier);
		if (type != null) {
			Constraint constraint = NameUtil.getNameable(metaModelManager.getAllInvariants(type), constraintName);
			if (constraint != null) {
				return constraint;
			}
		}
		throw new OCLDelegateException(new SemanticException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, type, PivotConstantsInternal.OWNED_CONSTRAINT_ROLE));
	}

	@Override
	public @Nullable ValidationDelegate.Factory getDefaultFactory() {
		return (ValidationDelegate.Factory) ValidationDelegate.Factory.Registry.INSTANCE.getValidationDelegate(getName());
	}

	@Override
	public @NonNull EValidator.ValidationDelegate.Registry getDefaultRegistry() {
		return ClassUtil.nonNullEMF(ValidationDelegate.Factory.Registry.INSTANCE);
	}

	@Override
	public @NonNull EPackage getEPackage(@NonNull EClassifier eClassifier) {
		return ClassUtil.nonNullEMF(eClassifier.getEPackage());
	}
	
/*	public ExpressionInOCL getExpressionInOCL(MetaModelManager metaModelManager, EClassifier eClassifier, String constraintName) throws OCLDelegateException {
		Resource ecoreMetaModel = eClassifier.eResource();
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreMetaModel, metaModelManager);
		Type type = ecore2as.getCreated(Type.class, eClassifier);
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

	@Override
	public @NonNull Class<ValidationDelegate.Factory> getFactoryClass() {
		return ValidationDelegate.Factory.class;
	}

	@Override
	public @NonNull String getName() {
		return NAME;
	}

	/**
	 * Return the operation body associated with operation, if necessary using
	 * <code>ocl</code> to create the relevant parsing environment for a textual
	 * definition.
	 * @throws OCLDelegateException 
	 */
	public @NonNull ExpressionInOCL getQueryOrThrow(@NonNull MetaModelManager metaModelManager, @NonNull Constraint constraint) throws OCLDelegateException {
		LanguageExpression specification = constraint.getOwnedSpecification();
		if (specification == null) {
			throw new OCLDelegateException(new SemanticException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, constraint, PivotConstantsInternal.OWNED_CONSTRAINT_ROLE));
		}
		try {
			return metaModelManager.getQueryOrThrow(specification);
		} catch (ParserException e) {
			throw new OCLDelegateException(e);
		}
	}

	@Override
	public @NonNull Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}
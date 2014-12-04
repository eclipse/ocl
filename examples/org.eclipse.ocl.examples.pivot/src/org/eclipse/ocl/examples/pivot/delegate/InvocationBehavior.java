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

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.common.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LanguageExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.PivotConstants;
import org.eclipse.ocl.examples.pivot.SemanticException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;

/**
 */
public class InvocationBehavior extends AbstractDelegatedBehavior<EOperation, InvocationDelegate.Factory.Registry, InvocationDelegate.Factory>
{
	public static final @NonNull InvocationBehavior INSTANCE = new InvocationBehavior();
	public static final @NonNull String BODY_CONSTRAINT_KEY = "body"; //$NON-NLS-1$
	public static final @NonNull String NAME = "invocationDelegates"; //$NON-NLS-1$

//	public boolean appliesTo(EOperation operation) {
//      	String annotation = EcoreUtil.getAnnotation(operation, OCLDelegateDomain.OCL_DELEGATE_URI, BODY_CONSTRAINT_KEY);
//		return annotation != null;
//	}

	@Override
	public @Nullable InvocationDelegate.Factory getDefaultFactory() {
		return InvocationDelegate.Factory.Registry.INSTANCE.getFactory(getName());
	}

	@Override
	public @NonNull InvocationDelegate.Factory.Registry getDefaultRegistry() {
		return DomainUtil.nonNullEMF(InvocationDelegate.Factory.Registry.INSTANCE);
	}

	@Override
	public @NonNull EPackage getEPackage(@NonNull EOperation eOperation) {
		return DomainUtil.nonNullEMF(eOperation.getEContainingClass().getEPackage());
	}

	@Override
	public @Nullable InvocationDelegate.Factory getFactory(@NonNull DelegateDomain delegateDomain, @NonNull EOperation eOperation) {
		InvocationDelegate.Factory.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eOperation, getRegistryClass(), getDefaultRegistry());
	    return registry != null ? registry.getFactory(delegateDomain.getURI()) : null;
	}

	@Override
	public @NonNull Class<InvocationDelegate.Factory> getFactoryClass() {
		return InvocationDelegate.Factory.class;
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
	public @NonNull ExpressionInOCL getQueryOrThrow(@NonNull MetaModelManager metaModelManager, @NonNull Operation operation) throws OCLDelegateException {
		LanguageExpression specification = operation.getBodyExpression();
		if (specification == null) {
			throw new OCLDelegateException(new SemanticException(OCLMessages.MissingSpecificationBody_ERROR_, EcoreUtils.qualifiedNameFor(operation), PivotConstants.BODY_EXPRESSION_ROLE));
		}
		try {
			return metaModelManager.getQueryOrThrow(specification);
		} catch (ParserException e) {
			throw new OCLDelegateException(e);
		}
	}

	@Override
	public @NonNull Class<InvocationDelegate.Factory.Registry> getRegistryClass() {
		return InvocationDelegate.Factory.Registry.class;
	}
}
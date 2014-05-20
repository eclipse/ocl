/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * Factory for OCL operation-invocation delegates.
 */
public class OCLInvocationDelegateFactory extends AbstractOCLDelegateFactory
		implements EOperation.Internal.InvocationDelegate.Factory
{
	public OCLInvocationDelegateFactory(@NonNull String delegateURI) {
		super(delegateURI);
	}

	public @Nullable EOperation.Internal.InvocationDelegate createInvocationDelegate(EOperation operation) {
		if (operation == null) {
			return null;
		}
		EPackage ePackage = DomainUtil.nonNullEMF(operation.getEContainingClass().getEPackage());
		OCLDelegateDomain delegateDomain = getDelegateDomain(ePackage);
		return delegateDomain != null ? new OCLInvocationDelegate(delegateDomain, operation) : null;
	}
	
	/**
	 * The Global variant of the Factory delegates to a local ResourceSet factory if one
	 * can be located at the EOperation.Internal.InvocationDelegate.Factory.Registry
	 * by the DelegateResourceSetAdapter.
	 */
	public static class Global extends OCLInvocationDelegateFactory
	{
		public Global() {
			super(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		}

		@Override
		public @Nullable EOperation.Internal.InvocationDelegate createInvocationDelegate(EOperation operation) {
			if (operation == null) {
				return null;
			}
			EOperation.Internal.InvocationDelegate.Factory.Registry localRegistry = DelegateResourceSetAdapter.getRegistry(
				operation, EOperation.Internal.InvocationDelegate.Factory.Registry.class, null);
			if (localRegistry != null) {
				EOperation.Internal.InvocationDelegate.Factory factory = localRegistry.getFactory(delegateURI);
				if (factory != null) {
					return factory.createInvocationDelegate(operation);
				}
			}
			return super.createInvocationDelegate(operation);
		}	
	}
}

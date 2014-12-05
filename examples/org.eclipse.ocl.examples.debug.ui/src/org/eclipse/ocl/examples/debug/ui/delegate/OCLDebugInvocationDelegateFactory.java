/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.ui.delegate;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.domain.utilities.DomainUtil;
import org.eclipse.ocl.pivot.delegate.AbstractOCLDelegateFactory;
import org.eclipse.ocl.pivot.delegate.OCLDelegateDomain;

/**
 * Factory for OCL operation-invocation delegates.
 */
public class OCLDebugInvocationDelegateFactory extends AbstractOCLDelegateFactory
		implements EOperation.Internal.InvocationDelegate.Factory
{
	public OCLDebugInvocationDelegateFactory(@NonNull String delegateURI) {
		super(delegateURI);
	}

	public @Nullable EOperation.Internal.InvocationDelegate createInvocationDelegate(EOperation operation) {
		if (operation == null) {
			return null;
		}
		EPackage ePackage = DomainUtil.nonNullEMF(operation.getEContainingClass().getEPackage());
		OCLDelegateDomain delegateDomain = getDelegateDomain(ePackage);
		return delegateDomain != null ? new OCLDebugInvocationDelegate(delegateDomain, operation) : null;
	}
	
	/**
	 * The Global variant of the Factory delegates to a local ResourceSet factory if one
	 * can be located at the EOperation.Internal.InvocationDelegate.Factory.Registry
	 * by the DelegateResourceSetAdapter.
	 */
	public static class Global extends OCLDebugInvocationDelegateFactory
	{
		public Global() {
			super(OCLDelegateDomain.OCL_DELEGATE_URI_DEBUG);
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

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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

/**
 * Factory for OCL derived-attribute setting delegates.
 */
public class OCLSettingDelegateFactory extends AbstractOCLDelegateFactory
		implements EStructuralFeature.Internal.SettingDelegate.Factory
{
	public OCLSettingDelegateFactory(@NonNull String delegateURI) {
		super(delegateURI);
	}

	public @Nullable EStructuralFeature.Internal.SettingDelegate createSettingDelegate(EStructuralFeature structuralFeature) {
		if (structuralFeature == null) {
			return null;
		}
		EPackage ePackage = structuralFeature.getEContainingClass().getEPackage();
		OCLDelegateDomain delegateDomain = getDelegateDomain(DomainUtil.nonNullEMF(ePackage));
		if (delegateDomain == null) {
			return null;
		}
		return new OCLSettingDelegate(delegateDomain, structuralFeature);
	}
	
	/**
	 * The Global variant of the Factory delegates to a local ResourceSet factory if one
	 * can be located at the EStructuralFeature.Internal.SettingDelegate.Factory.Registry
	 * by the DelegateResourceSetAdapter.
	 */
	public static class Global extends OCLSettingDelegateFactory
	{
		public Global() {
			super(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		}

		@Override
		public @Nullable EStructuralFeature.Internal.SettingDelegate createSettingDelegate(EStructuralFeature structuralFeature) {
			if (structuralFeature == null) {
				return null;
			}
			EStructuralFeature.Internal.SettingDelegate.Factory.Registry localRegistry = DelegateResourceSetAdapter.getRegistry(
				structuralFeature, EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, null);
			if (localRegistry != null) {
				EStructuralFeature.Internal.SettingDelegate.Factory factory = localRegistry.getFactory(delegateURI);
				if (factory != null) {
					return factory.createSettingDelegate(structuralFeature);
				}
			}
			return super.createSettingDelegate(structuralFeature);
		}	
	}
}

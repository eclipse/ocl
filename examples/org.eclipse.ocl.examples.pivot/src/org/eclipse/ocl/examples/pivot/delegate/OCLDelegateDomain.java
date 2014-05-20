/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.ValidationDelegateRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.common.delegate.VirtualDelegateMapping;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.examples.domain.validation.DomainSubstitutionLabelProvider;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerListener;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;

/**
 * An implementation of a delegate domain for an OCL enhanced package. The domain
 * maintains an OCL facade to be shared by all delegates within the package.
 */
public class OCLDelegateDomain implements DelegateDomain, MetaModelManagerListener
{
	protected static class PivotOnlyRegistry extends ValidationDelegateRegistryImpl
	{
		private static final long serialVersionUID = 1L;

		public static final @NonNull PivotOnlyRegistry INSTANCE = new PivotOnlyRegistry();

		@Override
		public ValidationDelegate getValidationDelegate(String uri) {
			return OCLValidationDelegateFactory.Global.INSTANCE;
		}
	}
	
	protected static class PivotOnlyVirtualDelegateMapping extends VirtualDelegateMapping
	{
		public static final @NonNull PivotOnlyVirtualDelegateMapping INSTANCE = new PivotOnlyVirtualDelegateMapping();

		protected PivotOnlyVirtualDelegateMapping() {
			super("x", "y", "z");
		}

		@Override
		public @Nullable String getDefaultValue() {
			return OCL_DELEGATE_URI_PIVOT;
		}

		@Override
		public @Nullable String getPreferredValue() {
			return OCL_DELEGATE_URI_PIVOT;
		}
	}

	/**
	 * The delegate URI for Ecore annotations using the Pivot evaluator.
	 */
	public static final @NonNull String OCL_DELEGATE_URI_PIVOT = OCLConstants.OCL_DELEGATE_URI_SLASH + "Pivot"; //$NON-NLS-1$
	
	/**
	 * Initialize the resourceSet registries, if non-null, or the global registries, if null,
	 * to support usage of the Pivot OCL Delegate Evaluator for the Pivot OCL Delegate URI. 
	 */
	public static void initialize(@Nullable ResourceSet resourceSet) {
		initialize(resourceSet, OCL_DELEGATE_URI_PIVOT);
	}
	
	/**
	 * Initialize the resourceSet registries, if non-null, or the global registries, if null,
	 * to support usage of the Pivot OCL Delegate Evaluator for the oclDelegateURI. 
	 */
	public static void initialize(@Nullable ResourceSet resourceSet, @NonNull String oclDelegateURI) {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {		// Install the 'plugin' registrations
			EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI, new OCLInvocationDelegateFactory.Global());
			EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI, new OCLSettingDelegateFactory.Global());
			EValidator.ValidationDelegate.Registry.INSTANCE.put(oclDelegateURI, new OCLValidationDelegateFactory.Global());
			QueryDelegate.Factory.Registry.INSTANCE.put(oclDelegateURI, new OCLQueryDelegateFactory.Global());
		}
		if (resourceSet != null) {
			// Install a DelegateResourceSetAdapter to supervise local registries and resource post-loading
			DelegateResourceSetAdapter adapter = DelegateResourceSetAdapter.getAdapter(resourceSet);
			VirtualDelegateMapping delegationMode = CommonOptions.DEFAULT_DELEGATION_MODE;
			adapter.putRegistry(VirtualDelegateMapping.class, new VirtualDelegateMapping(delegationMode.getPluginId(), delegationMode.getKey(), delegationMode.getPreferredValue()));
	
			// Install a local DelegateDomain.Factory
			DelegateDomain.Factory.Registry.Impl delegateDomainFactory = new DelegateDomain.Factory.Registry.Impl();
			delegateDomainFactory.put(oclDelegateURI, new OCLDelegateDomainFactory());
			adapter.putRegistry(DelegateDomain.Factory.Registry.class, delegateDomainFactory);
					
			// Install a local ValidationDelegate.Factory
			ValidationDelegate.Factory.Registry validationDelegateFactoryRegistry = new ValidationDelegate.Factory.Registry.Impl();
			validationDelegateFactoryRegistry.put(oclDelegateURI, new OCLValidationDelegateFactory(oclDelegateURI));
			adapter.putRegistry(ValidationDelegate.Factory.Registry.class, validationDelegateFactoryRegistry);
	
			// Install a local SettingDelegate.Factory
			EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingDelegateFactoryRegistry = new EStructuralFeature.Internal.SettingDelegate.Factory.Registry.Impl();
			settingDelegateFactoryRegistry.put(oclDelegateURI, new OCLSettingDelegateFactory(oclDelegateURI));
			adapter.putRegistry(EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, settingDelegateFactoryRegistry);
	
			// Install a local InvocationDelegate.Factory
			EOperation.Internal.InvocationDelegate.Factory.Registry invocationDelegateFactoryRegistry = new EOperation.Internal.InvocationDelegate.Factory.Registry.Impl();
			invocationDelegateFactoryRegistry.put(oclDelegateURI, new OCLInvocationDelegateFactory(oclDelegateURI));
			adapter.putRegistry(EOperation.Internal.InvocationDelegate.Factory.Registry.class, invocationDelegateFactoryRegistry);	
	
			// Install a local QueryDelegate.Factory
			QueryDelegate.Factory.Registry queryDelegateFactoryRegistry = new QueryDelegate.Factory.Registry.Impl();
			queryDelegateFactoryRegistry.put(oclDelegateURI, new OCLQueryDelegateFactory(oclDelegateURI));
			adapter.putRegistry(QueryDelegate.Factory.Registry.class, queryDelegateFactoryRegistry);
		}
	}

	public static void initializePivotOnlyDiagnosticianContext(@NonNull Map<Object, Object> context) {
		context.put(org.eclipse.emf.ecore.EValidator.ValidationDelegate.Registry.class, PivotOnlyRegistry.INSTANCE);
		context.put(EValidator.SubstitutionLabelProvider.class, DomainSubstitutionLabelProvider.INSTANCE);
	}

	public static void initializePivotOnlyDiagnosticianResourceSet(@NonNull ResourceSet resourceSet) {
		DelegateResourceSetAdapter adapter = DelegateResourceSetAdapter.getAdapter(resourceSet);
		adapter.putRegistry(org.eclipse.ocl.examples.pivot.delegate.ValidationDelegate.Registry.class, PivotOnlyRegistry.INSTANCE);
		adapter.putRegistry(VirtualDelegateMapping.class, PivotOnlyVirtualDelegateMapping.INSTANCE);
	}

	protected final @NonNull String uri;
	protected final @NonNull EPackage ePackage;
	protected OCL ocl = null;				// Lazily initialized and re-initialized
	// FIXME Introduce a lightweight function (? a lambda function) to avoid the need for a CompleteEnvironment for queries
//	private Map<CompletePackage, org.eclipse.ocl.examples.pivot.Package> queryPackages = null;
//	private Map<CompleteType, org.eclipse.ocl.examples.pivot.Class> queryTypes = null;
	
	/**
	 * Initializes me with my delegate URI and package.
	 * 
	 * @param delegateURI
	 *            the delegate namespace I handle
	 * @param ePackage
	 *            the package that I handle
	 * 
	 * @throws ParserException
	 *             if the operation's OCL body expression is invalid
	 */
	public OCLDelegateDomain(@NonNull String delegateURI, @NonNull EPackage ePackage) {
		this.uri = delegateURI;
		this.ePackage = ePackage;
	}

	private @NonNull PivotEnvironmentFactory getEnvironmentFactory() {
		Resource res = ePackage.eResource();
		PivotEnvironmentFactory envFactory = null;
		if (res != null) {
			MetaModelManager metaModelManager = null;
			ResourceSet resourceSet = res.getResourceSet();
			if (resourceSet != null) {
				MetaModelManagerResourceSetAdapter rsAdapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
				if (rsAdapter != null) {
					metaModelManager = rsAdapter.getMetaModelManager();
				}
				// it's a dynamic package. Use the local package registry
				EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
				envFactory = new PivotEnvironmentFactory(packageRegistry, metaModelManager);
				DelegateResourceAdapter.getAdapter(res);
			}
		}
		if (envFactory == null) {
			// the shared instance uses the static package registry
			envFactory = PivotEnvironmentFactory.getGlobalRegistryInstance();
		}
		return envFactory;
	}

	public final @NonNull MetaModelManager getMetaModelManager() {
		return getOCL().getMetaModelManager();
	}

	public @NonNull OCL getOCL() {
		OCL ocl2 = ocl;
		if (ocl2 == null) {
			// Delegates are an application-independent extension of EMF
			//  so we must use the neutral/global context see Bug 338501
			ocl2 = ocl = OCL.newInstance(getEnvironmentFactory());
			ocl2.getMetaModelManager().addListener(this);
		}
		return ocl2;
	}
	
	public <T extends Element> T getPivot(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		MetaModelManager metaModelManager = getOCL().getMetaModelManager();
		try {
			return metaModelManager.getPivotOf(requiredClass, eObject);
		} catch (ParserException e) {
			return null;
		}
	}
	
	public final @NonNull String getURI() {
		return uri;
	}

	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		reset();
	}

	public void reset() {
		if (ocl != null) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				List<Adapter> eClassifierAdapters = eClassifier.eAdapters();
				for (Adapter adapter : eClassifierAdapters) {
					if (adapter instanceof DelegateEClassifierAdapter) {
						eClassifierAdapters.remove(adapter);
						break;
					}
				}
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					for (EOperation eOperation : eClass.getEOperations()) {
						((EOperation.Internal) eOperation).setInvocationDelegate(null);
					}
					for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
						((EStructuralFeature.Internal) eStructuralFeature).setSettingDelegate(null);
					}
				}
			}
			ocl.dispose();
			ocl = null;
		}
	}

	@Override
	public String toString() {
		return ePackage.getName() + " : " + getURI(); //$NON-NLS-1$
	}
}

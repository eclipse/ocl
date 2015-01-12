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
package org.eclipse.ocl.pivot.internal.delegate;

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
import org.eclipse.ocl.common.delegate.DelegateResourceSetAdapter;
import org.eclipse.ocl.common.delegate.VirtualDelegateMapping;
import org.eclipse.ocl.common.internal.options.CommonOptions;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnvironmentFactory;
import org.eclipse.ocl.pivot.ParserException;
import org.eclipse.ocl.pivot.internal.manager.EnvironmentFactoryResourceSetAdapter;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * An implementation of a delegate domain for an OCL enhanced package. The domain
 * maintains an OCL facade to be shared by all delegates within the package.
 */
public class OCLDelegateDomain implements DelegateDomain, EnvironmentFactory.Listener
{
	public static class FactoryFactory
	{
		public static final @NonNull FactoryFactory INSTANCE = new FactoryFactory();

		public @NonNull OCLDelegateDomainFactory createDelegateDomainFactory() {
			return new OCLDelegateDomainFactory();
		}

		public @NonNull OCLInvocationDelegateFactory createInvocationDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLInvocationDelegateFactory(oclDelegateURI);
		}

		public @NonNull OCLQueryDelegateFactory createQueryDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLQueryDelegateFactory(oclDelegateURI);
		}

		public @NonNull OCLSettingDelegateFactory createSettingDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLSettingDelegateFactory(oclDelegateURI);
		}

		public @NonNull OCLValidationDelegateFactory createValidationDelegateFactory(@NonNull String oclDelegateURI) {
			return new OCLValidationDelegateFactory(oclDelegateURI);
		}
	}
	
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
			return PivotConstants.OCL_DELEGATE_URI_PIVOT;
		}

		@Override
		public @Nullable String getPreferredValue() {
			return PivotConstants.OCL_DELEGATE_URI_PIVOT;
		}
	}

	/**
	 * Initialize the resourceSet registries, if non-null, or the global registries, if null,
	 * to support usage of the Pivot OCL Delegate Evaluator for the Pivot OCL Delegate URI. 
	 */
	public static void initialize(@Nullable ResourceSet resourceSet) {
		initialize(resourceSet, PivotConstants.OCL_DELEGATE_URI_PIVOT);
	}
	
	/**
	 * Initialize the resourceSet registries, if non-null, or the global registries, if null,
	 * to support usage of the Pivot OCL Delegate Evaluator for the oclDelegateURI. 
	 */
	public static void initialize(@Nullable ResourceSet resourceSet, @NonNull String oclDelegateURI) {
		lazyInitializeGlobals(oclDelegateURI, true);
		if (resourceSet != null) {
			lazyInitializeLocals(resourceSet, oclDelegateURI, true, null);
		}
	}

	public static void initializePivotOnlyDiagnosticianContext(@NonNull Map<Object, Object> context) {
		context.put(org.eclipse.emf.ecore.EValidator.ValidationDelegate.Registry.class, PivotOnlyRegistry.INSTANCE);
		context.put(EValidator.SubstitutionLabelProvider.class, LabelUtil.SUBSTITUTION_LABEL_PROVIDER);
	}

	public static void initializePivotOnlyDiagnosticianResourceSet(@NonNull ResourceSet resourceSet) {
		DelegateResourceSetAdapter adapter = DelegateResourceSetAdapter.getAdapter(resourceSet);
		adapter.putRegistry(org.eclipse.ocl.pivot.internal.delegate.ValidationDelegate.Registry.class, PivotOnlyRegistry.INSTANCE);
		adapter.putRegistry(VirtualDelegateMapping.class, PivotOnlyVirtualDelegateMapping.INSTANCE);
	}

	/**
	 * Initialize the local resourceSet delegate registries to support the oclDelegateURI.
	 * A non-null delegateFactoryFactory may be specified for test purposes to intercept factory creation.
	 */
	public static void lazyInitializeLocals(@NonNull ResourceSet resourceSet, @NonNull String oclDelegateURI, boolean forceInitialization,
			@Nullable FactoryFactory delegateFactoryFactory) {
		if (delegateFactoryFactory == null) {
			delegateFactoryFactory = FactoryFactory.INSTANCE;
		}
		// Install a DelegateResourceSetAdapter to supervise local registries and resource post-loading
		DelegateResourceSetAdapter adapter = DelegateResourceSetAdapter.getAdapter(resourceSet);
		VirtualDelegateMapping delegationMode = CommonOptions.DEFAULT_DELEGATION_MODE;
		if (forceInitialization || (adapter.getRegistry(VirtualDelegateMapping.class) == null)) {
			adapter.putRegistry(VirtualDelegateMapping.class, new VirtualDelegateMapping(delegationMode.getPluginId(), delegationMode.getKey(), delegationMode.getPreferredValue()));
		}
		
		// Install a local DelegateDomain.Factory
		DelegateDomain.Factory.Registry.Impl delegateDomainFactory = new DelegateDomain.Factory.Registry.Impl();
		if (forceInitialization || !delegateDomainFactory.containsKey(oclDelegateURI)) {
			delegateDomainFactory.put(oclDelegateURI, delegateFactoryFactory.createDelegateDomainFactory());
		}
		if (forceInitialization || (adapter.getRegistry(DelegateDomain.Factory.Registry.class) == null)) {
			adapter.putRegistry(DelegateDomain.Factory.Registry.class, delegateDomainFactory);
		}

		// Install a local ValidationDelegate.Factory
		ValidationDelegate.Factory.Registry validationDelegateFactoryRegistry = new ValidationDelegate.Factory.Registry.Impl();
		if (forceInitialization || !validationDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			validationDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory.createValidationDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (adapter.getRegistry(ValidationDelegate.Factory.Registry.class) == null)) {
			adapter.putRegistry(ValidationDelegate.Factory.Registry.class, validationDelegateFactoryRegistry);
		}

		// Install a local SettingDelegate.Factory
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingDelegateFactoryRegistry = new EStructuralFeature.Internal.SettingDelegate.Factory.Registry.Impl();
		if (forceInitialization || !settingDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			settingDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory.createSettingDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (adapter.getRegistry(EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class) == null)) {
			adapter.putRegistry(EStructuralFeature.Internal.SettingDelegate.Factory.Registry.class, settingDelegateFactoryRegistry);
		}

		// Install a local InvocationDelegate.Factory
		EOperation.Internal.InvocationDelegate.Factory.Registry invocationDelegateFactoryRegistry = new EOperation.Internal.InvocationDelegate.Factory.Registry.Impl();
		if (forceInitialization || !invocationDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			invocationDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory.createInvocationDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (adapter.getRegistry(EOperation.Internal.InvocationDelegate.Factory.Registry.class) == null)) {
			adapter.putRegistry(EOperation.Internal.InvocationDelegate.Factory.Registry.class, invocationDelegateFactoryRegistry);
		}

		// Install a local QueryDelegate.Factory
		QueryDelegate.Factory.Registry queryDelegateFactoryRegistry = new QueryDelegate.Factory.Registry.Impl();
		if (forceInitialization || !queryDelegateFactoryRegistry.containsKey(oclDelegateURI)) {
			queryDelegateFactoryRegistry.put(oclDelegateURI, delegateFactoryFactory.createQueryDelegateFactory(oclDelegateURI));
		}
		if (forceInitialization || (adapter.getRegistry(QueryDelegate.Factory.Registry.class) == null)) {
			adapter.putRegistry(QueryDelegate.Factory.Registry.class, queryDelegateFactoryRegistry);
		}
	}

	/**
	 * Initialize any currently uninitialized global delegate registries to support the oclDelegateURI.
	 */
	public static void lazyInitializeGlobals(@NonNull String oclDelegateURI, boolean forceInitialization) {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {		// Install the 'plugin' registrations
			EOperation.Internal.InvocationDelegate.Factory.Registry invocationRegistry = EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE;
			if (forceInitialization || !invocationRegistry.containsKey(oclDelegateURI)) {
				invocationRegistry.put(oclDelegateURI, new OCLInvocationDelegateFactory.Global());
			}
			EStructuralFeature.Internal.SettingDelegate.Factory.Registry settingRegistry = EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE;
			if (forceInitialization || !settingRegistry.containsKey(oclDelegateURI)) {
				settingRegistry.put(oclDelegateURI, new OCLSettingDelegateFactory.Global());
			}
			EValidator.ValidationDelegate.Registry validationRegistry = EValidator.ValidationDelegate.Registry.INSTANCE;
			if (forceInitialization || !validationRegistry.containsKey(oclDelegateURI)) {
				validationRegistry.put(oclDelegateURI, new OCLValidationDelegateFactory.Global());
			}
			QueryDelegate.Factory.Registry queryRegistry = QueryDelegate.Factory.Registry.INSTANCE;
			if (forceInitialization || !queryRegistry.containsKey(oclDelegateURI)) {
				queryRegistry.put(oclDelegateURI, new OCLQueryDelegateFactory.Global());
			}
		}
	}

	protected final @NonNull String uri;
	protected final @NonNull EPackage ePackage;
	protected OCL ocl = null;				// Lazily initialized and re-initialized
	// FIXME Introduce a lightweight function (? a lambda function) to avoid the need for a CompleteEnvironment for queries
//	private Map<CompletePackage, org.eclipse.ocl.pivot.Package> queryPackages = null;
//	private Map<CompleteType, org.eclipse.ocl.pivot.Class> queryTypes = null;
	
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

	@Override
	public void environmentFactoryDisposed(@NonNull EnvironmentFactory environmentFactory) {
		reset();
	}

	private @NonNull EnvironmentFactory getEnvironmentFactory() {
		Resource res = ePackage.eResource();
		EnvironmentFactory envFactory = null;
		if (res != null) {
			MetamodelManager metamodelManager = null;
			ResourceSet resourceSet = res.getResourceSet();
			if (resourceSet != null) {
				EnvironmentFactoryResourceSetAdapter rsAdapter = EnvironmentFactoryResourceSetAdapter.findAdapter(resourceSet);
				if (rsAdapter != null) {
					metamodelManager = rsAdapter.getMetamodelManager();
				}
				// it's a dynamic package. Use the local package registry
//				EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
				if (metamodelManager != null) {
					envFactory = metamodelManager.getEnvironmentFactory();
				}
				else {
					envFactory = OCL.Internal.createEnvironmentFactory(null);
				}
				DelegateResourceAdapter.getAdapter(res);
			}
		}
		if (envFactory == null) {
			// the shared instance uses the static package registry
			envFactory = OCL.Internal.getGlobalEnvironmentFactory();
		}
		return envFactory;
	}

	public final @NonNull MetamodelManager getMetamodelManager() {
		return getOCL().getMetamodelManager();
	}

	public @NonNull OCL getOCL() {
		OCL ocl2 = ocl;
		if (ocl2 == null) {
			// Delegates are an application-independent extension of EMF
			//  so we must use the neutral/global context see Bug 338501
			EnvironmentFactory environmentFactory = getEnvironmentFactory();
			ocl2 = ocl = OCL.newInstance(environmentFactory);
			environmentFactory.addListener(this);
		}
		return ocl2;
	}
	
	public <T extends Element> T getPivot(@NonNull Class<T> requiredClass, @NonNull EObject eObject) {
		MetamodelManager metamodelManager = getOCL().getMetamodelManager();
		try {
			return metamodelManager.getPivotOf(requiredClass, eObject);
		} catch (ParserException e) {
			return null;
		}
	}
	
	@Override
	public final @NonNull String getURI() {
		return uri;
	}

	@Override
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

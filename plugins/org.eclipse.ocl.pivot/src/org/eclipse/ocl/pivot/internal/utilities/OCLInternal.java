/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;

public class OCLInternal extends OCL
{
	/**
     * A convenient shared instance of the environment factory, that creates
     * environments using the global package registry.
	 */
    private static @Nullable EnvironmentFactoryInternal GLOBAL_ENVIRONMENT_FACTORY = null;
	
	public static @NonNull EnvironmentFactoryAdapter adapt(@NonNull Notifier notifier) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(notifier.eAdapters());
		EnvironmentFactoryAdapter adapter = ClassUtil.getAdapter(EnvironmentFactoryAdapter.class, eAdapters);
		if (adapter == null) {
			ProjectManager projectMap = null;
			if (notifier instanceof ResourceSet) {
				projectMap = BasicProjectManager.findAdapter((ResourceSet) notifier);
			}
			if (projectMap == null) {
				projectMap = BasicProjectManager.createDefaultProjectManager();
			}
			EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectMap, null);
			adapter = new EnvironmentFactoryAdapter(environmentFactory, notifier);
			eAdapters.add(adapter);
		}
		return adapter;
	}

	public static @Nullable EnvironmentFactory basicGetGlobalEnvironmentFactory() {
		return GLOBAL_ENVIRONMENT_FACTORY;
	}

    /**
     * Dispose of the global instance; this is intended for leakage detection in tests.
     */
	public static void disposeGlobalEnvironmentFactory() {
		EnvironmentFactory GLOBAL_ENVIRONMENT_FACTORY2 = GLOBAL_ENVIRONMENT_FACTORY;
		if (GLOBAL_ENVIRONMENT_FACTORY2 != null) {
//			PivotUtilInternal.debugPrintln("Dispose Global " + NameUtil.debugSimpleName(GLOBAL_ENVIRONMENT_FACTORY2));	
			((EnvironmentFactoryInternal)GLOBAL_ENVIRONMENT_FACTORY2).disposeGlobal();
			GLOBAL_ENVIRONMENT_FACTORY = null;
		}
	}

	/**
	 * Return the global EnvironmentFactory that may be shared amongst OCL consumers for which Complete OCL
	 * complements are not possible. Typically this is the OCLDElegateDomains that supported interpreted
	 * execution of OCL embedded in Ecore.
	 */
	public static @NonNull EnvironmentFactoryInternal getGlobalEnvironmentFactory() {
		EnvironmentFactoryInternal globalRegistryInstance2 = GLOBAL_ENVIRONMENT_FACTORY;
		if (globalRegistryInstance2 == null) {
			GLOBAL_ENVIRONMENT_FACTORY = globalRegistryInstance2 = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(ProjectManager.CLASS_PATH, null);
//			PivotUtilInternal.debugPrintln("Create Global " + NameUtil.debugSimpleName(GLOBAL_ENVIRONMENT_FACTORY));	
		}
//		else {
//			PivotUtilInternal.debugPrintln("Re-use Global " + NameUtil.debugSimpleName(GLOBAL_ENVIRONMENT_FACTORY));	
//		}
		return globalRegistryInstance2;
	}
	
	public static @NonNull OCLInternal newInstance() {
		return newInstance(BasicProjectManager.createDefaultProjectManager(), null);
	}
	
	public static @NonNull OCLInternal newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {	
		EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager, externalResourceSet);
		OCLInternal ocl = newInstance(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}
		return ocl;
	}
	
	public static @NonNull OCLInternal newInstance(@NonNull EnvironmentFactoryInternal environmentFactory) {	
		return new OCLInternal(environmentFactory);
	}
	
	public OCLInternal(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		assert environmentFactory != null;
		return environmentFactory;
	}

	@Override
	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		assert environmentFactory != null;
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		assert environmentFactory != null;
		return environmentFactory.getStandardLibrary();
	}
}
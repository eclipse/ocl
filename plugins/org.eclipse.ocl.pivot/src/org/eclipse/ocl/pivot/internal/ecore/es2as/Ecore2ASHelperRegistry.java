/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore.es2as;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.plugin.Ecore2ASHelperRegistryReader;

/**
 * The Ecore2ASHelperRegistry maintains the mapping from known ASResource content type
 * identifiers to the Ecore2ASHelper instance appropriate to the content type.
 * <p>
 * @since 1.1
 * 
 */
public class Ecore2ASHelperRegistry
{
	public static final @NonNull Ecore2ASHelperRegistry INSTANCE = new Ecore2ASHelperRegistry();

	static {
		if (EcorePlugin.IS_ECLIPSE_RUNNING) {
			new Ecore2ASHelperRegistryReader().readRegistry();
		}
	}
	
	protected final @NonNull Map<String, Ecore2ASHelperContribution> metamodelRegistry = new HashMap<String, Ecore2ASHelperContribution>();
	protected final @NonNull Map<String, Ecore2ASHelperContribution> modelRegistry = new HashMap<String, Ecore2ASHelperContribution>();
	
	public synchronized Object addEcore2ASHelper(@Nullable String uri, @NonNull Ecore2ASHelperContribution ecore2asHelper) {
		Map<String, Ecore2ASHelperContribution> registry = ecore2asHelper.isModel() ? modelRegistry : metamodelRegistry;
		Ecore2ASHelperContribution oldEcore2asHelper = registry.put(uri, ecore2asHelper);
		assert (oldEcore2asHelper == null) || (oldEcore2asHelper == ecore2asHelper)
				|| (oldEcore2asHelper.basicGetEcore2ASHelper() == ecore2asHelper)
				|| (oldEcore2asHelper.basicGetEcore2ASHelper() == null);
		return oldEcore2asHelper;
	}

	public @Nullable Ecore2ASHelperContribution getMetamodelHelper(@NonNull String contentType) {
		return metamodelRegistry.get(contentType);
	}

	public @Nullable Ecore2ASHelperContribution getModelHelper(@NonNull String contentType) {
		return modelRegistry.get(contentType);
	}

	/**
	 * Return the Ecore2ASHelper to be used in association with a particular resource.
	 * <p>
	 * For an ASResource, the Ecore2ASHelper is directly accessible.
	 * <p>
	 * For a CSResource, the CSResourceFactory is directly related to the CSResource class.
	 * <p>
	 * For more general resources, inheritance from defined correspondences is used. Thus
	 * the UMLEcore2ASHelper is defined for the UMLResource interface and so is used for
	 * all variants of derived UMLResource class. Inheritance is determined by registered
	 * class name to avoid loading the UML support plugins when UML is not in use.
	 * <p>
	 * In the absence of a configured selection an EcoreEcore2ASHelper is used.
	 *
	public @Nullable Ecore2ASHelper getEcore2ASHelper(@NonNull Resource resource) {
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getEcore2ASHelper();
		}
		if (resource instanceof CSResource) {
			return ((CSResource)resource).getEcore2ASHelper();
		}
		//
		//	This complexity is solely for the benefit of UML which may not be loaded so we cannot use UML classes.
		//
		synchronized(this) {
			Class<? extends Resource> resourceClass = resource.getClass();
			String resourceClassName = resourceClass.getName();
			Ecore2ASHelperContribution asResourceFactoryContribution = resourceClassName2resourceFactory.get(resourceClassName);
			if (asResourceFactoryContribution != null) {
				return asResourceFactoryContribution.getEcore2ASHelper();
			}
			for (Class<?> aClass = resourceClass; aClass != null; aClass = aClass.getSuperclass()) {
				{
					String aClassName = aClass.getName();
					asResourceFactoryContribution = resourceClassName2resourceFactory.get(aClassName);
					if (asResourceFactoryContribution != null) {
						Ecore2ASHelper asResourceFactory = asResourceFactoryContribution.getEcore2ASHelper();
						resourceClassName2resourceFactory.put(resourceClassName, asResourceFactory);
						return asResourceFactory;
					}
				}
				for (Class<?> anInterface : aClass.getInterfaces()) {
					String anInterfaceName = anInterface.getName();
					asResourceFactoryContribution = resourceClassName2resourceFactory.get(anInterfaceName);
					if (asResourceFactoryContribution != null) {
						Ecore2ASHelper asResourceFactory = asResourceFactoryContribution.getEcore2ASHelper();
						resourceClassName2resourceFactory.put(resourceClassName, asResourceFactory);
						return asResourceFactory;
					}
				}
			}
			Ecore2ASHelper asResourceFactory = EcoreEcore2ASHelper.getInstance();
			resourceClassName2resourceFactory.put(resourceClassName, asResourceFactory);
			return asResourceFactory;
		}
	} */

	public void remove(@NonNull String uri, boolean isModel) {
		Map<String, Ecore2ASHelperContribution> registry = isModel ? modelRegistry : metamodelRegistry;
		registry.remove(uri);
	}
}

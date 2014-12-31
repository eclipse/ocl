/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ecore.EcoreASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;

/**
 * The ASResourceFactoryRegistry maintains the mapping from known ASResource content type
 * identifiers to the ASResourceFactory instance appropriate to the content type.
 * <p>
 * 
 */
public class ASResourceFactoryRegistry
{
	public static final @NonNull ASResourceFactoryRegistry INSTANCE = new ASResourceFactoryRegistry();
	
//	protected final @NonNull Set<ASResourceFactoryContribution> asResourceFactories = new HashSet<ASResourceFactoryContribution>();
	protected final @NonNull Map<String, ASResourceFactoryContribution> contentType2resourceFactory = new HashMap<String, ASResourceFactoryContribution>();
	protected final @NonNull Map<String, ASResourceFactoryContribution> extension2resourceFactory = new HashMap<String, ASResourceFactoryContribution>();
	protected final @NonNull Map<String, ASResourceFactoryContribution> resourceClassName2resourceFactory = new HashMap<String, ASResourceFactoryContribution>();
	
	public synchronized Object addASResourceFactory(@Nullable String contentType, @Nullable String oclasExtension, @Nullable String resourceClassName, @NonNull ASResourceFactoryContribution asResourceFactory) {
		ASResourceFactoryContribution oldASResourceFactory;
		if (contentType != null) {
//			asResourceFactories.add(asResourceFactory);
			oldASResourceFactory = contentType2resourceFactory.put(contentType, asResourceFactory);
			assert (oldASResourceFactory == null) || (oldASResourceFactory == asResourceFactory)
				|| (oldASResourceFactory.getContribution() == asResourceFactory);
		}
		if (oclasExtension != null) {
			oldASResourceFactory = extension2resourceFactory.put(oclasExtension, asResourceFactory);
			assert (oldASResourceFactory == null) || (oldASResourceFactory == asResourceFactory)
				|| (oldASResourceFactory.getContribution() == asResourceFactory);
		}
		if (resourceClassName != null) {
			oldASResourceFactory = resourceClassName2resourceFactory.put(resourceClassName, asResourceFactory);
			assert (oldASResourceFactory == null) || (oldASResourceFactory == asResourceFactory)
				|| (oldASResourceFactory.getContribution() == asResourceFactory);
		}
		return null;
	}

	public synchronized void configureResourceSet(@NonNull ResourceSet resourceSet) {
		for (ASResourceFactoryContribution asResourceFactory : getResourceFactories()) {
			asResourceFactory.getASResourceFactory().configure(resourceSet);
		}
	}

	public @Nullable ASResourceFactoryContribution get(@NonNull String contentType) {
		return contentType2resourceFactory.get(contentType);
	}

	@SuppressWarnings("null")
	public @NonNull Iterable<ASResourceFactoryContribution> getResourceFactories() {
		return contentType2resourceFactory.values();
	}

	/**
	 * Return the ASResourceFactory to be used in association with a particular resource.
	 * <p>
	 * For an ASResource, the ASResourceFactory is directly accessible.
	 * <p>
	 * For a CSResource, the CSResourceFactory is directly related to the CSResource class.
	 * <p>
	 * For more general resources, inheritance from defined correspondences is used. Thus
	 * the UMLASResourceFactory is defined for the UMLResource interface and so is used for
	 * all variants of derived UMLResource class. Inheritance is determined by registered
	 * class name to avoid loading the UML support plugins when UML is not in use.
	 * <p>
	 * In the absence of a configured selection an EcoreASResourceFactory is used.
	 */
	public @Nullable ASResourceFactory getASResourceFactory(@NonNull Resource resource) {
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory();
		}
		if (resource instanceof CSResource) {
			return ((CSResource)resource).getASResourceFactory();
		}
		//
		//	This complexity is solely for the benefit of UML which may not be loaded so we cannot use UML classes.
		//
		synchronized(this) {
			Class<? extends Resource> resourceClass = resource.getClass();
			String resourceClassName = resourceClass.getName();
			ASResourceFactoryContribution asResourceFactoryContribution = resourceClassName2resourceFactory.get(resourceClassName);
			if (asResourceFactoryContribution != null) {
				return asResourceFactoryContribution.getASResourceFactory();
			}
			for (Class<?> aClass = resourceClass; aClass != null; aClass = aClass.getSuperclass()) {
				{
					String aClassName = aClass.getName();
					asResourceFactoryContribution = resourceClassName2resourceFactory.get(aClassName);
					if (asResourceFactoryContribution != null) {
						ASResourceFactory asResourceFactory = asResourceFactoryContribution.getASResourceFactory();
						resourceClassName2resourceFactory.put(resourceClassName, asResourceFactory);
						return asResourceFactory;
					}
				}
				for (Class<?> anInterface : aClass.getInterfaces()) {
					String anInterfaceName = anInterface.getName();
					asResourceFactoryContribution = resourceClassName2resourceFactory.get(anInterfaceName);
					if (asResourceFactoryContribution != null) {
						ASResourceFactory asResourceFactory = asResourceFactoryContribution.getASResourceFactory();
						resourceClassName2resourceFactory.put(resourceClassName, asResourceFactory);
						return asResourceFactory;
					}
				}
			}
			ASResourceFactory asResourceFactory = EcoreASResourceFactory.getInstance();
			resourceClassName2resourceFactory.put(resourceClassName, asResourceFactory);
			return asResourceFactory;
		}
	}

	public @Nullable ASResourceFactory getASResourceFactoryForExtension(@Nullable String extension) {
		ASResourceFactoryContribution asResourceFactoryContribution = extension2resourceFactory.get(extension);
		return asResourceFactoryContribution != null ?asResourceFactoryContribution.getASResourceFactory() : null;
	}

	public synchronized void remove(@Nullable String contentType, @Nullable String extension, @Nullable String resourceClassName) {
		if (contentType != null) {
			contentType2resourceFactory.remove(contentType);
		}
		if (extension != null) {
			extension2resourceFactory.remove(extension);
		}
		if (resourceClassName != null) {
			resourceClassName2resourceFactory.remove(resourceClassName);			// FIXME derived usages
		}
	}
}

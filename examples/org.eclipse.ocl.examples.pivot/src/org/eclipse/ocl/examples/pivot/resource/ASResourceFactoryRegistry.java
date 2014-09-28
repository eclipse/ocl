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
package org.eclipse.ocl.examples.pivot.resource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The ASResourceFactoryRegistry maintains the mapping from known ASResource content type
 * identifiers to the ASResourceFactory instance appropriate to the content type.
 * <p>
 * 
 */
public class ASResourceFactoryRegistry
{
	public static final @NonNull ASResourceFactoryRegistry INSTANCE = new ASResourceFactoryRegistry();
	
	protected final @NonNull Set<ASResourceFactory> asResourceFactories = new HashSet<ASResourceFactory>();
	protected final @NonNull Map<String, ASResourceFactory> contentType2resourceFactory = new HashMap<String, ASResourceFactory>();
	
	public synchronized void addASResourceFactory(@NonNull String contentType, @NonNull ASResourceFactory asResourceFactory) {
		asResourceFactories.add(asResourceFactory);
		contentType2resourceFactory.put(contentType, asResourceFactory);
	}

	public synchronized void configureResourceSet(@NonNull ResourceSet resourceSet) {
		for (ASResourceFactory asResourceFactory : asResourceFactories) {
			asResourceFactory.configure(resourceSet);
		}
	}

	public @NonNull Iterable<ASResourceFactory> getResourceFactories() {
		return asResourceFactories;
	}

	public synchronized @Nullable ASResourceFactory getResourceFactory(@Nullable EObject eObject) {
		if (eObject == null) {
			return null;
		}
		int bestPriority = ASResourceFactory.CANNOT_HANDLE;
		ASResourceFactory bestASResourceFactory = null;
		for (ASResourceFactory asResourceFactory : asResourceFactories) {
			int priority = asResourceFactory.getHandlerPriority(eObject);
			if (priority > bestPriority) {
				bestASResourceFactory = asResourceFactory;
				bestPriority = priority;
			}
		}
		return bestASResourceFactory;
	}

	public synchronized @Nullable ASResourceFactory getResourceFactory(@NonNull Resource resource) {
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory();
		}
		int bestPriority = ASResourceFactory.CANNOT_HANDLE;
		ASResourceFactory bestASResourceFactory = null;
		for (ASResourceFactory asResourceFactory : asResourceFactories) {
			int priority = asResourceFactory.getHandlerPriority(resource);
			if (priority > bestPriority) {
				bestASResourceFactory = asResourceFactory;
				bestPriority = priority;
			}
		}
		return bestASResourceFactory;
	}

	public synchronized @Nullable ASResourceFactory getResourceFactory(@NonNull URI uri) {
		int bestPriority = ASResourceFactory.CANNOT_HANDLE;
		ASResourceFactory bestASResourceFactory = null;
		for (ASResourceFactory asResourceFactory : asResourceFactories) {
			int priority = asResourceFactory.getHandlerPriority(uri);
			if (priority > bestPriority) {
				bestASResourceFactory = asResourceFactory;
				bestPriority = priority;
			}
		}
		return bestASResourceFactory;
	}
}

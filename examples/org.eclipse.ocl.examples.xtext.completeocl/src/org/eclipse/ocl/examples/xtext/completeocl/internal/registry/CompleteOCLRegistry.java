/**
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 */
package org.eclipse.ocl.examples.xtext.completeocl.internal.registry;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.ImportCSImpl;

/**
 * This registry will be used to hold all complete ocl resources that have been
 * made available through the extension point.
 * 
 * @author <a href="mailto:marwa.rostren@obeo.fr">Marwa Rostren</a>
 */
public class CompleteOCLRegistry {
	private static final Set<URI> REGISTERED_URIS = new LinkedHashSet<URI>();

	private CompleteOCLRegistry() {
		// prevents instantiation
	}

	public static void addURI(URI resourceURI) {
		REGISTERED_URIS.add(resourceURI);
	}

	public static void removeURI(URI resourceURI) {
		REGISTERED_URIS.remove(resourceURI);
	}

	public static void clear() {
		REGISTERED_URIS.clear();
	}
	
	/**
	 * Returns all registered URIs for a specific resources in resourceSet
	 * 
	 * @param resourceSet
	 *            the resourceSet
	 * @return all registered URIs for all resources in resourceSet
	 */
	public static Set<URI> getRegisteredResourceURIs(ResourceSet resourceSet) {
		Set<URI> concernedRegisteredURIs = new LinkedHashSet<URI>();
		
		for (Resource resource : resourceSet.getResources()) {
			EPackage epack = resource.getContents().get(0).eClass().getEPackage();
			concernedRegisteredURIs.addAll(CompleteOCLRegistry
				.getRegisteredResourceURIs(epack.getNsURI()));
		}
		return Collections.unmodifiableSet(concernedRegisteredURIs);
	}
	
	/**
	 * Returns a set of registered URIs for a specific model nsURI
	 * 
	 * @param modelNsURI
	 *            a specific model nsURI
	 * @return A set of registered URIs for a specific model nsURI
	 */
	private static Set<URI> getRegisteredResourceURIs(String modelNsURI) {
		Set<URI> modelRegisteredURIs = new LinkedHashSet<URI>();
		ResourceSet resourceSet = new ResourceSetImpl();
		
		for (URI uri: REGISTERED_URIS){
			final BaseResource xtextResource;
			if (uri.isPlatformResource()) {
				xtextResource = (BaseResource) resourceSet.getResource(URI.createPlatformPluginURI(uri.toPlatformString(false), false), true);
			} else {
				xtextResource = (BaseResource) resourceSet.getResource(uri, true);
			}
			for (TreeIterator<EObject> iterator = xtextResource.getAllContents(); iterator.hasNext(); ) {
				EObject eObject = iterator.next();
				if (eObject instanceof ImportCSImpl) {
					ImportCSImpl importObject = (ImportCSImpl) eObject;
					if (("'" + modelNsURI + "'").equals(importObject.getPathName().toString())){
						modelRegisteredURIs.add(uri);
					}
				}
			}
		}
		return Collections.unmodifiableSet(modelRegisteredURIs);
	}
}

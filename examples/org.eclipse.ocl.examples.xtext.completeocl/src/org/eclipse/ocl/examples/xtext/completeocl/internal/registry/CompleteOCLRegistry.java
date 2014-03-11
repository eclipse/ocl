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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;

/**
 * This registry will be used to hold all complete ocl resources that have been
 * made available through the extension point.
 * 
 * @author <a href="mailto:marwa.rostren@obeo.fr">Marwa Rostren</a>
 */
public class CompleteOCLRegistry
{
	public static final @NonNull CompleteOCLRegistry INSTANCE = new CompleteOCLRegistry();
	
//	private final @NonNull Map<URI, Set<String>> resourceURI2nsURIs = new HashMap<URI, Set<String>>();
	private /*@Nullable*/ Map<String, Set<URI>> nsURI2resourceURIs = null;

	private CompleteOCLRegistry() {
		// prevents instantiation
	}

	public void addURI(@NonNull URI resourceURI, @NonNull Iterable<String> moreNsURIs) {
//		Set<String> nsURIs = resourceURI2nsURIs.get(resourceURI);
//		if (nsURIs == null) {
//			nsURIs = new HashSet<String>();
//			resourceURI2nsURIs.put(resourceURI, nsURIs);
//		}
		for (String nsURI : moreNsURIs) {
			Set<URI> resourceURIs = nsURI2resourceURIs.get(nsURI);
			if (resourceURIs == null) {
				resourceURIs = new HashSet<URI>();
				nsURI2resourceURIs.put(nsURI, resourceURIs);
			}
			resourceURIs.add(resourceURI);
//			nsURIs.add(nsURI);
		}
	}

	public void clear() {
//		resourceURI2nsURIs.clear();
		nsURI2resourceURIs.clear();
	}
	
	/**
	 * Returns all document URIs that provide content for any EPackege nsURI in resourceSet
	 */
	public @NonNull Set<URI> getRegisteredResourceURIs(@NonNull ResourceSet resourceSet) {
		if (nsURI2resourceURIs == null) {
			nsURI2resourceURIs = new HashMap<String, Set<URI>>();
			new CompleteOCLRegistryReader().readRegistry();
		}
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (Resource resource : resourceSet.getResources()) {
			for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				EPackage ePackage = eObject.eClass().getEPackage();
				ePackages.add(ePackage);
			}
		}
		Set<URI> documentURIs = new HashSet<URI>();
		for (EPackage ePackage : ePackages) {
			String nsURI = ePackage.getNsURI();
			if (nsURI != null) {
				Set<URI> resourceURIs = nsURI2resourceURIs.get(nsURI);
				if (resourceURIs != null) {
					documentURIs.addAll(resourceURIs);
				}
			}
		}
		return documentURIs;
	}
	
	public void removeURI(@NonNull URI resourceURI) {
//		resourceURI2nsURIs.remove(resourceURI);
	}
}

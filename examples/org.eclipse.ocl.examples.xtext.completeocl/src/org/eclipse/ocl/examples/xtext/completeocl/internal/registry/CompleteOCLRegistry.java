/**
 * Copyright (c) 2013 Obeo and others.
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

import org.eclipse.emf.common.util.URI;

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
	
	public static Set<URI> getRegisteredResourceURIs() {
		return Collections.unmodifiableSet(REGISTERED_URIS);
	}
}

/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;

/**
 * ClasspathURIHandler may be installed by code such as 
 * <p>
 * 	resourceSet.getURIConverter().getURIHandlers().add(0, new ClasspathURIHandler());
 * <p>
 * to rectify the missing support for the classpath: protocol in Xtext (Bug 446073).
 */
public class ClasspathURIHandler extends URIHandlerImpl
{
	private final @NonNull ClassloaderClasspathUriResolver resolver = new ClassloaderClasspathUriResolver();

	@Override
	public boolean canHandle(URI uri) {
		return "classpath".equals(uri.scheme());
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		try {
			URI resolvedURI = resolver.findResourceOnClasspath(getClass().getClassLoader(), uri);
			return super.createInputStream(resolvedURI, options);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
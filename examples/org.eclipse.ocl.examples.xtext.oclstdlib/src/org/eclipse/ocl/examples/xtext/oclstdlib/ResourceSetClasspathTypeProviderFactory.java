/**
 * <copyright>
 *
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.oclstdlib;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;

import com.google.inject.Inject;


@SuppressWarnings("restriction")
public class ResourceSetClasspathTypeProviderFactory extends ClasspathTypeProviderFactory
{
	@Inject
	public ResourceSetClasspathTypeProviderFactory(ClassLoader classLoader) {
		super(classLoader);
	}

	@Override
	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new ClasspathTypeProvider(resourceSet.getClass().getClassLoader(), resourceSet, getIndexedJvmTypeAccess());
	}
}

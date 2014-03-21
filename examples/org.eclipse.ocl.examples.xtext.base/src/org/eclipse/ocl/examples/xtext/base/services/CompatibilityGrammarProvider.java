/**
 * <copyright>
 *
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.services;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.ocl.examples.xtext.base.utilities.BinaryGrammarResourceFactoryImpl;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.GrammarProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * This adds the Xtext 2.4 *.xtextbin functionality for use on Xtext 2.3
 */
@Singleton
public class CompatibilityGrammarProvider extends GrammarProvider {

	private final String languageName;

	private volatile Grammar grammar;

	private final Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject(optional=true)
	private ClassLoader classLoader;

	@Inject
	public CompatibilityGrammarProvider(@Named(Constants.LANGUAGE_NAME) String languageName, Provider<XtextResourceSet> resourceSetProvider) {
		super(languageName, resourceSetProvider);
		this.languageName = languageName;
		this.resourceSetProvider = resourceSetProvider;
	}

	@Override
	public Grammar getGrammar(Object requestor) {
		if (grammar == null) {
			try {
				grammar = super.getGrammar(requestor);
			} catch (WrappedException e) {
				synchronized(this) {
					if (grammar == null) {
						XtextResourceSet resourceSet = resourceSetProvider.get();
						if (!resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().containsKey("xtextbin"))
							resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
							"xtextbin", new BinaryGrammarResourceFactoryImpl());
						if (classLoader != null) {
							resourceSet.setClasspathURIContext(classLoader);
						} else {
							final ClassLoader classLoaderToUse = requestor == null ? getClass().getClassLoader() : requestor.getClass().getClassLoader();
							resourceSet.setClasspathURIContext(classLoaderToUse);
						}
						grammar = (Grammar) BaseEPackageAccess.loadGrammarFile(
								ClasspathUriUtil.CLASSPATH_SCHEME + ":/" + languageName.replace('.', '/') + ".xtextbin",
								resourceSet);
					}
				}
			}
		}
		return grammar;
	}
}

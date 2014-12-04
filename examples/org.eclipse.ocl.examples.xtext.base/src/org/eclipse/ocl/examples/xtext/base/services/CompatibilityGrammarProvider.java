/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation 
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
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
 * This makes the *.xtextbin grammar functionality for Xtext >= 2.4  available for use on Xtext 2.3
 */
@Singleton
public class CompatibilityGrammarProvider extends GrammarProvider
{
	/**
	 * @author Moritz Eysholdt - Initial contribution and API
	 * <p>
	 * This copy of org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl
	 * enables binary grammars to be used by an Xtext 2.6 generated editor on Xtext 2.3.1.
	 */
	public static class BinaryGrammarResourceFactoryImpl implements Factory
	{
		public static final @NonNull BinaryGrammarResourceFactoryImpl INSTANCE = new BinaryGrammarResourceFactoryImpl();

		@Override
		public Resource createResource(URI uri) {
			XMIResourceImpl resource = new XMIResourceImpl(uri);
			
			// make it a binary resource
			resource.getDefaultLoadOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);
			resource.getDefaultSaveOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);
			
			// don't do any resolution, since the only external references point to Ecore elements from EPackages in the registry. 
			XMLResource.URIHandler uriHandler = new XMLResource.URIHandler() {
	
				@Override
				public void setBaseURI(URI uri) {
				}
	
				@Override
				public URI resolve(URI uri) {
					return uri;
				}
	
				@Override
				public URI deresolve(URI uri) {
					return uri;
				}
			};
			resource.getDefaultLoadOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
			resource.getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
			return resource;
		}
	}

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
							"xtextbin", BinaryGrammarResourceFactoryImpl.INSTANCE);
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

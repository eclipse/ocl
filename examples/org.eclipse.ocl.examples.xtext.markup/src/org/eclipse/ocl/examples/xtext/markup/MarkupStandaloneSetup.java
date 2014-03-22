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
 *
 * $Id$
 */
package org.eclipse.ocl.examples.xtext.markup;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.xtext.base.services.CompatibilityGrammarProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MarkupStandaloneSetup extends MarkupStandaloneSetupGenerated
{
	private static Injector injector = null;
	
	public static void doSetup() {
		if (injector == null) {
			new MarkupStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			@SuppressWarnings("unused")Class<?> loadClass = classLoader.loadClass("org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl");
			return super.createInjectorAndDoEMFRegistration();
		}
		catch (ClassNotFoundException e) { // Xtext 2.3 - super code with custom BinaryResourceFactory
			// register default ePackages
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xtextbin"))
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xtextbin", CompatibilityGrammarProvider.BinaryGrammarResourceFactoryImpl.INSTANCE);
			if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI))
				EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI, org.eclipse.xtext.XtextPackage.eINSTANCE);
	
			Injector injector = createInjector();
			register(injector);
			return injector;
		}
	}

	public static void doTearDown() {
		injector = null;
	}

	public static Injector getInjector() {
		if (injector == null) {
			if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
				doSetup();
			}
			else {
				injector = Guice.createInjector(new MarkupRuntimeModule());
			}
		}
		return injector;
	}

	public static void init() {
		EPackage.Registry.INSTANCE.put(MarkupPackage.eNS_URI, MarkupPackage.eINSTANCE);
	}

	@Override
	public Injector createInjector() {
		init();
		injector = super.createInjector();
		return injector;
	}
}


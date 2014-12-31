/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.uml;

import org.eclipse.ocl.pivot.internal.PivotStandaloneSetup;
import org.eclipse.ocl.pivot.internal.manager.ImplementationManager;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.UML2AS;
import org.eclipse.ocl.pivot.uml.internal.UMLASResourceFactory;
import org.eclipse.ocl.pivot.uml.internal.UMLExplicitNavigator;
import org.eclipse.ocl.pivot.uml.internal.labels.CommentLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralBooleanLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralIntegerLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralNullLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralRealLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralStringLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.LiteralUnlimitedNaturalLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.NamedElementLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.OpaqueExpressionLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.PackageImportLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.SlotLabelGenerator;
import org.eclipse.ocl.pivot.uml.internal.labels.UMLElementExtensionLabelGenerator;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

//import com.google.inject.Guice;
//import com.google.inject.Injector;

/**
 * Initialization support for UML Pivot models without equinox extension registry
 */
public class UMLStandaloneSetup //implements ISetup
{
//	private static Injector injector = null;
	
//	public static void doSetup() {
//		if (injector == null) {
//			new UMLStandaloneSetup().createInjectorAndDoEMFRegistration();
//		}
//	}
	
//	public static void doTearDown() {
//		injector = null;
//	}

	public static void init() {
		PivotStandaloneSetup.init();
		UMLASResourceFactory.getInstance();
		ImplementationManager.addExplicitNavgator(UMLExplicitNavigator.INSTANCE);
		try {
			UML2AS.initialize();
			UMLResourcesUtil.init(null);
		} catch (Throwable e) {}		// UML is optional so may get a ClassNotFoundException
		//
		// UML
		//
		CommentLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		LiteralBooleanLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		LiteralIntegerLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		LiteralNullLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		LiteralRealLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		LiteralStringLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		LiteralUnlimitedNaturalLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		NamedElementLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		OpaqueExpressionLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		PackageImportLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		SlotLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		UMLElementExtensionLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
	}
	
	/**
	 * Return the Injector for this plugin.
	 */
//	public static final Injector getInjector() {
//		return injector;
//	}

//	public Injector createInjector() {
//		if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
//			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove("xmi");
//		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(Resource.Factory.Registry.DEFAULT_EXTENSION))
//			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
//		injector = Guice.createInjector(/*new PivotRuntimeModule()*/);
//		return injector;
//	}

//	public Injector createInjectorAndDoEMFRegistration() {
//		init();
//		// register default ePackages
//		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
//			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//				"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
//		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
//			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//				"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
//		if (!EPackage.Registry.INSTANCE.containsKey(PivotPackage.eNS_URI))
//			EPackage.Registry.INSTANCE.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
//
//		Injector injector = createInjector();
////		register(injector);
//		return injector;
//	}
	
//	public void register(Injector injector) {
//		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
//		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", resourceFactory);
//		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", serviceProvider);
//	}
}


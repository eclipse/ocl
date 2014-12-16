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

package org.eclipse.ocl.pivot;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.pivot.ecore.EcoreASResourceFactory;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.labels.LabelGeneratorRegistry;
import org.eclipse.ocl.pivot.manager.ImplementationManager;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.scoping.PivotScoping;
import org.eclipse.ocl.pivot.uml.CommentLabelGenerator;
import org.eclipse.ocl.pivot.uml.LiteralBooleanLabelGenerator;
import org.eclipse.ocl.pivot.uml.LiteralIntegerLabelGenerator;
import org.eclipse.ocl.pivot.uml.LiteralNullLabelGenerator;
import org.eclipse.ocl.pivot.uml.LiteralRealLabelGenerator;
import org.eclipse.ocl.pivot.uml.LiteralStringLabelGenerator;
import org.eclipse.ocl.pivot.uml.LiteralUnlimitedNaturalLabelGenerator;
import org.eclipse.ocl.pivot.uml.NamedElementLabelGenerator;
import org.eclipse.ocl.pivot.uml.OpaqueExpressionLabelGenerator;
import org.eclipse.ocl.pivot.uml.PackageImportLabelGenerator;
import org.eclipse.ocl.pivot.uml.SlotLabelGenerator;
import org.eclipse.ocl.pivot.uml.UML2AS;
import org.eclipse.ocl.pivot.uml.UMLASResourceFactory;
import org.eclipse.ocl.pivot.uml.UMLElementExtensionLabelGenerator;
import org.eclipse.ocl.pivot.uml.UMLExplicitNavigator;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.ocl.pivot.utilities.ExpressionInOCLLabelGenerator;
import org.eclipse.ocl.pivot.utilities.ModelLabelGenerator;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for Pivot models without equinox extension registry
 */
public class PivotStandaloneSetup //implements ISetup
{
	private static Injector injector = null;
	
	public static void doSetup() {
		if (injector == null) {
			new PivotStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}
	
	public static void doTearDown() {
		injector = null;
	}

	public static void init() {
//		OCLDelegateDomain.initialize(null);
		OCLstdlib.lazyInstall();
		EcoreASResourceFactory.INSTANCE.getClass();
		UMLASResourceFactory.INSTANCE.getClass();
		OCLASResourceFactory.INSTANCE.getClass();
		EcorePackage.eINSTANCE.getClass();
		ImplementationManager.addExplicitNavgator(UMLExplicitNavigator.INSTANCE);
		try {
			UML2AS.initialize();
			UMLResourcesUtil.init(null);
		} catch (Throwable e) {}		// UML is optional so may get a ClassNotFoundException
		PivotScoping.init();
		ToStringVisitor.FACTORY.getClass();
		EPackage.Registry.INSTANCE.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);
		EValidator.Registry.INSTANCE.put(PivotPackage.eINSTANCE, PivotValidator.INSTANCE);
		LabelGeneratorRegistry.initialize(ILabelGenerator.Registry.INSTANCE);
		//
		// Pivot
		//
		ExpressionInOCLLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		ModelLabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
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
	public static final Injector getInjector() {
		return injector;
	}

	public Injector createInjector() {
		if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove("xmi");
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(Resource.Factory.Registry.DEFAULT_EXTENSION))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		injector = Guice.createInjector(/*new PivotRuntimeModule()*/);
		return injector;
	}

	public Injector createInjectorAndDoEMFRegistration() {
		init();
		// register default ePackages
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi"))
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		if (!EPackage.Registry.INSTANCE.containsKey(PivotPackage.eNS_URI))
			EPackage.Registry.INSTANCE.put(PivotPackage.eNS_URI, PivotPackage.eINSTANCE);

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public void register(Injector injector) {
//		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
//		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", resourceFactory);
//		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("essentialocl", serviceProvider);
	}
}


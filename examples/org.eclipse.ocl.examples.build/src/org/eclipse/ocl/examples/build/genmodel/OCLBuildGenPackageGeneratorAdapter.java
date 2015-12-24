/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.genmodel;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;

//
//	Overridden to allow static templates to be invoked standalone.
//
public class OCLBuildGenPackageGeneratorAdapter extends GenPackageGeneratorAdapter
{
	private static final JETEmitterDescriptor[] JET_EMITTER_DESCRIPTORS = {
	    new JETEmitterDescriptor("model/PackageClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.PackageClass"),
	    new JETEmitterDescriptor("model/FactoryClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.FactoryClass"),
	    new JETEmitterDescriptor("model/XMLProcessorClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.XMLProcessorClass"),
	    new JETEmitterDescriptor("model/ValidatorClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.ValidatorClass"),
		new JETEmitterDescriptor("model/SwitchClass.javajet", "org.eclipse.ocl.examples.build.templates.model.SwitchClass"),
	    new JETEmitterDescriptor("model/AdapterFactoryClass.javajet", "org.eclipse.ocl.examples.build.templates.model.AdapterFactoryClass"),
	    new JETEmitterDescriptor("model/ResourceFactoryClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.ResourceFactoryClass"),
	    new JETEmitterDescriptor("model/ResourceClass.javajet", "org.eclipse.emf.codegen.ecore.templates.model.ResourceClass"),
	    new JETEmitterDescriptor("edit/ItemProviderAdapterFactory.javajet", "org.eclipse.emf.codegen.ecore.templates.edit.ItemProviderAdapterFactory"),
	    new JETEmitterDescriptor("editor/Editor.javajet", "org.eclipse.emf.codegen.ecore.templates.editor.Editor"),
	    new JETEmitterDescriptor("editor/ModelWizard.javajet", "org.eclipse.emf.codegen.ecore.templates.editor.ModelWizard"),
	    new JETEmitterDescriptor("editor/ActionBarContributor.javajet", "org.eclipse.emf.codegen.ecore.templates.editor.ActionBarContributor"),
	    new JETEmitterDescriptor("model.tests/PackageTestSuite.javajet", "org.eclipse.emf.codegen.ecore.templates.model.tests.PackageTestSuite"),
	    new JETEmitterDescriptor("model.tests/PackageExample.javajet", "org.eclipse.emf.codegen.ecore.templates.model.tests.PackageExample")};

	/**
	 * Returns the set of <code>JETEmitterDescriptor</code>s used by the
	 * adapter. The contents of the returned array should never be changed.
	 * Rather, subclasses may override this method to return a different array
	 * altogether.
	 */
	@Override
	protected JETEmitterDescriptor[] getJETEmitterDescriptors() {
		return JET_EMITTER_DESCRIPTORS;
	}

	public OCLBuildGenPackageGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}
}

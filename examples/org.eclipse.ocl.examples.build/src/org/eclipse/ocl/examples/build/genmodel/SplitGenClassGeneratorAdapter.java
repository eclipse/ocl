/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGenModelGeneratorAdapter;

//
//	Overridden to allow static templates to be invoked standalone.
//
public class SplitGenClassGeneratorAdapter extends GenClassGeneratorAdapter
{

	public SplitGenClassGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}

	@Override
	protected void generateClass(GenClass genClass, Monitor monitor) {
	    GenModel genModel = genClass.getGenModel();
	    String modelDirectory = genModel.getModelDirectory();
		try {
			EClassifier eClassifier = genClass.getEcoreClassifier();
			if (eClassifier instanceof EEnum) {
			    String interfaceModelDirectory = OCLinEcoreGenModelGeneratorAdapter.getInterfaceModelDirectory(genModel);
				if (interfaceModelDirectory != null) {
					genModel.setModelDirectory(interfaceModelDirectory);
				}
			}
			super.generateClass(genClass, monitor);
		}
		finally {
			genModel.setModelDirectory(modelDirectory);
		}
	}

	//
	//	Overridden to adjust modelDirectory for interfaces.
	//
	@Override
	protected void generateInterface(GenClass genClass, Monitor monitor) {
	    GenModel genModel = genClass.getGenModel();
	    String modelDirectory = genModel.getModelDirectory();
		try {
			String interfaceModelDirectory = OCLinEcoreGenModelGeneratorAdapter.getInterfaceModelDirectory(genModel);
			if (interfaceModelDirectory != null) {
				genModel.setModelDirectory(interfaceModelDirectory);
			}
			super.generateInterface(genClass, monitor);
		}
		finally {
			genModel.setModelDirectory(modelDirectory);
		}
	}
}

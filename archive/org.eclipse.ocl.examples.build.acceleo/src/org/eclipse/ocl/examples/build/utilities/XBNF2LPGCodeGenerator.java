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
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.ocl.examples.build.acceleo.GenerateXBNF2LPG;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;

/**
 * Generates the javaFolder/'javaPackageName'/visitorClassName.java file providing
 * a static Java-creation of the libraryFile OCL standard library definition.
 */
public class XBNF2LPGCodeGenerator extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
	protected String javaFolder;
	protected String javaPackageName;
	protected String in;

	public void checkConfiguration(Issues issues) {
		if (javaPackageName == null) {
			issues.addError(this, "javaPackageName not specified.");
		}
		if (in == null) {
			issues.addError(this, "in not specified.");
		}
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		OCLstdlibStandaloneSetup.doSetup();
		return resourceSet;
	}

	@Override
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues issues) {
		URI fileURI = URI.createPlatformResourceURI(in, true);
		File folder = new File(javaFolder + '/' + javaPackageName.replace('.', '/'));
		log.info("Loading '" + fileURI);
		try {
			ResourceSet resourceSet = getResourceSet();
			Resource ecoreResource = resourceSet.getResource(fileURI, true);
			List<Object> arguments = new ArrayList<Object>();
			EObject xbnfModel = ecoreResource.getContents().get(0);
			GenerateXBNF2LPG acceleo = new GenerateXBNF2LPG(xbnfModel, folder, arguments);
			log.info("Generating to ' " + folder + "'");
			EMF2MWEMonitorAdapter monitor = new EMF2MWEMonitorAdapter(arg1);
			acceleo.generate(monitor);
		} catch (IOException e) {
			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
		}
	}

	public void setIn(String in) {
		this.in = in;
	}

	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}

	public void setJavaPackageName(String javaPackageName) {
		this.javaPackageName = javaPackageName;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}

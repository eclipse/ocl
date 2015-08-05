/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.build.utilities;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.tx.TransformationTechnology;
import org.eclipse.ocl.pivot.evaluation.tx.TransformationTechnology.TransformationException;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.XMIUtil;

public  class GenerateCGedQVTiTransformation extends AbstractWorkflowComponent
{
	private final static @NonNull String BACKSLASH = "/";

	protected static boolean isDefined(final String string) {
		return (!Objects.equals(string, null));
	}
	
	protected String projectName;
	protected String oclFileURI;
	protected ResourceSet resourceSet;
	protected String javaFolder = "src-gen/";
	protected String javaPackage = "";
	protected String envClassName;
	protected String visitorClassName;
	protected String namedElementItfName;
	protected String traceabilityPropName = "ast";
	protected Map<?, ?> savingOptions;

	public void checkConfiguration(final Issues issues) {
		if (!isDefined(oclFileURI)) {
			issues.addError(this, "OCL document URI not specified.");
		}
		
		if (!isDefined(envClassName)) {
			issues.addError(this, "Fully qualified name of the Environment java class not specified.");
		}
		
		if (!isDefined(visitorClassName)) {
			issues.addError(this, "Fully qualified name of the Loookup Visitor java class not specified");
		}
		
		if (!isDefined(namedElementItfName)) {
			issues.addError(this, "Fully qualified name of the Named Element interface not specified");
		}
	}
	
	 


	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		try {
			Class<?> txClass = Class.forName("org.eclipse.qvtd.cs2as.compiler.OCL2QVTiTransformationTechnology");
			Field txField = txClass.getField("INSTANCE");
			TransformationTechnology tx = (TransformationTechnology) txField.get(null);
			Map<String, Object> modelMap = new HashMap<String, Object>();
			Map<String, Object> parametersMap = new HashMap<String, Object>();
			parametersMap.put("envClassName", envClassName);
			parametersMap.put("visitorClassName", visitorClassName);
			parametersMap.put("namedElementItfName", namedElementItfName);
			parametersMap.put("javaFolder", javaFolder);
			parametersMap.put("javaPackage", javaPackage);
			//
			parametersMap.put("oclFileURI", oclFileURI);
			parametersMap.put("traceabilityPropName", traceabilityPropName);
			//
			tx.execute(ClassUtil.nonNullState(resourceSet), modelMap, parametersMap);
		} catch (TransformationException e) {
			issues.addError(this, e.getMessage(), null, e.getCause(), null);
		} catch (Exception e) {
			issues.addError(this, "Error while executing " + GenerateCGedQVTiTransformation.class.getName(), null, e, null);
		}		
	}

	/**
	 * (Optional) The folder within the project that forms the root of EMF
	 * generated sources. (default is "src-gen/")
	 */
	public void setJavaFolder(final String javaFolder) {
		this.javaFolder = javaFolder.endsWith(BACKSLASH) ? javaFolder : javaFolder.concat(BACKSLASH);
	}
	
	/**
	 * (Optional) The folder within the project that forms the root of EMF
	 * generated sources. (default is "")
	 */
	public void setJavaPackage(final String javaPackage) {
		this.javaPackage = javaPackage;
	}

	/**
	 * (Mandatory) The OCL document URI corresponding to the CS2AS description  
	 */
	public void setOclDocURI(final String oclDocURI) {
		this.oclFileURI = oclDocURI;
	}

	/**
	 * (Mandatory) The fully qualified class name of the Environment java class  
	 */
	public void setEnvironmentClassName(final String envClassName) {
		this.envClassName = envClassName;
	}
	
	/**
	 * (Mandatory) The fully qualified class name of the Lookup Visitor java class  
	 */
	public void setLookupVisitorClassName(final String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}
	
	/**
	 * (Mandatory) The fully qualified interface name of the NamedElement (itf which provides the "name" attribute)  
	 */
	public void setNamedElementItfName(final String namedElementItfName) {
		this.namedElementItfName = namedElementItfName;
	}
	
	/**
	 * An optional ResourceSet that MWE components may share to reduce model
	 * loading.
	 */
	public void setResourceSet(final ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	/**
	 * An optional saving options used when serialising EMF resources. (default is {@link XMIUtil#createSaveOptions()})
	 */
	public void setSavingOptions(final Map<?, ?> savingOptions) {
		this.savingOptions = savingOptions;
	}
	

	/**
	 * An optional CS2AS traceability property name (default is "ast")
	 */
	public void setTracePropertyName(final String tracePropName) {
		this.traceabilityPropName = tracePropName;
	}
	
	
}

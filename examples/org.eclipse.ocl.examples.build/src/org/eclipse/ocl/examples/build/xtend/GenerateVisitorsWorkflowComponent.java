/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - bug397429
 *******************************************************************************/
package org.eclipse.ocl.examples.build.xtend;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.utilities.GenPackageHelper;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

import com.google.common.base.Objects;

public abstract class GenerateVisitorsWorkflowComponent extends AbstractWorkflowComponent
{
	private static Logger log = Logger.getLogger(GenerateVisitorsWorkflowComponent.class);
	private final static @NonNull String EMPTY_STRING = "";

	protected static boolean isDefined(final String string) {
		return (!Objects.equal(string, null));
	}

	// Mandatory properties
	protected ResourceSet resourceSet = null;
	protected String projectName;
	protected String genModelFile;
	// Optional properties
	protected String superProjectName;
	protected String superGenModelFile;
	protected String baseProjectName;
	protected String baseGenModelFile;
	
	// Derived properties
	protected String projectPrefix;
	protected String modelPackageName;
	protected String visitorPackageName;
	protected String visitorClassName;
	protected String visitablePackageName;
	protected String visitableClassName;
	protected String javaFolder;
	protected String superProjectPrefix;
	protected String superVisitorClassName;
	protected String superVisitorPackageName;
	protected String sourceFile;
	protected String copyright;
	protected String modelFolder;
	protected String outputFolder;
	
	protected GenPackage genPackage = null;
	protected GenPackage superGenPackage = null;
	protected GenPackage baseGenPackage = null;
	

	public void checkConfiguration(final Issues issues) {
		if (!isDefined(projectName)) {
			issues.addError(this, "projectName not specified.");
		}
		if (!isDefined(genModelFile)) {
			issues.addError(this, "genModelFile not specified.");
		}
		if (isDerived()) {
			if (!isDefined(superGenModelFile)) {
				issues.addError(this, "superProjectPrefix not specified.");
			}
			if (!isDefined(baseProjectName)) {
				issues.addError(this, "baseProjectName must be specified for derived languages");
			}
			
			if (!isDefined(baseGenModelFile)) {
				issues.addError(this, "baseGenModelFile must be specified for derived languages");
			}
		}
	}

	/**
	 * It gives a chance to derived components to do initialise additional properties
	 * of the der
	 * 
	 * Derived components may override, but the must call super.doPreliminaryConfigurations(ocl)
	 * so the properties of this base components are initialised
	 * @param ocl
	 */
	protected void doPreliminarConfigurations(OCL ocl) {
		// load the genPackage
		URI genModelURI = getGenModelURI(projectName, genModelFile);
		Resource genModelResource = getGenModelResource(ocl, genModelURI);
		GenModel genModel = getGenModel(genModelResource);
		genModel.reconcile();
		genPackage = getGenPackage(genModelResource);
		
		// And configure missing information
		GenPackageHelper helper = new GenPackageHelper(genPackage);
		if (projectPrefix == null) { projectPrefix = helper.getProjectPrefix(); }
		if (visitorPackageName == null) { visitorPackageName = helper.getVisitorPackageName(); }
		if (visitorClassName == null) { visitorClassName = helper.getVisitorClassName(); }
		if (modelPackageName == null) { modelPackageName = helper.getModelPackageName(); }
		javaFolder = helper.getSrcJavaFolder();
		if (isDerived()) {
			URI superGenModelURI = getGenModelURI(superProjectName, superGenModelFile);
			Resource superGenModelResource = getGenModelResource(ocl, superGenModelURI);
			superGenPackage = getGenPackage(superGenModelResource);			
			
			helper = new GenPackageHelper(superGenPackage);
			if (!isDefined(superProjectPrefix)) { superProjectPrefix =  helper.getProjectPrefix(); }
			if (!isDefined(superVisitorPackageName)) { superVisitorPackageName = helper.getVisitorPackageName(); }
			if (!isDefined(superVisitorClassName)) { superVisitorClassName = helper.getVisitorClassName(); }
			
			// Visitable info will be get from base package
			URI baseGenModelURI = getGenModelURI(baseProjectName, baseGenModelFile);
			Resource baseGenModelResource = getGenModelResource(ocl, baseGenModelURI);
			baseGenPackage = getGenPackage(baseGenModelResource);
			
			helper = new GenPackageHelper(baseGenPackage);
			visitablePackageName = helper.getVisitablePackageName(); 
			visitableClassName = helper.getVisitableClassName();
		}  else { // if not derived
			if (visitablePackageName == null) { visitablePackageName = helper.getVisitablePackageName(); }
			if (visitableClassName == null) { visitableClassName = helper.getVisitableClassName(); }
		}
	}
	
	/**
	 * It gives a chance to derived components to do some setup subprocess,
	 * prior to start with the component generation process
	 * 
	 * derived components may override
	 */
	protected void doSetup() {
	}

	public abstract void generateVisitors(/*@NonNull*/ final GenPackage genPackage);
	
	private String getCopyright(GenModel genModel) {
		String copyright = genModel.getCopyright("");
		return copyright != null ? copyright : EMPTY_STRING;
	}

	protected @NonNull URI getGenModelURI(String projectName, String genModelFile) {
		URI projectResourceURI = URI.createPlatformResourceURI("/" + projectName + "/", true);
		return ClassUtil.nonNullState(URI.createURI(genModelFile).resolve(projectResourceURI));
	}
	
	protected @NonNull Resource getGenModelResource(OCL ocl, URI genModelURI) {
		Resource genModelResource = ocl.getResourceSet().getResource(genModelURI, true);
		if (genModelResource == null) {
			throw new IllegalStateException("No '" + genModelURI + "' Resource");
		}
		return genModelResource;
	}
	private @NonNull GenModel getGenModel(@NonNull Resource genModelResource) {
		EList<EObject> contents = genModelResource.getContents();
		if (contents.isEmpty()) {
			throw new IllegalArgumentException("Illegal empty genModelResource: " + genModelResource.getURI());
		}
		EObject rootElement = contents.get(0);
		if (!(rootElement instanceof GenModel)) { 
			throw new IllegalArgumentException("Illegal non GenModel root element: " + genModelResource.getURI());
		}
		return (GenModel) rootElement;
	}

	protected @NonNull GenPackage getGenPackage(@NonNull Resource genModelResource) {
		GenModel genModel = getGenModel(genModelResource);
		List<GenPackage> genPackages = genModel.getAllGenPackagesWithConcreteClasses();
		GenPackage genPackage = genPackages.isEmpty() ? null : genPackages.get(0); // We assume we want the first one;
		if (genPackage == null) {
			throw new IllegalStateException("No '" + genModelResource.getURI() + "' GenPackage");
		}
		return genPackage; 
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		ResourceSet resourceSet2 = resourceSet;
		assert resourceSet2 != null;
		OCL ocl = OCL.newInstance(resourceSet2);
		doPreliminarConfigurations(ocl);
		
		if (!isDefined(visitablePackageName)) {
			visitablePackageName = visitorPackageName;
		}
		if (!isDefined(superVisitorPackageName)) {
			superVisitorPackageName = visitorPackageName;
		}
		if (!isDerived()) {
			superProjectPrefix = "";
			superVisitorPackageName = "";
			superVisitorClassName = "";
		}
		doSetup();
		URI projectFileURI = EcorePlugin.getPlatformResourceMap().get(projectName);
		URI genModelURI = getGenModelURI(projectName, genModelFile);
		URI modelURI = URI.createURI(javaFolder);
		URI resolvedModelURI = modelURI.resolve(projectFileURI);
		modelFolder = (resolvedModelURI.isFile() ? resolvedModelURI.toFileString() : resolvedModelURI.toString()) + "/";
//		URI outputURI = URI.createURI(javaFolder + '/' + visitorPackageName.replace('.', '/'));
//		URI resolvedOutputURI = outputURI.resolve(projectFileURI);
		outputFolder = modelFolder + visitorPackageName.replace('.', '/') + "/";

		log.info("Loading GenModel '" + genModelURI);
//		try {
			registerGenModel(ocl, ClassUtil.nonNullState(genPackage.getGenModel()));
			copyright = getCopyright(genPackage.getGenModel());
			sourceFile = genModelFile;
			generateVisitors(genPackage);
//		} catch (IOException e) {
//			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
//		}
		ocl.dispose();
	}

	protected boolean isDerived() {		
		return (isDefined(superProjectName) && superProjectName.length() > 0);
	}

	protected boolean needsOverride() {
		if (genPackage != null) {
			GenModel genModel = genPackage.getGenModel();
			GenJDKLevel complianceLevel = genModel.getComplianceLevel();
			return complianceLevel.compareTo(GenJDKLevel.JDK60_LITERAL) >= 0;
		}
		return false;
	}

	
	private void registerGenModel(@NonNull OCL ocl, @NonNull GenModel genModel) {
		@SuppressWarnings("null")@NonNull ResourceSet resourceSet2 = resourceSet;
		EnvironmentFactoryAdapter adapter = OCLInternal.adapt(resourceSet2); // We prepare the mManager for the whole resourceSet
		PivotMetamodelManager metamodelManager = adapter.getMetamodelManager();
		metamodelManager.addGenModel(genModel);
		for (@SuppressWarnings("null")@NonNull GenPackage usedGenPackage : genModel.getUsedGenPackages()) {
			metamodelManager.addGenPackage(usedGenPackage);
		}
	}

	/**
	 * The path within the project to the genmodel file that identifies the
	 * Ecore file from which the EMF generated interfaces derive. Also provides
	 * the copyright for generated Visitor interfaces. (e.g.
	 * "model/my.genmodel")
	 */
	public void setGenModelFile(final String genModelFile) {
		this.genModelFile = genModelFile;
	}

	/**
	 * (Optional) The folder within the project that forms the root of EMF
	 * generated sources. (default is "emf-gen")
	 * @deprecated ensure you have set {@link #setGenModelFile(String)}
	 */
	@Deprecated
	public void setJavaFolder(final String javaFolder) {
		this.javaFolder = javaFolder;
	}

	/**
	 * The package name of the EMF generated interfaces. (e.g. "org.my.project")
	 * 
	 * @deprecated ensure you have set {@link #setGenModelFile(String)}
	 */
	@Deprecated
	public void setModelPackageName(final String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}

	/**
	 * The project name containing the genmodel and generated EMF sources. (e.g.
	 * "org.my.project")
	 */
	public void setProjectName(final String projectName) {
		this.projectName = projectName;
	}

	/**
	 * The name prefix of the EMF generated infrasdtructure classes. (e.g.
	 * "Project")
	 * 
	 * @deprecated ensure you have set {@link #setGenModelFile(String)}
	 */
	@Deprecated
	public void setProjectPrefix(final String projectPrefix) {
		this.projectPrefix = projectPrefix;
	}

	/**
	 * An optional ResourceSet that MWE components may share to reduce model
	 * loading.
	 */
	public void setResourceSet(final ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	/**
	 * The project name that is extended by the project containing the genmodel
	 * and generated EMF sources. (e.g. "org.my.superproject"). Must be null or
	 * "" if there is no super project to extend.
	 */
	public void setSuperProjectName(final String superProjectName) {
		this.superProjectName = superProjectName;
	}

	/**
	 * The gen model file path of the super project(e.g. "model/superModel.genmodel"). 
	 * It may be null or ""
	 */
	public void setSuperGenModelFile(final String superGenModelFile) {
		this.superGenModelFile = superGenModelFile;
	}
	
	/**
	 * The name prefix of the project that is extended by the project containing
	 * the genmodel and generated EMF sources. (e.g. "SuperProject"). The value
	 * is ignored if the superProjectName is "".
	 * 
	 * @deprecated ensure you have set {@link #setSuperGenModelFile(String)}
	 */
	@Deprecated
	public void setSuperProjectPrefix(final String superProjectPrefix) {
		this.superProjectPrefix = superProjectPrefix;
	}

	/**
	 * The class name for the extended Visitor interface. (e.g. "SuperVisitor").
	 * The value is ignored if the superProjectName is "".
	 * 
	 * @deprecated ensure you have set {@link #setSuperGenModelFile(String)}
	 */
	@Deprecated
	public void setSuperVisitorClassName(final String superVisitorClassName) {
		this.superVisitorClassName = superVisitorClassName;
	}

	/**
	 * The package name for the extended Visitor interface. (e.g.
	 * "org.my.superproject.util"). The value is ignored if the superProjectName
	 * is "".
	 * 
	 * @deprecated ensure you have set {@link #setSuperGenModelFile(String)}
	 */
	@Deprecated
	public void setSuperVisitorPackageName(final String superVisitorPackageName) {
		this.superVisitorPackageName = superVisitorPackageName;
	}

	/**
	 * The class name for the referenced Visitable interface. (e.g. "Visitable")
	 * 
	 * @deprecated ensure you have set {@link #setGenModelFile(String)}
	 */
	@Deprecated
	public void setVisitableClassName(final String visitableClassName) {
		this.visitableClassName = visitableClassName;
	}

	/**
	 * The package name for the referenced Visitable interface. (e.g.
	 * "org.my.project.util") If unspecified the visitorPackageName is used.
	 * 
	 * @deprecated ensure you have set {@link #setGenModelFile(String)}
	 */
	@Deprecated
	public void setVisitablePackageName(final String visitablePackageName) {
		this.visitablePackageName = visitablePackageName;
	}

	/**
	 * The required class name for the generated Visitor interface. (e.g.
	 * "Visitor")
	 * 
	 * @deprecated ensure you have set {@link #setGenModelFile(String)}
	 */
	@Deprecated
	public void setVisitorClassName(final String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}

	/**
	 * The required package name for the generated Visitor interface. (e.g.
	 * "org.my.project.util")
	 * 
	 * @deprecated ensure you have set {@link #setGenModelFile(String)}
	 */
	@Deprecated
	public void setVisitorPackageName(final String visitorPackageName) {
		this.visitorPackageName = visitorPackageName;
	}
}

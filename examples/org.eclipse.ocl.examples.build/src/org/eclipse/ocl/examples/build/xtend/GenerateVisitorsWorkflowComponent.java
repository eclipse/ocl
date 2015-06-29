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
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.OCL;

import com.google.common.base.Objects;

public abstract class GenerateVisitorsWorkflowComponent extends AbstractWorkflowComponent
{
	private static Logger log = Logger.getLogger(GenerateVisitorsWorkflowComponent.class);
	private final static @NonNull String EMPTY_STRING = "";

	protected static boolean isDefined(final String string) {
		return (!Objects.equal(string, null));
	}

	protected ResourceSet resourceSet = null;
	protected String projectName;
	protected String projectPrefix;
	protected String modelPackageName;
	protected String visitorPackageName;
	protected String visitorClassName;
	protected String visitablePackageName;
	protected String visitableClassName;
	protected String javaFolder = "emf-gen";
	protected String genModelFile;
	protected String superProjectName;
	protected String superProjectPrefix;
	protected String superVisitorClassName;
	protected String superVisitorPackageName;
	protected String sourceFile;
	protected String copyright;
	protected String modelFolder;
	protected String outputFolder;
	private GenModel genModel = null;

	public void checkConfiguration(final Issues issues) {
		if (!isDefined(projectName)) {
			issues.addError(this, "projectName not specified.");
		}
		if (!isDefined(projectPrefix)) {
			issues.addError(this, "projectPrefix not specified.");
		}
		if (!isDefined(modelPackageName)) {
			issues.addError(this, "modelPackageName not specified.");
		}
		if (!isDefined(visitorPackageName)) {
			issues.addError(this, "visitorPackageName not specified.");
		}
		if (!isDefined(visitorClassName)) {
			issues.addError(this, "visitorClassName not specified.");
		}
		if (!isDefined(visitableClassName)) {
			issues.addError(this, "visitableClassName not specified.");
		}
		if (!isDefined(genModelFile)) {
			issues.addError(this, "genModelFile not specified.");
		}
		if (!isDefined(superProjectName)) {
			issues.addError(this, "superProjectName not specified (use \"\" for a base visitor).");
		} else if (isDerived()) {
			if (!isDefined(superProjectPrefix)) {
				issues.addError(this, "superProjectPrefix not specified.");
			}
			if (!isDefined(superVisitorPackageName)) {
				issues.addError(this, "superVisitorPackageName not specified.");
			}
			if (!isDefined(superVisitorClassName)) {
				issues.addError(this, "superVisitorClassName not specified.");
			}
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

	public abstract void generateVisitors(@NonNull final GenPackage genPackage);

	private String getCopyright(@NonNull Resource genModelResource) {
		GenModel genModel = (GenModel)genModelResource.getContents().get(0);
		String copyright = genModel.getCopyright("");
		return copyright != null ? copyright : EMPTY_STRING;
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

	private GenPackage getGenPackage(@NonNull Resource genModelResource) {
		GenModel genModel = getGenModel(genModelResource);
		List<GenPackage> genPackages = genModel.getAllGenPackagesWithConcreteClasses();
		return genPackages.isEmpty() ? null : genPackages.get(0); // We assume we want the first one;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		ResourceSet resourceSet2 = resourceSet;
		assert resourceSet2 != null;
		OCL ocl = OCL.newInstance(resourceSet2);
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
		URI projectResourceURI = URI.createPlatformResourceURI("/" + projectName + "/", true);
		URI genModelURI = URI.createURI(genModelFile).resolve(projectResourceURI);
		URI modelURI = URI.createURI(javaFolder);
		URI resolvedModelURI = modelURI.resolve(projectFileURI);
		modelFolder = (resolvedModelURI.isFile() ? resolvedModelURI.toFileString() : resolvedModelURI.toString()) + "/";
//		URI outputURI = URI.createURI(javaFolder + '/' + visitorPackageName.replace('.', '/'));
//		URI resolvedOutputURI = outputURI.resolve(projectFileURI);
		outputFolder = modelFolder + visitorPackageName.replace('.', '/') + "/";

		log.info("Loading GenModel '" + genModelURI);
//		try {
			Resource genModelResource = ocl.getResourceSet().getResource(genModelURI, true);
			if (genModelResource == null) {
				throw new IllegalStateException("No '" + genModelURI + "' Resource");
			}
			GenModel genModel2 = genModel = getGenModel(genModelResource);
			genModel2.reconcile();
			GenPackage genPackage = getGenPackage(genModelResource);
			if (genPackage == null) {
				throw new IllegalStateException("No '" + genModelURI + "' GenPackage");
			}
			registerGenModel(ocl, genModel2);
			copyright = getCopyright(genModelResource);
			sourceFile = genModelFile;
			generateVisitors(genPackage);
//		} catch (IOException e) {
//			throw new RuntimeException("Problems running " + getClass().getSimpleName(), e);
//		}
		ocl.dispose();
	}

	protected boolean isDerived() {
		int _length = this.superProjectName.length();
		return (_length > 0);
	}

	protected boolean needsOverride() {
		if (genModel != null) {
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
	 */
	public void setJavaFolder(final String javaFolder) {
		this.javaFolder = javaFolder;
	}

	/**
	 * The package name of the EMF generated interfaces. (e.g. "org.my.project")
	 */
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
	 */
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
	 * The name prefix of the project that is extended by the project containing
	 * the genmodel and generated EMF sources. (e.g. "SuperProject"). The value
	 * is ignored if the superProjectName is "".
	 */
	public void setSuperProjectPrefix(final String superProjectPrefix) {
		this.superProjectPrefix = superProjectPrefix;
	}

	/**
	 * The class name for the extended Visitor interface. (e.g. "SuperVisitor").
	 * The value is ignored if the superProjectName is "".
	 */
	public void setSuperVisitorClassName(final String superVisitorClassName) {
		this.superVisitorClassName = superVisitorClassName;
	}

	/**
	 * The package name for the extended Visitor interface. (e.g.
	 * "org.my.superproject.util"). The value is ignored if the superProjectName
	 * is "".
	 */
	public void setSuperVisitorPackageName(final String superVisitorPackageName) {
		this.superVisitorPackageName = superVisitorPackageName;
	}

	/**
	 * The class name for the referenced Visitable interface. (e.g. "Visitable")
	 */
	public void setVisitableClassName(final String visitableClassName) {
		this.visitableClassName = visitableClassName;
	}

	/**
	 * The package name for the referenced Visitable interface. (e.g.
	 * "org.my.project.util") If unspecified the visitorPackageName is used.
	 */
	public void setVisitablePackageName(final String visitablePackageName) {
		this.visitablePackageName = visitablePackageName;
	}

	/**
	 * The required class name for the generated Visitor interface. (e.g.
	 * "Visitor")
	 */
	public void setVisitorClassName(final String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}

	/**
	 * The required package name for the generated Visitor interface. (e.g.
	 * "org.my.project.util")
	 */
	public void setVisitorPackageName(final String visitorPackageName) {
		this.visitorPackageName = visitorPackageName;
	}
}

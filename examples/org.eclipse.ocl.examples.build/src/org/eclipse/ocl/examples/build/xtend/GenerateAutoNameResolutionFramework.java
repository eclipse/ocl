/**
 * <copyright>
 * 
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.build.xtend;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.namereso.AutoGenNameResoCommonFramework;
import org.eclipse.ocl.examples.autogen.namereso.AutoGenNameResoSpecificFramework;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;

public class GenerateAutoNameResolutionFramework extends GenerateVisitorsWorkflowComponent
{
	
	protected String nameResoPackageName;
	
	protected String nameResolutionFile;
	
	protected String baseElement;
	
	protected String baseElementPackageName;
	
	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (!isDefined(nameResoPackageName)) {
			issues.addError(this, "nameResoPackageName not specified");
		}
	}
	@Override
	protected void doSetup() {
		CompleteOCLStandaloneSetup.doSetup();
		OCLstdlib.install();
	}
	
	@SuppressWarnings("null")
	@Override
	public void generateVisitors(@NonNull GenPackage genPackage) {
		if (isDerived()) {
//			AutoCodeGenerator.generate(genPackage, projectPrefix, projectName, visitorPackageName, visitorClassName,
//				superProjectPrefix, superProjectName, superVisitorClassName);
		} else {
			Package nameResoPackage = getNameResoDescriptionPackage();
			AutoGenNameResoCommonFramework.generateCommonFramework(outputFolder,nameResoPackageName);
			AutoGenNameResoSpecificFramework.generateSpecificFramework(outputFolder, genPackage, projectPrefix, modelPackageName,
				nameResoPackageName, visitorPackageName, visitorClassName, baseElementPackageName, baseElement, nameResoPackage);
		}
	}
		
	@SuppressWarnings("null")
	private Package getNameResoDescriptionPackage() {
		
		// MetaModelManager metaModelManager = PivotUtil.fingetMetaModelManager(DomainUtil.nonNullState(genPackage.eResource()));
		MetaModelManager mmManager = PivotUtil.findMetaModelManager(resourceSet);		
		URI projectResourceURI = URI.createPlatformResourceURI("/" + projectName + "/", true);
		@NonNull URI nameResoURI = URI.createURI(nameResolutionFile).resolve(projectResourceURI);
		OCL ocl = OCL.newInstance(new PivotEnvironmentFactory(resourceSet.getPackageRegistry(), mmManager));
		Resource resource = DomainUtil.nonNullState(ocl.parse(nameResoURI));
		Root root = (Root) resource.getContents().get(0);
		return root.getNestedPackage().get(0);
	}
	/**
	 * The optional package name in which the name resolution framework will be generated. (e.g. "org.my.project.lookup")
	 */
	public void setNameResoPackageName(final String nameResoPackageName) {
		this.nameResoPackageName = nameResoPackageName;
	}

	/**
	 * The optional name of the base element in the class hierarchy of the context elements meta-model. (e.g. EObject).
	 */
	public void setBaseElement(final String baseElement) {
		this.baseElement = baseElement;
	}

	/**
	 * The optional name of the package in which base element resides (see <code>baseElement</code>); (e.g. "org.eclipse.emf.ecore").
	 */
	public void setBaseElementPackageName(final String baseElementPackageName) {
		this.baseElementPackageName = baseElementPackageName;
	}
	
	/**
	 *The optional project-relative OCL file with the name resolution description file; default: "model/${projectPrefix}NameResolution.ocl".
	 */
	
	public void setNameResolutionFile(final String nameResoOclFile) {
		this.nameResolutionFile = nameResoOclFile;
	}
	
	
	/* The framework will be generated in its own  package: nameResoPackageName
	 * @see org.eclipse.ocl.examples.build.xtend.GenerateVisitorsWorkflowComponent#getOutputPackageName()
	 */
	@Override
	protected String getOutputPackageName() {		
		return nameResoPackageName;
	}
	
	
}

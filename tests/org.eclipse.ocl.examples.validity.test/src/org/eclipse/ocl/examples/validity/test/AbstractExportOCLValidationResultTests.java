/**
 * <copyright>
 *
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation
 *   E.D.Willink (Obeo) - 425799 Validity View Integration
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.validity.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.export.ExportResultsDescriptor;
import org.eclipse.ocl.examples.emf.validation.validity.export.ExportResultsRegistry;
import org.eclipse.ocl.examples.emf.validation.validity.export.IValidityExport;
import org.junit.After;
import org.junit.Before;

/**
 * Class testing the AbstractExport class.
 */
public class AbstractExportOCLValidationResultTests extends AbstractValidityTestCase
{
	
	protected IValidityExport exporter;
	protected IProject project;
	protected EList<Result> results;

	protected void initExporter(@NonNull Class<? extends IValidityExport> exportClass) {
		exporter = null;
		for (ExportResultsDescriptor descriptor : ExportResultsRegistry.getRegisteredExtensions()) {
			if (exportClass.getName().equals(descriptor.getExtensionClassName())) {
				exporter = descriptor.getExportExtension();
			}
		}
		assertNotNull(exporter);
		TEST_PROGRESS.println("exporter = " + exporter);
	}

	protected void initProject() throws CoreException {
		// create test project to save export models into.
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(TEST_PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		TEST_PROGRESS.println("project = " + project);
	}

	@Before
	public void setUp() throws Exception {
		TEST_PROGRESS.setState(true);
		super.setUp();
		initTestModels();
		initValidityManager(null);
		results = resultSet.getResults();
		TEST_PROGRESS.println("results = " + results);
	}

	@After
	public void tearDown() throws Exception {
		if (project != null) {
			project.delete(false, new NullProgressMonitor());
			project = null;
			TEST_PROGRESS.println("-project");
		}
		exporter = null;
		TEST_PROGRESS.println("-exporter");
		super.tearDown();
	}
}

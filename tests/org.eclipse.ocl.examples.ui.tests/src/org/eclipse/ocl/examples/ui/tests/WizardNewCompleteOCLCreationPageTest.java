/**
 * <copyright>
 *
 * Copyright (c) 2013 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.ui.tests;

import java.net.URL;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ocl.examples.test.ui.WizardCreationPageForTest;
import org.eclipse.ocl.examples.test.ui.WizardNewCompleteOCLFileCreationForTest;
import org.eclipse.ocl.examples.ui.dialogs.ExtendedNewCompleteOCLFileDialog;
import org.eclipse.ocl.examples.ui.messages.Messages;
import org.eclipse.ocl.examples.ui.wizards.WizardNewCompleteOCLFileCreation;
import org.eclipse.ocl.examples.ui.wizards.WizardNewCompleteOCLFileCreationPage;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.junit.Test;

/**
 * Tests that exercise the new complete OCL creation wizard page.
 */
public class WizardNewCompleteOCLCreationPageTest
		extends TestCase {

	private static final String TEST_ECORE_NAME = "Test.ecore";

	private static final String TEST_PROJECT_NAME = "test-project";

	private static final String PAGE_NAME = "page";

	private static final String EXPECTED_NS_URI = "platform:/resource/"
		+ TEST_PROJECT_NAME + "/" + TEST_ECORE_NAME;

	private static final String TEST_ECORE_PATH = "/" + TEST_PROJECT_NAME + "/"
		+ TEST_ECORE_NAME;

	private static final String EXPECTED_PACKAGE_NAME = "Test";

	private WizardNewCompleteOCLFileCreationPage page = null;

	private ExtendedNewCompleteOCLFileDialog dialog = null;

	private IProject project = null;

	private IFile modelFile = null;

	private IStructuredSelection selection = null;

	private WizardNewCompleteOCLFileCreation oclFileCreationWizard = null;

	public WizardNewCompleteOCLCreationPageTest(String name) {
		super(name);
	}

	private IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp()
			throws Exception {
		super.setUp();

		IEclipsePreferences prefs = InstanceScope.INSTANCE
			.getNode(ResourcesPlugin.PI_RESOURCES);
		prefs.putBoolean(ResourcesPlugin.PREF_LIGHTWEIGHT_AUTO_REFRESH, true);

		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProjectDescription description = ResourcesPlugin.getWorkspace()
			.newProjectDescription(TEST_PROJECT_NAME);
		project = root.getProject(description.getName());
		if (project.exists()) {
			project.delete(true, true, new NullProgressMonitor());
		}
		project.create(description, new NullProgressMonitor());

		assertTrue(project.exists());

		project.open(new NullProgressMonitor());

		URL url = getClass().getResource(TEST_ECORE_NAME);

		assertNotNull(url);
		project.getFile(TEST_ECORE_NAME).create(url.openStream(), true,
			new NullProgressMonitor());

		modelFile = project.getFile(TEST_ECORE_NAME);

		assertTrue(modelFile.exists());

		selection = new StructuredSelection(modelFile);
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown()
			throws Exception {
		super.tearDown();
		if (project.exists()) {
			project.delete(true, true, new NullProgressMonitor());
		}
	}

	@Test
	public void test_WizardPage() {
		oclFileCreationWizard = new WizardNewCompleteOCLFileCreation();
		oclFileCreationWizard.init(getWorkbench(), selection);
		page = (WizardNewCompleteOCLFileCreationPage) oclFileCreationWizard
			.getPage(PAGE_NAME);

		assertTrue(PAGE_NAME.equals(page.getName()));
		assertTrue(Messages.WizardNewCompleteOCLFileCreationPage_completeOCLFile
			.equals(page.getTitle()));
		assertTrue(Messages.WizardNewCompleteOCLFileCreationPage_createCompleteOCLFileBasedOnModel
			.equals(page.getDescription()));
		assertNull(page.getErrorMessage());
	}

	@Test
	public void test_ExtendedDialog() {
		dialog = new ExtendedNewCompleteOCLFileDialog(null, null, selection,
			null);
		dialog.fillContentsFromWorkspacePath(TEST_ECORE_PATH);

		assertTrue(Messages.WizardNewCompleteOCLFileCreationPage_fileExtension
			.equals(dialog.getNewFileExtension()));
		assertTrue(Messages.WizardNewCompleteOCLFileCreationPage_oclFileNameLabel
			.equals(dialog.getNewFileLabel()));
		assertTrue(Messages.WizardNewCompleteOCLFileCreationPage_fileName
			.equals(dialog.getNewFileName()));
		assertTrue(Messages.WizardNewCompleteOCLFileCreationPage_file
			.equals(dialog.getResourceType()));
		assertTrue(EXPECTED_NS_URI.equals(dialog.getMetamodelNsURI()));
		assertTrue(EXPECTED_PACKAGE_NAME.equals(dialog.getFirstPackage()
			.getName()));
		assertTrue(TEST_ECORE_PATH.equals(dialog.getURI().toString()));
	}

	@Test
	public void test_WizardPage_CreatedFileContent() {
		dialog = new ExtendedNewCompleteOCLFileDialog(null, null, selection,
			null);
		dialog.fillContentsFromWorkspacePath(TEST_ECORE_PATH);

		WizardCreationPageForTest oclFileCreationWizardPage = new WizardCreationPageForTest(
			selection, dialog);

		assertTrue(oclFileCreationWizardPage.getInitialContentsAsString()
			.equals(getExpectedContents()));
	}

	@Test
	public void test_WizardPage_FileCreation() {
		IWorkbenchWizard wizard = new WizardNewCompleteOCLFileCreationForTest();
		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection(
			modelFile));

		WizardDialog dialog = new WizardDialog(new Shell(), wizard);
		dialog.open();

		wizard.performFinish();

		assertTrue(project.getFile("NewOCLFile.ocl").exists());
	}

	public String getExpectedContents() {
		String line = new String("import '"); //$NON-NLS-1$
		line = line.concat(dialog.getMetamodelNsURI()).concat("'\n"); //$NON-NLS-1$
		String firstPackageName = dialog.getFirstPackage().getName(); //$NON-NLS-1$
		line = line + "\npackage " + firstPackageName + "\n\n"; //$NON-NLS-1$ //$NON-NLS-2$
		line = line + "\tcontext type\n"; //$NON-NLS-1$
		line = line + "\tinv InvariantName: true\n\n"; //$NON-NLS-1$
		line = line + "endpackage\n"; //$NON-NLS-1$
		return line;
	}
}

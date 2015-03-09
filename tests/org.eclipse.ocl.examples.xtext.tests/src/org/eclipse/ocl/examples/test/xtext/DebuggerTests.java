/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.ocl.examples.debug.launching.OCLLaunchConstants;
import org.eclipse.ocl.examples.xtext.tests.TestUIUtil;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
@SuppressWarnings({"null", "restriction"})
public class DebuggerTests extends XtextTestCase
{
	protected void closeIntro() {
		IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
		introManager.closeIntro(introManager.getIntro());
	}

	protected IFile copyFile(IProject project, String fileName, String encoding) throws CoreException, FileNotFoundException {
		URI xmiURI = getProjectFileURI(fileName);
		String string = xmiURI.isFile() ? xmiURI.toFileString() : xmiURI.toString();
		Reader reader = new BufferedReader(new FileReader(string));
		if (encoding == null) {
			encoding = URIConverter.ReadableInputStream.getEncoding(reader);
		}
		InputStream inputStream = new URIConverter.ReadableInputStream(reader, encoding);
		IFile outFile = project.getFile(fileName);
		outFile.create(inputStream, true, null);
		return outFile;
	}

	protected ILaunchConfigurationWorkingCopy createLaunchConfiguration(@NonNull IProject iProject,
			@NonNull Constraint constraint, @NonNull EObject eObject) throws CoreException {
		URI contextURI = EcoreUtil.getURI(eObject);
		URI constraintURI = EcoreUtil.getURI(constraint);
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(OCLLaunchConstants.LAUNCH_CONFIGURATION_TYPE_ID);
		ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(iProject, constraint.getName());
		launchConfiguration.setAttribute(OCLLaunchConstants.CONSTRAINT_URI, constraintURI.toString());
		launchConfiguration.setAttribute(OCLLaunchConstants.CONTEXT_URI, contextURI.toString());
		return launchConfiguration;
	}

	protected IProject createProject(String projectName) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		if (!project.exists()) {
			project.create(null);
		}
		project.open(null);
		return project;
	}

	protected void enableSwitchToDebugPerspectivePreference() {
		DebugUIPlugin.getDefault().getPreferenceStore().setValue(IInternalDebugUIConstants.PREF_SWITCH_TO_PERSPECTIVE, MessageDialogWithToggle.ALWAYS);
	}

	public void testDebugger_Launch() throws Exception {
		OCLInternal ocl = OCLInternal.newInstance(getProjectMap(), null);
		closeIntro();
		enableSwitchToDebugPerspectivePreference();
		//
		IProject iProject = createProject("DebuggerTests");
		IFile xmiFile = copyFile(iProject, "RoyalAndLoyal.xmi", null);
		@SuppressWarnings("unused")IFile ecoreFile = copyFile(iProject, "RoyalAndLoyal.ecore", null);
		IFile oclFile = copyFile(iProject, "RoyalAndLoyal.ocl", "UTF-8");
		URI xmiURI = URI.createPlatformResourceURI(xmiFile.getFullPath().toString(), true);
		URI oclURI = URI.createPlatformResourceURI(oclFile.getFullPath().toString(), true);
		//
		Resource xmiResource = ocl.getResourceSet().getResource(xmiURI, true);
		EObject xmiRoot = xmiResource.getContents().get(0);
		assertNoResourceErrors("Load failed", xmiResource);
		assertNoUnresolvedProxies("Unresolved proxies", xmiResource);
		assertNoValidationErrors("Validation errors", xmiRoot);
		Resource oclResource = ocl.getResourceSet().getResource(oclURI, true);
		assertNoResourceErrors("Load failed", oclResource);
		assertNoUnresolvedProxies("Unresolved proxies", oclResource);
		assertNoValidationErrors("Validation errors", oclResource.getContents().get(0));
		
		EStructuralFeature ref_RandL_Customer = xmiRoot.eClass().getEStructuralFeature("ref_RandL_Customer");
		@SuppressWarnings("unchecked")List<EObject> customers = (List<EObject>) xmiRoot.eGet(ref_RandL_Customer);
		EObject eObject = customers.get(0);
		
		MetamodelManagerInternal metamodelManager = ocl.getMetamodelManager();
		org.eclipse.ocl.pivot.Class customerClass = metamodelManager.getASOf(org.eclipse.ocl.pivot.Class.class, eObject.eClass());
		Iterable<Constraint> customerInvariants = metamodelManager.getAllInvariants(customerClass);
		Constraint constraint = NameUtil.getNameable(customerInvariants, "invariant_sizesAgree");

		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(iProject, constraint, eObject);
		launchConfiguration.doSave();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.DEBUG_MODE, null);
		waitForLaunchToTerminate(launch);
		ocl.dispose();
	}

	protected void waitForLaunchToTerminate(ILaunch launch) throws InterruptedException, DebugException {
		while (true) {
			for (int i = 0; i < 10; i++){
				TestUIUtil.flushEvents();
				Thread.sleep(100);
			}
			boolean allDead = true;
			for (IDebugTarget debugTarget : launch.getDebugTargets()) {
				IProcess process = debugTarget.getProcess();
				if (!process.isTerminated()) {
					allDead = false;
				}
				for (IThread debugThread : debugTarget.getThreads()) {
					if (!debugThread.isTerminated()) {
						allDead = false;
					}
				}
			}
			if (allDead) {
				break;
			}
		}
	}
}

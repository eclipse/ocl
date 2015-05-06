/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.tests;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.osgi.framework.Bundle;

public class TestUIUtil
{
	public static void closeIntro() {
		IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
		introManager.closeIntro(introManager.getIntro());
	}

	public static void cancelAndWaitForValidationJob() throws InterruptedException {
		IJobManager jobManager = Job.getJobManager();
		for (Job job : jobManager.find(null)) {
			if (job instanceof ValidationJob) {
//				System.out.println(Thread.currentThread().getName() + " cancel " + NameUtil.debugSimpleName(job));
				if (!job.cancel()) {
					int i = 0;
					while ((job.getState() == Job.RUNNING) && (i++ < 10)) {
//						System.out.println(Thread.currentThread().getName() + " waiting for " + NameUtil.debugSimpleName(job));
						flushEvents();
						Thread.sleep(100);
					}
				}
			}
		}
	}

	public static @NonNull FileEditorInput createFileEditorInput(@NonNull IContainer container, @NonNull String fileName, @NonNull InputStream inputStream) throws CoreException {
		IFile file1 = container.getFile(new Path(fileName));
		file1.create(inputStream, true, null);
		return new FileEditorInput(file1) {};	// Ensure classloader is here
	}

	public static void deleteIProject(@NonNull String testProjectName) throws Exception {
		suppressGitPrefixPopUp();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(testProjectName);
		project.delete(true, true, null);
	}

	public static void flushEvents() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		for (int i = 0; i < 10; i++) {
			while (workbench.getDisplay().readAndDispatch());
		}
	}

	private static boolean testedEgitUiBundle = false;

	/**
	 * Suppress diagnostics from EGIT
	 * <p>
	 * This was originally necessary to eliminate a model PopUp that locked up the tests (Bug 390479).
	 * <p>
	 * Now it just suppresses a Console Log entry.
	 */
	public static void suppressGitPrefixPopUp() {
	    if (!testedEgitUiBundle) {
	    	testedEgitUiBundle = true;
	    	Bundle egitUiBundle = Platform.getBundle("org.eclipse.egit.ui");
	        if (egitUiBundle != null) {
				try {
					Class<?> activatorClass = egitUiBundle.loadClass("org.eclipse.egit.ui.Activator");
					Class<?> preferencesClass = egitUiBundle.loadClass("org.eclipse.egit.ui.UIPreferences");
					Method getDefaultMethod = activatorClass.getMethod("getDefault");
					AbstractUIPlugin activator = (AbstractUIPlugin) getDefaultMethod.invoke(null);
					IPreferenceStore store = activator.getPreferenceStore();
					Field field = preferencesClass.getField("SHOW_GIT_PREFIX_WARNING");
					String name = (String)field.get(null);
					store.setValue(name, false);
					field = preferencesClass.getField("SHOW_HOME_DIR_WARNING");
					name = (String)field.get(null);
					store.setValue(name, false);
				}
				catch (Exception e) {}			// Ignore
			}
	    }
	}
	
	public static void wait(int delayTimeInMilliseconds) {
		for (int i = 0; i < delayTimeInMilliseconds; i += 100) {
			flushEvents();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}

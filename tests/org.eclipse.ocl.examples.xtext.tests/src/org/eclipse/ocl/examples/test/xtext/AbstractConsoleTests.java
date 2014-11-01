/*******************************************************************************
 * Copyright (c) 2011,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.tests.PivotTestCase;
import org.eclipse.ocl.examples.xtext.base.ui.model.BaseDocument;
import org.eclipse.ocl.examples.xtext.console.ColorManager;
import org.eclipse.ocl.examples.xtext.console.OCLConsole;
import org.eclipse.ocl.examples.xtext.console.OCLConsolePage;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.part.IPageBookViewPage;

/**
 * Tests that exercise the Xtext OCL Console.
 */
@SuppressWarnings("restriction")
public abstract class AbstractConsoleTests extends PivotTestCase
{	
	public static class TestConsole extends OCLConsole
	{
		private static TestConsole instance;

		public static TestConsole getInstance() {
			if (instance == null) {
				instance = new TestConsole();
				ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] {instance});
			}			
			return instance;
		}

		private TestConsolePage page;
		
		@Override
		public void close() {
			super.close();
			flushEvents();
			instance = null;
		}

		@Override
		public IPageBookViewPage createPage(IConsoleView view) {
			page = new TestConsolePage(this);
			return page;
		}
		
		public final TestConsolePage getPage() {
			return page;
		}
	}
	
	public static class TestConsolePage extends OCLConsolePage
	{
		private StringBuilder s = new StringBuilder();
		
		public TestConsolePage(TestConsole testConsole) {
			super(testConsole);
		}

		@Override
		protected void append(String text, RGB rgb, boolean bold) {
			super.append(text, rgb, bold);
			String boldTag;
			if (bold) { boldTag = "b"; }
			else { boldTag = null; }
			String rgbTag;
			if (rgb == ColorManager.DEFAULT) { rgbTag = null; }
			else if (rgb == ColorManager.OUTPUT_ERROR) { rgbTag = "error"; }
			else if (rgb == ColorManager.OUTPUT_RESULTS) { rgbTag = null; }
			else { rgbTag = "?"; }
			if (boldTag != null) {
				s.append("<" + boldTag + ">");
			}
			if (rgbTag != null) {
				s.append("<" + rgbTag + ">");
			}
			s.append(text + "\n");
			if (rgbTag != null) {
				s.append("</" + rgbTag + ">");
			}
			if (boldTag != null) {
				s.append("</" + boldTag + ">");
			}
		}

		@Override
		public boolean evaluate(String expression) {
			return super.evaluate(expression);
		}

		public String get() {
			return s.toString();
		}

		public ILaunch launchDebugger() {
			return internalLaunchDebugger();
		}

		@Override
		public void refreshSelection(Object selected) {
			super.refreshSelection(selected);
		}

		@Override
		public void resetDocument() {
			super.resetDocument();
			s = new StringBuilder();
		}
	}

	public static void assertConsoleResult(TestConsolePage consolePage, EObject contextObject, String testExpression, String expectedResult) {
		consolePage.resetDocument();
		flushEvents();
		consolePage.refreshSelection(contextObject);
		flushEvents();
		BaseDocument editorDocument = consolePage.getEditorDocument();
//		System.out.println("Set " + testExpression);
		editorDocument.set(testExpression);
		flushEvents();			// Let ValidationJob and other activities have a go
		consolePage.evaluate(testExpression);
		flushEvents();			// FIXME on more than one occasion the previous result was returned (perhaps the new input was not set) (before additional flushEvents added above)
		String string = consolePage.get();
		assertEquals("<b>Evaluating:\n</b>" + testExpression + "\n<b>Results:\n</b>" + expectedResult, string);
	}

	public static void flushEvents() {
		for (int i = 0; i < 10; i++) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			while (workbench.getDisplay().readAndDispatch());
		}
	}

	public TestConsolePage consolePage;

	protected void closeIntro() {
		IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
		introManager.closeIntro(introManager.getIntro());
	}

	protected void enableSwitchToDebugPerspectivePreference() {
		DebugUIPlugin.getDefault().getPreferenceStore().setValue(IInternalDebugUIConstants.PREF_SWITCH_TO_PERSPECTIVE, MessageDialogWithToggle.ALWAYS);
	}
	
	protected @NonNull TestConsolePage openConsole() {
		closeIntro();
		flushEvents();
		TestConsole console = TestConsole.getInstance();
		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();
		mgr.showConsoleView(console);
		flushEvents();
		@Nullable TestConsolePage consolePage = console.getPage();
		for (int i = 0; (consolePage == null) && (i < 100000); i++) {
			flushEvents();
			consolePage = console.getPage();
		}
		assert consolePage != null;
		return consolePage;
	}	
	
	@Override
    protected void setUp() throws Exception {
		suppressGitPrefixPopUp();    		
        super.setUp();
		OCLstdlib.install();
		consolePage = openConsole();
    }

	@Override
	protected void tearDown() throws Exception {
		TestConsole.getInstance().close();
		consolePage = null;
		super.tearDown();
	}
	
	protected void waitForLaunchToTerminate(@NonNull ILaunch launch) throws InterruptedException, DebugException {
		while (true) {
			for (int i = 0; i < 10; i++){
				flushEvents();
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

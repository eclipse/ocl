/*******************************************************************************
 * Copyright (c) 2011,2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * Tests that exercise the Xtext OCL Console.
 */
public class ConsoleTests extends AbstractConsoleTests
{	
	public void testConsole_oclLog() throws Exception {
		assertConsoleResult(consolePage, null, "7", "7\n");
		assertConsoleResult(consolePage, null, "7.oclLog('seven = ')", "seven = 7\n7\n");
	}

	public void zztestConsole_debugger() throws Exception {
//		VMVirtualMachine.LOCATION.setState(true);
//		VMVirtualMachine.PRE_VISIT.setState(true);
//		VMVirtualMachine.POST_VISIT.setState(true);
//		VMVirtualMachine.VISITOR_STACK.setState(true);
//		VMVirtualMachine.VM_EVENT.setState(true);
//		VMVirtualMachine.VM_REQUEST.setState(true);
//		VMVirtualMachine.VM_RESPONSE.setState(true);
		enableSwitchToDebugPerspectivePreference();
//		assertConsoleResult(consolePage, englishClass, "self.name", "'EnglishClass'\n");
		assertConsoleResult(consolePage, EcorePackage.Literals.ECLASS, "self.name <> null", "true\n");
		ILaunch launch = consolePage.launchDebugger();
		assertNotNull(launch);
		IDebugTarget debugTarget = launch.getDebugTarget();
		IThread vmThread = debugTarget.getThreads()[0];
		vmThread.stepInto();
		waitForLaunchToTerminate(launch);
	}
}

/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.ui.messages;

import org.eclipse.osgi.util.NLS;

public class DebugUIMessages
{
	static {
		NLS.initializeMessages(DebugUIMessages.class.getName(), DebugUIMessages.class);
	}

	public static String StatusDialog_Error;
    public static String StatusDialog_Warning;
    public static String StatusDialog_Information;

    public static String BreakpointConditionEditor_EnterCondition;

    public static String OCLBreakpointPage_CancelBreakpointCreationError;
    public static String OCLBreakpointPage_CreateBreakpointForModule;
    public static String OCLBreakpointPage_Enabled;
    public static String OCLBreakpointPage_HitCount;
    public static String OCLBreakpointPage_HitCountErrorMessage;
    public static String OCLBreakpointPage_Module;
    public static String OCLBreakpointPage_ModulePrepareBreakpoint;

	public static String OCLDebugModelPresentation_Running;

	public static String OCLDebugModelPresentation_Suspended;

	public static String OCLDebugModelPresentation_ThreadLabel;

	public static String OCLDebugModelPresentation_ExpressionInOCLLabel;

    public static String OCLToggleBreakpointAdapter_VerifyBreakpointJob;
	public static String OCLToggleBreakpointAdapter_CannotSetBreakpoint;
	
	public static String OCLLineBreakpointPage_ConditionTrue;
    public static String OCLLineBreakpointPage_ConditionValueChange;
    public static String OCLLineBreakpointPage_EnableCondition;
    public static String OCLLineBreakpointPage_LineBreakpoint;
    public static String OCLLineBreakpointPage_LineNumber;
    public static String OCLLineBreakpointPage_SuspendCondition;

	public static String OCLMainTab_mustRunAsVMApp;

	public static String OCLRunToLineAdapter_invalidLocation;

	public static String OCLRunToLineAdapter_runFailed;
 
	public static String OCLRunToLineAdapter_NoFile;
	public static String OCLRunToLineAdapter_NoDocument;
	public static String OCLRunToLineAdapter_NoInput;
	
    public static String BreakpointCondErrorHandler_EditConditionButtonLabel;
    public static String BreakpointCondErrorHandler_DialogTitle;

	public static String ModifiedSourceFileHandler_HotReplaceNotSupported;

	public static String ModifiedSourceFileHandler_ModifiedDebuggedSource;
    
    public static String OCLBreakpointProperties_RulerActionLabel;
    
    public static String DebugHandler_0;
}

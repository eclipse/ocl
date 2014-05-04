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
package org.eclipse.ocl.examples.debug.vm.event;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.data.VMLocationData;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;

public class VMSuspendEvent extends VMEvent
{
	private static final long serialVersionUID = 2494519177689939386L;

	public static final int BREAKPOINT_CONDITION_ERR = DebugEvent.MODEL_SPECIFIC + 10;

	public static void toDetailString(@NonNull StringBuilder s, int detail) {
		String prefix = "";
		if ((detail & DebugEvent.STEP_INTO) != 0) {
			s.append(prefix); s.append("STEP_INTO");
			prefix = "+";
		}
		if ((detail & DebugEvent.STEP_OVER) != 0) {
			s.append(prefix); s.append("STEP_OVER");
			prefix = "+";
		}
		if ((detail & DebugEvent.STEP_RETURN) != 0) {
			s.append(prefix); s.append("STEP_RETURN");
			prefix = "+";
		}
		if ((detail & DebugEvent.STEP_END) != 0) {
			s.append(prefix); s.append("STEP_END");
			prefix = "+";
		}
		if ((detail & DebugEvent.BREAKPOINT) != 0) {
			s.append(prefix); s.append("BREAKPOINT");
			prefix = "+";
		}
		if ((detail & DebugEvent.CLIENT_REQUEST) != 0) {
			s.append(prefix); s.append("CLIENT_REQUEST");
			prefix = "+";
		}
		if ((detail & DebugEvent.EVALUATION) != 0) {
			s.append(prefix); s.append("EVALUATION");
			prefix = "+";
		}
		if ((detail & DebugEvent.EVALUATION_IMPLICIT) != 0) {
			s.append(prefix); s.append("EVALUATION_IMPLICIT");
			prefix = "+";
		}
		if ((detail & DebugEvent.STATE) != 0) {
			s.append(prefix); s.append("STATE");
			prefix = "+";
		}
		if ((detail & DebugEvent.CONTENT) != 0) {
			s.append(prefix); s.append("CONTENT");
			prefix = "+";
		}
		if (prefix.equals("")) {
			s.append("UNSPECIFIED");
		}
	}

	public @NonNull VMLocationData location;
	public @NonNull VMStackFrameData[] stackFrames;
	public Long breakpointID;

	// TODO - currently using DebugEvent constants, OCL should define its own
	public int detail;
	
	public String reason;
	public String reasonDetail;

	public VMSuspendEvent(@NonNull VMStackFrameData[] stack, int detail) {
		if (stack.length == 0) {
			throw new IllegalArgumentException("empty stack"); //$NON-NLS-1$
		}
		
		this.stackFrames = stack;
		this.location = stack[0].getLocation();
		this.detail = detail;
	}
		
	public Long getBreakpointID() {
		return breakpointID;
	}
	
	public String getReason() {
		return reason;
	}
	
	public String getReasonDetail() {
		return reasonDetail;
	}
	
	public void setBreakpointID(Long breakpointID) {
		this.breakpointID = breakpointID;
	}
	
	public void setReason(String reason, String reasonDetail) {
		if(reason == null && reasonDetail != null) {
			throw new IllegalArgumentException();
		}
		this.reason = reason;
		this.reasonDetail = reasonDetail;
	}

	public void setReasonDetail(String reasonDetail) {
		this.reasonDetail = reasonDetail;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		s.append("(");
		toDetailString(s, detail);
		if (breakpointID != null) {
			s.append(" breakpointID:").append(breakpointID); //$NON-NLS-1$
		}
		if (reason != null) {
			s.append(" reason:").append( //$NON-NLS-1$
					reason.substring(0, Math.min(50, reason.length())));
		}
		if (stackFrames != null) {
			s.append(", {");
			for (int i = 0; i < stackFrames.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t");
				s.append(stackFrames[i]);
			}
			s.append("}");
		}
		s.append(")");
		return s.toString();
	}
}
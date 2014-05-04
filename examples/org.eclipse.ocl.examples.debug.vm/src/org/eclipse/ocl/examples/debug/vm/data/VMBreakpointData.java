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
package org.eclipse.ocl.examples.debug.vm.data;

import java.io.Serializable;

import org.eclipse.jdt.annotation.NonNull;

public class VMBreakpointData implements Serializable
{
	private static final long serialVersionUID = 2199378435188939811L;

	public String condition;
	public boolean conditionEnabled;
	public boolean conditionSuspendOnTrue;
	public int hitCount;
	
	public VMBreakpointData() {
		super();
	}
	
	protected VMBreakpointData(@NonNull VMBreakpointData data) {
		this.condition = data.condition;
		this.conditionEnabled = data.conditionEnabled;
		this.conditionSuspendOnTrue = data.conditionSuspendOnTrue;
		this.hitCount = data.hitCount;
	}
}
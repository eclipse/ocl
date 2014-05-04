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

import org.eclipse.jdt.annotation.NonNull;

public class VMNewBreakpointData extends VMBreakpointData
{
	private static final long serialVersionUID = -8614925057936040002L;

	public long ID;
	public int line = -1;
	public String targetURI;
	
	public VMNewBreakpointData() {
		super();
	}
	
	public VMNewBreakpointData(long id, int line, String targetURI, @NonNull VMBreakpointData data) {
		super(data);
		this.ID = id;
		this.line = line;
		this.targetURI = targetURI;			
	}
}
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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class AbstractVMEnvironmentFactory extends AbstractEnvironmentFactory implements IVMEnvironmentFactory
{
	private IVMDebuggerShell shell;
	private long envId = 0;
	
	public AbstractVMEnvironmentFactory(@NonNull ProjectManager projectMap) {
		super(projectMap);
	}

	protected @NonNull IVMDebuggerShell getShell() {
		return ClassUtil.nonNullState(shell);
	}

	protected long getNextEnvironmentId(){
		return ++envId;
	}

	public boolean keepDebug() {
		return true;
	}

	public void setShell(@Nullable IVMDebuggerShell shell) {
		this.shell = shell;
	}
}

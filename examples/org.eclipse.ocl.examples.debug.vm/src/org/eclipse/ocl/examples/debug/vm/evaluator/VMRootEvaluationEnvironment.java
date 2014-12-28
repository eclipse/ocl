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
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;

public abstract class VMRootEvaluationEnvironment<T extends NamedElement> extends VMEvaluationEnvironment<T> implements IVMRootEvaluationEnvironment<T>
{
    protected final @NonNull T debuggableElement;

    public VMRootEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull IVMModelManager modelManager, @NonNull T debuggableElement) {
		super(environmentFactory, modelManager);
		this.debuggableElement = debuggableElement;
	}

	public @NonNull T getDebuggableElement() {
		return debuggableElement;
	}

	public @NonNull VMRootEvaluationEnvironment<T> getRootEvaluationEnvironment() {
		return this;
	}
}

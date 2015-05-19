/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

public abstract class VMRootEvaluationEnvironment<T extends NamedElement> extends VMEvaluationEnvironment<T> implements IVMRootEvaluationEnvironment<T>
{
    public VMRootEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull T executableObject, @NonNull IVMModelManager modelManager) {
		super(environmentFactory, executableObject, modelManager);
	}

	@SuppressWarnings("unchecked")
	public @NonNull T getDebuggableElement() {
		Object executableObject2 = executableObject;
		assert executableObject2 != null;
		return (T) executableObject2;
	}

	public @NonNull VMRootEvaluationEnvironment<T> getRootEvaluationEnvironment() {
		return this;
	}
}

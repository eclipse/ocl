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
package org.eclipse.ocl.examples.debug.evaluator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;

public class OCLVMEnvironment extends PivotEnvironment
{
	public OCLVMEnvironment(@NonNull OCLVMEnvironmentFactory factory, @Nullable Resource resource) {
		super(factory, resource);
	}

	public OCLVMEnvironment(@NonNull OCLVMEnvironment parent) {
		super(parent);
	}

	@Override
	public @NonNull OCLVMEnvironmentFactory getFactory() {
		return (OCLVMEnvironmentFactory) super.getFactory();
	}
}

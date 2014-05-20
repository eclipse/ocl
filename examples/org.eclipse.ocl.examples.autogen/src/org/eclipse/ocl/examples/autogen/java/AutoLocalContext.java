/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.java;
/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;

/**
 * A AutoLocalContext maintains the Java-specific local context for generation of Auto code.
 */
public class AutoLocalContext extends JavaLocalContext
{
	public AutoLocalContext(@NonNull AutoGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext, cgScope);
	}

	@Override
	public @NonNull AutoGlobalContext getGlobalContext() {
		return (AutoGlobalContext) globalContext;
	}

	@Override
	public @NonNull CGValuedElement getIdResolverVariable(@NonNull CGValuedElement cgValuedElement) {
		return getGlobalContext().getIdResolverVariable(cgValuedElement);
	}
}

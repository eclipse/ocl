/*******************************************************************************
 * Copyright (c) 2013, 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;

/**
 * A AutoLocalContext maintains the Java-specific local context for generation of Auto code.
 */
public class CS2ASLocalContext extends JavaLocalContext<CS2ASCodeGenerator>
{
	public CS2ASLocalContext(@NonNull CS2ASGlobalContext globalContext, @NonNull CGElement cgScope) {
		super(globalContext, cgScope);
	}

	@Override
	public @NonNull CS2ASGlobalContext getGlobalContext() {
		return (CS2ASGlobalContext) globalContext;
	}

	@Override
	public @NonNull CGValuedElement getIdResolverVariable(@NonNull CGValuedElement cgValuedElement) {
		return getGlobalContext().getIdResolverVariable(cgValuedElement);
	}
}

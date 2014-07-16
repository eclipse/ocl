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
package org.eclipse.ocl.examples.autogen.namereso;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoGlobalContext;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;

public class AutoLookupCG2JavaPreVisitor extends CG2JavaPreVisitor implements NameResoCGModelVisitor<Object>
{
	public AutoLookupCG2JavaPreVisitor(@NonNull AutoGlobalContext javaContext) {
		super(javaContext);
	}

	@Nullable
	public Object visitCGAddOp(@NonNull CGAddOp object) {
		return visitCGOperation(object);
	}
}

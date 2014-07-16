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
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.java.AutoGlobalContext;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.java.JavaDependencyVisitor;

public class AutoLookupDependencyVisitor extends JavaDependencyVisitor implements NameResoCGModelVisitor<Object>
{	
	public AutoLookupDependencyVisitor(@NonNull AutoAnalyzer analyzer, @NonNull AutoGlobalContext globalContext, @NonNull GlobalPlace globalPlace) {
		super(analyzer, globalContext, globalPlace);
	}

	@Nullable
	public Object visitCGAddOp(@NonNull CGAddOp object) {
		return visitCGOperation(object);
	}
}

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
package org.eclipse.ocl.examples.autogen.analyzer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoGlobalContext;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.java.JavaDependencyVisitor;

public class AutoDependencyVisitor extends JavaDependencyVisitor implements AutoCGModelVisitor<Object>
{	
	public AutoDependencyVisitor(@NonNull AutoAnalyzer analyzer, @NonNull AutoGlobalContext<?> globalContext, @NonNull GlobalPlace globalPlace) {
		super(analyzer, globalContext, globalPlace);
	}

	public @Nullable Object visitCGASTCallExp(@NonNull CGASTCallExp object) {
		return visitCGOperationCallExp(object);
	}

	public @Nullable Object visitCGContainmentBody(@NonNull CGContainmentBody object) {
		return visitCGValuedElement(object);
	}

	public @Nullable Object visitCGContainmentPart(@NonNull CGContainmentPart object) {
		return visitCGValuedElement(object);
	}

	public @Nullable Object visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		return visitCGOperation(object);
	}
}

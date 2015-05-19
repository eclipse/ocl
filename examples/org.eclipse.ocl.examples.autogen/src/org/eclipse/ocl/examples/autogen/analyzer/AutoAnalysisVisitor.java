/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;

public class AutoAnalysisVisitor extends AnalysisVisitor implements AutoCGModelVisitor<Object>
{
	public AutoAnalysisVisitor(@NonNull AutoAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	public @Nullable Object visitCGASTCallExp(@NonNull CGASTCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable Object visitCGContainmentBody(@NonNull CGContainmentBody object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable Object visitCGContainmentPart(@NonNull CGContainmentPart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable Object visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
		return visitCGOperation(object);
	}
}

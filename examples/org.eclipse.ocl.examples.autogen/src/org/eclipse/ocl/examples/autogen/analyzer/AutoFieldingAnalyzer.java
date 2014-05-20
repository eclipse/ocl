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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentBody;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentPart;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGContainmentVisit;
import org.eclipse.ocl.examples.autogen.autocgmodel.util.AutoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;

public class AutoFieldingAnalyzer extends FieldingAnalyzer
{
	public static class AutoAnalysisVisitor extends AnalysisVisitor implements AutoCGModelVisitor<Set<CGVariable>>
	{
		public AutoAnalysisVisitor(@NonNull AutoFieldingAnalyzer context) {
			super(context);
		}

		public @Nullable Set<CGVariable> visitCGASTCallExp(@NonNull CGASTCallExp object) {
			return visitCGOperationCallExp(object);
		}

		public @Nullable Set<CGVariable> visitCGContainmentBody(@NonNull CGContainmentBody object) {
			return visitCGValuedElement(object);
		}

		public @Nullable Set<CGVariable> visitCGContainmentPart(@NonNull CGContainmentPart object) {
			return visitCGValuedElement(object);
		}

		public @Nullable Set<CGVariable> visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
			return visitCGOperation(object);
		}
	}
	
	public static class AutoRewriteVisitor extends RewriteVisitor implements AutoCGModelVisitor<Boolean>
	{
		public AutoRewriteVisitor(@NonNull AutoAnalyzer context, @NonNull Set<CGVariable> caughtVariables) {
			super(context, caughtVariables);
		}

		public @Nullable Boolean visitCGASTCallExp(@NonNull CGASTCallExp object) {
			return visitCGOperationCallExp(object);
		}

		public @Nullable Boolean visitCGContainmentBody(@NonNull CGContainmentBody object) {
			return visitCGValuedElement(object);
		}

		public @Nullable Boolean visitCGContainmentPart(@NonNull CGContainmentPart object) {
			return visitCGValuedElement(object);
		}

		public @Nullable Boolean visitCGContainmentVisit(@NonNull CGContainmentVisit object) {
			return visitCGOperation(object);
		}
	}
	
	public AutoFieldingAnalyzer(@NonNull AutoAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	protected @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new AutoAnalysisVisitor(this);
	}

	@Override
	protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<CGVariable> caughtVariables) {
		return new AutoRewriteVisitor((AutoAnalyzer) analyzer, caughtVariables);
	}
}

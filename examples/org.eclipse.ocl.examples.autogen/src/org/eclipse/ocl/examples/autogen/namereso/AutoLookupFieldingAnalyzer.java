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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;

public class AutoLookupFieldingAnalyzer extends FieldingAnalyzer
{
	public static class AutoAnalysisVisitor extends AnalysisVisitor implements NameResoCGModelVisitor<Set<CGVariable>>
	{
		public AutoAnalysisVisitor(@NonNull AutoLookupFieldingAnalyzer context) {
			super(context);
		}


		@Nullable
		public Set<CGVariable> visitCGAddOp(@NonNull CGAddOp object) {
			return visitCGOperation(object);
		}

	}
	
	public static class AutoRewriteVisitor extends RewriteVisitor implements NameResoCGModelVisitor<Boolean>
	{
		public AutoRewriteVisitor(@NonNull AutoAnalyzer context, @NonNull Set<CGVariable> caughtVariables) {
			super(context, caughtVariables);
		}

		@Nullable
		public Boolean visitCGAddOp(@NonNull CGAddOp object) {
			return visitCGOperation(object);
		}

	}
	
	public AutoLookupFieldingAnalyzer(@NonNull AutoAnalyzer analyzer) {
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

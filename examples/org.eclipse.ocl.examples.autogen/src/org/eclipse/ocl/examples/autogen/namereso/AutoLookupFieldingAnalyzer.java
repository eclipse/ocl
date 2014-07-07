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
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
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
		public Set<CGVariable> visitCGAddCall(@NonNull CGAddCall object) {
			return visitCGOperationCallExp(object);
		}

		@Nullable
		public Set<CGVariable> visitCGEnvVisitIfPart(@NonNull CGEnvVisitIfPart object) {
			return visitCGValuedElement(object);
		}

		@Nullable
		public Set<CGVariable> visitCGEnvVisitOp(@NonNull CGEnvVisitOp object) {
			return visitCGOperation(object);
		}

		@Nullable
		public Set<CGVariable> visitCGEnvVisitOpBody(@NonNull CGEnvVisitOpBody object) {
			return visitCGValuedElement(object);
		}
	}
	
	public static class AutoRewriteVisitor extends RewriteVisitor implements NameResoCGModelVisitor<Boolean>
	{
		public AutoRewriteVisitor(@NonNull AutoAnalyzer context, @NonNull Set<CGVariable> caughtVariables) {
			super(context, caughtVariables);
		}

		@Nullable
		public Boolean visitCGAddCall(@NonNull CGAddCall object) {
			return visitCGOperationCallExp(object);
		}

		@Nullable
		public Boolean visitCGEnvVisitIfPart(@NonNull CGEnvVisitIfPart object) {
			return visitCGValuedElement(object);
		}

		@Nullable
		public Boolean visitCGEnvVisitOp(@NonNull CGEnvVisitOp object) {
			return visitCGOperation(object);
		}

		@Nullable
		public Boolean visitCGEnvVisitOpBody(@NonNull CGEnvVisitOpBody object) {
			return visitCGValuedElement(object);
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

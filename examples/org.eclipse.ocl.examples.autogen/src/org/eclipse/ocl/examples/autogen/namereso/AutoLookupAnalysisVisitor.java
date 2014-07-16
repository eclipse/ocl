package org.eclipse.ocl.examples.autogen.namereso;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;


public class AutoLookupAnalysisVisitor extends AnalysisVisitor 
	implements NameResoCGModelVisitor<Object>{

	public AutoLookupAnalysisVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}

	@Nullable
	public Object visitCGAddOp(@NonNull CGAddOp object) {
		return visitCGOperation(object);
	}
}

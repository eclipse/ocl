package org.eclipse.ocl.examples.autogen.namereso;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;


public class AutoLookupBoxingAnalyzer extends BoxingAnalyzer
	implements NameResoCGModelVisitor<Object>{

	public AutoLookupBoxingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}

	@Nullable
	public Object visitCGAddCall(@NonNull CGAddCall object) {
		return visitCGOperationCallExp(object);
	}

	@Nullable
	public Object visitCGEnvVisitIfPart(@NonNull CGEnvVisitIfPart object) {
		return visitCGValuedElement(object);
	}

	@Nullable
	public Object visitCGEnvVisitOp(@NonNull CGEnvVisitOp object) {
		return visitCGOperation(object);
	}

	@Nullable
	public Object visitCGEnvVisitOpBody(@NonNull CGEnvVisitOpBody object) {
		return visitCGValuedElement(object);
	}

}

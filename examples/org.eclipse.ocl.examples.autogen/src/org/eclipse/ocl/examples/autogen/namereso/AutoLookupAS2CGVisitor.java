package org.eclipse.ocl.examples.autogen.namereso;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;


public class AutoLookupAS2CGVisitor extends AS2CGVisitor {

	public AutoLookupAS2CGVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}
	
	
	@Override
	public @NonNull
	CGValuedElement visitOperationCallExp(@NonNull OperationCallExp element) {
		Operation asOperation = DomainUtil.nonNullState(element.getReferredOperation());
		if (NameResolutionUtil.isAddOperation(asOperation)) {
			OCLExpression pSource = element.getSource();
			CGValuedElement cgSource = pSource != null ? doVisit(CGValuedElement.class, pSource) : null;
			List<OCLExpression> args = element.getArgument(); // FIXME what if more than 1 arg. Not expected
			CGValuedElement cgArgument = args.isEmpty() ? null : doVisit(CGValuedElement.class, args.get(0)); 
			CGASTCallExp cgAddCallExp = AutoCGModelFactory.eINSTANCE.createCGASTCallExp();
			cgAddCallExp.setSource(cgSource);
			cgAddCallExp.getArguments().add(cgArgument);
			setAst(cgAddCallExp, element);
			return  cgAddCallExp;
		}
		return super.visitOperationCallExp(element);
	}

}

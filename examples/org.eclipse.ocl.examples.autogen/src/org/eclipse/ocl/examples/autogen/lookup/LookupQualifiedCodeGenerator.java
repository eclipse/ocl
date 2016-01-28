package org.eclipse.ocl.examples.autogen.lookup;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoCG2JavaVisitor;
import org.eclipse.ocl.examples.autogen.java.AutoCodeGenerator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

public class LookupQualifiedCodeGenerator extends LookupVisitorsCodeGenerator {

	protected LookupQualifiedCodeGenerator(
			@NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull Package asPackage, @Nullable Package asSuperPackage,
			@NonNull Package asBasePackage, @NonNull GenPackage genPackage,
			@Nullable GenPackage superGenPackage,
			@Nullable GenPackage baseGenPackage) {
		super(environmentFactory, asPackage, asSuperPackage, asBasePackage, genPackage,
			superGenPackage, baseGenPackage);
	}

	@Override
	protected @NonNull AutoCG2JavaVisitor<@NonNull ? extends AutoCodeGenerator> createCG2JavaVisitor(
			@NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		return new LookupQualifiedCG2JavaVisitor(this, cgPackage, sortedGlobals);
	}
	
	@Override
	protected @NonNull String getLookupVisitorClassName(@NonNull String prefix) {
		return prefix + "QualifiedLookupVisitor";
	}
	
	@Override
	protected boolean isRewrittenOperation(Operation operation) {
		return LookupVisitorsClassContext.QUALIFIED_ENV_NAME.equals(operation.getName())
				&& operation.getOwnedParameters().size() == 0;
	}
	
	/**
	 * Convert  'Element'::_qualified_env() : Environment 
	 * to XXXXXQualifiedLookupVisitor::visit'Element'(element : 'Element') : Environment
	 * 
	 * with
	 *   - self accessed as element.
	 *   - let env = LookupEnvironment{} in ... rewritten as let env = this.context in ...
	 *   
	 * @throws ParserException 
	 */
	@Override
	protected @NonNull Operation createVisitOperationDeclaration(
			Map<Element, Element> reDefinitions, Operation operation) {
		ExpressionInOCL envExpressionInOCL = getExpressionInOCL(operation);
		//
		org.eclipse.ocl.pivot.Class asType = ClassUtil.nonNullState(operation.getOwningClass());
		Variable asElement = PivotUtil.createVariable(LookupVisitorsClassContext.ELEMENT_NAME, asType, true, null);
		reDefinitions.put(envExpressionInOCL.getOwnedContext(), asElement);

		//rewrite LookupEnvironment ShadowExp as accessing the context variable (it might be the init of let variable)
		VariableExp asContextAccess = createThisVariableExp(asContextVariable);
		OCLExpression body = envExpressionInOCL.getOwnedBody();
		OCLExpression rewrittenExp = body instanceof ShadowExp ? body : ((LetExp)body).getOwnedVariable().getOwnedInit() ;
		reDefinitions.put(rewrittenExp, asContextAccess);
		//
		Operation asOperation = createVisitorOperation("visit" + asType.getName(), operation.getType());
		reDefinitions.put(operation, asOperation);
		return asOperation;
			

	}


}

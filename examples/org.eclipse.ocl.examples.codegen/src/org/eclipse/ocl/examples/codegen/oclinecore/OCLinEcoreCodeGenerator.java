/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.oclinecore;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * OCLinEcoreCodeGenerator supports generation of the inline OCL-defined content of a Ecore *Impl file.
 */
public class OCLinEcoreCodeGenerator extends JavaCodeGenerator
{
	public static class EcoreBoxingAnalyzer extends BoxingAnalyzer
	{
		private EcoreBoxingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		public @Nullable Object visitCGOperation(@NonNull CGOperation cgOperation) {
			super.visitCGOperation(cgOperation);
			rewriteAsUnboxed(cgOperation.getBody());
			return null;
		}

		@Override
		public @Nullable Object visitCGProperty(@NonNull CGProperty cgProperty) {
			super.visitCGProperty(cgProperty);
			rewriteAsUnboxed(cgProperty.getBody());
			return null;
		}
	}

	public static class EcoreCG2JavaPreVisitor extends CG2JavaPreVisitor
	{
		public EcoreCG2JavaPreVisitor(@NonNull JavaGlobalContext<? extends JavaCodeGenerator> javaContext) {
			super(javaContext);
		}

/*		@Override
		public @Nullable Object visitCGConstraint(@NonNull CGConstraint cgConstraint) {
			localContext = context.getLocalContext(cgConstraint);
			try {
				CGValuedElement evaluatorVariable = installEvaluatorVariable(cgConstraint);
//				cgConstraint.getBody().getOwns().add(evaluatorVariable);
			}
			finally {
				localContext = null;
			}
			return super.visitCGConstraint(cgConstraint);
		} */
	}

	public static class EcoreFieldingAnalyzer extends FieldingAnalyzer
	{
		private EcoreFieldingAnalyzer(@NonNull CodeGenAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<CGVariable> caughtVariables) {
			return new EcoreRewriteVisitor(analyzer, caughtVariables);
		}
	}

	public static class EcoreRewriteVisitor extends FieldingAnalyzer.RewriteVisitor
	{
		EcoreRewriteVisitor(@NonNull CodeGenAnalyzer context, @NonNull Set<CGVariable> caughtVariables) {
			super(context, caughtVariables);
		}
		
		@Override
		public @NonNull Boolean visitCGConstraint(@NonNull CGConstraint cgConstraint) {
//			rewriteAsCaught(cgConstraint.getBody());
				String name = cgConstraint.getName();
				System.out.println("visitCGConstraint " + name);
				if ("validateCompatibleReturn".equals(name)) {
					System.out.println("Got it");
				}
			return super.visitCGConstraint(cgConstraint);
		}
	}	

	public static void generatePackage(@NonNull GenPackage genPackage,
			@NonNull Map<String, String> uri2body, @NonNull Map<GenPackage, String> constantsTexts) {
		Resource genResource = ClassUtil.nonNullState(genPackage.eResource());
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(genResource);
		OCLinEcoreCodeGenerator generator = new OCLinEcoreCodeGenerator(environmentFactory, genPackage);
		generator.generate(uri2body, constantsTexts);
	}

	protected final @NonNull OCLinEcoreGlobalContext globalContext;
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull GenPackage genPackage;
	
	protected OCLinEcoreCodeGenerator(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull GenPackage genPackage) {
		super(environmentFactory);
		GenModel genModel = ClassUtil.nonNullModel(genPackage.getGenModel());
		genModel.reconcile();
		metamodelManager.addGenModel(genModel);
		getOptions().setUseNullAnnotations(OCLinEcoreGenModelGeneratorAdapter.useNullAnnotations(genModel));
		this.cgAnalyzer = new CodeGenAnalyzer(this);
		this.genPackage = genPackage;
		this.globalContext = new OCLinEcoreGlobalContext(this, genPackage);
//		CommonSubexpressionEliminator.CSE_BUILD.setState(true);
//		CommonSubexpressionEliminator.CSE_PLACES.setState(true);
//		CommonSubexpressionEliminator.CSE_PRUNE.setState(true);
//		CommonSubexpressionEliminator.CSE_PULL_UP.setState(true);
//		CommonSubexpressionEliminator.CSE_PUSH_UP.setState(true);
//		CommonSubexpressionEliminator.CSE_REWRITE.setState(true);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new EcoreBoxingAnalyzer(cgAnalyzer);
	}

	@Override
	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new EcoreCG2JavaPreVisitor(getGlobalContext());
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new EcoreFieldingAnalyzer(cgAnalyzer);
	}

	protected void generate(@NonNull Map<String, String> uri2body, @NonNull Map<GenPackage, String> constantsTexts) {
		EPackage ecorePackage = genPackage.getEcorePackage();
		org.eclipse.ocl.pivot.Package asPackage = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Package.class, ecorePackage);
		assert asPackage != null;
		AS2CGVisitor as2cgVisitor = new OCLinEcoreAS2CGVisitor(cgAnalyzer, globalContext);
		CGPackage cgPackage = (CGPackage) ClassUtil.nonNullState(asPackage.accept(as2cgVisitor));
		optimize(cgPackage);
		OCLinEcoreCG2JavaVisitor cg2java = new OCLinEcoreCG2JavaVisitor(this, genPackage, cgPackage);
		Map<String, String> results = cg2java.generateBodies();
		for (Map.Entry<String, String> entry : results.entrySet()) {
			uri2body.put(entry.getKey(), entry.getValue());
		}
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		String constantsText = cg2java.generateConstants(sortedGlobals);
		constantsTexts.put(genPackage, constantsText);
	}

	@Override
	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}

	@Override
	public @NonNull OCLinEcoreGlobalContext getGlobalContext() {
		return globalContext;
	}
}

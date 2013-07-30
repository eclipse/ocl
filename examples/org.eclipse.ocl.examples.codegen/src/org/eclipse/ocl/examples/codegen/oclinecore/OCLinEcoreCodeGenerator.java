/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.ocl.examples.codegen.oclinecore;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

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
			rewriteAsCaught(cgConstraint.getBody());
			return true;
		}
	}	

	protected final @NonNull CodeGenAnalyzer cgAnalyzer;
	protected final @NonNull GenPackage genPackage;
	protected final @NonNull OCLinEcoreCG2JavaVisitor generator;
	protected final @NonNull CGPackage cgPackage;

	public OCLinEcoreCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull GenPackage genPackage) {
		super(metaModelManager);
		GenModel genModel = DomainUtil.nonNullModel(genPackage.getGenModel());
		metaModelManager.addGenModel(genModel);
		getOptions().setUseNullAnnotations(OCLinEcoreGenModelGeneratorAdapter.useNullAnnotations(genModel));
		cgAnalyzer = new CodeGenAnalyzer(this);
		this.genPackage = genPackage;
		this.generator = new OCLinEcoreCG2JavaVisitor(this, genPackage);
		this.cgPackage = generator.generate();
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new EcoreBoxingAnalyzer(cgAnalyzer);
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new EcoreFieldingAnalyzer(cgAnalyzer);
	}

/*	@Override
	protected @NonNull CodeGenSnippet createEvaluatorSnippet(@NonNull CodeGenSnippet referringSnippet) {
		final CodeGenSnippet snippet = new JavaSnippet(getEvaluatorName(), TypeId.OCL_ANY, DomainEvaluator.class, this, "",
			CodeGenSnippet.NON_NULL | CodeGenSnippet.SYNTHESIZED);
		referringSnippet.addDependsOn(snippet);
		addDependency(CodeGenerator.LOCAL_ROOT, snippet);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.append("new ");
				text.appendClassReference(EcoreExecutorManager.class);
				text.append("(");
				text.appendReferenceTo(null, getSelfSnippet(snippet));
				text.append(", ");
				text.appendClassReference(PivotTables.class);		// FIXME
				text.append(".LIBRARY)");
			}
		});
	}

	@Override
	protected @NonNull CodeGenSnippet createSelfSnippet() {
		CodeGenSnippet snippet = new JavaSnippet(getSelfName(), TypeId.OCL_ANY, Object.class, this, "",
			CodeGenSnippet.NON_NULL | CodeGenSnippet.SYNTHESIZED);
//			System.out.println("selfSnippet " + DomainUtil.debugSimpleName(selfSnippet2));
		setSnippet(expression.getContextVariable(), snippet);
		return snippet.appendText("", new AbstractTextAppender()
		{			
			@Override
			public void appendToBody(@NonNull CodeGenText text) {
				text.append("this");
			}
		});
	}*/

	@Override
	protected @NonNull JavaGlobalContext createGlobalContext() {
		return new OCLinEcoreGlobalContext(this, genPackage);
	}

	public @NonNull Map<String, String> generateBodies() {
		return generator.generateBodies();
	}

	public @NonNull String generateConstants() {
		return generator.generateConstants();
	}

/*	public @NonNull String generateClassFile(String packageName, String className) {
		CG2JavaClassVisitor generator = CG2JavaClassVisitor.generate(this, expInOcl, packageName, className);
		Set<String> allImports = generator.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
	} */

/*	protected void generateClassBodies() {
		EClassifier eClassifier = DomainUtil.nonNullEMF(genClassifier.getEcoreClassifier());
		String selfClassName = DomainUtil.nonNullEMF(genClassifier.getRawInstanceClassName());
		org.eclipse.ocl.examples.pivot.Class pivotClass = metaModelManager.getPivotOfEcore(org.eclipse.ocl.examples.pivot.Class.class, eClassifier);
		assert pivotClass != null;
		//
		//	Unused globals -- FIXME delete
		//
		CodeGenSnippet globalRoot = createCodeGenSnippet("", CodeGenSnippet.GLOBAL | CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		getSnippetLabel(GLOBAL_ROOT).push(globalRoot);
		//
		//	Class invariants
		//
		List<Constraint> ownedRules = new ArrayList<Constraint>(pivotClass.getOwnedRule());
		Collections.sort(ownedRules, nameComparator);
		for (Constraint aRule : ownedRules) {
			constraint = aRule;
			specification = aRule.getSpecification();
			expression = PivotUtil.getExpressionInOCL(pivotClass, DomainUtil.nonNullModel(specification));
			if ((expression != null) && (expression.getContextVariable() != null)) {
				@SuppressWarnings("null")@NonNull String booleanName = Boolean.class.getName();
				String body = generateExpressionBody(null, selfClassName, booleanName);
				String fragmentURI = getFragmentURI(pivotClass) + "==" + getRuleName(aRule);
				bodies.put(fragmentURI, body);
			}
		}
		//
		//	Operation bodies
		//
		List<Operation> ownedOperations = new ArrayList<Operation>(PivotQueries.getOperations(pivotClass));
		Collections.sort(ownedOperations, nameComparator);
		for (@SuppressWarnings("null")@NonNull Operation anOperation : ownedOperations) {
			for (Constraint aRule : anOperation.getOwnedRule()) {
				constraint = aRule;
				specification = aRule.getSpecification();
				expression = PivotUtil.getExpressionInOCL(anOperation, DomainUtil.nonNullModel(specification));
				if ((expression != null) && (expression.getContextVariable() != null)) {
					String returnClassName;
					try {
						returnClassName = genModelHelper.getOperationReturnType(anOperation);
					} catch (GenModelException e) {
						returnClassName = "Object";		// FIXME
					}
					String body = generateExpressionBody(anOperation, selfClassName, returnClassName);
					String fragmentURI = getFragmentURI(anOperation);
					bodies.put(fragmentURI, body);
				}
			}
		}
		//
		//	Property bodies
		//
		List<Property> ownedProperties = new ArrayList<Property>(PivotQueries.getProperties(pivotClass));
		Collections.sort(ownedProperties, nameComparator);
		for (@SuppressWarnings("null")@NonNull Property aProperty : ownedProperties) {
			for (Constraint  aRule : aProperty.getOwnedRule()) {
				constraint = aRule;
				specification = aRule.getSpecification();
				expression = PivotUtil.getExpressionInOCL(aProperty, DomainUtil.nonNullModel(specification));
				if ((expression != null) && (expression.getContextVariable() != null)) {
					String returnClassName;
					try {
						returnClassName = genModelHelper.getPropertyResultType(aProperty);
					} catch (GenModelException e) {
						returnClassName = "Object";		// FIXME
					}
					String body = generateExpressionBody(aProperty, selfClassName, returnClassName);
					String fragmentURI = getFragmentURI(aProperty);
					bodies.put(fragmentURI, body);
				}
			}
		}
	}

	protected String generateExpressionBody(@Nullable Feature feature, @NonNull String className, @NonNull String returnClassName) {
		boolean isRequired = (feature == null) || feature.isRequired();
//		String returnClass = feature != null ? className : Boolean.class.getSimpleName();
		CodeGenSnippet snippet = createCodeGenSnippet("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		//
		// Start with a comment containing the OCL
		//
		CodeGenText oclComment = snippet.appendIndentedText("");
		ExpressionInOCL expression2 = DomainUtil.nonNullState(expression);
		oclComment.appendCommentWithOCL(null, expression2);
		//
		//	The a placeholding scope for the local variables
		//
		CodeGenSnippet scopeSnippet = push();
		snippet.appendContentsOf(scopeSnippet);
		//
		//	Reserve parameter names
		//
		if (feature == null) {
			nameManager.reserveName("diagnostics", null);
			nameManager.reserveName("context", null);
		}
		CodeGenAnalysis rootAnalysis = cgAnalyzer.analyze(expression2, isRequired);
		cgAnalyzer.optimize(rootAnalysis);
		//
		OCLExpression bodyExpression = DomainUtil.nonNullModel(expression2.getBodyExpression());
		if (feature == null) {
			getAnalysis(bodyExpression).setCatching();
		}
		//
		//	Reserve result name
		//
//		CodeGenAnalysis bodyAnalysis = getAnalysis(bodyExpression);
//		if (!bodyAnalysis.isConstant()) {
//			nameManager.getSymbolName(bodyExpression, "result");
//		}
		//
		//	"evaluate" function declaration
		//
		CodeGenSnippet evaluateSnippet = snippet.appendIndentedNodes("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenSnippet evaluateNodes = evaluateSnippet.appendIndentedNodes("", CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
		CodeGenSnippet evaluateBodySnippet = evaluateNodes.appendUnboxedGuardedChild(bodyExpression, isRequired && (feature != null) ? DomainMessage.NULL : null, null);
		if (evaluateBodySnippet != null) {
			if (!evaluateBodySnippet.isInvalid()) {
				if (feature == null) {
					String validatorClass = genModelHelper.getQualifiedValidatorClassName(genPackage);
					boolean isConstant = evaluateBodySnippet.isConstant();
					if (isConstant && (evaluateBodySnippet.getConstantValue() == Boolean.TRUE)) {
						evaluateNodes.append("return true;\n");
					}
					else {
						if (!isConstant) {
							CodeGenText ifOkText = evaluateNodes.append("if (");
						    ifOkText.appendReferenceTo(null, evaluateBodySnippet);
						    ifOkText.append(" == ");
						    ifOkText.appendReferenceTo(null, getSnippet(true));
						    ifOkText.append(") {\n");
								CodeGenSnippet returnNodes = evaluateNodes.appendIndentedNodes(null, CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
								returnNodes.append("return true;\n");
						    evaluateNodes.append("}\n");
						}
					    evaluateNodes.append("if (diagnostics != null) {\n");
							String constraintName = constraint.getName();
							String genClassifierName = genClassifier.getName();
							if (genClassifierName == null) {
								genClassifierName = "";
							}
							String constraintLiteralName = CodeGenUtil.upperName(genClassifierName) + "__" + CodeGenUtil.upperName(constraintName != null ? constraintName : "");
							String severityName = nameManager.reserveName("severity", null);
							String messageName = nameManager.reserveName("message", null);
							CodeGenSnippet diagsNodes = evaluateNodes.appendIndentedNodes(null, CodeGenSnippet.LIVE | CodeGenSnippet.UNASSIGNED);
							CodeGenText severityText = diagsNodes.append("int " + severityName + " = ");
							if (evaluateBodySnippet.isNull()) {
								severityText.appendClassReference(Diagnostic.class);
								severityText.append(".ERROR");
							}
							else if (evaluateBodySnippet.isNonNull()) {
								severityText.appendClassReference(Diagnostic.class);
								severityText.append(".WARNING");
							}
							else {
								severityText.appendReferenceTo(null, evaluateBodySnippet);
								severityText.append(" == null ? ");
								severityText.appendClassReference(Diagnostic.class);
								severityText.append(".ERROR : ");
								severityText.appendClassReference(Diagnostic.class);
								severityText.append(".WARNING");
							}
							severityText.append(";\n");
							CodeGenText messageText = diagsNodes.append("String " + messageName + " = ");
							messageText.appendClassReference(NLS.class);
							messageText.append(".bind(");
							messageText.appendClassReference(EvaluatorMessages.class);
							messageText.append(".ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"");
							messageText.append(genClassifierName);
							messageText.append("\", \"");
							messageText.append(constraintName!= null ? constraintName : "UnnamedConstraint");
							messageText.append("\", ");
							messageText.appendClassReference(EObjectValidator.class);
							messageText.append(".getObjectLabel(this, context)});\n");
							CodeGenText addText = diagsNodes.append("diagnostics.add(new ");
							addText.appendClassReference(BasicDiagnostic.class);
							addText.append("(" + severityName + ", ");
							addText.appendClassReference(validatorClass);
							addText.append(".DIAGNOSTIC_SOURCE, ");
							addText.appendClassReference(validatorClass);
							addText.append("." + constraintLiteralName + ", " + messageName + ", new Object [] { this }));\n");
					    evaluateNodes.append("}\n");
					    evaluateNodes.append("return false;\n");
					}
				}
				else  {
				    CodeGenText returnText = evaluateNodes.append("return ");
				    String suffix = null;
				    String bodyTypeName = evaluateBodySnippet.getJavaClassName();
					if (!returnClassName.equals(bodyTypeName)) {
						if ("boolean".equals(returnClassName)) {
							suffix = ".booleanValue()";
						}
						else if ("double".equals(returnClassName)) {
							suffix = ".doubleValue()";
						}
						else if ("float".equals(returnClassName)) {
							suffix = ".floatValue()";
						}
						else if ("int".equals(returnClassName)) {
							suffix = ".intValue()";
						}
						else if ("long".equals(returnClassName)) {
							suffix = ".longValue()";
						}
						else if ("short".equals(returnClassName)) {
							suffix = ".shortValue()";
						}
						else {
							returnText.append("(");
							returnText.appendClassReference(returnClassName);
							returnText.append(")");
						}
					}
					returnText.appendReferenceTo(null, evaluateBodySnippet);
					if (suffix != null) {
						returnText.append(suffix);
					}
					returnText.append(";\n");
				}
			}
			else if (!evaluateBodySnippet.isCaught() && !evaluateBodySnippet.isInline()) {
				/* Already thrown * /
			}
			else {
			    CodeGenText returnText = evaluateNodes.append("throw ");
				returnText.appendReferenceTo(Exception.class, evaluateBodySnippet);
				returnText.append(";\n");
			}
		}

		
		activateGuards(rootAnalysis);
		pop();
		Set<CodeGenSnippet> liveSnippets = new HashSet<CodeGenSnippet>();
		Set<String> referencedClasses = new HashSet<String>();
		snippet.gatherLiveSnippets(liveSnippets, referencedClasses);
		LinkedHashMap<CodeGenText, String> flatContents = snippet.flatten();
		StringBuilder s = new StringBuilder();
		for (Map.Entry<CodeGenText, String> entry : flatContents.entrySet()) {
			CodeGenText key = entry.getKey();
			if (!key.getSnippet().isGlobal()) {		// Global goes in Constants file
				@SuppressWarnings("null")@NonNull String value = entry.getValue();
				key.toString(s, value);
			}
		}
		String javaCodeSource = s.toString();
		return javaCodeSource;
	}

	public @NonNull CodeGenAnalysis getAnalysis(@NonNull Element element) {
		return cgAnalyzer.getAnalysis(element);
	} */

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}

/*	@Override
	public @NonNull String getConstantsClass() {
		return constantsClassName;
	} */

/*	protected String getRuleName(@NonNull Constraint constraint) {
		String name = constraint.getName();
		return name != null ? name : "";
	}

	@Override
	public @NonNull String getSelfName() {
		return "self";
	} */
}

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
package org.eclipse.ocl.examples.codegen.oclinjunit;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaGlobalContext;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * JUnitCodeGenerator supports generation of an ExpressionInOCL for execution in a JUNit test.
 * The ExpressionInOCL is wrpapped in an Operation in a Class with a static INSTANCE to provide
 * the polymorphic implementation of a LibraryOperation.
 */
public class JUnitCodeGenerator extends JavaCodeGenerator
{
	public static @NonNull String generateClassFile(@NonNull MetaModelManager metaModelManager, @NonNull ExpressionInOCL query,
			@NonNull String packageName, @NonNull String className) {
		JUnitCodeGenerator expressionInOCL2Class = new JUnitCodeGenerator(metaModelManager, true);
		return expressionInOCL2Class.generate(query, packageName, className);
	}
	
	protected final @NonNull JavaGlobalContext<JUnitCodeGenerator> globalContext = new JavaGlobalContext<JUnitCodeGenerator>(this);
	protected final @NonNull CodeGenAnalyzer cgAnalyzer;

	protected JUnitCodeGenerator(@NonNull MetaModelManager metaModelManager, boolean useNullAnnotations) {
		super(metaModelManager);
		getOptions().setUseNullAnnotations(useNullAnnotations);
		cgAnalyzer = new CodeGenAnalyzer(this);
	}

	protected @NonNull CGPackage createCGPackage(@NonNull ExpressionInOCL expInOcl,
			@NonNull String packageName, @NonNull String className) {
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packageName);
		//
		CGClass cgClass = CGModelFactory.eINSTANCE.createCGClass();
		cgClass.setName(className);
		cgPackage.getClasses().add(cgClass);
		//
		Variable contextVariable = expInOcl.getContextVariable();
		if (contextVariable != null) {
			contextVariable.setIsRequired(false); // May be null for test
		}
		AS2CGVisitor as2cgVisitor = new JUnitAS2CGVisitor(cgAnalyzer);
		CGValuedElement cgBody = (CGValuedElement) DomainUtil.nonNullState(expInOcl.accept(as2cgVisitor));
		CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGLibraryOperation();
		List<CGParameter> cgParameters = cgOperation.getParameters();
		JavaLocalContext<?> localContext = globalContext.getLocalContext(cgOperation);
		if (localContext != null) {
			CGParameter evaluatorParameter = localContext.createEvaluatorParameter();
			if (evaluatorParameter != null) {
				cgParameters.add(evaluatorParameter);
			}
			CGParameter typeIdParameter = localContext.createTypeIdParameter();
			if (typeIdParameter != null) {
				cgParameters.add(typeIdParameter);
			}
		}
		if (contextVariable != null) {
			CGParameter cgContext = as2cgVisitor.getParameter(contextVariable);
			cgParameters.add(cgContext);
		}
		for (@SuppressWarnings("null")@NonNull Variable parameterVariable : expInOcl.getParameterVariable()) {
			CGParameter cgParameter = as2cgVisitor.getParameter(parameterVariable);
			cgParameters.add(cgParameter);
		}
		cgOperation.setAst(expInOcl);
		TypeId asTypeId = expInOcl.getTypeId();
		cgOperation.setTypeId(cgAnalyzer.getTypeId(asTypeId));
		cgOperation.setName(globalContext.getEvaluateName());
		cgOperation.setBody(cgBody);
		cgClass.getOperations().add(cgOperation);
		return cgPackage;
	}

	protected @NonNull String generate(@NonNull ExpressionInOCL expInOcl, @NonNull String packageName, @NonNull String className) {
		CGPackage cgPackage = createCGPackage(expInOcl, packageName, className);
		optimize(cgPackage);
		List<CGValuedElement> sortedGlobals = prepareGlobals();
		JUnitCG2JavaClassVisitor cg2JavaClassVisitor = new JUnitCG2JavaClassVisitor(this, expInOcl, sortedGlobals);
		cg2JavaClassVisitor.safeVisit(cgPackage);
		Set<String> allImports = cg2JavaClassVisitor.getAllImports();
		Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
		return ImportUtils.resolveImports(cg2JavaClassVisitor.toString(), long2ShortImportNames);
	}

	@Override
	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}

	@Override
	public @NonNull JavaGlobalContext<JUnitCodeGenerator> getGlobalContext() {
		return globalContext;
	}
}

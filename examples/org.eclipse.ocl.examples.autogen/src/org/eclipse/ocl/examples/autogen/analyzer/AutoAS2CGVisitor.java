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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.autogen.java.AutoGlobalContext;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;

public final class AutoAS2CGVisitor extends AS2CGVisitor
{
	protected final @NonNull AutoAnalyzer analyzer;
	protected final @NonNull AutoGlobalContext<?> globalContext;
	
	public AutoAS2CGVisitor(@NonNull AutoAnalyzer analyzer, @NonNull AutoGlobalContext<?> globalContext) {
		super(analyzer);
		this.analyzer = analyzer;
		this.globalContext = globalContext;
	}

	@Override
	public @NonNull
	CGValuedElement visitOperationCallExp(@NonNull OperationCallExp element) {
		Operation asOperation = DomainUtil.nonNullState(element.getReferredOperation());
		if ("ast".equals(asOperation.getName())) {
			OCLExpression pSource = element.getSource();
			CGValuedElement cgSource = pSource != null ? doVisit(CGValuedElement.class, pSource) : null;
			CGASTCallExp cgASTCallExp = AutoCGModelFactory.eINSTANCE.createCGASTCallExp();
			cgASTCallExp.setSource(cgSource);
			setAst(cgASTCallExp, element);
			return  cgASTCallExp;
		}
		return super.visitOperationCallExp(element);
	}
}

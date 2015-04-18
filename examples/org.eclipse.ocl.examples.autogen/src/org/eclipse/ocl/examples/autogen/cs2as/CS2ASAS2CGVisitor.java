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
package org.eclipse.ocl.examples.autogen.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.analyzer.AutoAnalyzer;
import org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelFactory;
import org.eclipse.ocl.examples.autogen.autocgmodel.CGASTCallExp;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class CS2ASAS2CGVisitor extends AS2CGVisitor
{
	public CS2ASAS2CGVisitor(@NonNull AutoAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	protected @NonNull CGValuedElement generateOperationCallExp(@Nullable CGValuedElement cgSource, @NonNull OperationCallExp element) {
		Operation asOperation = ClassUtil.nonNullState(element.getReferredOperation());
		if ("ast".equals(asOperation.getName())) {
			CGASTCallExp cgASTCallExp = AutoCGModelFactory.eINSTANCE.createCGASTCallExp();
			cgASTCallExp.setSource(cgSource);
			setAst(cgASTCallExp, element);
			return  cgASTCallExp;
		}
		return super.generateOperationCallExp(cgSource, element);
	}
}

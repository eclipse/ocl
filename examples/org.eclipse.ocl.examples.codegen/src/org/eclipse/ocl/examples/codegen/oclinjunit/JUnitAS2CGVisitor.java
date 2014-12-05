/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.oclinjunit;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Variable;

/**
 * @since 1.3
 */
public final class JUnitAS2CGVisitor extends AS2CGVisitor
{
	public JUnitAS2CGVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	public @NonNull CGValuedElement visitExpressionInOCL(@NonNull ExpressionInOCL element) {
		Variable contextVariable = element.getContextVariable();
		if (contextVariable != null) {
			CGVariable cgContext = getParameter(contextVariable);
			cgContext.setTypeId(context.getTypeId(TypeId.OCL_VOID));			// FIXME Java-specific
			cgContext.setNonInvalid();
//			cgContext.setNonNull();
		}
		for (@SuppressWarnings("null")@NonNull Variable parameterVariable : element.getParameterVariable()) {
			@SuppressWarnings("unused") CGVariable cgParameter = getParameter(parameterVariable);
		}
		CGValuedElement cgBody = doVisit(CGValuedElement.class, element.getBodyExpression());
//		cgOperation.getDependsOn().add(cgBody);
		return cgBody;
	}
}

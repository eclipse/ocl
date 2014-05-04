/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;


/**
 * The Class OCLTracingEvaluationVisitor is a decorator visitor that prints
 * AST, variable values and other information useful for debugging.
 * 
 * @author Horacio Hoyos
 */
public class OCLTracingEvaluationVisitor extends OCLAbstractTracingEvaluationVisitor
{
	
	/** The Constant DEFAULT_INDENT. */
	protected static final String DEFAULT_INDENT = "  ";
	
	static int VERBOSE_LEVEL_LOW = 0;
	static int VERBOSE_LEVEL_MED = 1;
	static int VERBOSE_LEVEL_HIGH = 2;
	
	
	/** The indent level. */
	private int indentLevel = 0;
	

	/**
	 * Instantiates a new OCL tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 */
	public OCLTracingEvaluationVisitor(@NonNull IOCLVMEvaluationVisitor decorated) {
		
		this(decorated, 0);
	}
	
	/**
	 * Instantiates a new OCL tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 * @param indentLevel the indent level
	 */
	protected OCLTracingEvaluationVisitor(@NonNull IOCLVMEvaluationVisitor decorated, int indentLevel) {
		
		super(decorated);
		this.indentLevel = indentLevel;
	}
	
	@Override
	public @NonNull IOCLVMEvaluationVisitor createNestedEvaluator() {
		
		return new OCLTracingEvaluationVisitor(super.createNestedEvaluator(), indentLevel);
	}
}

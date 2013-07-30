/**
 * <copyright>
 * 
 * Copyright (c) 2012,2013 CEA LIST and others.
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
package org.eclipse.ocl.examples.codegen.cse;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.CodeGenConstants;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.common.utils.TracingOption;

/**
 * A CommonSubExpressionEliminator annotates the structurally equivalent analysis nodes in an analyzed tree with CommonSubExpression instances that
 * unify and potentially hoist their computations.
 */
public class CommonSubexpressionEliminator
{	
	public static final @NonNull TracingOption CSE_PLACES = new TracingOption(CodeGenConstants.PLUGIN_ID, "cse/places");
	public static final @NonNull TracingOption CSE_PRUNE = new TracingOption(CodeGenConstants.PLUGIN_ID, "cse/prune");
	public static final @NonNull TracingOption CSE_PULL_UP = new TracingOption(CodeGenConstants.PLUGIN_ID, "cse/pullUp");
	public static final @NonNull TracingOption CSE_PUSH_UP = new TracingOption(CodeGenConstants.PLUGIN_ID, "cse/pushUp");
	public static final @NonNull TracingOption CSE_REWRITE = new TracingOption(CodeGenConstants.PLUGIN_ID, "cse/rewrite");

	
	protected final @NonNull CodeGenAnalyzer analyzer;
	
	public CommonSubexpressionEliminator(@NonNull CodeGenAnalyzer analyzer) {
		this.analyzer = analyzer;
	}

	public @NonNull CodeGenAnalyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * Optimize the cgRoot tree by eliminating common subexpressions.
	 */
	public void optimize(@NonNull CGElement cgRoot) {
		GlobalPlace globalPlace = new GlobalPlace(analyzer);
		globalPlace.optimize(cgRoot);
	}
}

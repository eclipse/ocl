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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.Element;

public class OCLVMNestedEvaluationVisitor extends OCLVMEvaluationVisitor
{
	protected final @NonNull OCLVMRootEvaluationVisitor root;
	protected final @NonNull OCLVMEvaluationVisitor parent;
	protected final int depth;
	
	protected OCLVMNestedEvaluationVisitor(@NonNull OCLVMEvaluationVisitor parent, @NonNull IOCLVMEvaluationVisitor nestedEvaluationVisitor) {
		super(nestedEvaluationVisitor);
		this.root = parent.getRootEvaluationVisitor();
		this.parent = parent;
		this.depth = parent.getDepth() + 1;
		root.pushVisitor(this);
	}

	@Override
	protected @Nullable Object badVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv,
			@NonNull Element element, Object preState, @NonNull Throwable e) {
		return root.badVisit(evalEnv, element, preState, e);
	}

	public void dispose() {
		root.popVisitor(this);
	}

	public int getDepth() {
		return depth;
	}

	public @NonNull OCLVMRootEvaluationVisitor getRootEvaluationVisitor() {
		return root;
	}

	protected void postVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element, @Nullable Object result) {
		root.postVisit(evalEnv, element, result);
	}

	protected @Nullable Element preVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element) {
		return root.preVisit(evalEnv, element);
	}
}

/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.namereso;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody;
import org.eclipse.ocl.examples.autogen.nameresocgmodel.util.NameResoCGModelVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;

/**
 * The ReferencesVisitor compute a list of objects referenced by (but not contained by or containing) the visited object
 * that contribute to that objects identity. The computed list may contain null elements to ensure that the returned lists
 * by two different objects exhibit positioanl equivalence.
 */
public class AutoLookupReferencesVisitor extends ReferencesVisitor implements NameResoCGModelVisitor<List<Object>>
{
	public static final @NonNull AutoLookupReferencesVisitor INSTANCE = new AutoLookupReferencesVisitor(new Object());
	
	protected AutoLookupReferencesVisitor(@NonNull Object context) {
		super(context);
	}

	@Nullable
	public List<Object> visitCGAddCall(@NonNull CGAddCall object) {
		return visitCGOperationCallExp(object);
	}

	@Nullable
	public List<Object> visitCGEnvVisitIfPart(@NonNull CGEnvVisitIfPart object) {
		return visitCGValuedElement(object);
	}

	@Nullable
	public List<Object> visitCGEnvVisitOp(@NonNull CGEnvVisitOp object) {
		return visitCGOperation(object);
	}

	@Nullable
	public List<Object> visitCGEnvVisitOpBody(@NonNull CGEnvVisitOpBody object) {
		return visitCGValuedElement(object);
	}
}
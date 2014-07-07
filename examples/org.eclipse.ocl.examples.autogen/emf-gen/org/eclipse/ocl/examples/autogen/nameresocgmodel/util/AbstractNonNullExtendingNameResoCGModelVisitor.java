/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2014 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Adolfo Sanchez-Barbudo Herrera (Univerisity of York) - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.autogen/model/nameresocgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.autogen.nameresocgmodel.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingNonNullNameResoCGModelVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 * The return in annotated as @NonNull.
 */
public abstract class AbstractNonNullExtendingNameResoCGModelVisitor<R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractNonNullExtendingCGModelVisitor<R, C>
	implements NameResoCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNonNullExtendingNameResoCGModelVisitor(@NonNull C context) {
		super(context);
	}	

	public @NonNull R visitCGAddCall(@NonNull org.eclipse.ocl.examples.autogen.nameresocgmodel.CGAddCall object) {
		return visitCGOperationCallExp(object);
	}

	public @NonNull R visitCGEnvVisitIfPart(@NonNull org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitIfPart object) {
		return visitCGValuedElement(object);
	}

	public @NonNull R visitCGEnvVisitOp(@NonNull org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOp object) {
		return visitCGOperation(object);
	}

	public @NonNull R visitCGEnvVisitOpBody(@NonNull org.eclipse.ocl.examples.autogen.nameresocgmodel.CGEnvVisitOpBody object) {
		return visitCGValuedElement(object);
	}
}

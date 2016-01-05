/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.autogen/model/autocgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.autogen.autocgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullAutoCGModelVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.  
 */
 @Deprecated
public abstract class AbstractNullAutoCGModelVisitor<@Nullable R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractNullCGModelVisitor<R, C> implements AutoCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullAutoCGModelVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitCGASTCallExp(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGASTCallExp object) {
		return null;
	}

	@Override
	public R visitCGContainmentBody(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGContainmentBody object) {
		return null;
	}

	@Override
	public R visitCGContainmentPart(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGContainmentPart object) {
		return null;
	}

	@Override
	public R visitCGContainmentVisit(org.eclipse.ocl.examples.autogen.autocgmodel.@NonNull CGContainmentVisit object) {
		return null;
	}
}

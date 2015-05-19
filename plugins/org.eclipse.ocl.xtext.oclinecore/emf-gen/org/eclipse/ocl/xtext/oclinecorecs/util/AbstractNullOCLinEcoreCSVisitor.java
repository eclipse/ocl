/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullOCLinEcoreCSVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullOCLinEcoreCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractNullEssentialOCLCSVisitor<R, C> implements OCLinEcoreCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullOCLinEcoreCSVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS object) {
		return null;
	}

	@Override
	public @Nullable R visitSysMLCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.SysMLCS object) {
		return null;
	}

	@Override
	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS object) {
		return null;
	}
}

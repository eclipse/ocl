/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingOCLinEcoreCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingOCLinEcoreCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements OCLinEcoreCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingOCLinEcoreCSVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS object) {
		return visitConstraintCS(object);
	}

	@Override
	public @Nullable R visitSysMLCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS object) {
		return visitAnnotationElementCS(object);
	}

	@Override
	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.TopLevelCS object) {
		return visitRootPackageCS(object);
	}
}

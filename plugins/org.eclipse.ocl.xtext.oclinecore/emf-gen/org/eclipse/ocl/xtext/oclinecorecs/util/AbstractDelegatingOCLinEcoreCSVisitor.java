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
 * from: org.eclipse.ocl.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingOCLinEcoreCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLinEcoreCSVisitor<R, C, D extends OCLinEcoreCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLinEcoreCSVisitor<R>
{
	protected AbstractDelegatingOCLinEcoreCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS object) {
		return delegate.visitOCLinEcoreConstraintCS(object);
	}

	@Override
	public @Nullable R visitSysMLCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.SysMLCS object) {
		return delegate.visitSysMLCS(object);
	}

	@Override
	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.ocl.xtext.oclinecorecs.TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}
}

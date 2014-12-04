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
 * from: org.eclipse.ocl.examples.xtext.base/model/BaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.base.basecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/*
 * An AbstractBaseCSVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R>
{
	/**
	 * Context for the AST visitation.
	 */
	protected final @NonNull C context;

	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractBaseCSVisitor(@NonNull C context) {
		this.context = context;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A> A getAdapter(@NonNull Class<A> adapter) {
		if (adapter.isAssignableFrom(getClass())) {
			return (A) this;
		}
		else {
			return null;
		}
	}
	
	/**
	 * A null-safe visitation of the specified visitable.
	 * 
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *	 otherwise, the result of visiting it
	 */
	public @Nullable R safeVisit(@Nullable org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS v) {
		return (v == null) ? null : v.accept(this);
	}
	
	/**
	 * Perform a visit to the specified visitable.
	 * 
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *	 otherwise, the result of visiting it
	 */
	public @Nullable R visit(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS v) {
		return v.accept(this);
	}

	//	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
	//		return null;
	//	}
}

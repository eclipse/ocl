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
 * from: org.eclipse.ocl.examples.xtext.oclstdlib/model/OCLstdlibCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingOCLstdlibCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLstdlibCSVisitor<R, C, D extends OCLstdlibCSVisitor<R>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLstdlibCSVisitor<R>
{
	protected AbstractDelegatingOCLstdlibCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitJavaClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS object) {
		return delegate.visitJavaClassCS(object);
	}

	@Override
	public @Nullable R visitJavaImplementationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS object) {
		return delegate.visitJavaImplementationCS(object);
	}

	@Override
	public @Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS object) {
		return delegate.visitLibClassCS(object);
	}

	@Override
	public @Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS object) {
		return delegate.visitLibConstraintCS(object);
	}

	@Override
	public @Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS object) {
		return delegate.visitLibIterationCS(object);
	}

	@Override
	public @Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS object) {
		return delegate.visitLibOperationCS(object);
	}

	@Override
	public @Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS object) {
		return delegate.visitLibPackageCS(object);
	}

	@Override
	public @Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS object) {
		return delegate.visitLibPropertyCS(object);
	}

	@Override
	public @Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS object) {
		return delegate.visitLibRootPackageCS(object);
	}

	@Override
	public @Nullable R visitMetaclassNameCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaclassNameCS object) {
		return delegate.visitMetaclassNameCS(object);
	}

	@Override
	public @Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS object) {
		return delegate.visitPrecedenceCS(object);
	}
}

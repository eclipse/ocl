/*******************************************************************************
 * Copyright (c) 2010,2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.xtext.oclstdlib/model/OCLstdlibCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingOCLstdlibCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLstdlibCSVisitor<R, C, D extends OCLstdlibCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLstdlibCSVisitor<R>
{
	protected AbstractDelegatingOCLstdlibCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitJavaClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS object) {
		return delegate.visitJavaClassCS(object);
	}

	@Override
	public @Nullable R visitJavaImplementationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS object) {
		return delegate.visitJavaImplementationCS(object);
	}

	@Override
	public @Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS object) {
		return delegate.visitLibClassCS(object);
	}

	@Override
	public @Nullable R visitLibCoercionCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS object) {
		return delegate.visitLibCoercionCS(object);
	}

	@Override
	public @Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS object) {
		return delegate.visitLibConstraintCS(object);
	}

	@Override
	public @Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS object) {
		return delegate.visitLibIterationCS(object);
	}

	@Override
	public @Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS object) {
		return delegate.visitLibOperationCS(object);
	}

	@Override
	public @Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS object) {
		return delegate.visitLibPackageCS(object);
	}

	@Override
	public @Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS object) {
		return delegate.visitLibPropertyCS(object);
	}

	@Override
	public @Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS object) {
		return delegate.visitLibRootPackageCS(object);
	}

	@Override
	public @Nullable R visitMetaclassNameCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS object) {
		return delegate.visitMetaclassNameCS(object);
	}

	@Override
	public @Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS object) {
		return delegate.visitPrecedenceCS(object);
	}
}

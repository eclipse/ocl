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
 * from: org.eclipse.ocl.xtext.oclstdlib/model/OCLstdlibCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullOCLstdlibCSVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullOCLstdlibCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractNullEssentialOCLCSVisitor<R, C> implements OCLstdlibCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullOCLstdlibCSVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitJavaClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS object) {
		return null;
	}

	@Override
	public @Nullable R visitJavaImplementationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibCoercionCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS object) {
		return null;
	}

	@Override
	public @Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS object) {
		return null;
	}

	@Override
	public @Nullable R visitMetaclassNameCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS object) {
		return null;
	}

	@Override
	public @Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS object) {
		return null;
	}
}

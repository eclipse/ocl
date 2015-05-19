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
 * An AbstractExtendingOCLstdlibCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingOCLstdlibCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements OCLstdlibCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingOCLstdlibCSVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitJavaClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitJavaImplementationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS object) {
		return visitStructuredClassCS(object);
	}

	@Override
	public @Nullable R visitLibCoercionCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS object) {
		return visitOperationCS(object);
	}

	@Override
	public @Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS object) {
		return visitConstraintCS(object);
	}

	@Override
	public @Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS object) {
		return visitOperationCS(object);
	}

	@Override
	public @Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS object) {
		return visitOperationCS(object);
	}

	@Override
	public @Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS object) {
		return visitPackageCS(object);
	}

	@Override
	public @Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS object) {
		return visitAttributeCS(object);
	}

	@Override
	public @Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS object) {
		return visitRootPackageCS(object);
	}

	@Override
	public @Nullable R visitMetaclassNameCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS object) {
		return visitElementCS(object);
	}

	@Override
	public @Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS object) {
		return visitNamedElementCS(object);
	}
}

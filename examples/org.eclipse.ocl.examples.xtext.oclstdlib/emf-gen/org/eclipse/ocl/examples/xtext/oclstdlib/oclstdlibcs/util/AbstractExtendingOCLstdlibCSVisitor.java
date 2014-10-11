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
 * An AbstractExtendingOCLstdlibCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingOCLstdlibCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
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

	public @Nullable R visitJavaClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS object) {
		return visitStructuredClassCS(object);
	}

	public @Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS object) {
		return visitConstraintCS(object);
	}

	public @Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS object) {
		return visitPackageCS(object);
	}

	public @Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS object) {
		return visitAttributeCS(object);
	}

	public @Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS object) {
		return visitRootPackageCS(object);
	}

	public @Nullable R visitMetaclassNameCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaclassNameCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS object) {
		return visitNamedElementCS(object);
	}
}

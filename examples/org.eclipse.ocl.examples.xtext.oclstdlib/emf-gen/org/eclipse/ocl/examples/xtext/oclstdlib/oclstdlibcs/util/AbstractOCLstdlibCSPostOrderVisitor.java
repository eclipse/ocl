/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractOCLstdlibCSPostOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractOCLstdlibCSPostOrderVisitor
	extends EssentialOCLCSPostOrderVisitor
	implements OCLstdlibCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractOCLstdlibCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitJavaClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaClassCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitJavaImplementationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.JavaImplementationCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitLibClassCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibClassCS csElement) {
		return visitStructuredClassCS(csElement);
	}

	public @Nullable Continuation<?> visitLibConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibConstraintCS csElement) {
		return visitConstraintCS(csElement);
	}

	public @Nullable Continuation<?> visitLibIterationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibIterationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Continuation<?> visitLibOperationCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Continuation<?> visitLibPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPackageCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitLibPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS csElement) {
		return visitAttributeCS(csElement);
	}

	public @Nullable Continuation<?> visitLibRootPackageCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibRootPackageCS csElement) {
		return visitRootPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitMetaclassNameCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.MetaclassNameCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPrecedenceCS(@NonNull org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS csElement) {
		return visitNamedElementCS(csElement);
	}
}

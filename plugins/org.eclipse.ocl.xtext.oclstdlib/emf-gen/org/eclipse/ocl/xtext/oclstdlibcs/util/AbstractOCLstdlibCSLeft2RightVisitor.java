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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;

/**
 * An AbstractOCLstdlibCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractOCLstdlibCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements OCLstdlibCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractOCLstdlibCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitJavaClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitJavaImplementationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS csElement) {
		return visitElementCS(csElement);
	}

	@Override
	public @Nullable Element visitLibClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS csElement) {
		return visitStructuredClassCS(csElement);
	}

	@Override
	public @Nullable Element visitLibCoercionCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS csElement) {
		return visitOperationCS(csElement);
	}

	@Override
	public @Nullable Element visitLibConstraintCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS csElement) {
		return visitConstraintCS(csElement);
	}

	@Override
	public @Nullable Element visitLibIterationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS csElement) {
		return visitOperationCS(csElement);
	}

	@Override
	public @Nullable Element visitLibOperationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS csElement) {
		return visitOperationCS(csElement);
	}

	@Override
	public @Nullable Element visitLibPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS csElement) {
		return visitPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitLibPropertyCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS csElement) {
		return visitAttributeCS(csElement);
	}

	@Override
	public @Nullable Element visitLibRootPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitMetaclassNameCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS csElement) {
		return visitElementCS(csElement);
	}

	@Override
	public @Nullable Element visitPrecedenceCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS csElement) {
		return visitNamedElementCS(csElement);
	}
}

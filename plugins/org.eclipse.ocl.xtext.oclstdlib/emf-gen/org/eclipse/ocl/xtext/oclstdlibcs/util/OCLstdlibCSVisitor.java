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
 */
public interface OCLstdlibCSVisitor<R> extends org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitJavaClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS object);
	@Nullable R visitJavaImplementationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS object);
	@Nullable R visitLibClassCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS object);
	@Nullable R visitLibCoercionCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS object);
	@Nullable R visitLibConstraintCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS object);
	@Nullable R visitLibIterationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS object);
	@Nullable R visitLibOperationCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS object);
	@Nullable R visitLibPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS object);
	@Nullable R visitLibPropertyCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS object);
	@Nullable R visitLibRootPackageCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS object);
	@Nullable R visitMetaclassNameCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS object);
	@Nullable R visitPrecedenceCS(@NonNull org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS object);
}

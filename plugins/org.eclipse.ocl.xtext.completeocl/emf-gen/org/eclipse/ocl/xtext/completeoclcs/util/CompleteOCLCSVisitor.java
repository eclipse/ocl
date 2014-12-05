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
 * from: org.eclipse.ocl.xtext.completeocl/model/CompleteOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.completeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface CompleteOCLCSVisitor<R> extends org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor<R>
{
	@Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS object);
	@Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS object);
	@Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS object);
	@Nullable R visitDefCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefCS object);
	@Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefOperationCS object);
	@Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS object);
	@Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS object);
	@Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.IncludeCS object);
	@Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS object);
	@Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS object);
	@Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS object);
	@Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS object);
	@Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS object);
}

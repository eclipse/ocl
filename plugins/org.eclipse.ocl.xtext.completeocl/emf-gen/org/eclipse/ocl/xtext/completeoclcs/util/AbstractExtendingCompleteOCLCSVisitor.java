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
 * from: org.eclipse.ocl.xtext.completeocl/model/CompleteOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.completeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingCompleteOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingCompleteOCLCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements CompleteOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingCompleteOCLCSVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	@Override
	public @Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS object) {
		return visitPathNameDeclCS(object);
	}

	@Override
	public @Nullable R visitDefCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public @Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefOperationCS object) {
		return visitDefCS(object);
	}

	@Override
	public @Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS object) {
		return visitDefCS(object);
	}

	@Override
	public @Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	@Override
	public @Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.IncludeCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public @Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS object) {
		return visitExpCS(object);
	}

	@Override
	public @Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}

	@Override
	public @Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS object) {
		return visitPathNameDeclCS(object);
	}

	@Override
	public @Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public @Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}
}

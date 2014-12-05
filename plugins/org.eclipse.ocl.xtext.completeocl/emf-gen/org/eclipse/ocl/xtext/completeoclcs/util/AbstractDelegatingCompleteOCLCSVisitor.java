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
 * An AbstractDelegatingCompleteOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingCompleteOCLCSVisitor<R, C, D extends CompleteOCLCSVisitor<R>>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements CompleteOCLCSVisitor<R>
{
	protected AbstractDelegatingCompleteOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public @Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS object) {
		return delegate.visitClassifierContextDeclCS(object);
	}

	@Override
	public @Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS object) {
		return delegate.visitCompleteOCLDocumentCS(object);
	}

	@Override
	public @Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS object) {
		return delegate.visitContextDeclCS(object);
	}

	@Override
	public @Nullable R visitDefCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefCS object) {
		return delegate.visitDefCS(object);
	}

	@Override
	public @Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefOperationCS object) {
		return delegate.visitDefOperationCS(object);
	}

	@Override
	public @Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS object) {
		return delegate.visitDefPropertyCS(object);
	}

	@Override
	public @Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS object) {
		return delegate.visitFeatureContextDeclCS(object);
	}

	@Override
	public @Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.IncludeCS object) {
		return delegate.visitIncludeCS(object);
	}

	@Override
	public @Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS object) {
		return delegate.visitOCLMessageArgCS(object);
	}

	@Override
	public @Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS object) {
		return delegate.visitOperationContextDeclCS(object);
	}

	@Override
	public @Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS object) {
		return delegate.visitPackageDeclarationCS(object);
	}

	@Override
	public @Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS object) {
		return delegate.visitPathNameDeclCS(object);
	}

	@Override
	public @Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS object) {
		return delegate.visitPropertyContextDeclCS(object);
	}
}

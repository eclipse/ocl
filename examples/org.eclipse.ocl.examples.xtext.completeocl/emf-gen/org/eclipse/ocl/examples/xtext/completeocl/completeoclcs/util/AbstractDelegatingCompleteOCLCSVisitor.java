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
 * from: org.eclipse.ocl.examples.xtext.completeocl/model/CompleteOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingCompleteOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingCompleteOCLCSVisitor<R, C, D extends CompleteOCLCSVisitor<R>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements CompleteOCLCSVisitor<R>
{
	protected AbstractDelegatingCompleteOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS object) {
		return delegate.visitClassifierContextDeclCS(object);
	}

	public @Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS object) {
		return delegate.visitCompleteOCLDocumentCS(object);
	}

	public @Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS object) {
		return delegate.visitContextDeclCS(object);
	}

	public @Nullable R visitDefCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS object) {
		return delegate.visitDefCS(object);
	}

	public @Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS object) {
		return delegate.visitDefOperationCS(object);
	}

	public @Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS object) {
		return delegate.visitDefPropertyCS(object);
	}

	public @Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS object) {
		return delegate.visitFeatureContextDeclCS(object);
	}

	public @Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS object) {
		return delegate.visitIncludeCS(object);
	}

	public @Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS object) {
		return delegate.visitOCLMessageArgCS(object);
	}

	public @Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS object) {
		return delegate.visitOperationContextDeclCS(object);
	}

	public @Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS object) {
		return delegate.visitPackageDeclarationCS(object);
	}

	public @Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS object) {
		return delegate.visitPathNameDeclCS(object);
	}

	public @Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS object) {
		return delegate.visitPropertyContextDeclCS(object);
	}
}

/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSContainmentVisitor;

/**
 * An AbstractCompleteOCLCSContainmentVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCompleteOCLCSContainmentVisitor
	extends EssentialOCLCSContainmentVisitor
	implements CompleteOCLCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractCompleteOCLCSContainmentVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS csElement) {
		return visitContextDeclCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.ContextDeclCS csElement) {
		return visitPathNameDeclCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDefCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDefOperationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefOperationCS csElement) {
		return visitDefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDefPropertyCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS csElement) {
		return visitDefCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.FeatureContextDeclCS csElement) {
		return visitContextDeclCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitIncludeCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.IncludeCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitOCLMessageArgCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitOperationContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS csElement) {
		return visitFeatureContextDeclCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPackageDeclarationCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS csElement) {
		return visitPathNameDeclCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPathNameDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PathNameDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS csElement) {
		return visitFeatureContextDeclCS(csElement);
	}
}

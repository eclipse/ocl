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
 * An AbstractExtendingCompleteOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingCompleteOCLCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
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

	public @Nullable R visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	public @Nullable R visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS object) {
		return visitPathNameDeclCS(object);
	}

	public @Nullable R visitDefCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS object) {
		return visitTypedElementCS(object);
	}

	public @Nullable R visitDefOperationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS object) {
		return visitDefCS(object);
	}

	public @Nullable R visitDefPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS object) {
		return visitDefCS(object);
	}

	public @Nullable R visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	public @Nullable R visitIncludeCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS object) {
		return visitNamedElementCS(object);
	}

	public @Nullable R visitOCLMessageArgCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitOperationContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}

	public @Nullable R visitPackageDeclarationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS object) {
		return visitPathNameDeclCS(object);
	}

	public @Nullable R visitPathNameDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS object) {
		return visitModelElementCS(object);
	}

	public @Nullable R visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}
}

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
 * from: org.eclipse.ocl.examples.xtext.completeocl/model/CompleteOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;
import org.eclipse.ocl.examples.pivot.Element;

/**
 * An AbstractCompleteOCLCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCompleteOCLCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements CompleteOCLCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractCompleteOCLCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitClassifierContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS csElement) {
		return visitContextDeclCS(csElement);
	}

	public @Nullable Element visitCompleteOCLDocumentCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Element visitContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS csElement) {
		return visitPathNameDeclCS(csElement);
	}

	public @Nullable Element visitDefCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Element visitDefOperationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS csElement) {
		return visitDefCS(csElement);
	}

	public @Nullable Element visitDefPropertyCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS csElement) {
		return visitDefCS(csElement);
	}

	public @Nullable Element visitFeatureContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.FeatureContextDeclCS csElement) {
		return visitContextDeclCS(csElement);
	}

	public @Nullable Element visitIncludeCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.IncludeCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Element visitOCLMessageArgCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OCLMessageArgCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitOperationContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS csElement) {
		return visitFeatureContextDeclCS(csElement);
	}

	public @Nullable Element visitPackageDeclarationCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS csElement) {
		return visitPathNameDeclCS(csElement);
	}

	public @Nullable Element visitPathNameDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PathNameDeclCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Element visitPropertyContextDeclCS(@NonNull org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PropertyContextDeclCS csElement) {
		return visitFeatureContextDeclCS(csElement);
	}
}

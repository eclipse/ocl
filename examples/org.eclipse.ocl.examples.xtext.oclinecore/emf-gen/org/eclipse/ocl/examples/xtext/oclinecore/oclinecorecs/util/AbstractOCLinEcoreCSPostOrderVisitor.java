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
 * from: org.eclipse.ocl.examples.xtext.oclinecore/model/OCLinEcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractOCLinEcoreCSPostOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractOCLinEcoreCSPostOrderVisitor
	extends EssentialOCLCSPostOrderVisitor
	implements OCLinEcoreCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractOCLinEcoreCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitOCLinEcoreConstraintCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS csElement) {
		return visitConstraintCS(csElement);
	}

	public @Nullable Continuation<?> visitSysMLCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.SysMLCS csElement) {
		return visitAnnotationElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}
}

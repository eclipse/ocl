/**
 * <copyright>
 *
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
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.util.AbstractOCLstdlibCSPostOrderVisitor;

public class OCLstdlibCSPostOrderVisitor extends AbstractOCLstdlibCSPostOrderVisitor
{		
	public OCLstdlibCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public @Nullable
	Continuation<?> visitLibPropertyCS(@NonNull LibPropertyCS csElement) {
		Continuation<?> continuation = super.visitLibPropertyCS(csElement);
		Property pivotElement = PivotUtil.getPivot(Property.class, csElement);
		if (pivotElement != null) {
			pivotElement.setOpposite(null);
			metaModelManager.installPropertyDeclaration(pivotElement);
		}
		return continuation;
	}

	@Override
	public Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS csPrecedence) {
		return null;
	}
}
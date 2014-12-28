/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 388529
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.attributes;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;

public class UnaryOperationMatcher extends AbstractOperationMatcher
{
	public UnaryOperationMatcher(@NonNull MetamodelManager metamodelManager, @Nullable Type sourceType, @Nullable Type sourceTypeValue) {
		super(metamodelManager, sourceType, sourceTypeValue);
	}

	@Override
	protected OCLExpression getArgument(int i) {
		throw new IllegalStateException();
	}

	@Override
	protected int getArgumentCount() {
		return 0;
	}
}
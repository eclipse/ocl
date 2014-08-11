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
package org.eclipse.ocl.examples.xtext.essentialocl.attributes;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;

public class BinaryOperationMatcher extends AbstractOperationMatcher
{
	protected final OCLExpression asArgument;
	
	public BinaryOperationMatcher(@NonNull MetaModelManager metaModelManager, @Nullable Type sourceType, boolean sourceIsTypeof, @Nullable ExpCS csArgument) {
		super(metaModelManager, sourceType, sourceIsTypeof);
		this.asArgument = PivotUtil.getPivot(OCLExpression.class, csArgument);
	}

	@Override
	protected OCLExpression getArgument(int i) {
		if (i != 0) {
			throw new IllegalStateException();
		}
		return asArgument;
	}

	@Override
	protected int getArgumentCount() {
		return 1;
	}
}
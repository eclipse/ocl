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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;

public class OperationMatcher extends AbstractOperationMatcher
{
	protected final @NonNull List<OCLExpression> asArguments = new ArrayList<OCLExpression>();

	public OperationMatcher(@NonNull MetaModelManager metaModelManager, @Nullable Type sourceType, @Nullable Type sourceTypeValue, @NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		super(metaModelManager, sourceType, sourceTypeValue);
		for (NavigatingArgCS csNavigatingArg : csRoundBracketedClause.getOwnedArguments()) {
			if (csNavigatingArg.getRole() == NavigationRole.EXPRESSION) {
				asArguments.add(PivotUtil.getPivot(OCLExpression.class, csNavigatingArg));
			}
		}
	}

	@Override
	protected OCLExpression getArgument(int i) {
		return asArguments.get(i);
	}

	@Override
	protected int getArgumentCount() {
		return asArguments.size();
	}
}
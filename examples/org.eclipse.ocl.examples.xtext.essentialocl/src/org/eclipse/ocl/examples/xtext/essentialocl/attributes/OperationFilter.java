/*******************************************************************************
 * Copyright (c) 2011,2013 E.D.Willink and others.
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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;

public class OperationFilter implements ScopeFilter
{
	protected final @Nullable Type sourceType;
	protected final @NonNull List<NavigatingArgCS> csArguments;
	protected final int iterators;
	protected final int accumulators;
	protected final int expressions;
	
	public OperationFilter(@Nullable Type sourceType, @NonNull RoundBracketedClauseCS csRoundBracketedClause) {
		this.sourceType = sourceType != null ? PivotUtil.getType(sourceType) : null;		// FIXME redundant
		int accumulators = 0;
		int iterators = 0;
		int expressions = 0;
		List<NavigatingArgCS> csArguments = csRoundBracketedClause.getArguments();
		this.csArguments = csArguments;
		for (NavigatingArgCS csNavigatingArg : csArguments) {
			if (csNavigatingArg.getRole() == NavigationRole.ITERATOR) {
				iterators++;
			}
			else if (csNavigatingArg.getRole() == NavigationRole.ACCUMULATOR) {
				accumulators++;
			}
			else if (csNavigatingArg.getRole() == NavigationRole.EXPRESSION) {
				expressions++;
			}
		}
		this.iterators = iterators;
		this.accumulators = accumulators;
		this.expressions = expressions;
	}

	public boolean matches(@NonNull EnvironmentView environmentView, @NonNull Object object) {
		MetaModelManager metaModelManager = environmentView.getMetaModelManager();
		if (object instanceof Iteration) {
			Iteration candidateIteration = (Iteration)object;
			int iteratorCount = candidateIteration.getOwnedIterator().size();
			if ((0 < iterators) && (iteratorCount != iterators)) {
				return false;
			}
			int accumulatorCount = candidateIteration.getOwnedAccumulator().size();
			if (accumulatorCount != accumulators) {
				return false;
			}
			return true;
		}
		else if (object instanceof Operation) {
			if (iterators > 0) {
				return false;
			}
			if (accumulators > 0) {
				return false;
			}
			Operation candidateOperation = (Operation)object;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameter();
			if (expressions != candidateParameters.size()) {
				return false;
			}
			for (int i = 0; i < expressions; i++) {
				Parameter candidateParameter = candidateParameters.get(i);
				if (candidateParameter != null) {
					NavigatingArgCS csExpression = csArguments.get(i);
					OCLExpression expression = PivotUtil.getPivot(OCLExpression.class, csExpression);
					Type candidateType = PivotUtil.getType(candidateParameter);
					Type expressionType = PivotUtil.getType(expression);
					if ((expressionType == null) || (candidateType == null)) {
						return false;
					}
					if (!metaModelManager.conformsTo(expressionType, candidateType, null)) {
						return false;
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
}
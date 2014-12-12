/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.DomainFragment;
import org.eclipse.ocl.domain.messages.EvaluatorMessages;
import org.eclipse.ocl.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Operation;

public abstract class AbstractFragment implements DomainFragment
{
	public final @NonNull CompleteInheritance derivedInheritance;
	public final @NonNull CompleteInheritance baseInheritance;

	public AbstractFragment(@NonNull CompleteInheritance derivedInheritance, @NonNull CompleteInheritance baseInheritance) {
		this.derivedInheritance = derivedInheritance;
		this.baseInheritance = baseInheritance;
	}
	
	/**
	 * Return the actualOperation that has the same signature as apparentOperation.
	 */
	@Override
	public @NonNull Operation getActualOperation(@NonNull Operation apparentOperation) {
		Operation localOperation = getLocalOperation(apparentOperation);
		if (localOperation == null) {
			if (derivedInheritance == baseInheritance) {
				localOperation = apparentOperation;
			}
		}
		if (localOperation == null) {				// Non-trivial, search up the inheritance tree for an inherited operation
			Operation bestOverload = null;
			CompleteInheritance bestInheritance = null;
			int bestDepth = -1;
			int minDepth = baseInheritance.getDepth();
			for (int depth = derivedInheritance.getDepth()-1; depth >= minDepth; depth--) {
				Iterable<DomainFragment> derivedSuperFragments = derivedInheritance.getSuperFragments(depth);
				for (DomainFragment derivedSuperFragment : derivedSuperFragments) {
					CompleteInheritance superInheritance = derivedSuperFragment.getBaseInheritance();
					DomainFragment superFragment = superInheritance.getFragment(baseInheritance);
					if (superFragment != null) {
						Operation overload = superFragment.getLocalOperation(apparentOperation);
						if (overload != null) {
							if (bestInheritance == null) {				// First candidate
								bestDepth = depth;
								bestInheritance = superInheritance;
								bestOverload = overload;
							}
							else if (depth == bestDepth) {				// Sibling candidate 
								bestOverload = null;
								depth = -1;
								break;
							}
							else if (!bestInheritance.isSubInheritanceOf(superInheritance)) {	// Non-occluded child candidate
								bestOverload = null;
								depth = -1;
								break;
							}
						}
					}
				}
			}
			if (bestOverload != null) {
				localOperation = bestOverload;
			}
			else {
				throw new InvalidValueException(EvaluatorMessages.AmbiguousOperation, apparentOperation, derivedInheritance);
			}
		}
//		if (localOperation == null) {
//			localOperation = INVALID;
//		}
//		if (localOperation == null) {
//			localOperation = apparentOperation;
//		}
		return localOperation;
	}

	@Override
	public final @NonNull DomainFragment getBaseFragment() {
		return baseInheritance.getSelfFragment();
	}

	@Override
	public final @NonNull CompleteInheritance getBaseInheritance() {
		return baseInheritance;
	}

	@Override
	public final @NonNull CompleteInheritance getDerivedInheritance() {
		return derivedInheritance;
	}

	/**
	 * Return true if anOperation overloads an existing operation.
	 *
	protected boolean isOverload(DomainOperation anOperation) {
		int depth = derivedInheritance.getDepth();
		for (int i = 0; i <= depth-1; i++) {
			for (DomainInheritance superInheritance : derivedInheritance.getSuperInheritances(depth)) {
				DomainFragment baseFragment = superInheritance.getSelfFragment();
				for (DomainOperation baseOperation : baseFragment.getOperations()) {
					if (isOverload(anOperation, baseOperation)) {
						return true;
					}
				}
			}
		}
		return false;
	} */

/*	public DomainOperation lookupOperation(DomainStandardLibrary standardLibrary, DomainType staticType, String operationName, DomainType[] argumentTypes) {
		for (DomainOperation operation : getOperations()) {		// FIXME binary search
			if (operation.getName().equals(operationName)) {
				boolean gotIt = true;
				IndexableIterable<? extends DomainType> parameterTypeArguments = operation.getParameterType();
//				ExecutorTypeArgument[] parameterTypeArguments = operation.getParameterType();
				if (parameterTypeArguments.size() == argumentTypes.length) {
					for (int i = 0; i < parameterTypeArguments.size(); i++) {
						DomainType argumentType = argumentTypes[i];
						DomainType parameterTypeArgument = parameterTypeArguments.get(i);
//						if (parameterTypeArgument instanceof ExecutorType) {
							DomainType parameterType;
							if (parameterTypeArgument == standardLibrary.getOclSelfType()) {
								parameterType = staticType;
							}
							else {
								parameterType = parameterTypeArgument;
							}
							if (!argumentType.conformsTo(standardLibrary, parameterType)) {
								gotIt = false;
								break;
							}
							
//						}
//						else {
//							// FIXME
//						}
					}
				}
				if (gotIt) {
					return operation;
				}
			}
		}
		return null;
	} */

	@Override
	public String toString() {
		return derivedInheritance.getName() + "__" + baseInheritance.getName(); //$NON-NLS-1$
	}
}
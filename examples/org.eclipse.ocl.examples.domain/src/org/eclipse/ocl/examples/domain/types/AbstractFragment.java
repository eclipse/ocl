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
package org.eclipse.ocl.examples.domain.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainFragment;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;

public abstract class AbstractFragment implements DomainFragment
{
	public final @NonNull DomainInheritance derivedInheritance;
	public final @NonNull DomainInheritance baseInheritance;

	public AbstractFragment(@NonNull DomainInheritance derivedInheritance, @NonNull DomainInheritance baseInheritance) {
		this.derivedInheritance = derivedInheritance;
		this.baseInheritance = baseInheritance;
	}

	public final @NonNull DomainFragment getBaseFragment() {
		return baseInheritance.getSelfFragment();
	}

	public final @NonNull DomainInheritance getBaseInheritance() {
		return baseInheritance;
	}

	public final @NonNull DomainInheritance getDerivedInheritance() {
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
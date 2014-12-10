/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.ids.ParametersId;
import org.eclipse.ocl.library.executor.ReflectiveFragment;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceInternal;

public class PivotReflectiveFragment extends ReflectiveFragment
{
	public PivotReflectiveFragment(@NonNull CompleteInheritanceInternal derivedInheritance, @NonNull DomainInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
	}

	@Override
	public @Nullable DomainOperation getLocalOperation(@NonNull DomainOperation baseOperation) {
		CompleteInheritanceInternal completeInheritance = (CompleteInheritanceInternal) derivedInheritance;
		String baseOperationName = baseOperation.getName();
		ParametersId baseParametersId = baseOperation.getParametersId();
		DomainOperation bestOperation = null;
		for (DomainClass partialClass : completeInheritance.getCompleteClass().getPartialClasses()) {
			for (DomainOperation localOperation : partialClass.getOwnedOperations()) {
				if (localOperation.getName().equals(baseOperationName) && (localOperation.getParametersId() == baseParametersId)) {
					if ((localOperation instanceof Operation) && (((Operation)localOperation).getETarget() != null)) {
						return localOperation;
					}					
					if (bestOperation == null) {
						bestOperation = localOperation;
					}
					else if ((localOperation.getBodyExpression() != null) && (bestOperation.getBodyExpression() == null)) {
						bestOperation = localOperation;
					}
				}
			}
		}
		return bestOperation;					// null if not known locally, caller must try superfragments.
	}
}

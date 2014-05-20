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
package org.eclipse.ocl.examples.pivot.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.library.executor.ReflectiveFragment;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;

public class PivotReflectiveFragment extends ReflectiveFragment
{
	public PivotReflectiveFragment(@NonNull TypeServer derivedInheritance, @NonNull DomainInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
	}

	public @Nullable DomainOperation getLocalOperation(@NonNull DomainOperation baseOperation) {
		TypeServer typeServer = (TypeServer) derivedInheritance;
		String baseOperationName = baseOperation.getName();
		ParametersId baseParametersId = baseOperation.getParametersId();
		for (DomainType partialType : typeServer.getPartialTypes()) {
			for (DomainOperation localOperation : partialType.getOwnedOperation()) {
				if (localOperation.getName().equals(baseOperationName) && (localOperation.getParametersId() == baseParametersId)) {
					return localOperation;
				}
			}
		}
		return null;					// Not known locally, caller must try superfragments.
	}
}
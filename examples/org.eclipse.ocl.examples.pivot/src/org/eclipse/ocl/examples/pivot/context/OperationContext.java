/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

/**
 * OperationContext supports parsing OCL expressions in the context of an Operation.
 */
public class OperationContext extends ClassContext
{
	private final @NonNull Operation operationContext;
	private final @Nullable String resultVariableName;		// Null for none
	
	public OperationContext(@NonNull MetaModelManager metaModelManager, @Nullable URI uri, @NonNull Operation operationContext, @Nullable String resultVariableName) {
		super(metaModelManager, uri, DomainUtil.nonNullModel(operationContext.getOwningType()));
		this.operationContext = operationContext;
		this.resultVariableName = resultVariableName;
	}

	@Override
	public void initialize(@NonNull Base2PivotConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		conversion.setParameterVariables(expression, DomainUtil.nonNullEMF(operationContext.getOwnedParameter()));
		String resultVariableName2 = resultVariableName;
		if (resultVariableName2 != null) {
			conversion.setResultVariable(expression, operationContext, resultVariableName2);
		}
	}
}

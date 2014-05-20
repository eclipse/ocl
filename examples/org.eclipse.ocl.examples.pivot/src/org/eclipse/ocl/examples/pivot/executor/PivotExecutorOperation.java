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
package org.eclipse.ocl.examples.pivot.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.library.executor.ExecutorOperation;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.manager.TypeServer;

public class PivotExecutorOperation extends ExecutorOperation
{
	protected final @NonNull Operation pivotOperation;
	
	public PivotExecutorOperation(@NonNull TypeServer inheritance, int operationIndex, @NonNull Operation pivotOperation) {
		super(DomainUtil.nonNullModel(pivotOperation.getName()), DomainParameterTypes.EMPTY_LIST, inheritance, operationIndex, DomainTypeParameters.EMPTY_LIST, pivotOperation.getImplementation());
		this.pivotOperation = pivotOperation;		
	}
	
	public final @NonNull Operation getPivotOperation() {
		return pivotOperation;
	}
}
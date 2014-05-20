/*******************************************************************************
 * Copyright (c) 2009, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.logical;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractUntypedUnaryOperation;
import org.eclipse.ocl.examples.domain.values.SetValue;

/**
 * BooleanAllInstancesOperation realises the Boolean::allInstances() library operation.
 */
public class BooleanAllInstancesOperation extends AbstractUntypedUnaryOperation
{
	public static final @NonNull BooleanAllInstancesOperation INSTANCE = new BooleanAllInstancesOperation();
	public static final @NonNull CollectionTypeId SET_BOOLEAN = TypeId.SET.getSpecializedId(TypeId.BOOLEAN);
	
	@Override
	public @NonNull SetValue evaluate(@NonNull DomainEvaluator evaluator, @Nullable Object sourceVal) {
		// Boolean has two instances: false, true
		return evaluator.getIdResolver().createSetOfEach(SET_BOOLEAN, Boolean.FALSE, Boolean.TRUE);
	}
}

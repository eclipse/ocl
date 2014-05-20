/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.AbstractProperty;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.TupleValue;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;

public class TuplePartProperty extends AbstractProperty
{
	protected final @NonNull TuplePartId tuplePartId;

	public TuplePartProperty(@NonNull TuplePartId tuplePartId) {
		this.tuplePartId = tuplePartId;
	}

	public @Nullable Object evaluate(@NonNull DomainEvaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		TupleValue tupleValue = asTupleValue(sourceValue);
		Object resultValue = tupleValue.getValue(tuplePartId);
		if (resultValue != null) {
			return resultValue;		// null is a static type error so no need to diagnose dynamically
		}
		throw new InvalidValueException(DomainUtil.bind("part '" + tuplePartId + "' is not a part of '" + sourceValue));
	}
}
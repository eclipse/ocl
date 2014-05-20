/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;

public interface NullValue
	extends ObjectValue, UnlimitedValue,
		BagValue, OrderedSetValue, SequenceValue, SetValue, TupleValue
{
	@NonNull OclVoidTypeId getTypeId();
	/**
	 * @generated NOT
	 */
	@NonNull NullValue negate();	
}

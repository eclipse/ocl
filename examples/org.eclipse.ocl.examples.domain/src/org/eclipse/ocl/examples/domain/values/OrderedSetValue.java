/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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

public interface OrderedSetValue extends OrderedCollectionValue, UniqueCollectionValue
{
	/**
	 * @generated NOT
	 */
	interface Accumulator extends CollectionValue.Accumulator, OrderedSetValue {}

	/**
	 * @generated NOT
	 */
    @NonNull OrderedSetValue subOrderedSet(int lower, int upper);
}

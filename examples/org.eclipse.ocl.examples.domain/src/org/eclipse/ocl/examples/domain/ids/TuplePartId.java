/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.Nameable;

/**
 * A TuplePartId provides a unique identifier for a TuplePart such as first:String.
 */
public interface TuplePartId extends ElementId, Nameable, Comparable<TuplePartId>
{
	int getIndex();
	@NonNull String getName();
	@NonNull TypeId getTypeId();
}
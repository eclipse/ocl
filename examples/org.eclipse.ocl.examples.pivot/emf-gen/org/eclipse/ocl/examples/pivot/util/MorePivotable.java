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
package org.eclipse.ocl.examples.pivot.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.utilities.PivotObject;

/**
 * A MorePivotable object has references to additional pivot objects that should be
 * treated as in use at the end of a CS2Pivot conversion. 
 */
public interface MorePivotable extends PivotObject
{
	@NonNull Iterable<Element> getMorePivots();
}

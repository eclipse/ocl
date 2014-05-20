/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
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

/**
 * A EnumerationLiteralId provides a unique hierarchical identifier for an enumeration literal.
 */
public interface EnumerationLiteralId extends ElementId
{
	@NonNull String getName();
	@NonNull EnumerationId getParentId();
}
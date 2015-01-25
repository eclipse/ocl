/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.types.IdResolver;

/**
 * ValueExtension provides an additional convert-to-Ecore API that cannot be placed directly in Value
 * while maintaining API compatibility in the 5.0.4 maintenance release. This interface will vanish in 6.0.
 * @since 3.4
 */
@Deprecated
public interface ValueExtension
{
	/**
	 * Return the representation of this value used within Ecore. For EDataTypes that may have
	 * multiple representations, instanceClass identifies the required representation.
	 */
	Object asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass);	
}

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
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.Nullable;

/**
 * IdResolverExtension provides an additional convert-to-Ecore API that cannot be placed directly in IdResolver
 * while maintaining API compatibility in the 5.0.4 maintenance release. This interface will vanish in 6.0.
 */
@Deprecated
public interface IdResolverExtension
{
	Object ecoreValueOf(@Nullable Class<?> instanceClass, Object boxedValue);
}

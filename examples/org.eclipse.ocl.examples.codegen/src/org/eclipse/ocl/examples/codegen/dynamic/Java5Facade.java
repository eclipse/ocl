/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.dynamic;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @deprecated Jva 5 support is discontinued in Luna, so OCL2JavaFileObject can be invoked directly.
 */
@Deprecated
public class Java5Facade
{
	public static Class<?> loadClass(@NonNull String qualifiedName, @NonNull String javaCodeSource) throws Exception {
		return OCL2JavaFileObject.loadClass(qualifiedName, javaCodeSource);
	}
}
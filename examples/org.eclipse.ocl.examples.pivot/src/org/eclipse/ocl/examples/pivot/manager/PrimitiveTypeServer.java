/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.manager;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.PrimitiveType;

/**
 * A PrimitiveTypeServer supports one or more merged primitive types.
 */
public class PrimitiveTypeServer extends ExtensibleTypeServer
{
	protected PrimitiveTypeServer(@NonNull PackageServer packageServer, @NonNull PrimitiveType primitiveType) {
		super(packageServer, primitiveType);
	}
}

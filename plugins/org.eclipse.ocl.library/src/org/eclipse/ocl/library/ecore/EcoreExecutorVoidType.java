/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.ecore;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.BuiltInTypeId;
import org.eclipse.ocl.library.executor.ExecutorPackage;
import org.eclipse.ocl.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;

public class EcoreExecutorVoidType extends EcoreExecutorType
{
	public EcoreExecutorVoidType(@NonNull BuiltInTypeId typeId, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(typeId, evaluationPackage, flags | OCL_VOID, typeParameters);
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (type instanceof EcoreExecutorInvalidType) {
			return false;
		}
		else {
			return true;
		}
	}
}

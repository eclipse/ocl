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
package org.eclipse.ocl.examples.library.ecore;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.BuiltInTypeId;
import org.eclipse.ocl.examples.library.executor.ExecutorPackage;
import org.eclipse.ocl.examples.library.executor.ExecutorTypeParameter;

public class EcoreExecutorInvalidType extends EcoreExecutorType
{
	public EcoreExecutorInvalidType(@NonNull BuiltInTypeId typeId, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter... typeParameters) {
		super(typeId, evaluationPackage, flags | OCL_INVALID, typeParameters);
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		return true;
	}
}

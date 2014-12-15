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
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.ids.ParametersId;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;


/**
 * DomainParameterTypesIterable provides a hashable list of operation
 * parameters suitable for use when indexing operation overloads.
 */
public interface ParameterTypes
{
	@NonNull Type[] get();
	@NonNull Type get(int index);
	@NonNull ParametersId getParametersId();
	@NonNull List<Parameter> getParameters();
	int size();
}
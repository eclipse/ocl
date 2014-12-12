/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.executor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.AbstractExecutorTypedElement;
import org.eclipse.ocl.domain.evaluation.DomainEvaluationEnvironment;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;

public class ExecutorEvaluationEnvironment implements DomainEvaluationEnvironment
{
	private Map<TypedElement, Object> variables = new HashMap<TypedElement, Object>();
	
	@Override
	public void add(@NonNull TypedElement variable, Object value) {
		variables.put(variable, value);
	}

	@Override
	public @NonNull TypedElement createVariable(@NonNull String name, @NonNull Type type) {
		return new AbstractExecutorTypedElement(name, type);
	}	

	@Override
	public void replace(@NonNull TypedElement variable, Object value) {
		variables.put(variable, value);
	}
}

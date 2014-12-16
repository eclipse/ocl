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
package org.eclipse.ocl.pivot.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;

public interface DomainEvaluationEnvironment
{
	void add(@NonNull TypedElement variable, Object value);
	@NonNull TypedElement createVariable(@NonNull String name, @NonNull Type type);
	void replace(@NonNull TypedElement variable, Object value);
}

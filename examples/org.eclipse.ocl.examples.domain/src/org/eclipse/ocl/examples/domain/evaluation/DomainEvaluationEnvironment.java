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
package org.eclipse.ocl.examples.domain.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.elements.DomainTypedElement;

public interface DomainEvaluationEnvironment
{
	void add(@NonNull DomainTypedElement variable, Object value);
	@NonNull DomainTypedElement createVariable(@NonNull String name, @NonNull DomainType type);
	void replace(@NonNull DomainTypedElement variable, Object value);
}

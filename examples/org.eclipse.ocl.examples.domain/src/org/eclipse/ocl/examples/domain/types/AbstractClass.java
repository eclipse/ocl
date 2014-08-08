/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.types;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainClass;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;

public abstract class AbstractClass extends AbstractType implements DomainClass	// FIXME rename as perhaps DerivativeType
{
	public AbstractClass(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name) {
		super(standardLibrary, name);
	}

	public @NonNull List<? extends DomainClass> getSuperClasses() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}
}
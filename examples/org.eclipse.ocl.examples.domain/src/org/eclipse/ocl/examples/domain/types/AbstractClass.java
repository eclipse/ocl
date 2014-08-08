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
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.Value;

public abstract class AbstractClass extends AbstractType implements DomainClass	// FIXME rename as perhaps DerivativeType
{
	public AbstractClass(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name) {
		super(standardLibrary, name);
	}

	public @NonNull ObjectValue createInstance() {
		throw new UnsupportedOperationException();
	}

	public @NonNull Value createInstance(@NonNull String value) {
		throw new UnsupportedOperationException();
	}

	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull List<? extends DomainProperty> getOwnedProperties() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull List<? extends DomainClass> getSuperClasses() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	public @NonNull DomainTypeParameters getTypeParameters() {
		return DomainTypeParameters.EMPTY_LIST;
	}
}
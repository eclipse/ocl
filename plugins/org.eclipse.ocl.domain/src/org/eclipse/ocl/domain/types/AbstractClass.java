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
package org.eclipse.ocl.domain.types;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainPackage;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.domain.values.Value;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Property;

public abstract class AbstractClass extends AbstractType implements DomainClass	// FIXME rename as perhaps DerivativeType
{
	public AbstractClass(@NonNull DomainEnvironment environment, @NonNull String name) {
		super(environment, name);
	}

	@Override
	public @NonNull EObject createInstance() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Value createInstance(@NonNull String value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public @NonNull DomainClass flattenedType() {
		return this;
	}

	@Override
	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getInheritance(this);
	}

	@Override
	public @NonNull List<? extends Constraint> getOwnedInvariants() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public @NonNull List<? extends DomainOperation> getOwnedOperations() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	@Override
	public @NonNull List<Property> getOwnedProperties() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	@Override
	public DomainPackage getOwningPackage() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	@Override
	public @NonNull List<? extends DomainClass> getSuperClasses() {
		throw new UnsupportedOperationException();			// WIP fixme / DerivativeType should not be used as full types
	}

	@Override
	public @NonNull DomainTypeParameters getTypeParameters() {
		return DomainTypeParameters.EMPTY_LIST;
	}
	
	@Override
	public @NonNull DomainClass isClass() {
		return this;
	}

	@Override
	public boolean isOrdered() {
		return false;
	}

	@Override
	public @Nullable DomainTemplateParameter isTemplateParameter() {
		return null;
	}

	@Override
	public boolean isUnique() {
		return false;
	}
}
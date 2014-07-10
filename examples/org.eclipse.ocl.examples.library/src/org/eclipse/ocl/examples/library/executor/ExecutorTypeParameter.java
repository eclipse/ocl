/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.AbstractType;
import org.eclipse.ocl.examples.domain.types.IdResolver;

public class ExecutorTypeParameter extends AbstractType implements ExecutorTypeArgument, DomainTemplateParameter
{
	private final @NonNull TemplateParameterId typeid;

	public ExecutorTypeParameter(@NonNull TemplateParameterId typeid, @NonNull DomainStandardLibrary standardLibrary, @NonNull String name) {
		super(standardLibrary, name);
		this.typeid = typeid;
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}
	
	public @NonNull TemplateParameterId getElementId() {
		return typeid;
	}

	public @NonNull TemplateParameterId getTypeId() {
		return typeid;
	}

	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public DomainOperation lookupOperation(DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainType... argumentTypes) {
		throw new UnsupportedOperationException();			// WIP fixme
	}
}
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
package org.eclipse.ocl.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainTemplateParameter;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.TemplateParameterId;
import org.eclipse.ocl.domain.types.AbstractType;
import org.eclipse.ocl.domain.types.IdResolver;

public class ExecutorTypeParameter extends AbstractType implements ExecutorTypeArgument, DomainTemplateParameter
{
	private final @NonNull TemplateParameterId typeid;

	public ExecutorTypeParameter(@NonNull TemplateParameterId typeid, @NonNull DomainEnvironment environment, @NonNull String name) {
		super(environment, name);
		this.typeid = typeid;
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @Nullable DomainType getLowerBound() {
		return null;
	}
	
	@Override
	public @NonNull TemplateParameterId getTemplateParameterId() {
		return typeid;
	}

	@Override
	public @NonNull TemplateParameterId getTypeId() {
		return typeid;
	}
	
	@Override
	public @Nullable DomainClass isClass() {
		return null;
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull DomainTemplateParameter isTemplateParameter() {
		return this;
	}
}
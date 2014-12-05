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
import org.eclipse.ocl.domain.elements.DomainEnvironment;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.CollectionTypeId;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.types.AbstractClass;
import org.eclipse.ocl.domain.types.IdResolver;

public class ExecutorSpecializedType extends AbstractClass implements ExecutorTypeArgument
{
	protected final @NonNull TypeId typeId;

	public ExecutorSpecializedType(@NonNull DomainEnvironment environment, @NonNull String name, @NonNull ExecutorTypeArgument... typeArguments) {
		super(environment, name);
		CollectionTypeId collectionTypeId = IdManager.getCollectionTypeId(name);
		typeId = (TypeId) collectionTypeId.specialize(IdManager.getBindingsId(typeArguments));
	}

	@Override
	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public boolean isEqualTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull DomainOperation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainOperation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public DomainOperation lookupOperation(DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainType... argumentTypes) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return typeId;
	}
}
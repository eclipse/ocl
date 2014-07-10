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
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.AbstractType;
import org.eclipse.ocl.examples.domain.types.IdResolver;

public class ExecutorSpecializedType extends AbstractType implements ExecutorTypeArgument
{
	protected final @NonNull TypeId typeId;

	public ExecutorSpecializedType(@NonNull DomainStandardLibrary standardLibrary, @NonNull String name, @NonNull ExecutorTypeArgument... typeArguments) {
		super(standardLibrary, name);
		if (TypeId.METACLASS_NAME.equals(name)) {
			typeId = TypeId.METACLASS.getSpecializedId(typeArguments[0].getTypeId());
		}
		else {
			CollectionTypeId collectionTypeId = IdManager.getCollectionTypeId(name);
			typeId = (TypeId) collectionTypeId.specialize(IdManager.getBindingsId(typeArguments));
		}
	}

	public boolean conformsTo(@NonNull DomainStandardLibrary standardLibrary, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
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

	@Override
	public @NonNull DomainType getCommonType(@NonNull IdResolver idResolver, @NonNull DomainType type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public @NonNull TypeId getTypeId() {
		return typeId;
	}
}
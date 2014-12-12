/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.executor;

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.domain.elements.AbstractExecutorClass;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.ids.IdManager;
import org.eclipse.ocl.domain.ids.TuplePartId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.domain.types.IdResolver;
import org.eclipse.ocl.pivot.Operation;

public class ExecutorTupleType extends AbstractExecutorClass implements ExecutorTypeArgument
{
	protected final @NonNull TypeId typeId;

	public ExecutorTupleType(@NonNull String name, @NonNull Collection<? extends TuplePartId> parts) {
		super(name, 0);
		typeId = IdManager.getTupleTypeId(name, parts);
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
	public @NonNull Operation lookupActualOperation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull DomainStandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	public Operation lookupOperation(DomainStandardLibrary standardLibrary, @NonNull String operationName, DomainType... argumentTypes) {
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
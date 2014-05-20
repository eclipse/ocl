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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainOperation;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.library.LibraryFeature;
import org.eclipse.ocl.examples.domain.types.AbstractFragment;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

import com.google.common.collect.Lists;

/**
 * An ExecutorFragment provides the description of the properties and operations defined by some class when accessed by the same
 * or another class. The descriptions are normally built by direct static construction from auto-generated code, with instnaces defined
 * in isolation during construction then cross-references defined later by calls to init().
 */
public class ExecutorFragment extends AbstractFragment
{
	private ExecutorOperation[] operations;
	private ExecutorProperty[] properties;

	public ExecutorFragment(@NonNull ExecutorType derivedInheritance, @NonNull DomainInheritance baseInheritance) {
		super(derivedInheritance, baseInheritance);
		this.operations = null;
		this.properties = null;
	}
	
	public @NonNull LibraryFeature getImplementation(@NonNull DomainOperation staticOperation) {
		int index = staticOperation.getIndex();
		if (index >= 0) {
			return DomainUtil.nonNullState(operations[index].implementation);
		}
		else {
			throw new UnsupportedOperationException();		// WIP 
		}
	}

	public @Nullable DomainOperation getLocalOperation(@NonNull DomainOperation staticOperation) {
		int index = staticOperation.getIndex();
		if (index >= 0) {
			return operations[index];
		}
		else {
			return null;
		}
	}

	@SuppressWarnings("null")
	public @NonNull List<? extends DomainOperation> getLocalOperations() {
		assert operations != null;
		return Lists.newArrayList(operations);
	}
	
	@SuppressWarnings("null")
	public @NonNull List<? extends DomainProperty> getLocalProperties() {
		assert properties != null;
		return Lists.newArrayList(properties);
	}

	public @NonNull List<? extends DomainType> getLocalSuperTypes() {
		throw new UnsupportedOperationException();		// WIP 
	}

	public void initOperations(@NonNull ExecutorOperation[] operations) {
		assert this.operations == null;
		this.operations = operations;
	}

	public void initProperties(@NonNull ExecutorProperty[] properties) {
		assert this.properties == null;
		this.properties = properties;
	}
}
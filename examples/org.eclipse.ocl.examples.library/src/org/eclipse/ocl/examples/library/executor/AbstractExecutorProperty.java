/**
 * <copyright>
 *
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainInheritance;
import org.eclipse.ocl.examples.domain.elements.DomainProperty;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

public abstract class AbstractExecutorProperty implements DomainProperty
{
	protected final @NonNull String name;
	protected final @NonNull DomainInheritance executorType;
	protected final int propertyIndex;
	protected ExecutorProperty opposite;

	public AbstractExecutorProperty(@NonNull String name, @NonNull DomainInheritance executorType, int propertyIndex) {
		this.name = name;
		this.executorType = executorType;
		this.propertyIndex = propertyIndex;
		this.opposite = null;
	}

	public DomainExpression getDefaultExpression() {
		throw new UnsupportedOperationException(); 			// FIXME
	}

	public @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return executorType;
	}

	public @NonNull String getName() {
		return name;
	}

	public @NonNull DomainProperty getOpposite() {
		return DomainUtil.nonNullState(opposite);
	}

	public DomainType getOwningType() {
		throw new UnsupportedOperationException();			// FIXME
	}

	public @NonNull DomainType getType() {
		return executorType;
	}

	public @NonNull TypeId getTypeId() {
		DomainType type2 = getType();
		return type2.getTypeId();
	}

	void initOpposite(@NonNull ExecutorProperty opposite) {
		this.opposite = opposite;
	}

	public void initValue(@NonNull Object objectValue, @Nullable Object propertyValue) {
		throw new UnsupportedOperationException();
	}

	public boolean isStatic() {
		return false;								// WIP FIXME
	}
	
	@Override
	public String toString() {
		return String.valueOf(executorType) + "::" + String.valueOf(name); //$NON-NLS-1$
	}
}
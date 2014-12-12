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
package org.eclipse.ocl.domain.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;

public final class AbstractExecutorParameter extends AbstractExecutorTypedElement implements Parameter
{
	protected final boolean typeof;
	
	public AbstractExecutorParameter(@NonNull String name, @NonNull Type type, boolean typeof) {
		super(name, type);
		this.typeof = typeof;
	}
	
	@Override
	public boolean isTypeof() {
		return typeof;
	}

	@Override
	public Type getTypeValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTypeValue(Type value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsTypeof(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Operation getOperation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOperation(Operation value) {
		throw new UnsupportedOperationException();
	}
}
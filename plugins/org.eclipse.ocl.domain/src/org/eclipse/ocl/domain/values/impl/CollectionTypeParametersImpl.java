/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.domain.values.impl;

import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.values.CollectionTypeParameters;
import org.eclipse.ocl.domain.values.IntegerValue;
import org.eclipse.ocl.domain.values.UnlimitedNaturalValue;
import org.eclipse.ocl.domain.values.util.ValuesUtil;

public class CollectionTypeParametersImpl<T extends DomainType> implements CollectionTypeParameters<T>
{
	protected class Iterator implements java.util.Iterator<Object>
	{
		private int position = 0;
		
		@Override
		public boolean hasNext() {
			return position < 3;
		}

		@Override
		public Object next() {
			switch (position++) {
				case 0: return elementType;
				case 1: return lower;
				case 2: return upper;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private final int hashCode;
	private final @NonNull T elementType;
	private final @NonNull IntegerValue lower;
	private final @NonNull UnlimitedNaturalValue upper;

	public CollectionTypeParametersImpl(@NonNull T elementType, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		this.elementType = elementType;
		this.lower = lower != null ? lower : ValuesUtil.ZERO_VALUE;
		this.upper = upper != null ? upper : ValuesUtil.UNLIMITED_VALUE;
		int hash = elementType.hashCode();
		hash = 111 * hash + this.lower.hashCode();
		hash = 111 * hash + this.upper.hashCode();
		hashCode = hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CollectionTypeParametersImpl<?>)) {
			return false;
		}
		CollectionTypeParametersImpl<?> that = (CollectionTypeParametersImpl<?>)o;
		if (this.hashCode != that.hashCode){
			return false;
		}
		if (!this.elementType.equals(that.elementType)) {
			return false;
		}
		if (!this.lower.equals(that.lower)) {
			return false;
		}
		if (!this.upper.equals(that.upper)) {
			return false;
		}
		return true;
	}

	public @NonNull T getElementType() {
		return elementType;
	}

	public @NonNull IntegerValue getLower() {
		return lower;
	}

	public @NonNull UnlimitedNaturalValue getUpper() {
		return upper;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public @NonNull Iterator iterator() {
		return new Iterator();
	}		

	public int parametersSize() {
		return 1;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		s.append(elementType);
		s.append(',');
		s.append(lower);
		s.append(',');
		s.append(upper);
		s.append(')');
		return s.toString();
	}
}
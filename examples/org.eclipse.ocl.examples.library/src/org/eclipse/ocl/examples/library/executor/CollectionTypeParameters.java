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
package org.eclipse.ocl.examples.library.executor;

import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.values.IntegerValue;

public class CollectionTypeParameters<T extends DomainType> implements Iterable<Object>
{
	protected class Iterator implements java.util.Iterator<Object>
	{
		private int position = 0;
		
		public boolean hasNext() {
			return position < 3;
		}

		public Object next() {
			switch (position++) {
				case 0: return elementType;
				case 1: return lower;
				case 2: return upper;
			}
			throw new NoSuchElementException();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private final int hashCode;
	private final @NonNull T elementType;
	private final @NonNull IntegerValue lower;
	private final @NonNull IntegerValue upper;

	public CollectionTypeParameters(@NonNull T elementType, @NonNull IntegerValue lower, @NonNull IntegerValue upper) {
		this.elementType = elementType;
		this.lower = lower;
		this.upper = upper;
		int hash = elementType.hashCode();
		hash = 111 * hash + lower.hashCode();
		hash = 111 * hash + upper.hashCode();
		hashCode = hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CollectionTypeParameters<?>)) {
			return false;
		}
		CollectionTypeParameters<?> that = (CollectionTypeParameters<?>)o;
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

	public @NonNull IntegerValue getUpper() {
		return upper;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

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
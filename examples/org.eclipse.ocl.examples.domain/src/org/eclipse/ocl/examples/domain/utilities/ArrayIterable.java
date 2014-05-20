/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.utilities;

import org.eclipse.jdt.annotation.NonNull;

/**
 * ArrayIterable provides an Iterable for an Array
 */
public class ArrayIterable<T> implements IndexableIterable<T>
{
	protected class Iterator implements java.util.Iterator<T>
	{
		private int index = firstIndex;
		
		public boolean hasNext() {
			return index < lastIndex;
		}

		public T next() {
			return array[index++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private final T[] array;
	private final int firstIndex;
	private final int lastIndex;
	
	public ArrayIterable(T[] array) {
		this.array = array;
		this.firstIndex = 0;
		this.lastIndex = array.length;
	}
	
	public ArrayIterable(T[] array, int firstIndex, int lastIndex) {
		this.array = array;
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
	}

	public @NonNull T get(int index) {
		return DomainUtil.nonNullState(array[firstIndex + index]);
	}		
	
	public java.util.Iterator<T> iterator() {
		return new Iterator();
	}

	public int size() {
		return lastIndex - firstIndex;
	}
}
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
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

/**
 * A CompleteElementIterable supports iteration over the multiple iterable contributions
 * to a Complete Element as if all were merged in a composite element.
 *
 * @param <O> The Outer type of the Complete Element
 * @param <I> The Inner type of the iterated Complete Element child
 */
public abstract class CompleteElementIterable<O,I> implements Iterable<I>
{
	protected class Iterator implements java.util.Iterator<I>
	{
		private final java.util.Iterator<? extends O> outerIterator;
		private java.util.Iterator<I> innerIterator;
		private I nextValue;
		
		public Iterator(@NonNull Iterable<? extends O> iterables) {
			outerIterator = iterables.iterator();
			innerIterator = null;
			advance();
		}

		protected boolean advance() {
			while (true) {
				if (innerIterator != null) {
					while (innerIterator.hasNext()) {
						nextValue = getInnerValue(DomainUtil.nonNullState(innerIterator.next()));
						if (nextValue != null) {
							return true;
						}
					}
				}
				if (outerIterator.hasNext()) {
					Iterable<I> innerIterable = getInnerIterable(DomainUtil.nonNullState(outerIterator.next()));
					if (innerIterable != null) {
						innerIterator = innerIterable.iterator();
					}
				}
				else {
					break;
				}
			}
			nextValue = null;
			return false;
		}

		public boolean hasNext() {
			return nextValue != null;
//			if (innerIterator == null) {
//				return false;
//			}
//			if (innerIterator.hasNext()) {
//				return true;
//			}
//			return advance();
		}

		public I next() {
			try {
				return nextValue;
			}
			finally {
				advance();
			}
//			return innerIterator != null ? getInnerValue(innerIterator.next()) : null;
		}

		public void remove() {
			throw new IllegalStateException();
		}
	}
	
	protected final @NonNull Iterable<? extends O> iterables;
	
	public CompleteElementIterable(@NonNull Iterable<? extends O> iterables) {
		this.iterables = iterables;
	}
	
	/**
	 * Return the iterables for an inner iteration over the iterable. A null
	 * return may be used to indicate no inner iterations are necessary.
	 * 
	 * @param iterable
	 * @return the inner iterable or null for none.
	 */
	protected abstract Iterable<I> getInnerIterable(@NonNull O iterable);

	protected I getInnerValue(@NonNull I element) {
		return element;
	}

	public @NonNull java.util.Iterator<I> iterator() {
		if (iterables instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<O> list = (List<O>)iterables;
			if (list.size() == 0) {
				@SuppressWarnings("null") @NonNull UnmodifiableIterator<I> result = Iterators.<I>emptyIterator();
				return result;
			}
			else if (list.size() == 1) {
				O listEntry = list.get(0);
				if (listEntry != null) {
					Iterable<I> innerIterable = getInnerIterable(listEntry);
					if (innerIterable != null) {
						@SuppressWarnings("null") @NonNull java.util.Iterator<I> result = innerIterable.iterator();
						return result;
					}
				}
				@SuppressWarnings("null") @NonNull UnmodifiableIterator<I> result = Iterators.<I>emptyIterator();
				return result;
			}
		}
		return new Iterator(iterables);
	}
}
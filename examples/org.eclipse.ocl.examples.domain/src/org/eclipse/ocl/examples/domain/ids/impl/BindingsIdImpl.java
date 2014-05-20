/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdManager;

/**
 * BindingsIdImpl provides a hashable list of elementIds suitable for use when indexing specializations.
 */
public class BindingsIdImpl implements BindingsId, WeakHashMapOfListOfWeakReference2.MatchableId<ElementId[]>
{
	protected class Iterator implements java.util.Iterator<ElementId>
	{
		private int index = 0;
		
		public boolean hasNext() {
			return index < elementIds.length;
		}

		@SuppressWarnings("null")
		public @NonNull ElementId next() {
			return elementIds[index++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private final @NonNull ElementId[] elementIds;
	private final @NonNull Integer hashCode;

	/**
	 * Construct a BindingsId for an idManager that has computed the hashCode for the typeIds.
	 */
	public BindingsIdImpl(@NonNull IdManager idManager, @NonNull Integer hashCode, @NonNull ElementId[] elementIds) {
		this.hashCode = hashCode;
		this.elementIds = elementIds;
	}

	@Override
	public final boolean equals(Object o) {
		return o == this;
	}

	@SuppressWarnings("null")
	public @NonNull ElementId get(int i) {
		return elementIds[i];
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	public java.util.Iterator<ElementId> iterator() {
		return new Iterator();
	}

	public boolean matches(@NonNull ElementId[] thoseElementIds) {
		if (elementIds.length != thoseElementIds.length) {
			return false;
		}
		for (int i = 0; i < elementIds.length; i++) {
			if (elementIds[i] != thoseElementIds[i]) {
				return false;
			}
		}
		return true;
	}

	public int size() {
		return elementIds.length;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		for (int i = 0; i < elementIds.length; i++) {
			if (i > 0) {
				s.append(',');
			}
			s.append(String.valueOf(elementIds[i]));
		}
		s.append(')');
		return s.toString();
	}
}

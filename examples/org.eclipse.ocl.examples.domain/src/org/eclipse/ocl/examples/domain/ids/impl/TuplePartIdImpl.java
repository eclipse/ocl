/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.ids.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class TuplePartIdImpl implements TuplePartId, WeakHashMapOfListOfWeakReference4.MatchableId<Integer, String, TypeId>
{
	protected final @NonNull Integer hashCode;							
	protected final int index;							
	protected final @NonNull String name;
	protected final @NonNull TypeId typeId;
	
	public TuplePartIdImpl(@NonNull IdManager idManager, @NonNull Integer hashCode, int index, @NonNull String name, @NonNull TypeId typeId) {
		this.hashCode = hashCode;
		this.index = index;
		this.name = name;
		this.typeId = typeId;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTuplePartId(this);
	}

	public int compareTo(TuplePartId o) {
		String n1 = name;
		String n2 = o.getName();
		if (n1 == n2) {
			return 0;
		}
		return n1.compareTo(n2);
	}

	@Override
	public final boolean equals(Object obj) {
		return this == obj;
	}

	public @NonNull String getDisplayName() {
		return String.valueOf(name) + " : " + String.valueOf(typeId);
	}

	public int getIndex() {
		return index;
	}

	public @NonNull String getName() {
		return name;
	}

	public @NonNull TypeId getTypeId() {
		return typeId;
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	public boolean matches(@NonNull Integer thatIndex, @NonNull String thatName, @NonNull TypeId thatTypeid) {
		if (this.typeId != thatTypeid) {
			return false;
		}
		if (this.index != thatIndex) {
			return false;
		}
		if (!this.name.equals(thatName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(name) + " : " + String.valueOf(typeId);
	}
}
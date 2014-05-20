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
import org.eclipse.ocl.examples.domain.ids.TupleTypeId;

public class GeneralizedTupleTypeIdImpl extends AbstractTypeId implements TupleTypeId, WeakHashMapOfListOfWeakReference3.MatchableId<String, TuplePartId[]>
{
	protected final @NonNull Integer hashCode;
	protected final @NonNull String name;
	protected final @NonNull TuplePartId[] partIds;
	
	public GeneralizedTupleTypeIdImpl(@NonNull IdManager idManager, @NonNull Integer hashCode, @NonNull String name, @NonNull TuplePartId[] orderedPartIds) {
		this.hashCode = hashCode;
		this.name = name;
		this.partIds = orderedPartIds;
		assert partsAreOrdered();
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTupleTypeId(this);
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append("{");
		boolean isFirst = true;
		for (TuplePartId partId : partIds) {
			if (!isFirst) {
				s.append(", ");
			}
			s.append(partId.getDisplayName());
			isFirst = false;
		}
		s.append("}");
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull TupleTypeId getGeneralizedId() {
		return this;
	}
	
	@Override
	public @NonNull String getMetaTypeName() {
		return TUPLE_TYPE_NAME;
	}

	public @NonNull String getName() {
		return name;
	}

	public @Nullable TuplePartId getPartId(@NonNull String name) {
		for (TuplePartId partId : partIds) {
			if (name.equals(partId.getName())) {
				return partId;
			}
		}
		return null;
	}
	
	public @NonNull TuplePartId[] getPartIds() {
		return partIds;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	public boolean matches(@NonNull String thatName, @NonNull TuplePartId[] thoseOrderedParts) {
		for (int i = 0; i < partIds.length; i++) {
			if (partIds[i] != thoseOrderedParts[i]) {
				return false;
			}
		}
		if (!this.name.equals(thatName)) {
			return false;
		}
		return true;
	}

	private boolean partsAreOrdered() {
		for (int i = 0; i < partIds.length-1; i++) {
			TuplePartId earlierPartId = partIds[i];
			TuplePartId laterPartId = partIds[i+1];
			if (earlierPartId.compareTo(laterPartId) >= 0) {
				return false;
			}
		}
		return true;
	}
}
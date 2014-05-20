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
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.ids.CollectionTypeId;
import org.eclipse.ocl.examples.domain.ids.ElementId;
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.TuplePartId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class OclVoidTypeIdImpl extends UnscopedId implements OclVoidTypeId
{
	public OclVoidTypeIdImpl(@NonNull String name) {
		super(name);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitNullId(this);
	}

	public @NonNull CollectionTypeId getCollectedTypeId() {
		return this;
	}

	public @NonNull TypeId getElementId() {
		return this;
	}

	public @NonNull TypeId getElementTypeId() {
		return this;
	}

	public @NonNull OclVoidTypeIdImpl getGeneralizedId() {
		return this;
	}

	public int getIndex() {
		return 0;
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.OCL_ANY) {
			return "OCL_ANY";
		}
		else {
			return "OCL_VOID";
		}
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return "VoidType";
	}

	public @Nullable DomainElement getOrigin() {
		return null;
	}

	public @NonNull TypeId getParent() {
		return this;									// FIXME Is this safe?
	}

	public TuplePartId getPartId(@NonNull String name) {
		return null;
	}

	public @NonNull TuplePartId[] getPartIds() {
		return NULL_TUPLE_PART_ID_ARRAY;
	}

	public @NonNull OclVoidTypeIdImpl getSpecializedId(@NonNull BindingsId templateBindings) {
		return this;
	}

	public @NonNull MetaclassId getSpecializedId(@NonNull ElementId elementId) {
		return this;
	}

	public @NonNull CollectionTypeId getSpecializedId(@NonNull ElementId... templateBindings) {
		return this;
	}
}
/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.ids.ValueId;
import org.eclipse.ocl.pivot.values.Value;

public class ValueIdImpl extends AbstractElementId implements ValueId
{
	protected final @Nullable Object boxedValue;

	public ValueIdImpl(@NonNull IdManager idManager, @Nullable Object boxedValue) {
		this.boxedValue = boxedValue;
	}

	@Override
	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitValueId(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(boxedValue != null ? boxedValue.toString() : "null");
		@SuppressWarnings("null")@NonNull String string2 = s.toString();
		return string2;
	}

	public @NonNull String getMetaTypeName() {		// FIXME
		Object boxedValue2 = boxedValue;
		if (boxedValue2 == null) {
			return TypeId.OCL_VOID.getMetaTypeName();
		}
		return ((Value)boxedValue2).getTypeId().getMetaTypeName(); //TypeId.PROPERTY_NAME;
	}

	@Override
	
	public @NonNull TypeId getTypeId() {
		if (boxedValue instanceof Value) {
			return ((Value)boxedValue).getTypeId();
		}
		if (boxedValue instanceof Boolean) {
			return TypeId.BOOLEAN;
		}
		if (boxedValue instanceof String) {
			return TypeId.STRING;
		}
		if (boxedValue == null) {
			return TypeId.OCL_VOID;
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Object getValue() {
		return boxedValue;
	}

	@Override
	public final int hashCode() {
		return boxedValue != null ? boxedValue.hashCode() : 0;
	}
}
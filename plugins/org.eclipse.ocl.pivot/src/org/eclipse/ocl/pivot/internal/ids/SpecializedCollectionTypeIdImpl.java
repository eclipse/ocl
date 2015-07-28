/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.ids.ValueId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class SpecializedCollectionTypeIdImpl extends AbstractSpecializedIdImpl<CollectionTypeId> implements CollectionTypeId
{
	public SpecializedCollectionTypeIdImpl(@NonNull CollectionTypeId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
		assert templateBindings.size() == 4;
	}

	@Override
	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitCollectionTypeId(this);
	}

	@Override
	protected @NonNull CollectionTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedCollectionTypeIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull TypeId getElementTypeId() {
		return (TypeId)templateBindings.get(0);
	}

	@Override
	public @NonNull IntegerValue getLowerValue() {
		ElementId elementId = templateBindings.get(2);
		if (elementId instanceof ValueId) {
			Object boxedValue = ((ValueId)elementId).getValue();
			if (boxedValue instanceof IntegerValue) {
				return (IntegerValue)boxedValue;
			}
		}
		return ValueUtil.ZERO_VALUE;
	}

	@Override
	public @NonNull CollectionTypeId getRespecializedId(boolean isNullFree, int size) {
		ValueId nullFreeId = isNullFree == Boolean.TRUE ? ValueId.TRUE_ID : ValueId.FALSE_ID;
		IntegerValue sizeValue = ValueUtil.integerValueOf(size);
		ValueId sizeId = IdManager.getValueId(sizeValue);
		return generalizedId.getSpecializedId(getElementTypeId(), nullFreeId, sizeId, sizeId);
	}

	@Override
	public @NonNull CollectionTypeId getSpecializedId(@NonNull Type elementType,
			@Nullable Boolean isNullFree, @Nullable IntegerValue lowerValue, @Nullable UnlimitedNaturalValue upperValue) {
		return generalizedId.getSpecializedId(elementType, isNullFree,  lowerValue, upperValue);
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		ElementId elementId = templateBindings.get(3);
		if (elementId instanceof ValueId) {
			Object boxedValue = ((ValueId)elementId).getValue();
			if (boxedValue instanceof UnlimitedNaturalValue) {
				return (UnlimitedNaturalValue)boxedValue;
			}
		}
		return ValueUtil.UNLIMITED_VALUE;
	}

	@Override
	public boolean isNullFree() {
		ElementId elementId = templateBindings.get(1);
		if (elementId instanceof ValueId) {
			Object boxedValue = ((ValueId)elementId).getValue();
			if (boxedValue instanceof Boolean) {
				return ((Boolean)boxedValue).booleanValue();
			}
		}
		return false;
	}

    @Override
	public @NonNull CollectionTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}
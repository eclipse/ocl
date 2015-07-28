/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.IdHash;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.ids.ValueId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class GeneralizedCollectionTypeIdImpl extends GeneralizedTypeIdImpl<CollectionTypeId> implements CollectionTypeId
{
	public GeneralizedCollectionTypeIdImpl(@NonNull IdManager idManager, @NonNull String name) {
		super(IdHash.createGlobalHash(CollectionTypeId.class, name), 4, name);
		assert !MAP_NAME.equals(name);
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
	public @NonNull String getDisplayName() {
		return name;
	}

	@Override
	public @NonNull TemplateParameterId getElementTypeId() {
		return TypeId.T_1;
	}

	@Override
	public @NonNull CollectionTypeId getGeneralizedId() {
		return this;
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.BAG) {
			return "BAG";
		}
		else if (this == TypeId.COLLECTION) {
			return "COLLECTION";
		}
		else if (this == TypeId.ORDERED_SET) {
			return "ORDERED_SET";
		}
		else if (this == TypeId.SEQUENCE) {
			return "SEQUENCE";
		}
		else if (this == TypeId.SET) {
			return "SET";
		}
		else if (this == TypeId.UNIQUE_COLLECTION) {
			return "UNIQUE_COLLECTION";
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull IntegerValue getLowerValue() {
		return ValueUtil.ZERO_VALUE;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return name + "Type";
	}

	@Override
	public @NonNull CollectionTypeId getRespecializedId(boolean isNullFree, int size) {
		throw new UnsupportedOperationException();		// Can only respecialize a specialization.
	}

	@Override
	public @NonNull CollectionTypeId getSpecializedId(@NonNull ElementId... templateBindings) {
		int length = templateBindings.length;
		assert (1 <= length) && (length <= 4);
		if (length >= 2) {
			assert (templateBindings[1] instanceof ValueId) && (((ValueId)templateBindings[1]).getTypeId() == TypeId.BOOLEAN);
			if (length >= 3) {
				assert (templateBindings[2] instanceof ValueId) && (((ValueId)templateBindings[2]).getTypeId() == TypeId.INTEGER);
				if (length >= 4) {
					assert (templateBindings[3] instanceof ValueId) && ((((ValueId)templateBindings[3]).getTypeId() == TypeId.INTEGER) || (((ValueId)templateBindings[3]).getTypeId() == TypeId.UNLIMITED_NATURAL));
				}
			}	
		}	
		BindingsId bindingsId;
		if (length >= 4) {
			bindingsId = IdManager.getBindingsId(templateBindings);
		}
//		else if (length >= 3) {
//			bindingsId = IdManager.getBindingsId(templateBindings[0], templateBindings[1], templateBindings[2], ValueId.UNLIMITED_ID);
//		}
		else if (length >= 2) {
			bindingsId = IdManager.getBindingsId(templateBindings[0], templateBindings[1], ValueId.ZERO_ID, ValueId.UNLIMITED_ID);
		}
		else {
			bindingsId = IdManager.getBindingsId(templateBindings[0], ValueId.FALSE_ID, ValueId.ZERO_ID, ValueId.UNLIMITED_ID);	
		}
		return getSpecializedId(bindingsId);
	}

	@Override
	public @NonNull CollectionTypeId getSpecializedId(@NonNull Type elementType,
			@Nullable Boolean isNullFree, @Nullable IntegerValue lowerValue, @Nullable UnlimitedNaturalValue upperValue) {
		TypeId elementId = elementType.getTypeId();
		ValueId nullFreeId = isNullFree == Boolean.TRUE ? ValueId.TRUE_ID : ValueId.FALSE_ID;
		ValueId lowerId = IdManager.getValueId(lowerValue);
		ValueId upperId = IdManager.getValueId(upperValue);
		BindingsId bindingsId = IdManager.getBindingsId(elementId, nullFreeId, lowerId, upperId);
		return getSpecializedId(bindingsId);
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpperValue() {
		return ValueUtil.UNLIMITED_VALUE;
	}

	@Override
	public boolean isNullFree() {
		return false;
	}

    @Override
	public @NonNull CollectionTypeId specialize(@NonNull BindingsId templateBindings) {
    	return getSpecializedId(templateBindings);
	}
}
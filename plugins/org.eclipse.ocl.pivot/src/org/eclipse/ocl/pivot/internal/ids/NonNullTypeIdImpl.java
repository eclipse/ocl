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
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.NonNullTypeId;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TypeId;

public class NonNullTypeIdImpl extends AbstractElementId implements NonNullTypeId
{
	protected final @NonNull TypeId nullableTypeId;
	private /*@LazyNonNull*/ Integer hashCode = null;

	public NonNullTypeIdImpl(@NonNull TypeId nullableTypeId) {
		this.nullableTypeId = nullableTypeId;
	}

	@Override
	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return nullableTypeId.accept(visitor);					// FIXME support additional typeid
	}

	@Override
	public @NonNull String getDisplayName() {
		return "<<non-null>>" + nullableTypeId.getDisplayName();
	}

	@Override
	@NonNull
	public String getMetaTypeName() {
		return nullableTypeId.getMetaTypeName();
	}

	@Override
	public @NonNull OperationId getOperationId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
		return nullableTypeId.getOperationId(templateParameters, name, parametersId);
	}

	@Override
	public @NonNull PropertyId getPropertyId(@NonNull String name) {
		return nullableTypeId.getPropertyId(name);
	}

	@Override
	public @NonNull TemplateParameterId getTemplateParameterId(int index) {
		return nullableTypeId.getTemplateParameterId(index);
	}

	@Override
	public int getTemplateParameters() {
		return nullableTypeId.getTemplateParameters();
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return nullableTypeId;
	}

	@Override
	public int hashCode() {
		if (hashCode == null) {
			hashCode = 2 * nullableTypeId.hashCode() + 1;
		}
		return hashCode;
	}

	@Override
	public @NonNull ElementId specialize(@NonNull BindingsId templateBindings) {
		return IdManager.getNonNullTypeId((TypeId) nullableTypeId.specialize(templateBindings));
	}
}
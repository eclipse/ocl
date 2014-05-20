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
import org.eclipse.ocl.examples.domain.ids.IdVisitor;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedOperationIdImpl extends AbstractGeneralizedIdImpl<OperationId> implements OperationId, WeakHashMapOfListOfWeakReference4.MatchableId<Integer, String, ParametersId>
{
	protected final @NonNull TypeId parentId;
	protected final @NonNull ParametersId parametersId;
	
	public GeneralizedOperationIdImpl(@NonNull Integer hashCode, @NonNull TypeId parentId, int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
		super(hashCode, templateParameters, name);
		this.parentId = parentId;
		this.parametersId = parametersId;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitOperationId(this);
	}

	@Override
	protected @NonNull OperationId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedOperationIdImpl(this, templateBindings);
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		if (templateParameters > 0) {
			s.append("<" + templateParameters + ">");
		}
		s.append(parentId);
		s.append("::");
		s.append(name);
		s.append(parametersId);
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull OperationId getGeneralizedId() {
		return this;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.OPERATION_NAME;
	}

	public @NonNull ParametersId getParametersId() {
		return parametersId;
	}

	public @NonNull TypeId getParent() {
		return parentId;
	}

	public boolean matches(@NonNull Integer thoseTemplateParameters, @NonNull String thatName, @NonNull ParametersId thatParametersId) {
		if (this.parametersId != thatParametersId) {
			return false;
		}
		if (this.templateParameters != thoseTemplateParameters) {
			return false;
		}
		if (!this.name.equals(thatName)) {
			return false;
		}
		return true;
	}
}
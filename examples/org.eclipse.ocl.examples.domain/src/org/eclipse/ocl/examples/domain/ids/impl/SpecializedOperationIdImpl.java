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

public class SpecializedOperationIdImpl extends AbstractSpecializedIdImpl<OperationId> implements OperationId
{
	public SpecializedOperationIdImpl(@NonNull OperationId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitOperationId(this);
	}

	@Override
	protected @NonNull OperationId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedOperationIdImpl(this, templateBindings);
	}

	public @NonNull ParametersId getParametersId() {
		return generalizedId.getParametersId();
	}

	public @NonNull TypeId getParent() {
		return generalizedId.getParent();
	}
}
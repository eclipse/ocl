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
import org.eclipse.ocl.examples.domain.ids.LambdaTypeId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.BindingsId;

public class SpecializedLambdaTypeIdImpl extends AbstractSpecializedIdImpl<LambdaTypeId> implements LambdaTypeId
{
	public SpecializedLambdaTypeIdImpl(@NonNull LambdaTypeId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitLambdaTypeId(this);
	}

	@Override
	protected @NonNull LambdaTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedLambdaTypeIdImpl(this, templateBindings);
	}

	public @NonNull ParametersId getParametersId() {
		return generalizedId.getParametersId();
	}

    public @NonNull LambdaTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}
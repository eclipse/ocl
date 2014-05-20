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
import org.eclipse.ocl.examples.domain.ids.TypeId;

public class GeneralizedLambdaTypeIdImpl extends AbstractGeneralizedIdImpl<LambdaTypeId> implements LambdaTypeId, WeakHashMapOfListOfWeakReference3.MatchableId<String, ParametersId>
{
	protected final @NonNull ParametersId parametersId;
	
	public GeneralizedLambdaTypeIdImpl(@NonNull Integer hashCode, @NonNull String name, @NonNull ParametersId parametersId) {
		super(hashCode, 0, name);
		this.parametersId = parametersId;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitLambdaTypeId(this);
	}

	@Override
	protected @NonNull LambdaTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedLambdaTypeIdImpl(this, templateBindings);
	}

	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		if (templateParameters > 0) {
			s.append("<");
			s.append(templateParameters);
			s.append(">");
		}
		s.append(name);
		for (int i = 0; i < parametersId.size(); i++) {
			TypeId parameterId = parametersId.get(i);
			if (i == 0) {
				s.append(' ');
				s.append(parameterId.toString());
				s.append('(');
			}
			else if (i == 1) {
			}
			else if (i == 2) {
				s.append(parameterId.toString());
			}
			else {
				s.append(',');
				s.append(parameterId.toString());
			}
		}
		s.append(") : ");
		if (parametersId.size() > 1) {
			s.append(parametersId.get(1).toString());
		}
		else {
			s.append("?");
		}
		String string2 = s.toString();
		assert string2 != null;
		return string2;
	}

	public @NonNull LambdaTypeId getGeneralizedId() {
		return this;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.LAMBDA_TYPE_NAME;
	}

	public @NonNull ParametersId getParametersId() {
		return parametersId;
	}

	public boolean matches(@NonNull String thatName, @NonNull ParametersId thatParametersId) {
		if (parametersId != thatParametersId) {
			return false;
		}
		if (!this.name.equals(thatName)) {
			return false;
		}
		return true;
	}

    public @NonNull LambdaTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}
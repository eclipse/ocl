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
import org.eclipse.ocl.examples.domain.ids.MetaclassId;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;
import org.eclipse.ocl.examples.domain.ids.PropertyId;
import org.eclipse.ocl.examples.domain.ids.BindingsId;
import org.eclipse.ocl.examples.domain.ids.TemplateParameterId;
import org.eclipse.ocl.examples.domain.ids.TemplateableId;
import org.eclipse.ocl.examples.domain.ids.TypeId;

public abstract class AbstractMetaclassId extends AbstractElementId implements MetaclassId
{
	protected final int hashCode;

	protected AbstractMetaclassId(int hashCode) {
		this.hashCode = hashCode;
	}

	public @Nullable <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitMetaclassId(this);
	}

	public @NonNull MetaclassId getGeneralizedId() {
		return TypeId.METACLASS;
	}

	public @NonNull String getMetaTypeName() {
		return TypeId.METACLASS_NAME;
	}

	public @NonNull String getName() {
		return TypeId.METACLASS_NAME;
	}

	public @NonNull OperationId getOperationId(int templateParameters, @NonNull String name, @NonNull ParametersId parametersId) {
		throw new UnsupportedOperationException();
	}

    public @NonNull PropertyId getPropertyId(@NonNull String name) {
    	throw new UnsupportedOperationException();
    }
	
	public @NonNull TemplateableId getSpecializedId(@NonNull BindingsId bindings) {
		throw new UnsupportedOperationException();
	}

	@NonNull
	public TemplateParameterId getTemplateParameterId(int index) {
    	throw new UnsupportedOperationException();
	}

	public int getTemplateParameters() {
    	return 1;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}

	@NonNull
	public TypeId specialize(@NonNull BindingsId templateBindings) {
    	throw new UnsupportedOperationException();
	}
}
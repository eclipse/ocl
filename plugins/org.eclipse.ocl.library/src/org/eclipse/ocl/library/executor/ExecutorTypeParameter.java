/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.library.executor;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.elements.AbstractExecutorType;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;

public class ExecutorTypeParameter extends AbstractExecutorType implements ExecutorTypeArgument, TemplateParameter
{
	private final @NonNull TemplateParameterId typeid;

	public ExecutorTypeParameter(@NonNull TemplateParameterId typeid, @NonNull String name) {
		super(name, 0);
		this.typeid = typeid;
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @Nullable Type getLowerBound() {
		return null;
	}
	
	@Override
	public @NonNull TemplateParameterId getTemplateParameterId() {
		return typeid;
	}

	@Override
	public @NonNull TemplateParameterId getTypeId() {
		return typeid;
	}
	
	@Override
	public @Nullable org.eclipse.ocl.pivot.Class isClass() {
		return null;
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		throw new UnsupportedOperationException();			// WIP fixme
	}

	@Override
	public @NonNull TemplateParameter isTemplateParameter() {
		return this;
	}

	@Override
	public List<Class> getConstrainingClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLowerBound(Type value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TemplateSignature getOwningTemplateSignature() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOwningTemplateSignature(TemplateSignature value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Type getUpperBound() {
		return null;
	}

	@Override
	public void setUpperBound(Type value) {
		throw new UnsupportedOperationException();
	}
}
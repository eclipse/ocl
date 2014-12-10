/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.util.Visitor;

public abstract class AbstractExecutorTypedElement extends AbstractExecutorObject implements TypedElement
{
	protected final @NonNull DomainInheritance executorType;

	public AbstractExecutorTypedElement(@NonNull String name, @NonNull DomainInheritance executorType) {
		super(name);
		this.executorType = executorType;
	}

	@Override
	public boolean CompatibleBody(ValueSpecification bodySpecification) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	public <R> R accept(@NonNull Visitor<R> visitor) {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Element> allOwnedElements() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Comment> getComment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EObject getETarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<ElementExtension> getExtension() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Comment> getOwnedComment() {
		throw new UnsupportedOperationException();
	}

	@Override
	@NonNull
	public List<Element> getOwnedAnnotation() {
		throw new UnsupportedOperationException();
	}

	@Override
		public Type getType() {
	//		return executorType;
			throw new UnsupportedOperationException();
		}

	@Override
	@NonNull
	public TypeId getTypeId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Element getValue(Type stereotype, String propertyName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isMany() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isRequired() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Parameter makeParameter() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIsRequired(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setType(Type value) {
		throw new UnsupportedOperationException();
	}
}
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

public abstract class UnscopedId extends AbstractTypeId
{
	protected final @NonNull String name;
	protected final int hashCode;
	
	/**
	 * Map from the operation hashCode to the lambda typeIds with the same hash. 
	 *
	private @NonNull WeakHashMapOfListOfWeakReference<Integer, DomainParameterTypes, OperationIdImpl> memberOperations =
		new WeakHashMapOfListOfWeakReference<Integer, DomainParameterTypes, OperationIdImpl>()
		{
			@Override
			protected @NonNull OperationIdImpl newTypeId(@NonNull Integer hashCode, @NonNull DomainParameterTypes parameterTypes, @NonNull String name) {
				return new OperationIdImpl(UnscopedId.this, name, parameterTypes, hashCode);
			}		
		}; */

	/**
	 * Map from a type parameter name to the corresponding TypeParameterId. 
	 *
	private @NonNull WeakHashMapOfWeakReference<String, TypeTemplateParameterId> typeParameters = new WeakHashMapOfWeakReference<String, TypeTemplateParameterId>()
		{
			@Override
			protected @NonNull TypeTemplateParameterId newTypeId(@NonNull String name) {
				return new TypeParameterIdImpl(UnscopedId.this, name);
			}
		}; */

	protected UnscopedId(@NonNull String name) {
		this.name = name;
		this.hashCode = name.hashCode();
	}

	public @NonNull String getDisplayName() {
		return name;
	}

	public @NonNull String getName() {
		return name;
	}

/*	@Override
	public @NonNull OperationId getOperationId(@NonNull DomainOperation anOperation) {
		String name = anOperation.getName();
		assert name != null;
		DomainTypeParameters typeParameters = anOperation.getTypeParameters();
		int hashCode = 47 * hashCode() + 37 * name.hashCode() + typeParameters.hashCode();
		return memberOperations.getTypeId(hashCode, anOperation.getParameterTypes(), name);
	} */

//    @Override
//	public @NonNull TypeTemplateParameterId getTypeParameterId(final @NonNull String name) {
//    	return typeParameters.getElementId(name);
//    }

	@Override
	public final int hashCode() {
		return hashCode;
	}
}
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
import org.eclipse.ocl.domain.elements.DomainClass;
import org.eclipse.ocl.domain.elements.DomainInheritance;
import org.eclipse.ocl.domain.elements.DomainOperation;
import org.eclipse.ocl.domain.elements.DomainParameter;
import org.eclipse.ocl.domain.elements.DomainParameterTypes;
import org.eclipse.ocl.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.domain.elements.DomainType;
import org.eclipse.ocl.domain.elements.DomainTypeParameters;
import org.eclipse.ocl.domain.ids.OperationId;
import org.eclipse.ocl.domain.ids.ParametersId;
import org.eclipse.ocl.domain.ids.TypeId;
import org.eclipse.ocl.domain.library.LibraryFeature;
import org.eclipse.ocl.library.oclany.OclAnyUnsupportedOperation;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.LanguageExpression;

public class ExecutorOperation implements DomainOperation
{
	protected final @NonNull String name;
	protected final @NonNull DomainParameterTypes parameterTypes;
	protected final @NonNull DomainInheritance inheritance;
	protected final int index;
	protected final @NonNull LibraryFeature implementation;
	protected final @NonNull DomainTypeParameters typeParameters;
	
	public ExecutorOperation(@NonNull String name, @NonNull DomainParameterTypes parameterTypes, @NonNull DomainInheritance inheritance, int index, @NonNull DomainTypeParameters typeParameters, @Nullable LibraryFeature implementation) {
		this.name = name;
		this.parameterTypes = parameterTypes;
		this.inheritance = inheritance;
		this.index = index;
		this.implementation = implementation != null ? implementation : OclAnyUnsupportedOperation.INSTANCE;		// FIXME
		this.typeParameters = typeParameters;
	}

	@Override
	public @NonNull LibraryFeature getImplementation() {
		return implementation;
	}

	@Override
	public LanguageExpression getBodyExpression() {
		throw new UnsupportedOperationException(); 			// FIXME
	}

	@Override
	public final int getIndex() {
		return index;
	}

	@Override
	public final @NonNull DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary) {
		return inheritance;
	}

	@Override
	public final String getName() {
		return name;
	}

	@Override
	public @NonNull OperationId getOperationId() {
		throw new UnsupportedOperationException();			// FIXME
	}
	
	@Override
	public @NonNull List<? extends DomainParameter> getOwnedParameter() {
		return getParameterTypes().getParameters();
	}

	public @NonNull List<? extends Constraint> getOwnedRule() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public @NonNull DomainClass getOwningClass() {
		throw new UnsupportedOperationException();			// FIXME
	}

	@Override
	public @NonNull ParametersId getParametersId() {
		return parameterTypes.getParametersId();
	}
	
	@Override
	public @NonNull DomainParameterTypes getParameterTypes() {
		return parameterTypes;
	}

	
	@Override
	public @NonNull List<? extends Constraint> getPostcondition() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); // WIP FIXME
	}

	@Override
	public @NonNull List<? extends Constraint> getPrecondition() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); // WIP FIXME
	}

	@Override
	public @NonNull DomainType getType() {
//		return executorType;
		throw new UnsupportedOperationException(); // WIP FIXME
	}

	@Override
	public @NonNull TypeId getTypeId() {
		DomainType type2 = getType();
		return type2.getTypeId();
	}

	@Override
	public @NonNull DomainTypeParameters getTypeParameters() {
		return typeParameters;
	}

	@Override
	public boolean isStatic() {
		return false;								// WIP FIXME
	}

	@Override
	public String toString() {
		return inheritance.toString() + "::" + name; //$NON-NLS-1$
	}
}

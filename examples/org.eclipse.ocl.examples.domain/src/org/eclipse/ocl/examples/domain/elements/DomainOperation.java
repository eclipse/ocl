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
package org.eclipse.ocl.examples.domain.elements;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.ids.OperationId;
import org.eclipse.ocl.examples.domain.ids.ParametersId;

public interface DomainOperation extends DomainFeature
{
	/**
	 * Return the index of this operation in the operation dispatch table.
	 */
	int getIndex();

	DomainExpression getBodyExpression();

	/**
	 * Return the Inheritance dispatch table for the owning type, or null for am orphan property owned by an Annotation.
	 */
	@Nullable DomainInheritance getInheritance(@NonNull DomainStandardLibrary standardLibrary);
	
	/**
	 * Return the unique identity of the ordered list of parameters of this operation.
	 */
	@NonNull ParametersId getParametersId();
	
	/**
	 * Return the ordered list of parameters of this operation.
	 */
	@NonNull DomainParameterTypes getParameterTypes();
	
	@NonNull List<? extends DomainConstraint> getPostcondition();
	
	@NonNull List<? extends DomainConstraint> getPrecondition();

	/**
	 * Return the ordered list of type parameters of this operation.
	 */
	@NonNull DomainTypeParameters getTypeParameters();

	@NonNull OperationId getOperationId();
	@NonNull List<? extends DomainTypedElement> getOwnedParameter();
}

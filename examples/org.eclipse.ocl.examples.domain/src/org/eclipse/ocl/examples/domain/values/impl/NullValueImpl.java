/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.ids.OclVoidTypeId;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.domain.values.NullValue;
import org.eclipse.ocl.examples.domain.values.OCLValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * An InvalidValueException wraps an InvalidValue and is used to return the InvalidValue
 * to the caller. Exceptions are a
 * is thrown when an Invalid Value arises during
 * an evaluation, and when no EvaluationEnvironment is available to support
 * throwing an InvalidEvaluationException. When such an environment is
 * available the InvalidValueException is rethrown as an 
 * InvalidEvaluationException.
 *
 * * @generated NOT
 */
public class NullValueImpl extends UndefinedValueImpl implements NullValue
{	
	private static final long serialVersionUID = 1L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.NULL_VALUE;
	}
	
	public NullValueImpl() {
		super(null, null);
	}

	@Deprecated // Use asEcoreObject(@NonNull IdResolver idResolver)
	public List<Object> asEcoreObject() {
		return null;
	}
	
	public List<Object> asEcoreObject(@NonNull IdResolver idResolver) {
		return null;
	}

	public DomainElement asElement() {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof NullValueImpl;
	}

	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		return standardLibrary.getOclInvalidType();
	}

	@Override
	public @NonNull OclVoidTypeId getTypeId() {
		return TypeId.OCL_VOID;
	}

	@Override
	public int hashCode() {
		return 0x33333337;
	}

	public int intValue() {
    	toInvalidValue();		// throws rather than returns
    	return 0;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean oclEquals(@NonNull OCLValue thatValue) {
		return equals(thatValue);
	}

	public int oclHashCode() {
		return hashCode();
	}

	@Override
	public String toString() {
		return "null";
	}
}

/*******************************************************************************
 * Copyright (c) 2011, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.domain.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.values.ObjectValue;
import org.eclipse.ocl.examples.domain.values.ValuesPackage;

/**
 * @generated NOT
 */
public abstract class ObjectValueImpl extends ValueImpl implements ObjectValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.OBJECT_VALUE;
	}
	
	protected ObjectValueImpl() {}

	public @NonNull Object asObject() {
		return getObject();
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ObjectValue)) {
			return false;
		}
		return getObject().equals(((ObjectValue)obj).getObject());
	}

	public abstract @NonNull Object getObject();

	@Override
	public int hashCode() {
		return getObject().hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(getObject());
	}
}

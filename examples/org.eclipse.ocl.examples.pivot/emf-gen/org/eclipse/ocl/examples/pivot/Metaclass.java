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
package org.eclipse.ocl.examples.pivot;





/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Type</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainMetaclass
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Metaclass#getInstanceType <em>Instance Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMetaclass()
 * @generated
 */
public interface Metaclass<T> extends org.eclipse.ocl.examples.pivot.Class, org.eclipse.ocl.examples.domain.elements.DomainMetaclass
{
	/**
	 * Returns the value of the '<em><b>Instance Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Type</em>' reference.
	 * @see #setInstanceType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMetaclass_InstanceType()
	 * @generated
	 */
	Type getInstanceType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Metaclass#getInstanceType <em>Instance Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Type</em>' reference.
	 * @see #getInstanceType()
	 * @generated
	 */
	void setInstanceType(Type value);

} // Metaclass

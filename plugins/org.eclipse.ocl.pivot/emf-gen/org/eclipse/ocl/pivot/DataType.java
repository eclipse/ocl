/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DataType is a type whose instances are identified only by their value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.DataType#getBehavioralClass <em>Behavioral Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.DataType#isIsSerializable <em>Is Serializable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getDataType()
 * @generated
 */
public interface DataType
		extends org.eclipse.ocl.pivot.Class {

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.DataType#isIsSerializable <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Serializable</em>' attribute.
	 * @see #isIsSerializable()
	 * @generated
	 */
	void setIsSerializable(boolean value);

	/**
	 * Returns the value of the '<em><b>Behavioral Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioral Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavioral Class</em>' reference.
	 * @see #setBehavioralClass(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getDataType_BehavioralClass()
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getBehavioralClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.DataType#getBehavioralClass <em>Behavioral Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavioral Class</em>' reference.
	 * @see #getBehavioralClass()
	 * @generated
	 */
	void setBehavioralClass(org.eclipse.ocl.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Is Serializable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Serializable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Serializable</em>' attribute.
	 * @see #setIsSerializable(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getDataType_IsSerializable()
	 * @generated
	 */
	boolean isIsSerializable();
} // DataType

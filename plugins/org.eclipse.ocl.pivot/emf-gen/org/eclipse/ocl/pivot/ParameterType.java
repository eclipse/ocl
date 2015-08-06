/**
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.ParameterType#isIsNonNull <em>Is Non Null</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ParameterType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getParameterType()
 * @generated
 */
public interface ParameterType extends Element
{
	/**
	 * Returns the value of the '<em><b>Is Non Null</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Non Null</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Non Null</em>' attribute.
	 * @see #setIsNonNull(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getParameterType_IsNonNull()
	 * @generated
	 */
	boolean isIsNonNull();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ParameterType#isIsNonNull <em>Is Non Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Non Null</em>' attribute.
	 * @see #isIsNonNull()
	 * @generated
	 */
	void setIsNonNull(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getParameterType_Type()
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ParameterType#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	@NonNull TypeId getTypeId();

} // ParameterType

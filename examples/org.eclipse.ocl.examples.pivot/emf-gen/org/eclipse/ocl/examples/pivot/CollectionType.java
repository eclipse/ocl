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
package org.eclipse.ocl.examples.pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.values.IntegerValue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainCollectionType
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionType#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionType#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionType#getUpper <em>Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionType()
 * @generated
 */
public interface CollectionType
		extends DataType, org.eclipse.ocl.examples.domain.elements.DomainCollectionType {

	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionType_ElementType()
	 * @generated
	 */
	Type getElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CollectionType#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(Type value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(Number)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionType_Lower()
	 * @generated
	 */
	Number getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CollectionType#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(Number value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * The default value is <code>"*"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(Number)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionType_Upper()
	 * @generated
	 */
	Number getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CollectionType#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(Number value);

	void setLowerValue(@NonNull IntegerValue lower);
	void setUpperValue(@NonNull IntegerValue upper);
} // CollectionType

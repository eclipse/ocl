/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsNotUnique <em>Is Not Unique</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsOptional <em>Is Optional</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedElementCS()
 * @model abstract="true"
 * @generated
 */
public interface TypedElementCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Is Not Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Not Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Not Unique</em>' attribute.
	 * @see #setIsNotUnique(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedElementCS_IsNotUnique()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsNotUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsNotUnique <em>Is Not Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Not Unique</em>' attribute.
	 * @see #isIsNotUnique()
	 * @generated
	 */
	void setIsNotUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference.
	 * @see #setOwnedType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedElementCS_OwnedType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Optional</em>' attribute.
	 * @see #setIsOptional(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedElementCS_IsOptional()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsOptional();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsOptional <em>Is Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Optional</em>' attribute.
	 * @see #isIsOptional()
	 * @generated
	 */
	void setIsOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedElementCS_IsOrdered()
	 * @model default="false" dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedElementCS#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

} // TypedElementCS

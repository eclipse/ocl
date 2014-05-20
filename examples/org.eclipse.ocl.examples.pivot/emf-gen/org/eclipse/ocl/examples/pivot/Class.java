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

import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A class is a type that has objects as its instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#isActive <em>Is Active</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#isInterface <em>Is Interface</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getNestedType <em>Nested Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getOwnedBehavior <em>Owned Behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_()
 * @generated
 */
public interface Class
		extends Type, Namespace {

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True when a class is abstract.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_IsAbstract()
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#isAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Active</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True when a class is active.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Active</em>' attribute.
	 * @see #setIsActive(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_IsActive()
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#isActive <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setIsActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Behavior</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Behavior</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_OwnedBehavior()
	 * @generated
	 */
	List<Behavior> getOwnedBehavior();

	/**
	 * Returns the value of the '<em><b>Is Interface</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Interface</em>' attribute.
	 * @see #setIsInterface(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_IsInterface()
	 * @generated
	 */
	boolean isInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#isInterface <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Interface</em>' attribute.
	 * @see #isInterface()
	 * @generated
	 */
	void setIsInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Nested Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Type</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_NestedType()
	 * @generated
	 */
	List<Class> getNestedType();

} // Class

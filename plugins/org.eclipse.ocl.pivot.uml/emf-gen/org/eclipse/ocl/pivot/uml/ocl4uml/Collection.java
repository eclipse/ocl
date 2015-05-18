/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.ocl4uml;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies the null-free-ness of a Collection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collection#getBase_TypedElement <em>Base Typed Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collection#isNullFree <em>Is Null Free</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getCollection()
 * @model
 * @generated
 */
public interface Collection
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Is Null Free</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the type of the TypedElement is a null-free Collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Null Free</em>' attribute.
	 * @see #setIsNullFree(boolean)
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getCollection_IsNullFree()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isNullFree();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collection#isNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Null Free</em>' attribute.
	 * @see #isNullFree()
	 * @generated
	 */
	void setIsNullFree(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Typed Element</em>' reference.
	 * @see #setBase_TypedElement(TypedElement)
	 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage#getCollection_Base_TypedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TypedElement getBase_TypedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.ocl4uml.Collection#getBase_TypedElement <em>Base Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Typed Element</em>' reference.
	 * @see #getBase_TypedElement()
	 * @generated
	 */
	void setBase_TypedElement(TypedElement value);

} // Collection

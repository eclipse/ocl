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



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * @implements org.eclipse.ocl.examples.domain.elements.DomainParameter
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A parameter is a typed element that represents a parameter of an operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Parameter#isTypeof <em>Is Typeof</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Parameter#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getParameter()
 * @generated
 */
public interface Parameter
		extends VariableDeclaration, org.eclipse.ocl.examples.domain.elements.DomainParameter {

	/**
	 * Returns the value of the '<em><b>Is Typeof</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Typeof</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Typeof</em>' attribute.
	 * @see #setIsTypeof(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getParameter_IsTypeof()
	 * @generated
	 */
	boolean isTypeof();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Parameter#isTypeof <em>Is Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Typeof</em>' attribute.
	 * @see #isTypeof()
	 * @generated
	 */
	void setIsTypeof(boolean value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Operation#getOwnedParameter <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operation that owns the parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(Operation)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getParameter_Operation()
	 * @see org.eclipse.ocl.examples.pivot.Operation#getOwnedParameter
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Parameter#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // Parameter

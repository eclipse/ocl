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
 * A representation of the model object '<em><b>Enumeration Literal</b></em>'.
 * @implements org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An enumeration literal is a value of an enumeration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getEnumerationLiteral()
 * @generated
 */
public interface EnumerationLiteral
		extends NamedElement, org.eclipse.ocl.examples.domain.elements.DomainEnumerationLiteral {

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Enumeration#getOwnedLiteral <em>Owned Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Enumeration that this EnumerationLiteral is a member of.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enumeration</em>' container reference.
	 * @see #setEnumeration(Enumeration)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getEnumerationLiteral_Enumeration()
	 * @see org.eclipse.ocl.examples.pivot.Enumeration#getOwnedLiteral
	 * @generated
	 */
	Enumeration getEnumeration();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getEnumeration <em>Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' container reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(Enumeration value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Number)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getEnumerationLiteral_Value()
	 * @generated
	 */
	Number getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.EnumerationLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Number value);

} // EnumerationLiteral

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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract If Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.AbstractIfExp#isIsElseIf <em>Is Else If</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.AbstractIfExp#getOwnedElse <em>Owned Else</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.AbstractIfExp#getOwnedThen <em>Owned Then</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getAbstractIfExp()
 * @generated
 */
public interface AbstractIfExp extends OCLExpression
{
	/**
	 * Returns the value of the '<em><b>Is Else If</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this IfExp corresponds to an 'elseif' in the OCL source, false if it corresponds to an 'if'. This attribute has no semantic significance; it merely supports more faithful reconstruction of the OCL source by a pretty printer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Else If</em>' attribute.
	 * @see #setIsElseIf(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getAbstractIfExp_IsElseIf()
	 * @generated
	 */
	boolean isIsElseIf();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.AbstractIfExp#isIsElseIf <em>Is Else If</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Else If</em>' attribute.
	 * @see #isIsElseIf()
	 * @generated
	 */
	void setIsElseIf(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Else</em>' containment reference.
	 * @see #setOwnedElse(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getAbstractIfExp_OwnedElse()
	 * @generated
	 */
	OCLExpression getOwnedElse();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.AbstractIfExp#getOwnedElse <em>Owned Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Else</em>' containment reference.
	 * @see #getOwnedElse()
	 * @generated
	 */
	void setOwnedElse(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Then</em>' containment reference.
	 * @see #setOwnedThen(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getAbstractIfExp_OwnedThen()
	 * @generated
	 */
	OCLExpression getOwnedThen();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.AbstractIfExp#getOwnedThen <em>Owned Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Then</em>' containment reference.
	 * @see #getOwnedThen()
	 * @generated
	 */
	void setOwnedThen(OCLExpression value);

} // AbstractIfExp

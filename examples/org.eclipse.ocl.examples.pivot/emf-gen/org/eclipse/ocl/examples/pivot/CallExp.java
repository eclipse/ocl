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
 * A representation of the model object '<em><b>Call Exp</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainCallExp
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CallExp#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CallExp#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCallExp()
 * @generated
 */
public interface CallExp
		extends OCLExpression, org.eclipse.ocl.examples.domain.elements.DomainCallExp {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCallExp_Source()
	 * @generated
	 */
	OCLExpression getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CallExp#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Implicit</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit</em>' attribute.
	 * @see #setImplicit(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCallExp_Implicit()
	 * @generated
	 */
	boolean isImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CallExp#isImplicit <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit</em>' attribute.
	 * @see #isImplicit()
	 * @generated
	 */
	void setImplicit(boolean value);

} // CallExp

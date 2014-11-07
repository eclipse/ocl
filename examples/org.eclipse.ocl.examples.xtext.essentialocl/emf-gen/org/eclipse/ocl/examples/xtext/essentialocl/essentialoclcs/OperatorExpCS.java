/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getOwnedSource <em>Owned Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getDerivedSource <em>Derived Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getDerivedParent <em>Derived Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getDerivedPrecedence <em>Derived Precedence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS()
 * @model abstract="true"
 * @generated
 */
public interface OperatorExpCS
		extends ExpCS, NamedElementCS {

	/**
	 * Returns the value of the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Source</em>' containment reference.
	 * @see #setOwnedSource(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_OwnedSource()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getOwnedSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getOwnedSource <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Source</em>' containment reference.
	 * @see #getOwnedSource()
	 * @generated
	 */
	void setOwnedSource(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_Source()
	 * @model resolveProxies="false" required="true" transient="true"
	 * @generated
	 */
	ExpCS getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Derived Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Source</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_DerivedSource()
	 * @model resolveProxies="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	ExpCS getDerivedSource();

	/**
	 * Returns the value of the '<em><b>Derived Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Parent</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_DerivedParent()
	 * @model resolveProxies="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	ExpCS getDerivedParent();

	/**
	 * Returns the value of the '<em><b>Derived Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Precedence</em>' reference.
	 * @see #setDerivedPrecedence(Precedence)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_DerivedPrecedence()
	 * @model resolveProxies="false" transient="true" derived="true"
	 * @generated
	 */
	@NonNull Precedence getDerivedPrecedence();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS#getDerivedPrecedence <em>Derived Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived Precedence</em>' reference.
	 * @see #getDerivedPrecedence()
	 * @generated
	 */
	void setDerivedPrecedence(Precedence value);

	/**
	 * Returns the value of the '<em><b>Derived Right Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Right Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Right Precedence</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_DerivedRightPrecedence()
	 * @model resolveProxies="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
//	Precedence getDerivedRightPrecedence();

	/**
	 * Returns the value of the '<em><b>Derived Left Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Left Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Left Precedence</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getOperatorExpCS_DerivedLeftPrecedence()
	 * @model resolveProxies="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
//	Precedence getDerivedLeftPrecedence();

} // OperatorCS

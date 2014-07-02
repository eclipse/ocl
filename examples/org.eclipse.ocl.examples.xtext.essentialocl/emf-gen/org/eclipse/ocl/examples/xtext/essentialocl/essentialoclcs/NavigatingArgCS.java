/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigating Arg CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getRoundBracketedClause <em>Round Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getInit <em>Init</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS()
 * @model
 * @generated
 */
public interface NavigatingArgCS
		extends ModelElementCS {

	/**
	 * Returns the value of the '<em><b>Round Bracketed Clause</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Round Bracketed Clause</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Round Bracketed Clause</em>' container reference.
	 * @see #setRoundBracketedClause(RoundBracketedClauseCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_RoundBracketedClause()
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getArguments
	 * @model opposite="arguments" transient="false"
	 * @generated
	 */
	RoundBracketedClauseCS getRoundBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getRoundBracketedClause <em>Round Bracketed Clause</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Round Bracketed Clause</em>' container reference.
	 * @see #getRoundBracketedClause()
	 * @generated
	 */
	void setRoundBracketedClause(RoundBracketedClauseCS value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole
	 * @see #setRole(NavigationRole)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_Role()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	NavigationRole getRole();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigationRole
	 * @see #getRole()
	 * @generated
	 */
	void setRole(NavigationRole value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_Prefix()
	 * @model
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_Name()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(ExpCS value);

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
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_OwnedType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' containment reference.
	 * @see #setInit(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_Init()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getInit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NavigatingArgCS#getInit <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' containment reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(ExpCS value);

} // NavigatingArgCS

/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getLetExpression <em>Let Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getRoundBracketedClause <em>Round Bracketed Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getLetVariableCS()
 * @model
 * @generated
 */
public interface LetVariableCS
		extends VariableCS, ExpCS {

	/**
	 * Returns the value of the '<em><b>Let Expression</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Let Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Let Expression</em>' container reference.
	 * @see #setLetExpression(LetExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getLetVariableCS_LetExpression()
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS#getVariable
	 * @model opposite="variable" transient="false"
	 * @generated
	 */
	LetExpCS getLetExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getLetExpression <em>Let Expression</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Let Expression</em>' container reference.
	 * @see #getLetExpression()
	 * @generated
	 */
	void setLetExpression(LetExpCS value);

	/**
	 * Returns the value of the '<em><b>Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Round Bracketed Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Round Bracketed Clause</em>' containment reference.
	 * @see #setRoundBracketedClause(RoundBracketedClauseCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getLetVariableCS_RoundBracketedClause()
	 * @model containment="true"
	 * @generated
	 */
	RoundBracketedClauseCS getRoundBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS#getRoundBracketedClause <em>Round Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Round Bracketed Clause</em>' containment reference.
	 * @see #getRoundBracketedClause()
	 * @generated
	 */
	void setRoundBracketedClause(RoundBracketedClauseCS value);

} // VariableCS

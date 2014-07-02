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

package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#isAtPre <em>At Pre</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getCurlyBracketedClause <em>Curly Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getRoundBracketedClause <em>Round Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getSquareBracketedClauses <em>Square Bracketed Clauses</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getSourceType <em>Source Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNameExpCS()
 * @model
 * @generated
 */
public interface NameExpCS
		extends ExpCS {

	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' containment reference.
	 * @see #setPathName(PathNameCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNameExpCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getPathName <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' containment reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>At Pre</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>At Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Pre</em>' attribute.
	 * @see #setAtPre(boolean)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNameExpCS_AtPre()
	 * @model default="false"
	 * @generated
	 */
	boolean isAtPre();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#isAtPre <em>At Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Pre</em>' attribute.
	 * @see #isAtPre()
	 * @generated
	 */
	void setAtPre(boolean value);

	/**
	 * Returns the value of the '<em><b>Curly Bracketed Clause</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getNameExp <em>Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curly Bracketed Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curly Bracketed Clause</em>' containment reference.
	 * @see #setCurlyBracketedClause(CurlyBracketedClauseCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNameExpCS_CurlyBracketedClause()
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CurlyBracketedClauseCS#getNameExp
	 * @model opposite="nameExp" containment="true"
	 * @generated
	 */
	CurlyBracketedClauseCS getCurlyBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getCurlyBracketedClause <em>Curly Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curly Bracketed Clause</em>' containment reference.
	 * @see #getCurlyBracketedClause()
	 * @generated
	 */
	void setCurlyBracketedClause(CurlyBracketedClauseCS value);

	/**
	 * Returns the value of the '<em><b>Round Bracketed Clause</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getNameExp <em>Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Round Bracketed Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Round Bracketed Clause</em>' containment reference.
	 * @see #setRoundBracketedClause(RoundBracketedClauseCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNameExpCS_RoundBracketedClause()
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS#getNameExp
	 * @model opposite="nameExp" containment="true"
	 * @generated
	 */
	RoundBracketedClauseCS getRoundBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getRoundBracketedClause <em>Round Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Round Bracketed Clause</em>' containment reference.
	 * @see #getRoundBracketedClause()
	 * @generated
	 */
	void setRoundBracketedClause(RoundBracketedClauseCS value);

	/**
	 * Returns the value of the '<em><b>Square Bracketed Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS#getNameExp <em>Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Square Bracketed Clauses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Square Bracketed Clauses</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNameExpCS_SquareBracketedClauses()
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.SquareBracketedClauseCS#getNameExp
	 * @model opposite="nameExp" containment="true" upper="2"
	 * @generated
	 */
	@NonNull EList<SquareBracketedClauseCS> getSquareBracketedClauses();

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For explicit source invocations, sourceType provides the true source type after resolution of implicit set or implicit collect.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Type</em>' reference.
	 * @see #setSourceType(Type)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getNameExpCS_SourceType()
	 * @model resolveProxies="false" transient="true" derived="true"
	 * @generated
	 */
	Type getSourceType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS#getSourceType <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' reference.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(Type value);
} // NamedElementRefCS

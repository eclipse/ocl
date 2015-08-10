/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lambda Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS()
 * @model superTypes="org.eclipse.ocl.xtext.essentialoclcs.LiteralExpCS org.eclipse.ocl.pivot.Nameable"
 * @generated
 */
public interface LambdaLiteralExpCS extends LiteralExpCS, Nameable
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS_Name()
	 * @model
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS_OwnedExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS_OwnedParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedParameters();

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
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS_OwnedType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypedRefCS getOwnedType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(TypedRefCS value);

} // LambdaLiteralExpCS

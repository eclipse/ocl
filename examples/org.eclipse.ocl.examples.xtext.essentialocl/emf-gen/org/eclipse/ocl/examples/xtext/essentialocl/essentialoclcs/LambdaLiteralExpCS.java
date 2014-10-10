/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
 * A representation of the model object '<em><b>Lambda Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS()
 * @model
 * @generated
 */
public interface LambdaLiteralExpCS extends LiteralExpCS
{
	/**
	 * Returns the value of the '<em><b>Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression CS</em>' containment reference.
	 * @see #setExpressionCS(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS_ExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LambdaLiteralExpCS#getExpressionCS <em>Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression CS</em>' containment reference.
	 * @see #getExpressionCS()
	 * @generated
	 */
	void setExpressionCS(ExpCS value);

} // LambdaLiteralExpCS

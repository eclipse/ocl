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

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lambda Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.LambdaLiteralExp#getOwnedBody <em>Owned Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LambdaLiteralExp#getOwnedParameters <em>Owned Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getLambdaLiteralExp()
 * @generated
 */
public interface LambdaLiteralExp extends LiteralExp
{
	/**
	 * Returns the value of the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body</em>' containment reference.
	 * @see #setOwnedBody(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLambdaLiteralExp_OwnedBody()
	 * @generated
	 */
	OCLExpression getOwnedBody();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LambdaLiteralExp#getOwnedBody <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Body</em>' containment reference.
	 * @see #getOwnedBody()
	 * @generated
	 */
	void setOwnedBody(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLambdaLiteralExp_OwnedParameters()
	 * @generated
	 */
	List<Parameter> getOwnedParameters();

} // LambdaLiteralExp

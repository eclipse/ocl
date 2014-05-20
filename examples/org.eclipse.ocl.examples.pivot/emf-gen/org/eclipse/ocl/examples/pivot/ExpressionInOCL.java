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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression In Ocl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getContextVariable <em>Context Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getParameterVariable <em>Parameter Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getResultVariable <em>Result Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOCL()
 * @generated
 */
public interface ExpressionInOCL
		extends OpaqueExpression {

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOCL_BodyExpression()
	 * @generated
	 */
	OCLExpression getBodyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Context Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Variable</em>' containment reference.
	 * @see #setContextVariable(Variable)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOCL_ContextVariable()
	 * @generated
	 */
	Variable getContextVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getContextVariable <em>Context Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Variable</em>' containment reference.
	 * @see #getContextVariable()
	 * @generated
	 */
	void setContextVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Result Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Variable</em>' containment reference.
	 * @see #setResultVariable(Variable)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOCL_ResultVariable()
	 * @generated
	 */
	Variable getResultVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ExpressionInOCL#getResultVariable <em>Result Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Variable</em>' containment reference.
	 * @see #getResultVariable()
	 * @generated
	 */
	void setResultVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Parameter Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Variable</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOCL_ParameterVariable()
	 * @generated
	 */
	@NonNull List<Variable> getParameterVariable();

} // ExpressionInOCL

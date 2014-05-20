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

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Variable#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Variable#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable()
 * @generated
 */
public interface Variable
		extends VariableDeclaration {

	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable_InitExpression()
	 * @generated
	 */
	OCLExpression getInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Variable#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Parameter</em>' reference.
	 * @see #setRepresentedParameter(Parameter)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable_RepresentedParameter()
	 * @generated
	 */
	Parameter getRepresentedParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Parameter</em>' reference.
	 * @see #getRepresentedParameter()
	 * @generated
	 */
	void setRepresentedParameter(Parameter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleInitialiserType(DiagnosticChain diagnostics, Map<Object, Object> context);

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
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable_Implicit()
	 * @generated
	 */
	boolean isImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Variable#isImplicit <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit</em>' attribute.
	 * @see #isImplicit()
	 * @generated
	 */
	void setImplicit(boolean value);

} // Variable

/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
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
 * A representation of the model object '<em><b>Lambda Type</b></em>'.
 * @implements org.eclipse.ocl.examples.domain.elements.DomainLambdaType
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.LambdaType#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.LambdaType#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.LambdaType#getResultType <em>Result Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getLambdaType()
 * @generated
 */
public interface LambdaType extends DataType, org.eclipse.ocl.examples.domain.elements.DomainLambdaType
{
	/**
	 * Returns the value of the '<em><b>Context Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Type</em>' reference.
	 * @see #setContextType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getLambdaType_ContextType()
	 * @generated
	 */
	Type getContextType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.LambdaType#getContextType <em>Context Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Type</em>' reference.
	 * @see #getContextType()
	 * @generated
	 */
	void setContextType(Type value);

	/**
	 * Returns the value of the '<em><b>Parameter Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Type</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getLambdaType_ParameterType()
	 * @generated
	 */
	@NonNull List<Type> getParameterType();

	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' reference.
	 * @see #setResultType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getLambdaType_ResultType()
	 * @generated
	 */
	Type getResultType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.LambdaType#getResultType <em>Result Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' reference.
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(Type value);

} // LambdaType

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
package org.eclipse.ocl.examples.xtext.completeocl.completeoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS()
 * @model
 * @generated
 */
public interface OperationContextDeclCS
		extends FeatureContextDeclCS {

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_Operation()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getParameters();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(VariableCS)
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_Result()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	VariableCS getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.OperationContextDeclCS#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(VariableCS value);

	/**
	 * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_Preconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getPreconditions();

	/**
	 * Returns the value of the '<em><b>Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_Postconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getPostconditions();

	/**
	 * Returns the value of the '<em><b>Bodies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bodies</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_Bodies()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpSpecificationCS> getBodies();

} // OperationContextDeclCS

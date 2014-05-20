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
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp()
 * @generated
 */
public interface MessageExp
		extends OCLExpression {

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(OCLExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_Target()
	 * @generated
	 */
	OCLExpression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_Argument()
	 * @generated
	 */
	List<OCLExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Operation</em>' containment reference.
	 * @see #setCalledOperation(CallOperationAction)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_CalledOperation()
	 * @generated
	 */
	CallOperationAction getCalledOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Operation</em>' containment reference.
	 * @see #getCalledOperation()
	 * @generated
	 */
	void setCalledOperation(CallOperationAction value);

	/**
	 * Returns the value of the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sent Signal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sent Signal</em>' containment reference.
	 * @see #setSentSignal(SendSignalAction)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_SentSignal()
	 * @generated
	 */
	SendSignalAction getSentSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sent Signal</em>' containment reference.
	 * @see #getSentSignal()
	 * @generated
	 */
	void setSentSignal(SendSignalAction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateOneCallOrOneSend(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTargetIsNotACollection(DiagnosticChain diagnostics, Map<Object, Object> context);
} // MessageExp

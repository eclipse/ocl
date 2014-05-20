/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Point Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A connection point reference represents a usage (as part of a submachine state) of an entry/exit point defined in the statemachine reference by the submachine state.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getExit <em>Exit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConnectionPointReference()
 * @generated
 */
public interface ConnectionPointReference extends Vertex
{
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entryPoint kind pseudo states corresponding to this connection point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entry</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConnectionPointReference_Entry()
	 * @generated
	 */
	List<Pseudostate> getEntry();

	/**
	 * Returns the value of the '<em><b>State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.State#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The State in which the connection point refreshens are defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State</em>' container reference.
	 * @see #setState(State)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConnectionPointReference_State()
	 * @see org.eclipse.ocl.examples.pivot.State#getConnection
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getState <em>State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' container reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exitPoints kind pseudo states corresponding to this connection point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exit</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getConnectionPointReference_Exit()
	 * @generated
	 */
	List<Pseudostate> getExit();

} // ConnectionPointReference

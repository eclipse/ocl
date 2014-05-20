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
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * State machines can be used to express the behavior of part of a system. Behavior is modeled as a traversal of a graph of state nodes interconnected by one or more joined transition arcs that are triggered by the dispatching of series of (event) occurrences. During this traversal, the state machine executes a series of activities associated with various elements of the state machine.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getConnectionPoint <em>Connection Point</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getExtendedStateMachine <em>Extended State Machine</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getRegion <em>Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateMachine#getSubmachineState <em>Submachine State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine()
 * @generated
 */
public interface StateMachine extends Behavior
{
	/**
	 * Returns the value of the '<em><b>Region</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Region#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The regions owned directly by the state machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Region</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_Region()
	 * @see org.eclipse.ocl.examples.pivot.Region#getStateMachine
	 * @generated
	 */
	List<Region> getRegion();

	/**
	 * Returns the value of the '<em><b>Connection Point</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The connection points defined for this state machine. They represent the interface of the state machine when used as part of submachine state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection Point</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_ConnectionPoint()
	 * @generated
	 */
	List<Pseudostate> getConnectionPoint();

	/**
	 * Returns the value of the '<em><b>Extended State Machine</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.StateMachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The state machines of which this is an extension.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended State Machine</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_ExtendedStateMachine()
	 * @generated
	 */
	List<StateMachine> getExtendedStateMachine();

	/**
	 * Returns the value of the '<em><b>Submachine State</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.State}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.State#getSubmachine <em>Submachine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the submachine(s) in case of a submachine state. Multiple machines are referenced in case of a concurrent state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Submachine State</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateMachine_SubmachineState()
	 * @see org.eclipse.ocl.examples.pivot.State#getSubmachine
	 * @generated
	 */
	List<State> getSubmachineState();

} // StateMachine

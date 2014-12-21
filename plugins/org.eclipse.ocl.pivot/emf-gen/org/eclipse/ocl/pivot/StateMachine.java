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
package org.eclipse.ocl.pivot;

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
 *   <li>{@link org.eclipse.ocl.pivot.StateMachine#getExtendedStateMachines <em>Extended State Machines</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.StateMachine#getOwnedConnectionPoints <em>Owned Connection Points</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.StateMachine#getOwnedRegions <em>Owned Regions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.StateMachine#getSubmachineStates <em>Submachine States</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getStateMachine()
 * @generated
 */
public interface StateMachine extends Behavior
{
	/**
	 * Returns the value of the '<em><b>Extended State Machines</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.StateMachine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The state machines of which this is an extension.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended State Machines</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getStateMachine_ExtendedStateMachines()
	 * @generated
	 */
	List<StateMachine> getExtendedStateMachines();

	/**
	 * Returns the value of the '<em><b>Owned Connection Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Pseudostate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Pseudostate#getOwningStateMachine <em>Owning State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The connection points defined for this state machine. They represent the interface of the state machine when used as part of submachine state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Connection Points</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getStateMachine_OwnedConnectionPoints()
	 * @see org.eclipse.ocl.pivot.Pseudostate#getOwningStateMachine
	 * @generated
	 */
	List<Pseudostate> getOwnedConnectionPoints();

	/**
	 * Returns the value of the '<em><b>Owned Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Region#getOwningStateMachine <em>Owning State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The regions owned directly by the state machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Regions</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getStateMachine_OwnedRegions()
	 * @see org.eclipse.ocl.pivot.Region#getOwningStateMachine
	 * @generated
	 */
	List<Region> getOwnedRegions();

	/**
	 * Returns the value of the '<em><b>Submachine States</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.State}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.State#getSubmachines <em>Submachines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * References the submachine(s) in case of a submachine state. Multiple machines are referenced in case of a concurrent state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Submachine States</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getStateMachine_SubmachineStates()
	 * @see org.eclipse.ocl.pivot.State#getSubmachines
	 * @generated
	 */
	List<State> getSubmachineStates();

} // StateMachine

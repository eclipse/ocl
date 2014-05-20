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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A state models a situation during which some (usually implicit) invariant condition holds.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getConnectionPoint <em>Connection Point</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getDeferrableTrigger <em>Deferrable Trigger</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getDoActivity <em>Do Activity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getExit <em>Exit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#isOrthogonal <em>Is Orthogonal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#isSimple <em>Is Simple</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#isSubmachineState <em>Is Submachine State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getRedefinedState <em>Redefined State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getRegion <em>Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getStateInvariant <em>State Invariant</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.State#getSubmachine <em>Submachine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState()
 * @generated
 */
public interface State
		extends Vertex, Namespace {

	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isComposite=true is said to be a composite state. A composite state is a state that contains at least one region.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_IsComposite()
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Returns the value of the '<em><b>Is Orthogonal</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isOrthogonal=true is said to be an orthogonal composite state. An orthogonal composite state contains two or more regions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Orthogonal</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_IsOrthogonal()
	 * @generated
	 */
	boolean isOrthogonal();

	/**
	 * Returns the value of the '<em><b>Is Simple</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isSimple=true is said to be a simple state. A simple state does not have any regions and it does not refer to any submachine state machine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Simple</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_IsSimple()
	 * @generated
	 */
	boolean isSimple();

	/**
	 * Returns the value of the '<em><b>Is Submachine State</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isSubmachineState=true is said to be a submachine state. Such a state refers to a state machine (submachine).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Submachine State</em>' attribute.
	 * @see #setIsSubmachineState(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_IsSubmachineState()
	 * @generated
	 */
	boolean isSubmachineState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.State#isSubmachineState <em>Is Submachine State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Submachine State</em>' attribute.
	 * @see #isSubmachineState()
	 * @generated
	 */
	void setIsSubmachineState(boolean value);

	/**
	 * Returns the value of the '<em><b>Submachine</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.StateMachine#getSubmachineState <em>Submachine State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The state machine that is to be inserted in place of the (submachine) state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Submachine</em>' reference.
	 * @see #setSubmachine(StateMachine)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_Submachine()
	 * @see org.eclipse.ocl.examples.pivot.StateMachine#getSubmachineState
	 * @generated
	 */
	StateMachine getSubmachine();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.State#getSubmachine <em>Submachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submachine</em>' reference.
	 * @see #getSubmachine()
	 * @generated
	 */
	void setSubmachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.ConnectionPointReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.ConnectionPointReference#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entry and exit connection points used in conjunction with this (submachine) state, i.e. as targets and sources, respectively, in the region with the submachine state. A connection point reference references the corresponding definition of a connection point pseudostate in the statemachine referenced by the submachinestate.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_Connection()
	 * @see org.eclipse.ocl.examples.pivot.ConnectionPointReference#getState
	 * @generated
	 */
	List<ConnectionPointReference> getConnection();

	/**
	 * Returns the value of the '<em><b>Redefined State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The state of which this state is a redefinition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefined State</em>' reference.
	 * @see #setRedefinedState(State)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_RedefinedState()
	 * @generated
	 */
	State getRedefinedState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.State#getRedefinedState <em>Redefined State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redefined State</em>' reference.
	 * @see #getRedefinedState()
	 * @generated
	 */
	void setRedefinedState(State value);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Region#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The regions owned directly by the state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Region</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_Region()
	 * @see org.eclipse.ocl.examples.pivot.Region#getState
	 * @generated
	 */
	List<Region> getRegion();

	/**
	 * Returns the value of the '<em><b>State Invariant</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Constraint#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies conditions that are always true when this state is the current state. In protocol state machines, state invariants are additional conditions to the preconditions of the outgoing transitions, and to the postcondition of the incoming transitions.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State Invariant</em>' containment reference.
	 * @see #setStateInvariant(Constraint)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_StateInvariant()
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getOwningState
	 * @generated
	 */
	Constraint getStateInvariant();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.State#getStateInvariant <em>State Invariant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Invariant</em>' containment reference.
	 * @see #getStateInvariant()
	 * @generated
	 */
	void setStateInvariant(Constraint value);

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional behavior that is executed whenever this state is entered regardless of the transition taken to reach the state. If defined, entry actions are always executed to completion prior to any internal behavior or transitions performed within the state.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entry</em>' containment reference.
	 * @see #setEntry(Behavior)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_Entry()
	 * @generated
	 */
	Behavior getEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.State#getEntry <em>Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' containment reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(Behavior value);

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional behavior that is executed whenever this state is exited regardless of which transition was taken out of the state. If defined, exit actions are always executed to completion only after all internal activities and transition actions have completed execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exit</em>' containment reference.
	 * @see #setExit(Behavior)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_Exit()
	 * @generated
	 */
	Behavior getExit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.State#getExit <em>Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit</em>' containment reference.
	 * @see #getExit()
	 * @generated
	 */
	void setExit(Behavior value);

	/**
	 * Returns the value of the '<em><b>Do Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional behavior that is executed while being in the state. The execution starts when this state is entered, and stops either by itself, or when the state is exited, whichever comes first.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Do Activity</em>' containment reference.
	 * @see #setDoActivity(Behavior)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_DoActivity()
	 * @generated
	 */
	Behavior getDoActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.State#getDoActivity <em>Do Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Do Activity</em>' containment reference.
	 * @see #getDoActivity()
	 * @generated
	 */
	void setDoActivity(Behavior value);

	/**
	 * Returns the value of the '<em><b>Connection Point</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Pseudostate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Pseudostate#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entry and exit pseudostates of a composite state. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite states.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection Point</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_ConnectionPoint()
	 * @see org.eclipse.ocl.examples.pivot.Pseudostate#getState
	 * @generated
	 */
	List<Pseudostate> getConnectionPoint();

	/**
	 * Returns the value of the '<em><b>Deferrable Trigger</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Trigger}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Trigger#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of triggers that are candidates to be retained by the state machine if they trigger no transitions out of the state (not consumed). A deferred trigger is retained until the state machine reaches a state configuration where it is no longer deferred.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deferrable Trigger</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getState_DeferrableTrigger()
	 * @see org.eclipse.ocl.examples.pivot.Trigger#getState
	 * @generated
	 */
	List<Trigger> getDeferrableTrigger();
} // State

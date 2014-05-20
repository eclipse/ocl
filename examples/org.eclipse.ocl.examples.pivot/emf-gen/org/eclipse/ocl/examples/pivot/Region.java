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
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A region is an orthogonal part of either a composite state or a state machine. It contains states and transitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Region#getExtendedRegion <em>Extended Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Region#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Region#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Region#getSubvertex <em>Subvertex</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Region#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRegion()
 * @generated
 */
public interface Region extends Namespace
{
	/**
	 * Returns the value of the '<em><b>Subvertex</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Vertex}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Vertex#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of vertices that are owned by this region.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subvertex</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRegion_Subvertex()
	 * @see org.eclipse.ocl.examples.pivot.Vertex#getContainer
	 * @generated
	 */
	List<Vertex> getSubvertex();

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Transition#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of transitions owned by the region. Note that internal transitions are owned by a region, but applies to the source state.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transition</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRegion_Transition()
	 * @see org.eclipse.ocl.examples.pivot.Transition#getContainer
	 * @generated
	 */
	List<Transition> getTransition();

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.StateMachine#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The StateMachine that owns the Region. If a Region is owned by a StateMachine, then it cannot also be owned by a State.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State Machine</em>' container reference.
	 * @see #setStateMachine(StateMachine)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRegion_StateMachine()
	 * @see org.eclipse.ocl.examples.pivot.StateMachine#getRegion
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Region#getStateMachine <em>State Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' container reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.State#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The State that owns the Region. If a Region is owned by a State, then it cannot also be owned by a StateMachine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>State</em>' container reference.
	 * @see #setState(State)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRegion_State()
	 * @see org.eclipse.ocl.examples.pivot.State#getRegion
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Region#getState <em>State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' container reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Extended Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The region of which this region is an extension.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Region</em>' reference.
	 * @see #setExtendedRegion(Region)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRegion_ExtendedRegion()
	 * @generated
	 */
	Region getExtendedRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Region#getExtendedRegion <em>Extended Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Region</em>' reference.
	 * @see #getExtendedRegion()
	 * @generated
	 */
	void setExtendedRegion(Region value);

} // Region

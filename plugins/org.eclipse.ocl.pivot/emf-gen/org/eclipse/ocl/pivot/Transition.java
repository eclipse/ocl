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
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A transition is a directed relationship between a source vertex and a target vertex. It may be part of a compound transition, which takes the state machine from one state configuration to another, representing the complete response of the state machine to an occurrence of an event of a particular type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Transition#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Transition#getOwnedEffect <em>Owned Effect</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Transition#getOwnedGuard <em>Owned Guard</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Transition#getOwnedTriggers <em>Owned Triggers</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Transition#getOwningRegion <em>Owning Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Transition#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition()
 * @generated
 */
public interface Transition extends Namespace
{
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"external"</code>.
	 * The literals are from the enumeration {@link org.eclipse.ocl.pivot.TransitionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates  the precise type of the transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.ocl.pivot.TransitionKind
	 * @see #setKind(TransitionKind)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition_Kind()
	 * @generated
	 */
	TransitionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Transition#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.ocl.pivot.TransitionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TransitionKind value);

	/**
	 * Returns the value of the '<em><b>Owned Effect</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Behavior#getOwningTransition <em>Owning Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies an optional behavior to be performed when the transition fires.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Effect</em>' containment reference.
	 * @see #setOwnedEffect(Behavior)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition_OwnedEffect()
	 * @see org.eclipse.ocl.pivot.Behavior#getOwningTransition
	 * @generated
	 */
	Behavior getOwnedEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Transition#getOwnedEffect <em>Owned Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Effect</em>' containment reference.
	 * @see #getOwnedEffect()
	 * @generated
	 */
	void setOwnedEffect(Behavior value);

	/**
	 * Returns the value of the '<em><b>Owned Guard</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Constraint#getOwningTransition <em>Owning Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A guard is a constraint that provides a fine-grained control over the firing of the transition. The guard is evaluated when an event occurrence is dispatched by the state machine. If the guard is true at that time, the transition may be enabled, otherwise, it is disabled. Guards should be pure expressions without side effects. Guard expressions with side effects are ill formed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Guard</em>' containment reference.
	 * @see #setOwnedGuard(Constraint)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition_OwnedGuard()
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningTransition
	 * @generated
	 */
	Constraint getOwnedGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Transition#getOwnedGuard <em>Owned Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Guard</em>' containment reference.
	 * @see #getOwnedGuard()
	 * @generated
	 */
	void setOwnedGuard(Constraint value);

	/**
	 * Returns the value of the '<em><b>Owned Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Trigger}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Trigger#getOwningTransition <em>Owning Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the triggers that may fire the transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Triggers</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition_OwnedTriggers()
	 * @see org.eclipse.ocl.pivot.Trigger#getOwningTransition
	 * @generated
	 */
	List<Trigger> getOwnedTriggers();

	/**
	 * Returns the value of the '<em><b>Owning Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Region#getOwnedTransitions <em>Owned Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates the region that owns this transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Region</em>' container reference.
	 * @see #setOwningRegion(Region)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition_OwningRegion()
	 * @see org.eclipse.ocl.pivot.Region#getOwnedTransitions
	 * @generated
	 */
	Region getOwningRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Transition#getOwningRegion <em>Owning Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Region</em>' container reference.
	 * @see #getOwningRegion()
	 * @generated
	 */
	void setOwningRegion(Region value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates the originating vertex (state or pseudostate) of the transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Vertex)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition_Source()
	 * @see org.eclipse.ocl.pivot.Vertex#getOutgoingTransitions
	 * @generated
	 */
	Vertex getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Vertex value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates the target vertex that is reached when the transition is taken.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Vertex)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTransition_Target()
	 * @see org.eclipse.ocl.pivot.Vertex#getIncomingTransitions
	 * @generated
	 */
	Vertex getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Vertex value);

} // Transition

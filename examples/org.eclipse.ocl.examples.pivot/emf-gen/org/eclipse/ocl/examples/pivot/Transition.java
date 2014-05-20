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
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A transition is a directed relationship between a source vertex and a target vertex. It may be part of a compound transition, which takes the state machine from one state configuration to another, representing the complete response of the state machine to an occurrence of an event of a particular type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Transition#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Transition#getEffect <em>Effect</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Transition#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Transition#getTrigger <em>Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition()
 * @generated
 */
public interface Transition extends Namespace
{
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"external"</code>.
	 * The literals are from the enumeration {@link org.eclipse.ocl.examples.pivot.TransitionKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates  the precise type of the transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.TransitionKind
	 * @see #setKind(TransitionKind)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition_Kind()
	 * @generated
	 */
	TransitionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Transition#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.TransitionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TransitionKind value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Region#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates the region that owns this transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Region)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition_Container()
	 * @see org.eclipse.ocl.examples.pivot.Region#getTransition
	 * @generated
	 */
	Region getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Transition#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Region value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Vertex#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates the originating vertex (state or pseudostate) of the transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Vertex)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition_Source()
	 * @see org.eclipse.ocl.examples.pivot.Vertex#getOutgoing
	 * @generated
	 */
	Vertex getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Vertex value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Vertex#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Designates the target vertex that is reached when the transition is taken.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Vertex)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition_Target()
	 * @see org.eclipse.ocl.examples.pivot.Vertex#getIncoming
	 * @generated
	 */
	Vertex getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Vertex value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Constraint#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A guard is a constraint that provides a fine-grained control over the firing of the transition. The guard is evaluated when an event occurrence is dispatched by the state machine. If the guard is true at that time, the transition may be enabled, otherwise, it is disabled. Guards should be pure expressions without side effects. Guard expressions with side effects are ill formed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(Constraint)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition_Guard()
	 * @see org.eclipse.ocl.examples.pivot.Constraint#getTransition
	 * @generated
	 */
	Constraint getGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Transition#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Constraint value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Behavior#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies an optional behavior to be performed when the transition fires.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effect</em>' containment reference.
	 * @see #setEffect(Behavior)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition_Effect()
	 * @see org.eclipse.ocl.examples.pivot.Behavior#getTransition
	 * @generated
	 */
	Behavior getEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Transition#getEffect <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' containment reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(Behavior value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Trigger}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Trigger#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the triggers that may fire the transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTransition_Trigger()
	 * @see org.eclipse.ocl.examples.pivot.Trigger#getTransition
	 * @generated
	 */
	List<Trigger> getTrigger();

} // Transition

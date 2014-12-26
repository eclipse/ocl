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
 * A representation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A vertex is an abstraction of a node in a state machine graph. In general, it can be the source or destination of any number of transitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Vertex#getOwningRegion <em>Owning Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getVertex()
 * @generated
 */
public interface Vertex extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the transitions entering this vertex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getVertex_IncomingTransitions()
	 * @see org.eclipse.ocl.pivot.Transition#getTarget
	 * @generated
	 */
	List<Transition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the transitions departing from this vertex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getVertex_OutgoingTransitions()
	 * @see org.eclipse.ocl.pivot.Transition#getSource
	 * @generated
	 */
	List<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Owning Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Region#getOwnedSubvertexes <em>Owned Subvertexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The region that contains this vertex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Region</em>' container reference.
	 * @see #setOwningRegion(Region)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getVertex_OwningRegion()
	 * @see org.eclipse.ocl.pivot.Region#getOwnedSubvertexes
	 * @generated
	 */
	Region getOwningRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Vertex#getOwningRegion <em>Owning Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Region</em>' container reference.
	 * @see #getOwningRegion()
	 * @generated
	 */
	void setOwningRegion(Region value);

} // Vertex

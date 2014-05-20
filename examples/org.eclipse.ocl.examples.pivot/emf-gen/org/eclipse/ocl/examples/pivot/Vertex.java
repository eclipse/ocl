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
 * A representation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A vertex is an abstraction of a node in a state machine graph. In general, it can be the source or destination of any number of transitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Vertex#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Vertex#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Vertex#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVertex()
 * @generated
 */
public interface Vertex extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Region#getSubvertex <em>Subvertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The region that contains this vertex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Region)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVertex_Container()
	 * @see org.eclipse.ocl.examples.pivot.Region#getSubvertex
	 * @generated
	 */
	Region getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Vertex#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Region value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the transitions departing from this vertex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVertex_Outgoing()
	 * @see org.eclipse.ocl.examples.pivot.Transition#getSource
	 * @generated
	 */
	List<Transition> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the transitions entering this vertex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVertex_Incoming()
	 * @see org.eclipse.ocl.examples.pivot.Transition#getTarget
	 * @generated
	 */
	List<Transition> getIncoming();

} // Vertex

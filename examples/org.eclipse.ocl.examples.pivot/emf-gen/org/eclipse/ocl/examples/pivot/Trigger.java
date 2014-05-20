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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Trigger#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Trigger#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTrigger()
 * @generated
 */
public interface Trigger extends NamedElement
{

	/**
	 * Returns the value of the '<em><b>State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.State#getDeferrableTrigger <em>Deferrable Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' container reference.
	 * @see #setState(State)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTrigger_State()
	 * @see org.eclipse.ocl.examples.pivot.State#getDeferrableTrigger
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Trigger#getState <em>State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' container reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' container reference.
	 * @see #setTransition(Transition)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTrigger_Transition()
	 * @see org.eclipse.ocl.examples.pivot.Transition#getTrigger
	 * @generated
	 */
	Transition getTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Trigger#getTransition <em>Transition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' container reference.
	 * @see #getTransition()
	 * @generated
	 */
	void setTransition(Transition value);
} // Trigger

/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.examples.pivot.Iteration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS#getReferredIteration <em>Referred Iteration</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS#isIsPre <em>Is Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS()
 * @model
 * @generated
 */
public interface IterationCallExpCS extends CallExpCS
{
	/**
	 * Returns the value of the '<em><b>Referred Iteration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Iteration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Iteration</em>' containment reference.
	 * @see #setReferredIteration(Iteration)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS_ReferredIteration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Iteration getReferredIteration();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS#getReferredIteration <em>Referred Iteration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Iteration</em>' containment reference.
	 * @see #getReferredIteration()
	 * @generated
	 */
	void setReferredIteration(Iteration value);

	/**
	 * Returns the value of the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.VariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Iterators</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS_OwnedIterators()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableCS> getOwnedIterators();

	/**
	 * Returns the value of the '<em><b>Owned Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Arguments</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS_OwnedArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpCS> getOwnedArguments();

	/**
	 * Returns the value of the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pre</em>' attribute.
	 * @see #setIsPre(boolean)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS_IsPre()
	 * @model
	 * @generated
	 */
	boolean isIsPre();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.IterationCallExpCS#isIsPre <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pre</em>' attribute.
	 * @see #isIsPre()
	 * @generated
	 */
	void setIsPre(boolean value);

} // IterationCallExpCS

/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage
 * @generated
 */
public interface ValidityFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ValidityFactory eINSTANCE = org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityFactoryImpl.init();
	/**
	 * Returns a new object of class '<em>Constraining Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraining Node</em>'.
	 * @generated
	 */
	ConstrainingNode createConstrainingNode();

	/**
	 * Returns a new object of class '<em>Leaf Constraining Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Leaf Constraining Node</em>'.
	 * @generated
	 */
	LeafConstrainingNode createLeafConstrainingNode();

	/**
	 * Returns a new object of class '<em>Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result</em>'.
	 * @generated
	 */
	Result createResult();

	/**
	 * Returns a new object of class '<em>Result Constraining Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Constraining Node</em>'.
	 * @generated
	 */
	ResultConstrainingNode createResultConstrainingNode();

	/**
	 * Returns a new object of class '<em>Result Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Set</em>'.
	 * @generated
	 */
	ResultSet createResultSet();

	/**
	 * Returns a new object of class '<em>Result Validatable Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Validatable Node</em>'.
	 * @generated
	 */
	ResultValidatableNode createResultValidatableNode();

	/**
	 * Returns a new object of class '<em>Root Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Node</em>'.
	 * @generated
	 */
	RootNode createRootNode();

	/**
	 * Returns a new object of class '<em>Root Constraining Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Constraining Node</em>'.
	 * @generated
	 */
	RootConstrainingNode createRootConstrainingNode();

	/**
	 * Returns a new object of class '<em>Root Validatable Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Validatable Node</em>'.
	 * @generated
	 */
	RootValidatableNode createRootValidatableNode();

	/**
	 * Returns a new object of class '<em>Validatable Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validatable Node</em>'.
	 * @generated
	 */
	ValidatableNode createValidatableNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ValidityPackage getValidityPackage();

} //ValidationFactory

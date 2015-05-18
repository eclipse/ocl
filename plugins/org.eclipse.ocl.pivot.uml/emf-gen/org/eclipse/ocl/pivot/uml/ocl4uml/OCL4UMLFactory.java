/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.ocl4uml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage
 * @generated
 */
public interface OCL4UMLFactory
		extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCL4UMLFactory eINSTANCE = org.eclipse.ocl.pivot.uml.ocl4uml.impl.OCL4UMLFactoryImpl
		.init();

	/**
	 * Returns a new object of class '<em>Bounded Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bounded Integer</em>'.
	 * @generated
	 */
	BoundedInteger createBoundedInteger();

	/**
	 * Returns a new object of class '<em>Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer</em>'.
	 * @generated
	 */
	Integer createInteger();

	/**
	 * Returns a new object of class '<em>Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection</em>'.
	 * @generated
	 */
	Collection createCollection();

	/**
	 * Returns a new object of class '<em>Collections</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collections</em>'.
	 * @generated
	 */
	Collections createCollections();

	/**
	 * Returns a new object of class '<em>Fixed Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Point</em>'.
	 * @generated
	 */
	FixedPoint createFixedPoint();

	/**
	 * Returns a new object of class '<em>Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real</em>'.
	 * @generated
	 */
	Real createReal();

	/**
	 * Returns a new object of class '<em>Floating Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Floating Point</em>'.
	 * @generated
	 */
	FloatingPoint createFloatingPoint();

	/**
	 * Returns a new object of class '<em>Validation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validation</em>'.
	 * @generated
	 */
	Validation createValidation();

	/**
	 * Returns a new object of class '<em>Validations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validations</em>'.
	 * @generated
	 */
	Validations createValidations();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OCL4UMLPackage getOCL4UMLPackage();

} //OCL4UMLFactory

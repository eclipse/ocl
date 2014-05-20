/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.autocgmodel;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.autogen.autocgmodel.AutoCGModelPackage
 * @generated
 */
public interface AutoCGModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@NonNull AutoCGModelFactory eINSTANCE = org.eclipse.ocl.examples.autogen.autocgmodel.impl.AutoCGModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CGAST Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CGAST Call Exp</em>'.
	 * @generated
	 */
	@NonNull CGASTCallExp createCGASTCallExp();

	/**
	 * Returns a new object of class '<em>CG Containment Visit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Containment Visit</em>'.
	 * @generated
	 */
	@NonNull CGContainmentVisit createCGContainmentVisit();

	/**
	 * Returns a new object of class '<em>CG Containment Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Containment Part</em>'.
	 * @generated
	 */
	@NonNull CGContainmentPart createCGContainmentPart();

	/**
	 * Returns a new object of class '<em>CG Containment Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Containment Body</em>'.
	 * @generated
	 */
	CGContainmentBody createCGContainmentBody();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	@NonNull AutoCGModelPackage getAutoCGModelPackage();

} //AutoCGModelFactory

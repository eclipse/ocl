/*******************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.cgmodel;

import org.eclipse.emf.ecore.EDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Ecore Data Type Constructor Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeShadowExp#getEDataType <em>EData Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeShadowExp#getString <em>String</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGEcoreDataTypeShadowExp()
 * @generated
 */
public interface CGEcoreDataTypeShadowExp extends CGShadowExp {
	/**
	 * Returns the value of the '<em><b>EData Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EData Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EData Type</em>' reference.
	 * @see #setEDataType(EDataType)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGEcoreDataTypeShadowExp_EDataType()
	 * @generated
	 */
	EDataType getEDataType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeShadowExp#getEDataType <em>EData Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EData Type</em>' reference.
	 * @see #getEDataType()
	 * @generated
	 */
	void setEDataType(EDataType value);

	/**
	 * Returns the value of the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the integer value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>String</em>' attribute.
	 * @see #setString(String)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGEcoreDataTypeShadowExp_String()
	 * @generated
	 */
	String getString();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreDataTypeShadowExp#getString <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' attribute.
	 * @see #getString()
	 * @generated
	 */
	void setString(String value);

} // CGEcoreDataTypeConstructorExp

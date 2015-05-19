/*******************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.cgmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Text Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CGTextParameter supports provision of literal language-specific text as a parameter contribution to the generate code.
 * (e.g. the initialisation of the self parameter from this).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter#getTextValue <em>Text Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTextParameter()
 * @generated
 */
public interface CGTextParameter extends CGParameter {
	/**
	 * Returns the value of the '<em><b>Text Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the string value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Text Value</em>' attribute.
	 * @see #setTextValue(String)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGTextParameter_TextValue()
	 * @generated
	 */
	String getTextValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTextParameter#getTextValue <em>Text Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Value</em>' attribute.
	 * @see #getTextValue()
	 * @generated
	 */
	void setTextValue(String value);

} // CGTextParameter

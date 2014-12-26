/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.AttributeCS#isIsId <em>Is Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getAttributeCS()
 * @model
 * @generated
 */
public interface AttributeCS extends StructuralFeatureCS {

	/**
	 * Returns the value of the '<em><b>Is Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Id</em>' attribute.
	 * @see #setIsId(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getAttributeCS_IsId()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsId();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.AttributeCS#isIsId <em>Is Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Id</em>' attribute.
	 * @see #isIsId()
	 * @generated
	 */
	void setIsId(boolean value);
} // AttributeCS

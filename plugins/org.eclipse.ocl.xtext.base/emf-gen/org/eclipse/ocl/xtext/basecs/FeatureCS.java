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
 * A representation of the model object '<em><b>Feature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.FeatureCS#isIsDefinition <em>Is Definition</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.FeatureCS#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.FeatureCS#isIsStatic <em>Is Static</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getFeatureCS()
 * @model abstract="true"
 * @generated
 */
public interface FeatureCS extends TypedElementCS {

	/**
	 * Returns the value of the '<em><b>Is Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Definition</em>' attribute.
	 * @see #setIsDefinition(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getFeatureCS_IsDefinition()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.FeatureCS#isIsDefinition <em>Is Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Definition</em>' attribute.
	 * @see #isIsDefinition()
	 * @generated
	 */
	void setIsDefinition(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getFeatureCS_IsDerived()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsDerived();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.FeatureCS#isIsDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isIsDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Static</em>' attribute.
	 * @see #setIsStatic(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getFeatureCS_IsStatic()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.FeatureCS#isIsStatic <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Static</em>' attribute.
	 * @see #isIsStatic()
	 * @generated
	 */
	void setIsStatic(boolean value);

} // FeatureCS

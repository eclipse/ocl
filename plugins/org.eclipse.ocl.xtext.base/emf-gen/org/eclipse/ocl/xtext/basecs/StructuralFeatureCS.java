/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.basecs;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsReadonly <em>Is Readonly</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwnedDefaultExpressions <em>Owned Default Expressions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS()
 * @model abstract="true"
 * @generated
 */
public interface StructuralFeatureCS extends FeatureCS {

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedProperties <em>Owned Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see #setOwningClass(StructuredClassCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS_OwningClass()
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedProperties
	 * @model opposite="ownedProperties" transient="false"
	 * @generated
	 */
	StructuredClassCS getOwningClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getOwningClass <em>Owning Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' container reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(StructuredClassCS value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS_Default()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Is Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Readonly</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Readonly</em>' attribute.
	 * @see #setIsReadonly(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS_IsReadonly()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsReadonly();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsReadonly <em>Is Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Readonly</em>' attribute.
	 * @see #isIsReadonly()
	 * @generated
	 */
	void setIsReadonly(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Transient</em>' attribute.
	 * @see #setIsTransient(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS_IsTransient()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsTransient <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Transient</em>' attribute.
	 * @see #isIsTransient()
	 * @generated
	 */
	void setIsTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unsettable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unsettable</em>' attribute.
	 * @see #setIsUnsettable(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS_IsUnsettable()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsUnsettable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsUnsettable <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unsettable</em>' attribute.
	 * @see #isIsUnsettable()
	 * @generated
	 */
	void setIsUnsettable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Volatile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Volatile</em>' attribute.
	 * @see #setIsVolatile(boolean)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS_IsVolatile()
	 * @model dataType="org.eclipse.ocl.pivot.Boolean"
	 * @generated
	 */
	boolean isIsVolatile();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.StructuralFeatureCS#isIsVolatile <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Volatile</em>' attribute.
	 * @see #isIsVolatile()
	 * @generated
	 */
	void setIsVolatile(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Default Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.SpecificationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Default Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Default Expressions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getStructuralFeatureCS_OwnedDefaultExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<SpecificationCS> getOwnedDefaultExpressions();
} // StructuralFeatureCS

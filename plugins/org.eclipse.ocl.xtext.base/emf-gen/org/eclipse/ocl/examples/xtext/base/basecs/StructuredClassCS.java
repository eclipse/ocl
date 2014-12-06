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

package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuredClassCS#getOwnedMetaclass <em>Owned Metaclass</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuredClassCS#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuredClassCS#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuredClassCS#getOwnedSuperTypes <em>Owned Super Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getStructuredClassCS()
 * @model
 * @generated
 */
public interface StructuredClassCS extends ClassCS, NamespaceCS {
	/**
	 * Returns the value of the '<em><b>Owned Super Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Super Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Super Types</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getStructuredClassCS_OwnedSuperTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedSuperTypes();

	/**
	 * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operations</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getStructuredClassCS_OwnedOperations()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<OperationCS> getOwnedOperations();

	/**
	 * Returns the value of the '<em><b>Owned Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Properties</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getStructuredClassCS_OwnedProperties()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<StructuralFeatureCS> getOwnedProperties();

	/**
	 * Returns the value of the '<em><b>Owned Metaclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Meta Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Metaclass</em>' containment reference.
	 * @see #setOwnedMetaclass(TypedRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getStructuredClassCS_OwnedMetaclass()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedMetaclass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuredClassCS#getOwnedMetaclass <em>Owned Metaclass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Metaclass</em>' containment reference.
	 * @see #getOwnedMetaclass()
	 * @generated
	 */
	void setOwnedMetaclass(TypedRefCS value);

} // ClassCS

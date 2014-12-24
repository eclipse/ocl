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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypeParameterCS#getOwnedExtends <em>Owned Extends</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypeParameterCS#getOwnedSuper <em>Owned Super</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypeParameterCS()
 * @model
 * @generated
 */
public interface TypeParameterCS extends TemplateParameterCS, TypeCS {
	/**
	 * Returns the value of the '<em><b>Owned Extends</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Extends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Extends</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypeParameterCS_OwnedExtends()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedExtends();

	/**
	 * Returns the value of the '<em><b>Owned Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Super</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Super</em>' containment reference.
	 * @see #setOwnedSuper(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypeParameterCS_OwnedSuper()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedSuper();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypeParameterCS#getOwnedSuper <em>Owned Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Super</em>' containment reference.
	 * @see #getOwnedSuper()
	 * @generated
	 */
	void setOwnedSuper(TypedRefCS value);

} // TypeParameterCS

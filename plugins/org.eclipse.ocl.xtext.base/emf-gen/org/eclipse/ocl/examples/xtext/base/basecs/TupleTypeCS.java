/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.domain.elements.Nameable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTupleTypeCS()
 * @model superTypes="org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS org.eclipse.ocl.examples.pivot.Nameable"
 * @generated
 */
public interface TupleTypeCS extends TypedRefCS, Nameable
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTupleTypeCS_Name()
	 * @model
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.TupleTypeCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.TuplePartCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getTupleTypeCS_OwnedParts()
	 * @model containment="true"
	 * @generated
	 */
	EList<TuplePartCS> getOwnedParts();

} // TupleTypeCS

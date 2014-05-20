/*******************************************************************************
 * Copyright (c) 2012, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainRoot
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Root#getExternalURI <em>External URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Root#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Root#getNestedPackage <em>Nested Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRoot()
 * @generated
 */
public interface Root extends Namespace, org.eclipse.ocl.examples.domain.elements.DomainRoot
{

	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRoot_NestedPackage()
	 * @generated
	 */
	List<org.eclipse.ocl.examples.pivot.Package> getNestedPackage();

	/**
	 * Returns the value of the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External URI</em>' attribute.
	 * @see #setExternalURI(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRoot_ExternalURI()
	 * @generated
	 */
	String getExternalURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Root#getExternalURI <em>External URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External URI</em>' attribute.
	 * @see #getExternalURI()
	 * @generated
	 */
	void setExternalURI(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getRoot_Imports()
	 * @generated
	 */
	@NonNull List<Import> getImports();

} // Root
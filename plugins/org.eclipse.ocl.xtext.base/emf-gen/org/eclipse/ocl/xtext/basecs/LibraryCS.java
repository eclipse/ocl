/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
 * A representation of the model object '<em><b>Library CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.LibraryCS#getReferredPackage <em>Referred Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getLibraryCS()
 * @model
 * @generated
 */
public interface LibraryCS extends NamespaceCS {
	/**
	 * Returns the value of the '<em><b>Referred Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Package</em>' reference.
	 * @see #setReferredPackage(org.eclipse.ocl.examples.pivot.Package)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getLibraryCS_ReferredPackage()
	 * @model
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package getReferredPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.LibraryCS#getReferredPackage <em>Referred Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Package</em>' reference.
	 * @see #getReferredPackage()
	 * @generated
	 */
	void setReferredPackage(org.eclipse.ocl.examples.pivot.Package value);

} // LibraryCS

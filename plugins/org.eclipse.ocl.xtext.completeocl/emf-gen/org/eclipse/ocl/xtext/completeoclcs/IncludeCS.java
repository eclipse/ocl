/*******************************************************************************
 * Copyright (c) 2011, 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.xtext.basecs.NamespaceCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.IncludeCS#getReferredNamespace <em>Referred Namespace</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getIncludeCS()
 * @model
 * @generated
 */
public interface IncludeCS
		extends NamespaceCS {

	/**
	 * Returns the value of the '<em><b>Referred Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Namespace</em>' reference.
	 * @see #setReferredNamespace(Namespace)
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getIncludeCS_ReferredNamespace()
	 * @model
	 * @generated
	 */
	Namespace getReferredNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.completeoclcs.IncludeCS#getReferredNamespace <em>Referred Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Namespace</em>' reference.
	 * @see #getReferredNamespace()
	 * @generated
	 */
	void setReferredNamespace(Namespace value);

} // IncludeCS

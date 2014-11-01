/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.ocl.examples.pivot.AssociationClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS#getReferredAssociation <em>Referred Association</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS#isIsPre <em>Is Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getAssociationClassCallExpCS()
 * @model
 * @generated
 */
public interface AssociationClassCallExpCS extends CallExpCS
{
	/**
	 * Returns the value of the '<em><b>Referred Association</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Association</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Association</em>' containment reference.
	 * @see #setReferredAssociation(AssociationClass)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getAssociationClassCallExpCS_ReferredAssociation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AssociationClass getReferredAssociation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS#getReferredAssociation <em>Referred Association</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Association</em>' containment reference.
	 * @see #getReferredAssociation()
	 * @generated
	 */
	void setReferredAssociation(AssociationClass value);

	/**
	 * Returns the value of the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pre</em>' attribute.
	 * @see #setIsPre(boolean)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getAssociationClassCallExpCS_IsPre()
	 * @model
	 * @generated
	 */
	boolean isIsPre();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS#isIsPre <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pre</em>' attribute.
	 * @see #isIsPre()
	 * @generated
	 */
	void setIsPre(boolean value);

} // AssociationClassCallExpCS

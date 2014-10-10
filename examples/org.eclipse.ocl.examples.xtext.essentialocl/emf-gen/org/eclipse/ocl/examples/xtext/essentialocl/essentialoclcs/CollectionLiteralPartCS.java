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
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedExpressionCS <em>Owned Expression CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedLastExpressionCS <em>Owned Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getCollectionLiteralPartCS()
 * @model
 * @generated
 */
public interface CollectionLiteralPartCS
		extends ModelElementCS {

	/**
	 * Returns the value of the '<em><b>Owned Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression CS</em>' containment reference.
	 * @see #setOwnedExpressionCS(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getCollectionLiteralPartCS_OwnedExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedExpressionCS <em>Owned Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression CS</em>' containment reference.
	 * @see #getOwnedExpressionCS()
	 * @generated
	 */
	void setOwnedExpressionCS(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Last Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Last Expression CS</em>' containment reference.
	 * @see #setOwnedLastExpressionCS(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getCollectionLiteralPartCS_OwnedLastExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedLastExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CollectionLiteralPartCS#getOwnedLastExpressionCS <em>Owned Last Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Last Expression CS</em>' containment reference.
	 * @see #getOwnedLastExpressionCS()
	 * @generated
	 */
	void setOwnedLastExpressionCS(ExpCS value);

} // CollectionLiteralPartCS

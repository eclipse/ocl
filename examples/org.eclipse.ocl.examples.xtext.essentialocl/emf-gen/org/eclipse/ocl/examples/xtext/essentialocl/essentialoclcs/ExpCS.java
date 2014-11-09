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
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Expression CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#isHasError <em>Has Error</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#getPrecedence <em>Precedence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getExpCS()
 * @model
 * @generated
 */
public interface ExpCS
		extends ModelElementCS {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getExpCS_Parent()
	 * @model resolveProxies="false" transient="true" changeable="false" derived="true"
	 * @generated
	 */
	OperatorExpCS getParent();

	/**
	 * Returns the value of the '<em><b>Has Error</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Error</em>' attribute.
	 * @see #setHasError(boolean)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getExpCS_HasError()
	 * @model default="false" transient="true"
	 * @generated
	 */
	boolean isHasError();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#isHasError <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Error</em>' attribute.
	 * @see #isHasError()
	 * @generated
	 */
	void setHasError(boolean value);
	
	/**
	 * Returns the value of the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedence</em>' reference.
	 * @see #setPrecedence(Precedence)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage#getExpCS_Precedence()
	 * @model resolveProxies="false" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Precedence getPrecedence();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS#getPrecedence <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' reference.
	 * @see #getPrecedence()
	 * @generated
	 */
	void setPrecedence(Precedence value);

	@Nullable ExpCS getLocalLeft();

	@NonNull ExpCS getLocalLeftmostDescendant();

	@Nullable ExpCS getLocalRight();

	@NonNull ExpCS getLocalRightmostDescendant();
	
	void setInterleaved();
} // ExpCS

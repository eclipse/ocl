/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profile Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getApplyingPackage <em>Applying Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ProfileApplication#isStrict <em>Is Strict</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProfileApplication()
 * @generated
 */
public interface ProfileApplication extends Element
{
	/**
	 * Returns the value of the '<em><b>Applied Profile</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Profile#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Profile</em>' reference.
	 * @see #setAppliedProfile(Profile)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProfileApplication_AppliedProfile()
	 * @see org.eclipse.ocl.examples.pivot.Profile#getApplication
	 * @generated
	 */
	Profile getAppliedProfile();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Profile</em>' reference.
	 * @see #getAppliedProfile()
	 * @generated
	 */
	void setAppliedProfile(Profile value);

	/**
	 * Returns the value of the '<em><b>Applying Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getProfileApplication <em>Profile Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applying Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applying Package</em>' container reference.
	 * @see #setApplyingPackage(org.eclipse.ocl.examples.pivot.Package)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProfileApplication_ApplyingPackage()
	 * @see org.eclipse.ocl.examples.pivot.Package#getProfileApplication
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package getApplyingPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getApplyingPackage <em>Applying Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applying Package</em>' container reference.
	 * @see #getApplyingPackage()
	 * @generated
	 */
	void setApplyingPackage(org.eclipse.ocl.examples.pivot.Package value);

	/**
	 * Returns the value of the '<em><b>Is Strict</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strict</em>' attribute.
	 * @see #setIsStrict(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProfileApplication_IsStrict()
	 * @generated
	 */
	boolean isStrict();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#isStrict <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strict</em>' attribute.
	 * @see #isStrict()
	 * @generated
	 */
	void setIsStrict(boolean value);

} // ProfileApplication

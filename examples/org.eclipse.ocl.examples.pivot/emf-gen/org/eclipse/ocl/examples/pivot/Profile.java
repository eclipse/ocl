/*******************************************************************************
 * Copyright (c) 2012, 2014 E.D.Willink and others.
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
 * A representation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Profile#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProfile()
 * @generated
 */
public interface Profile extends org.eclipse.ocl.examples.pivot.Package
{

	/**
	 * Returns the value of the '<em><b>Application</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.ProfileApplication}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getAppliedProfile <em>Applied Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getProfile_Application()
	 * @see org.eclipse.ocl.examples.pivot.ProfileApplication#getAppliedProfile
	 * @generated
	 */
	@NonNull List<ProfileApplication> getApplication();

} // Profile

/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.NavigationCallExp#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getNavigationCallExp()
 * @generated
 */
public interface NavigationCallExp
		extends FeatureCallExp {

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getNavigationCallExp_Qualifier()
	 * @generated
	 */
	List<OCLExpression> getQualifier();

	/**
	 * Returns the value of the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigation Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigation Source</em>' reference.
	 * @see #setNavigationSource(Property)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getNavigationCallExp_NavigationSource()
	 * @generated
	 */
	Property getNavigationSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigation Source</em>' reference.
	 * @see #getNavigationSource()
	 * @generated
	 */
	void setNavigationSource(Property value);

} // NavigationCallExp

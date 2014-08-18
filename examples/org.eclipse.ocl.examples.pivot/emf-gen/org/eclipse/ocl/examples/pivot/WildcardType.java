/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wildcard Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.WildcardType#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.WildcardType#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getWildcardType()
 * @generated
 */
public interface WildcardType extends org.eclipse.ocl.examples.pivot.Class
{
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is the default for this formal template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower Bound</em>' reference.
	 * @see #setLowerBound(org.eclipse.ocl.examples.pivot.Class)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getWildcardType_LowerBound()
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getLowerBound();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.WildcardType#getLowerBound <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(org.eclipse.ocl.examples.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is the default for this formal template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper Bound</em>' reference.
	 * @see #setUpperBound(org.eclipse.ocl.examples.pivot.Class)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getWildcardType_UpperBound()
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getUpperBound();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.WildcardType#getUpperBound <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(org.eclipse.ocl.examples.pivot.Class value);

} // WildcardType

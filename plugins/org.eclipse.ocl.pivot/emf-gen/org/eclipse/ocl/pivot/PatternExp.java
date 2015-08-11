/**
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.PatternExp#getOwnedPattern <em>Owned Pattern</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.PatternExp#getOwnedVariables <em>Owned Variables</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getPatternExp()
 * @generated
 */
public interface PatternExp extends Element
{
	/**
	 * Returns the value of the '<em><b>Owned Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Pattern</em>' containment reference.
	 * @see #setOwnedPattern(PatternValue)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPatternExp_OwnedPattern()
	 * @generated
	 */
	PatternValue getOwnedPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.PatternExp#getOwnedPattern <em>Owned Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Pattern</em>' containment reference.
	 * @see #getOwnedPattern()
	 * @generated
	 */
	void setOwnedPattern(PatternValue value);

	/**
	 * Returns the value of the '<em><b>Owned Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Variables</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPatternExp_OwnedVariables()
	 * @generated
	 */
	List<Variable> getOwnedVariables();

} // PatternExp

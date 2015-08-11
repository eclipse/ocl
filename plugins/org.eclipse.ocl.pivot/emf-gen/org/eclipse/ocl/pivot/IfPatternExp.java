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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Pattern Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.IfPatternExp#getOwnedPattern <em>Owned Pattern</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.IfPatternExp#getOwnedSource <em>Owned Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getIfPatternExp()
 * @generated
 */
public interface IfPatternExp extends AbstractIfExp
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
	 * @see #setOwnedPattern(PatternExp)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getIfPatternExp_OwnedPattern()
	 * @generated
	 */
	PatternExp getOwnedPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.IfPatternExp#getOwnedPattern <em>Owned Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Pattern</em>' containment reference.
	 * @see #getOwnedPattern()
	 * @generated
	 */
	void setOwnedPattern(PatternExp value);

	/**
	 * Returns the value of the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Source</em>' containment reference.
	 * @see #setOwnedSource(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getIfPatternExp_OwnedSource()
	 * @generated
	 */
	OCLExpression getOwnedSource();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.IfPatternExp#getOwnedSource <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Source</em>' containment reference.
	 * @see #getOwnedSource()
	 * @generated
	 */
	void setOwnedSource(OCLExpression value);

} // IfPatternExp

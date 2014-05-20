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
package org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs;

import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS#isCallable <em>Callable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage#getOCLinEcoreConstraintCS()
 * @model
 * @generated
 */
public interface OCLinEcoreConstraintCS extends ConstraintCS {

	/**
	 * Returns the value of the '<em><b>Callable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Callable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Callable</em>' attribute.
	 * @see #setCallable(boolean)
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreCSPackage#getOCLinEcoreConstraintCS_Callable()
	 * @model
	 * @generated
	 */
	boolean isCallable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinecorecs.OCLinEcoreConstraintCS#isCallable <em>Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callable</em>' attribute.
	 * @see #isCallable()
	 * @generated
	 */
	void setCallable(boolean value);

} // ConstraintCS

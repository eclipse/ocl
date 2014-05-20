/*******************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.codegen.cgmodel;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Constructor Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp#getParts <em>Parts</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp#getExecutorType <em>Executor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGConstructorExp()
 * @generated
 */
public interface CGConstructorExp extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart#getConstructorExp <em>Constructor Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGConstructorExp_Parts()
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorPart#getConstructorExp
	 * @generated
	 */
	@NonNull List<CGConstructorPart> getParts();

	/**
	 * Returns the value of the '<em><b>Executor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executor Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executor Type</em>' reference.
	 * @see #setExecutorType(CGExecutorType)
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage#getCGConstructorExp_ExecutorType()
	 * @generated
	 */
	CGExecutorType getExecutorType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGConstructorExp#getExecutorType <em>Executor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executor Type</em>' reference.
	 * @see #getExecutorType()
	 * @generated
	 */
	void setExecutorType(CGExecutorType value);

} // CGConstructorExp

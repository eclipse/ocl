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

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs;

import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isInvalidating <em>Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isValidating <em>Validating</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS()
 * @model
 * @generated
 */
public interface LibOperationCS
		extends OperationCS, JavaImplementationCS {

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
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_Precedence()
	 * @model
	 * @generated
	 */
	Precedence getPrecedence();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#getPrecedence <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' reference.
	 * @see #getPrecedence()
	 * @generated
	 */
	void setPrecedence(Precedence value);

	/**
	 * Returns the value of the '<em><b>Invalidating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalidating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalidating</em>' attribute.
	 * @see #setInvalidating(boolean)
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_Invalidating()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean"
	 * @generated
	 */
	boolean isInvalidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isInvalidating <em>Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invalidating</em>' attribute.
	 * @see #isInvalidating()
	 * @generated
	 */
	void setInvalidating(boolean value);

	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_Static()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Validating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validating</em>' attribute.
	 * @see #setValidating(boolean)
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.OCLstdlibCSPackage#getLibOperationCS_Validating()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean"
	 * @generated
	 */
	boolean isValidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibcs.LibOperationCS#isValidating <em>Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validating</em>' attribute.
	 * @see #isValidating()
	 * @generated
	 */
	void setValidating(boolean value);

} // LibOperationCS

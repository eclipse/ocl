/**
 * <copyright>
 *
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.ocl.examples.xtext.base.basecs;

import org.eclipse.ocl.examples.pivot.Parameter;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getParameterCS()
 * @model
 * @generated
 */
public interface ParameterCS extends TypedElementCS {

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedParameter <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(OperationCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getParameterCS_Owner()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedParameter
	 * @model opposite="ownedParameter" transient="false"
	 * @generated
	 */
	OperationCS getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(OperationCS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='ocl::Parameter {\n\t\t\t\t-- TODO\n\t\t\t\tname = name\n\t\t\t}'"
	 * @generated
	 */
	Parameter ast();
} // ParameterCS

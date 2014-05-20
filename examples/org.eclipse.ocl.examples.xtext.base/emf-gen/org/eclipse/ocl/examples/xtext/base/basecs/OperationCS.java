/**
 * <copyright>
 *
 * Copyright (c) 2010, 2013 E.D.Willink and others.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedParameter <em>Owned Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedException <em>Owned Exception</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedPrecondition <em>Owned Precondition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedPostcondition <em>Owned Postcondition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwnedBodyExpression <em>Owned Body Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getOperationCS()
 * @model
 * @generated
 */
public interface OperationCS extends FeatureCS, TemplateableElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getOperationCS_OwnedParameter()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedParameter();

	/**
	 * Returns the value of the '<em><b>Owned Exception</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Exception</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Exception</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getOperationCS_OwnedException()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedException();

	/**
	 * Returns the value of the '<em><b>Owned Precondition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Precondition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Precondition</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getOperationCS_OwnedPrecondition()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedPrecondition();

	/**
	 * Returns the value of the '<em><b>Owned Postcondition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Postcondition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Postcondition</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getOperationCS_OwnedPostcondition()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedPostcondition();

	/**
	 * Returns the value of the '<em><b>Owned Body Expression</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.basecs.SpecificationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Body Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body Expression</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getOperationCS_OwnedBodyExpression()
	 * @model containment="true"
	 * @generated
	 */
	EList<SpecificationCS> getOwnedBodyExpression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='ocl::Operation {\n\t\t\t\t-- TODO\n\t\t\t\tname = name\n\t\t\t}'"
	 * @generated
	 */
	Operation ast();

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see #setOwningClass(ClassCS)
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage#getOperationCS_OwningClass()
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassCS#getOwnedOperation
	 * @model opposite="ownedOperation" transient="false"
	 * @generated
	 */
	ClassCS getOwningClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS#getOwningClass <em>Owning Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' container reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(ClassCS value);

} // OperationCS

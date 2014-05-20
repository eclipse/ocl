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
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainOperation
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An operation is owned by a class and may be invoked in the context of objects that are instances of that class. It is a typed element and a multiplicity element.
 * Operation specializes TemplateableElement in order to support specification of template operations and bound operations. Operation specializes ParameterableElement to specify that an operation can be exposed as a formal template parameter, and provided as an actual parameter in a binding of a template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#isInvalidating <em>Is Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#isValidating <em>Is Validating</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getOwnedParameter <em>Owned Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getRaisedException <em>Raised Exception</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Operation#getRedefinedOperation <em>Redefined Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation()
 * @generated
 */
public interface Operation
		extends Feature, Namespace, TemplateableElement, ParameterableElement, org.eclipse.ocl.examples.domain.elements.DomainOperation {

	/**
	 * Returns the value of the '<em><b>Raised Exception</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exceptions that are declared as possible during an invocation of the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Raised Exception</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_RaisedException()
	 * @generated
	 */
	@NonNull List<Type> getRaisedException();

	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters to the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_OwnedParameter()
	 * @see org.eclipse.ocl.examples.pivot.Parameter#getOperation
	 * @generated
	 */
	@NonNull List<Parameter> getOwnedParameter();

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
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_Precedence()
	 * @generated
	 */
	Precedence getPrecedence();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Operation#getPrecedence <em>Precedence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedence</em>' reference.
	 * @see #getPrecedence()
	 * @generated
	 */
	void setPrecedence(Precedence value);

	/**
	 * Returns the value of the '<em><b>Redefined Operation</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefined Operation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefined Operation</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_RedefinedOperation()
	 * @generated
	 */
	@NonNull List<Operation> getRedefinedOperation();

	/**
	 * Returns the value of the '<em><b>Owning Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Type#getOwnedOperation <em>Owned Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Type</em>' container reference.
	 * @see #setOwningType(Type)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_OwningType()
	 * @see org.eclipse.ocl.examples.pivot.Type#getOwnedOperation
	 * @generated
	 */
	Type getOwningType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Operation#getOwningType <em>Owning Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Type</em>' container reference.
	 * @see #getOwningType()
	 * @generated
	 */
	void setOwningType(Type value);

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_Precondition()
	 * @generated
	 */
	@NonNull List<Constraint> getPrecondition();

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_Postcondition()
	 * @generated
	 */
	@NonNull List<Constraint> getPostcondition();

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(OpaqueExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_BodyExpression()
	 * @generated
	 */
	OpaqueExpression getBodyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Operation#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(OpaqueExpression value);

	/**
	 * Returns the value of the '<em><b>Is Invalidating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Invalidating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Invalidating</em>' attribute.
	 * @see #setIsInvalidating(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_IsInvalidating()
	 * @generated
	 */
	boolean isInvalidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Operation#isInvalidating <em>Is Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Invalidating</em>' attribute.
	 * @see #isInvalidating()
	 * @generated
	 */
	void setIsInvalidating(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Validating</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Validating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Validating</em>' attribute.
	 * @see #setIsValidating(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_IsValidating()
	 * @generated
	 */
	boolean isValidating();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Operation#isValidating <em>Is Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Validating</em>' attribute.
	 * @see #isValidating()
	 * @generated
	 */
	void setIsValidating(boolean value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class that owns the operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOperation_Class()
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getClass_();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleReturn(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateLoadableImplementation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniquePreconditionName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniquePostconditionName(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Operation

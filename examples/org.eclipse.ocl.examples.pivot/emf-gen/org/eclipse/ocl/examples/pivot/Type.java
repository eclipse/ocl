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
 * A representation of the model object '<em><b>Type</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainType
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type is a named element that is used as the type for a typed element. A type can be contained in a package.
 * Type is defined to be a kind of templateable element so that a type can be parameterized. It is also defined to be a kind of parameterable element so that a type can be a formal template parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Type#getExtendedBys <em>Extended Bys</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Type#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Type#getOwnedAttribute <em>Owned Attribute</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Type#getOwnedInvariant <em>Owned Invariant</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Type#getOwnedOperation <em>Owned Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Type#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Type#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType()
 * @generated
 */
public interface Type
		extends NamedElement, TemplateableElement, ParameterableElement, org.eclipse.ocl.examples.domain.elements.DomainType {

	/**
	 * Returns the value of the '<em><b>Extended Bys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.TypeExtension}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TypeExtension#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Bys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Bys</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType_ExtendedBys()
	 * @see org.eclipse.ocl.examples.pivot.TypeExtension#getType
	 * @generated
	 */
	List<TypeExtension> getExtendedBys();

	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the owning package of this classifier, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(org.eclipse.ocl.examples.pivot.Package)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType_Package()
	 * @see org.eclipse.ocl.examples.pivot.Package#getOwnedType
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package getPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Type#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(org.eclipse.ocl.examples.pivot.Package value);

	/**
	 * Returns the value of the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Property#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attribute</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType_OwnedAttribute()
	 * @see org.eclipse.ocl.examples.pivot.Property#getOwningType
	 * @generated
	 */
	@NonNull List<Property> getOwnedAttribute();

	/**
	 * Returns the value of the '<em><b>Owned Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Operation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Operation#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operation</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType_OwnedOperation()
	 * @see org.eclipse.ocl.examples.pivot.Operation#getOwningType
	 * @generated
	 */
	@NonNull List<Operation> getOwnedOperation();

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType_SuperClass()
	 * @generated
	 */
	@NonNull List<Type> getSuperClass();

	/**
	 * Returns the value of the '<em><b>Owned Invariant</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Invariant</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Invariant</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType_OwnedInvariant()
	 * @generated
	 */
	@NonNull List<Constraint> getOwnedInvariant();

	/**
	 * Returns the value of the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Class Name</em>' attribute.
	 * @see #setInstanceClassName(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getType_InstanceClassName()
	 * @generated
	 */
	String getInstanceClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Type#getInstanceClassName <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Class Name</em>' attribute.
	 * @see #getInstanceClassName()
	 * @generated
	 */
	void setInstanceClassName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Type specializeIn(OCLExpression expr, Type selfType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniqueInvariantName(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Type

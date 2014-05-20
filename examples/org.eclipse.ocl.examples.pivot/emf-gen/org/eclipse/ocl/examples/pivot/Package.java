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

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainPackage
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A package is a container for types and other packages.
 * Package specializes TemplateableElement and PackageableElement specializes ParameterableElement to specify that a package can be used as a template and a PackageableElement as a template parameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getImportedPackage <em>Imported Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Package#getProfileApplication <em>Profile Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage()
 * @generated
 */
public interface Package
		extends Namespace, TemplateableElement, org.eclipse.ocl.examples.domain.elements.DomainPackage {

	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of contained packages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NestedPackage()
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestingPackage
	 * @generated
	 */
	@NonNull List<Package> getNestedPackage();

	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NsPrefix()
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Package#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns URI</em>' attribute.
	 * @see #setNsURI(String)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NsURI()
	 * @generated
	 */
	String getNsURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Package#getNsURI <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns URI</em>' attribute.
	 * @see #getNsURI()
	 * @generated
	 */
	void setNsURI(String value);

	/**
	 * Returns the value of the '<em><b>Imported Package</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Package</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_ImportedPackage()
	 * @generated
	 */
	@NonNull List<Package> getImportedPackage();

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Type}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Type#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of contained types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_OwnedType()
	 * @see org.eclipse.ocl.examples.pivot.Type#getPackage
	 * @generated
	 */
	@NonNull List<Type> getOwnedType();

	/**
	 * Returns the value of the '<em><b>Profile Application</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.ProfileApplication}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.ProfileApplication#getApplyingPackage <em>Applying Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Application</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Application</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_ProfileApplication()
	 * @see org.eclipse.ocl.examples.pivot.ProfileApplication#getApplyingPackage
	 * @generated
	 */
	@NonNull List<ProfileApplication> getProfileApplication();

	/**
	 * Returns the value of the '<em><b>Nesting Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getNestedPackage <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nesting Package</em>' container reference.
	 * @see #setNestingPackage(Package)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getPackage_NestingPackage()
	 * @see org.eclipse.ocl.examples.pivot.Package#getNestedPackage
	 * @generated
	 */
	Package getNestingPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Package#getNestingPackage <em>Nesting Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nesting Package</em>' container reference.
	 * @see #getNestingPackage()
	 * @generated
	 */
	void setNestingPackage(Package value);

} // Package

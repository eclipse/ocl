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
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * @extends org.eclipse.ocl.domain.elements.DomainPackage
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A package is a container for types and other packages.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getImportedPackage <em>Imported Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwnedClasses <em>Owned Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwnedInstances <em>Owned Instances</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwnedPackages <em>Owned Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Package#getProfileApplication <em>Profile Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage()
 * @generated
 */
public interface Package
		extends Namespace, org.eclipse.ocl.domain.elements.DomainPackage {

	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Package#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of contained packages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwnedPackages()
	 * @see org.eclipse.ocl.pivot.Package#getOwningPackage
	 * @generated
	 */
	@Override
	@NonNull List<Package> getOwnedPackages();

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
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_NsPrefix()
	 * @generated
	 */
	@Override
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Package#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(String)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_URI()
	 * @generated
	 */
	@Override
	String getURI();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Package#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(String value);

	/**
	 * Returns the value of the '<em><b>Owned Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.InstanceSpecification}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.InstanceSpecification#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The instance specification that owns this slot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Instances</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwnedInstances()
	 * @see org.eclipse.ocl.pivot.InstanceSpecification#getOwningPackage
	 * @generated
	 */
	List<InstanceSpecification> getOwnedInstances();

	/**
	 * Returns the value of the '<em><b>Imported Package</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Package</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_ImportedPackage()
	 * @generated
	 */
	@NonNull List<Package> getImportedPackage();

	/**
	 * Returns the value of the '<em><b>Owned Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Class}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Class#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of contained types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Classes</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwnedClasses()
	 * @see org.eclipse.ocl.pivot.Class#getOwningPackage
	 * @generated
	 */
	@Override
	@NonNull List<org.eclipse.ocl.pivot.Class> getOwnedClasses();

	/**
	 * Returns the value of the '<em><b>Profile Application</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.ProfileApplication}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.ProfileApplication#getApplyingPackage <em>Applying Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Application</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Application</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_ProfileApplication()
	 * @see org.eclipse.ocl.pivot.ProfileApplication#getApplyingPackage
	 * @generated
	 */
	@NonNull List<ProfileApplication> getProfileApplication();

	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Package#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing package.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see #setOwningPackage(Package)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getPackage_OwningPackage()
	 * @see org.eclipse.ocl.pivot.Package#getOwnedPackages
	 * @generated
	 */
	@Override
	Package getOwningPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Package#getOwningPackage <em>Owning Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Package</em>' container reference.
	 * @see #getOwningPackage()
	 * @generated
	 */
	void setOwningPackage(Package value);

} // Package

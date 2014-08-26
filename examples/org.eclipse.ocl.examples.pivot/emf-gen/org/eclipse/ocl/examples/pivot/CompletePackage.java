/**
 * Copyright (c) 2010,2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.examples.pivot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompleteClasses <em>Owned Complete Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompletePackages <em>Owned Complete Packages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwningCompletePackage <em>Owning Complete Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getPartialPackages <em>Partial Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage()
 * @generated
 */
public interface CompletePackage extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Owned Complete Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompleteClass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.CompleteClass#getOwningCompletePackage <em>Owning Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Classes</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_OwnedCompleteClasses()
	 * @see org.eclipse.ocl.examples.pivot.CompleteClass#getOwningCompletePackage
	 * @generated
	 */
	List<CompleteClass> getOwnedCompleteClasses();

	/**
	 * Returns the value of the '<em><b>Owned Complete Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompletePackage}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwningCompletePackage <em>Owning Complete Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Complete Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Complete Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_OwnedCompletePackages()
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage#getOwningCompletePackage
	 * @generated
	 */
	List<CompletePackage> getOwnedCompletePackages();

	/**
	 * Returns the value of the '<em><b>Owning Complete Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.CompleteModel#getOwnedCompletePackages <em>Owned Complete Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Complete Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Complete Model</em>' container reference.
	 * @see #setOwningCompleteModel(CompleteModel)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_OwningCompleteModel()
	 * @see org.eclipse.ocl.examples.pivot.CompleteModel#getOwnedCompletePackages
	 * @generated
	 */
	CompleteModel getOwningCompleteModel();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwningCompleteModel <em>Owning Complete Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Model</em>' container reference.
	 * @see #getOwningCompleteModel()
	 * @generated
	 */
	void setOwningCompleteModel(CompleteModel value);

	/**
	 * Returns the value of the '<em><b>Owning Complete Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompletePackages <em>Owned Complete Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Complete Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Complete Package</em>' container reference.
	 * @see #setOwningCompletePackage(CompletePackage)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_OwningCompletePackage()
	 * @see org.eclipse.ocl.examples.pivot.CompletePackage#getOwnedCompletePackages
	 * @generated
	 */
	CompletePackage getOwningCompletePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getOwningCompletePackage <em>Owning Complete Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Complete Package</em>' container reference.
	 * @see #getOwningCompletePackage()
	 * @generated
	 */
	void setOwningCompletePackage(CompletePackage value);

	/**
	 * Returns the value of the '<em><b>Partial Packages</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Packages</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_PartialPackages()
	 * @generated
	 */
	List<org.eclipse.ocl.examples.pivot.Package> getPartialPackages();

} // CompletePackage

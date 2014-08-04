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
 * A representation of the model object '<em><b>Instance Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An instance specification is a model element that represents an instance in a modeled system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InstanceSpecification#getClasses <em>Classes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InstanceSpecification#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InstanceSpecification#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.InstanceSpecification#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInstanceSpecification()
 * @generated
 */
public interface InstanceSpecification extends PackageableElement
{
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classifier or classifiers of the represented instance. If multiple classifiers are specified, the instance is classified by all of them.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classes</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInstanceSpecification_Classes()
	 * @generated
	 */
	List<org.eclipse.ocl.examples.pivot.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getOwnedInstances <em>Owned Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see #setOwningPackage(org.eclipse.ocl.examples.pivot.Package)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInstanceSpecification_OwningPackage()
	 * @see org.eclipse.ocl.examples.pivot.Package#getOwnedInstances
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package getOwningPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.InstanceSpecification#getOwningPackage <em>Owning Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Package</em>' container reference.
	 * @see #getOwningPackage()
	 * @generated
	 */
	void setOwningPackage(org.eclipse.ocl.examples.pivot.Package value);

	/**
	 * Returns the value of the '<em><b>Slots</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Slot}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Slot#getOwningInstance <em>Owning Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A slot giving the value or values of a structural feature of the instance. An instance specification can have one slot per structural feature of its classifiers, including inherited features. It is not necessary to model a slot for each structural feature, in which case the instance specification is a partial description.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Slots</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInstanceSpecification_Slots()
	 * @see org.eclipse.ocl.examples.pivot.Slot#getOwningInstance
	 * @generated
	 */
	List<Slot> getSlots();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A specification of how to compute, derive, or construct the instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specification</em>' containment reference.
	 * @see #setSpecification(LanguageExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getInstanceSpecification_Specification()
	 * @generated
	 */
	LanguageExpression getSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.InstanceSpecification#getSpecification <em>Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' containment reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(LanguageExpression value);

} // InstanceSpecification

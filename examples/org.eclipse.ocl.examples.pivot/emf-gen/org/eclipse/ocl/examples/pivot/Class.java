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
 * A representation of the model object '<em><b>Class</b></em>'.
 * @extends org.eclipse.ocl.examples.domain.elements.DomainClass
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A class is a type that has objects as its instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#isActive <em>Is Active</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#isInterface <em>Is Interface</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getOwnedInvariants <em>Owned Invariants</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Class#getSuperClasses <em>Super Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_()
 * @generated
 */
public interface Class
		extends Type, Namespace, TemplateableElement, org.eclipse.ocl.examples.domain.elements.DomainClass {

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
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_InstanceClassName()
	 * @generated
	 */
	String getInstanceClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#getInstanceClassName <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Class Name</em>' attribute.
	 * @see #getInstanceClassName()
	 * @generated
	 */
	void setInstanceClassName(String value);

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True when a class is abstract.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_IsAbstract()
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#isAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Active</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True when a class is active.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Active</em>' attribute.
	 * @see #setIsActive(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_IsActive()
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#isActive <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setIsActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Behavior</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Behavior</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_OwnedBehavior()
	 * @generated
	 */
	@NonNull List<Behavior> getOwnedBehavior();

	/**
	 * Returns the value of the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Invariants</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_OwnedInvariants()
	 * @generated
	 */
	@Override
	@NonNull List<Constraint> getOwnedInvariants();

	/**
	 * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Operation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Operation#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operations owned by a class. These do not include the inherited operations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Operations</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_OwnedOperations()
	 * @see org.eclipse.ocl.examples.pivot.Operation#getOwningClass
	 * @generated
	 */
	@Override
	@NonNull List<Operation> getOwnedOperations();

	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Package#getOwnedClasses <em>Owned Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the owning package of this classifier, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see #setOwningPackage(org.eclipse.ocl.examples.pivot.Package)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_OwningPackage()
	 * @see org.eclipse.ocl.examples.pivot.Package#getOwnedClasses
	 * @generated
	 */
	@Override
	org.eclipse.ocl.examples.pivot.Package getOwningPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#getOwningPackage <em>Owning Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Package</em>' container reference.
	 * @see #getOwningPackage()
	 * @generated
	 */
	void setOwningPackage(org.eclipse.ocl.examples.pivot.Package value);

	/**
	 * Returns the value of the '<em><b>Super Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The immediate superclasses of a class, from which the class inherits.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Classes</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_SuperClasses()
	 * @generated
	 */
	@Override
	@NonNull List<Class> getSuperClasses();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniqueInvariantName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Is Interface</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Interface</em>' attribute.
	 * @see #setIsInterface(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_IsInterface()
	 * @generated
	 */
	boolean isInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Class#isInterface <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Interface</em>' attribute.
	 * @see #isInterface()
	 * @generated
	 */
	void setIsInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Property}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.Property#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attributes owned by a class. These do not include the inherited attributes. Attributes are represented by instances of Property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Properties</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getClass_OwnedProperties()
	 * @see org.eclipse.ocl.examples.pivot.Property#getOwningClass
	 * @generated
	 */
	@Override
	@NonNull List<Property> getOwnedProperties();

} // Class

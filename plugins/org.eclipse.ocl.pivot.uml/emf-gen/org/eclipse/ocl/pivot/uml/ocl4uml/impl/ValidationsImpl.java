/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.ocl4uml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage;
import org.eclipse.ocl.pivot.uml.ocl4uml.Validations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationsImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.ValidationsImpl#isValidate <em>Validate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValidationsImpl
		extends EObjectImpl
		implements Validations {

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The default value of the '{@link #isValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidate() <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidate()
	 * @generated
	 * @ordered
	 */
	protected boolean validate = VALIDATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValidationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCL4UMLPackage.Literals.VALIDATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject) base_Package;
			base_Package = (org.eclipse.uml2.uml.Package) eResolveProxy(
				oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OCL4UMLPackage.VALIDATIONS__BASE_PACKAGE,
						oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.VALIDATIONS__BASE_PACKAGE, oldBase_Package,
				base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isValidate() {
		return validate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidate(boolean newValidate) {
		boolean oldValidate = validate;
		validate = newValidate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.VALIDATIONS__VALIDATE, oldValidate, validate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCL4UMLPackage.VALIDATIONS__BASE_PACKAGE :
				if (resolve)
					return getBase_Package();
				return basicGetBase_Package();
			case OCL4UMLPackage.VALIDATIONS__VALIDATE :
				return isValidate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OCL4UMLPackage.VALIDATIONS__BASE_PACKAGE :
				setBase_Package((org.eclipse.uml2.uml.Package) newValue);
				return;
			case OCL4UMLPackage.VALIDATIONS__VALIDATE :
				setValidate((Boolean) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OCL4UMLPackage.VALIDATIONS__BASE_PACKAGE :
				setBase_Package((org.eclipse.uml2.uml.Package) null);
				return;
			case OCL4UMLPackage.VALIDATIONS__VALIDATE :
				setValidate(VALIDATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OCL4UMLPackage.VALIDATIONS__BASE_PACKAGE :
				return base_Package != null;
			case OCL4UMLPackage.VALIDATIONS__VALIDATE :
				return validate != VALIDATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (validate: "); //$NON-NLS-1$
		result.append(validate);
		result.append(')');
		return result.toString();
	}

} //ValidationsImpl

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

import org.eclipse.ocl.pivot.uml.ocl4uml.Collections;
import org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collections</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionsImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionsImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionsImpl#isNullFree <em>Is Null Free</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionsImpl
		extends EObjectImpl
		implements Collections {

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

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
	 * The default value of the '{@link #isNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NULL_FREE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullFree()
	 * @generated
	 * @ordered
	 */
	protected boolean isNullFree = IS_NULL_FREE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCL4UMLPackage.Literals.COLLECTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject) base_Class;
			base_Class = (org.eclipse.uml2.uml.Class) eResolveProxy(
				oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OCL4UMLPackage.COLLECTIONS__BASE_CLASS, oldBase_Class,
						base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.COLLECTIONS__BASE_CLASS, oldBase_Class,
				base_Class));
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
						OCL4UMLPackage.COLLECTIONS__BASE_PACKAGE,
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
				OCL4UMLPackage.COLLECTIONS__BASE_PACKAGE, oldBase_Package,
				base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNullFree() {
		return isNullFree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNullFree(boolean newIsNullFree) {
		boolean oldIsNullFree = isNullFree;
		isNullFree = newIsNullFree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.COLLECTIONS__IS_NULL_FREE, oldIsNullFree,
				isNullFree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCL4UMLPackage.COLLECTIONS__BASE_CLASS :
				if (resolve)
					return getBase_Class();
				return basicGetBase_Class();
			case OCL4UMLPackage.COLLECTIONS__BASE_PACKAGE :
				if (resolve)
					return getBase_Package();
				return basicGetBase_Package();
			case OCL4UMLPackage.COLLECTIONS__IS_NULL_FREE :
				return isNullFree();
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
			case OCL4UMLPackage.COLLECTIONS__BASE_CLASS :
				setBase_Class((org.eclipse.uml2.uml.Class) newValue);
				return;
			case OCL4UMLPackage.COLLECTIONS__BASE_PACKAGE :
				setBase_Package((org.eclipse.uml2.uml.Package) newValue);
				return;
			case OCL4UMLPackage.COLLECTIONS__IS_NULL_FREE :
				setIsNullFree((Boolean) newValue);
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
			case OCL4UMLPackage.COLLECTIONS__BASE_CLASS :
				setBase_Class((org.eclipse.uml2.uml.Class) null);
				return;
			case OCL4UMLPackage.COLLECTIONS__BASE_PACKAGE :
				setBase_Package((org.eclipse.uml2.uml.Package) null);
				return;
			case OCL4UMLPackage.COLLECTIONS__IS_NULL_FREE :
				setIsNullFree(IS_NULL_FREE_EDEFAULT);
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
			case OCL4UMLPackage.COLLECTIONS__BASE_CLASS :
				return base_Class != null;
			case OCL4UMLPackage.COLLECTIONS__BASE_PACKAGE :
				return base_Package != null;
			case OCL4UMLPackage.COLLECTIONS__IS_NULL_FREE :
				return isNullFree != IS_NULL_FREE_EDEFAULT;
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
		result.append(" (isNullFree: "); //$NON-NLS-1$
		result.append(isNullFree);
		result.append(')');
		return result.toString();
	}

} //CollectionsImpl

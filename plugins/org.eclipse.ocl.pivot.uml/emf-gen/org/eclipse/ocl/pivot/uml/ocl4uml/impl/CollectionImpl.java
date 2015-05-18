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

import org.eclipse.ocl.pivot.uml.ocl4uml.Collection;
import org.eclipse.ocl.pivot.uml.ocl4uml.OCL4UMLPackage;

import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionImpl#getBase_TypedElement <em>Base Typed Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.ocl4uml.impl.CollectionImpl#isNullFree <em>Is Null Free</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionImpl
		extends EObjectImpl
		implements Collection {

	/**
	 * The cached value of the '{@link #getBase_TypedElement() <em>Base Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TypedElement()
	 * @generated
	 * @ordered
	 */
	protected TypedElement base_TypedElement;

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
	protected CollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCL4UMLPackage.Literals.COLLECTION;
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
				OCL4UMLPackage.COLLECTION__IS_NULL_FREE, oldIsNullFree,
				isNullFree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedElement getBase_TypedElement() {
		if (base_TypedElement != null && base_TypedElement.eIsProxy()) {
			InternalEObject oldBase_TypedElement = (InternalEObject) base_TypedElement;
			base_TypedElement = (TypedElement) eResolveProxy(
				oldBase_TypedElement);
			if (base_TypedElement != oldBase_TypedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OCL4UMLPackage.COLLECTION__BASE_TYPED_ELEMENT,
						oldBase_TypedElement, base_TypedElement));
			}
		}
		return base_TypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement basicGetBase_TypedElement() {
		return base_TypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_TypedElement(TypedElement newBase_TypedElement) {
		TypedElement oldBase_TypedElement = base_TypedElement;
		base_TypedElement = newBase_TypedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OCL4UMLPackage.COLLECTION__BASE_TYPED_ELEMENT,
				oldBase_TypedElement, base_TypedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OCL4UMLPackage.COLLECTION__BASE_TYPED_ELEMENT :
				if (resolve)
					return getBase_TypedElement();
				return basicGetBase_TypedElement();
			case OCL4UMLPackage.COLLECTION__IS_NULL_FREE :
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
			case OCL4UMLPackage.COLLECTION__BASE_TYPED_ELEMENT :
				setBase_TypedElement((TypedElement) newValue);
				return;
			case OCL4UMLPackage.COLLECTION__IS_NULL_FREE :
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
			case OCL4UMLPackage.COLLECTION__BASE_TYPED_ELEMENT :
				setBase_TypedElement((TypedElement) null);
				return;
			case OCL4UMLPackage.COLLECTION__IS_NULL_FREE :
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
			case OCL4UMLPackage.COLLECTION__BASE_TYPED_ELEMENT :
				return base_TypedElement != null;
			case OCL4UMLPackage.COLLECTION__IS_NULL_FREE :
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

} //CollectionImpl

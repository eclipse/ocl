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
package org.eclipse.ocl.xtext.basecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl#isIsNotUnique <em>Is Not Unique</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl#isIsOptional <em>Is Optional</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TypedElementCSImpl extends NamedElementCSImpl implements TypedElementCS
{
	/**
	 * The default value of the '{@link #isIsNotUnique() <em>Is Not Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNotUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NOT_UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsNotUnique() <em>Is Not Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNotUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isNotUnique = IS_NOT_UNIQUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOptional() <em>Is Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOptional() <em>Is Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean isOptional = IS_OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedElementCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return BaseCSPackage.Literals.TYPED_ELEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsNotUnique()
	{
		return isNotUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNotUnique(boolean newIsNotUnique)
	{
		boolean oldIsNotUnique = isNotUnique;
		isNotUnique = newIsNotUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_ELEMENT_CS__IS_NOT_UNIQUE, oldIsNotUnique, isNotUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedType()
	{
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedType(TypedRefCS newOwnedType, NotificationChain msgs)
	{
		TypedRefCS oldOwnedType = ownedType;
		ownedType = newOwnedType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedType(TypedRefCS newOwnedType)
	{
		if (newOwnedType != ownedType)
		{
			NotificationChain msgs = null;
			if (ownedType != null)
				msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE, null, msgs);
			if (newOwnedType != null)
				msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE, null, msgs);
			msgs = basicSetOwnedType(newOwnedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE, newOwnedType, newOwnedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOptional()
	{
		return isOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOptional(boolean newIsOptional)
	{
		boolean oldIsOptional = isOptional;
		isOptional = newIsOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL, oldIsOptional, isOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOrdered()
	{
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOrdered(boolean newIsOrdered)
	{
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSPackage.TYPED_ELEMENT_CS__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE:
				return basicSetOwnedType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_NOT_UNIQUE:
				return isIsNotUnique();
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL:
				return isIsOptional();
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_ORDERED:
				return isIsOrdered();
			case BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE:
				return getOwnedType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_NOT_UNIQUE:
				setIsNotUnique((Boolean)newValue);
				return;
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL:
				setIsOptional((Boolean)newValue);
				return;
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE:
				setOwnedType((TypedRefCS)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_NOT_UNIQUE:
				setIsNotUnique(IS_NOT_UNIQUE_EDEFAULT);
				return;
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL:
				setIsOptional(IS_OPTIONAL_EDEFAULT);
				return;
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE:
				setOwnedType((TypedRefCS)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_NOT_UNIQUE:
				return isNotUnique != IS_NOT_UNIQUE_EDEFAULT;
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL:
				return isOptional != IS_OPTIONAL_EDEFAULT;
			case BaseCSPackage.TYPED_ELEMENT_CS__IS_ORDERED:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE:
				return ownedType != null;
		}
		return super.eIsSet(featureID);
	}
} //TypedElementCSImpl

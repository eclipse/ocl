/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.CallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CallExpCSImpl#getOwnedSource <em>Owned Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.CallExpCSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CallExpCSImpl extends ExpCSImpl implements CallExpCS
{
	/**
	 * The cached value of the '{@link #getOwnedSource() <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSource()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedSource;

	/**
	 * The cached value of the '{@link #getOwnedPathName() <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedPathName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallExpCSImpl()
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
		return EssentialOCLCSPackage.Literals.CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOwnedSource()
	{
		return ownedSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSource(ExpCS newOwnedSource, NotificationChain msgs)
	{
		ExpCS oldOwnedSource = ownedSource;
		ownedSource = newOwnedSource;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE, oldOwnedSource, newOwnedSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedSource(ExpCS newOwnedSource)
	{
		if (newOwnedSource != ownedSource)
		{
			NotificationChain msgs = null;
			if (ownedSource != null)
				msgs = ((InternalEObject)ownedSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE, null, msgs);
			if (newOwnedSource != null)
				msgs = ((InternalEObject)newOwnedSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE, null, msgs);
			msgs = basicSetOwnedSource(newOwnedSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE, newOwnedSource, newOwnedSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getOwnedPathName()
	{
		return ownedPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPathName(PathNameCS newOwnedPathName, NotificationChain msgs)
	{
		PathNameCS oldOwnedPathName = ownedPathName;
		ownedPathName = newOwnedPathName;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME, oldOwnedPathName, newOwnedPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedPathName(PathNameCS newOwnedPathName)
	{
		if (newOwnedPathName != ownedPathName)
		{
			NotificationChain msgs = null;
			if (ownedPathName != null)
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME, null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME, null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME, newOwnedPathName, newOwnedPathName));
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
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE:
				return basicSetOwnedSource(null, msgs);
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME:
				return basicSetOwnedPathName(null, msgs);
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
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE:
				return getOwnedSource();
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME:
				return getOwnedPathName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE:
				setOwnedSource((ExpCS)newValue);
				return;
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)newValue);
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
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE:
				setOwnedSource((ExpCS)null);
				return;
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)null);
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
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_SOURCE:
				return ownedSource != null;
			case EssentialOCLCSPackage.CALL_EXP_CS__OWNED_PATH_NAME:
				return ownedPathName != null;
		}
		return super.eIsSet(featureID);
	}


} //CallExpCSImpl

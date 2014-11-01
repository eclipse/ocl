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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AssociationClassCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Class Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.AssociationClassCallExpCSImpl#getReferredAssociation <em>Referred Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationClassCallExpCSImpl extends CallExpCSImpl implements AssociationClassCallExpCS
{
	/**
	 * The cached value of the '{@link #getReferredAssociation() <em>Referred Association</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAssociation()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass referredAssociation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationClassCallExpCSImpl()
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
		return EssentialOCLCSPackage.Literals.ASSOCIATION_CLASS_CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass getReferredAssociation()
	{
		return referredAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredAssociation(AssociationClass newReferredAssociation, NotificationChain msgs)
	{
		AssociationClass oldReferredAssociation = referredAssociation;
		referredAssociation = newReferredAssociation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION, oldReferredAssociation, newReferredAssociation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAssociation(AssociationClass newReferredAssociation)
	{
		if (newReferredAssociation != referredAssociation)
		{
			NotificationChain msgs = null;
			if (referredAssociation != null)
				msgs = ((InternalEObject)referredAssociation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION, null, msgs);
			if (newReferredAssociation != null)
				msgs = ((InternalEObject)newReferredAssociation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION, null, msgs);
			msgs = basicSetReferredAssociation(newReferredAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION, newReferredAssociation, newReferredAssociation));
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
			case EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION:
				return basicSetReferredAssociation(null, msgs);
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
			case EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION:
				return getReferredAssociation();
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
			case EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION:
				setReferredAssociation((AssociationClass)newValue);
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
			case EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION:
				setReferredAssociation((AssociationClass)null);
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
			case EssentialOCLCSPackage.ASSOCIATION_CLASS_CALL_EXP_CS__REFERRED_ASSOCIATION:
				return referredAssociation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitAssociationClassCallExpCS(this);
	}

} //AssociationClassCallExpCSImpl

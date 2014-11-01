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
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.PropertyCallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PropertyCallExpCSImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.PropertyCallExpCSImpl#isIsPre <em>Is Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyCallExpCSImpl extends CallExpCSImpl implements PropertyCallExpCS
{
	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * The default value of the '{@link #isIsPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPre()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPre()
	 * @generated
	 * @ordered
	 */
	protected boolean isPre = IS_PRE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyCallExpCSImpl()
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
		return EssentialOCLCSPackage.Literals.PROPERTY_CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getReferredProperty()
	{
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredProperty(Property newReferredProperty, NotificationChain msgs)
	{
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY, oldReferredProperty, newReferredProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredProperty(Property newReferredProperty)
	{
		if (newReferredProperty != referredProperty)
		{
			NotificationChain msgs = null;
			if (referredProperty != null)
				msgs = ((InternalEObject)referredProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY, null, msgs);
			if (newReferredProperty != null)
				msgs = ((InternalEObject)newReferredProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY, null, msgs);
			msgs = basicSetReferredProperty(newReferredProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY, newReferredProperty, newReferredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPre()
	{
		return isPre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPre(boolean newIsPre)
	{
		boolean oldIsPre = isPre;
		isPre = newIsPre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__IS_PRE, oldIsPre, isPre));
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
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY:
				return basicSetReferredProperty(null, msgs);
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
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY:
				return getReferredProperty();
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__IS_PRE:
				return isIsPre();
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
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
				return;
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__IS_PRE:
				setIsPre((Boolean)newValue);
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
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
				return;
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
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
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__REFERRED_PROPERTY:
				return referredProperty != null;
			case EssentialOCLCSPackage.PROPERTY_CALL_EXP_CS__IS_PRE:
				return isPre != IS_PRE_EDEFAULT;
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitPropertyCallExpCS(this);
	}

} //PropertyCallExpCSImpl

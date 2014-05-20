/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NamedExpCSImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.NamedExpCSImpl#getNameExp <em>Name Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedExpCSImpl
		extends ExpCSImpl
		implements NamedExpCS {

	/**
	 * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected Type sourceType;

	/**
	 * The cached value of the '{@link #getNameExp() <em>Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameExp()
	 * @generated
	 * @ordered
	 */
	protected NameExpCS nameExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.NAMED_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS getNameExp() {
		return nameExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNameExp(NameExpCS newNameExp,
			NotificationChain msgs) {
		NameExpCS oldNameExp = nameExp;
		nameExp = newNameExp;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP, oldNameExp, newNameExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameExp(NameExpCS newNameExp) {
		if (newNameExp != nameExp)
		{
			NotificationChain msgs = null;
			if (nameExp != null)
				msgs = ((InternalEObject)nameExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP, null, msgs);
			if (newNameExp != null)
				msgs = ((InternalEObject)newNameExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP, null, msgs);
			msgs = basicSetNameExp(newNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP, newNameExp, newNameExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getSourceType()
	{
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceType(Type newSourceType)
	{
		Type oldSourceType = sourceType;
		sourceType = newSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.NAMED_EXP_CS__SOURCE_TYPE, oldSourceType, sourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP:
				return basicSetNameExp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case EssentialOCLCSPackage.NAMED_EXP_CS__SOURCE_TYPE:
				return getSourceType();
			case EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP:
				return getNameExp();
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
		switch (featureID)
		{
			case EssentialOCLCSPackage.NAMED_EXP_CS__SOURCE_TYPE:
				setSourceType((Type)newValue);
				return;
			case EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP:
				setNameExp((NameExpCS)newValue);
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
		switch (featureID)
		{
			case EssentialOCLCSPackage.NAMED_EXP_CS__SOURCE_TYPE:
				setSourceType((Type)null);
				return;
			case EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP:
				setNameExp((NameExpCS)null);
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
		switch (featureID)
		{
			case EssentialOCLCSPackage.NAMED_EXP_CS__SOURCE_TYPE:
				return sourceType != null;
			case EssentialOCLCSPackage.NAMED_EXP_CS__NAME_EXP:
				return nameExp != null;
		}
		return super.eIsSet(featureID);
	}

	public NamedElement getNamedElement() {
		NameExpCS nameExp2 = getNameExp();
		return nameExp2 != null
			? nameExp2.getNamedElement()
			: null;
	}

	public PathNameCS getPathName() {
		NameExpCS nameExp2 = getNameExp();
		return nameExp2 != null
			? nameExp2.getPathName()
			: null;
	}

} //NamedExpCSImpl

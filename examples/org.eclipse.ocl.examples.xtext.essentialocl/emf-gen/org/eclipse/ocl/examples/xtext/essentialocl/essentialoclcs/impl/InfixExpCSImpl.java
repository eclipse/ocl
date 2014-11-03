/*******************************************************************************
 * Copyright (c) 2010, 2012 E.D.Willink and others.
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
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedOperator <em>Owned Operator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedSuffix <em>Owned Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfixExpCSImpl
		extends ExpCSImpl
		implements InfixExpCS {

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedExpression;

	/**
	 * The cached value of the '{@link #getOwnedOperator() <em>Owned Operator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperator()
	 * @generated
	 * @ordered
	 */
	protected BinaryOperatorCS ownedOperator;

	/**
	 * The cached value of the '{@link #getOwnedSuffix() <em>Owned Suffix</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSuffix()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedSuffix;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfixExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.INFIX_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOwnedExpression()
	{
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(ExpCS newOwnedExpression, NotificationChain msgs)
	{
		ExpCS oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedExpression(ExpCS newOwnedExpression)
	{
		if (newOwnedExpression != ownedExpression)
		{
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperatorCS getOwnedOperator()
	{
		return ownedOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedOperator(BinaryOperatorCS newOwnedOperator, NotificationChain msgs)
	{
		BinaryOperatorCS oldOwnedOperator = ownedOperator;
		ownedOperator = newOwnedOperator;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR, oldOwnedOperator, newOwnedOperator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedOperator(BinaryOperatorCS newOwnedOperator)
	{
		if (newOwnedOperator != ownedOperator)
		{
			NotificationChain msgs = null;
			if (ownedOperator != null)
				msgs = ((InternalEObject)ownedOperator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR, null, msgs);
			if (newOwnedOperator != null)
				msgs = ((InternalEObject)newOwnedOperator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR, null, msgs);
			msgs = basicSetOwnedOperator(newOwnedOperator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR, newOwnedOperator, newOwnedOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOwnedSuffix()
	{
		return ownedSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSuffix(ExpCS newOwnedSuffix, NotificationChain msgs)
	{
		ExpCS oldOwnedSuffix = ownedSuffix;
		ownedSuffix = newOwnedSuffix;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX, oldOwnedSuffix, newOwnedSuffix);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedSuffix(ExpCS newOwnedSuffix)
	{
		if (newOwnedSuffix != ownedSuffix)
		{
			NotificationChain msgs = null;
			if (ownedSuffix != null)
				msgs = ((InternalEObject)ownedSuffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX, null, msgs);
			if (newOwnedSuffix != null)
				msgs = ((InternalEObject)newOwnedSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX, null, msgs);
			msgs = basicSetOwnedSuffix(newOwnedSuffix, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX, newOwnedSuffix, newOwnedSuffix));
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				return basicSetOwnedExpression(null, msgs);
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				return basicSetOwnedOperator(null, msgs);
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX:
				return basicSetOwnedSuffix(null, msgs);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				return getOwnedExpression();
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				return getOwnedOperator();
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX:
				return getOwnedSuffix();
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)newValue);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				setOwnedOperator((BinaryOperatorCS)newValue);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX:
				setOwnedSuffix((ExpCS)newValue);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)null);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				setOwnedOperator((BinaryOperatorCS)null);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX:
				setOwnedSuffix((ExpCS)null);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_EXPRESSION:
				return ownedExpression != null;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_OPERATOR:
				return ownedOperator != null;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SUFFIX:
				return ownedSuffix != null;
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitInfixExpCS(this);
	}
} //BinaryExpressionCSImpl

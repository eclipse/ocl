/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IfExpCSImpl#getOwnedElseExpression <em>Owned Else Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.IfExpCSImpl#getOwnedIfThenExpressions <em>Owned If Then Expressions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfExpCSImpl
		extends ExpCSImpl
		implements IfExpCS {

	/**
	 * The cached value of the '{@link #getOwnedElseExpression() <em>Owned Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElseExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedElseExpression;

	/**
	 * The cached value of the '{@link #getOwnedIfThenExpressions() <em>Owned If Then Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIfThenExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<IfThenExpCS> ownedIfThenExpressions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.IF_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IfThenExpCS> getOwnedIfThenExpressions()
	{
		if (ownedIfThenExpressions == null)
		{
			ownedIfThenExpressions = new EObjectContainmentEList<IfThenExpCS>(IfThenExpCS.class, this, EssentialOCLCSPackage.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS);
		}
		return ownedIfThenExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedElseExpression() {
		return ownedElseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedElseExpression(ExpCS newOwnedElseExpression, NotificationChain msgs)
	{
		ExpCS oldOwnedElseExpression = ownedElseExpression;
		ownedElseExpression = newOwnedElseExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION, oldOwnedElseExpression, newOwnedElseExpression);
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
	public void setOwnedElseExpression(ExpCS newOwnedElseExpression)
	{
		if (newOwnedElseExpression != ownedElseExpression)
		{
			NotificationChain msgs = null;
			if (ownedElseExpression != null)
				msgs = ((InternalEObject)ownedElseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION, null, msgs);
			if (newOwnedElseExpression != null)
				msgs = ((InternalEObject)newOwnedElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION, null, msgs);
			msgs = basicSetOwnedElseExpression(newOwnedElseExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION, newOwnedElseExpression, newOwnedElseExpression));
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
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION:
				return basicSetOwnedElseExpression(null, msgs);
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS:
				return ((InternalEList<?>)getOwnedIfThenExpressions()).basicRemove(otherEnd, msgs);
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
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION:
				return getOwnedElseExpression();
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS:
				return getOwnedIfThenExpressions();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION:
				setOwnedElseExpression((ExpCS)newValue);
				return;
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS:
				getOwnedIfThenExpressions().clear();
				getOwnedIfThenExpressions().addAll((Collection<? extends IfThenExpCS>)newValue);
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
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION:
				setOwnedElseExpression((ExpCS)null);
				return;
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS:
				getOwnedIfThenExpressions().clear();
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
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_ELSE_EXPRESSION:
				return ownedElseExpression != null;
			case EssentialOCLCSPackage.IF_EXP_CS__OWNED_IF_THEN_EXPRESSIONS:
				return ownedIfThenExpressions != null && !ownedIfThenExpressions.isEmpty();
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitIfExpCS(this);
	}
} //IfExpCSImpl

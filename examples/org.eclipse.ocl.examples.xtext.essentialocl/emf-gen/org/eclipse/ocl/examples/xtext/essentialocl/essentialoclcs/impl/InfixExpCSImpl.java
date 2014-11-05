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
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedSource <em>Owned Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedArgument <em>Owned Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getDerivedSource <em>Derived Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfixExpCSImpl
		extends OperatorCSImpl
		implements InfixExpCS {

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
	 * The cached value of the '{@link #getOwnedArgument() <em>Owned Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedArgument()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedArgument;

	/**
	 * The cached value of the '{@link #getDerivedSource() <em>Derived Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedSource()
	 * @generated
	 * @ordered
	 */
	protected ExpCS derivedSource;

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected ExpCS argument;

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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE, oldOwnedSource, newOwnedSource);
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
				msgs = ((InternalEObject)ownedSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE, null, msgs);
			if (newOwnedSource != null)
				msgs = ((InternalEObject)newOwnedSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE, null, msgs);
			msgs = basicSetOwnedSource(newOwnedSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE, newOwnedSource, newOwnedSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOwnedArgument()
	{
		return ownedArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedArgument(ExpCS newOwnedArgument, NotificationChain msgs)
	{
		ExpCS oldOwnedArgument = ownedArgument;
		ownedArgument = newOwnedArgument;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT, oldOwnedArgument, newOwnedArgument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedArgument(ExpCS newOwnedArgument)
	{
		if (newOwnedArgument != ownedArgument)
		{
			NotificationChain msgs = null;
			if (ownedArgument != null)
				msgs = ((InternalEObject)ownedArgument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT, null, msgs);
			if (newOwnedArgument != null)
				msgs = ((InternalEObject)newOwnedArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT, null, msgs);
			msgs = basicSetOwnedArgument(newOwnedArgument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT, newOwnedArgument, newOwnedArgument));
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE:
				return basicSetOwnedSource(null, msgs);
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT:
				return basicSetOwnedArgument(null, msgs);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE:
				return getOwnedSource();
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT:
				return getOwnedArgument();
			case EssentialOCLCSPackage.INFIX_EXP_CS__DERIVED_SOURCE:
				return getDerivedSource();
			case EssentialOCLCSPackage.INFIX_EXP_CS__ARGUMENT:
				return getArgument();
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE:
				setOwnedSource((ExpCS)newValue);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT:
				setOwnedArgument((ExpCS)newValue);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__ARGUMENT:
				setArgument((ExpCS)newValue);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE:
				setOwnedSource((ExpCS)null);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT:
				setOwnedArgument((ExpCS)null);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS__ARGUMENT:
				setArgument((ExpCS)null);
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_SOURCE:
				return ownedSource != null;
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT:
				return ownedArgument != null;
			case EssentialOCLCSPackage.INFIX_EXP_CS__DERIVED_SOURCE:
				return derivedSource != null;
			case EssentialOCLCSPackage.INFIX_EXP_CS__ARGUMENT:
				return argument != null;
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

	public ExpCS getDerivedSource() {
		return derivedSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getArgument()
	{
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgument(ExpCS newArgument)
	{
		ExpCS oldArgument = argument;
		argument = newArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.INFIX_EXP_CS__ARGUMENT, oldArgument, argument));
	}

	@Override
	public void resetPivot() {
		super.resetPivot();
		setArgument(null);
		derivedSource = null;
	}
} //BinaryExpressionCSImpl

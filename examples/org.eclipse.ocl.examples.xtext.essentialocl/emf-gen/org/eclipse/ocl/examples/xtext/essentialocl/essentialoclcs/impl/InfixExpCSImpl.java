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
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2AS;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getOwnedArgument <em>Owned Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getDerivedArgument <em>Derived Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.InfixExpCSImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfixExpCSImpl
		extends OperatorExpCSImpl
		implements InfixExpCS {

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
	 * The cached value of the '{@link #getDerivedArgument() <em>Derived Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedArgument()
	 * @generated
	 * @ordered
	 */
	protected ExpCS derivedArgument;

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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT:
				return getOwnedArgument();
			case EssentialOCLCSPackage.INFIX_EXP_CS__DERIVED_ARGUMENT:
				return getDerivedArgument();
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
			case EssentialOCLCSPackage.INFIX_EXP_CS__OWNED_ARGUMENT:
				return ownedArgument != null;
			case EssentialOCLCSPackage.INFIX_EXP_CS__DERIVED_ARGUMENT:
				return derivedArgument != null;
			case EssentialOCLCSPackage.INFIX_EXP_CS__ARGUMENT:
				return false;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExpCS getArgument()
	{
		ExpCS expCS = getDerivedArgument();
		assert !EssentialOCLCSPostOrderVisitor.doesInterleave || (expCS == argument);
		return expCS;
	}

	private boolean derivedArgumentIsSet = false;
	
	private ExpCS argument = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgument(ExpCS newArgument)
	{
		derivedArgumentIsSet = newArgument != null;
		argument = newArgument;
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

	public ExpCS getDerivedArgument() {
		if (EssentialOCLCSPostOrderVisitor.interleaveInProgress) {
			assert !isInterleaved;
			return argument;
		}
		if (EssentialOCLCSPostOrderVisitor.doesInterleave && !derivedArgumentIsSet) {
			assert !isInterleaved || (argument == null);
			return null;
		}
		if (!EssentialOCLCSPostOrderVisitor.doesInterleave && !isInterleaved) {
			return null;
		}
		assert isInterleaved || !(eContainer() instanceof OperatorExpCS);
		if (derivedArgument == null) {
			ExpCS csLowestRight = null;
			for (ExpCS csRight = this; (csRight = csRight.getLocalRight()) != null; ) {
				if ((csRight instanceof OperatorExpCS) && ((OperatorExpCS) csRight).isLocalRightAncestorOf(this)) {
					break;
				}
				if ((csLowestRight == null) || ((csRight instanceof OperatorExpCS) && ((OperatorExpCS) csRight).isLocalRightAncestorOf(csLowestRight))) {
					csLowestRight = csRight;
				}
			}
			derivedArgument = csLowestRight;
		}
		assert !EssentialOCLCSPostOrderVisitor.doesInterleave || (derivedArgument == argument);
		return derivedArgument;
	}

	public ExpCS getDerivedSource() {
		if (EssentialOCLCSPostOrderVisitor.interleaveInProgress) {
			assert !isInterleaved;
			return source;
		}
		if (EssentialOCLCSPostOrderVisitor.doesInterleave && !derivedSourceIsSet) {
			assert !isInterleaved || (source == null);
			return null;
		}
		if (!EssentialOCLCSPostOrderVisitor.doesInterleave && !isInterleaved) {
			return null;
		}
		assert isInterleaved || !(eContainer() instanceof OperatorExpCS);
		if (derivedSource == null) {
			ExpCS csLowestLeft = null;
			for (ExpCS csLeft = this; (csLeft = csLeft.getLocalLeft()) != null; ) {
				if ((csLeft instanceof OperatorExpCS) && ((OperatorExpCS)csLeft).isLocalLeftAncestorOf(this)) {
					break;
				}
				if ((csLowestLeft == null) || ((csLeft instanceof OperatorExpCS) && ((OperatorExpCS)csLeft).isLocalLeftAncestorOf(csLowestLeft))) {
					csLowestLeft = csLeft;
				}
			}
			derivedSource = csLowestLeft;
		}
		return derivedSource;
	}

	@Override
	public @Nullable ExpCS getLocalLeft() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getLocalRightmostDescendant() : null;
	}

	@Override
	public @NonNull ExpCS getLocalLeftmostDescendant() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getLocalLeftmostDescendant() : this;
	}

	@Override
	public @Nullable ExpCS getLocalRight() {
		ExpCS ownedArgument = getOwnedArgument();
		return ownedArgument != null ? ownedArgument.getLocalLeftmostDescendant() : null;
	}

	@Override
	public @NonNull ExpCS getLocalRightmostDescendant() {
		ExpCS ownedArgument = getOwnedArgument();
		return ownedArgument != null ? ownedArgument.getLocalRightmostDescendant() : this;
	}
	
	public boolean isLocalRightAncestorOf(@NonNull ExpCS csExp) {	// csExp should be to the right of this for associativity resolution
		return !EssentialOCLCS2AS.isLocalProperAncestorOf(csExp, this);
	}

	@Override
	public void resetPivot() {
		super.resetPivot();
		setArgument(null);
		derivedArgument = null;
		derivedArgumentIsSet = false;
	}
	
	@Override
	public void setInterleaved() {
		super.setInterleaved();
		ExpCS ownedSource2 = getOwnedSource();
		if (ownedSource2 != null) {
			ownedSource2.setInterleaved();
		}
		ExpCS ownedArgument2 = getOwnedArgument();
		if (ownedArgument2 != null) {
			ownedArgument2.setInterleaved();
		}
	}
} //BinaryExpressionCSImpl

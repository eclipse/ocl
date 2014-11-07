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
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2AS;
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
				return argument != null;
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
		ExpCS derivedArgument2 = getDerivedArgument();
		if (derivedArgument2 != argument) {
			derivedArgument = null;
			derivedArgument2 = getDerivedArgument();
		}
		assert (derivedArgument2 == argument) || (argument == null) || (derivedPrecedence == null);
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

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitInfixExpCS(this);
	}

/*	@Override
	protected @NonNull Precedence computeLeftPrecedence() {
		ExpCS csSource = getOwnedSource();
		if (csSource instanceof OperatorExpCS) {
			Precedence sourcePrecedence = ((OperatorExpCS)csSource).getDerivedPrecedence();
			Precedence leftPrecedence = ((OperatorExpCS)csSource).getDerivedLeftPrecedence();
			return PivotUtil.highestPrecedence(sourcePrecedence, leftPrecedence);
		}
		else {
			return PrecedenceManager.NULL_PRECEDENCE;
		}
	} */

/*	@Override
	protected @NonNull Precedence computeRightPrecedence() {
		ExpCS csArgument = getOwnedArgument();
		if (csArgument instanceof OperatorExpCS) {
			Precedence argumentPrecedence = ((OperatorExpCS)csArgument).getDerivedPrecedence();
			Precedence rightPrecedence = ((OperatorExpCS)csArgument).getDerivedRightPrecedence();
			return PivotUtil.highestPrecedence(argumentPrecedence, rightPrecedence);
		}
		else {
			return PrecedenceManager.NULL_PRECEDENCE;
		}
	} */

	public ExpCS getDerivedArgument() {
		if (derivedArgument == null) {
			ExpCS csBestRight = null;
			for (ExpCS csRight = this; (csRight = csRight.getDerivedRightExpCS()) != null; ) {
				ExpCS csThisWrtRight = EssentialOCLCS2AS.lowestPrecedence(this, csRight);
				if (csThisWrtRight != this) {
					break;
				}
				if (csBestRight == null) {
					csBestRight = csRight;
				}
				else {
					ExpCS csBestWrtRight = EssentialOCLCS2AS.lowestPrecedence(csBestRight, csRight);
					if (csBestWrtRight != csBestRight) {
						csBestRight = csRight;
					}
				}
			}
			derivedArgument = csBestRight;
		}
		return derivedArgument;
	}
	
	@Override
	public @NonNull Precedence getDerivedHighestPrecedence() {
		Precedence leftPrecedence = getOwnedSource().getDerivedHighestPrecedence();
		Precedence rightPrecedence = getOwnedArgument().getDerivedHighestPrecedence();
		Precedence highestPrecedence = PivotUtil.highestPrecedence(leftPrecedence, rightPrecedence);
		return PivotUtil.highestPrecedence(getDerivedPrecedence(), highestPrecedence);
	}

	@Override
	public @NonNull ExpCS getDerivedHighestPrecedenceExpCS() {
		ExpCS leftExpCS = getOwnedSource().getDerivedHighestPrecedenceExpCS();
		ExpCS rightExpCS = getOwnedArgument().getDerivedHighestPrecedenceExpCS();
		ExpCS leftHighestExpCS = getHighestPrecedenceExpCS(leftExpCS, this);
		ExpCS highestExpCS = getHighestPrecedenceExpCS(leftHighestExpCS, rightExpCS);
		return highestExpCS;
	}

	@Override
	public @Nullable ExpCS getDerivedLeftExpCS() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getDerivedRightmostExpCS() : null;
	}

	@Override
	public @NonNull ExpCS getDerivedLeftmostExpCS() {
		ExpCS ownedSource = getOwnedSource();
		return ownedSource != null ? ownedSource.getDerivedLeftmostExpCS() : this;
	}

	@Override
	public @Nullable ExpCS getDerivedRightExpCS() {
		ExpCS ownedArgument = getOwnedArgument();
		return ownedArgument != null ? ownedArgument.getDerivedLeftmostExpCS() : null;
	}

	@Override
	public @NonNull ExpCS getDerivedRightmostExpCS() {
		ExpCS ownedArgument = getOwnedArgument();
		return ownedArgument != null ? ownedArgument.getDerivedRightmostExpCS() : this;
	}

	public @NonNull ExpCS getHighestPrecedenceExpCS(@NonNull ExpCS leftExpCS, @NonNull ExpCS rightExpCS) {
		Precedence leftPrecedence = leftExpCS.getDerivedPrecedence();
		Precedence rightPrecedence = rightExpCS.getDerivedPrecedence();
		if (leftPrecedence == rightPrecedence) {
			if (getDerivedPrecedence().getAssociativity() == AssociativityKind.RIGHT) {
				return leftExpCS;
			}
			else if (rightExpCS instanceof InfixExpCS) {
				return rightExpCS;
//				ExpCS ownedSource2 = ((InfixExpCS)rightExpCS).getOwnedSource();
//				return ownedSource2 != null ? ownedSource2 : rightExpCS;
			}
			else {
				return rightExpCS;
			}
		}
		Precedence highestPrecedence = PivotUtil.highestPrecedence(leftPrecedence, rightPrecedence);
		if (highestPrecedence != rightPrecedence) {
			return leftExpCS;
		}
		else {
			return rightExpCS;
		}
	}

	@Override
	public void resetPivot() {
		super.resetPivot();
		setArgument(null);
		derivedArgument = null;
	}
} //BinaryExpressionCSImpl

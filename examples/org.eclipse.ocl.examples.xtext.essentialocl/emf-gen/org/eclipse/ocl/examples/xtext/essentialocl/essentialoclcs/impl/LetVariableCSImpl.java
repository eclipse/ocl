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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl#isHasError <em>Has Error</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl#getLetExpression <em>Let Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.LetVariableCSImpl#getRoundBracketedClause <em>Round Bracketed Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LetVariableCSImpl
		extends VariableCSImpl
		implements LetVariableCS {

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected OperatorCS parent;

	/**
	 * The default value of the '{@link #isHasError() <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasError()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_ERROR_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isHasError() <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasError()
	 * @generated
	 * @ordered
	 */
	protected boolean hasError = HAS_ERROR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoundBracketedClause() <em>Round Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundBracketedClause()
	 * @generated
	 * @ordered
	 */
	protected RoundBracketedClauseCS roundBracketedClause;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LetVariableCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.LET_VARIABLE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorCS getParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(OperatorCS newParent) {
		OperatorCS oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.LET_VARIABLE_CS__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasError()
	{
		return hasError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasError(boolean newHasError)
	{
		boolean oldHasError = hasError;
		hasError = newHasError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.LET_VARIABLE_CS__HAS_ERROR, oldHasError, hasError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpCS getLetExpression() {
		if (eContainerFeatureID() != EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION) return null;
		return (LetExpCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLetExpression(LetExpCS newLetExpression,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLetExpression, EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLetExpression(LetExpCS newLetExpression) {
		if (newLetExpression != eInternalContainer() || (eContainerFeatureID() != EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION && newLetExpression != null))
		{
			if (EcoreUtil.isAncestor(this, newLetExpression))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLetExpression != null)
				msgs = ((InternalEObject)newLetExpression).eInverseAdd(this, EssentialOCLCSPackage.LET_EXP_CS__VARIABLE, LetExpCS.class, msgs);
			msgs = basicSetLetExpression(newLetExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION, newLetExpression, newLetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundBracketedClauseCS getRoundBracketedClause()
	{
		return roundBracketedClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoundBracketedClause(RoundBracketedClauseCS newRoundBracketedClause, NotificationChain msgs)
	{
		RoundBracketedClauseCS oldRoundBracketedClause = roundBracketedClause;
		roundBracketedClause = newRoundBracketedClause;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE, oldRoundBracketedClause, newRoundBracketedClause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoundBracketedClause(RoundBracketedClauseCS newRoundBracketedClause)
	{
		if (newRoundBracketedClause != roundBracketedClause)
		{
			NotificationChain msgs = null;
			if (roundBracketedClause != null)
				msgs = ((InternalEObject)roundBracketedClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE, null, msgs);
			if (newRoundBracketedClause != null)
				msgs = ((InternalEObject)newRoundBracketedClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE, null, msgs);
			msgs = basicSetRoundBracketedClause(newRoundBracketedClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE, newRoundBracketedClause, newRoundBracketedClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLetExpression((LetExpCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return basicSetLetExpression(null, msgs);
			case EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE:
				return basicSetRoundBracketedClause(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return eInternalContainer().eInverseRemove(this, EssentialOCLCSPackage.LET_EXP_CS__VARIABLE, LetExpCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case EssentialOCLCSPackage.LET_VARIABLE_CS__PARENT:
				return getParent();
			case EssentialOCLCSPackage.LET_VARIABLE_CS__HAS_ERROR:
				return isHasError();
			case EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return getLetExpression();
			case EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE:
				return getRoundBracketedClause();
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
			case EssentialOCLCSPackage.LET_VARIABLE_CS__PARENT:
				setParent((OperatorCS)newValue);
				return;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__HAS_ERROR:
				setHasError((Boolean)newValue);
				return;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				setLetExpression((LetExpCS)newValue);
				return;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE:
				setRoundBracketedClause((RoundBracketedClauseCS)newValue);
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
			case EssentialOCLCSPackage.LET_VARIABLE_CS__PARENT:
				setParent((OperatorCS)null);
				return;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__HAS_ERROR:
				setHasError(HAS_ERROR_EDEFAULT);
				return;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				setLetExpression((LetExpCS)null);
				return;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE:
				setRoundBracketedClause((RoundBracketedClauseCS)null);
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
			case EssentialOCLCSPackage.LET_VARIABLE_CS__PARENT:
				return parent != null;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__HAS_ERROR:
				return hasError != HAS_ERROR_EDEFAULT;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__LET_EXPRESSION:
				return getLetExpression() != null;
			case EssentialOCLCSPackage.LET_VARIABLE_CS__ROUND_BRACKETED_CLAUSE:
				return roundBracketedClause != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExpCS.class)
		{
			switch (derivedFeatureID)
			{
				case EssentialOCLCSPackage.LET_VARIABLE_CS__PARENT: return EssentialOCLCSPackage.EXP_CS__PARENT;
				case EssentialOCLCSPackage.LET_VARIABLE_CS__HAS_ERROR: return EssentialOCLCSPackage.EXP_CS__HAS_ERROR;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ExpCS.class)
		{
			switch (baseFeatureID)
			{
				case EssentialOCLCSPackage.EXP_CS__PARENT: return EssentialOCLCSPackage.LET_VARIABLE_CS__PARENT;
				case EssentialOCLCSPackage.EXP_CS__HAS_ERROR: return EssentialOCLCSPackage.LET_VARIABLE_CS__HAS_ERROR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitLetVariableCS(this);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
} //VariableCSImpl

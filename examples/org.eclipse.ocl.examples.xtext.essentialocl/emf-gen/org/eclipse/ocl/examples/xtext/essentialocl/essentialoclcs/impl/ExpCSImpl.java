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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.manager.PrecedenceManager;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2AS;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCSPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpCSImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.impl.ExpCSImpl#isHasError <em>Has Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpCSImpl
		extends ModelElementCSImpl
		implements ExpCS {

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected OperatorExpCS parent;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.EXP_CS;
	}

	boolean derivedParentIsSet = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(OperatorExpCS newParent) {
		derivedParentIsSet = newParent != null;
		parent = newParent;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSPackage.EXP_CS__HAS_ERROR, oldHasError, hasError));
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
			case EssentialOCLCSPackage.EXP_CS__PARENT:
				return getParent();
			case EssentialOCLCSPackage.EXP_CS__HAS_ERROR:
				return isHasError();
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
			case EssentialOCLCSPackage.EXP_CS__PARENT:
				setParent((OperatorExpCS)newValue);
				return;
			case EssentialOCLCSPackage.EXP_CS__HAS_ERROR:
				setHasError((Boolean)newValue);
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
			case EssentialOCLCSPackage.EXP_CS__PARENT:
				setParent((OperatorExpCS)null);
				return;
			case EssentialOCLCSPackage.EXP_CS__HAS_ERROR:
				setHasError(HAS_ERROR_EDEFAULT);
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
			case EssentialOCLCSPackage.EXP_CS__PARENT:
				return parent != null;
			case EssentialOCLCSPackage.EXP_CS__HAS_ERROR:
				return hasError != HAS_ERROR_EDEFAULT;
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
		return (R) ((EssentialOCLCSVisitor<?>)visitor).visitExpCS(this);
	}

	/**
	 * The cached value of the '{@link #getDerivedParent() <em>Derived Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedParent()
	 * @generated
	 * @ordered
	 */
	protected OperatorExpCS derivedParent;

	public OperatorExpCS getParent() {
		OperatorExpCS expCS = getDerivedParent();
		assert !EssentialOCLCSPostOrderVisitor.doesInterleave || (expCS == parent);
		return expCS;
	}

	public OperatorExpCS getDerivedParent() {
		if (EssentialOCLCSPostOrderVisitor.interleaveInProgress) {
			assert !isInterleaved;
			return parent;
		}
		if (EssentialOCLCSPostOrderVisitor.doesInterleave && !derivedParentIsSet) {
			assert !isInterleaved || (parent == null);
			return null;
		}
		if (!EssentialOCLCSPostOrderVisitor.doesInterleave && !isInterleaved) {
			return null;
		}
		assert isInterleaved || !(eContainer() instanceof OperatorExpCS);
		if (derivedParent == null) {
			OperatorExpCS csNearestLeft = null;
			for (ExpCS csLeft = this; (csLeft = csLeft.getLocalLeft()) != null; ) {
				OperatorExpCS csLeftOperator = csLeft instanceof OperatorExpCS ? (OperatorExpCS)csLeft : null;
				if (csNearestLeft == null) {
					if ((csLeftOperator != null) && csLeftOperator.isLocalLeftAncestorOf(this)) {
						csNearestLeft = csLeftOperator;
					}
				}
				else {
					if ((csLeftOperator != null) && csNearestLeft.isLocalLeftAncestorOf(csLeft) && csLeftOperator.isLocalLeftAncestorOf(this)) {
						csNearestLeft = csLeftOperator;
					}
					else {
						break;
					}
				}
			}
			OperatorExpCS csNearestRight = null;
			for (ExpCS csRight = this; (csRight = csRight.getLocalRight()) != null; ) {
				OperatorExpCS csRightOperator = csRight instanceof OperatorExpCS ? (OperatorExpCS)csRight : null;
				if (csNearestRight == null) {
					if ((csRightOperator != null) && csRightOperator.isLocalRightAncestorOf(this)) {
						csNearestRight = csRightOperator;
					}
				}
				else {
					if ((csRightOperator != null) && csRightOperator.isLocalRightAncestorOf(this) && csNearestRight.isLocalRightAncestorOf(csRight)) {
						csNearestRight = csRightOperator;
					}
					else {
						break;
					}
				}
			}
			if (csNearestLeft == null) {
				if (csNearestRight == null) {
					derivedParent = null;
				}
				else {
					derivedParent = csNearestRight;
				}
			}
			else {
				if (csNearestRight == null) {
					derivedParent = csNearestLeft;
				}
				else if (csNearestLeft.isLocalLeftAncestorOf(csNearestRight)) {
					derivedParent = csNearestRight;
				}
				else {
					derivedParent = csNearestLeft;
				}
			}
		}
		return derivedParent;
	}
	
	public @NonNull Precedence getDerivedPrecedence() {
		return PrecedenceManager.LEAF_PRECEDENCE;
	}

	public @Nullable ExpCS getLocalLeft() {
		return EssentialOCLCS2AS.getDerivedLeftExpCS(this);
	}

	public @NonNull ExpCS getLocalLeftmostDescendant() {
		return this;
	}

	public @Nullable ExpCS getLocalRight() {
		return EssentialOCLCS2AS.getDerivedRightExpCS(this);
	}

	public @NonNull ExpCS getLocalRightmostDescendant() {
		return this;
	}
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ElementCS getLogicalParent() {
		ElementCS parent = getParent();
		return parent != null
			? parent
			: super.getLogicalParent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void resetPivot() {
		super.resetPivot();
		setParent(null);
		setHasError(false);
		derivedParentIsSet = false;
		isInterleaved = false;
	}

	protected boolean isInterleaved = false;
	
	public void setInterleaved() {
		isInterleaved = true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
} //ExpCSImpl

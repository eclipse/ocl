/*******************************************************************************
 * Copyright (c) 2010, 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.StateExpImpl#getReferredState <em>Referred State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateExpImpl
		extends OCLExpressionImpl
		implements StateExp {

	/**
	 * The cached value of the '{@link #getReferredState() <em>Referred State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredState()
	 * @generated
	 * @ordered
	 */
	protected State referredState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.STATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getReferredState() {
		if (referredState != null && ((EObject)referredState).eIsProxy())
		{
			InternalEObject oldReferredState = (InternalEObject)referredState;
			referredState = (State)eResolveProxy(oldReferredState);
			if (referredState != oldReferredState)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.STATE_EXP__REFERRED_STATE, oldReferredState, referredState));
			}
		}
		return referredState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetReferredState() {
		return referredState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredState(State newReferredState) {
		State oldReferredState = referredState;
		referredState = newReferredState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.STATE_EXP__REFERRED_STATE, oldReferredState, referredState));
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
			case PivotPackage.STATE_EXP__EXTENSION:
				return getExtension();
			case PivotPackage.STATE_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotation();
			case PivotPackage.STATE_EXP__OWNED_COMMENT:
				return getOwnedComment();
			case PivotPackage.STATE_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.STATE_EXP__NAME:
				return getName();
			case PivotPackage.STATE_EXP__IS_REQUIRED:
				return isRequired();
			case PivotPackage.STATE_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.STATE_EXP__REFERRED_STATE:
				if (resolve) return getReferredState();
				return basicGetReferredState();
		}
		return eDynamicGet(featureID, resolve, coreType);
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
			case PivotPackage.STATE_EXP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case PivotPackage.STATE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				getOwnedAnnotation().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.STATE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.STATE_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.STATE_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.STATE_EXP__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case PivotPackage.STATE_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.STATE_EXP__REFERRED_STATE:
				setReferredState((State)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
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
			case PivotPackage.STATE_EXP__EXTENSION:
				getExtension().clear();
				return;
			case PivotPackage.STATE_EXP__OWNED_ANNOTATION:
				getOwnedAnnotation().clear();
				return;
			case PivotPackage.STATE_EXP__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case PivotPackage.STATE_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.STATE_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.STATE_EXP__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case PivotPackage.STATE_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.STATE_EXP__REFERRED_STATE:
				setReferredState((State)null);
				return;
		}
		eDynamicUnset(featureID);
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
			case PivotPackage.STATE_EXP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case PivotPackage.STATE_EXP__OWNED_ANNOTATION:
				return ownedAnnotation != null && !ownedAnnotation.isEmpty();
			case PivotPackage.STATE_EXP__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case PivotPackage.STATE_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.STATE_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.STATE_EXP__IS_REQUIRED:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case PivotPackage.STATE_EXP__TYPE:
				return type != null;
			case PivotPackage.STATE_EXP__REFERRED_STATE:
				return referredState != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitStateExp(this);
	}
} //StateExpImpl
